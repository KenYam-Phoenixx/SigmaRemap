package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.IBlockDisplayReader;

public final class Class7446 implements Class7443 {
   private static String[] field32020;

   @Override
   public int method24053(BlockState var1, IBlockDisplayReader var2, BlockPos var3) {
      return Class9680.method37904() == null ? FoliageColors.method36294() : Class9680.method37904().method24069(var2, var3);
   }

   @Override
   public boolean method24054() {
      return Class9680.method37904() == null;
   }
}
