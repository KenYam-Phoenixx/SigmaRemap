// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import net.minecraft.item.ItemStack;

public class Class451 implements IInventory
{
    private static String[] field2696;
    private final IInventory field2697;
    private final IInventory field2698;
    
    public Class451(IInventory field2697, IInventory field2698) {
        if (field2697 == null) {
            field2697 = field2698;
        }
        if (field2698 == null) {
            field2698 = field2697;
        }
        this.field2697 = field2697;
        this.field2698 = field2698;
    }
    
    @Override
    public int getSizeInventory() {
        return this.field2697.getSizeInventory() + this.field2698.getSizeInventory();
    }
    
    @Override
    public boolean method2156() {
        return this.field2697.method2156() && this.field2698.method2156();
    }
    
    public boolean method2284(final IInventory class446) {
        return this.field2697 == class446 || this.field2698 == class446;
    }
    
    @Override
    public ItemStack getStackInSlot(final int n) {
        return (n < this.field2697.getSizeInventory()) ? this.field2697.getStackInSlot(n) : this.field2698.getStackInSlot(n - this.field2697.getSizeInventory());
    }
    
    @Override
    public ItemStack method2158(final int n, final int n2) {
        return (n < this.field2697.getSizeInventory()) ? this.field2697.method2158(n, n2) : this.field2698.method2158(n - this.field2697.getSizeInventory(), n2);
    }
    
    @Override
    public ItemStack method2159(final int n) {
        return (n < this.field2697.getSizeInventory()) ? this.field2697.method2159(n) : this.field2698.method2159(n - this.field2697.getSizeInventory());
    }
    
    @Override
    public void method2160(final int n, final ItemStack class8321) {
        if (n < this.field2697.getSizeInventory()) {
            this.field2697.method2160(n, class8321);
        }
        else {
            this.field2698.method2160(n - this.field2697.getSizeInventory(), class8321);
        }
    }
    
    @Override
    public int method2254() {
        return this.field2697.method2254();
    }
    
    @Override
    public void method2161() {
        this.field2697.method2161();
        this.field2698.method2161();
    }
    
    @Override
    public boolean method2162(final PlayerEntity playerEntity) {
        return this.field2697.method2162(playerEntity) && this.field2698.method2162(playerEntity);
    }
    
    @Override
    public void method2241(final PlayerEntity playerEntity) {
        this.field2697.method2241(playerEntity);
        this.field2698.method2241(playerEntity);
    }
    
    @Override
    public void method2242(final PlayerEntity playerEntity) {
        this.field2697.method2242(playerEntity);
        this.field2698.method2242(playerEntity);
    }
    
    @Override
    public boolean method2264(final int n, final ItemStack class8321) {
        return (n < this.field2697.getSizeInventory()) ? this.field2697.method2264(n, class8321) : this.field2698.method2264(n - this.field2697.getSizeInventory(), class8321);
    }
    
    @Override
    public void method2164() {
        this.field2697.method2164();
        this.field2698.method2164();
    }
}
