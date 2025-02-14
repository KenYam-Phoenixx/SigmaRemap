package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

public class Class5723 extends EntityRenderer<EnderCrystalEntity> {
   private static final ResourceLocation field25122 = new ResourceLocation("textures/entity/end_crystal/end_crystal.png");
   private static final RenderType field25123 = RenderType.getEntityCutoutNoCull(field25122);
   private static final float field25124 = (float)Math.sin(Math.PI / 4);
   private final ModelRenderer field25125;
   private final ModelRenderer field25126;
   private final ModelRenderer field25127;

   public Class5723(EntityRendererManager var1) {
      super(var1);
      this.shadowSize = 0.5F;
      this.field25126 = new ModelRenderer(64, 32, 0, 0);
      this.field25126.method22673(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F);
      this.field25125 = new ModelRenderer(64, 32, 32, 0);
      this.field25125.method22673(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F);
      this.field25127 = new ModelRenderer(64, 32, 0, 16);
      this.field25127.method22673(-6.0F, 0.0F, -6.0F, 12.0F, 4.0F, 12.0F);
   }

   public void render(EnderCrystalEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
      matrixStackIn.push();
      float var9 = method17909(entityIn, partialTicks);
      float var10 = ((float) entityIn.field5523 + partialTicks) * 3.0F;
      IVertexBuilder var11 = bufferIn.getBuffer(field25123);
      matrixStackIn.push();
      matrixStackIn.scale(2.0F, 2.0F, 2.0F);
      matrixStackIn.translate(0.0, -0.5, 0.0);
      int var12 = OverlayTexture.NO_OVERLAY;
      if (entityIn.method4145()) {
         this.field25127.render(matrixStackIn, var11, packedLightIn, var12);
      }

      matrixStackIn.rotate(Vector3f.YP.rotationDegrees(var10));
      matrixStackIn.translate(0.0, (double)(1.5F + var9 / 2.0F), 0.0);
      matrixStackIn.rotate(new Quaternion(new Vector3f(field25124, 0.0F, field25124), 60.0F, true));
      this.field25126.render(matrixStackIn, var11, packedLightIn, var12);
      float var13 = 0.875F;
      matrixStackIn.scale(0.875F, 0.875F, 0.875F);
      matrixStackIn.rotate(new Quaternion(new Vector3f(field25124, 0.0F, field25124), 60.0F, true));
      matrixStackIn.rotate(Vector3f.YP.rotationDegrees(var10));
      this.field25126.render(matrixStackIn, var11, packedLightIn, var12);
      matrixStackIn.scale(0.875F, 0.875F, 0.875F);
      matrixStackIn.rotate(new Quaternion(new Vector3f(field25124, 0.0F, field25124), 60.0F, true));
      matrixStackIn.rotate(Vector3f.YP.rotationDegrees(var10));
      this.field25125.render(matrixStackIn, var11, packedLightIn, var12);
      matrixStackIn.pop();
      matrixStackIn.pop();
      BlockPos var14 = entityIn.method4143();
      if (var14 != null) {
         float var15 = (float)var14.getX() + 0.5F;
         float var16 = (float)var14.getY() + 0.5F;
         float var17 = (float)var14.getZ() + 0.5F;
         float var18 = (float)((double)var15 - entityIn.getPosX());
         float var19 = (float)((double)var16 - entityIn.getPosY());
         float var20 = (float)((double)var17 - entityIn.getPosZ());
         matrixStackIn.translate((double)var18, (double)var19, (double)var20);
         Class5718.method17906(-var18, -var19 + var9, -var20, partialTicks, entityIn.field5523, matrixStackIn, bufferIn, packedLightIn);
      }

      super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
   }

   public static float method17909(EnderCrystalEntity var0, float var1) {
      float var4 = (float)var0.field5523 + var1;
      float var5 = MathHelper.sin(var4 * 0.2F) / 2.0F + 0.5F;
      var5 = (var5 * var5 + var5) * 0.4F;
      return var5 - 1.4F;
   }

   public ResourceLocation method17843(EnderCrystalEntity var1) {
      return field25122;
   }

   public boolean method17854(EnderCrystalEntity var1, Class7647 var2, double var3, double var5, double var7) {
      return super.method17854(var1, var2, var3, var5, var7) || var1.method4143() != null;
   }
}
