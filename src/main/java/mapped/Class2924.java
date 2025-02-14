package mapped;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;

import java.util.Random;

public class Class2924 extends Class2898<Class4712> {
   private static final Class166 field17998 = Class166.method497(Blocks.SAND);
   private final BlockState field17999 = Blocks.SANDSTONE_SLAB.getDefaultState();
   private final BlockState field18000 = Blocks.SANDSTONE.getDefaultState();
   private final BlockState field18001 = Blocks.WATER.getDefaultState();

   public Class2924(Codec<Class4712> var1) {
      super(var1);
   }

   public boolean method11213(ISeedReader var1, ChunkGenerator var2, Random var3, BlockPos var4, Class4712 var5) {
      var4 = var4.up();

      while (var1.method7007(var4) && var4.getY() > 2) {
         var4 = var4.down();
      }

      if (!field17998.test(var1.getBlockState(var4))) {
         return false;
      } else {
         for (int var8 = -2; var8 <= 2; var8++) {
            for (int var9 = -2; var9 <= 2; var9++) {
               if (var1.method7007(var4.add(var8, -1, var9)) && var1.method7007(var4.add(var8, -2, var9))) {
                  return false;
               }
            }
         }

         for (int var12 = -1; var12 <= 0; var12++) {
            for (int var17 = -2; var17 <= 2; var17++) {
               for (int var10 = -2; var10 <= 2; var10++) {
                  var1.setBlockState(var4.add(var17, var12, var10), this.field18000, 2);
               }
            }
         }

         var1.setBlockState(var4, this.field18001, 2);

         for (Direction var18 : Direction.Plane.HORIZONTAL) {
            var1.setBlockState(var4.offset(var18), this.field18001, 2);
         }

         for (int var14 = -2; var14 <= 2; var14++) {
            for (int var19 = -2; var19 <= 2; var19++) {
               if (var14 == -2 || var14 == 2 || var19 == -2 || var19 == 2) {
                  var1.setBlockState(var4.add(var14, 1, var19), this.field18000, 2);
               }
            }
         }

         var1.setBlockState(var4.add(2, 1, 0), this.field17999, 2);
         var1.setBlockState(var4.add(-2, 1, 0), this.field17999, 2);
         var1.setBlockState(var4.add(0, 1, 2), this.field17999, 2);
         var1.setBlockState(var4.add(0, 1, -2), this.field17999, 2);

         for (int var15 = -1; var15 <= 1; var15++) {
            for (int var20 = -1; var20 <= 1; var20++) {
               if (var15 == 0 && var20 == 0) {
                  var1.setBlockState(var4.add(var15, 4, var20), this.field18000, 2);
               } else {
                  var1.setBlockState(var4.add(var15, 4, var20), this.field17999, 2);
               }
            }
         }

         for (int var16 = 1; var16 <= 3; var16++) {
            var1.setBlockState(var4.add(-1, var16, -1), this.field18000, 2);
            var1.setBlockState(var4.add(-1, var16, 1), this.field18000, 2);
            var1.setBlockState(var4.add(1, var16, -1), this.field18000, 2);
            var1.setBlockState(var4.add(1, var16, 1), this.field18000, 2);
         }

         return true;
      }
   }
}
