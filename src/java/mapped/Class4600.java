package mapped;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.Fluid;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.SoundEvents;

public class Class4600 extends Class4599 {
   private static String[] field22094;

   public Class4600(ClientWorld var1, double var2, double var4, double var6, Fluid var8, IParticleData var9) {
      super(var1, var2, var4, var6, var8, var9);
   }

   @Override
   public void method14534() {
      if (this.field22048) {
         this.method14518();
         this.field22037.addParticle(this.field22093, this.field22041, this.field22042, this.field22043, 0.0, 0.0, 0.0);
         this.field22037
            .playSound(
               this.field22041 + 0.5,
               this.field22042,
               this.field22043 + 0.5,
               SoundEvents.field26395,
               SoundCategory.field14732,
               0.3F + this.field22037.rand.nextFloat() * 2.0F / 3.0F,
               1.0F,
               false
            );
      }
   }
}
