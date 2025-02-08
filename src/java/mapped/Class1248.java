package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.AbstractButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;

public class Class1248 extends AbstractButton {
   private static final ResourceLocation field6611 = new ResourceLocation("textures/gui/checkbox.png");
   private boolean field6612;
   private final boolean field6613;

   public Class1248(int var1, int var2, int var3, int var4, ITextComponent var5, boolean var6) {
      this(var1, var2, var3, var4, var5, var6, true);
   }

   public Class1248(int var1, int var2, int var3, int var4, ITextComponent var5, boolean var6, boolean var7) {
      super(var1, var2, var3, var4, var5);
      this.field6612 = var6;
      this.field6613 = var7;
   }

   @Override
   public void onPress() {
      this.field6612 = !this.field6612;
   }

   public boolean method5820() {
      return this.field6612;
   }

   @Override
   public void renderButton(MatrixStack var1, int var2, int var3, float var4) {
      Minecraft var7 = Minecraft.getInstance();
      var7.getTextureManager().bindTexture(field6611);
      RenderSystem.enableDepthTest();
      FontRenderer var8 = var7.fontRenderer;
      RenderSystem.color4f(1.0F, 1.0F, 1.0F, this.alpha);
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
      method5699(var1, this.x, this.y, !this.method5746() ? 0.0F : 20.0F, !this.field6612 ? 0.0F : 20.0F, 20, this.height, 64, 64);
      this.method5731(var1, var7, var2, var3);
      if (this.field6613) {
         drawString(
            var1,
            var8,
            this.method5745(),
            this.x + 24,
            this.y + (this.height - 8) / 2,
            14737632 | MathHelper.ceil(this.alpha * 255.0F) << 24
         );
      }
   }
}
