package mapped;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.mojang.datafixers.DataFixer;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;
import java.util.Map.Entry;

import net.minecraft.util.Util;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.play.server.SStatisticsPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.datafix.DefaultTypeReferences;
import net.minecraft.util.registry.Registry;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Class8287 extends StatisticsManager {
   private static final Logger field35591 = LogManager.getLogger();
   private final MinecraftServer field35592;
   private final File field35593;
   private final Set<Class9007<?>> field35594 = Sets.newHashSet();
   private int field35595 = -300;

   public Class8287(MinecraftServer var1, File var2) {
      this.field35592 = var1;
      this.field35593 = var2;
      if (var2.isFile()) {
         try {
            this.method28964(var1.getDataFixer(), FileUtils.readFileToString(var2));
         } catch (IOException var6) {
            field35591.error("Couldn't read statistics file {}", var2, var6);
         } catch (JsonParseException var7) {
            field35591.error("Couldn't parse statistics file {}", var2, var7);
         }
      }
   }

   public void method28962() {
      try {
         FileUtils.writeStringToFile(this.field35593, this.method28967());
      } catch (IOException var4) {
         field35591.error("Couldn't save stats", var4);
      }
   }

   @Override
   public void method28959(PlayerEntity var1, Class9007<?> var2, int var3) {
      super.method28959(var1, var2, var3);
      this.field35594.add(var2);
   }

   private Set<Class9007<?>> method28963() {
      HashSet var3 = Sets.newHashSet(this.field35594);
      this.field35594.clear();
      return var3;
   }

   public void method28964(DataFixer var1, String var2) {
      try {
         JsonReader var5 = new JsonReader(new StringReader(var2));
         Throwable var6 = null;

         try {
            var5.setLenient(false);
            JsonElement var7 = Streams.parse(var5);
            if (!var7.isJsonNull()) {
               CompoundNBT var8 = method28966(var7.getAsJsonObject());
               if (!var8.contains("DataVersion", 99)) {
                  var8.putInt("DataVersion", 1343);
               }

               var8 = NBTUtil.update(var1, DefaultTypeReferences.STATS, var8, var8.getInt("DataVersion"));
               if (var8.contains("stats", 10)) {
                  CompoundNBT var9 = var8.getCompound("stats");

                  for (String var11 : var9.keySet()) {
                     if (var9.contains(var11, 10)) {
                        Util.<Class49<?>>acceptOrElse(
                           Registry.field16088.method9187(new ResourceLocation(var11)),
                           var3 -> {
                              CompoundNBT var6x = var9.getCompound(var11);

                              for (String var8x : var6x.keySet()) {
                                 if (!var6x.contains(var8x, 99)) {
                                    field35591.warn(
                                       "Invalid statistic value in {}: Don't know what {} is for key {}", this.field35593, var6x.get(var8x), var8x
                                    );
                                 } else {
                                    Util.acceptOrElse(
                                       this.method28965(var3, var8x),
                                       var3x -> this.field35590.put(var3x, var6x.getInt(var8x)),
                                       () -> field35591.warn("Invalid statistic in {}: Don't know what {} is", this.field35593, var8x)
                                    );
                                 }
                              }
                           },
                           () -> field35591.warn("Invalid statistic type in {}: Don't know what {} is", this.field35593, var11)
                        );
                     }
                  }
               }

               return;
            }

            field35591.error("Unable to parse Stat data from {}", this.field35593);
         } catch (Throwable var21) {
            var6 = var21;
            throw var21;
         } finally {
            if (var5 != null) {
               if (var6 != null) {
                  try {
                     var5.close();
                  } catch (Throwable var20) {
                     var6.addSuppressed(var20);
                  }
               } else {
                  var5.close();
               }
            }
         }
      } catch (JsonParseException | IOException var23) {
         field35591.error("Unable to parse Stat data from {}", this.field35593, var23);
      }
   }

   private <T> Optional<Class9007<T>> method28965(Class49<T> var1, String var2) {
      return Optional.<ResourceLocation>ofNullable(ResourceLocation.method8289(var2)).<T>flatMap(var1.method171()::method9187).<Class9007<T>>map(var1::method172);
   }

   private static CompoundNBT method28966(JsonObject var0) {
      CompoundNBT var3 = new CompoundNBT();

      for (Entry var5 : var0.entrySet()) {
         JsonElement var6 = (JsonElement)var5.getValue();
         if (!var6.isJsonObject()) {
            if (var6.isJsonPrimitive()) {
               JsonPrimitive var7 = var6.getAsJsonPrimitive();
               if (var7.isNumber()) {
                  var3.putInt((String)var5.getKey(), var7.getAsInt());
               }
            }
         } else {
            var3.put((String)var5.getKey(), method28966(var6.getAsJsonObject()));
         }
      }

      return var3;
   }

   public String method28967() {
      Map<Class49<?>, JsonObject> var3 = Maps.newHashMap();

       for (Object2IntMap.Entry<Class9007<?>> entry : this.field35590.object2IntEntrySet()) {
           var3.computeIfAbsent(entry.getKey().method33275(), var0 -> new JsonObject()).addProperty(method28968(entry.getKey()).toString(),
                   entry.getIntValue());
       }

      JsonObject var7 = new JsonObject();

      for (Entry<Class49<?>, JsonObject> var10 : var3.entrySet()) {
         var7.add(Registry.field16088.getKey(var10.getKey()).toString(), var10.getValue());
      }

      JsonObject var9 = new JsonObject();
      var9.add("stats", var7);
      var9.addProperty("DataVersion", SharedConstants.getVersion().getWorldVersion());
      return var9.toString();
   }

   private static <T> ResourceLocation method28968(Class9007<T> var0) {
      return var0.method33275().method171().getKey(var0.method33276());
   }

   public void method28969() {
      this.field35594.addAll(this.field35590.keySet());
   }

   public void method28970(ServerPlayerEntity var1) {
      int var4 = this.field35592.method1375();
      Object2IntOpenHashMap var5 = new Object2IntOpenHashMap();
      if (var4 - this.field35595 > 300) {
         this.field35595 = var4;

         for (Class9007 var7 : this.method28963()) {
            var5.put(var7, this.method28961(var7));
         }
      }

      var1.connection.sendPacket(new SStatisticsPacket(var5));
   }
}
