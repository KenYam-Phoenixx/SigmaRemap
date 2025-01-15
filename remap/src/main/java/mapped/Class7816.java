// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import net.minecraft.entity.Entity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Class7816 extends Class7814
{
    public List<Integer> field32021;
    public HashMap<Entity, Integer> field32022;
    public HashMap<Entity, ArrayList<Integer>> field32023;
    public int field32024;
    
    public Class7816() {
        super("Movement", "Detects bots based on movement patterns", Class304.field1771);
        this.field32021 = new CopyOnWriteArrayList<Integer>();
        this.field32022 = new HashMap<Entity, Integer>();
        this.field32023 = new HashMap<Entity, ArrayList<Integer>>();
        this.field32024 = 30;
    }
    
    @Override
    public boolean method25239(final Entity key) {
        return this.field32022.getOrDefault(key, 0) < this.field32024;
    }
    
    @Class6753
    private void method25251(final Class5743 class5743) {
        if (Class7816.field32015.field4684.field2424 < 10) {
            this.field32022.clear();
        }
        for (final Class512 class5744 : Class6430.method19108()) {
            if (class5744 != Class7816.field32015.field4684) {
                Label_0079: {
                    if (class5744 != null) {
                        if (Class6430.method19160(class5744, 0.01f)) {
                            if (!class5744.method1823()) {
                                if (class5744.method1732(Class7816.field32015.field4684) <= 5.0f) {
                                    if (class5744.field2395 != class5744.field2417) {
                                        break Label_0079;
                                    }
                                    if (class5744.field2397 != class5744.field2419) {
                                        break Label_0079;
                                    }
                                    if (class5744.field2396 != class5744.field2418) {
                                        break Label_0079;
                                    }
                                }
                                this.field32022.put(class5744, this.field32022.getOrDefault(class5744, 0) + 1);
                                continue;
                            }
                        }
                    }
                }
                if (this.field32022.getOrDefault(class5744, 0) >= this.field32024) {
                    continue;
                }
                this.field32022.put(class5744, 0);
            }
        }
    }
    
    @Class6753
    private void method25252(final Class5723 class5723) {
        if (Class7816.field32015.field4684 != null && this.field32022 != null) {
            if (Class7816.field32015.field4684.field2424 < 10) {
                this.field32022.clear();
            }
            if (class5723.method16998() instanceof Class4372) {
                final Class4372 class5724 = (Class4372)class5723.method16998();
                if (!(class5724.method13142(Class7816.field32015.field4683) instanceof Class512)) {
                    return;
                }
                final Entity method13142 = class5724.method13142(Class7816.field32015.field4683);
                final boolean method13143 = Class6430.method19160(method13142, 0.5f);
                final short method13144 = class5724.method13144();
                if (!this.field32023.containsKey(method13142)) {
                    this.field32023.put(method13142, new ArrayList<Integer>());
                }
                final ArrayList list = this.field32023.get(method13142);
                if (method13143) {
                    if (list.size() > 0) {
                        final int method13145 = this.method25253(list);
                        final int method13146 = this.method25254(list);
                        if (method13146 > 0) {
                            if (method13146 < 1300) {
                                if (method13145 < 3500) {
                                    if (method13145 > 2900) {
                                        this.field32022.put(method13142, this.field32022.getOrDefault(method13142, 0) + this.field32024);
                                    }
                                }
                            }
                        }
                    }
                    list.clear();
                    this.field32023.put(method13142, list);
                }
                if (list.size() > 0) {
                    if ((int)list.get(list.size() - 1) < 0) {
                        if (method13144 > 0) {
                            list.clear();
                        }
                    }
                }
                if (this.method25253(list) > 3600) {
                    list.clear();
                }
                if (list.size() == 0 || !method13143) {
                    if (method13144 != 0) {
                        list.add((int)method13144);
                    }
                }
                this.field32023.put(method13142, list);
            }
        }
    }
    
    public int method25253(final ArrayList<Integer> list) {
        int n = 0;
        for (final int intValue : list) {
            n += ((intValue <= 0) ? 0 : intValue);
        }
        return n;
    }
    
    public int method25254(final ArrayList<Integer> list) {
        int n = 0;
        final Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            n += iterator.next();
        }
        return n;
    }
    
    public boolean method25255(final Entity class399) {
        if (!Class7816.field32015.field4683.method6701(class399.method1894()).method21723()) {
            final AxisAlignedBB class400 = new AxisAlignedBB(class399.field2403.field25073, class399.field2403.field25074 - 0.5, class399.field2403.field25075, class399.field2403.field25076, class399.field2403.field25077, class399.field2403.field25078);
            for (final BlockPos class401 : method25256(class399)) {
                final Class7702 method21725 = Class7816.field32015.field4683.method6701(class401).method21725(Class7816.field32015.field4683, class401);
                if (!method21725.method24540() && class400.method18502(method21725.method24537().method18500(class401))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    
    public static List<BlockPos> method25256(final Entity class399) {
        final ArrayList list = new ArrayList();
        final int n = 1;
        for (float n2 = (float)(-n); n2 <= n; ++n2) {
            for (float n3 = (float)(-n); n3 <= n; ++n3) {
                list.add(new BlockPos(class399.field2395 + n2, class399.field2396 - 1.0, class399.field2397 + n3));
            }
        }
        return list;
    }
    
    @Override
    public boolean method25240(final Entity key) {
        return this.field32022.getOrDefault(key, 0) >= this.field32024;
    }
}
