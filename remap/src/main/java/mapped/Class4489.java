// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.Direction;

import java.util.List;
import java.util.Random;

public class Class4489 extends Class4484
{
    private boolean field19882;
    
    public Class4489(final int n, final Random random, final MutableBoundingBox field19849, final Direction class179) {
        super(Class9520.field40958, n);
        this.method13456(class179);
        this.field19849 = field19849;
        this.field19882 = (random.nextInt(3) == 0);
    }
    
    public Class4489(final Class1795 class1795, final CompoundNBT class1796) {
        super(Class9520.field40958, class1796);
        this.field19882 = class1796.getBoolean("Chest");
    }
    
    @Override
    public void method13415(final CompoundNBT class51) {
        super.method13415(class51);
        class51.putBoolean("Chest", this.field19882);
    }
    
    @Override
    public void method13431(final Class4473 class4473, final List<Class4473> list, final Random random) {
        this.method13476((Class4494)class4473, list, random, 0, 1, true);
    }
    
    public static Class4489 method13482(final List<Class4473> list, final Random random, final int n, final int n2, final int n3, final Direction class179, final int n4) {
        final MutableBoundingBox method21408 = MutableBoundingBox.getComponentToAddBoundingBox(n, n2, n3, -1, 0, 0, 5, 7, 5, class179);
        return (Class4484.method13477(method21408) && Class4473.method13435(list, method21408) == null) ? new Class4489(n4, random, method21408, class179) : null;
    }
    
    @Override
    public boolean method13421(final Class1851 class1851, final Class6346<?> class1852, final Random random, final MutableBoundingBox class1853, final ChunkPos class1854) {
        this.method13444(class1851, class1853, 0, 0, 0, 4, 1, 4, Blocks.field29394.getDefaultState(), Blocks.field29394.getDefaultState(), false);
        this.method13444(class1851, class1853, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
        final BlockState class1855 = ((StateHolder<O, BlockState>)((StateHolder<O, BlockState>) Blocks.field29395.getDefaultState()).with((IProperty<Comparable>)Class3929.field17468, true)).with((IProperty<Comparable>)Class3929.field17466, true);
        final BlockState class1856 = ((StateHolder<O, BlockState>)((StateHolder<O, BlockState>) Blocks.field29395.getDefaultState()).with((IProperty<Comparable>)Class3929.field17465, true)).with((IProperty<Comparable>)Class3929.field17467, true);
        this.method13444(class1851, class1853, 0, 2, 0, 0, 5, 4, Blocks.field29394.getDefaultState(), Blocks.field29394.getDefaultState(), false);
        this.method13444(class1851, class1853, 0, 3, 1, 0, 4, 1, class1856, class1856, false);
        this.method13444(class1851, class1853, 0, 3, 3, 0, 4, 3, class1856, class1856, false);
        this.method13444(class1851, class1853, 4, 2, 0, 4, 5, 0, Blocks.field29394.getDefaultState(), Blocks.field29394.getDefaultState(), false);
        this.method13444(class1851, class1853, 1, 2, 4, 4, 5, 4, Blocks.field29394.getDefaultState(), Blocks.field29394.getDefaultState(), false);
        this.method13444(class1851, class1853, 1, 3, 4, 1, 4, 4, class1855, class1855, false);
        this.method13444(class1851, class1853, 3, 3, 4, 3, 4, 4, class1855, class1855, false);
        if (this.field19882) {
            if (class1853.isVecInside(new BlockPos(this.method13437(1, 3), this.method13438(2), this.method13439(1, 3)))) {
                this.field19882 = false;
                this.method13450(class1851, class1853, random, 1, 2, 3, Class9020.field38084);
            }
        }
        this.method13444(class1851, class1853, 0, 6, 0, 4, 6, 4, Blocks.field29394.getDefaultState(), Blocks.field29394.getDefaultState(), false);
        for (int i = 0; i <= 4; ++i) {
            for (int j = 0; j <= 4; ++j) {
                this.method13449(class1851, Blocks.field29394.getDefaultState(), i, -1, j, class1853);
            }
        }
        return true;
    }
}
