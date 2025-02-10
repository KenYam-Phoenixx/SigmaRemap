package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.ShoulderRidingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.optifine.Config;
import net.optifine.shaders.Shaders;

public class Class250<T extends PlayerEntity> extends LayerRenderer<T, PlayerModel<T>> {
   private final Class2814 field907 = new Class2814();

   public Class250(Class5714<T, PlayerModel<T>> var1) {
      super(var1);
   }

   public void render(MatrixStack var1, IRenderTypeBuffer var2, int var3, T var4, float var5, float var6, float var7, float var8, float var9, float var10) {
      this.method840(var1, var2, var3, (T)var4, var5, var6, var9, var10, true);
      this.method840(var1, var2, var3, (T)var4, var5, var6, var9, var10, false);
   }

   private void method840(MatrixStack var1, IRenderTypeBuffer var2, int var3, T var4, float var5, float var6, float var7, float var8, boolean var9) {
      CompoundNBT var12 = !var9 ? var4.method2971() : var4.method2969();
      EntityType.method33199(var12.getString("id")).filter(var0 -> var0 == EntityType.PARROT).ifPresent(var11 -> {
         Entity var14 = Config.method26874().field1000;
         if (var4 instanceof AbstractClientPlayerEntity) {
            AbstractClientPlayerEntity var15 = (AbstractClientPlayerEntity)var4;
            ShoulderRidingEntity var16 = !var9 ? var15.entityShoulderRight : var15.entityShoulderLeft;
            if (var16 != null) {
               Config.method26874().field1000 = var16;
               if (Config.isShaders()) {
                  Shaders.method33079(var16);
               }
            }
         }

         var1.push();
         var1.translate(!var9 ? -0.4F : 0.4F, !var4.isCrouching() ? -1.5 : -1.3F, 0.0);
         IVertexBuilder var17 = var2.getBuffer(this.field907.method11028(Class5697.field25067[var12.getInt("Variant")]));
         this.field907.method11019(var1, var17, var3, OverlayTexture.NO_OVERLAY, var5, var6, var7, var8, var4.ticksExisted);
         var1.pop();
         Config.method26874().field1000 = var14;
         if (Config.isShaders()) {
            Shaders.method33079(var14);
         }
      });
   }
}
