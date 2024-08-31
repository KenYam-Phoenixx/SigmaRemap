package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;

public class Class3214 extends Class3213 {
   private static String[] field18623;
   public static final VoxelShape field18624 = Block.method11539(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);

   public Class3214(AbstractBlock var1) {
      super(var1);
   }

   @Override
   public VoxelShape method11483(BlockState var1, Class1665 var2, BlockPos var3, ISelectionContext var4) {
      return field18624;
   }

   @Override
   public ActionResultType method11505(BlockState var1, World var2, BlockPos var3, PlayerEntity var4, Hand var5, BlockRayTraceResult var6) {
      this.method11603(var1, var2, var3);
      return ActionResultType.method9002(var2.isRemote);
   }

   @Override
   public void method11602(BlockState var1, World var2, BlockPos var3, PlayerEntity var4) {
      this.method11603(var1, var2, var3);
   }

   private void method11603(BlockState var1, World var2, BlockPos var3) {
      for (int var6 = 0; var6 < 1000; var6++) {
         BlockPos var7 = var3.method8336(
            var2.rand.nextInt(16) - var2.rand.nextInt(16),
            var2.rand.nextInt(8) - var2.rand.nextInt(8),
            var2.rand.nextInt(16) - var2.rand.nextInt(16)
         );
         if (var2.getBlockState(var7).isAir()) {
            if (!var2.isRemote) {
               var2.setBlockState(var7, var1, 2);
               var2.removeBlock(var3, false);
            } else {
               for (int var8 = 0; var8 < 128; var8++) {
                  double var9 = var2.rand.nextDouble();
                  float var11 = (var2.rand.nextFloat() - 0.5F) * 0.2F;
                  float var12 = (var2.rand.nextFloat() - 0.5F) * 0.2F;
                  float var13 = (var2.rand.nextFloat() - 0.5F) * 0.2F;
                  double var14 = MathHelper.method37822(var9, (double)var7.getX(), (double)var3.getX()) + (var2.rand.nextDouble() - 0.5) + 0.5;
                  double var16 = MathHelper.method37822(var9, (double)var7.getY(), (double)var3.getY()) + var2.rand.nextDouble() - 0.5;
                  double var18 = MathHelper.method37822(var9, (double)var7.getZ(), (double)var3.getZ()) + (var2.rand.nextDouble() - 0.5) + 0.5;
                  var2.method6746(ParticleTypes.field34090, var14, var16, var18, (double)var11, (double)var12, (double)var13);
               }
            }

            return;
         }
      }
   }

   @Override
   public int method11597() {
      return 5;
   }

   @Override
   public boolean method11494(BlockState var1, Class1665 var2, BlockPos var3, Class1947 var4) {
      return false;
   }
}
