package mapped;

import java.awt.Color;

import com.mentalfrostbyte.jello.unmapped.ResourcesDecrypter;
import org.lwjgl.opengl.GL11;

public class Class5968 {
   private static String[] field26019;
   public final float field26020 = (float)(0.1F + Math.random() * 0.9F);
   public final float field26021 = (float)(0.5 + Math.random() * 0.5);
   public final int field26022 = (int)((double)Class5263.method16466().mainWindow.method8043() * Math.random());
   public final int field26023 = (int)((double)Class5263.method16467().mainWindow.method8044() * Math.random());
   public float field26024;

   public void method18497(float var1) {
      this.field26024 = this.field26024 + 0.02F * var1 * this.field26020;
   }

   public void method18498() {
      float var3 = 0.3F + this.field26024 * 0.7F;
      float var4 = 1.0F;
      if (!(this.field26024 < 0.1F)) {
         if (this.field26024 > 0.75F) {
            var4 = 1.0F - (this.field26024 - 0.75F) / 0.25F;
         }
      } else {
         var4 = this.field26024 / 0.1F;
      }

      GL11.glPushMatrix();
      GL11.glTranslatef((float)(Class5263.method16468().mainWindow.method8043() / 2), (float)(Class5263.method16469().mainWindow.method8044() / 2), 0.0F);
      GL11.glScalef(var3, var3, 1.0F);
      GL11.glTranslatef((float)(-Class5263.method16470().mainWindow.method8043() / 2), (float)(-Class5263.method16471().mainWindow.method8044() / 2), 0.0F);
      int var5 = Color.getHSBColor((float)(System.currentTimeMillis() % 4000L) / 4000.0F, 0.3F, 1.0F).getRGB();
      float var6 = 60.0F * this.field26021;
      RenderUtil.method11449(
         (float)this.field26022 - var6 / 2.0F, (float)this.field26023 - var6 / 2.0F, var6, var6, ResourcesDecrypter.particlePNG, Class5628.method17688(var5, var4 * 0.9F)
      );
      GL11.glPopMatrix();
   }

   public boolean method18499() {
      return this.field26024 >= 1.0F;
   }
}
