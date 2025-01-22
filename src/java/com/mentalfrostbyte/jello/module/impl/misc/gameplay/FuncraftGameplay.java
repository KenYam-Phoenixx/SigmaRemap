package com.mentalfrostbyte.jello.module.impl.misc.gameplay;

import com.mentalfrostbyte.jello.event.EventTarget;
import com.mentalfrostbyte.jello.event.impl.ReceivePacketEvent;
import com.mentalfrostbyte.jello.module.Module;
import com.mentalfrostbyte.jello.module.ModuleCategory;
import com.mentalfrostbyte.jello.module.impl.misc.GamePlay;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SChatPacket;

public class FuncraftGameplay extends Module {
    private GamePlay field23579;

    public FuncraftGameplay() {
        super(ModuleCategory.MISC, "Funcraft", "Gameplay for Funcraft");
    }

    @Override
    public void initialize() {
        this.field23579 = (GamePlay) this.access();
    }

    @EventTarget
    private void method16295(ReceivePacketEvent var1) {
        if (this.isEnabled() && mc.player != null) {
            IPacket var4 = var1.getPacket();
            if (var4 instanceof SChatPacket) {
                SChatPacket var5 = (SChatPacket) var4;
                String var6 = var5.getChatComponent().getString();
                String var7 = mc.player.getName().getString().toLowerCase();
                if (this.field23579.getBooleanValueFromSettingName("AutoL")
                        && (var6.toLowerCase().contains("a été tué par " + var7) || var6.toLowerCase().contains("a été tué par le vide et " + var7))) {
                    this.field23579.processAutoLMessage(var6);
                }
            }
        }
    }
}
