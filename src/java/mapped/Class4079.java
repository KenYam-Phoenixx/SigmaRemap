package mapped;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.optifine.Config;

public class Class4079 extends Class4057 {
   public Class4079() {
      super(EntityType.TROPICAL_FISH, "tropical_fish_b", 0.2F);
   }

   @Override
   public Class2828 method12822() {
      return new Class2810(0.0F);
   }

   @Override
   public ModelRenderer method12823(Class2828 var1, String var2) {
      if (var1 instanceof Class2810) {
         Class2810 var5 = (Class2810)var1;
         if (!var2.equals("body")) {
            if (!var2.equals("tail")) {
               if (!var2.equals("fin_right")) {
                  if (!var2.equals("fin_left")) {
                     if (!var2.equals("fin_top")) {
                        return !var2.equals("fin_bottom") ? null : (ModelRenderer) Reflector.field43118.method36565(var5, 5);
                     } else {
                        return (ModelRenderer) Reflector.field43118.method36565(var5, 4);
                     }
                  } else {
                     return (ModelRenderer) Reflector.field43118.method36565(var5, 3);
                  }
               } else {
                  return (ModelRenderer) Reflector.field43118.method36565(var5, 2);
               }
            } else {
               return (ModelRenderer) Reflector.field43118.method36565(var5, 1);
            }
         } else {
            return (ModelRenderer) Reflector.field43118.method36565(var5, 0);
         }
      } else {
         return null;
      }
   }

   @Override
   public String[] method12824() {
      return new String[]{"body", "tail", "fin_right", "fin_left", "fin_top", "fin_bottom"};
   }

   @Override
   public Class9492 method12825(Class2828 var1, float var2) {
      EntityRendererManager var5 = Minecraft.getInstance().getRenderManager();
      Object var6 = var5.method32232().get(EntityType.TROPICAL_FISH);
      if (var6 instanceof Class5655) {
         if (((EntityRenderer)var6).method17898() == null) {
            Class5655 var7 = new Class5655(var5);
            var7.shadowSize = var2;
            var6 = var7;
         }

         Class5655 var8 = (Class5655)var6;
         if (Reflector.field43149.exists()) {
            Reflector.field43149.method20237(var8, var1);
            return (Class9492)var8;
         } else {
            Config.method26811("Model field not found: RenderTropicalFish.modelB");
            return null;
         }
      } else {
         Config.method26811("Not a TropicalFishRenderer: " + var6);
         return null;
      }
   }
}
