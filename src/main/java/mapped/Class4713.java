package mapped;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Class4713 implements Class4698 {
   public static final Codec<Class4713> field22351 = RecordCodecBuilder.create(
      var0 -> var0.group(
               ConfiguredFeature.field33883.fieldOf("feature").forGetter(var0x -> var0x.field22352),
               Class7907.field33878.fieldOf("decorator").forGetter(var0x -> var0x.field22353)
            )
            .apply(var0, Class4713::new)
   );
   public final Supplier<ConfiguredFeature<?, ?>> field22352;
   public final Class7907<?> field22353;

   public Class4713(Supplier<ConfiguredFeature<?, ?>> var1, Class7907<?> var2) {
      this.field22352 = var1;
      this.field22353 = var2;
   }

   @Override
   public String toString() {
      return String.format(
         "< %s [%s | %s] >", this.getClass().getSimpleName(), Registry.FEATURE.getKey(this.field22352.get().method26518()), this.field22353
      );
   }

   @Override
   public Stream<ConfiguredFeature<?, ?>> method14736() {
      return this.field22352.get().method26522();
   }
}
