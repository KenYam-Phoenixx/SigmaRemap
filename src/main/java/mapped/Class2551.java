package mapped;

import com.google.gson.*;
import net.minecraft.util.JSONUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Type;

public class Class2551 implements JsonDeserializer<Class8894>, JsonSerializer<Class8894> {
   public Class8894 deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
      JsonObject var6 = JSONUtils.getJSONObject(var1, "loot pool");
      Class4688[] var7 = JSONUtils.<Class4688[]>method32788(var6, "entries", var3, Class4688[].class);
      ILootCondition[] var8 = JSONUtils.<ILootCondition[]>method32789(var6, "conditions", new ILootCondition[0], var3, ILootCondition[].class);
      ILootFunction[] var9 = JSONUtils.<ILootFunction[]>method32789(var6, "functions", new ILootFunction[0], var3, ILootFunction[].class);
      Class6870 var10 = Class9288.method35013(var6.get("rolls"), var3);
      Class6872 var11 = JSONUtils.<Class6872>method32789(var6, "bonus_rolls", new Class6872(0.0F, 0.0F), var3, Class6872.class);
      return new Class8894(var7, var8, var9, var10, var11);
   }

   public JsonElement serialize(Class8894 var1, Type var2, JsonSerializationContext var3) {
      JsonObject var6 = new JsonObject();
      var6.add("rolls", Class9288.method35014(Class8894.method32375(var1), var3));
      var6.add("entries", var3.serialize(Class8894.method32376(var1)));
      if (Class8894.method32377(var1).method20922() != 0.0F && Class8894.method32377(var1).method20923() != 0.0F) {
         var6.add("bonus_rolls", var3.serialize(Class8894.method32377(var1)));
      }

      if (!ArrayUtils.isEmpty(Class8894.method32378(var1))) {
         var6.add("conditions", var3.serialize(Class8894.method32378(var1)));
      }

      if (!ArrayUtils.isEmpty(Class8894.method32379(var1))) {
         var6.add("functions", var3.serialize(Class8894.method32379(var1)));
      }

      return var6;
   }
}
