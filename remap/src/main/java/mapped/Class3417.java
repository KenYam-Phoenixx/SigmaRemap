// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import net.minecraft.item.ItemStack;

public class Class3417 extends Class3418
{
    private final Class7318 field16145;
    private boolean field16146;
    private long field16147;
    public final IInventory field16148;
    private final Class470 field16149;
    
    public Class3417(final int n, final Class464 class464) {
        this(n, class464, Class7318.field28308);
    }
    
    public Class3417(final int n, final Class464 class464, final Class7318 field16145) {
        super(Class8471.field34776, n);
        this.field16148 = new Class481(this, 2);
        this.field16149 = new Class471(this);
        this.field16145 = field16145;
        this.method10870(new Class6630(this, this.field16148, 0, 15, 15));
        this.method10870(new Class6619(this, this.field16148, 1, 15, 52));
        this.method10870(new Class6628(this, this.field16149, 2, 145, 39, field16145));
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.method10870(new Class6601(class464, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int k = 0; k < 9; ++k) {
            this.method10870(new Class6601(class464, k, 8 + k * 18, 142));
        }
    }
    
    @Override
    public boolean method10854(final PlayerEntity playerEntity) {
        return Class3418.method10866(this.field16145, playerEntity, Blocks.CARTOGRAPHY_TABLE);
    }
    
    @Override
    public void method10855(final IInventory class446) {
        final ItemStack method2157 = this.field16148.getStackInSlot(0);
        final ItemStack method2158 = this.field16148.getStackInSlot(1);
        final ItemStack method2159 = this.field16149.getStackInSlot(2);
        if (!method2159.method27620() && (method2157.method27620() || method2158.method27620())) {
            this.field16149.method2159(2);
        }
        else if (!method2157.method27620()) {
            if (!method2158.method27620()) {
                this.method10856(method2157, method2158, method2159);
            }
        }
    }
    
    private void method10856(final ItemStack class8321, final ItemStack class8322, final ItemStack class8323) {
        this.field16145.method22437((class8327, p4) -> {
            class8324.method27622();
            Class4094.method12327(class8325, class8327);
            final Class6356 class8328;
            if (class8328 != null) {
                final ItemStack class8330;
                Label_0169_1: {
                    final Item class8329;
                    if (class8329 == Items.field31369) {
                        if (!class8328.field25427) {
                            if (class8328.field25425 < 4) {
                                class8325.method27641();
                                class8330.method27691(1);
                                class8330.method27658().putInt("map_scale_direction", 1);
                                this.method10876();
                                break Label_0169_1;
                            }
                        }
                    }
                    if (class8329 == Items.field30967 && !class8328.field25427) {
                        class8325.method27641();
                        class8330.method27691(1);
                        this.method10876();
                    }
                    else if (class8329 == Items.field31521) {
                        class8325.method27641();
                        class8330.method27691(2);
                        this.method10876();
                    }
                    else {
                        this.field16149.method2159(2);
                        this.method10876();
                        return;
                    }
                }
                if (!ItemStack.method27643(class8330, class8326)) {
                    this.field16149.method2160(2, class8330);
                    this.method10876();
                }
            }
        });
    }
    
    @Override
    public boolean method10857(final ItemStack class8321, final Class6601 class8322) {
        return class8322.field26173 != this.field16149 && super.method10857(class8321, class8322);
    }
    
    @Override
    public ItemStack method10858(final PlayerEntity playerEntity, final int n) {
        ItemStack class513 = ItemStack.EMPTY;
        final Class6601 class514 = this.field16151.get(n);
        if (class514 != null) {
            if (class514.method20054()) {
                ItemStack method20053;
                final ItemStack other = method20053 = class514.method20053();
                final Item method20054 = other.getItem();
                class513 = other.method27641();
                Label_0089: {
                    if (n != 2) {
                        if (n != 1 && n != 0) {
                            if (method20054 != Items.field31425) {
                                if (method20054 != Items.field31369) {
                                    if (method20054 != Items.field31521) {
                                        if (method20054 != Items.field30967) {
                                            if (n >= 3 && n < 30) {
                                                if (this.method10888(other, 30, 39, false)) {
                                                    break Label_0089;
                                                }
                                                return ItemStack.EMPTY;
                                            }
                                            else {
                                                if (n < 30) {
                                                    break Label_0089;
                                                }
                                                if (n >= 39) {
                                                    break Label_0089;
                                                }
                                                if (this.method10888(other, 3, 30, false)) {
                                                    break Label_0089;
                                                }
                                                return ItemStack.EMPTY;
                                            }
                                        }
                                    }
                                }
                                if (!this.method10888(other, 1, 2, false)) {
                                    return ItemStack.EMPTY;
                                }
                            }
                            else if (!this.method10888(other, 0, 1, false)) {
                                return ItemStack.EMPTY;
                            }
                        }
                        else if (!this.method10888(other, 3, 39, false)) {
                            return ItemStack.EMPTY;
                        }
                    }
                    else {
                        if (this.field16148.getStackInSlot(1).getItem() == Items.field30967) {
                            method20053 = this.field16145.method22435((class518, p2) -> {
                                Class4094.method12337(class518, this.field16148.getStackInSlot(0));
                                final ItemStack class519;
                                if (class519 == null) {
                                    return class516;
                                }
                                else {
                                    class519.method27691(1);
                                    return class519;
                                }
                            }).orElse(other);
                        }
                        method20054.method11723(method20053, playerEntity.world, playerEntity);
                        if (!this.method10888(method20053, 3, 39, true)) {
                            return ItemStack.EMPTY;
                        }
                        class514.method20049(method20053, class513);
                    }
                }
                if (method20053.method27620()) {
                    class514.method20055(ItemStack.EMPTY);
                }
                class514.method20056();
                if (method20053.method27690() == class513.method27690()) {
                    return ItemStack.EMPTY;
                }
                this.field16146 = true;
                class514.method20047(playerEntity, method20053);
                this.field16146 = false;
                this.method10876();
            }
        }
        return class513;
    }
    
    @Override
    public void method10859(final PlayerEntity playerEntity) {
        super.method10859(playerEntity);
        this.field16149.method2159(2);
        this.field16145.method22437((p1, p2) -> this.method10881(class513, class513.field2391, this.field16148));
    }
}
