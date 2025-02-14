package mapped;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;

import java.util.Random;

public class Class2946 extends Class2898<Class4710> {
   public Class2946(Codec<Class4710> var1) {
      super(var1);
   }

   public boolean method11213(ISeedReader var1, ChunkGenerator var2, Random var3, BlockPos var4, Class4710 var5) {
      return method11288(var1, var3, var4, var5, 8, 4);
   }

   public static boolean method11288(IWorld var0, Random var1, BlockPos var2, Class4710 var3, int var4, int var5) {
      Block var8 = var0.getBlockState(var2.down()).getBlock();
      if (var8.isIn(BlockTags.field32799)) {
         int var9 = var2.getY();
         if (var9 >= 1 && var9 + 1 < 256) {
            int var10 = 0;

            for (int var11 = 0; var11 < var4 * var4; var11++) {
               BlockPos var12 = var2.add(
                  var1.nextInt(var4) - var1.nextInt(var4), var1.nextInt(var5) - var1.nextInt(var5), var1.nextInt(var4) - var1.nextInt(var4)
               );
               BlockState var13 = var3.field22343.method20424(var1, var12);
               if (var0.method7007(var12) && var12.getY() > 0 && var13.isValidPosition(var0, var12)) {
                  var0.setBlockState(var12, var13, 2);
                  var10++;
               }
            }

            return var10 > 0;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }
}
