package mapped;

import net.minecraft.block.BannerBlock;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.Random;

public class Class3243 extends BannerBlock {
   private static String[] field18695;

   public Class3243(Properties var1) {
      super(var1);
   }

   @Override
   public TileEntity method11646(IBlockReader var1) {
      return new Class957();
   }

   @Override
   public void animateTick(BlockState var1, World var2, BlockPos var3, Random var4) {
      TileEntity var7 = var2.getTileEntity(var3);
      if (var7 instanceof Class957) {
         int var8 = ((Class957)var7).method3884();

         for (int var9 = 0; var9 < var8; var9++) {
            double var10 = (double)var3.getX() + var4.nextDouble();
            double var12 = (double)var3.getY() + var4.nextDouble();
            double var14 = (double)var3.getZ() + var4.nextDouble();
            double var16 = (var4.nextDouble() - 0.5) * 0.5;
            double var18 = (var4.nextDouble() - 0.5) * 0.5;
            double var20 = (var4.nextDouble() - 0.5) * 0.5;
            int var22 = var4.nextInt(2) * 2 - 1;
            if (!var4.nextBoolean()) {
               var10 = (double)var3.getX() + 0.5 + 0.25 * (double)var22;
               var16 = (double)(var4.nextFloat() * 2.0F * (float)var22);
            } else {
               var14 = (double)var3.getZ() + 0.5 + 0.25 * (double)var22;
               var20 = (double)(var4.nextFloat() * 2.0F * (float)var22);
            }

            var2.addParticle(ParticleTypes.field34090, var10, var12, var14, var16, var18, var20);
         }
      }
   }

   @Override
   public ItemStack getItem(IBlockReader var1, BlockPos var2, BlockState var3) {
      return ItemStack.EMPTY;
   }

   @Override
   public boolean method11650(BlockState var1, Fluid var2) {
      return false;
   }
}
