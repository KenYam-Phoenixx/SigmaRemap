package mapped;

import com.mentalfrostbyte.jello.Client;
import com.mentalfrostbyte.jello.event.EventTarget;
import com.mentalfrostbyte.jello.event.impl.Class4424;
import com.mentalfrostbyte.jello.module.Module;
import com.mentalfrostbyte.jello.module.ModuleCategory;

public class Class5184 extends Module {
    public static Class5184 field23483;

    public Class5184() {
        super(ModuleCategory.RENDER, "XRay", "Shows ores");
        field23483 = this;
    }

    @Override
    public void isInDevelopment() {
        mc.worldRenderer.loadRenderers();
        Class5313 var3 = (Class5313) Client.getInstance().getModuleManager().getModuleByClass(Class5313.class);
        if (!var3.isEnabled()) {
            var3.setState(true);
        }
    }

    @Override
    public void method15965() {
        mc.worldRenderer.loadRenderers();
    }

    @EventTarget
    public void method16141(Class4424 var1) {
        if (this.isEnabled()) {
            Class7377 var4 = var1.method13970();
            if (!(var4.getBlock() instanceof Class3420) && var4.getBlock() != Blocks.field37121) {
                var1.method13900(true);
            } else {
                var1.method13972(true);
            }
        }
    }
}
