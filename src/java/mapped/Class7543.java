package mapped;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.stb.STBTTFontinfo;
import org.lwjgl.stb.STBTruetype;
import org.lwjgl.system.MemoryUtil;

public class Class7543 implements Class7544 {
   private static final Logger field32356 = LogManager.getLogger();
   private final ResourceLocation field32357;
   private final float field32358;
   private final float field32359;
   private final float field32360;
   private final float field32361;
   private final String field32362;

   public Class7543(ResourceLocation var1, float var2, float var3, float var4, float var5, String var6) {
      this.field32357 = var1;
      this.field32358 = var2;
      this.field32359 = var3;
      this.field32360 = var4;
      this.field32361 = var5;
      this.field32362 = var6;
   }

   public static Class7544 method24663(JsonObject var0) {
      float var3 = 0.0F;
      float var4 = 0.0F;
      if (var0.has("shift")) {
         JsonArray var5 = var0.getAsJsonArray("shift");
         if (var5.size() != 2) {
            throw new JsonParseException("Expected 2 elements in 'shift', found " + var5.size());
         }

         var3 = JSONUtils.method32770(var5.get(0), "shift[0]");
         var4 = JSONUtils.method32770(var5.get(1), "shift[1]");
      }

      StringBuilder var9 = new StringBuilder();
      if (var0.has("skip")) {
         JsonElement var6 = var0.get("skip");
         if (!var6.isJsonArray()) {
            var9.append(JSONUtils.method32762(var6, "skip"));
         } else {
            JsonArray var7 = JSONUtils.method32784(var6, "skip");

            for (int var8 = 0; var8 < var7.size(); var8++) {
               var9.append(JSONUtils.method32762(var7.get(var8), "skip[" + var8 + "]"));
            }
         }
      }

      return new Class7543(
         new ResourceLocation(JSONUtils.getString(var0, "file")),
         JSONUtils.method32772(var0, "size", 11.0F),
         JSONUtils.method32772(var0, "oversample", 1.0F),
         var3,
         var4,
         var9.toString()
      );
   }

   @Nullable
   @Override
   public Class1768 method24664(IResourceManager var1) {
      STBTTFontinfo var4 = null;
      ByteBuffer var5 = null;

      try (IResource var6 = var1.getResource(new ResourceLocation(this.field32357.getNamespace(), "font/" + this.field32357.getPath()))) {
         field32356.debug("Loading font {}", this.field32357);
         var4 = STBTTFontinfo.malloc();
         var5 = TextureUtil.method30373(var6.getInputStream());
         ((Buffer)var5).flip();
         field32356.debug("Reading font {}", this.field32357);
         if (!STBTruetype.stbtt_InitFont(var4, var5)) {
            throw new IOException("Invalid ttf");
         } else {
            return new Class1769(var5, var4, this.field32358, this.field32359, this.field32360, this.field32361, this.field32362);
         }
      } catch (Exception var20) {
         field32356.error("Couldn't load truetype font {}", this.field32357, var20);
         if (var4 != null) {
            var4.free();
         }

         MemoryUtil.memFree(var5);
         return null;
      }
   }
}
