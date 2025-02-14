package mapped;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class Class2804<T extends Entity> extends Class2803<T> {
   private static String[] field17456;
   private final ModelRenderer field17457 = new ModelRenderer(this, 0, 0);
   private final ModelRenderer field17458;
   private final ModelRenderer field17459;

   public Class2804() {
      this.field17457.setRotationPoint(-5.0F, 22.0F, -5.0F);
      this.field17457.method22673(0.0F, 0.0F, 0.0F, 10.0F, 12.0F, 10.0F);
      this.field17458 = new ModelRenderer(this, 40, 0);
      this.field17458.setRotationPoint(1.5F, 22.0F, -4.0F);
      this.field17458.method22673(0.0F, 0.0F, 0.0F, 4.0F, 14.0F, 8.0F);
      this.field17459 = new ModelRenderer(this, 40, 0);
      this.field17459.setRotationPoint(-1.5F, 22.0F, 4.0F);
      this.field17459.method22673(0.0F, 0.0F, 0.0F, 4.0F, 14.0F, 8.0F);
   }

   @Override
   public void setRotationAngles(T var1, float var2, float var3, float var4, float var5, float var6) {
      float var9 = var2 * 2.0F;
      if (var9 > 1.0F) {
         var9 = 1.0F;
      }

      var9 = 1.0F - var9 * var9 * var9;
      this.field17458.rotateAngleZ = (float) Math.PI - var9 * 0.35F * (float) Math.PI;
      this.field17459.rotateAngleZ = (float) Math.PI + var9 * 0.35F * (float) Math.PI;
      this.field17459.rotateAngleY = (float) Math.PI;
      float var10 = (var2 + MathHelper.sin(var2 * 2.7F)) * 0.6F * 12.0F;
      this.field17458.rotationPointY = 24.0F - var10;
      this.field17459.rotationPointY = this.field17458.rotationPointY;
      this.field17457.rotationPointY = this.field17458.rotationPointY;
   }

   @Override
   public Iterable<ModelRenderer> method11015() {
      return ImmutableList.of(this.field17457, this.field17458, this.field17459);
   }
}
