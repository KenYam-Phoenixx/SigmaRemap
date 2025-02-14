package mapped;

import com.mojang.serialization.Codec;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;

public class Class2976 extends Structure<Class4712> {
   public Class2976(Codec<Class4712> var1) {
      super(var1);
   }

   @Override
   public boolean method11357() {
      return false;
   }

   public boolean method11361(ChunkGenerator var1, BiomeProvider var2, long var3, SharedSeedRandom var5, int var6, int var7, Biome var8, ChunkPos var9, Class4712 var10) {
      for (Biome var14 : var2.method7202(var6 * 16 + 9, var1.func_230356_f_(), var7 * 16 + 9, 32)) {
         if (!var14.getGenerationSettings().hasStructure(this)) {
            return false;
         }
      }

      return true;
   }

   @Override
   public Class7072<Class4712> method11359() {
      return Class5450::new;
   }
}
