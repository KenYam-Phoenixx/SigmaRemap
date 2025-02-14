package mapped;

import com.google.common.collect.Lists;
import com.google.gson.*;
import net.minecraft.util.JSONUtils;
import org.apache.commons.lang3.Validate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Class2569 implements JsonDeserializer<Class9304> {
   public Class9304 deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
      JsonObject var6 = JSONUtils.getJSONObject(var1, "entry");
      boolean var7 = JSONUtils.getBoolean(var6, "replace", false);
      String var8 = JSONUtils.getString(var6, "subtitle", (String)null);
      List var9 = this.method10759(var6);
      return new Class9304(var9, var7, var8);
   }

   private List<Class6647> method10759(JsonObject var1) {
      ArrayList var4 = Lists.newArrayList();
      if (var1.has("sounds")) {
         JsonArray var5 = JSONUtils.method32785(var1, "sounds");

         for (int var6 = 0; var6 < var5.size(); var6++) {
            JsonElement var7 = var5.get(var6);
            if (!JSONUtils.method32756(var7)) {
               var4.add(this.method10760(JSONUtils.getJSONObject(var7, "sound")));
            } else {
               String var8 = JSONUtils.method32762(var7, "sound");
               var4.add(new Class6647(var8, 1.0F, 1.0F, 1, Class2221.field14506, false, false, 16));
            }
         }
      }

      return var4;
   }

   private Class6647 method10760(JsonObject var1) {
      String var4 = JSONUtils.getString(var1, "name");
      Class2221 var5 = this.method10761(var1, Class2221.field14506);
      float var6 = JSONUtils.method32772(var1, "volume", 1.0F);
      Validate.isTrue(var6 > 0.0F, "Invalid volume", new Object[0]);
      float var7 = JSONUtils.method32772(var1, "pitch", 1.0F);
      Validate.isTrue(var7 > 0.0F, "Invalid pitch", new Object[0]);
      int var8 = JSONUtils.getInt(var1, "weight", 1);
      Validate.isTrue(var8 > 0, "Invalid weight", new Object[0]);
      boolean var9 = JSONUtils.getBoolean(var1, "preload", false);
      boolean var10 = JSONUtils.getBoolean(var1, "stream", false);
      int var11 = JSONUtils.getInt(var1, "attenuation_distance", 16);
      return new Class6647(var4, var6, var7, var8, var5, var10, var9, var11);
   }

   private Class2221 method10761(JsonObject var1, Class2221 var2) {
      Class2221 var5 = var2;
      if (var1.has("type")) {
         var5 = Class2221.method8948(JSONUtils.getString(var1, "type"));
         Validate.notNull(var5, "Invalid type", new Object[0]);
      }

      return var5;
   }
}
