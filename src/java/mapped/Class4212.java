package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.properties.RedstoneSide;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Random;

public class Class4212 extends Class4209 {
   private boolean field20523;
   private boolean field20524;
   private boolean field20525;
   private boolean field20526;
   private static final Class8346 field20527 = new Class8346();

   public Class4212(Random var1, int var2, int var3) {
      super(Class7792.field33457, var1, var2, 64, var3, 12, 10, 15);
   }

   public Class4212(TemplateManager var1, CompoundNBT var2) {
      super(Class7792.field33457, var2);
      this.field20523 = var2.getBoolean("placedMainChest");
      this.field20524 = var2.getBoolean("placedHiddenChest");
      this.field20525 = var2.getBoolean("placedTrap1");
      this.field20526 = var2.getBoolean("placedTrap2");
   }

   @Override
   public void method12897(CompoundNBT var1) {
      super.method12897(var1);
      var1.putBoolean("placedMainChest", this.field20523);
      var1.putBoolean("placedHiddenChest", this.field20524);
      var1.putBoolean("placedTrap1", this.field20525);
      var1.putBoolean("placedTrap2", this.field20526);
   }

   @Override
   public boolean method12896(ISeedReader var1, StructureManager var2, ChunkGenerator var3, Random var4, MutableBoundingBox var5, ChunkPos var6, BlockPos var7) {
      if (!this.method13002(var1, var5, 0)) {
         return false;
      } else {
         this.method12928(var1, var5, 0, -4, 0, this.field20516 - 1, 0, this.field20518 - 1, false, var4, field20527);
         this.method12928(var1, var5, 2, 1, 2, 9, 2, 2, false, var4, field20527);
         this.method12928(var1, var5, 2, 1, 12, 9, 2, 12, false, var4, field20527);
         this.method12928(var1, var5, 2, 1, 3, 2, 2, 11, false, var4, field20527);
         this.method12928(var1, var5, 9, 1, 3, 9, 2, 11, false, var4, field20527);
         this.method12928(var1, var5, 1, 3, 1, 10, 6, 1, false, var4, field20527);
         this.method12928(var1, var5, 1, 3, 13, 10, 6, 13, false, var4, field20527);
         this.method12928(var1, var5, 1, 3, 2, 1, 6, 12, false, var4, field20527);
         this.method12928(var1, var5, 10, 3, 2, 10, 6, 12, false, var4, field20527);
         this.method12928(var1, var5, 2, 3, 2, 9, 3, 12, false, var4, field20527);
         this.method12928(var1, var5, 2, 6, 2, 9, 6, 12, false, var4, field20527);
         this.method12928(var1, var5, 3, 7, 3, 8, 7, 11, false, var4, field20527);
         this.method12928(var1, var5, 4, 8, 4, 7, 8, 10, false, var4, field20527);
         this.method12926(var1, var5, 3, 1, 3, 8, 2, 11);
         this.method12926(var1, var5, 4, 3, 6, 7, 3, 9);
         this.method12926(var1, var5, 2, 4, 2, 9, 5, 12);
         this.method12926(var1, var5, 4, 6, 5, 7, 6, 9);
         this.method12926(var1, var5, 5, 7, 6, 6, 7, 8);
         this.method12926(var1, var5, 5, 1, 2, 6, 2, 2);
         this.method12926(var1, var5, 5, 2, 12, 6, 2, 12);
         this.method12926(var1, var5, 5, 5, 1, 6, 5, 1);
         this.method12926(var1, var5, 5, 5, 13, 6, 5, 13);
         this.method12923(var1, Blocks.AIR.getDefaultState(), 1, 5, 5, var5);
         this.method12923(var1, Blocks.AIR.getDefaultState(), 10, 5, 5, var5);
         this.method12923(var1, Blocks.AIR.getDefaultState(), 1, 5, 9, var5);
         this.method12923(var1, Blocks.AIR.getDefaultState(), 10, 5, 9, var5);

         for (int var10 = 0; var10 <= 14; var10 += 14) {
            this.method12928(var1, var5, 2, 4, var10, 2, 5, var10, false, var4, field20527);
            this.method12928(var1, var5, 4, 4, var10, 4, 5, var10, false, var4, field20527);
            this.method12928(var1, var5, 7, 4, var10, 7, 5, var10, false, var4, field20527);
            this.method12928(var1, var5, 9, 4, var10, 9, 5, var10, false, var4, field20527);
         }

         this.method12928(var1, var5, 5, 6, 0, 6, 6, 0, false, var4, field20527);

         for (int var16 = 0; var16 <= 11; var16 += 11) {
            for (int var11 = 2; var11 <= 12; var11 += 2) {
               this.method12928(var1, var5, var16, 4, var11, var16, 5, var11, false, var4, field20527);
            }

            this.method12928(var1, var5, var16, 6, 5, var16, 6, 5, false, var4, field20527);
            this.method12928(var1, var5, var16, 6, 9, var16, 6, 9, false, var4, field20527);
         }

         this.method12928(var1, var5, 2, 7, 2, 2, 9, 2, false, var4, field20527);
         this.method12928(var1, var5, 9, 7, 2, 9, 9, 2, false, var4, field20527);
         this.method12928(var1, var5, 2, 7, 12, 2, 9, 12, false, var4, field20527);
         this.method12928(var1, var5, 9, 7, 12, 9, 9, 12, false, var4, field20527);
         this.method12928(var1, var5, 4, 9, 4, 4, 9, 4, false, var4, field20527);
         this.method12928(var1, var5, 7, 9, 4, 7, 9, 4, false, var4, field20527);
         this.method12928(var1, var5, 4, 9, 10, 4, 9, 10, false, var4, field20527);
         this.method12928(var1, var5, 7, 9, 10, 7, 9, 10, false, var4, field20527);
         this.method12928(var1, var5, 5, 9, 7, 6, 9, 7, false, var4, field20527);
         BlockState var17 = Blocks.COBBLESTONE_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.EAST);
         BlockState var18 = Blocks.COBBLESTONE_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.WEST);
         BlockState var12 = Blocks.COBBLESTONE_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH);
         BlockState var13 = Blocks.COBBLESTONE_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.NORTH);
         this.method12923(var1, var13, 5, 9, 6, var5);
         this.method12923(var1, var13, 6, 9, 6, var5);
         this.method12923(var1, var12, 5, 9, 8, var5);
         this.method12923(var1, var12, 6, 9, 8, var5);
         this.method12923(var1, var13, 4, 0, 0, var5);
         this.method12923(var1, var13, 5, 0, 0, var5);
         this.method12923(var1, var13, 6, 0, 0, var5);
         this.method12923(var1, var13, 7, 0, 0, var5);
         this.method12923(var1, var13, 4, 1, 8, var5);
         this.method12923(var1, var13, 4, 2, 9, var5);
         this.method12923(var1, var13, 4, 3, 10, var5);
         this.method12923(var1, var13, 7, 1, 8, var5);
         this.method12923(var1, var13, 7, 2, 9, var5);
         this.method12923(var1, var13, 7, 3, 10, var5);
         this.method12928(var1, var5, 4, 1, 9, 4, 1, 9, false, var4, field20527);
         this.method12928(var1, var5, 7, 1, 9, 7, 1, 9, false, var4, field20527);
         this.method12928(var1, var5, 4, 1, 10, 7, 2, 10, false, var4, field20527);
         this.method12928(var1, var5, 5, 4, 5, 6, 4, 5, false, var4, field20527);
         this.method12923(var1, var17, 4, 4, 5, var5);
         this.method12923(var1, var18, 7, 4, 5, var5);

         for (int var14 = 0; var14 < 4; var14++) {
            this.method12923(var1, var12, 5, 0 - var14, 6 + var14, var5);
            this.method12923(var1, var12, 6, 0 - var14, 6 + var14, var5);
            this.method12926(var1, var5, 5, 0 - var14, 7 + var14, 6, 0 - var14, 9 + var14);
         }

         this.method12926(var1, var5, 1, -3, 12, 10, -1, 13);
         this.method12926(var1, var5, 1, -3, 1, 3, -1, 13);
         this.method12926(var1, var5, 1, -3, 1, 9, -1, 5);

         for (int var19 = 1; var19 <= 13; var19 += 2) {
            this.method12928(var1, var5, 1, -3, var19, 1, -2, var19, false, var4, field20527);
         }

         for (int var20 = 2; var20 <= 12; var20 += 2) {
            this.method12928(var1, var5, 1, -1, var20, 3, -1, var20, false, var4, field20527);
         }

         this.method12928(var1, var5, 2, -2, 1, 5, -2, 1, false, var4, field20527);
         this.method12928(var1, var5, 7, -2, 1, 9, -2, 1, false, var4, field20527);
         this.method12928(var1, var5, 6, -3, 1, 6, -3, 1, false, var4, field20527);
         this.method12928(var1, var5, 6, -1, 1, 6, -1, 1, false, var4, field20527);
         this.method12923(
            var1,
            Blocks.TRIPWIRE_HOOK.getDefaultState().with(Class3459.field19281, Direction.EAST).with(Class3459.field19283, Boolean.valueOf(true)),
            1,
            -3,
            8,
            var5
         );
         this.method12923(
            var1,
            Blocks.TRIPWIRE_HOOK.getDefaultState().with(Class3459.field19281, Direction.WEST).with(Class3459.field19283, Boolean.valueOf(true)),
            4,
            -3,
            8,
            var5
         );
         this.method12923(
            var1,
            Blocks.TRIPWIRE
               .getDefaultState()
               .with(Class3425.field19167, Boolean.valueOf(true))
               .with(Class3425.field19169, Boolean.valueOf(true))
               .with(Class3425.field19164, Boolean.valueOf(true)),
            2,
            -3,
            8,
            var5
         );
         this.method12923(
            var1,
            Blocks.TRIPWIRE
               .getDefaultState()
               .with(Class3425.field19167, Boolean.valueOf(true))
               .with(Class3425.field19169, Boolean.valueOf(true))
               .with(Class3425.field19164, Boolean.valueOf(true)),
            3,
            -3,
            8,
            var5
         );
         BlockState var21 = Blocks.REDSTONE_WIRE
            .getDefaultState()
            .with(Class3222.field18647, RedstoneSide.field266)
            .with(Class3222.field18649, RedstoneSide.field266);
         this.method12923(var1, var21, 5, -3, 7, var5);
         this.method12923(var1, var21, 5, -3, 6, var5);
         this.method12923(var1, var21, 5, -3, 5, var5);
         this.method12923(var1, var21, 5, -3, 4, var5);
         this.method12923(var1, var21, 5, -3, 3, var5);
         this.method12923(var1, var21, 5, -3, 2, var5);
         this.method12923(
            var1,
            Blocks.REDSTONE_WIRE.getDefaultState().with(Class3222.field18647, RedstoneSide.field266).with(Class3222.field18650, RedstoneSide.field266),
            5,
            -3,
            1,
            var5
         );
         this.method12923(
            var1,
            Blocks.REDSTONE_WIRE.getDefaultState().with(Class3222.field18648, RedstoneSide.field266).with(Class3222.field18650, RedstoneSide.field266),
            4,
            -3,
            1,
            var5
         );
         this.method12923(var1, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 3, -3, 1, var5);
         if (!this.field20525) {
            this.field20525 = this.method12936(var1, var5, var4, 3, -2, 1, Direction.NORTH, Class8793.field39560);
         }

         this.method12923(var1, Blocks.VINE.getDefaultState().with(Class3402.field19067, Boolean.valueOf(true)), 3, -2, 2, var5);
         this.method12923(
            var1,
            Blocks.TRIPWIRE_HOOK.getDefaultState().with(Class3459.field19281, Direction.NORTH).with(Class3459.field19283, Boolean.valueOf(true)),
            7,
            -3,
            1,
            var5
         );
         this.method12923(
            var1,
            Blocks.TRIPWIRE_HOOK.getDefaultState().with(Class3459.field19281, Direction.SOUTH).with(Class3459.field19283, Boolean.valueOf(true)),
            7,
            -3,
            5,
            var5
         );
         this.method12923(
            var1,
            Blocks.TRIPWIRE
               .getDefaultState()
               .with(Class3425.field19166, Boolean.valueOf(true))
               .with(Class3425.field19168, Boolean.valueOf(true))
               .with(Class3425.field19164, Boolean.valueOf(true)),
            7,
            -3,
            2,
            var5
         );
         this.method12923(
            var1,
            Blocks.TRIPWIRE
               .getDefaultState()
               .with(Class3425.field19166, Boolean.valueOf(true))
               .with(Class3425.field19168, Boolean.valueOf(true))
               .with(Class3425.field19164, Boolean.valueOf(true)),
            7,
            -3,
            3,
            var5
         );
         this.method12923(
            var1,
            Blocks.TRIPWIRE
               .getDefaultState()
               .with(Class3425.field19166, Boolean.valueOf(true))
               .with(Class3425.field19168, Boolean.valueOf(true))
               .with(Class3425.field19164, Boolean.valueOf(true)),
            7,
            -3,
            4,
            var5
         );
         this.method12923(
            var1,
            Blocks.REDSTONE_WIRE.getDefaultState().with(Class3222.field18648, RedstoneSide.field266).with(Class3222.field18650, RedstoneSide.field266),
            8,
            -3,
            6,
            var5
         );
         this.method12923(
            var1,
            Blocks.REDSTONE_WIRE.getDefaultState().with(Class3222.field18650, RedstoneSide.field266).with(Class3222.field18649, RedstoneSide.field266),
            9,
            -3,
            6,
            var5
         );
         this.method12923(
            var1,
            Blocks.REDSTONE_WIRE.getDefaultState().with(Class3222.field18647, RedstoneSide.field266).with(Class3222.field18649, RedstoneSide.field265),
            9,
            -3,
            5,
            var5
         );
         this.method12923(var1, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 9, -3, 4, var5);
         this.method12923(var1, var21, 9, -2, 4, var5);
         if (!this.field20526) {
            this.field20526 = this.method12936(var1, var5, var4, 9, -2, 3, Direction.WEST, Class8793.field39560);
         }

         this.method12923(var1, Blocks.VINE.getDefaultState().with(Class3402.field19066, Boolean.valueOf(true)), 8, -1, 3, var5);
         this.method12923(var1, Blocks.VINE.getDefaultState().with(Class3402.field19066, Boolean.valueOf(true)), 8, -2, 3, var5);
         if (!this.field20523) {
            this.field20523 = this.method12933(var1, var5, var4, 8, -3, 3, Class8793.field39559);
         }

         this.method12923(var1, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 9, -3, 2, var5);
         this.method12923(var1, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 8, -3, 1, var5);
         this.method12923(var1, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 4, -3, 5, var5);
         this.method12923(var1, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 5, -2, 5, var5);
         this.method12923(var1, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 5, -1, 5, var5);
         this.method12923(var1, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 6, -3, 5, var5);
         this.method12923(var1, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 7, -2, 5, var5);
         this.method12923(var1, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 7, -1, 5, var5);
         this.method12923(var1, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 8, -3, 5, var5);
         this.method12928(var1, var5, 9, -1, 1, 9, -1, 5, false, var4, field20527);
         this.method12926(var1, var5, 8, -3, 8, 10, -1, 10);
         this.method12923(var1, Blocks.CHISELED_STONE_BRICKS.getDefaultState(), 8, -2, 11, var5);
         this.method12923(var1, Blocks.CHISELED_STONE_BRICKS.getDefaultState(), 9, -2, 11, var5);
         this.method12923(var1, Blocks.CHISELED_STONE_BRICKS.getDefaultState(), 10, -2, 11, var5);
         BlockState var15 = Blocks.LEVER
            .getDefaultState()
            .with(Class3201.HORIZONTAL_FACING, Direction.NORTH)
            .with(Class3201.field18500, AttachFace.field314);
         this.method12923(var1, var15, 8, -2, 12, var5);
         this.method12923(var1, var15, 9, -2, 12, var5);
         this.method12923(var1, var15, 10, -2, 12, var5);
         this.method12928(var1, var5, 8, -3, 8, 8, -3, 10, false, var4, field20527);
         this.method12928(var1, var5, 10, -3, 8, 10, -3, 10, false, var4, field20527);
         this.method12923(var1, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 10, -2, 9, var5);
         this.method12923(var1, var21, 8, -2, 9, var5);
         this.method12923(var1, var21, 8, -2, 10, var5);
         this.method12923(
            var1,
            Blocks.REDSTONE_WIRE
               .getDefaultState()
               .with(Class3222.field18647, RedstoneSide.field266)
               .with(Class3222.field18649, RedstoneSide.field266)
               .with(Class3222.field18648, RedstoneSide.field266)
               .with(Class3222.field18650, RedstoneSide.field266),
            10,
            -1,
            9,
            var5
         );
         this.method12923(var1, Blocks.STICKY_PISTON.getDefaultState().with(PistonBlock.field19198, Direction.UP), 9, -2, 8, var5);
         this.method12923(var1, Blocks.STICKY_PISTON.getDefaultState().with(PistonBlock.field19198, Direction.WEST), 10, -2, 8, var5);
         this.method12923(var1, Blocks.STICKY_PISTON.getDefaultState().with(PistonBlock.field19198, Direction.WEST), 10, -1, 8, var5);
         this.method12923(var1, Blocks.REPEATER.getDefaultState().with(RepeaterBlock.HORIZONTAL_FACING, Direction.NORTH), 10, -2, 10, var5);
         if (!this.field20524) {
            this.field20524 = this.method12933(var1, var5, var4, 9, -3, 10, Class8793.field39559);
         }

         return true;
      }
   }
}
