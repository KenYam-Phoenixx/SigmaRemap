package mapped;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;

import java.util.Random;

public class Class6774 extends Class6773 {
   private static final BlockState field29495 = Blocks.WHITE_TERRACOTTA.getDefaultState();
   private static final BlockState field29549 = Blocks.ORANGE_TERRACOTTA.getDefaultState();
   private static final BlockState field29550 = Blocks.TERRACOTTA.getDefaultState();

   public Class6774(Codec<Class8278> var1) {
      super(var1);
   }

   @Override
   public void buildSurface(
      Random var1,
      IChunk var2,
      Biome var3,
      int var4,
      int var5,
      int var6,
      double var7,
      BlockState var9,
      BlockState var10,
      int var11,
      long var12,
      Class8278 var14
   ) {
      double var17 = 0.0;
      double var19 = Math.min(Math.abs(var7), this.field29557.noiseAt((double)var4 * 0.25, (double)var5 * 0.25, false) * 15.0);
      if (var19 > 0.0) {
         double var29 = 0.001953125;
         double var31 = Math.abs(this.field29558.noiseAt((double)var4 * 0.001953125, (double)var5 * 0.001953125, false));
         var17 = var19 * var19 * 2.5;
         double var33 = Math.ceil(var31 * 50.0) + 14.0;
         if (var17 > var33) {
            var17 = var33;
         }

         var17 += 64.0;
      }

      int var21 = var4 & 15;
      int var22 = var5 & 15;
      BlockState var23 = field29495;
      ISurfaceBuilderConfig var24 = var3.getGenerationSettings().getSurfaceBuilderConfig();
      BlockState var25 = var24.method28935();
      BlockState var26 = var24.getTop();
      BlockState var27 = var25;
      int var28 = (int)(var7 / 3.0 + 3.0 + var1.nextDouble() * 0.25);
      boolean var35 = Math.cos(var7 / 3.0 * Math.PI) > 0.0;
      int var36 = -1;
      boolean var37 = false;
      BlockPos.Mutable var38 = new BlockPos.Mutable();

      for (int var39 = Math.max(var6, (int)var17 + 1); var39 >= 0; var39--) {
         var38.setPos(var21, var39, var22);
         if (var2.getBlockState(var38).isAir() && var39 < (int)var17) {
            var2.setBlockState(var38, var9, false);
         }

         BlockState var40 = var2.getBlockState(var38);
         if (!var40.isAir()) {
            if (var40.isIn(var9.getBlock())) {
               if (var36 != -1) {
                  if (var36 > 0) {
                     var36--;
                     if (!var37) {
                        var2.setBlockState(var38, this.method20660(var4, var39, var5), false);
                     } else {
                        var2.setBlockState(var38, field29549, false);
                     }
                  }
               } else {
                  var37 = false;
                  if (var28 > 0) {
                     if (var39 >= var11 - 4 && var39 <= var11 + 1) {
                        var23 = field29495;
                        var27 = var25;
                     }
                  } else {
                     var23 = Blocks.AIR.getDefaultState();
                     var27 = var9;
                  }

                  if (var39 < var11 && (var23 == null || var23.isAir())) {
                     var23 = var10;
                  }

                  var36 = var28 + Math.max(0, var39 - var11);
                  if (var39 < var11 - 1) {
                     var2.setBlockState(var38, var27, false);
                     Block var41 = var27.getBlock();
                     if (var41 == Blocks.WHITE_TERRACOTTA
                        || var41 == Blocks.ORANGE_TERRACOTTA
                        || var41 == Blocks.MAGENTA_TERRACOTTA
                        || var41 == Blocks.LIGHT_BLUE_TERRACOTTA
                        || var41 == Blocks.YELLOW_TERRACOTTA
                        || var41 == Blocks.LIME_TERRACOTTA
                        || var41 == Blocks.PINK_TERRACOTTA
                        || var41 == Blocks.GRAY_TERRACOTTA
                        || var41 == Blocks.LIGHT_GRAY_TERRACOTTA
                        || var41 == Blocks.CYAN_TERRACOTTA
                        || var41 == Blocks.PURPLE_TERRACOTTA
                        || var41 == Blocks.BLUE_TERRACOTTA
                        || var41 == Blocks.BROWN_TERRACOTTA
                        || var41 == Blocks.GREEN_TERRACOTTA
                        || var41 == Blocks.RED_TERRACOTTA
                        || var41 == Blocks.BLACK_TERRACOTTA) {
                        var2.setBlockState(var38, field29549, false);
                     }
                  } else if (var39 > var11 + 3 + var28) {
                     BlockState var43;
                     if (var39 < 64 || var39 > 127) {
                        var43 = field29549;
                     } else if (!var35) {
                        var43 = this.method20660(var4, var39, var5);
                     } else {
                        var43 = field29550;
                     }

                     var2.setBlockState(var38, var43, false);
                  } else {
                     var2.setBlockState(var38, var26, false);
                     var37 = true;
                  }
               }
            }
         } else {
            var36 = -1;
         }
      }
   }
}
