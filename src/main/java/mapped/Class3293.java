package mapped;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;

import javax.annotation.Nullable;

public class Class3293 extends BlockItem {
   private static String[] field18802;

   public Class3293(Block var1, Properties var2) {
      super(var1, var2);
   }

   @Nullable
   @Override
   public BlockState method11838(BlockItemUseContext var1) {
      PlayerEntity var4 = var1.method18358();
      return var4 != null && !var4.canUseCommandBlock() ? null : super.method11838(var1);
   }
}
