package com.mentalfrostbyte.jello.module.impl.render;

import com.mentalfrostbyte.Client;
import com.mentalfrostbyte.jello.event.EventTarget;
import com.mentalfrostbyte.jello.event.impl.Render3DEvent;
import com.mentalfrostbyte.jello.event.impl.TickEvent;
import com.mentalfrostbyte.jello.module.Module;
import com.mentalfrostbyte.jello.module.ModuleCategory;
import com.mentalfrostbyte.jello.notification.Notification;
import com.mentalfrostbyte.jello.unmapped.ResourceList;
import com.mentalfrostbyte.jello.util.MultiUtilities;
import com.mentalfrostbyte.jello.util.world.BlockUtil;
import com.mentalfrostbyte.jello.util.ClientColors;
import mapped.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import org.lwjgl.opengl.GL11;

public class PathFinder extends Module {
    public BlockRayTraceResult rayTraceResult;
    public Thread computationThread;
    public Class9823 pathfindingClass;

    public PathFinder() {
        super(ModuleCategory.RENDER, "PathFinder", "You know what it is");
    }

    @EventTarget
    public void onTick(TickEvent event) {
        this.rayTraceResult = BlockUtil.rayTrace(mc.player.rotationYaw, mc.player.rotationPitch, 200.0F);
        if (this.computationThread != null && this.pathfindingClass != null) {
            Client.getInstance()
                    .notificationManager
                    .send(new Notification("AutoMiner", "Computing... (" + this.pathfindingClass.field45900 + ")", ResourceList.directionIconPNG));
        }
    }

    @EventTarget
    public void onRender3D(Render3DEvent event) {
        if (this.isEnabled()) {
            if (this.rayTraceResult != null) {
                int color = MultiUtilities.applyAlpha(ClientColors.PALE_YELLOW.getColor, 0.14F);
                GL11.glPushMatrix();
                GL11.glDisable(GL11.GL_DEPTH_TEST);
                BlockPos pos = this.rayTraceResult.getPos();
                double x = pos.getX() - mc.gameRenderer.getActiveRenderInfo().getPos().getX();
                double y = pos.getY() - mc.gameRenderer.getActiveRenderInfo().getPos().getY();
                double z = pos.getZ() - mc.gameRenderer.getActiveRenderInfo().getPos().getZ();
                Box3D box = new Box3D(x, y, z, x + 1.0, y + 1.0, z + 1.0);
                RenderUtil.render3DColoredBox(box, color);
                GL11.glEnable(GL11.GL_DEPTH_TEST);
                GL11.glPopMatrix();
            }
        }
    }
}
