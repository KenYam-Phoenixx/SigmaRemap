// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Class8966 implements Class8967
{
    private static String[] field37673;
    private double field37674;
    private double field37675;
    private long field37676;
    public final /* synthetic */ Class4069 field37677;
    
    public Class8966(final Class4069 field37677) {
        this.field37677 = field37677;
    }
    
    @Override
    public float method31812(final ItemStack class8321, World field2391, final LivingEntity class8322) {
        final Entity class8323 = (class8322 != null) ? class8322 : class8321.method27679();
        if (field2391 == null) {
            if (class8323 != null) {
                field2391 = class8323.world;
            }
        }
        if (field2391 != null) {
            double random;
            if (!field2391.dimension.method20492()) {
                random = Math.random();
            }
            else {
                random = field2391.method6952(1.0f);
            }
            return (float)this.method31813(field2391, random);
        }
        return 0.0f;
    }
    
    private double method31813(final World class1847, final double n) {
        if (class1847.method6754() != this.field37676) {
            this.field37676 = class1847.method6754();
            this.field37675 += (MathHelper.method35666(n - this.field37674 + 0.5, 1.0) - 0.5) * 0.1;
            this.field37675 *= 0.9;
            this.field37674 = MathHelper.method35666(this.field37674 + this.field37675, 1.0);
        }
        return this.field37674;
    }
}
