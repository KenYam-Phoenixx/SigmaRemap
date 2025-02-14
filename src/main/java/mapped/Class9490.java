package mapped;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.MapLike;
import com.mojang.serialization.RecordBuilder;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

import net.minecraft.util.Util;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import org.apache.commons.lang3.mutable.MutableObject;

public final class Class9490<E extends LivingEntity> extends MapCodec<Brain<E>> {
   public final Collection<MemoryModuleType> field44113;
   public final Collection field44114;
   public final MutableObject field44115;

   public Class9490(Collection var1, Collection var2, MutableObject var3) {
      this.field44113 = var1;
      this.field44114 = var2;
      this.field44115 = var3;
   }

   public <T> Stream<T> keys(DynamicOps<T> var1) {
      return this.field44113
         .stream()
         .<ResourceLocation>flatMap(var0 -> Util.streamOptional(var0.method31926().map(var1x -> Registry.field16092.getKey((MemoryModuleType<?>)var0))))
         .<T>map(var1x -> (T)var1.createString(var1x.toString()));
   }

   public <T> DataResult<Brain<E>> decode(DynamicOps<T> dynamicOps, MapLike<T> mapLike) {
      MutableObject<DataResult<ImmutableList.Builder<Class9802<?>>>> mutableObject = new MutableObject<>(DataResult.success(ImmutableList.builder()));
      mapLike.entries().forEach(pair -> {
         DataResult<MemoryModuleType<?>> dataResult = Registry.field16092.parse(dynamicOps, pair.getFirst());
         DataResult<? extends Class9802<?>> dataResult2 = dataResult.flatMap(class8830 -> this.method36654(class8830, dynamicOps, pair.getSecond()));
         mutableObject.setValue(mutableObject.getValue().apply2(ImmutableList.Builder::add, dataResult2));
      });

      ImmutableList<Class9802<?>> immutableList = mutableObject.getValue().resultOrPartial(arg_0 -> Brain.method21445().error(arg_0)).map(ImmutableList.Builder::build).orElseGet(ImmutableList::of);
      return DataResult.success(new Brain(this.field44113, this.field44114, immutableList, this.field44115::getValue));
   }

   private <T, U> DataResult<Class9802<U>> method36654(MemoryModuleType<U> memoryModuleType, DynamicOps<T> dynamicOps, T t) {
      return memoryModuleType.method31926().map(DataResult::success).orElseGet(() -> DataResult.error((String)("No codec for memory: " + memoryModuleType))).flatMap(codec -> codec.parse(dynamicOps, t)).map(class8222 -> new Class9802(memoryModuleType, Optional.of(class8222), null));
   }

   public <T> RecordBuilder<T> encode(Brain<E> class6947, DynamicOps<T> dynamicOps, RecordBuilder<T> recordBuilder) {
      Brain.method21446(class6947).forEach(class9802 -> class9802.method38647(dynamicOps, recordBuilder));
      return recordBuilder;
   }
}
