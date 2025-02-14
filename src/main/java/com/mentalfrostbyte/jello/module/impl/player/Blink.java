package com.mentalfrostbyte.jello.module.impl.player;

import com.mentalfrostbyte.jello.event.EventTarget;
import com.mentalfrostbyte.jello.event.impl.SendPacketEvent;
import com.mentalfrostbyte.jello.module.Module;
import com.mentalfrostbyte.jello.module.ModuleCategory;
import net.minecraft.client.entity.player.RemoteClientPlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.client.*;
import net.minecraft.util.math.vector.Vector3d;

import java.util.ArrayList;
import java.util.List;

public class Blink extends Module {
    public static RemoteClientPlayerEntity clientPlayerEntity;
    public float yaw;
    public float pitch;
    private final List<IPacket<?>> packets = new ArrayList<>();
    private Vector3d vector;

    // New boolean flag for controlling the blinking state
    private boolean isBlinking = false;

    public Blink() {
        super(ModuleCategory.PLAYER, "Blink", "Stops your packets to blink");
    }

    @Override
    public void onEnable() {
        this.vector = new Vector3d(mc.player.getPosX(), mc.player.getPosY(), mc.player.getPosZ());
        this.yaw = mc.player.rotationYaw;
        this.pitch = mc.player.rotationPitch;
        clientPlayerEntity = new RemoteClientPlayerEntity(mc.world, mc.player.getGameProfile());
        clientPlayerEntity.inventory = mc.player.inventory;
        clientPlayerEntity.setPositionAndRotation(this.vector.x, this.vector.y, this.vector.z, this.yaw, this.pitch);
        clientPlayerEntity.rotationYawHead = mc.player.rotationYawHead;
        mc.world.addEntity(-1, clientPlayerEntity);

        // Start blinking when enabled
        isBlinking = true;
    }

    @Override
    public void onDisable() {
        isBlinking = false;

        int packetAmount = this.packets.size();

        for (int i = 0; i < packetAmount; i++) {
            mc.getConnection().sendPacket(this.packets.get(i));
        }

        this.packets.clear();
        mc.world.removeEntityFromWorld(-1);
    }

    @EventTarget
    private void SendPacketEvent(SendPacketEvent event) {
        // Only handle packets when blinking is enabled
        if (isBlinking && this.isEnabled()) {
            if (mc.player != null && event.getPacket() instanceof CEntityActionPacket
                    || event.getPacket() instanceof CPlayerPacket
                    || event.getPacket() instanceof CUseEntityPacket
                    || event.getPacket() instanceof CAnimateHandPacket
                    || event.getPacket() instanceof CPlayerTryUseItemPacket) {
                this.packets.add(event.getPacket());
                event.setCancelled(true);
            }
        }
    }

    // Getter for the isBlinking flag
    public boolean isBlinking() {
        return isBlinking;
    }

    // Setter for the isBlinking flag
    public void setBlinking(boolean isBlinking) {
        this.isBlinking = isBlinking;
    }
}
