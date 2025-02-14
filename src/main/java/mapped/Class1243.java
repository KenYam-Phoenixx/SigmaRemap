package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class Class1243 extends Button {
   private static String[] field6595;
   private final ResourceLocation field6596;
   private final int field6597;
   private final int field6598;
   private final int field6599;
   private final int field6600;
   private final int field6601;

   public Class1243(int var1, int var2, int var3, int var4, int var5, int var6, int var7, ResourceLocation var8, IPressable var9) {
      this(var1, var2, var3, var4, var5, var6, var7, var8, 256, 256, var9);
   }

   public Class1243(int var1, int var2, int var3, int var4, int var5, int var6, int var7, ResourceLocation var8, int var9, int var10, IPressable var11) {
      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, StringTextComponent.EMPTY);
   }

   public Class1243(
           int var1, int var2, int var3, int var4, int var5, int var6, int var7, ResourceLocation var8, int var9, int var10, IPressable var11, ITextComponent var12
   ) {
      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, field_238486_s_, var12);
   }

   public Class1243(
      int var1,
      int var2,
      int var3,
      int var4,
      int var5,
      int var6,
      int var7,
      ResourceLocation var8,
      int var9,
      int var10,
      IPressable var11,
      ITooltip var12,
      ITextComponent var13
   ) {
      super(var1, var2, var3, var4, var13, var11, var12);
      this.field6600 = var9;
      this.field6601 = var10;
      this.field6597 = var5;
      this.field6598 = var6;
      this.field6599 = var7;
      this.field6596 = var8;
   }

   public void method5819(int var1, int var2) {
      this.x = var1;
      this.y = var2;
   }

   @Override
   public void renderButton(MatrixStack var1, int var2, int var3, float var4) {
      Minecraft var7 = Minecraft.getInstance();
      var7.getTextureManager().bindTexture(this.field6596);
      int var8 = this.field6598;
      if (this.isHovered()) {
         var8 += this.field6599;
      }

      RenderSystem.enableDepthTest();
      method5699(var1, this.x, this.y, (float)this.field6597, (float)var8, this.width, this.height, this.field6600, this.field6601);
      if (this.isHovered()) {
         this.renderToolTip(var1, var2, var3);
      }
   }
}
