package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public abstract class Class223<T extends Entity & Class1080, M extends Class2827<T>> extends LayerRenderer<T, M> {
   public Class223(Class5714<T, M> var1) {
      super(var1);
   }

   @Override
   public void render(MatrixStack var1, IRenderTypeBuffer var2, int var3, T var4, float var5, float var6, float var7, float var8, float var9, float var10) {
      if (((Class1080)var4).method5016()) {
         float var13 = (float)var4.ticksExisted + var7;
         Class2827 var14 = this.method833();
         var14.setLivingAnimations(var4, var5, var6, var7);
         this.method825().copyModelAttributesTo(var14);
         IVertexBuilder var15 = var2.getBuffer(RenderType.method14326(this.method832(), this.method831(var13), var13 * 0.01F));
         var14.setRotationAngles(var4, var5, var6, var8, var9, var10);
         var14.render(var1, var15, var3, OverlayTexture.NO_OVERLAY, 0.5F, 0.5F, 0.5F, 1.0F);
      }
   }

   public abstract float method831(float var1);

   public abstract ResourceLocation method832();

   public abstract Class2827<T> method833();
}
