package mapped;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.util.JSONUtils;

public class Class4942 implements ILootSerializer<Class154> {
   public void serialize(JsonObject var1, Class154 var2, JsonSerializationContext var3) {
      var1.addProperty("raining", Class154.method465(var2));
      var1.addProperty("thundering", Class154.method466(var2));
   }

   public Class154 method15248(JsonObject var1, JsonDeserializationContext var2) {
      Boolean var5 = !var1.has("raining") ? null : JSONUtils.method32768(var1, "raining");
      Boolean var6 = !var1.has("thundering") ? null : JSONUtils.method32768(var1, "thundering");
      return new Class154(var5, var6);
   }
}
