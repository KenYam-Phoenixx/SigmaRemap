package mapped;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;

import java.util.Random;

public class Class2907 extends Class2898<Class4712> {
   public Class2907(Codec<Class4712> var1) {
      super(var1);
   }

   public boolean method11213(ISeedReader var1, ChunkGenerator var2, Random var3, BlockPos var4, Class4712 var5) {
      if (var1.method7007(var4) && !var1.method7007(var4.up())) {
         BlockPos.Mutable var8 = var4.method8354();
         BlockPos.Mutable var9 = var4.method8354();
         boolean var10 = true;
         boolean var11 = true;
         boolean var12 = true;
         boolean var13 = true;

         while (var1.method7007(var8)) {
            if (World.isOutsideBuildHeight(var8)) {
               return true;
            }

            var1.setBlockState(var8, Blocks.BASALT.getDefaultState(), 2);
            var10 = var10 && this.method11246(var1, var3, var9.method8377(var8, Direction.NORTH));
            var11 = var11 && this.method11246(var1, var3, var9.method8377(var8, Direction.SOUTH));
            var12 = var12 && this.method11246(var1, var3, var9.method8377(var8, Direction.WEST));
            var13 = var13 && this.method11246(var1, var3, var9.method8377(var8, Direction.EAST));
            var8.method8379(Direction.DOWN);
         }

         var8.method8379(Direction.UP);
         this.method11245(var1, var3, var9.method8377(var8, Direction.NORTH));
         this.method11245(var1, var3, var9.method8377(var8, Direction.SOUTH));
         this.method11245(var1, var3, var9.method8377(var8, Direction.WEST));
         this.method11245(var1, var3, var9.method8377(var8, Direction.EAST));
         var8.method8379(Direction.DOWN);
         BlockPos.Mutable var14 = new BlockPos.Mutable();

         for (int var15 = -3; var15 < 4; var15++) {
            for (int var16 = -3; var16 < 4; var16++) {
               int var17 = MathHelper.abs(var15) * MathHelper.abs(var16);
               if (var3.nextInt(10) < 10 - var17) {
                  var14.method8374(var8.add(var15, 0, var16));
                  int var18 = 3;

                  while (var1.method7007(var9.method8377(var14, Direction.DOWN))) {
                     var14.method8379(Direction.DOWN);
                     if (--var18 <= 0) {
                        break;
                     }
                  }

                  if (!var1.method7007(var9.method8377(var14, Direction.DOWN))) {
                     var1.setBlockState(var14, Blocks.BASALT.getDefaultState(), 2);
                  }
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private void method11245(IWorld var1, Random var2, BlockPos var3) {
      if (var2.nextBoolean()) {
         var1.setBlockState(var3, Blocks.BASALT.getDefaultState(), 2);
      }
   }

   private boolean method11246(IWorld var1, Random var2, BlockPos var3) {
      if (var2.nextInt(10) == 0) {
         return false;
      } else {
         var1.setBlockState(var3, Blocks.BASALT.getDefaultState(), 2);
         return true;
      }
   }
}
