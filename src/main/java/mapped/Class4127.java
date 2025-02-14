package mapped;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;

import java.util.ArrayList;
import java.util.Arrays;

public class Class4127 extends Class4117 {
   public Class4127() {
      super(EntityType.PIGLIN, "piglin", 0.5F);
   }

   public Class4127(EntityType var1, String var2, float var3) {
      super(var1, var2, var3);
   }

   @Override
   public Class2828 method12822() {
      return new Class2895(0.0F, 64, 64);
   }

   @Override
   public ModelRenderer method12823(Class2828 var1, String var2) {
      if (var1 instanceof Class2895) {
         Class2895 var5 = (Class2895)var1;
         if (var2.equals("left_ear")) {
            return var5.field17928;
         }

         if (var2.equals("right_ear")) {
            return var5.field17929;
         }
      }

      return super.method12823(var1, var2);
   }

   @Override
   public String[] method12824() {
      ArrayList<String> var3 = new ArrayList<String>(Arrays.asList(super.method12824()));
      var3.add("left_ear");
      var3.add("right_ear");
      return var3.toArray(new String[var3.size()]);
   }

   @Override
   public Class9492 method12825(Class2828 var1, float var2) {
      EntityRendererManager var5 = Minecraft.getInstance().getRenderManager();
      Class5671 var6 = new Class5671(var5, false);
      var6.entityModel = (Class2895<MobEntity>)var1;
      var6.shadowSize = var2;
      return (Class9492)var6;
   }
}
