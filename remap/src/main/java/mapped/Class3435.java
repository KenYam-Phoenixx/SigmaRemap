// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

public class Class3435 extends Class3418
{
    private static String[] field16226;
    private final Class446 field16227;
    
    public Class3435(final int n, final Class464 class464) {
        this(n, class464, new Class443(27));
    }
    
    public Class3435(final int n, final Class464 class464, final Class446 field16227) {
        super(Class8471.field34774, n);
        Class3418.method10868(field16227, 27);
        (this.field16227 = field16227).method2241(class464.field2744);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.method10870(new Class6613(field16227, j + i * 9, 8 + j * 18, 18 + i * 18));
            }
        }
        for (int k = 0; k < 3; ++k) {
            for (int l = 0; l < 9; ++l) {
                this.method10870(new Class6601(class464, l + k * 9 + 9, 8 + l * 18, 84 + k * 18));
            }
        }
        for (int n2 = 0; n2 < 9; ++n2) {
            this.method10870(new Class6601(class464, n2, 8 + n2 * 18, 142));
        }
    }
    
    @Override
    public boolean method10854(final Class512 class512) {
        return this.field16227.method2162(class512);
    }
    
    @Override
    public ItemStack method10858(final Class512 class512, final int n) {
        ItemStack class513 = ItemStack.field34174;
        final Class6601 class514 = this.field16151.get(n);
        if (class514 != null) {
            if (class514.method20054()) {
                final ItemStack method20053 = class514.method20053();
                class513 = method20053.method27641();
                if (n >= this.field16227.method2239()) {
                    if (!this.method10888(method20053, 0, this.field16227.method2239(), false)) {
                        return ItemStack.field34174;
                    }
                }
                else if (!this.method10888(method20053, this.field16227.method2239(), this.field16151.size(), true)) {
                    return ItemStack.field34174;
                }
                if (!method20053.method27620()) {
                    class514.method20056();
                }
                else {
                    class514.method20055(ItemStack.field34174);
                }
            }
        }
        return class513;
    }
    
    @Override
    public void method10859(final Class512 class512) {
        super.method10859(class512);
        this.field16227.method2242(class512);
    }
}
