package mapped;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.optifine.Config;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class Class8043 {
   private static final Splitter field34551 = Splitter.on('=').limit(2);
   private static final Pattern field34552 = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");

   public static void method27615() {
      HashMap var2 = new HashMap();
      ArrayList<String> var3 = new ArrayList();
      String var4 = "optifine/lang/";
      String var5 = "en_us";
      String var6 = ".lang";
      var3.add(var4 + var5 + var6);
      if (!Config.method26928().language.equals(var5)) {
         var3.add(var4 + Config.method26928().language + var6);
      }

      String[] var7 = var3.toArray(new String[var3.size()]);
      method27616(Config.method26871(), var7, var2);
      IResourcePack[] var8 = Config.method26869();

      for (int var9 = 0; var9 < var8.length; var9++) {
         IResourcePack var10 = var8[var9];
         method27616(var10, var7, var2);
      }
   }

   private static void method27616(IResourcePack var0, String[] var1, Map var2) {
      try {
         for (int var5 = 0; var5 < var1.length; var5++) {
            String var6 = var1[var5];
            ResourceLocation var7 = new ResourceLocation(var6);
            if (var0.resourceExists(ResourcePackType.CLIENT_RESOURCES, var7)) {
               InputStream var8 = var0.getResourceStream(ResourcePackType.CLIENT_RESOURCES, var7);
               if (var8 != null) {
                  method27617(var8, var2);
               }
            }
         }
      } catch (IOException var9) {
         var9.printStackTrace();
      }
   }

   public static void method27617(InputStream var0, Map var1) throws IOException {
      Iterator var4 = IOUtils.readLines(var0, Charsets.UTF_8).iterator();
      var0.close();

      while (var4.hasNext()) {
         String var5 = (String)var4.next();
         if (!var5.isEmpty() && var5.charAt(0) != '#') {
            String[] var6 = (String[])Iterables.toArray(field34551.split(var5), String.class);
            if (var6 != null && var6.length == 2) {
               String var7 = var6[0];
               String var8 = field34552.matcher(var6[1]).replaceAll("%$1s");
               var1.put(var7, var8);
            }
         }
      }
   }

   public static void method27618(IResourceManager var0, String var1, Map<String, String> var2) {
      try {
         String var5 = "optifine/lang/" + var1 + ".lang";
         ResourceLocation var6 = new ResourceLocation(var5);
         IResource var7 = var0.getResource(var6);
         InputStream var8 = var7.getInputStream();
         method27617(var8, var2);
      } catch (IOException var9) {
      }
   }

   public static String method27619(String var0) {
      return I18n.format(var0);
   }

   public static TranslationTextComponent method27620(String var0) {
      return new TranslationTextComponent(var0);
   }

   public static String method27621(String var0, String var1) {
      String var4 = I18n.format(var0);
      return var4 != null && !var4.equals(var0) ? var4 : var1;
   }

   public static String method27622() {
      return I18n.format("options.on");
   }

   public static String method27623() {
      return I18n.format("options.off");
   }

   public static String method27624() {
      return I18n.format("options.graphics.fast");
   }

   public static String method27625() {
      return I18n.format("options.graphics.fancy");
   }

   public static String method27626() {
      return I18n.format("generator.default");
   }
}
