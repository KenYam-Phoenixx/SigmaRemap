package com.mentalfrostbyte.jello.module.impl.world;

import com.mentalfrostbyte.Client;
import com.mentalfrostbyte.jello.event.EventTarget;
import com.mentalfrostbyte.jello.event.impl.EventKeyPress;
import com.mentalfrostbyte.jello.event.impl.EventUpdate;
import com.mentalfrostbyte.jello.event.impl.Render3DEvent;
import com.mentalfrostbyte.jello.module.Module;
import com.mentalfrostbyte.jello.module.ModuleCategory;
import com.mentalfrostbyte.jello.settings.*;
import com.mentalfrostbyte.jello.util.MultiUtilities;
import com.mentalfrostbyte.jello.util.world.BlockUtil;
import lol.ClientColors;
import mapped.*;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.network.play.client.CAnimateHandPacket;
import net.minecraft.network.play.client.CPlayerDiggingPacket;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameType;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class Nuker extends Module {
    private BlockPos field23566;
    private List<BlockPos> field23567;

    public Nuker() {
        super(ModuleCategory.WORLD, "Nuker", "Destroys blocks around you");
        this.registerSetting(
                new NumberSetting<Float>("Range", "Range value for nuker", 6.0F, Float.class, 2.0F, 10.0F, 1.0F));
        this.registerSetting(new ModeSetting("Mode", "Mode", 0, "All", "One hit", "Bed", "Egg"));
        this.registerSetting(new BooleanSetting("NoSwing", "Removes the swing animation.", false));
        this.registerSetting(new BooleanListSetting("Blocks", "Blocks to destroy", true));
        this.registerSetting(
                new ColorSetting("Color", "The rendered block color", ClientColors.MID_GREY.getColor, true));
    }

    public static void method16265(BlockPos var0) {
        mc.getConnection().sendPacket(
                new CPlayerDiggingPacket(CPlayerDiggingPacket.Action.START_DESTROY_BLOCK, var0, Direction.UP));
        mc.getConnection().sendPacket(
                new CPlayerDiggingPacket(CPlayerDiggingPacket.Action.STOP_DESTROY_BLOCK, var0, Direction.UP));
        mc.world.setBlockState(var0, Blocks.AIR.getDefaultState());
    }

    @EventTarget
    private void method16263(EventUpdate var1) {
        if (this.isEnabled() && var1.isPre()) {
            this.field23567 = this.method16267(this.getNumberValueBySettingName("Range") / 2.0F);
            if (this.field23567.isEmpty()) {
                this.field23566 = null;
            } else if (mc.playerController.getCurrentGameType() != GameType.CREATIVE) {
                if (this.field23566 != null) {
                    if (mc.world.getBlockState(this.field23566).isAir()
                            || Math.sqrt(
                                    mc.player
                                            .getDistanceNearest(
                                                    (double) this.field23566.getX() + 0.5,
                                                    (double) this.field23566.getY() + 0.5,
                                                    (double) this.field23566.getZ() + 0.5)) > 6.0) {
                        this.field23566 = this.field23567.get(0);
                    }

                    float[] var4 = RotationHelper.method34144(
                            (double) this.field23566.getX(), (double) this.field23566.getZ(),
                            (double) this.field23566.getY());
                    var1.setYaw(var4[0]);
                    var1.setPitch(var4[1]);
                    EventKeyPress var5 = new EventKeyPress(0, false, this.field23566);
                    Client.getInstance().eventManager.call(var5);
                    mc.playerController.onPlayerDamageBlock(this.field23566, BlockUtil.method34580(this.field23566));
                    if (!this.getBooleanValueFromSettingName("NoSwing")) {
                        mc.player.swingArm(Hand.MAIN_HAND);
                    } else {
                        mc.getConnection().sendPacket(new CAnimateHandPacket(Hand.MAIN_HAND));
                    }
                } else {
                    this.field23566 = this.field23567.get(0);
                    float[] var6 = RotationHelper.method34144(
                            (double) this.field23566.getX() + 0.5, (double) this.field23566.getZ(),
                            (double) this.field23566.getY() + 0.5);
                    var1.setYaw(var6[0]);
                    var1.setPitch(var6[1]);
                    EventKeyPress var8 = new EventKeyPress(0, false, this.field23566);
                    Client.getInstance().eventManager.call(var8);
                    mc.playerController.onPlayerDamageBlock(this.field23566, BlockUtil.method34580(this.field23566));
                    if (!this.getBooleanValueFromSettingName("NoSwing")) {
                        mc.player.swingArm(Hand.MAIN_HAND);
                    } else {
                        mc.getConnection().sendPacket(new CAnimateHandPacket(Hand.MAIN_HAND));
                    }
                }
            } else {
                for (BlockPos var9 : this.field23567) {
                    mc.getConnection().sendPacket(new CPlayerDiggingPacket(
                            CPlayerDiggingPacket.Action.START_DESTROY_BLOCK, var9, BlockUtil.method34580(var9)));
                    if (!this.getBooleanValueFromSettingName("NoSwing")) {
                        mc.player.swingArm(Hand.MAIN_HAND);
                    } else {
                        mc.getConnection().sendPacket(new CAnimateHandPacket(Hand.MAIN_HAND));
                    }
                }
            }
        }
    }

    @EventTarget
    public void method16264(Render3DEvent var1) {
        if (this.field23566 != null && !mc.world.getBlockState(this.field23566).isAir()) {
            int var4 = MultiUtilities.applyAlpha(this.parseSettingValueToIntBySettingName("Color"), 0.4F);
            GL11.glPushMatrix();
            GL11.glDisable(2929);
            double var5 = (double) this.field23566.getX() - mc.gameRenderer.getActiveRenderInfo().getPos().getX();
            double var7 = (double) this.field23566.getY() - mc.gameRenderer.getActiveRenderInfo().getPos().getY();
            double var9 = (double) this.field23566.getZ() - mc.gameRenderer.getActiveRenderInfo().getPos().getZ();
            AxisAlignedBB var11 = mc.world.getBlockState(this.field23566).method23414(mc.world, this.field23566)
                    .getBoundingBox();
            Box3D var12 = new Box3D(
                    var5 + var11.minX,
                    var7 + var11.minY,
                    var9 + var11.minZ,
                    var5 + var11.maxX,
                    var7 + var11.maxY,
                    var9 + var11.maxZ);
            RenderUtil.render3DColoredBox(var12, var4);
            GL11.glEnable(2929);
            GL11.glPopMatrix();
        }
    }

    private boolean method16266(BlockPos var1) {
        Block var4 = mc.world.getBlockState(var1).getBlock();
        return mc.world.getBlockState(var1).getMaterial().isReplaceable() || var4 instanceof BushBlock;
    }

    private List<BlockPos> method16267(float var1) {
        ArrayList var4 = new ArrayList();

        for (float var5 = var1 + 2.0F; var5 >= -var1 + 1.0F; var5--) {
            for (float var6 = -var1; var6 <= var1; var6++) {
                for (float var7 = -var1; var7 <= var1; var7++) {
                    BlockPos var8 = new BlockPos(
                            mc.player.getPosX() + (double) var6,
                            mc.player.getPosY() + (double) var5,
                            mc.player.getPosZ() + (double) var7);
                    if (!mc.world.getBlockState(var8).isAir()
                            && mc.world.getBlockState(var8).getFluidState().isEmpty()
                            && Math.sqrt(
                                    mc.player.getDistanceNearest((double) var8.getX() + 0.5, (double) var8.getY() + 0.5,
                                            (double) var8.getZ() + 0.5)) < (double) var1) {
                        String var9 = this.getStringSettingValueByName("Mode");
                        switch (var9) {
                            case "One hit":
                                if (!this.method16266(var8)) {
                                    continue;
                                }
                                break;
                            case "Bed":
                                if (!(mc.world.getBlockState(var8).getBlock() instanceof BedBlock)) {
                                    continue;
                                }
                                break;
                            case "Egg":
                                if (!(mc.world.getBlockState(var8).getBlock() instanceof Class3214)) {
                                    continue;
                                }
                        }

                        var4.add(var8);
                    }
                }
            }
        }

        return var4;
    }
}
