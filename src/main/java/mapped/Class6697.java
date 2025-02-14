package mapped;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

import java.util.Random;

public class Class6697 extends Class6698 {
   private static String[] field29325;
   public static final Codec<Class6697> field29326 = Codec.unit(() -> Class6697.field29327);
   public static final Class6697 field29327 = new Class6697();
   private static final BlockState[] field29328 = new BlockState[]{
      Blocks.ORANGE_TULIP.getDefaultState(), Blocks.RED_TULIP.getDefaultState(), Blocks.PINK_TULIP.getDefaultState(), Blocks.WHITE_TULIP.getDefaultState()
   };
   private static final BlockState[] field29329 = new BlockState[]{
      Blocks.POPPY.getDefaultState(), Blocks.AZURE_BLUET.getDefaultState(), Blocks.OXEYE_DAISY.getDefaultState(), Blocks.CORNFLOWER.getDefaultState()
   };

   @Override
   public Class9654<?> method20423() {
      return Class9654.field45133;
   }

   @Override
   public BlockState method20424(Random var1, BlockPos var2) {
      double var5 = Biome.INFO_NOISE.noiseAt((double)var2.getX() / 200.0, (double)var2.getZ() / 200.0, false);
      if (!(var5 < -0.8)) {
         return var1.nextInt(3) <= 0 ? Blocks.DANDELION.getDefaultState() : Util.<BlockState>getRandomObject(field29329, var1);
      } else {
         return Util.<BlockState>getRandomObject(field29328, var1);
      }
   }
}
