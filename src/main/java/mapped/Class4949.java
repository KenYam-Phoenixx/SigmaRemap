package mapped;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class Class4949 implements ILootSerializer<Class158> {
   public void serialize(JsonObject var1, Class158 var2, JsonSerializationContext var3) {
      var1.addProperty("enchantment", Registry.ENCHANTMENT.getKey(Class158.method478(var2)).toString());
      var1.add("chances", var3.serialize(Class158.method479(var2)));
   }

   public Class158 method15248(JsonObject var1, JsonDeserializationContext var2) {
      ResourceLocation var5 = new ResourceLocation(JSONUtils.getString(var1, "enchantment"));
      Enchantment var6 = Registry.ENCHANTMENT.method9187(var5).orElseThrow(() -> new JsonParseException("Invalid enchantment id: " + var5));
      float[] var7 = JSONUtils.<float[]>method32788(var1, "chances", var2, float[].class);
      return new Class158(var6, var7);
   }
}
