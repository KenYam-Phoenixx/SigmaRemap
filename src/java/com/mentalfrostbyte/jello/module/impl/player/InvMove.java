package com.mentalfrostbyte.jello.module.impl.player;

import com.mentalfrostbyte.Client;
import com.mentalfrostbyte.jello.event.EventTarget;
import com.mentalfrostbyte.jello.event.impl.EventKeyPress;
import com.mentalfrostbyte.jello.event.impl.SendPacketEvent;
import com.mentalfrostbyte.jello.event.impl.TickEvent;
import com.mentalfrostbyte.jello.event.impl.EventMove;
import com.mentalfrostbyte.jello.module.Module;
import com.mentalfrostbyte.jello.module.ModuleCategory;
import com.mentalfrostbyte.jello.module.settings.impl.BooleanSetting;
import mapped.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.AnvilScreen;
import net.minecraft.client.gui.screen.inventory.ChestScreen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.network.play.client.CEntityActionPacket;
import org.lwjgl.glfw.GLFW;

public class InvMove extends Module {
    private boolean field23757;

    public InvMove() {
        super(ModuleCategory.PLAYER, "InvMove", "Move freely in the inventory");
        this.registerSetting(new BooleanSetting("AACP", "Bypass for AACP", true));
        this.registerSetting(new BooleanSetting("Hypixel", "Bypass for Hypixel", false));
        this.field23757 = false;
    }

    @EventTarget
    private void method16583(EventKeyPress var1) {
        if (this.isEnabled()) {
            if (var1.getKey() == mc.gameSettings.keyBindInventory.keyCode.keyCode
                    && mc.player.isSprinting()) {
                mc.getConnection()
                        .sendPacket(new CEntityActionPacket(mc.player, CEntityActionPacket.Action.STOP_SPRINTING));
            }
        }
    }

    @EventTarget
    private void method16584(SendPacketEvent var1) {
        if (this.isEnabled()) {
            if (this.field23757 && var1.getPacket() instanceof CEntityActionPacket
                    && this.getBooleanValueFromSettingName("AACP")) {
                CEntityActionPacket var4 = (CEntityActionPacket) var1.getPacket();
                if (var4.getAction() == CEntityActionPacket.Action.START_SPRINTING) {
                    var1.setCancelled(true);
                }
            }
        }
    }

    @EventTarget
    private void method16585(TickEvent var1) {
        if (this.isEnabled()) {
            if (this.getBooleanValueFromSettingName("AACP")) {
                boolean var4 = !(mc.currentScreen instanceof InventoryScreen)
                        || !(mc.currentScreen instanceof ChestScreen);
                if (this.field23757 && !var4) {
                    this.field23757 = !this.field23757;
                    if (mc.player.isSprinting()) {
                        mc.getConnection().sendPacket(
                                new CEntityActionPacket(mc.player, CEntityActionPacket.Action.START_SPRINTING));
                    }
                } else if (!this.field23757 && var4) {
                    this.field23757 = !this.field23757;
                    if (mc.player.isSprinting()) {
                        mc.getConnection().sendPacket(
                                new CEntityActionPacket(mc.player, CEntityActionPacket.Action.STOP_SPRINTING));
                    }
                }
            }

            if (mc.currentScreen instanceof ContainerScreen
                    || Client.getInstance().getPlayerTracker().focusGameTicks() <= 1) {
                if (mc.currentScreen instanceof ChatScreen) {
                    return;
                }

                if (mc.currentScreen instanceof AnvilScreen) {
                    return;
                }

                if (mc.currentScreen instanceof Class1144) {
                    return;
                }

                if (mc.currentScreen instanceof CreativeScreen) {
                    CreativeScreen var9 = (CreativeScreen) mc.currentScreen;
                    if (var9.method2654() == 5) {
                        return;
                    }
                }

                if (Client.getInstance().guiManager.method33480() != null
                        && Client.getInstance().guiManager.method33480().method13227()) {
                    for (KeyBinding var14 : Minecraft.getInstance().gameSettings.field44658) {
                        var14.pressed = false;
                    }

                    return;
                }

                for (KeyBinding var7 : mc.gameSettings.field44658) {
                    if (var7.keyCode.keyCode > 0
                            && mc.gameSettings.keyBindSneak.keyCode.keyCode != var7.keyCode.keyCode
                            && var7.keyCode.keyCode > 4) {
                        int var8 = GLFW.glfwGetKey(mc.mainWindow.getHandle(), var7.keyCode.keyCode);
                        var7.pressed = var8 == 1;
                    }
                }
            }
        }
    }

    @EventTarget
    private void onMove(EventMove event) {
        if (this.isEnabled() && this.getBooleanValueFromSettingName("Hypixel")) {
            if (mc.currentScreen instanceof ContainerScreen ||
                    mc.currentScreen instanceof AnvilScreen ||
                    mc.currentScreen instanceof ChestScreen) {
                double baseSpeed = 0.7;
                event.setX(event.getX() * baseSpeed);
                event.setZ(event.getZ() * baseSpeed);
            }
        }
    }
}
