package mapped;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.Fluid;
import net.minecraft.particles.IParticleData;

public class Class4596 extends Class4595 {
   private static String[] field22089;

   public Class4596(ClientWorld var1, double var2, double var4, double var6, Fluid var8, IParticleData var9) {
      super(var1, var2, var4, var6, var8, var9);
   }

   @Override
   public void method14533() {
      this.field22058 = 1.0F;
      this.field22059 = 16.0F / (float)(40 - this.field22056 + 16);
      this.field22060 = 4.0F / (float)(40 - this.field22056 + 8);
      super.method14533();
   }
}
