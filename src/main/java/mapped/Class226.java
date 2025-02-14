package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.optifine.Config;
import net.optifine.shaders.Shaders;

public abstract class Class226<T extends Entity, M extends Class2827<T>> extends LayerRenderer<T, M> {
   public Class226(Class5714<T, M> var1) {
      super(var1);
   }

   @Override
   public void render(MatrixStack var1, IRenderTypeBuffer var2, int var3, T var4, float var5, float var6, float var7, float var8, float var9, float var10) {
      IVertexBuilder var13 = var2.getBuffer(this.method834());
      if (Config.isShaders()) {
         Shaders.method33081();
      }

      Config.method26874().field1020 = true;
      this.method825().render(var1, var13, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
      Config.method26874().field1020 = false;
      if (Config.isShaders()) {
         Shaders.method33082();
      }
   }

   public abstract RenderType method834();
}
