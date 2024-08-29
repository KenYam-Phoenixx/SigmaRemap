package mapped;

import com.mentalfrostbyte.jello.event.EventTarget;
import com.mentalfrostbyte.jello.event.impl.TickEvent;
import com.mentalfrostbyte.jello.module.Module;
import com.mentalfrostbyte.jello.module.ModuleCategory;

public class Class5376 extends Module {
    public Class5376() {
        super(ModuleCategory.WORLD, "Timer", "Speeds up the world's timer");
        this.registerSetting(new NumberSetting<Float>("Timer", "Timer value", 0.1F, Float.class, 0.1F, 10.0F, 0.1F));
    }

    @EventTarget
    private void method16925(TickEvent var1) {
        if (this.isEnabled()) {
            mc.timer.field40360 = this.getNumberValueBySettingName("Timer");
        }
    }

    @Override
    public void method15965() {
        mc.timer.field40360 = 1.0F;
    }
}
