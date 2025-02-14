package mapped;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.optifine.Config;

import java.util.Map;

public class BipedArmorLayer<T extends LivingEntity, M extends BipedModel<T>, A extends BipedModel<T>> extends LayerRenderer<T, M> {
   private static final Map<String, ResourceLocation> field912 = Maps.newHashMap();
   private final A field913;
   private final A field914;

   public BipedArmorLayer(Class5714<T, M> var1, A var2, A var3) {
      super(var1);
      this.field913 = (A)var2;
      this.field914 = (A)var3;
   }

   public void render(MatrixStack var1, IRenderTypeBuffer var2, int var3, T var4, float var5, float var6, float var7, float var8, float var9, float var10) {
      this.method843(var1, var2, (T)var4, EquipmentSlotType.CHEST, var3, this.method847(EquipmentSlotType.CHEST));
      this.method843(var1, var2, (T)var4, EquipmentSlotType.LEGS, var3, this.method847(EquipmentSlotType.LEGS));
      this.method843(var1, var2, (T)var4, EquipmentSlotType.FEET, var3, this.method847(EquipmentSlotType.FEET));
      this.method843(var1, var2, (T)var4, EquipmentSlotType.HEAD, var3, this.method847(EquipmentSlotType.HEAD));
   }

   private void method843(MatrixStack var1, IRenderTypeBuffer var2, T var3, EquipmentSlotType var4, int var5, A var6) {
      ItemStack var9 = var3.getItemStackFromSlot(var4);
      if (var9.getItem() instanceof ArmorItem) {
         ArmorItem var10 = (ArmorItem)var9.getItem();
         if (var10.getType() == var4) {
            if (Reflector.field42864.method20245()) {
               var6 = this.method850((T)var3, var9, var4, (A)var6);
            }

            this.method825().setModelAttributes(var6);
            this.method844((A)var6, var4);
            this.method848(var4);
            boolean var11 = var9.method32159();
            if (!(var10 instanceof Class3277)) {
               this.method846(var1, var2, var5, var11, (A)var6, 1.0F, 1.0F, 1.0F, this.method851(var3, var9, var4, (String)null));
            } else {
               int var12 = ((Class3277)var10).method11800(var9);
               float var13 = (float)(var12 >> 16 & 0xFF) / 255.0F;
               float var14 = (float)(var12 >> 8 & 0xFF) / 255.0F;
               float var15 = (float)(var12 & 0xFF) / 255.0F;
               this.method846(var1, var2, var5, var11, (A)var6, var13, var14, var15, this.method851(var3, var9, var4, (String)null));
               this.method846(var1, var2, var5, var11, (A)var6, 1.0F, 1.0F, 1.0F, this.method851(var3, var9, var4, "overlay"));
            }
         }
      }
   }

   public void method844(A var1, EquipmentSlotType var2) {
      var1.setVisible(false);
      switch (Class8875.field40095[var2.ordinal()]) {
         case 1:
            var1.bipedHead.showModel = true;
            var1.bipedHeadwear.showModel = true;
            break;
         case 2:
            var1.bipedBody.showModel = true;
            var1.bipedRightArm.showModel = true;
            var1.bipedLeftArm.showModel = true;
            break;
         case 3:
            var1.bipedBody.showModel = true;
            var1.bipedRightLeg.showModel = true;
            var1.bipedLeftLeg.showModel = true;
            break;
         case 4:
            var1.bipedRightLeg.showModel = true;
            var1.bipedLeftLeg.showModel = true;
      }
   }

   private void method845(
           MatrixStack var1, IRenderTypeBuffer var2, int var3, ArmorItem var4, boolean var5, A var6, boolean var7, float var8, float var9, float var10, String var11
   ) {
      this.method846(var1, var2, var3, var5, (A)var6, var8, var9, var10, this.method849(var4, var7, var11));
   }

   private void method846(MatrixStack var1, IRenderTypeBuffer var2, int var3, boolean var4, A var5, float var6, float var7, float var8, ResourceLocation var9) {
      IVertexBuilder var12 = ItemRenderer.method782(var2, RenderType.method14308(var9), false, var4);
      var5.render(var1, var12, var3, OverlayTexture.NO_OVERLAY, var6, var7, var8, 1.0F);
   }

   private A method847(EquipmentSlotType var1) {
      return !this.method848(var1) ? this.field914 : this.field913;
   }

   private boolean method848(EquipmentSlotType var1) {
      return var1 == EquipmentSlotType.LEGS;
   }

   private ResourceLocation method849(ArmorItem var1, boolean var2, String var3) {
      String var6 = "textures/models/armor/" + var1.getArmorMaterial().method8790() + "_layer_" + (!var2 ? 1 : 2) + (var3 != null ? "_" + var3 : "") + ".png";
      return field912.computeIfAbsent(var6, ResourceLocation::new);
   }

   public A method850(T var1, ItemStack var2, EquipmentSlotType var3, A var4) {
      return (A)(!Reflector.field42873.exists() ? var4 : Reflector.field42873.call(var1, var2, var3, var4));
   }

   public ResourceLocation method851(Entity var1, ItemStack var2, EquipmentSlotType var3, String var4) {
      ArmorItem var7 = (ArmorItem)var2.getItem();
      String var8 = var7.getArmorMaterial().method8790();
      String var9 = "minecraft";
      int var10 = var8.indexOf(58);
      if (var10 != -1) {
         var9 = var8.substring(0, var10);
         var8 = var8.substring(var10 + 1);
      }

      String var11 = String.format(
         "%s:textures/models/armor/%s_layer_%d%s.png", var9, var8, !this.method848(var3) ? 1 : 2, var4 != null ? String.format("_%s", var4) : ""
      );
      if (Reflector.field42874.exists()) {
         var11 = Reflector.method35061(Reflector.field42874, var1, var2, var11, var3, var4);
      }

      ResourceLocation var12 = field912.get(var11);
      if (var12 == null) {
         var12 = new ResourceLocation(var11);
         field912.put(var11, var12);
      }

      if (Config.method26953()) {
         var12 = Class7992.method27269(var2, var3, var4, var12);
      }

      return var12;
   }
}
