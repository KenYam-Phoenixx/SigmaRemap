package mapped;

import com.mentalfrostbyte.jello.module.Module;
import com.mentalfrostbyte.jello.module.ModuleCategory;

public class Class5312 extends Module {
    public Class5312(ModuleCategory var1, String var2, String var3) {
        super(var1, var2, var3);
    }

    @Override
    public void onEnable() {
        String var3 = "op " + mc.player.getName();
        var3.replace("&", "§");
        this.onDisable();
    }
}
