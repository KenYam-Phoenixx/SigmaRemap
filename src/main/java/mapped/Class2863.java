package mapped;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.vector.Vector3d;

public class Class2863<T extends LivingEntity> extends AgeableModel<T> {
   private static String[] field17746;
   private final ModelRenderer field17747;
   private final ModelRenderer field17748 = new ModelRenderer(this, 22, 0);

   public Class2863() {
      this.field17748.addBox(-10.0F, 0.0F, 0.0F, 10.0F, 20.0F, 2.0F, 1.0F);
      this.field17747 = new ModelRenderer(this, 22, 0);
      this.field17747.mirror = true;
      this.field17747.addBox(0.0F, 0.0F, 0.0F, 10.0F, 20.0F, 2.0F, 1.0F);
   }

   @Override
   public Iterable<ModelRenderer> getHeadParts() {
      return ImmutableList.of();
   }

   @Override
   public Iterable<ModelRenderer> getBodyParts() {
      return ImmutableList.of(this.field17748, this.field17747);
   }

   public void setRotationAngles(T var1, float var2, float var3, float var4, float var5, float var6) {
      float var9 = (float) (Math.PI / 12);
      float var10 = (float) (-Math.PI / 12);
      float var11 = 0.0F;
      float var12 = 0.0F;
      if (!var1.isElytraFlying()) {
         if (var1.isCrouching()) {
            var9 = (float) (Math.PI * 2.0 / 9.0);
            var10 = (float) (-Math.PI / 4);
            var11 = 3.0F;
            var12 = 0.08726646F;
         }
      } else {
         float var13 = 1.0F;
         Vector3d var14 = var1.getMotion();
         if (var14.y < 0.0) {
            Vector3d var15 = var14.normalize();
            var13 = 1.0F - (float)Math.pow(-var15.y, 1.5);
         }

         var9 = var13 * (float) (Math.PI / 9) + (1.0F - var13) * var9;
         var10 = var13 * (float) (-Math.PI / 2) + (1.0F - var13) * var10;
      }

      this.field17748.rotationPointX = 5.0F;
      this.field17748.rotationPointY = var11;
      if (!(var1 instanceof AbstractClientPlayerEntity)) {
         this.field17748.rotateAngleX = var9;
         this.field17748.rotateAngleZ = var10;
         this.field17748.rotateAngleY = var12;
      } else {
         AbstractClientPlayerEntity var16 = (AbstractClientPlayerEntity)var1;
         var16.rotateElytraX = (float)((double)var16.rotateElytraX + (double)(var9 - var16.rotateElytraX) * 0.1);
         var16.rotateElytraY = (float)((double)var16.rotateElytraY + (double)(var12 - var16.rotateElytraY) * 0.1);
         var16.rotateElytraZ = (float)((double)var16.rotateElytraZ + (double)(var10 - var16.rotateElytraZ) * 0.1);
         this.field17748.rotateAngleX = var16.rotateElytraX;
         this.field17748.rotateAngleY = var16.rotateElytraY;
         this.field17748.rotateAngleZ = var16.rotateElytraZ;
      }

      this.field17747.rotationPointX = -this.field17748.rotationPointX;
      this.field17747.rotateAngleY = -this.field17748.rotateAngleY;
      this.field17747.rotationPointY = this.field17748.rotationPointY;
      this.field17747.rotateAngleX = this.field17748.rotateAngleX;
      this.field17747.rotateAngleZ = -this.field17748.rotateAngleZ;
   }
}
