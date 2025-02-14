package mapped;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.resources.data.IMetadataSectionSerializer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.io.*;
import java.nio.charset.StandardCharsets;

public abstract class ResourcePack implements IResourcePack {
   private static final Logger field1196 = LogManager.getLogger();
   public final File field1197;

   public ResourcePack(File var1) {
      this.field1197 = var1;
   }

   private static String method1252(ResourcePackType var0, ResourceLocation var1) {
      return String.format("%s/%s/%s", var0.getDirectoryName(), var1.getNamespace(), var1.getPath());
   }

   public static String method1253(File var0, File var1) {
      return var0.toURI().relativize(var1.toURI()).getPath();
   }

   @Override
   public InputStream getResourceStream(ResourcePackType var1, ResourceLocation var2) throws IOException {
      return this.method1254(method1252(var1, var2));
   }

   @Override
   public boolean resourceExists(ResourcePackType var1, ResourceLocation var2) {
      return this.method1255(method1252(var1, var2));
   }

   public abstract InputStream method1254(String var1) throws IOException;

   @Override
   public InputStream getRootResourceStream(String var1) throws IOException {
      if (!var1.contains("/") && !var1.contains("\\")) {
         return this.method1254(var1);
      } else {
         throw new IllegalArgumentException("Root resources can only be filenames, not paths (no / allowed!)");
      }
   }

   public abstract boolean method1255(String var1);

   public void method1256(String var1) {
      field1196.warn("ResourcePack: ignored non-lowercase namespace: {} in {}", var1, this.field1197);
   }

   @Nullable
   @Override
   public <T> T getMetadata(IMetadataSectionSerializer<T> var1) throws IOException {
      Object var6;
      try (InputStream var4 = this.method1254("pack.mcmeta")) {
         var6 = method1257(var1, var4);
      }

      return (T)var6;
   }

   @Nullable
   public static <T> T method1257(IMetadataSectionSerializer<T> var0, InputStream var1) {
      JsonObject var6;
      try (BufferedReader var4 = new BufferedReader(new InputStreamReader(var1, StandardCharsets.UTF_8))) {
         var6 = JSONUtils.fromJson(var4);
      } catch (JsonParseException | IOException var20) {
         field1196.error("Couldn't load {} metadata", var0.getSectionName(), var20);
         return null;
      }

      if (!var6.has(var0.getSectionName())) {
         return null;
      } else {
         try {
            return (T)var0.deserialize(JSONUtils.method32782(var6, var0.getSectionName()));
         } catch (JsonParseException var17) {
            field1196.error("Couldn't load {} metadata", var0.getSectionName(), var17);
            return null;
         }
      }
   }

   @Override
   public String getName() {
      return this.field1197.getName();
   }
}
