package mapped;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChorusFlowerBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;

import java.util.Random;

public class Class2936 extends Class2898<Class4712> {
   public Class2936(Codec<Class4712> var1) {
      super(var1);
   }

   public boolean method11213(ISeedReader var1, ChunkGenerator var2, Random var3, BlockPos var4, Class4712 var5) {
      if (var1.method7007(var4) && var1.getBlockState(var4.down()).isIn(Blocks.END_STONE)) {
         ChorusFlowerBlock.method11593(var1, var4, var3, 8);
         return true;
      } else {
         return false;
      }
   }
}
