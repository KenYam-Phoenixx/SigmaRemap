package mapped;

import com.mentalfrostbyte.jello.Client;
import com.mentalfrostbyte.jello.resource.ResourceRegistry;
import com.mentalfrostbyte.jello.unmapped.Class4305;

public class Class4269 extends Class4247 {
   public Class4281 field20694;

   public Class4269(Class4305 var1, String var2, int var3, int var4, int var5, int var6) {
      super(var1, var2, var3, var4, var5, var6, Class6387.field27961, "", false);
      this.field20913 = ResourceRegistry.JelloLightFont20;
      this.method13230(this.field20694 = new Class4281(this, "chat", 14, 0, var5 - 28, var6, Class4281.field20741, "", "Chat..."));
      this.field20694.method13156(false);
      this.field20694.method13306(ResourceRegistry.JelloLightFont20);
      this.field20694.method13145(true);
   }

   @Override
   public void method13028(int var1, int var2) {
      super.method13028(var1, var2);
   }

   @Override
   public void method13027(float var1) {
      super.method13225();
      Class3192.method11467(this.field20895, this.field20896, this.field20897, this.field20898, Class5628.method17688(ClientColors.LIGHT_GREYISH_BLUE.getColor, var1));
      super.method13027(var1);
   }

   @Override
   public void method13065(int var1) {
      super.method13065(var1);
      if (var1 == 257) {
         ((Class4312)this.method13258()).method13359(this.field20694.method13303());
         Client.getInstance().getNetworkManager().field38429.method29515("SF4FSERFERF", this.field20694.method13303());
         this.field20694.method13304("");
         this.field20694.method13145(true);
      }
   }
}
