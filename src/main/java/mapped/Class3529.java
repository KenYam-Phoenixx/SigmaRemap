package mapped;

import net.minecraft.client.world.ClientWorld;

public class Class3529 implements Class3499<Class7435> {
   private static String[] field19430;
   private final Class8975 field19431;

   public Class3529(Class8975 var1) {
      this.field19431 = var1;
   }

   public Class4587 method12199(Class7435 var1, ClientWorld var2, double var3, double var5, double var7, double var9, double var11, double var13) {
      Class4608 var17 = new Class4608(var2, var3, var5, var7, var9, var11, var13, true);
      var17.method14515(0.95F);
      var17.method14507(this.field19431);
      return var17;
   }
}
