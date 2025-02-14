package mapped;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Class6773 extends SurfaceBuilder<Class8278> {
   private static final BlockState field29495 = Blocks.WHITE_TERRACOTTA.getDefaultState();
   private static final BlockState field29549 = Blocks.ORANGE_TERRACOTTA.getDefaultState();
   private static final BlockState field29550 = Blocks.TERRACOTTA.getDefaultState();
   private static final BlockState field29551 = Blocks.YELLOW_TERRACOTTA.getDefaultState();
   private static final BlockState field29552 = Blocks.BROWN_TERRACOTTA.getDefaultState();
   private static final BlockState field29553 = Blocks.RED_TERRACOTTA.getDefaultState();
   private static final BlockState field29554 = Blocks.LIGHT_GRAY_TERRACOTTA.getDefaultState();
   public BlockState[] field29555;
   public long field29556;
   public PerlinNoiseGenerator field29557;
   public PerlinNoiseGenerator field29558;
   public PerlinNoiseGenerator field29559;

   public Class6773(Codec<Class8278> var1) {
      super(var1);
   }

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
      int var17 = var4 & 15;
      int var18 = var5 & 15;
      BlockState var19 = field29495;
      ISurfaceBuilderConfig var20 = var3.getGenerationSettings().getSurfaceBuilderConfig();
      BlockState var21 = var20.method28935();
      BlockState var22 = var20.getTop();
      BlockState var23 = var21;
      int var24 = (int)(var7 / 3.0 + 3.0 + var1.nextDouble() * 0.25);
      boolean var25 = Math.cos(var7 / 3.0 * Math.PI) > 0.0;
      int var26 = -1;
      boolean var27 = false;
      int var28 = 0;
      BlockPos.Mutable var29 = new BlockPos.Mutable();

      for (int var30 = var6; var30 >= 0; var30--) {
         if (var28 < 15) {
            var29.setPos(var17, var30, var18);
            BlockState var31 = var2.getBlockState(var29);
            if (!var31.isAir()) {
               if (var31.isIn(var9.getBlock())) {
                  if (var26 != -1) {
                     if (var26 > 0) {
                        var26--;
                        if (!var27) {
                           var2.setBlockState(var29, this.method20660(var4, var30, var5), false);
                        } else {
                           var2.setBlockState(var29, field29549, false);
                        }
                     }
                  } else {
                     var27 = false;
                     if (var24 > 0) {
                        if (var30 >= var11 - 4 && var30 <= var11 + 1) {
                           var19 = field29495;
                           var23 = var21;
                        }
                     } else {
                        var19 = Blocks.AIR.getDefaultState();
                        var23 = var9;
                     }

                     if (var30 < var11 && (var19 == null || var19.isAir())) {
                        var19 = var10;
                     }

                     var26 = var24 + Math.max(0, var30 - var11);
                     if (var30 < var11 - 1) {
                        var2.setBlockState(var29, var23, false);
                        Block var33 = var23.getBlock();
                        if (var33 == Blocks.WHITE_TERRACOTTA
                           || var33 == Blocks.ORANGE_TERRACOTTA
                           || var33 == Blocks.MAGENTA_TERRACOTTA
                           || var33 == Blocks.LIGHT_BLUE_TERRACOTTA
                           || var33 == Blocks.YELLOW_TERRACOTTA
                           || var33 == Blocks.LIME_TERRACOTTA
                           || var33 == Blocks.PINK_TERRACOTTA
                           || var33 == Blocks.GRAY_TERRACOTTA
                           || var33 == Blocks.LIGHT_GRAY_TERRACOTTA
                           || var33 == Blocks.CYAN_TERRACOTTA
                           || var33 == Blocks.PURPLE_TERRACOTTA
                           || var33 == Blocks.BLUE_TERRACOTTA
                           || var33 == Blocks.BROWN_TERRACOTTA
                           || var33 == Blocks.GREEN_TERRACOTTA
                           || var33 == Blocks.RED_TERRACOTTA
                           || var33 == Blocks.BLACK_TERRACOTTA) {
                           var2.setBlockState(var29, field29549, false);
                        }
                     } else if (var30 <= var11 + 3 + var24) {
                        var2.setBlockState(var29, var22, false);
                        var27 = true;
                     } else {
                        BlockState var32;
                        if (var30 < 64 || var30 > 127) {
                           var32 = field29549;
                        } else if (!var25) {
                           var32 = this.method20660(var4, var30, var5);
                        } else {
                           var32 = field29550;
                        }

                        var2.setBlockState(var29, var32, false);
                     }
                  }

                  var28++;
               }
            } else {
               var26 = -1;
            }
         }
      }
   }

   @Override
   public void method20658(long var1) {
      if (this.field29556 != var1 || this.field29555 == null) {
         this.method20659(var1);
      }

      if (this.field29556 != var1 || this.field29557 == null || this.field29558 == null) {
         SharedSeedRandom var5 = new SharedSeedRandom(var1);
         this.field29557 = new PerlinNoiseGenerator(var5, IntStream.rangeClosed(-3, 0));
         this.field29558 = new PerlinNoiseGenerator(var5, ImmutableList.of(0));
      }

      this.field29556 = var1;
   }

   public void method20659(long var1) {
      this.field29555 = new BlockState[64];
      Arrays.fill(this.field29555, field29550);
      SharedSeedRandom var5 = new SharedSeedRandom(var1);
      this.field29559 = new PerlinNoiseGenerator(var5, ImmutableList.of(0));

      for (int var14 = 0; var14 < 64; var14++) {
         var14 += var5.nextInt(5) + 1;
         if (var14 < 64) {
            this.field29555[var14] = field29549;
         }
      }

      int var15 = var5.nextInt(4) + 2;

      for (int var7 = 0; var7 < var15; var7++) {
         int var8 = var5.nextInt(3) + 1;
         int var9 = var5.nextInt(64);

         for (int var10 = 0; var9 + var10 < 64 && var10 < var8; var10++) {
            this.field29555[var9 + var10] = field29551;
         }
      }

      int var16 = var5.nextInt(4) + 2;

      for (int var17 = 0; var17 < var16; var17++) {
         int var19 = var5.nextInt(3) + 2;
         int var22 = var5.nextInt(64);

         for (int var11 = 0; var22 + var11 < 64 && var11 < var19; var11++) {
            this.field29555[var22 + var11] = field29552;
         }
      }

      int var18 = var5.nextInt(4) + 2;

      for (int var20 = 0; var20 < var18; var20++) {
         int var23 = var5.nextInt(3) + 1;
         int var25 = var5.nextInt(64);

         for (int var12 = 0; var25 + var12 < 64 && var12 < var23; var12++) {
            this.field29555[var25 + var12] = field29553;
         }
      }

      int var21 = var5.nextInt(3) + 3;
      int var24 = 0;

      for (int var26 = 0; var26 < var21; var26++) {
         boolean var27 = true;
         var24 += var5.nextInt(16) + 4;

         for (int var13 = 0; var24 + var13 < 64 && var13 < 1; var13++) {
            this.field29555[var24 + var13] = field29495;
            if (var24 + var13 > 1 && var5.nextBoolean()) {
               this.field29555[var24 + var13 - 1] = field29554;
            }

            if (var24 + var13 < 63 && var5.nextBoolean()) {
               this.field29555[var24 + var13 + 1] = field29554;
            }
         }
      }
   }

   public BlockState method20660(int var1, int var2, int var3) {
      int var6 = (int)Math.round(this.field29559.noiseAt((double)var1 / 512.0, (double)var3 / 512.0, false) * 2.0);
      return this.field29555[(var2 + var6 + 64) % 64];
   }
}
