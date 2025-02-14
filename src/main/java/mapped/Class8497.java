package mapped;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import net.minecraft.client.multiplayer.ClientChunkProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.server.ServerChunkProvider;
import net.minecraft.world.server.ServerWorld;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public final class Class8497 {
   private final Map<ChunkPos, String> field37169;
   private final CompletableFuture<Map<ChunkPos, String>> field37170;
   public final Class5126 field37171;

   public Class8497(Class5126 var1, IntegratedServer var2, double var3, double var5) {
      this.field37171 = var1;
      ClientWorld var9 = Class5126.method15862(var1).world;
      RegistryKey var10 = var9.getDimensionKey();
      int var11 = (int)var3 >> 4;
      int var12 = (int)var5 >> 4;
      Builder var13 = ImmutableMap.builder();
      ClientChunkProvider var14 = var9.getChunkProvider();

      for (int var15 = var11 - 12; var15 <= var11 + 12; var15++) {
         for (int var16 = var12 - 12; var16 <= var12 + 12; var16++) {
            ChunkPos var17 = new ChunkPos(var15, var16);
            String var18 = "";
            Chunk var19 = var14.getChunk(var15, var16, false);
            var18 = var18 + "Client: ";
            if (var19 != null) {
               var18 = var18 + (!var19.isEmpty() ? "" : " E");
               var18 = var18 + "\n";
            } else {
               var18 = var18 + "0n/a\n";
            }

            var13.put(var17, var18);
         }
      }

      this.field37169 = var13.build();
      this.field37170 = var2.<Map<ChunkPos, String>>supplyAsync(() -> {
         ServerWorld var6 = var2.method1318(var10);
         if (var6 == null) {
            return ImmutableMap.of();
         } else {
            Builder var7 = ImmutableMap.builder();
            ServerChunkProvider var8 = var6.getChunkProvider();

            for (int var9x = var11 - 12; var9x <= var11 + 12; var9x++) {
               for (int var10x = var12 - 12; var10x <= var12 + 12; var10x++) {
                  ChunkPos var11x = new ChunkPos(var9x, var10x);
                  var7.put(var11x, "Server: " + var8.method7382(var11x));
               }
            }

            return var7.build();
         }
      });
   }

   // $VF: synthetic method
   public static CompletableFuture method30086(Class8497 var0) {
      return var0.field37170;
   }

   // $VF: synthetic method
   public static Map<ChunkPos, String> method30087(Class8497 var0) {
      return var0.field37169;
   }
}
