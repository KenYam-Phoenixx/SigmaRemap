package mapped;

import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;

public enum Class1666 implements Class1665 {
   field9078;

   private static final Class1666[] field9079 = new Class1666[]{field9078};

   @Nullable
   @Override
   public TileEntity getTileEntity(BlockPos var1) {
      return null;
   }

   @Override
   public BlockState getBlockState(BlockPos var1) {
      return Blocks.AIR.method11579();
   }

   @Override
   public FluidState getFluidState(BlockPos var1) {
      return Class9479.field44064.method25049();
   }
}
