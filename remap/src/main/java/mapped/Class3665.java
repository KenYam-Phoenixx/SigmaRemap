// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class Class3665 extends Class3664
{
    public Class3665(final ResourceLocation class1932) {
        super(class1932, "", 3, 3, NonNullList.from(Ingredient.field374, Ingredient.method618(Items.field31369), Ingredient.method618(Items.field31369), Ingredient.method618(Items.field31369), Ingredient.method618(Items.field31369), Ingredient.method618(Items.field31425), Ingredient.method618(Items.field31369), Ingredient.method618(Items.field31369), Ingredient.method618(Items.field31369), Ingredient.method618(Items.field31369)), new ItemStack(Items.field31521));
    }
    
    @Override
    public boolean method11301(final Class473 class473, final World class474) {
        if (!super.method11301(class473, class474)) {
            return false;
        }
        ItemStack field34174 = ItemStack.EMPTY;
        for (int n = 0; n < class473.getSizeInventory() && field34174.method27620(); ++n) {
            final ItemStack method2157 = class473.getStackInSlot(n);
            if (method2157.getItem() == Items.field31425) {
                field34174 = method2157;
            }
        }
        if (!field34174.method27620()) {
            final Class6356 method2158 = Class4094.method12328(field34174, class474);
            return method2158 != null && !this.method11322(method2158) && method2158.field25425 < 4;
        }
        return false;
    }
    
    private boolean method11322(final Class6356 class6356) {
        if (class6356.field25431 != null) {
            for (final Class9323 class6357 : class6356.field25431.values()) {
                if (class6357.method34523() != Class2095.field12119 && class6357.method34523() != Class2095.field12120) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }
    
    @Override
    public ItemStack method11303(final Class473 class473) {
        ItemStack field34174 = ItemStack.EMPTY;
        for (int n = 0; n < class473.getSizeInventory() && field34174.method27620(); ++n) {
            final ItemStack method2157 = class473.getStackInSlot(n);
            if (method2157.getItem() == Items.field31425) {
                field34174 = method2157;
            }
        }
        final ItemStack method2158 = field34174.method27641();
        method2158.method27691(1);
        method2158.method27658().putInt("map_scale_direction", 1);
        return method2158;
    }
    
    @Override
    public boolean isDynamic() {
        return true;
    }
    
    @Override
    public IRecipeSerializer<?> getSerializer() {
        return IRecipeSerializer.field24738;
    }
}
