package com.mentalfrostbyte.jello.module.impl.gui.jello;

import com.mentalfrostbyte.Client;
import com.mentalfrostbyte.jello.event.EventTarget;
import com.mentalfrostbyte.jello.event.impl.EventRender;
import com.mentalfrostbyte.jello.module.Module;
import com.mentalfrostbyte.jello.module.ModuleCategory;
import mapped.Class5968;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MusicParticles extends Module {
    public long field23676 = 0L;
    private final List<Class5968> field23677 = new ArrayList<Class5968>();

    public MusicParticles() {
        super(ModuleCategory.GUI, "MusicParticles", "Shows nice particles when music is playing");
        this.method16005(false);
    }

    // $VF: synthetic method
    public static Minecraft method16466() {
        return mc;
    }

    // $VF: synthetic method
    public static Minecraft method16467() {
        return mc;
    }

    // $VF: synthetic method
    public static Minecraft method16468() {
        return mc;
    }

    // $VF: synthetic method
    public static Minecraft method16469() {
        return mc;
    }

    // $VF: synthetic method
    public static Minecraft method16470() {
        return mc;
    }

    // $VF: synthetic method
    public static Minecraft method16471() {
        return mc;
    }

    @EventTarget
    private void method16463(EventRender var1) {
        if (this.isEnabled() && mc.player != null) {
            if (Client.getInstance().getMusicManager().method24319() && !Client.getInstance().getMusicManager().field32163.isEmpty()) {
                long var4 = System.nanoTime() - this.field23676;
                float var6 = Math.min(10.0F, Math.max(0.0F, (float) var4 / 1.810361E7F));
                double var7 = 0.0;
                double var9 = 4750;
                if (Client.getInstance().getMusicManager().field32165.isEmpty()) {
                    return;
                }

                for (int var10 = 0; var10 < 3; var10++) {
                    var7 = Math.max(var7, Math.sqrt(Client.getInstance().getMusicManager().field32165.get(var10)) - 1000.0);
                }

                float var14 = 0.7F + (float) (var7 / (double) (var9 - 1000)) * 8.14F;
                var14 *= var6;
                int var11 = 0;

                while (this.field23677.size() < 40) {
                    this.method16464();
                    if ((float) (var11++) > var14) {
                        break;
                    }
                }

                this.method16465(var14);

                for (Class5968 var13 : this.field23677) {
                    var13.method18498();
                }
            }

            this.field23676 = System.nanoTime();
        }
    }

    @Override
    public void onEnable() {
        this.field23676 = System.nanoTime();
    }

    private void method16464() {
        this.field23677.add(new Class5968());
    }

    private void method16465(float var1) {
        Iterator<Class5968> var4 = this.field23677.iterator();

        while (var4.hasNext()) {
            Class5968 var5 = (Class5968) var4.next();
            var5.method18497(var1);
            if (var5.method18499()) {
                var4.remove();
            }
        }
    }
}
