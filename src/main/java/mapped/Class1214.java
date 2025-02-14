package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.math.MathHelper;

public class Class1214 extends Class1213 {
   private static String[] field6525;
   private float field6527;
   public boolean field6528;
   private Class6679 field6526 = null;

   public Class1214(int var1, int var2, int var3, int var4, int var5, Class6679 var6, String var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
      this.field6527 = 1.0F;
      this.field6526 = var6;
      this.field6527 = var6.method20389();
      this.method5766(Class848.method2592(var6, this.width));
   }

   @Override
   public int method5729(boolean var1) {
      return 0;
   }

   @Override
   public void method5731(MatrixStack var1, Minecraft var2, int var3, int var4) {
      if (this.visible) {
         if (this.field6528 && !Screen.method2476()) {
            this.field6527 = (float)(var3 - (this.x + 4)) / (float)(this.width - 8);
            this.field6527 = MathHelper.clamp(this.field6527, 0.0F, 1.0F);
            this.field6526.method20390(this.field6527);
            this.field6527 = this.field6526.method20389();
            this.method5766(Class848.method2592(this.field6526, this.width));
         }

         var2.getTextureManager().bindTexture(WIDGETS_LOCATION);
         GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
         int var7 = (!this.isHovered() ? 1 : 2) * 20;
         this.blit(var1, this.x + (int)(this.field6527 * (float)(this.width - 8)), this.y, 0, 46 + var7, 4, 20);
         this.blit(var1, this.x + (int)(this.field6527 * (float)(this.width - 8)) + 4, this.y, 196, 46 + var7, 4, 20);
      }
   }

   @Override
   public boolean mouseClicked(double var1, double var3, int var5) {
      if (!super.mouseClicked(var1, var3, var5)) {
         return false;
      } else {
         this.field6527 = (float)(var1 - (double)(this.x + 4)) / (float)(this.width - 8);
         this.field6527 = MathHelper.clamp(this.field6527, 0.0F, 1.0F);
         this.field6526.method20390(this.field6527);
         this.method5766(Class848.method2592(this.field6526, this.width));
         this.field6528 = true;
         return true;
      }
   }

   @Override
   public boolean mouseReleased(double var1, double var3, int var5) {
      this.field6528 = false;
      return true;
   }

   @Override
   public void method5770() {
      this.field6527 = this.field6526.method20389();
   }

   @Override
   public boolean method5771() {
      return false;
   }
}
