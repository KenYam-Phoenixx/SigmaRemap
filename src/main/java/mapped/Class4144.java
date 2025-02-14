package mapped;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.optifine.Config;

public class Class4144 extends Class4057 {
   public Class4144() {
      super(EntityType.GUARDIAN, "guardian", 0.5F);
   }

   @Override
   public Class2828 method12822() {
      return new Class2820();
   }

   @Override
   public ModelRenderer method12823(Class2828 var1, String var2) {
      if (!(var1 instanceof Class2820)) {
         return null;
      } else {
         Class2820 var5 = (Class2820)var1;
         if (!var2.equals("body")) {
            if (var2.equals("eye")) {
               return (ModelRenderer) Reflector.getFieldValue(var5, Reflector.field43048);
            } else {
               String var6 = "spine";
               if (!var2.startsWith(var6)) {
                  String var11 = "tail";
                  if (!var2.startsWith(var11)) {
                     return null;
                  } else {
                     ModelRenderer[] var12 = (ModelRenderer[]) Reflector.getFieldValue(var5, Reflector.field43050);
                     if (var12 == null) {
                        return null;
                     } else {
                        String var14 = var2.substring(var11.length());
                        int var10 = Config.method26899(var14, -1);
                        var10--;
                        return var10 >= 0 && var10 < var12.length ? var12[var10] : null;
                     }
                  }
               } else {
                  ModelRenderer[] var7 = (ModelRenderer[]) Reflector.getFieldValue(var5, Reflector.field43049);
                  if (var7 == null) {
                     return null;
                  } else {
                     String var8 = var2.substring(var6.length());
                     int var9 = Config.method26899(var8, -1);
                     var9--;
                     return var9 >= 0 && var9 < var7.length ? var7[var9] : null;
                  }
               }
            }
         } else {
            return (ModelRenderer) Reflector.getFieldValue(var5, Reflector.field43047);
         }
      }
   }

   @Override
   public String[] method12824() {
      return new String[]{
         "body",
         "eye",
         "spine1",
         "spine2",
         "spine3",
         "spine4",
         "spine5",
         "spine6",
         "spine7",
         "spine8",
         "spine9",
         "spine10",
         "spine11",
         "spine12",
         "tail1",
         "tail2",
         "tail3"
      };
   }

   @Override
   public Class9492 method12825(Class2828 var1, float var2) {
      EntityRendererManager var5 = Minecraft.getInstance().getRenderManager();
      Class5658 var6 = new Class5658(var5);
      var6.entityModel = (Class2820)var1;
      var6.shadowSize = var2;
      return (Class9492)var6;
   }
}
