package mapped;

import com.mentalfrostbyte.jello.unmapped.Class4305;
import com.mentalfrostbyte.jello.unmapped.ResourcesDecrypter;

public class Class4249 extends Class4247 {
   private static String[] field20606;
   public Class189 field20607;

   public Class4249(Class4305 var1, String var2, int var3, int var4, int var5, int var6, Class189 var7) {
      super(var1, var2, var3, var4, var5, var6, false);
      this.field20607 = var7;
      this.method13251((var1x, var2x) -> {
         this.field20607 = this.field20607.method577();
         this.method13037();
      });
   }

   public Class189 method13038() {
      return this.field20607;
   }

   @Override
   public void method13027(float var1) {
      Class3192.method11419((float)this.field20895, (float)this.field20896, (float)this.field20897, (float)this.field20898);
      Class3192.method11449(
         (float)(this.field20895 - this.field20607.field719 * this.field20897),
         (float)this.field20896,
         (float)(this.field20897 * 3),
         (float)this.field20898,
         ResourcesDecrypter.repeatPNG,
         Class5628.method17688(ClientColors.LIGHT_GREYISH_BLUE.getColor, 0.35F)
      );
      Class3192.method11422();
      super.method13027(var1);
   }
}
