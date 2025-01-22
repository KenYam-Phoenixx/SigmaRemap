package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Random;

public class Class4211 extends Class4209 {
   private final boolean[] field20522 = new boolean[4];

   public Class4211(Random var1, int var2, int var3) {
      super(Class7792.field33462, var1, var2, 64, var3, 21, 15, 21);
   }

   public Class4211(TemplateManager var1, CompoundNBT var2) {
      super(Class7792.field33462, var2);
      this.field20522[0] = var2.getBoolean("hasPlacedChest0");
      this.field20522[1] = var2.getBoolean("hasPlacedChest1");
      this.field20522[2] = var2.getBoolean("hasPlacedChest2");
      this.field20522[3] = var2.getBoolean("hasPlacedChest3");
   }

   @Override
   public void method12897(CompoundNBT var1) {
      super.method12897(var1);
      var1.putBoolean("hasPlacedChest0", this.field20522[0]);
      var1.putBoolean("hasPlacedChest1", this.field20522[1]);
      var1.putBoolean("hasPlacedChest2", this.field20522[2]);
      var1.putBoolean("hasPlacedChest3", this.field20522[3]);
   }

   @Override
   public boolean method12896(ISeedReader var1, StructureManager var2, ChunkGenerator var3, Random var4, MutableBoundingBox var5, ChunkPos var6, BlockPos var7) {
      this.method12927(
         var1, var5, 0, -4, 0, this.field20516 - 1, 0, this.field20518 - 1, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false
      );

      for (int var10 = 1; var10 <= 9; var10++) {
         this.method12927(
            var1,
            var5,
            var10,
            var10,
            var10,
            this.field20516 - 1 - var10,
            var10,
            this.field20518 - 1 - var10,
            Blocks.SANDSTONE.getDefaultState(),
            Blocks.SANDSTONE.getDefaultState(),
            false
         );
         this.method12927(
            var1,
            var5,
            var10 + 1,
            var10,
            var10 + 1,
            this.field20516 - 2 - var10,
            var10,
            this.field20518 - 2 - var10,
            Blocks.AIR.getDefaultState(),
            Blocks.AIR.getDefaultState(),
            false
         );
      }

      for (int var18 = 0; var18 < this.field20516; var18++) {
         for (int var11 = 0; var11 < this.field20518; var11++) {
            byte var12 = -5;
            this.method12932(var1, Blocks.SANDSTONE.getDefaultState(), var18, -5, var11, var5);
         }
      }

      BlockState var19 = Blocks.SANDSTONE_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.NORTH);
      BlockState var20 = Blocks.SANDSTONE_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH);
      BlockState var21 = Blocks.SANDSTONE_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.EAST);
      BlockState var13 = Blocks.SANDSTONE_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.WEST);
      this.method12927(var1, var5, 0, 0, 0, 4, 9, 4, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
      this.method12927(var1, var5, 1, 10, 1, 3, 10, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
      this.method12923(var1, var19, 2, 10, 0, var5);
      this.method12923(var1, var20, 2, 10, 4, var5);
      this.method12923(var1, var21, 0, 10, 2, var5);
      this.method12923(var1, var13, 4, 10, 2, var5);
      this.method12927(
         var1, var5, this.field20516 - 5, 0, 0, this.field20516 - 1, 9, 4, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false
      );
      this.method12927(
         var1, var5, this.field20516 - 4, 10, 1, this.field20516 - 2, 10, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false
      );
      this.method12923(var1, var19, this.field20516 - 3, 10, 0, var5);
      this.method12923(var1, var20, this.field20516 - 3, 10, 4, var5);
      this.method12923(var1, var21, this.field20516 - 5, 10, 2, var5);
      this.method12923(var1, var13, this.field20516 - 1, 10, 2, var5);
      this.method12927(var1, var5, 8, 0, 0, 12, 4, 4, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
      this.method12927(var1, var5, 9, 1, 0, 11, 3, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
      this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), 9, 1, 1, var5);
      this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), 9, 2, 1, var5);
      this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), 9, 3, 1, var5);
      this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), 10, 3, 1, var5);
      this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), 11, 3, 1, var5);
      this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), 11, 2, 1, var5);
      this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), 11, 1, 1, var5);
      this.method12927(var1, var5, 4, 1, 1, 8, 3, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
      this.method12927(var1, var5, 4, 1, 2, 8, 2, 2, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
      this.method12927(var1, var5, 12, 1, 1, 16, 3, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
      this.method12927(var1, var5, 12, 1, 2, 16, 2, 2, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
      this.method12927(
         var1, var5, 5, 4, 5, this.field20516 - 6, 4, this.field20518 - 6, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false
      );
      this.method12927(var1, var5, 9, 4, 9, 11, 4, 11, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
      this.method12927(var1, var5, 8, 1, 8, 8, 3, 8, Blocks.CUT_SANDSTONE.getDefaultState(), Blocks.CUT_SANDSTONE.getDefaultState(), false);
      this.method12927(var1, var5, 12, 1, 8, 12, 3, 8, Blocks.CUT_SANDSTONE.getDefaultState(), Blocks.CUT_SANDSTONE.getDefaultState(), false);
      this.method12927(var1, var5, 8, 1, 12, 8, 3, 12, Blocks.CUT_SANDSTONE.getDefaultState(), Blocks.CUT_SANDSTONE.getDefaultState(), false);
      this.method12927(var1, var5, 12, 1, 12, 12, 3, 12, Blocks.CUT_SANDSTONE.getDefaultState(), Blocks.CUT_SANDSTONE.getDefaultState(), false);
      this.method12927(var1, var5, 1, 1, 5, 4, 4, 11, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
      this.method12927(
         var1, var5, this.field20516 - 5, 1, 5, this.field20516 - 2, 4, 11, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false
      );
      this.method12927(var1, var5, 6, 7, 9, 6, 7, 11, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
      this.method12927(
         var1, var5, this.field20516 - 7, 7, 9, this.field20516 - 7, 7, 11, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false
      );
      this.method12927(var1, var5, 5, 5, 9, 5, 7, 11, Blocks.CUT_SANDSTONE.getDefaultState(), Blocks.CUT_SANDSTONE.getDefaultState(), false);
      this.method12927(
         var1, var5, this.field20516 - 6, 5, 9, this.field20516 - 6, 7, 11, Blocks.CUT_SANDSTONE.getDefaultState(), Blocks.CUT_SANDSTONE.getDefaultState(), false
      );
      this.method12923(var1, Blocks.AIR.getDefaultState(), 5, 5, 10, var5);
      this.method12923(var1, Blocks.AIR.getDefaultState(), 5, 6, 10, var5);
      this.method12923(var1, Blocks.AIR.getDefaultState(), 6, 6, 10, var5);
      this.method12923(var1, Blocks.AIR.getDefaultState(), this.field20516 - 6, 5, 10, var5);
      this.method12923(var1, Blocks.AIR.getDefaultState(), this.field20516 - 6, 6, 10, var5);
      this.method12923(var1, Blocks.AIR.getDefaultState(), this.field20516 - 7, 6, 10, var5);
      this.method12927(var1, var5, 2, 4, 4, 2, 6, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
      this.method12927(
         var1, var5, this.field20516 - 3, 4, 4, this.field20516 - 3, 6, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false
      );
      this.method12923(var1, var19, 2, 4, 5, var5);
      this.method12923(var1, var19, 2, 3, 4, var5);
      this.method12923(var1, var19, this.field20516 - 3, 4, 5, var5);
      this.method12923(var1, var19, this.field20516 - 3, 3, 4, var5);
      this.method12927(var1, var5, 1, 1, 3, 2, 2, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
      this.method12927(
         var1, var5, this.field20516 - 3, 1, 3, this.field20516 - 2, 2, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false
      );
      this.method12923(var1, Blocks.SANDSTONE.getDefaultState(), 1, 1, 2, var5);
      this.method12923(var1, Blocks.SANDSTONE.getDefaultState(), this.field20516 - 2, 1, 2, var5);
      this.method12923(var1, Blocks.field36847.getDefaultState(), 1, 2, 2, var5);
      this.method12923(var1, Blocks.field36847.getDefaultState(), this.field20516 - 2, 2, 2, var5);
      this.method12923(var1, var13, 2, 1, 2, var5);
      this.method12923(var1, var21, this.field20516 - 3, 1, 2, var5);
      this.method12927(var1, var5, 4, 3, 5, 4, 3, 17, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
      this.method12927(
         var1, var5, this.field20516 - 5, 3, 5, this.field20516 - 5, 3, 17, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false
      );
      this.method12927(var1, var5, 3, 1, 5, 4, 2, 16, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
      this.method12927(
         var1, var5, this.field20516 - 6, 1, 5, this.field20516 - 5, 2, 16, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false
      );

      for (int var14 = 5; var14 <= 17; var14 += 2) {
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), 4, 1, var14, var5);
         this.method12923(var1, Blocks.CHISELED_SANDSTONE.getDefaultState(), 4, 2, var14, var5);
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), this.field20516 - 5, 1, var14, var5);
         this.method12923(var1, Blocks.CHISELED_SANDSTONE.getDefaultState(), this.field20516 - 5, 2, var14, var5);
      }

      this.method12923(var1, Blocks.field36731.getDefaultState(), 10, 0, 7, var5);
      this.method12923(var1, Blocks.field36731.getDefaultState(), 10, 0, 8, var5);
      this.method12923(var1, Blocks.field36731.getDefaultState(), 9, 0, 9, var5);
      this.method12923(var1, Blocks.field36731.getDefaultState(), 11, 0, 9, var5);
      this.method12923(var1, Blocks.field36731.getDefaultState(), 8, 0, 10, var5);
      this.method12923(var1, Blocks.field36731.getDefaultState(), 12, 0, 10, var5);
      this.method12923(var1, Blocks.field36731.getDefaultState(), 7, 0, 10, var5);
      this.method12923(var1, Blocks.field36731.getDefaultState(), 13, 0, 10, var5);
      this.method12923(var1, Blocks.field36731.getDefaultState(), 9, 0, 11, var5);
      this.method12923(var1, Blocks.field36731.getDefaultState(), 11, 0, 11, var5);
      this.method12923(var1, Blocks.field36731.getDefaultState(), 10, 0, 12, var5);
      this.method12923(var1, Blocks.field36731.getDefaultState(), 10, 0, 13, var5);
      this.method12923(var1, Blocks.field36741.getDefaultState(), 10, 0, 10, var5);

      for (int var22 = 0; var22 <= this.field20516 - 1; var22 += this.field20516 - 1) {
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var22, 2, 1, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var22, 2, 2, var5);
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var22, 2, 3, var5);
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var22, 3, 1, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var22, 3, 2, var5);
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var22, 3, 3, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var22, 4, 1, var5);
         this.method12923(var1, Blocks.CHISELED_SANDSTONE.getDefaultState(), var22, 4, 2, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var22, 4, 3, var5);
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var22, 5, 1, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var22, 5, 2, var5);
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var22, 5, 3, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var22, 6, 1, var5);
         this.method12923(var1, Blocks.CHISELED_SANDSTONE.getDefaultState(), var22, 6, 2, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var22, 6, 3, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var22, 7, 1, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var22, 7, 2, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var22, 7, 3, var5);
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var22, 8, 1, var5);
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var22, 8, 2, var5);
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var22, 8, 3, var5);
      }

      for (int var23 = 2; var23 <= this.field20516 - 3; var23 += this.field20516 - 3 - 2) {
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var23 - 1, 2, 0, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var23, 2, 0, var5);
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var23 + 1, 2, 0, var5);
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var23 - 1, 3, 0, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var23, 3, 0, var5);
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var23 + 1, 3, 0, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var23 - 1, 4, 0, var5);
         this.method12923(var1, Blocks.CHISELED_SANDSTONE.getDefaultState(), var23, 4, 0, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var23 + 1, 4, 0, var5);
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var23 - 1, 5, 0, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var23, 5, 0, var5);
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var23 + 1, 5, 0, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var23 - 1, 6, 0, var5);
         this.method12923(var1, Blocks.CHISELED_SANDSTONE.getDefaultState(), var23, 6, 0, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var23 + 1, 6, 0, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var23 - 1, 7, 0, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var23, 7, 0, var5);
         this.method12923(var1, Blocks.field36731.getDefaultState(), var23 + 1, 7, 0, var5);
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var23 - 1, 8, 0, var5);
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var23, 8, 0, var5);
         this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), var23 + 1, 8, 0, var5);
      }

      this.method12927(var1, var5, 8, 4, 0, 12, 6, 0, Blocks.CUT_SANDSTONE.getDefaultState(), Blocks.CUT_SANDSTONE.getDefaultState(), false);
      this.method12923(var1, Blocks.AIR.getDefaultState(), 8, 6, 0, var5);
      this.method12923(var1, Blocks.AIR.getDefaultState(), 12, 6, 0, var5);
      this.method12923(var1, Blocks.field36731.getDefaultState(), 9, 5, 0, var5);
      this.method12923(var1, Blocks.CHISELED_SANDSTONE.getDefaultState(), 10, 5, 0, var5);
      this.method12923(var1, Blocks.field36731.getDefaultState(), 11, 5, 0, var5);
      this.method12927(var1, var5, 8, -14, 8, 12, -11, 12, Blocks.CUT_SANDSTONE.getDefaultState(), Blocks.CUT_SANDSTONE.getDefaultState(), false);
      this.method12927(var1, var5, 8, -10, 8, 12, -10, 12, Blocks.CHISELED_SANDSTONE.getDefaultState(), Blocks.CHISELED_SANDSTONE.getDefaultState(), false);
      this.method12927(var1, var5, 8, -9, 8, 12, -9, 12, Blocks.CUT_SANDSTONE.getDefaultState(), Blocks.CUT_SANDSTONE.getDefaultState(), false);
      this.method12927(var1, var5, 8, -8, 8, 12, -1, 12, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
      this.method12927(var1, var5, 9, -11, 9, 11, -1, 11, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
      this.method12923(var1, Blocks.STONE_PRESSURE_PLATE.getDefaultState(), 10, -11, 10, var5);
      this.method12927(var1, var5, 9, -13, 9, 11, -13, 11, Blocks.TNT.getDefaultState(), Blocks.AIR.getDefaultState(), false);
      this.method12923(var1, Blocks.AIR.getDefaultState(), 8, -11, 10, var5);
      this.method12923(var1, Blocks.AIR.getDefaultState(), 8, -10, 10, var5);
      this.method12923(var1, Blocks.CHISELED_SANDSTONE.getDefaultState(), 7, -10, 10, var5);
      this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), 7, -11, 10, var5);
      this.method12923(var1, Blocks.AIR.getDefaultState(), 12, -11, 10, var5);
      this.method12923(var1, Blocks.AIR.getDefaultState(), 12, -10, 10, var5);
      this.method12923(var1, Blocks.CHISELED_SANDSTONE.getDefaultState(), 13, -10, 10, var5);
      this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), 13, -11, 10, var5);
      this.method12923(var1, Blocks.AIR.getDefaultState(), 10, -11, 8, var5);
      this.method12923(var1, Blocks.AIR.getDefaultState(), 10, -10, 8, var5);
      this.method12923(var1, Blocks.CHISELED_SANDSTONE.getDefaultState(), 10, -10, 7, var5);
      this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), 10, -11, 7, var5);
      this.method12923(var1, Blocks.AIR.getDefaultState(), 10, -11, 12, var5);
      this.method12923(var1, Blocks.AIR.getDefaultState(), 10, -10, 12, var5);
      this.method12923(var1, Blocks.CHISELED_SANDSTONE.getDefaultState(), 10, -10, 13, var5);
      this.method12923(var1, Blocks.CUT_SANDSTONE.getDefaultState(), 10, -11, 13, var5);

      for (Direction var15 : Direction.Plane.HORIZONTAL) {
         if (!this.field20522[var15.getHorizontalIndex()]) {
            int var16 = var15.getXOffset() * 2;
            int var17 = var15.getZOffset() * 2;
            this.field20522[var15.getHorizontalIndex()] = this.method12933(var1, var5, var4, 10 + var16, -11, 10 + var17, Class8793.field39558);
         }
      }

      return true;
   }
}
