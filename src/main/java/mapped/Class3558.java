package mapped;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.Fluids;

public class Class3558 implements Class3499<Class7435> {
   private static String[] field19485;
   public final Class8975 field19486;

   public Class3558(Class8975 var1) {
      this.field19486 = var1;
   }

   public Class4587 method12199(Class7435 var1, ClientWorld var2, double var3, double var5, double var7, double var9, double var11, double var13) {
      Class4599 var17 = new Class4599(var2, var3, var5, var7, Fluids.EMPTY, ParticleTypes.field34117);
      var17.field22088 = true;
      var17.field22057 = 0.01F;
      var17.method14514(0.51171875F, 0.03125F, 0.890625F);
      var17.method14507(this.field19486);
      return var17;
   }
}
