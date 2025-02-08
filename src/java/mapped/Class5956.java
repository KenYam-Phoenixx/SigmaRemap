package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

public class Class5956 extends Class5942<Class959> {
   public static final Class7826 field25968 = new Class7826(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("entity/conduit/base"));
   public static final Class7826 field25969 = new Class7826(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("entity/conduit/cage"));
   public static final Class7826 field25970 = new Class7826(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("entity/conduit/wind"));
   public static final Class7826 field25971 = new Class7826(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("entity/conduit/wind_vertical"));
   public static final Class7826 field25972 = new Class7826(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("entity/conduit/open_eye"));
   public static final Class7826 field25973 = new Class7826(AtlasTexture.LOCATION_BLOCKS_TEXTURE, new ResourceLocation("entity/conduit/closed_eye"));
   private final ModelRenderer field25974 = new ModelRenderer(16, 16, 0, 0);
   private final ModelRenderer field25975;
   private final ModelRenderer field25976;
   private final ModelRenderer field25977;

   public Class5956(TileEntityRendererDispatcher var1) {
      super(var1);
      this.field25974.addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 0.0F, 0.01F);
      this.field25975 = new ModelRenderer(64, 32, 0, 0);
      this.field25975.method22673(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F);
      this.field25976 = new ModelRenderer(32, 16, 0, 0);
      this.field25976.method22673(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F);
      this.field25977 = new ModelRenderer(32, 16, 0, 0);
      this.field25977.method22673(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F);
   }

   public void method18462(Class959 var1, float var2, MatrixStack var3, IRenderTypeBuffer var4, int var5, int var6) {
      float var9 = (float)var1.field5382 + var2;
      if (var1.method3903()) {
         float var10 = var1.method3907(var2) * (180.0F / (float)Math.PI);
         float var11 = MathHelper.sin(var9 * 0.1F) / 2.0F + 0.5F;
         var11 = var11 * var11 + var11;
         var3.push();
         var3.translate(0.5, (double)(0.3F + var11 * 0.2F), 0.5);
         Vector3f var12 = new Vector3f(0.5F, 1.0F, 0.5F);
         var12.normalize();
         var3.rotate(new Quaternion(var12, var10, true));
         this.field25977.render(var3, field25969.method26200(var4, RenderType::getEntityCutoutNoCull), var5, var6);
         var3.pop();
         int var13 = var1.field5382 / 66 % 3;
         var3.push();
         var3.translate(0.5, 0.5, 0.5);
         if (var13 != 1) {
            if (var13 == 2) {
               var3.rotate(Vector3f.ZP.rotationDegrees(90.0F));
            }
         } else {
            var3.rotate(Vector3f.XP.rotationDegrees(90.0F));
         }

         IVertexBuilder var14 = (var13 != 1 ? field25970 : field25971).method26200(var4, RenderType::getEntityCutoutNoCull);
         this.field25975.render(var3, var14, var5, var6);
         var3.pop();
         var3.push();
         var3.translate(0.5, 0.5, 0.5);
         var3.scale(0.875F, 0.875F, 0.875F);
         var3.rotate(Vector3f.XP.rotationDegrees(180.0F));
         var3.rotate(Vector3f.ZP.rotationDegrees(180.0F));
         this.field25975.render(var3, var14, var5, var6);
         var3.pop();
         ActiveRenderInfo var15 = this.field25928.field34748;
         var3.push();
         var3.translate(0.5, (double)(0.3F + var11 * 0.2F), 0.5);
         var3.scale(0.5F, 0.5F, 0.5F);
         float var16 = -var15.getYaw();
         var3.rotate(Vector3f.YP.rotationDegrees(var16));
         var3.rotate(Vector3f.XP.rotationDegrees(var15.getPitch()));
         var3.rotate(Vector3f.ZP.rotationDegrees(180.0F));
         float var17 = 1.3333334F;
         var3.scale(1.3333334F, 1.3333334F, 1.3333334F);
         this.field25974.render(var3, (!var1.method3904() ? field25973 : field25972).method26200(var4, RenderType::getEntityCutoutNoCull), var5, var6);
         var3.pop();
      } else {
         float var18 = var1.method3907(0.0F);
         IVertexBuilder var20 = field25968.method26200(var4, RenderType::getEntitySolid);
         var3.push();
         var3.translate(0.5, 0.5, 0.5);
         var3.rotate(Vector3f.YP.rotationDegrees(var18));
         this.field25976.render(var3, var20, var5, var6);
         var3.pop();
      }
   }
}
