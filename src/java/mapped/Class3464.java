package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class Class3464 extends Class3462 {
   private static String[] field19303;

   public Class3464(Properties var1) {
      super(var1);
   }

   @Override
   public ActionResultType onBlockActivated(BlockState var1, World var2, BlockPos var3, PlayerEntity var4, Hand var5, BlockRayTraceResult var6) {
      ItemStack var9 = var4.getHeldItem(var5);
      if (var9.getItem() != Items.field37956) {
         return super.onBlockActivated(var1, var2, var3, var4, var5, var6);
      } else {
         if (!var2.isRemote) {
            Direction var10 = var6.getFace();
            Direction var11 = var10.getAxis() != Direction.Axis.Y ? var10 : var4.getHorizontalFacing().getOpposite();
            var2.playSound((PlayerEntity)null, var3, SoundEvents.field26986, SoundCategory.field14732, 1.0F, 1.0F);
            var2.setBlockState(var3, Blocks.CARVED_PUMPKIN.getDefaultState().with(PumpkinBlock.field18848, var11), 11);
            ItemEntity var12 = new ItemEntity(
               var2,
               (double)var3.getX() + 0.5 + (double)var11.getXOffset() * 0.65,
               (double)var3.getY() + 0.1,
               (double)var3.getZ() + 0.5 + (double)var11.getZOffset() * 0.65,
               new ItemStack(Items.field37959, 4)
            );
            var12.setMotion(
               0.05 * (double)var11.getXOffset() + var2.rand.nextDouble() * 0.02,
               0.05,
               0.05 * (double)var11.getZOffset() + var2.rand.nextDouble() * 0.02
            );
            var2.addEntity(var12);
            var9.damageItem(1, var4, var1x -> var1x.sendBreakAnimation(var5));
         }

         return ActionResultType.method9002(var2.isRemote);
      }
   }

   @Override
   public Class3486 method12146() {
      return (Class3486) Blocks.PUMPKIN_STEM;
   }

   @Override
   public Class3493 method12147() {
      return (Class3493) Blocks.ATTACHED_PUMPKIN_STEM;
   }
}
