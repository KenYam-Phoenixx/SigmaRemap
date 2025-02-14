package mapped;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.optifine.Config;

public class Class4102 extends Class4057 {
   public Class4102() {
      super(EntityType.PUFFERFISH, "puffer_fish_big", 0.2F);
   }

   @Override
   public Class2828 method12822() {
      return new Class2812();
   }

   @Override
   public ModelRenderer method12823(Class2828 var1, String var2) {
      if (var1 instanceof Class2812) {
         Class2812 var5 = (Class2812)var1;
         if (!var2.equals("body")) {
            if (!var2.equals("fin_right")) {
               if (!var2.equals("fin_left")) {
                  if (!var2.equals("spikes_front_top")) {
                     if (!var2.equals("spikes_middle_top")) {
                        if (!var2.equals("spikes_back_top")) {
                           if (!var2.equals("spikes_front_right")) {
                              if (!var2.equals("spikes_front_left")) {
                                 if (!var2.equals("spikes_front_bottom")) {
                                    if (!var2.equals("spikes_middle_bottom")) {
                                       if (!var2.equals("spikes_back_bottom")) {
                                          if (!var2.equals("spikes_back_right")) {
                                             return !var2.equals("spikes_back_left") ? null : (ModelRenderer) Reflector.field43082.method36565(var5, 12);
                                          } else {
                                             return (ModelRenderer) Reflector.field43082.method36565(var5, 11);
                                          }
                                       } else {
                                          return (ModelRenderer) Reflector.field43082.method36565(var5, 10);
                                       }
                                    } else {
                                       return (ModelRenderer) Reflector.field43082.method36565(var5, 9);
                                    }
                                 } else {
                                    return (ModelRenderer) Reflector.field43082.method36565(var5, 8);
                                 }
                              } else {
                                 return (ModelRenderer) Reflector.field43082.method36565(var5, 7);
                              }
                           } else {
                              return (ModelRenderer) Reflector.field43082.method36565(var5, 6);
                           }
                        } else {
                           return (ModelRenderer) Reflector.field43082.method36565(var5, 5);
                        }
                     } else {
                        return (ModelRenderer) Reflector.field43082.method36565(var5, 4);
                     }
                  } else {
                     return (ModelRenderer) Reflector.field43082.method36565(var5, 3);
                  }
               } else {
                  return (ModelRenderer) Reflector.field43082.method36565(var5, 2);
               }
            } else {
               return (ModelRenderer) Reflector.field43082.method36565(var5, 1);
            }
         } else {
            return (ModelRenderer) Reflector.field43082.method36565(var5, 0);
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
         "spikes_middle_top",
         "spikes_back_top",
         "spikes_front_right",
         "spikes_front_left",
         "spikes_front_bottom",
         "spikes_middle_bottom",
         "spikes_back_bottom",
         "spikes_back_right",
         "spikes_back_left"
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
         if (Reflector.field43142.exists()) {
            Reflector.field43142.method20237(var8, var1);
            return (Class9492)var8;
         } else {
            Config.method26811("Model field not found: RenderPufferfish.modelBig");
            return null;
         }
      } else {
         Config.method26811("Not a PufferfishRenderer: " + var6);
         return null;
      }
   }
}
