package mapped;

import com.google.common.collect.ImmutableMap;
import net.minecraft.util.RangedInteger;
import net.minecraft.world.server.ServerWorld;

import java.util.function.Predicate;

public class Class3744<E extends MobEntity, T> extends Class3676<E> {
   private static String[] field19879;
   private final Predicate<E> field19880;
   private final MemoryModuleType<? extends T> field19881;
   private final MemoryModuleType<T> field19882;
   private final RangedInteger field19883;

   public Class3744(Predicate<E> var1, MemoryModuleType<? extends T> var2, MemoryModuleType<T> var3, RangedInteger var4) {
      super(ImmutableMap.of(var2, Class2217.field14484, var3, Class2217.field14485));
      this.field19880 = var1;
      this.field19881 = var2;
      this.field19882 = var3;
      this.field19883 = var4;
   }

   public boolean method12508(ServerWorld var1, E var2) {
      return this.field19880.test((E)var2);
   }

   public void method12502(ServerWorld var1, E var2, long var3) {
      Brain var7 = var2.getBrain();
      var7.method21407(this.field19882, (T)var7.getMemory(this.field19881).get(), (long)this.field19883.method29319(var1.rand));
   }
}
