package mapped;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.Fluid;

public class Class4598 extends Class4594 {
   private static String[] field22092;

   public Class4598(ClientWorld var1, double var2, double var4, double var6, Fluid var8) {
      super(var1, var2, var4, var6, var8);
      this.field22056 = (int)(64.0 / (Math.random() * 0.8 + 0.2));
   }

   @Override
   public void method14534() {
      if (this.field22048) {
         this.method14518();
      }
   }
}
