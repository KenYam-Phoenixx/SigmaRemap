package mapped;

import com.mojang.serialization.Codec;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;

public class Class2972 extends Structure<MineshaftConfig> {
   public Class2972(Codec<MineshaftConfig> var1) {
      super(var1);
   }

   public boolean method11361(ChunkGenerator var1, BiomeProvider var2, long var3, SharedSeedRandom var5, int var6, int var7, Biome var8, ChunkPos var9, MineshaftConfig var10) {
      var5.setLargeFeatureSeed(var3, var6, var7);
      double var13 = (double)var10.field22426;
      return var5.nextDouble() < var13;
   }

   @Override
   public Class7072<MineshaftConfig> method11359() {
      return Class5453::new;
   }
}
