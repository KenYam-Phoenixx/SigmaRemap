// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import net.minecraft.util.Direction;

public final class Class6399 extends Class6397
{
    private static String[] field25517;
    
    @Override
    public ItemStack method19087(final Class5491 class5491, final ItemStack class5492) {
        this.field25515 = true;
        final Class1847 method16763 = class5491.method16763();
        final BlockPos method16764 = class5491.method16764().method1149(class5491.method16765().method21772((Class7111<Direction>)Class3955.field17859));
        if (!Class4088.method12322(class5492, method16763, method16764) && !Class4088.method12323(class5492, method16763, method16764, null)) {
            this.field25515 = false;
        }
        else if (!method16763.field10067) {
            method16763.method6955(2005, method16764, 0);
        }
        return class5492;
    }
}
