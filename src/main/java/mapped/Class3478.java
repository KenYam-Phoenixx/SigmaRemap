package mapped;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class Class3478 extends HorizontalBlock {
   private static final ITextComponent field19331 = new TranslationTextComponent("container.loom");

   public Class3478(Properties var1) {
      super(var1);
   }

   @Override
   public ActionResultType onBlockActivated(BlockState var1, World var2, BlockPos var3, PlayerEntity var4, Hand var5, BlockRayTraceResult var6) {
      if (!var2.isRemote) {
         var4.method2766(var1.method23445(var2, var3));
         var4.method2911(Stats.field40170);
         return ActionResultType.field14819;
      } else {
         return ActionResultType.SUCCESS;
      }
   }

   @Override
   public Class949 method11528(BlockState var1, World var2, BlockPos var3) {
      return new Class953((var2x, var3x, var4) -> new Class5837(var2x, var3x, IWorldPosCallable.method31714(var2, var3)), field19331);
   }

   @Override
   public BlockState getStateForPlacement(BlockItemUseContext var1) {
      return this.getDefaultState().with(HORIZONTAL_FACING, var1.getPlacementHorizontalFacing().getOpposite());
   }

   @Override
   public void fillStateContainer(StateContainer.Builder<Block, BlockState> var1) {
      var1.add(HORIZONTAL_FACING);
   }
}
