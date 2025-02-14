package mapped;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.optifine.Config;

public class Class4097 extends Class4057 {
   public Class4097() {
      super(EntityType.PUFFERFISH, "puffer_fish_medium", 0.2F);
   }

   @Override
   public Class2828 method12822() {
      return new Class2877();
   }

   @Override
   public ModelRenderer method12823(Class2828 var1, String var2) {
      if (var1 instanceof Class2877) {
         Class2877 var5 = (Class2877)var1;
         if (!var2.equals("body")) {
            if (!var2.equals("fin_right")) {
               if (!var2.equals("fin_left")) {
                  if (!var2.equals("spikes_front_top")) {
                     if (!var2.equals("spikes_back_top")) {
                        if (!var2.equals("spikes_front_right")) {
                           if (!var2.equals("spikes_back_right")) {
                              if (!var2.equals("spikes_back_left")) {
                                 if (!var2.equals("spikes_front_left")) {
                                    if (!var2.equals("spikes_back_bottom")) {
                                       return !var2.equals("spikes_front_bottom") ? null : (ModelRenderer) Reflector.field43084.method36565(var5, 10);
                                    } else {
                                       return (ModelRenderer) Reflector.field43084.method36565(var5, 9);
                                    }
                                 } else {
                                    return (ModelRenderer) Reflector.field43084.method36565(var5, 8);
                                 }
                              } else {
                                 return (ModelRenderer) Reflector.field43084.method36565(var5, 7);
                              }
                           } else {
                              return (ModelRenderer) Reflector.field43084.method36565(var5, 6);
                           }
                        } else {
                           return (ModelRenderer) Reflector.field43084.method36565(var5, 5);
                        }
                     } else {
                        return (ModelRenderer) Reflector.field43084.method36565(var5, 4);
                     }
                  } else {
                     return (ModelRenderer) Reflector.field43084.method36565(var5, 3);
                  }
               } else {
                  return (ModelRenderer) Reflector.field43084.method36565(var5, 2);
               }
            } else {
               return (ModelRenderer) Reflector.field43084.method36565(var5, 1);
            }
         } else {
            return (ModelRenderer) Reflector.field43084.method36565(var5, 0);
         }
      } else {
         return null;
      }
   }

   @Override
   public String[] method12824() {
      return new String[]{
         "body",
         "fin_right",
         "fin_left",
         "spikes_front_top",
         "spikes_back_top",
         "spikes_front_right",
         "spikes_back_right",
         "spikes_back_left",
         "spikes_front_left",
         "spikes_back_bottom",
         "spikes_front_bottom"
      };
   }

   @Override
   public Class9492 method12825(Class2828 var1, float var2) {
      EntityRendererManager var5 = Minecraft.getInstance().getRenderManager();
      Object var6 = var5.method32232().get(EntityType.PUFFERFISH);
      if (var6 instanceof Class5748) {
         if (((EntityRenderer)var6).method17898() == null) {
            Class5748 var7 = new Class5748(var5);
            var7.shadowSize = var2;
            var6 = var7;
         }

         Class5748 var8 = (Class5748)var6;
         if (Reflector.field43141.exists()) {
            Reflector.field43141.method20237(var8, var1);
            return (Class9492)var8;
         } else {
            Config.method26811("Model field not found: RenderPufferfish.modelMedium");
            return null;
         }
      } else {
         Config.method26811("Not a PufferfishRenderer: " + var6);
         return null;
      }
   }
}
