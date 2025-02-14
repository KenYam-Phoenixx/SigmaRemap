package net.minecraft.world.chunk;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Either;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import mapped.*;
import net.minecraft.util.Util;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ChunkHolder;
import net.minecraft.world.server.ServerWorldLightManager;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class ChunkStatus {
   private static final EnumSet<Heightmap.Type> field42130 = EnumSet.<Heightmap.Type>of(Heightmap.Type.OCEAN_FLOOR_WG, Heightmap.Type.WORLD_SURFACE_WG);
   private static final EnumSet<Heightmap.Type> field42131 = EnumSet.<Heightmap.Type>of(Heightmap.Type.OCEAN_FLOOR, Heightmap.Type.WORLD_SURFACE, Heightmap.Type.MOTION_BLOCKING, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES);
   private static final Class9241 field42132 = (var0, var1, var2, var3, var4, var5) -> {
      if (var5 instanceof ChunkPrimer && !var5.getStatus().isAtLeast(var0)) {
         ((ChunkPrimer)var5).method7111(var0);
      }

      return CompletableFuture.completedFuture(Either.left(var5));
   };
   public static final ChunkStatus EMPTY = method34289("empty", (ChunkStatus)null, -1, field42130, Class2076.field13524, (var0, var1, var2, var3) -> {
   });
   public static final ChunkStatus STRUCTURE_STARTS = method34290(
      "structure_starts", EMPTY, 0, field42130, Class2076.field13524, (var0, var1, var2, var3, var4, var5, var6, var7) -> {
         if (!var7.getStatus().isAtLeast(var0)) {
            if (var1.getServer().func_240793_aU_().getDimensionGeneratorSettings().method26260()) {
               var2.func_242707_a(var1.func_241828_r(), var1.func_241112_a_(), var7, var3, var1.getSeed());
            }

            if (var7 instanceof ChunkPrimer) {
               ((ChunkPrimer)var7).method7111(var0);
            }
         }

         return CompletableFuture.completedFuture(Either.left(var7));
      }
   );
   public static final ChunkStatus STRUCTURE_REFERENCES = method34289(
      "structure_references", STRUCTURE_STARTS, 8, field42130, Class2076.field13524, (var0, var1, var2, var3) -> {
         WorldGenRegion var6 = new WorldGenRegion(var0, var2);
         var1.func_235953_a_(var6, var0.func_241112_a_().method24339(var6), var3);
      }
   );
   public static final ChunkStatus BIOMES = method34289(
      "biomes",
           STRUCTURE_REFERENCES,
      0,
      field42130,
      Class2076.field13524,
      (var0, var1, var2, var3) -> var1.func_242706_a(var0.func_241828_r().<Biome>getRegistry(Registry.BIOME_KEY), var3)
   );
   public static final ChunkStatus NOISE = method34289("noise", BIOMES, 8, field42130, Class2076.field13524, (var0, var1, var2, var3) -> {
      WorldGenRegion var6 = new WorldGenRegion(var0, var2);
      var1.func_230352_b_(var6, var0.func_241112_a_().method24339(var6), var3);
   });
   public static final ChunkStatus SURFACE = method34289(
      "surface", NOISE, 0, field42130, Class2076.field13524, (var0, var1, var2, var3) -> var1.generateSurface(new WorldGenRegion(var0, var2), var3)
   );
   public static final ChunkStatus CARVERS = method34289(
      "carvers",
           SURFACE,
      0,
      field42130,
      Class2076.field13524,
      (var0, var1, var2, var3) -> var1.func_230350_a_(var0.getSeed(), var0.getBiomeManager(), var3, GenerationStageCarving.field259)
   );
   public static final ChunkStatus LIQUID_CARVERS = method34289(
      "liquid_carvers",
           CARVERS,
      0,
      field42131,
      Class2076.field13524,
      (var0, var1, var2, var3) -> var1.func_230350_a_(var0.getSeed(), var0.getBiomeManager(), var3, GenerationStageCarving.field260)
   );
   public static final ChunkStatus FEATURES = method34290(
      "features", LIQUID_CARVERS, 8, field42131, Class2076.field13524, (var0, var1, var2, var3, var4, var5, var6, var7) -> {
         ChunkPrimer var10 = (ChunkPrimer)var7;
         var10.method7119(var4);
         if (!var7.getStatus().isAtLeast(var0)) {
            Heightmap.method24577(var7, EnumSet.<Heightmap.Type>of(Heightmap.Type.MOTION_BLOCKING, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, Heightmap.Type.OCEAN_FLOOR, Heightmap.Type.WORLD_SURFACE));
            WorldGenRegion var11 = new WorldGenRegion(var1, var6);
            var2.func_230351_a_(var11, var1.func_241112_a_().method24339(var11));
            var10.method7111(var0);
         }

         return CompletableFuture.completedFuture(Either.left(var7));
      }
   );
   public static final ChunkStatus LIGHT = method34291(
      "light",
           FEATURES,
      1,
      field42131,
      Class2076.field13524,
      (var0, var1, var2, var3, var4, var5, var6, var7) -> method34288(var0, var4, var7),
      (var0, var1, var2, var3, var4, var5) -> method34288(var0, var3, var5)
   );
   public static final ChunkStatus SPAWN = method34289(
      "spawn", LIGHT, 0, field42131, Class2076.field13524, (var0, var1, var2, var3) -> var1.func_230354_a_(new WorldGenRegion(var0, var2))
   );
   public static final ChunkStatus HEIGHTMAPS = method34289("heightmaps", SPAWN, 0, field42131, Class2076.field13524, (var0, var1, var2, var3) -> {
   });
   public static final ChunkStatus FULL = method34291(
      "full",
           HEIGHTMAPS,
      0,
      field42131,
      Class2076.field13525,
      (var0, var1, var2, var3, var4, var5, var6, var7) -> var5.apply(var7),
      (var0, var1, var2, var3, var4, var5) -> var4.apply(var5)
   );
   private static final List<ChunkStatus> field42146 = ImmutableList.of(
           FULL, FEATURES, LIQUID_CARVERS, STRUCTURE_STARTS, STRUCTURE_STARTS, STRUCTURE_STARTS, STRUCTURE_STARTS, STRUCTURE_STARTS, STRUCTURE_STARTS, STRUCTURE_STARTS, STRUCTURE_STARTS
   );
   private static final IntList field42147 = Util.<IntList>make(new IntArrayList(getAll().size()), var0 -> {
      int var3 = 0;

      for (int var4 = getAll().size() - 1; var4 >= 0; var4--) {
         while (var3 + 1 < field42146.size() && var4 <= field42146.get(var3 + 1).ordinal()) {
            var3++;
         }

         var0.add(0, var3);
      }
   });
   private final String field42148;
   private final int field42149;
   private final ChunkStatus field42150;
   private final Class6965 field42151;
   private final Class9241 field42152;
   private final int field42153;
   private final Class2076 field42154;
   private final EnumSet<Heightmap.Type> field42155;

   private static CompletableFuture<Either<IChunk, ChunkHolder.IChunkLoadingError>> method34288(ChunkStatus var0, ServerWorldLightManager var1, IChunk var2) {
      boolean var5 = method34293(var0, var2);
      if (!var2.getStatus().isAtLeast(var0)) {
         ((ChunkPrimer)var2).method7111(var0);
      }

      return var1.method610(var2, var5).thenApply(Either::left);
   }

   private static ChunkStatus method34289(String var0, ChunkStatus var1, int var2, EnumSet<Heightmap.Type> var3, Class2076 var4, Class6964 var5) {
      return method34290(var0, var1, var2, var3, var4, var5);
   }

   private static ChunkStatus method34290(String var0, ChunkStatus var1, int var2, EnumSet<Heightmap.Type> var3, Class2076 var4, Class6965 var5) {
      return method34291(var0, var1, var2, var3, var4, var5, field42132);
   }

   private static ChunkStatus method34291(String var0, ChunkStatus var1, int var2, EnumSet<Heightmap.Type> var3, Class2076 var4, Class6965 var5, Class9241 var6) {
      return Registry.<ChunkStatus>register(Registry.field16081, var0, new ChunkStatus(var0, var1, var2, var3, var4, var5, var6));
   }

   public static List<ChunkStatus> getAll() {
      ArrayList var2 = Lists.newArrayList();

      ChunkStatus var3;
      for (var3 = FULL; var3.method34299() != var3; var3 = var3.method34299()) {
         var2.add(var3);
      }

      var2.add(var3);
      Collections.reverse(var2);
      return var2;
   }

   private static boolean method34293(ChunkStatus var0, IChunk var1) {
      return var1.getStatus().isAtLeast(var0) && var1.hasLight();
   }

   public static ChunkStatus method34294(int var0) {
      if (var0 < field42146.size()) {
         return var0 >= 0 ? field42146.get(var0) : FULL;
      } else {
         return EMPTY;
      }
   }

   public static int maxDistance() {
      return field42146.size();
   }

   public static int getDistance(ChunkStatus var0) {
      return field42147.getInt(var0.ordinal());
   }

   public ChunkStatus(String var1, ChunkStatus var2, int var3, EnumSet<Heightmap.Type> var4, Class2076 var5, Class6965 var6, Class9241 var7) {
      this.field42148 = var1;
      this.field42150 = var2 != null ? var2 : this;
      this.field42151 = var6;
      this.field42152 = var7;
      this.field42153 = var3;
      this.field42154 = var5;
      this.field42155 = var4;
      this.field42149 = var2 != null ? var2.ordinal() + 1 : 0;
   }

   public int ordinal() {
      return this.field42149;
   }

   public String method34298() {
      return this.field42148;
   }

   public ChunkStatus method34299() {
      return this.field42150;
   }

   public CompletableFuture<Either<IChunk, ChunkHolder.IChunkLoadingError>> method34300(
      ServerWorld var1,
      ChunkGenerator var2,
      TemplateManager var3,
      ServerWorldLightManager var4,
      Function<IChunk, CompletableFuture<Either<IChunk, ChunkHolder.IChunkLoadingError>>> var5,
      List<IChunk> var6
   ) {
      return this.field42151.method21487(this, var1, var2, var3, var4, var5, var6, (IChunk)var6.get(var6.size() / 2));
   }

   public CompletableFuture<Either<IChunk, ChunkHolder.IChunkLoadingError>> doLoadingWork(
           ServerWorld var1, TemplateManager var2, ServerWorldLightManager var3, Function<IChunk, CompletableFuture<Either<IChunk, ChunkHolder.IChunkLoadingError>>> var4, IChunk var5
   ) {
      return this.field42152.method34754(this, var1, var2, var3, var4, var5);
   }

   public int method34302() {
      return this.field42153;
   }

   public Class2076 method34303() {
      return this.field42154;
   }

   public static ChunkStatus method34304(String var0) {
      return Registry.field16081.getOrDefault(ResourceLocation.method8289(var0));
   }

   public EnumSet<Heightmap.Type> method34305() {
      return this.field42155;
   }

   public boolean isAtLeast(ChunkStatus var1) {
      return this.ordinal() >= var1.ordinal();
   }

   @Override
   public String toString() {
      return Registry.field16081.getKey(this).toString();
   }
}
