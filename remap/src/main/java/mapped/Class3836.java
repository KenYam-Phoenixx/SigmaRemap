// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.util.Direction;

public class Class3836 extends Class3834
{
    private static String[] field17437;
    public static final Class7113 field17438;
    public static final Class7702 field17439;
    public static final Class7702 field17440;
    public static final Class7702 field17441;
    public static final Class7702 field17442;
    public static final Class7702 field17443;
    public static final Class7702 field17444;
    private final boolean field17445;
    
    public Class3836(final boolean field17445, final Class9288 class9288) {
        super(class9288);
        this.method11877(((Class7097<O, Class7096>)((Class7097<O, Class7096>)this.field17406.method32903()).method21773((Class7111<Comparable>)Class3836.field17415, Direction.NORTH)).method21773((Class7111<Comparable>)Class3836.field17438, false));
        this.field17445 = field17445;
    }
    
    @Override
    public boolean method11794(final Class7096 class7096, final Class1855 class7097, final BlockPos class7098) {
        return !class7096.method21772((Class7111<Boolean>)Class3836.field17438);
    }
    
    @Override
    public Class7702 method11808(final Class7096 class7096, final Class1855 class7097, final BlockPos class7098, final Class7543 class7099) {
        if (!class7096.method21772((Class7111<Boolean>)Class3836.field17438)) {
            return Class7698.method24487();
        }
        switch (Class8558.field35936[class7096.method21772((Class7111<Direction>)Class3836.field17415).ordinal()]) {
            case 1: {
                return Class3836.field17444;
            }
            default: {
                return Class3836.field17443;
            }
            case 3: {
                return Class3836.field17442;
            }
            case 4: {
                return Class3836.field17441;
            }
            case 5: {
                return Class3836.field17440;
            }
            case 6: {
                return Class3836.field17439;
            }
        }
    }
    
    @Override
    public boolean method11793(final Class7096 class7096, final Class1855 class7097, final BlockPos class7098) {
        return false;
    }
    
    @Override
    public void method11853(final Class1847 class1847, final BlockPos class1848, final Class7096 class1849, final Class511 class1850, final ItemStack class1851) {
        if (!class1847.field10067) {
            this.method11892(class1847, class1848, class1849);
        }
    }
    
    @Override
    public void method11825(final Class7096 class7096, final Class1847 class7097, final BlockPos class7098, final Class3833 class7099, final BlockPos class7100, final boolean b) {
        if (!class7097.field10067) {
            this.method11892(class7097, class7098, class7096);
        }
    }
    
    @Override
    public void method11828(final Class7096 class7096, final Class1847 class7097, final BlockPos class7098, final Class7096 class7099, final boolean b) {
        if (class7099.method21696() != class7096.method21696()) {
            if (!class7097.field10067) {
                if (class7097.method6727(class7098) == null) {
                    this.method11892(class7097, class7098, class7096);
                }
            }
        }
    }
    
    @Override
    public Class7096 method11846(final Class7074 class7074) {
        return ((Class7097<O, Class7096>)((Class7097<O, Class7096>)this.method11878()).method21773((Class7111<Comparable>)Class3836.field17415, class7074.method21642().getOpposite())).method21773((Class7111<Comparable>)Class3836.field17438, false);
    }
    
