package mapped;

import net.minecraft.util.math.BlockPos;

import java.util.List;
import java.util.Random;

public class Class4229 extends Class4167 {
   private boolean field20560;

   public Class4229(int var1, Random var2, Class9764 var3, Direction var4) {
      super(Class7792.field33438, var1);
      this.method12939(var4);
      this.field20444 = var3;
      this.field20560 = var2.nextInt(3) == 0;
   }

   public Class4229(Class8761 var1, CompoundNBT var2) {
      super(Class7792.field33438, var2);
      this.field20560 = var2.method132("Chest");
   }

   @Override
   public void method12897(CompoundNBT var1) {
      super.method12897(var1);
      var1.method115("Chest", this.field20560);
   }

   @Override
   public void method12894(Class4178 var1, List<Class4178> var2, Random var3) {
      this.method12903((Class4175)var1, var2, var3, 0, 1, true);
   }

   public static Class4229 method13021(List<Class4178> var0, Random var1, int var2, int var3, int var4, Direction var5, int var6) {
      Class9764 var9 = Class9764.method38388(var2, var3, var4, -1, 0, 0, 5, 7, 5, var5);
      return method12904(var9) && Class4178.method12918(var0, var9) == null ? new Class4229(var6, var1, var9, var5) : null;
   }

   @Override
   public boolean method12896(Class1658 var1, Class7480 var2, ChunkGenerator var3, Random var4, Class9764 var5, Class7481 var6, BlockPos var7) {
      this.method12927(var1, var5, 0, 0, 0, 4, 1, 4, Blocks.NETHER_BRICKS.method11579(), Blocks.NETHER_BRICKS.method11579(), false);
      this.method12927(var1, var5, 0, 2, 0, 4, 5, 4, Blocks.AIR.method11579(), Blocks.AIR.method11579(), false);
      BlockState var10 = Blocks.NETHER_BRICK_FENCE
         .method11579()
         .method23465(Class3239.field18683, Boolean.valueOf(true))
         .method23465(Class3239.field18681, Boolean.valueOf(true));
      BlockState var11 = Blocks.NETHER_BRICK_FENCE
         .method11579()
         .method23465(Class3239.field18680, Boolean.valueOf(true))
         .method23465(Class3239.field18682, Boolean.valueOf(true));
      this.method12927(var1, var5, 0, 2, 0, 0, 5, 4, Blocks.NETHER_BRICKS.method11579(), Blocks.NETHER_BRICKS.method11579(), false);
      this.method12927(var1, var5, 0, 3, 1, 0, 4, 1, var11, var11, false);
      this.method12927(var1, var5, 0, 3, 3, 0, 4, 3, var11, var11, false);
      this.method12927(var1, var5, 4, 2, 0, 4, 5, 0, Blocks.NETHER_BRICKS.method11579(), Blocks.NETHER_BRICKS.method11579(), false);
      this.method12927(var1, var5, 1, 2, 4, 4, 5, 4, Blocks.NETHER_BRICKS.method11579(), Blocks.NETHER_BRICKS.method11579(), false);
      this.method12927(var1, var5, 1, 3, 4, 1, 4, 4, var10, var10, false);
      this.method12927(var1, var5, 3, 3, 4, 3, 4, 4, var10, var10, false);
      if (this.field20560 && var5.method38396(new BlockPos(this.method12920(1, 3), this.method12921(2), this.method12922(1, 3)))) {
         this.field20560 = false;
         this.method12933(var1, var5, var4, 1, 2, 3, Class8793.field39554);
      }

      this.method12927(var1, var5, 0, 6, 0, 4, 6, 4, Blocks.NETHER_BRICKS.method11579(), Blocks.NETHER_BRICKS.method11579(), false);

      for (int var12 = 0; var12 <= 4; var12++) {
         for (int var13 = 0; var13 <= 4; var13++) {
            this.method12932(var1, Blocks.NETHER_BRICKS.method11579(), var12, -1, var13, var5);
         }
      }

      return true;
   }
}
