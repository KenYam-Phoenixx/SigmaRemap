package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.util.ResourceLocation;

public class Class5667 extends Class5666 {
   private static final ResourceLocation field25031 = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");

   public Class5667(EntityRendererManager var1) {
      super(var1);
   }

   @Override
   public ResourceLocation method17843(Class1082 var1) {
      return field25031;
   }

   public void method17857(Class1082 var1, MatrixStack var2, float var3) {
      var2.scale(1.2F, 1.2F, 1.2F);
   }
}
