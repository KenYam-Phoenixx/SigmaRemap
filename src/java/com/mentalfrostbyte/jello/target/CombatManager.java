package com.mentalfrostbyte.jello.target;

import com.mentalfrostbyte.jello.Client;
import com.mentalfrostbyte.jello.event.EventTarget;
import com.mentalfrostbyte.jello.event.impl.WorldLoadEvent;
import com.mentalfrostbyte.jello.event.impl.TickEvent;
import com.mentalfrostbyte.jello.event.priority.HigestPriority;
import mapped.Class5628;
import mapped.Class7249;
import mapped.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CombatManager {
    private static String[] field35945;
    public Class7249 field35946;
    public List<Entity> bots = new CopyOnWriteArrayList<Entity>();

    public void method29345() {
        Client.getInstance().getEventManager().register(this);
    }

    public boolean method29346(Entity var1) {
        return this.bots.contains(var1);
    }

    public void method29347() {
        this.bots.clear();
    }

    @EventTarget
    @HigestPriority
    private void method29348(WorldLoadEvent var1) {
        this.bots.clear();
    }

    @EventTarget
    @HigestPriority
    private void method29349(TickEvent var1) {
        if (this.field35946 != null) {
            for (PlayerEntity var5 : Class5628.method17680()) {
                if (!this.field35946.method22751(var5)) {
                    if (this.field35946.method22758(var5)) {
                        this.bots.remove(var5);
                    }
                } else if (!this.bots.contains(var5)) {
                    this.bots.add(var5);
                }
            }
        }
    }
}
