package net.minecraft.entity.item;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class LeashKnotEntity extends HangingEntity
{
    public LeashKnotEntity(EntityType <? extends LeashKnotEntity > p_i2437_1_, World p_i2437_2_)
    {
        super(p_i2437_1_, p_i2437_2_);
    }

    public LeashKnotEntity(World p_i2438_1_, BlockPos p_i2438_2_)
    {
        super(EntityType.LEASH_KNOT, p_i2438_1_, p_i2438_2_);
        this.setPosition((double)p_i2438_2_.getX() + 0.5D, (double)p_i2438_2_.getY() + 0.5D, (double)p_i2438_2_.getZ() + 0.5D);
        float f = 0.125F;
        float f1 = 0.1875F;
        float f2 = 0.25F;
        this.setBoundingBox(new AxisAlignedBB(this.getPosX() - 0.1875D, this.getPosY() - 0.25D + 0.125D, this.getPosZ() - 0.1875D, this.getPosX() + 0.1875D, this.getPosY() + 0.25D + 0.125D, this.getPosZ() + 0.1875D));
        this.forceSpawn = true;
    }

    public void setPosition(double x, double y, double z)
    {
        super.setPosition((double)MathHelper.floor(x) + 0.5D, (double)MathHelper.floor(y) + 0.5D, (double)MathHelper.floor(z) + 0.5D);
    }

    protected void updateBoundingBox()
    {
        this.setRawPosition((double)this.hangingPosition.getX() + 0.5D, (double)this.hangingPosition.getY() + 0.5D, (double)this.hangingPosition.getZ() + 0.5D);
    }

    public void updateFacingWithBoundingBox(Direction facingDirectionIn)
    {
    }

    public int getWidthPixels()
    {
        return 9;
    }

    public int getHeightPixels()
    {
        return 9;
    }

    protected float getEyeHeight(Pose poseIn, EntitySize sizeIn)
    {
        return -0.0625F;
    }

    public boolean isInRangeToRenderDist(double distance)
    {
        return distance < 1024.0D;
    }

    public void onBroken(@Nullable Entity brokenEntity)
    {
        this.playSound(SoundEvents.ENTITY_LEASH_KNOT_BREAK, 1.0F, 1.0F);
    }

    public void writeAdditional(CompoundNBT compound)
    {
    }

    public void readAdditional(CompoundNBT compound)
    {
    }

    public boolean processInitialInteract(PlayerEntity player, Hand hand)
    {
        if (this.world.isRemote)
        {
            return true;
        }
        else
        {
            boolean flag = false;
            double d0 = 7.0D;
            List<MobEntity> list = this.world.getEntitiesWithinAABB(MobEntity.class, new AxisAlignedBB(this.getPosX() - 7.0D, this.getPosY() - 7.0D, this.getPosZ() - 7.0D, this.getPosX() + 7.0D, this.getPosY() + 7.0D, this.getPosZ() + 7.0D));

            for (MobEntity mobentity : list)
            {
                if (mobentity.getLeashHolder() == player)
                {
                    mobentity.setLeashHolder(this, true);
                    flag = true;
                }
            }

            if (!flag)
            {
                this.remove();

                if (player.abilities.isCreativeMode)
                {
                    for (MobEntity mobentity1 : list)
                    {
                        if (mobentity1.getLeashed() && mobentity1.getLeashHolder() == this)
                        {
                            mobentity1.clearLeashed(true, false);
                        }
                    }
                }
            }

            return true;
        }
    }

    public boolean onValidSurface()
    {
        return this.world.getBlockState(this.hangingPosition).getBlock().isIn(BlockTags.FENCES);
    }

    public static LeashKnotEntity create(World p_213855_0_, BlockPos p_213855_1_)
    {
        int i = p_213855_1_.getX();
        int j = p_213855_1_.getY();
        int k = p_213855_1_.getZ();

        for (LeashKnotEntity leashknotentity : p_213855_0_.getEntitiesWithinAABB(LeashKnotEntity.class, new AxisAlignedBB((double)i - 1.0D, (double)j - 1.0D, (double)k - 1.0D, (double)i + 1.0D, (double)j + 1.0D, (double)k + 1.0D)))
        {
            if (leashknotentity.getHangingPosition().equals(p_213855_1_))
            {
                return leashknotentity;
            }
        }

        LeashKnotEntity leashknotentity1 = new LeashKnotEntity(p_213855_0_, p_213855_1_);
        p_213855_0_.addEntity(leashknotentity1);
        leashknotentity1.playPlaceSound();
        return leashknotentity1;
    }

    public void playPlaceSound()
    {
        this.playSound(SoundEvents.ENTITY_LEASH_KNOT_PLACE, 1.0F, 1.0F);
    }

    public IPacket<?> createSpawnPacket()
    {
        return new SSpawnObjectPacket(this, this.getType(), 0, this.getHangingPosition());
    }
}
