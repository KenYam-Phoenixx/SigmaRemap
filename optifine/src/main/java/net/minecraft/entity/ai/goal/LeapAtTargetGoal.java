package net.minecraft.entity.ai.goal;

import java.util.EnumSet;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.Vec3d;

public class LeapAtTargetGoal extends Goal
{
    private final MobEntity leaper;
    private LivingEntity leapTarget;
    private final float leapMotionY;

    public LeapAtTargetGoal(MobEntity p_i3162_1_, float p_i3162_2_)
    {
        this.leaper = p_i3162_1_;
        this.leapMotionY = p_i3162_2_;
        this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
    }

    public boolean shouldExecute()
    {
        if (this.leaper.isBeingRidden())
        {
            return false;
        }
        else
        {
            this.leapTarget = this.leaper.getAttackTarget();

            if (this.leapTarget == null)
            {
                return false;
            }
            else
            {
                double d0 = this.leaper.getDistanceSq(this.leapTarget);

                if (!(d0 < 4.0D) && !(d0 > 16.0D))
                {
                    if (!this.leaper.onGround)
                    {
                        return false;
                    }
                    else
                    {
                        return this.leaper.getRNG().nextInt(5) == 0;
                    }
                }
                else
                {
                    return false;
                }
            }
        }
    }

    public boolean shouldContinueExecuting()
    {
        return !this.leaper.onGround;
    }

    public void startExecuting()
    {
        Vec3d vec3d = this.leaper.getMotion();
        Vec3d vec3d1 = new Vec3d(this.leapTarget.getPosX() - this.leaper.getPosX(), 0.0D, this.leapTarget.getPosZ() - this.leaper.getPosZ());

        if (vec3d1.lengthSquared() > 1.0E-7D)
        {
            vec3d1 = vec3d1.normalize().scale(0.4D).add(vec3d.scale(0.2D));
        }

        this.leaper.setMotion(vec3d1.x, (double)this.leapMotionY, vec3d1.z);
    }
}
