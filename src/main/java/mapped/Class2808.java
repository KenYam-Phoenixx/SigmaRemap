package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.entity.Entity;

public abstract class Class2808<E extends Entity> extends Class2803<E> {
   private float field17477 = 1.0F;
   private float field17478 = 1.0F;
   private float field17479 = 1.0F;

   public void method11018(float var1, float var2, float var3) {
      this.field17477 = var1;
      this.field17478 = var2;
      this.field17479 = var3;
   }

   @Override
   public void render(MatrixStack var1, IVertexBuilder var2, int var3, int var4, float var5, float var6, float var7, float var8) {
      super.render(var1, var2, var3, var4, this.field17477 * var5, this.field17478 * var6, this.field17479 * var7, var8);
   }
}
