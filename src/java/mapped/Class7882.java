package mapped;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.Set;

public abstract class Class7882<E extends LivingEntity> {
   private static final Random field33825 = new Random();
   private static final EntityPredicate field33826 = new EntityPredicate().method30203(16.0).method30205().method30207();
   private static final EntityPredicate field33827 = new EntityPredicate().method30203(16.0).method30205().method30207().method30208();
   private final int field33828;
   private long field33829;

   public Class7882(int var1) {
      this.field33828 = var1;
      this.field33829 = (long)field33825.nextInt(var1);
   }

   public Class7882() {
      this(20);
   }

   public final void method26429(ServerWorld var1, E var2) {
      if (--this.field33829 <= 0L) {
         this.field33829 = (long)this.field33828;
         this.method26425(var1, (E)var2);
      }
   }

   public abstract void method26425(ServerWorld var1, E var2);

   public abstract Set<MemoryModuleType<?>> method26424();

   public static boolean method26430(LivingEntity var0, LivingEntity var1) {
      return !var0.getBrain().method21411(MemoryModuleType.ATTACK_TARGET, var1) ? field33826.canTarget(var0, var1) : field33827.canTarget(var0, var1);
   }
}
