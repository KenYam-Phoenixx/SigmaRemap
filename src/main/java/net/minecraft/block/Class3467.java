package net.minecraft.block;

import mapped.BlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class Class3467 extends Block {
   private static String[] field19312;

   public Class3467(Properties var1) {
      super(var1);
   }

   @Override
   public boolean propagatesSkylightDown(BlockState var1, IBlockReader var2, BlockPos var3) {
      return true;
   }

   @Override
   public BlockRenderType method11526(BlockState var1) {
      return BlockRenderType.field9885;
   }

   @Override
   public float method11636(BlockState var1, IBlockReader var2, BlockPos var3) {
      return 1.0F;
   }
}
