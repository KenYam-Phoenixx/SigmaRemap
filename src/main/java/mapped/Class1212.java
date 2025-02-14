package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.optifine.Config;

public class Class1212 extends Class1210 {
   public Class1212(int var1, int var2, int var3) {
      super(var1, var2, var3, 22, 20, "");
   }

   @Override
   public void render(MatrixStack var1, int var2, int var3, float var4) {
      if (this.visible) {
         super.render(var1, var2, var3, var4);
         ResourceLocation var7 = new ResourceLocation("optifine/textures/icons.png");
         Config.method26861().bindTexture(var7);
         GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.blit(var1, this.x + 3, this.y + 2, 0, 0, 16, 16);
      }
   }
}
