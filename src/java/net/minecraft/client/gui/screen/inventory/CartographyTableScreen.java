package net.minecraft.client.gui.screen.inventory;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import mapped.*;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.storage.MapData;

public class CartographyTableScreen extends ContainerScreen<Class5836> {
   private static final ResourceLocation field4753 = new ResourceLocation("textures/gui/container/cartography_table.png");

   public CartographyTableScreen(Class5836 var1, PlayerInventory var2, ITextComponent var3) {
      super(var1, var2, var3);
      this.field4724 -= 2;
   }

   @Override
   public void render(MatrixStack var1, int var2, int var3, float var4) {
      super.render(var1, var2, var3, var4);
      this.renderHoveredTooltip(var1, var2, var3);
   }

   @Override
   public void drawGuiContainerBackgroundLayer(MatrixStack var1, float var2, int var3, int var4) {
      this.renderBackground(var1);
      RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.mc.getTextureManager().bindTexture(field4753);
      int var7 = this.field4734;
      int var8 = this.field4735;
      this.blit(var1, var7, var8, 0, 0, this.xSize, this.ySize);
      Item var9 = this.field4727.getSlot(1).getStack().getItem();
      boolean var10 = var9 == Items.field38056;
      boolean var11 = var9 == Items.field37899;
      boolean var12 = var9 == Items.field37471;
      ItemStack var13 = this.field4727.getSlot(0).getStack();
      boolean var14 = false;
      MapData var15;
      if (var13.getItem() != Items.field37955) {
         var15 = null;
      } else {
         var15 = Class3316.method11860(var13, this.mc.world);
         if (var15 != null) {
            if (var15.locked) {
               var14 = true;
               if (var11 || var12) {
                  this.blit(var1, var7 + 35, var8 + 31, this.xSize + 50, 132, 28, 21);
               }
            }

            if (var11 && var15.scale >= 4) {
               var14 = true;
               this.blit(var1, var7 + 35, var8 + 31, this.xSize + 50, 132, 28, 21);
            }
         }
      }

      this.method2629(var1, var15, var10, var11, var12, var14);
   }

   private void method2629(MatrixStack var1, MapData var2, boolean var3, boolean var4, boolean var5, boolean var6) {
      int var9 = this.field4734;
      int var10 = this.field4735;
      if (var4 && !var6) {
         this.blit(var1, var9 + 67, var10 + 13, this.xSize, 66, 66, 66);
         this.method2630(var2, var9 + 85, var10 + 31, 0.226F);
      } else if (!var3) {
         if (!var5) {
            this.blit(var1, var9 + 67, var10 + 13, this.xSize, 0, 66, 66);
            this.method2630(var2, var9 + 71, var10 + 17, 0.45F);
         } else {
            this.blit(var1, var9 + 67, var10 + 13, this.xSize, 0, 66, 66);
            this.method2630(var2, var9 + 71, var10 + 17, 0.45F);
            this.mc.getTextureManager().bindTexture(field4753);
            RenderSystem.pushMatrix();
            RenderSystem.translatef(0.0F, 0.0F, 1.0F);
            this.blit(var1, var9 + 66, var10 + 12, 0, this.ySize, 66, 66);
            RenderSystem.popMatrix();
         }
      } else {
         this.blit(var1, var9 + 67 + 16, var10 + 13, this.xSize, 132, 50, 66);
         this.method2630(var2, var9 + 86, var10 + 16, 0.34F);
         this.mc.getTextureManager().bindTexture(field4753);
         RenderSystem.pushMatrix();
         RenderSystem.translatef(0.0F, 0.0F, 1.0F);
         this.blit(var1, var9 + 67, var10 + 13 + 16, this.xSize, 132, 50, 66);
         this.method2630(var2, var9 + 70, var10 + 32, 0.34F);
         RenderSystem.popMatrix();
      }
   }

   private void method2630(MapData var1, int var2, int var3, float var4) {
      if (var1 != null) {
         RenderSystem.pushMatrix();
         RenderSystem.translatef((float)var2, (float)var3, 1.0F);
         RenderSystem.scalef(var4, var4, 1.0F);
         IRenderTypeBuffer.Impl var7 = IRenderTypeBuffer.getImpl(Tessellator.getInstance().getBuffer());
         this.mc.gameRenderer.method756().method593(new MatrixStack(), var7, var1, true, 15728880);
         var7.finish();
         RenderSystem.popMatrix();
      }
   }
}
