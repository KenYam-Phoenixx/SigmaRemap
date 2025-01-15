package net.minecraft.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class LilyPadItem extends BlockItem
{
    public LilyPadItem(Block p_i3115_1_, Item.Properties p_i3115_2_)
    {
        super(p_i3115_1_, p_i3115_2_);
    }

    public ActionResultType onItemUse(ItemUseContext context)
    {
        return ActionResultType.PASS;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);

        if (raytraceresult.getType() == RayTraceResult.Type.MISS)
        {
            return ActionResult.resultPass(itemstack);
        }
        else
        {
            if (raytraceresult.getType() == RayTraceResult.Type.BLOCK)
            {
                BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult)raytraceresult;
                BlockPos blockpos = blockraytraceresult.getPos();
                Direction direction = blockraytraceresult.getFace();

                if (!worldIn.isBlockModifiable(playerIn, blockpos) || !playerIn.canPlayerEdit(blockpos.offset(direction), direction, itemstack))
                {
                    return ActionResult.resultFail(itemstack);
                }

                BlockPos blockpos1 = blockpos.up();
                BlockState blockstate = worldIn.getBlockState(blockpos);
                Material material = blockstate.getMaterial();
                IFluidState ifluidstate = worldIn.getFluidState(blockpos);

                if ((ifluidstate.getFluid() == Fluids.WATER || material == Material.ICE) && worldIn.isAirBlock(blockpos1))
                {
                    worldIn.setBlockState(blockpos1, Blocks.LILY_PAD.getDefaultState(), 11);

                    if (playerIn instanceof ServerPlayerEntity)
                    {
                        CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerIn, blockpos1, itemstack);
                    }

                    if (!playerIn.abilities.isCreativeMode)
                    {
                        itemstack.shrink(1);
                    }

                    playerIn.addStat(Stats.ITEM_USED.get(this));
                    worldIn.playSound(playerIn, blockpos, SoundEvents.BLOCK_LILY_PAD_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    return ActionResult.resultSuccess(itemstack);
                }
            }

            return ActionResult.resultFail(itemstack);
        }
    }
}
