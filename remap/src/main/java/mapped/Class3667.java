// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Class3667 extends Class3666
{
    public Class3667(final ResourceLocation class1932) {
        super(class1932);
    }
    
    public boolean method11301(final Class473 class473, final World class474) {
        ItemStack field34174 = ItemStack.EMPTY;
        ItemStack field34175 = ItemStack.EMPTY;
        for (int i = 0; i < class473.method2239(); ++i) {
            final ItemStack method2157 = class473.method2157(i);
            if (!method2157.method27620()) {
                if (!(method2157.getItem() instanceof Class4044)) {
                    if (method2157.getItem() != Items.field31583) {
                        return false;
                    }
                    if (!field34174.method27620()) {
                        return false;
                    }
                    if (method2157.method27660("BlockEntityTag") != null) {
                        return false;
                    }
                    field34174 = method2157;
                }
                else {
                    if (!field34175.method27620()) {
                        return false;
                    }
                    field34175 = method2157;
                }
            }
        }
        return !field34174.method27620() && !field34175.method27620();
    }
    
    public ItemStack method11303(final Class473 class473) {
        ItemStack field34174 = ItemStack.EMPTY;
        ItemStack class474 = ItemStack.EMPTY;
        for (int i = 0; i < class473.method2239(); ++i) {
            final ItemStack method2157 = class473.method2157(i);
            if (!method2157.method27620()) {
                if (!(method2157.getItem() instanceof Class4044)) {
                    if (method2157.getItem() == Items.field31583) {
                        class474 = method2157.method27641();
                    }
                }
                else {
                    field34174 = method2157;
                }
            }
        }
        if (!class474.method27620()) {
            final CompoundNBT method2158 = field34174.method27660("BlockEntityTag");
            final CompoundNBT class475 = (method2158 != null) ? method2158.copy() : new CompoundNBT();
            class475.putInt("Base", ((Class4044)field34174.getItem()).method12244().method813());
            class474.method27676("BlockEntityTag", class475);
            return class474;
        }
        return class474;
    }
    
    @Override
    public boolean method11291(final int n, final int n2) {
        return n * n2 >= 2;
    }
    
    @Override
    public Class6096<?> method11299() {
        return Class6096.field24744;
    }
}
