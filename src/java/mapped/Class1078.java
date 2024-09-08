package mapped;

import net.minecraft.entity.EntityType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class Class1078 extends Class1066 {
   private static String[] field5922;

   public Class1078(EntityType<? extends Class1078> var1, World var2) {
      super(var1, var2);
   }

   @Override
   public SoundEvent getAmbientSound() {
      super.getAmbientSound();
      return SoundEvents.field26770;
   }

   @Override
   public SoundEvent method4893() {
      super.method4893();
      return SoundEvents.field26771;
   }

   @Override
   public SoundEvent getDeathSound() {
      super.getDeathSound();
      return SoundEvents.field26773;
   }

   @Nullable
   @Override
   public SoundEvent method4894() {
      return SoundEvents.field26774;
   }

   @Override
   public SoundEvent getHurtSound(DamageSource var1) {
      super.getHurtSound(var1);
      return SoundEvents.field26775;
   }

   @Override
   public void method4895() {
      this.method2863(SoundEvents.field26772, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
   }

   @Override
   public Class1045 method4389(ServerWorld var1, Class1045 var2) {
      return EntityType.field41057.method33215(var1);
   }
}
