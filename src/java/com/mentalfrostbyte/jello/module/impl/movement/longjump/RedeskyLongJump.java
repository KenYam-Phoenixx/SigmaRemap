package com.mentalfrostbyte.jello.module.impl.movement.longjump;

import com.mentalfrostbyte.jello.event.EventTarget;
import com.mentalfrostbyte.jello.event.impl.EventUpdate;
import com.mentalfrostbyte.jello.event.impl.EventMove;
import com.mentalfrostbyte.jello.module.Module;
import com.mentalfrostbyte.jello.module.ModuleCategory;
import com.mentalfrostbyte.jello.module.settings.impl.BooleanSetting;
import com.mentalfrostbyte.jello.module.settings.impl.NumberSetting;
import com.mentalfrostbyte.jello.util.MultiUtilities;
import com.mentalfrostbyte.jello.util.player.MovementUtil;
import com.mentalfrostbyte.jello.util.world.BlockUtil;
import net.minecraft.util.math.BlockPos;

public class RedeskyLongJump extends Module {
    private int field23981;
    private double field23982;

    public RedeskyLongJump() {
        super(ModuleCategory.MOVEMENT, "Redesky", "Longjump for Redesky.");
        this.registerSetting(new NumberSetting<Float>("Boost", "Longjump boost", 1.0F, Float.class, 0.1F, 1.0F, 0.01F));
        this.registerSetting(new NumberSetting<Float>("Heigh", "Longjump heigh", 1.0F, Float.class, 0.1F, 1.0F, 0.01F));
        this.registerSetting(new BooleanSetting("NoFall", "Avoid taking fall damage", true));
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        this.field23981 = 0;
        this.field23982 = 0.0;
    }

    @EventTarget
    public void method16895(EventMove var1) {
        double var4 = Math.sqrt(var1.getX() * var1.getX() + var1.getZ() * var1.getZ());
        if (mc.player.onGround) {
            if (this.field23981 > 0) {
                this.field23981 = 0;
                if (this.access().getBooleanValueFromSettingName("Auto Disable")) {
                    this.access().toggle();
                    return;
                }
            } else {
                BlockPos var6 = new BlockPos(mc.player.getPosX(), mc.player.getPosY() - 0.4, mc.player.getPosZ());
                if (this.access().getBooleanValueFromSettingName("BorderJump") && !BlockUtil.method34578(var6) && MultiUtilities.method17686()
                        || this.access().getBooleanValueFromSettingName("Auto Jump") && MultiUtilities.method17686()
                        || var1.getY() == MovementUtil.getJumpValue()) {
                    this.field23981 = 1;
                    var1.setY(MovementUtil.getJumpValue());
                    MovementUtil.setSpeed(var1, 0.55);
                }
            }
        } else if (this.field23981 > 0) {
            this.field23981++;
            double var7 = var4;
            if (this.field23981 < 10) {
                switch (this.field23981) {
                    case 2:
                        var7 = 0.7;
                        break;
                    case 3:
                        var7 = 0.8;
                        break;
                    case 4:
                        var7 = 0.9;
                        break;
                    case 5:
                        var7 = 1.0;
                        break;
                    case 6:
                        var7 = 1.1;
                        break;
                    case 7:
                        var7 = 1.2;
                        break;
                    case 8:
                        var7 = 1.3;
                        break;
                    case 9:
                        var7 = 1.32;
                }

                MovementUtil.setSpeed(var1, (double) this.getNumberValueBySettingName("Boost") * var7);
                var1.setY((double) this.getNumberValueBySettingName("Heigh") * MovementUtil.getJumpValue());
                this.field23982 = 1.0;
            } else if (var1.getY() < 0.0 && mc.player.fallDistance < 3.0F) {
                this.field23982 = this.field23982 - var1.getY();
            }
        }

        MultiUtilities.setPlayerYMotion(var1.getY());
    }

    @EventTarget
    public void method16896(EventUpdate var1) {
        if (this.getBooleanValueFromSettingName("NoFall")) {
            if (this.field23982 > 3.0) {
                var1.setGround(true);
                this.field23982 = 0.0;
            }
        }
    }
}
