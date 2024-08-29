package mapped;

import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class Class3219 extends Block implements Class3196 {
   private static String[] field18638;

   public Class3219(AbstractBlock var1) {
      super(var1);
   }

   private static boolean method11609(BlockState var0, Class1662 var1, BlockPos var2) {
      BlockPos var5 = var2.up();
      BlockState var6 = var1.getBlockState(var5);
      int var7 = Class200.method649(var1, var0, var2, var6, var5, Direction.field673, var6.getOpacity(var1, var5));
      return var7 < var1.method7033();
   }

   @Override
   public void method11484(BlockState var1, ServerWorld var2, BlockPos var3, Random var4) {
      if (!method11609(var1, var2, var3)) {
         var2.setBlockState(var3, Blocks.NETHERRACK.method11579());
      }
   }

   @Override
   public boolean method11486(Class1665 var1, BlockPos var2, BlockState var3, boolean var4) {
      return var1.getBlockState(var2.up()).isAir();
   }

   @Override
   public boolean method11487(World var1, Random var2, BlockPos var3, BlockState var4) {
      return true;
   }

   @Override
   public void method11488(ServerWorld var1, Random var2, BlockPos var3, BlockState var4) {
      BlockState var7 = var1.getBlockState(var3);
      BlockPos var8 = var3.up();
      if (!var7.method23448(Blocks.field37083)) {
         if (var7.method23448(Blocks.field37074)) {
            Class2946.method11288(var1, var2, var8, Class8529.field38323, 3, 1);
            Class2946.method11288(var1, var2, var8, Class8529.field38324, 3, 1);
            if (var2.nextInt(8) == 0) {
               Class2937.method11277(var1, var2, var8, 3, 1, 2);
            }
         }
      } else {
         Class2946.method11288(var1, var2, var8, Class8529.field38322, 3, 1);
      }
   }
}
