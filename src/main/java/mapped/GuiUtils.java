package mapped;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.widget.OptionSlider;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class GuiUtils {
   private static String[] field32352;

   public static int method24650(Widget var0) {
      return OptionSlider.method5814(var0);
   }

   public static int method24651(Widget var0) {
      return OptionSlider.method5815(var0);
   }

   public static void fill(Matrix4f var0, GuiRect[] var1, int var2) {
      float var5 = (float)(var2 >> 24 & 0xFF) / 255.0F;
      float var6 = (float)(var2 >> 16 & 0xFF) / 255.0F;
      float var7 = (float)(var2 >> 8 & 0xFF) / 255.0F;
      float var8 = (float)(var2 & 0xFF) / 255.0F;
      BufferBuilder var9 = Tessellator.getInstance().getBuffer();
      RenderSystem.enableBlend();
      RenderSystem.disableTexture();
      RenderSystem.defaultBlendFunc();
      var9.begin(7, DefaultVertexFormats.POSITION_COLOR);

      for (int var10 = 0; var10 < var1.length; var10++) {
         GuiRect var11 = var1[var10];
         if (var11 != null) {
            int var12 = var11.method25502();
            int var13 = var11.method25503();
            int var14 = var11.method25504();
            int var15 = var11.method25505();
            if (var12 < var14) {
               int var16 = var12;
               var12 = var14;
               var14 = var16;
            }

            if (var13 < var15) {
               int var17 = var13;
               var13 = var15;
               var15 = var17;
            }

            var9.pos(var0, (float)var12, (float)var15, 0.0F).color(var6, var7, var8, var5).endVertex();
            var9.pos(var0, (float)var14, (float)var15, 0.0F).color(var6, var7, var8, var5).endVertex();
            var9.pos(var0, (float)var14, (float)var13, 0.0F).color(var6, var7, var8, var5).endVertex();
            var9.pos(var0, (float)var12, (float)var13, 0.0F).color(var6, var7, var8, var5).endVertex();
         }
      }

      var9.finishDrawing();
      WorldVertexBufferUploader.draw(var9);
      RenderSystem.enableTexture();
      RenderSystem.disableBlend();
   }
}
