package mapped;

import com.mojang.serialization.Codec;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;

import java.util.Random;

public class Class2960 extends Structure<Class4712> {
   public Class2960(Codec<Class4712> var1) {
      super(var1);
   }

   @Override
   public boolean method11357() {
      return false;
   }

   public boolean method11361(ChunkGenerator var1, BiomeProvider var2, long var3, SharedSeedRandom var5, int var6, int var7, Biome var8, ChunkPos var9, Class4712 var10) {
      return method11360(var6, var7, var1) >= 60;
   }

   @Override
   public Class7072<Class4712> method11359() {
      return Class5452::new;
   }

   private static int method11360(int var0, int var1, ChunkGenerator var2) {
      Random var5 = new Random((long)(var0 + var1 * 10387313));
      Rotation var6 = Rotation.randomRotation(var5);
      byte var7 = 5;
      byte var8 = 5;
      if (var6 != Rotation.CLOCKWISE_90) {
         if (var6 != Rotation.CLOCKWISE_180) {
            if (var6 == Rotation.COUNTERCLOCKWISE_90) {
               var8 = -5;
            }
         } else {
            var7 = -5;
            var8 = -5;
         }
      } else {
         var7 = -5;
      }

      int var9 = (var0 << 4) + 7;
      int var10 = (var1 << 4) + 7;
      int var11 = var2.getNoiseHeightMinusOne(var9, var10, Heightmap.Type.WORLD_SURFACE_WG);
      int var12 = var2.getNoiseHeightMinusOne(var9, var10 + var8, Heightmap.Type.WORLD_SURFACE_WG);
      int var13 = var2.getNoiseHeightMinusOne(var9 + var7, var10, Heightmap.Type.WORLD_SURFACE_WG);
      int var14 = var2.getNoiseHeightMinusOne(var9 + var7, var10 + var8, Heightmap.Type.WORLD_SURFACE_WG);
      return Math.min(Math.min(var11, var12), Math.min(var13, var14));
   }

   // $VF: synthetic method
   public static int method11362(int var0, int var1, ChunkGenerator var2) {
      return method11360(var0, var1, var2);
   }
}
