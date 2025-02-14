package mapped;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;

import java.util.List;

public class Class2971 extends Structure<Class4712> {
   private static final List<MobSpawnInfo.Spawners> field18085 = ImmutableList.of(new MobSpawnInfo.Spawners(EntityType.GUARDIAN, 1, 2, 4));

   public Class2971(Codec<Class4712> var1) {
      super(var1);
   }

   @Override
   public boolean method11357() {
      return false;
   }

   public boolean method11361(ChunkGenerator var1, BiomeProvider var2, long var3, SharedSeedRandom var5, int var6, int var7, Biome var8, ChunkPos var9, Class4712 var10) {
      for (Biome var14 : var2.method7202(var6 * 16 + 9, var1.func_230356_f_(), var7 * 16 + 9, 16)) {
         if (!var14.getGenerationSettings().hasStructure(this)) {
            return false;
         }
      }

      for (Biome var16 : var2.method7202(var6 * 16 + 9, var1.func_230356_f_(), var7 * 16 + 9, 29)) {
         if (var16.getCategory() != Biome.Category.OCEAN && var16.getCategory() != Biome.Category.RIVER) {
            return false;
         }
      }

      return true;
   }

   @Override
   public Class7072<Class4712> method11359() {
      return Class5451::new;
   }

   @Override
   public List<MobSpawnInfo.Spawners> method11374() {
      return field18085;
   }
}