    private void method11892(final Class1847 class1847, final BlockPos class1848, final Class7096 class1849) {
        final Direction class1850 = class1849.method21772((Class7111<Direction>)Class3836.field17415);
        final boolean method11893 = this.method11893(class1847, class1848, class1850);
        if (method11893 && !class1849.method21772((Class7111<Boolean>)Class3836.field17438)) {
            if (new Class9236(class1847, class1848, class1850, true).method34052()) {
                class1847.method6763(class1848, this, 0, class1850.getIndex());
            }
        }
        else if (!method11893) {
            if (class1849.method21772((Class7111<Boolean>)Class3836.field17438)) {
                final BlockPos method11894 = class1848.method1150(class1850, 2);
                final Class7096 method11895 = class1847.method6701(method11894);
                int n = 1;
                Label_0143: {
                    if (method11895.method21696() == Class7521.field29264) {
                        if (((Class7097<Object, Object>)method11895).method21772((Class7111<Comparable>)Class3836.field17415) == class1850) {
                            final Class436 method11896 = class1847.method6727(method11894);
                            if (method11896 instanceof Class491) {
                                final Class491 class1851 = (Class491)method11896;
                                if (class1851.method2462()) {
                                    if (class1851.method2465(0.0f) >= 0.5f) {
                                        if (class1847.method6754() != class1851.method2484()) {
                                            if (!((Class1849)class1847).method6866()) {
                                                break Label_0143;
                                            }
                                        }
                                    }
                                    n = 2;
                                }
                            }
                        }
                    }
                }
                class1847.method6763(class1848, this, n, class1850.getIndex());
            }
        }
    }
    
