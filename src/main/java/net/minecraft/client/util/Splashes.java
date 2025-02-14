package net.minecraft.client.util;

import com.google.common.collect.Lists;
import mapped.*;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Splashes extends Class269<List<String>> {
   private static final ResourceLocation field1045 = new ResourceLocation("texts/splashes.txt");
   private static final Random field1046 = new Random();
   private final List<String> field1047 = Lists.newArrayList();
   private final Session field1048;

   public Splashes(Session var1) {
      this.field1048 = var1;
   }

   public List<String> method970(IResourceManager var1, IProfiler var2) {
      try (
              IResource var5 = Minecraft.getInstance().getResourceManager().getResource(field1045);
              BufferedReader var7 = new BufferedReader(new InputStreamReader(var5.getInputStream(), StandardCharsets.UTF_8));
      ) {
         return var7.lines().<String>map(String::trim).filter(var0 -> var0.hashCode() != 125780783).collect(Collectors.<String>toList());
      } catch (IOException var38) {
         return Collections.<String>emptyList();
      }
   }

   public void method971(List<String> var1, IResourceManager var2, IProfiler var3) {
      this.field1047.clear();
      this.field1047.addAll(var1);
   }

   @Nullable
   public String method990() {
      Calendar var3 = Calendar.getInstance();
      var3.setTime(new Date());
      if (var3.get(2) + 1 == 12 && var3.get(5) == 24) {
         return "Merry X-mas!";
      } else if (var3.get(2) + 1 == 1 && var3.get(5) == 1) {
         return "Happy new year!";
      } else if (var3.get(2) + 1 == 10 && var3.get(5) == 31) {
         return "OOoooOOOoooo! Spooky!";
      } else if (this.field1047.isEmpty()) {
         return null;
      } else {
         return this.field1048 != null && field1046.nextInt(this.field1047.size()) == 42
            ? this.field1048.getUsername().toUpperCase(Locale.ROOT) + " IS YOU"
            : this.field1047.get(field1046.nextInt(this.field1047.size()));
      }
   }
}
