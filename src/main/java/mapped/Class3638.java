package mapped;

import com.mojang.datafixers.DSL;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.templates.TypeTemplate;
import net.minecraft.util.datafix.TypeReferences;

import java.util.Map;
import java.util.function.Supplier;

public class Class3638 extends Class3639 {
   public Class3638(int var1, Schema var2) {
      super(var1, var2);
   }

   public static void method12350(Schema var0, Map<String, Supplier<TypeTemplate>> var1, String var2) {
      var0.register(var1, var2, () -> Class9674.method37738(var0));
   }

   public Map<String, Supplier<TypeTemplate>> registerEntities(Schema var1) {
      Map var4 = super.registerEntities(var1);
      method12350(var1, var4, "minecraft:bee");
      method12350(var1, var4, "minecraft:bee_stinger");
      return var4;
   }

   public Map<String, Supplier<TypeTemplate>> registerBlockEntities(Schema var1) {
      Map var4 = super.registerBlockEntities(var1);
      var1.register(
         var4,
         "minecraft:beehive",
         () -> DSL.optionalFields(
               "Items", DSL.list(TypeReferences.ITEM_STACK.in(var1)), "Bees", DSL.list(DSL.optionalFields("EntityData", TypeReferences.ENTITY_TREE.in(var1)))
            )
      );
      return var4;
   }
}