    private boolean method11893(final Class1847 class1847, final BlockPos class1848, final Direction class1849) {
        for (final Direction class1850 : Direction.values()) {
            if (class1850 != class1849 && class1847.method6747(class1848.method1149(class1850), class1850)) {
                return true;
            }
        }
        if (!class1847.method6747(class1848, Direction.DOWN)) {
            final BlockPos method1137 = class1848.method1137();
            for (final Direction class1851 : Direction.values()) {
                if (class1851 != Direction.DOWN && class1847.method6747(method1137.method1149(class1851), class1851)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    @Override
    public boolean method11857(final Class7096 class7096, final Class1847 class7097, final BlockPos class7098, final int n, final int n2) {
        final Direction class7099 = class7096.method21772((Class7111<Direction>)Class3836.field17415);
        if (!class7097.field10067) {
            final boolean method11893 = this.method11893(class7097, class7098, class7099);
            if (method11893 && (n == 1 || n == 2)) {
                class7097.method6688(class7098, ((Class7097<O, Class7096>)class7096).method21773((Class7111<Comparable>)Class3836.field17438, true), 2);
                return false;
            }
            if (!method11893) {
                if (n == 0) {
                    return false;
                }
            }
        }
        if (n != 0) {
            if (n == 1 || n == 2) {
                final Class436 method11894 = class7097.method6727(class7098.method1149(class7099));
                if (method11894 instanceof Class491) {
                    ((Class491)method11894).method2482();
                }
                class7097.method6688(class7098, (Class7096)((Class7097<Object, Object>)((Class7097<Object, Object>)Class7521.field29264.method11878()).method21773((Class7111<Comparable>)Class3960.field17898, class7099)).method21773(Class3960.field17899, this.field17445 ? Class178.field508 : Class178.field507), 3);
                class7097.method6729(class7098, Class3960.method12080(((Class7097<O, Class7096>)this.method11878()).method21773((Class7111<Comparable>)Class3836.field17415, Direction.byIndex(n2 & 0x7)), class7099, false, true));
                if (!this.field17445) {
                    class7097.method6690(class7098.method1149(class7099), false);
                }
                else {
                    final BlockPos method11895 = class7098.method1134(class7099.getXOffset() * 2, class7099.getYOffset() * 2, class7099.getZOffset() * 2);
                    final Class7096 method11896 = class7097.method6701(method11895);
                    final Class3833 method11897 = method11896.method21696();
                    int n3 = 0;
                    if (method11897 == Class7521.field29264) {
                        final Class436 method11898 = class7097.method6727(method11895);
                        if (method11898 instanceof Class491) {
                            final Class491 class7100 = (Class491)method11898;
                            if (class7100.method2463() == class7099) {
                                if (class7100.method2462()) {
                                    class7100.method2482();
                                    n3 = 1;
                                }
                            }
                        }
                    }
                    Label_0392: {
                        if (n3 == 0) {
                            Label_0467: {
                                if (n == 1) {
                                    if (!method11896.method21706()) {
                                        if (method11894(method11896, class7097, method11895, class7099.getOpposite(), false, class7099)) {
                                            if (method11896.method21721() != Class2117.field12340) {
                                                if (method11897 != Class7521.field29246) {
                                                    if (method11897 != Class7521.field29239) {
                                                        break Label_0467;
                                                    }
                                                }
                                            }
                                            this.method11895(class7097, class7098, class7099, false);
                                            break Label_0392;
                                        }
                                    }
                                }
                            }
                            class7097.method6690(class7098.method1149(class7099), false);
                        }
                    }
                }
                class7097.method6705(null, class7098, Class8520.field35469, Class286.field1582, 0.5f, class7097.field10062.nextFloat() * 0.15f + 0.6f);
            }
        }
        else {
            if (!this.method11895(class7097, class7098, class7099, true)) {
                return false;
            }
            class7097.method6688(class7098, ((Class7097<O, Class7096>)class7096).method21773((Class7111<Comparable>)Class3836.field17438, true), 67);
            class7097.method6705(null, class7098, Class8520.field35470, Class286.field1582, 0.5f, class7097.field10062.nextFloat() * 0.25f + 0.6f);
        }
        return true;
    }
    
    public static boolean method11894(final Class7096 class7096, final Class1847 class7097, final BlockPos class7098, final Direction class7099, final boolean b, final Direction class7100) {
        final Class3833 method21696 = class7096.method21696();
        if (method21696 == Class7521.field29286) {
            return false;
        }
        if (!class7097.method6787().method34779(class7098)) {
            return false;
        }
        if (class7098.getY() < 0 || (class7099 == Direction.DOWN && class7098.getY() == 0)) {
            return false;
        }
        if (class7098.getY() <= class7097.method6986() - 1 && (class7099 != Direction.UP || class7098.getY() != class7097.method6986() - 1)) {
            if (method21696 != Class7521.field29246 && method21696 != Class7521.field29239) {
                if (class7096.method21718(class7097, class7098) == -1.0f) {
                    return false;
                }
                switch (Class8558.field35937[class7096.method21721().ordinal()]) {
                    case 1: {
                        return false;
                    }
                    case 2: {
                        return b;
                    }
                    case 3: {
                        return class7099 == class7100;
                    }
                }
            }
            else if (class7096.method21772((Class7111<Boolean>)Class3836.field17438)) {
                return false;
            }
            return !method21696.method11802();
        }
        return false;
    }
    
    private boolean method11895(final Class1847 class1847, final BlockPos class1848, final Direction class1849, final boolean b) {
        final BlockPos method1149 = class1848.method1149(class1849);
        if (!b) {
            if (class1847.method6701(method1149).method21696() == Class7521.field29247) {
                class1847.method6688(method1149, Class7521.field29147.method11878(), 20);
            }
        }
        final Class9236 class1850 = new Class9236(class1847, class1848, class1849, b);
        if (class1850.method34052()) {
            final HashMap hashMap = Maps.newHashMap();
            final List<BlockPos> method1150 = class1850.method34058();
            final ArrayList arrayList = Lists.newArrayList();
            for (int i = 0; i < method1150.size(); ++i) {
                final BlockPos class1851 = method1150.get(i);
                final Class7096 method1151 = class1847.method6701(class1851);
                arrayList.add(method1151);
                hashMap.put(class1851, method1151);
            }
            final List<BlockPos> method1152 = class1850.method34059();
            int n = method1150.size() + method1152.size();
            final Class7096[] array = new Class7096[n];
            final Direction class1852 = b ? class1849 : class1849.getOpposite();
            for (int j = method1152.size() - 1; j >= 0; --j) {
                final BlockPos class1853 = method1152.get(j);
                final Class7096 method1153 = class1847.method6701(class1853);
                Class3833.method11837(method1153, class1847, class1853, method1153.method21696().method11802() ? class1847.method6727(class1853) : null);
                class1847.method6688(class1853, Class7521.field29147.method11878(), 18);
                --n;
                array[n] = method1153;
            }
            for (int k = method1150.size() - 1; k >= 0; --k) {
                final BlockPos class1854 = method1150.get(k);
                final Class7096 method1154 = class1847.method6701(class1854);
                final BlockPos method1155 = class1854.method1149(class1852);
                hashMap.remove(method1155);
                class1847.method6688(method1155, ((Class7097<O, Class7096>)Class7521.field29264.method11878()).method21773((Class7111<Comparable>)Class3836.field17415, class1849), 68);
                class1847.method6729(method1155, Class3960.method12080((Class7096)arrayList.get(k), class1849, b, false));
                --n;
                array[n] = method1154;
            }
            if (b) {
                final Class7096 class1855 = ((Class7097<O, Class7096>)((Class7097<O, Class7096>)Class7521.field29247.method11878()).method21773((Class7111<Comparable>)Class3835.field17415, class1849)).method21773(Class3835.field17417, this.field17445 ? Class178.field508 : Class178.field507);
                final Class7096 class1856 = ((Class7097<O, Class7096>)((Class7097<O, Class7096>)Class7521.field29264.method11878()).method21773((Class7111<Comparable>)Class3960.field17898, class1849)).method21773(Class3960.field17899, this.field17445 ? Class178.field508 : Class178.field507);
                hashMap.remove(method1149);
                class1847.method6688(method1149, class1856, 68);
                class1847.method6729(method1149, Class3960.method12080(class1855, class1849, true, true));
            }
            final Class7096 method1156 = Class7521.field29147.method11878();
            final Iterator iterator = hashMap.keySet().iterator();
            while (iterator.hasNext()) {
                class1847.method6688((BlockPos)iterator.next(), method1156, 82);
            }
            for (final Map.Entry<BlockPos, V> entry : hashMap.entrySet()) {
                final BlockPos class1857 = entry.getKey();
                ((Class7096)entry.getValue()).method21736(class1847, class1857, 2);
                method1156.method21735(class1847, class1857, 2);
                method1156.method21736(class1847, class1857, 2);
            }
            for (int l = method1152.size() - 1; l >= 0; --l) {
                final Class7096 class1858 = array[n++];
                final BlockPos class1859 = method1152.get(l);
                class1858.method21736(class1847, class1859, 2);
                class1847.method6696(class1859, class1858.method21696());
            }
            for (int n2 = method1150.size() - 1; n2 >= 0; --n2) {
                class1847.method6696((BlockPos)method1150.get(n2), array[n++].method21696());
            }
            if (b) {
                class1847.method6696(method1149, Class7521.field29247);
            }
            return true;
        }
        return false;
    }
    
    @Override
    public Class7096 method11790(final Class7096 class7096, final Class2052 class7097) {
        return ((Class7097<O, Class7096>)class7096).method21773((Class7111<Comparable>)Class3836.field17415, class7097.method8142(class7096.method21772((Class7111<Direction>)Class3836.field17415)));
    }
    
    @Override
    public Class7096 method11791(final Class7096 class7096, final Class2181 class7097) {
        return class7096.method21708(class7097.method8344(class7096.method21772((Class7111<Direction>)Class3836.field17415)));
    }
    
    @Override
    public void method11875(final Class9500<Class3833, Class7096> class9500) {
        class9500.method35378(Class3836.field17415, Class3836.field17438);
    }
    
    @Override
    public boolean method11820(final Class7096 class7096) {
        return class7096.method21772((Class7111<Boolean>)Class3836.field17438);
    }
    
    @Override
    public boolean method11796(final Class7096 class7096, final Class1855 class7097, final BlockPos class7098, final Class2084 class7099) {
        return false;
    }
    
    static {
        field17438 = Class8970.field37725;
        field17439 = Class3833.method11778(0.0, 0.0, 0.0, 12.0, 16.0, 16.0);
        field17440 = Class3833.method11778(4.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        field17441 = Class3833.method11778(0.0, 0.0, 0.0, 16.0, 16.0, 12.0);
        field17442 = Class3833.method11778(0.0, 0.0, 4.0, 16.0, 16.0, 16.0);
        field17443 = Class3833.method11778(0.0, 0.0, 0.0, 16.0, 12.0, 16.0);
        field17444 = Class3833.method11778(0.0, 4.0, 0.0, 16.0, 16.0, 16.0);
    }
}
