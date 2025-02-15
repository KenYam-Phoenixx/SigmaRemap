package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

import java.util.Random;

public class Class5724 extends EntityRenderer<ItemEntity> {
   private static String[] field25128;
   private final ItemRenderer field25129;
   private final Random field25130 = new Random();

   public Class5724(EntityRendererManager var1, ItemRenderer var2) {
      super(var1);
      this.field25129 = var2;
      this.shadowSize = 0.15F;
      this.shadowOpaque = 0.75F;
   }

   private int method17910(ItemStack var1) {
      byte var4 = 1;
      if (var1.getCount() <= 48) {
         if (var1.getCount() <= 32) {
            if (var1.getCount() <= 16) {
               if (var1.getCount() > 1) {
                  var4 = 2;
               }
            } else {
               var4 = 3;
            }
         } else {
            var4 = 4;
         }
      } else {
         var4 = 5;
      }

      return var4;
   }

   public void render(ItemEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
      matrixStackIn.push();
      ItemStack var9 = entityIn.method4124();
      int var10 = !var9.isEmpty() ? Item.getIdFromItem(var9.getItem()) + var9.method32117() : 187;
      this.field25130.setSeed((long)var10);
      IBakedModel var11 = this.field25129.getItemModelWithOverrides(var9, entityIn.world, (LivingEntity)null);
      boolean var12 = var11.method22621();
      int var13 = this.method17910(var9);
      float var14 = 0.25F;
      float var15 = MathHelper.sin(((float) entityIn.method4130() + partialTicks) / 10.0F + entityIn.field5520) * 0.1F + 0.1F;
      if (!this.method17912()) {
         var15 = 0.0F;
      }

      float var16 = var11.method22625().getTransform(ItemCameraTransformsTransformType.GROUND).field29591.method25270();
      matrixStackIn.translate(0.0, (double)(var15 + 0.25F * var16), 0.0);
      float var17 = entityIn.method4138(partialTicks);
      matrixStackIn.rotate(Vector3f.YP.method25285(var17));
      float var18 = var11.method22625().ground.field29591.method25269();
      float var19 = var11.method22625().ground.field29591.method25270();
      float var20 = var11.method22625().ground.field29591.method25271();
      if (!var12) {
         float var21 = -0.0F * (float)(var13 - 1) * 0.5F * var18;
         float var22 = -0.0F * (float)(var13 - 1) * 0.5F * var19;
         float var23 = -0.09375F * (float)(var13 - 1) * 0.5F * var20;
         matrixStackIn.translate((double)var21, (double)var22, (double)var23);
      }

      for (int var25 = 0; var25 < var13; var25++) {
         matrixStackIn.push();
         if (var25 > 0) {
            if (!var12) {
               float var26 = (this.field25130.nextFloat() * 2.0F - 1.0F) * 0.15F * 0.5F;
               float var28 = (this.field25130.nextFloat() * 2.0F - 1.0F) * 0.15F * 0.5F;
               matrixStackIn.translate((double)var26, (double)var28, 0.0);
            } else {
               float var27 = (this.field25130.nextFloat() * 2.0F - 1.0F) * 0.15F;
               float var29 = (this.field25130.nextFloat() * 2.0F - 1.0F) * 0.15F;
               float var24 = (this.field25130.nextFloat() * 2.0F - 1.0F) * 0.15F;
               if (!this.method17911()) {
                  var27 = 0.0F;
                  var29 = 0.0F;
               }

               matrixStackIn.translate((double)var27, (double)var29, (double)var24);
            }
         }

         this.field25129.renderItem(var9, ItemCameraTransformsTransformType.GROUND, false, matrixStackIn, bufferIn, packedLightIn, OverlayTexture.NO_OVERLAY, var11);
         matrixStackIn.pop();
         if (!var12) {
            matrixStackIn.translate((double)(0.0F * var18), (double)(0.0F * var19), (double)(0.09375F * var20));
         }
      }

      matrixStackIn.pop();
      super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
   }

   public ResourceLocation method17843(ItemEntity var1) {
      return AtlasTexture.LOCATION_BLOCKS_TEXTURE;
   }

   public boolean method17911() {
      return true;
   }

   public boolean method17912() {
      return true;
   }
}
