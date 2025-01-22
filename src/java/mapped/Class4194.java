package mapped;

import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public abstract class Class4194 extends Class4178 {
   public Class2213 field20495 = Class2213.field14470;

   public Class4194(Class7792 var1, int var2) {
      super(var1, var2);
   }

   public Class4194(Class7792 var1, CompoundNBT var2) {
      super(var1, var2);
      this.field20495 = Class2213.valueOf(var2.getString("EntryDoor"));
   }

   @Override
   public void method12897(CompoundNBT var1) {
      var1.putString("EntryDoor", this.field20495.name());
   }

   public void method12984(ISeedReader var1, Random var2, MutableBoundingBox var3, Class2213 var4, int var5, int var6, int var7) {
      switch (Class9295.field42739[var4.ordinal()]) {
         case 1:
            this.method12927(var1, var3, var5, var6, var7, var5 + 3 - 1, var6 + 3 - 1, var7, field20443, field20443, false);
            break;
         case 2:
            this.method12923(var1, Blocks.STONE_BRICKS.getDefaultState(), var5, var6, var7, var3);
            this.method12923(var1, Blocks.STONE_BRICKS.getDefaultState(), var5, var6 + 1, var7, var3);
            this.method12923(var1, Blocks.STONE_BRICKS.getDefaultState(), var5, var6 + 2, var7, var3);
            this.method12923(var1, Blocks.STONE_BRICKS.getDefaultState(), var5 + 1, var6 + 2, var7, var3);
            this.method12923(var1, Blocks.STONE_BRICKS.getDefaultState(), var5 + 2, var6 + 2, var7, var3);
            this.method12923(var1, Blocks.STONE_BRICKS.getDefaultState(), var5 + 2, var6 + 1, var7, var3);
            this.method12923(var1, Blocks.STONE_BRICKS.getDefaultState(), var5 + 2, var6, var7, var3);
            this.method12923(var1, Blocks.OAK_DOOR.getDefaultState(), var5 + 1, var6, var7, var3);
            this.method12923(var1, Blocks.OAK_DOOR.getDefaultState().with(DoorBlock.DOUBLE_BLOCK_HALF, DoubleBlockHalf.field209), var5 + 1, var6 + 1, var7, var3);
            break;
         case 3:
            this.method12923(var1, Blocks.field37012.getDefaultState(), var5 + 1, var6, var7, var3);
            this.method12923(var1, Blocks.field37012.getDefaultState(), var5 + 1, var6 + 1, var7, var3);
            this.method12923(var1, Blocks.IRON_BARS.getDefaultState().with(Class3237.field18683, Boolean.valueOf(true)), var5, var6, var7, var3);
            this.method12923(var1, Blocks.IRON_BARS.getDefaultState().with(Class3237.field18683, Boolean.valueOf(true)), var5, var6 + 1, var7, var3);
            this.method12923(
               var1,
               Blocks.IRON_BARS
                  .getDefaultState()
                  .with(Class3237.field18681, Boolean.valueOf(true))
                  .with(Class3237.field18683, Boolean.valueOf(true)),
               var5,
               var6 + 2,
               var7,
               var3
            );
            this.method12923(
               var1,
               Blocks.IRON_BARS
                  .getDefaultState()
                  .with(Class3237.field18681, Boolean.valueOf(true))
                  .with(Class3237.field18683, Boolean.valueOf(true)),
               var5 + 1,
               var6 + 2,
               var7,
               var3
            );
            this.method12923(
               var1,
               Blocks.IRON_BARS
                  .getDefaultState()
                  .with(Class3237.field18681, Boolean.valueOf(true))
                  .with(Class3237.field18683, Boolean.valueOf(true)),
               var5 + 2,
               var6 + 2,
               var7,
               var3
            );
            this.method12923(var1, Blocks.IRON_BARS.getDefaultState().with(Class3237.field18681, Boolean.valueOf(true)), var5 + 2, var6 + 1, var7, var3);
            this.method12923(var1, Blocks.IRON_BARS.getDefaultState().with(Class3237.field18681, Boolean.valueOf(true)), var5 + 2, var6, var7, var3);
            break;
         case 4:
            this.method12923(var1, Blocks.STONE_BRICKS.getDefaultState(), var5, var6, var7, var3);
            this.method12923(var1, Blocks.STONE_BRICKS.getDefaultState(), var5, var6 + 1, var7, var3);
            this.method12923(var1, Blocks.STONE_BRICKS.getDefaultState(), var5, var6 + 2, var7, var3);
            this.method12923(var1, Blocks.STONE_BRICKS.getDefaultState(), var5 + 1, var6 + 2, var7, var3);
            this.method12923(var1, Blocks.STONE_BRICKS.getDefaultState(), var5 + 2, var6 + 2, var7, var3);
            this.method12923(var1, Blocks.STONE_BRICKS.getDefaultState(), var5 + 2, var6 + 1, var7, var3);
            this.method12923(var1, Blocks.STONE_BRICKS.getDefaultState(), var5 + 2, var6, var7, var3);
            this.method12923(var1, Blocks.IRON_DOOR.getDefaultState(), var5 + 1, var6, var7, var3);
            this.method12923(var1, Blocks.IRON_DOOR.getDefaultState().with(DoorBlock.DOUBLE_BLOCK_HALF, DoubleBlockHalf.field209), var5 + 1, var6 + 1, var7, var3);
            this.method12923(var1, Blocks.STONE_BUTTON.getDefaultState().with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.NORTH), var5 + 2, var6 + 1, var7 + 1, var3);
            this.method12923(var1, Blocks.STONE_BUTTON.getDefaultState().with(AbstractButtonBlock.HORIZONTAL_FACING, Direction.SOUTH), var5 + 2, var6 + 1, var7 - 1, var3);
      }
   }

   public Class2213 method12985(Random var1) {
      int var4 = var1.nextInt(5);
      switch (var4) {
         case 0:
         case 1:
         default:
            return Class2213.field14470;
         case 2:
            return Class2213.field14471;
         case 3:
            return Class2213.field14472;
         case 4:
            return Class2213.field14473;
      }
   }

   @Nullable
   public Class4178 method12986(Class4196 var1, List<Class4178> var2, Random var3, int var4, int var5) {
      Direction var8 = this.method12938();
      if (var8 != null) {
         switch (Class9295.field42740[var8.ordinal()]) {
            case 1:
               return Class9331.method35290(
                  var1,
                  var2,
                  var3,
                  this.field20444.minX + var4,
                  this.field20444.minY + var5,
                  this.field20444.minZ - 1,
                  var8,
                  this.method12916()
               );
            case 2:
               return Class9331.method35290(
                  var1,
                  var2,
                  var3,
                  this.field20444.minX + var4,
                  this.field20444.minY + var5,
                  this.field20444.maxZ + 1,
                  var8,
                  this.method12916()
               );
            case 3:
               return Class9331.method35290(
                  var1,
                  var2,
                  var3,
                  this.field20444.minX - 1,
                  this.field20444.minY + var5,
                  this.field20444.minZ + var4,
                  var8,
                  this.method12916()
               );
            case 4:
               return Class9331.method35290(
                  var1,
                  var2,
                  var3,
                  this.field20444.maxX + 1,
                  this.field20444.minY + var5,
                  this.field20444.minZ + var4,
                  var8,
                  this.method12916()
               );
         }
      }

      return null;
   }

   @Nullable
   public Class4178 method12987(Class4196 var1, List<Class4178> var2, Random var3, int var4, int var5) {
      Direction var8 = this.method12938();
      if (var8 != null) {
         switch (Class9295.field42740[var8.ordinal()]) {
            case 1:
               return Class9331.method35290(
                  var1,
                  var2,
                  var3,
                  this.field20444.minX - 1,
                  this.field20444.minY + var4,
                  this.field20444.minZ + var5,
                  Direction.WEST,
                  this.method12916()
               );
            case 2:
               return Class9331.method35290(
                  var1,
                  var2,
                  var3,
                  this.field20444.minX - 1,
                  this.field20444.minY + var4,
                  this.field20444.minZ + var5,
                  Direction.WEST,
                  this.method12916()
               );
            case 3:
               return Class9331.method35290(
                  var1,
                  var2,
                  var3,
                  this.field20444.minX + var5,
                  this.field20444.minY + var4,
                  this.field20444.minZ - 1,
                  Direction.NORTH,
                  this.method12916()
               );
            case 4:
               return Class9331.method35290(
                  var1,
                  var2,
                  var3,
                  this.field20444.minX + var5,
                  this.field20444.minY + var4,
                  this.field20444.minZ - 1,
                  Direction.NORTH,
                  this.method12916()
               );
         }
      }

      return null;
   }

   @Nullable
   public Class4178 method12988(Class4196 var1, List<Class4178> var2, Random var3, int var4, int var5) {
      Direction var8 = this.method12938();
      if (var8 != null) {
         switch (Class9295.field42740[var8.ordinal()]) {
            case 1:
               return Class9331.method35290(
                  var1,
                  var2,
                  var3,
                  this.field20444.maxX + 1,
                  this.field20444.minY + var4,
                  this.field20444.minZ + var5,
                  Direction.EAST,
                  this.method12916()
               );
            case 2:
               return Class9331.method35290(
                  var1,
                  var2,
                  var3,
                  this.field20444.maxX + 1,
                  this.field20444.minY + var4,
                  this.field20444.minZ + var5,
                  Direction.EAST,
                  this.method12916()
               );
            case 3:
               return Class9331.method35290(
                  var1,
                  var2,
                  var3,
                  this.field20444.minX + var5,
                  this.field20444.minY + var4,
                  this.field20444.maxZ + 1,
                  Direction.SOUTH,
                  this.method12916()
               );
            case 4:
               return Class9331.method35290(
                  var1,
                  var2,
                  var3,
                  this.field20444.minX + var5,
                  this.field20444.minY + var4,
                  this.field20444.maxZ + 1,
                  Direction.SOUTH,
                  this.method12916()
               );
         }
      }

      return null;
   }

   public static boolean method12989(MutableBoundingBox var0) {
      return var0 != null && var0.minY > 10;
   }
}
