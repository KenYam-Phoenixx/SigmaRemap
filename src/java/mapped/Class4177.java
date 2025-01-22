package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;
import java.util.Random;

public class Class4177 extends Class4167 {
   private static String[] field20442;

   public Class4177(int var1, MutableBoundingBox var2, Direction var3) {
      super(Class7792.field33441, var1);
      this.method12939(var3);
      this.field20444 = var2;
   }

   public Class4177(TemplateManager var1, CompoundNBT var2) {
      super(Class7792.field33441, var2);
   }

   @Override
   public void method12894(Class4178 var1, List<Class4178> var2, Random var3) {
      this.method12901((Class4175)var1, var2, var3, 2, 0, false);
      this.method12902((Class4175)var1, var2, var3, 0, 2, false);
      this.method12903((Class4175)var1, var2, var3, 0, 2, false);
   }

   public static Class4177 method12913(List<Class4178> var0, int var1, int var2, int var3, Direction var4, int var5) {
      MutableBoundingBox var8 = MutableBoundingBox.method38388(var1, var2, var3, -2, 0, 0, 7, 9, 7, var4);
      return method12904(var8) && Class4178.method12918(var0, var8) == null ? new Class4177(var5, var8, var4) : null;
   }

   @Override
   public boolean method12896(ISeedReader var1, StructureManager var2, ChunkGenerator var3, Random var4, MutableBoundingBox var5, ChunkPos var6, BlockPos var7) {
      this.method12927(var1, var5, 0, 0, 0, 6, 1, 6, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
      this.method12927(var1, var5, 0, 2, 0, 6, 7, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
      this.method12927(var1, var5, 0, 2, 0, 1, 6, 0, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
      this.method12927(var1, var5, 0, 2, 6, 1, 6, 6, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
      this.method12927(var1, var5, 5, 2, 0, 6, 6, 0, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
      this.method12927(var1, var5, 5, 2, 6, 6, 6, 6, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
      this.method12927(var1, var5, 0, 2, 0, 0, 6, 1, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
      this.method12927(var1, var5, 0, 2, 5, 0, 6, 6, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
      this.method12927(var1, var5, 6, 2, 0, 6, 6, 1, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
      this.method12927(var1, var5, 6, 2, 5, 6, 6, 6, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
      BlockState var10 = Blocks.NETHER_BRICK_FENCE
         .getDefaultState()
         .with(FenceBlock.field18683, Boolean.valueOf(true))
         .with(FenceBlock.field18681, Boolean.valueOf(true));
      BlockState var11 = Blocks.NETHER_BRICK_FENCE
         .getDefaultState()
         .with(FenceBlock.field18680, Boolean.valueOf(true))
         .with(FenceBlock.field18682, Boolean.valueOf(true));
      this.method12927(var1, var5, 2, 6, 0, 4, 6, 0, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
      this.method12927(var1, var5, 2, 5, 0, 4, 5, 0, var10, var10, false);
      this.method12927(var1, var5, 2, 6, 6, 4, 6, 6, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
      this.method12927(var1, var5, 2, 5, 6, 4, 5, 6, var10, var10, false);
      this.method12927(var1, var5, 0, 6, 2, 0, 6, 4, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
      this.method12927(var1, var5, 0, 5, 2, 0, 5, 4, var11, var11, false);
      this.method12927(var1, var5, 6, 6, 2, 6, 6, 4, Blocks.NETHER_BRICKS.getDefaultState(), Blocks.NETHER_BRICKS.getDefaultState(), false);
      this.method12927(var1, var5, 6, 5, 2, 6, 5, 4, var11, var11, false);

      for (int var12 = 0; var12 <= 6; var12++) {
         for (int var13 = 0; var13 <= 6; var13++) {
            this.method12932(var1, Blocks.NETHER_BRICKS.getDefaultState(), var12, -1, var13, var5);
         }
      }

      return true;
   }
}
