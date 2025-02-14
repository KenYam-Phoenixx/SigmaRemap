package mapped;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.block.Class3402;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;

import java.util.Random;

public class Class2906 extends Class2898<Class4712> {
   private static final Direction[] field17990 = Direction.values();

   public Class2906(Codec<Class4712> var1) {
      super(var1);
   }

   public boolean method11213(ISeedReader var1, ChunkGenerator var2, Random var3, BlockPos var4, Class4712 var5) {
      BlockPos.Mutable var8 = var4.method8354();

      for (int var9 = 64; var9 < 256; var9++) {
         var8.method8374(var4);
         var8.method8381(var3.nextInt(4) - var3.nextInt(4), 0, var3.nextInt(4) - var3.nextInt(4));
         var8.setY(var9);
         if (var1.method7007(var8)) {
            for (Direction var13 : field17990) {
               if (var13 != Direction.DOWN && Class3402.method12034(var1, var8, var13)) {
                  var1.setBlockState(var8, Blocks.VINE.getDefaultState().with(Class3402.method12039(var13), Boolean.valueOf(true)), 2);
                  break;
               }
            }
         }
      }

      return true;
   }
}
