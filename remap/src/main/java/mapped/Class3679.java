// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class Class3679 implements Class3663
{
    private static String[] field16969;
    private final ResourceLocation field16970;
    private final String field16971;
    private final ItemStack field16972;
    private final NonNullList<Class120> field16973;
    
    public Class3679(final ResourceLocation field16970, final String field16971, final ItemStack field16972, final NonNullList<Class120> field16973) {
        this.field16970 = field16970;
        this.field16971 = field16971;
        this.field16972 = field16972;
        this.field16973 = field16973;
    }
    
    @Override
    public ResourceLocation method11298() {
        return this.field16970;
    }
    
    @Override
    public Class6096<?> method11299() {
        return Class6096.field24734;
    }
    
    @Override
    public String method11296() {
        return this.field16971;
    }
    
    @Override
    public ItemStack getRecipeOutput() {
        return this.field16972;
    }
    
    @Override
    public NonNullList<Class120> method11294() {
        return this.field16973;
    }
    
    public boolean method11301(final Class473 class473, final World class474) {
        final Class5024 class475 = new Class5024();
        int n = 0;
        for (int i = 0; i < class473.getSizeInventory(); ++i) {
            final ItemStack method2157 = class473.getStackInSlot(i);
            if (!method2157.method27620()) {
                ++n;
                class475.method15244(method2157, 1);
            }
        }
        return n == this.field16973.size() && class475.method15249(this, null);
    }
    
    public ItemStack method11303(final Class473 class473) {
        return this.field16972.method27641();
    }
    
    @Override
    public boolean canFit(final int n, final int n2) {
        return n * n2 >= this.field16973.size();
    }
}
