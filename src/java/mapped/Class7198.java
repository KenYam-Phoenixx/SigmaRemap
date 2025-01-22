package mapped;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import org.apache.commons.lang3.mutable.MutableBoolean;

public class Class7198 extends Class7194 {
   public Class7198(Codec<Class4728> var1) {
      super(var1, 256);
      this.field30897 = ImmutableSet.of(
         Blocks.STONE,
         Blocks.GRANITE,
         Blocks.DIORITE,
         Blocks.ANDESITE,
         Blocks.DIRT,
         Blocks.COARSE_DIRT,
         new Block[]{
            Blocks.PODZOL,
            Blocks.GRASS_BLOCK,
            Blocks.field36794,
            Blocks.field36730,
            Blocks.field36731,
            Blocks.field36732,
            Blocks.field36733,
            Blocks.field36734,
            Blocks.field36735,
            Blocks.field36736,
            Blocks.field36737,
            Blocks.field36738,
            Blocks.field36739,
            Blocks.field36740,
            Blocks.field36741,
            Blocks.field36742,
            Blocks.field36743,
            Blocks.field36744,
            Blocks.field36745,
            Blocks.SANDSTONE,
            Blocks.field36835,
            Blocks.MYCELIUM,
            Blocks.SNOW,
            Blocks.SAND,
            Blocks.GRAVEL,
            Blocks.WATER,
            Blocks.LAVA,
            Blocks.OBSIDIAN,
            Blocks.AIR,
            Blocks.field37012,
            Blocks.PACKED_ICE
         }
      );
   }

   @Override
   public boolean method22611(IChunk var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      return false;
   }

   @Override
   public boolean method22596(
      IChunk var1,
      Function<BlockPos, Biome> var2,
      BitSet var3,
      Random var4,
      BlockPos.Mutable var5,
      BlockPos.Mutable var6,
      BlockPos.Mutable var7,
      int var8,
      int var9,
      int var10,
      int var11,
      int var12,
      int var13,
      int var14,
      int var15,
      MutableBoolean var16
   ) {
      return method22615(this, var1, var3, var4, var5, var8, var9, var10, var11, var12, var13, var14, var15);
   }

   public static boolean method22615(
      Class7195<?> var0,
      IChunk var1,
      BitSet var2,
      Random var3,
      BlockPos.Mutable var4,
      int var5,
      int var6,
      int var7,
      int var8,
      int var9,
      int var10,
      int var11,
      int var12
   ) {
      if (var11 >= var5) {
         return false;
      } else {
         int var15 = var10 | var12 << 4 | var11 << 8;
         if (var2.get(var15)) {
            return false;
         } else {
            var2.set(var15);
            var4.setPos(var8, var11, var9);
            BlockState var16 = var1.getBlockState(var4);
            if (!var0.method22609(var16)) {
               return false;
            } else if (var11 == 10) {
               float var22 = var3.nextFloat();
               if (!((double)var22 < 0.25)) {
                  var1.setBlockState(var4, Blocks.OBSIDIAN.getDefaultState(), false);
               } else {
                  var1.setBlockState(var4, Blocks.field36890.getDefaultState(), false);
                  var1.getBlocksToBeTicked().scheduleTick(var4, Blocks.field36890, 0);
               }

               return true;
            } else if (var11 < 10) {
               var1.setBlockState(var4, Blocks.LAVA.getDefaultState(), false);
               return false;
            } else {
               boolean var17 = false;

               for (Direction var19 : Direction.Plane.HORIZONTAL) {
                  int var20 = var8 + var19.getXOffset();
                  int var21 = var9 + var19.getZOffset();
                  if (var20 >> 4 != var6 || var21 >> 4 != var7 || var1.getBlockState(var4.setPos(var20, var11, var21)).isAir()) {
                     var1.setBlockState(var4, field30895.getBlockState(), false);
                     var1.getFluidsToBeTicked().scheduleTick(var4, field30895.getFluid(), 0);
                     var17 = true;
                     break;
                  }
               }

               var4.setPos(var8, var11, var9);
               if (var17) {
                  return true;
               } else {
                  var1.setBlockState(var4, field30895.getBlockState(), false);
                  return true;
               }
            }
         }
      }
   }
}
