package net.minecraft.inventory.container;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.world.World;

public class GrindstoneContainer extends Container
{
    private final IInventory outputInventory = new CraftResultInventory();
    private final IInventory inputInventory = new Inventory(2)
    {
        public void markDirty()
        {
            super.markDirty();
            GrindstoneContainer.this.onCraftMatrixChanged(this);
        }
    };
    private final IWorldPosCallable worldPosCallable;

    public GrindstoneContainer(int p_i1409_1_, PlayerInventory p_i1409_2_)
    {
        this(p_i1409_1_, p_i1409_2_, IWorldPosCallable.DUMMY);
    }

    public GrindstoneContainer(int p_i1410_1_, PlayerInventory p_i1410_2_, final IWorldPosCallable p_i1410_3_)
    {
        super(ContainerType.GRINDSTONE, p_i1410_1_);
        this.worldPosCallable = p_i1410_3_;
        this.addSlot(new Slot(this.inputInventory, 0, 49, 19)
        {
            public boolean isItemValid(ItemStack stack)
            {
                return stack.isDamageable() || stack.getItem() == Items.ENCHANTED_BOOK || stack.isEnchanted();
            }
        });
        this.addSlot(new Slot(this.inputInventory, 1, 49, 40)
        {
            public boolean isItemValid(ItemStack stack)
            {
                return stack.isDamageable() || stack.getItem() == Items.ENCHANTED_BOOK || stack.isEnchanted();
            }
        });
        this.addSlot(new Slot(this.outputInventory, 2, 129, 34)
        {
            public boolean isItemValid(ItemStack stack)
            {
                return false;
            }
            public ItemStack onTake(PlayerEntity thePlayer, ItemStack stack)
            {
                p_i1410_3_.consume((p_216944_1_, p_216944_2_) ->
                {
                    int l = this.getEnchantmentXpFromInputs(p_216944_1_);

                    while (l > 0)
                    {
                        int i1 = ExperienceOrbEntity.getXPSplit(l);
                        l -= i1;
                        p_216944_1_.addEntity(new ExperienceOrbEntity(p_216944_1_, (double)p_216944_2_.getX(), (double)p_216944_2_.getY() + 0.5D, (double)p_216944_2_.getZ() + 0.5D, i1));
                    }

                    p_216944_1_.playEvent(1042, p_216944_2_, 0);
                });
                GrindstoneContainer.this.inputInventory.setInventorySlotContents(0, ItemStack.EMPTY);
                GrindstoneContainer.this.inputInventory.setInventorySlotContents(1, ItemStack.EMPTY);
                return stack;
            }
            private int getEnchantmentXpFromInputs(World worldIn)
            {
                int l = 0;
                l = l + this.getEnchantmentXp(GrindstoneContainer.this.inputInventory.getStackInSlot(0));
                l = l + this.getEnchantmentXp(GrindstoneContainer.this.inputInventory.getStackInSlot(1));

                if (l > 0)
                {
                    int i1 = (int)Math.ceil((double)l / 2.0D);
                    return i1 + worldIn.rand.nextInt(i1);
                }
                else
                {
                    return 0;
                }
            }
            private int getEnchantmentXp(ItemStack stack)
            {
                int l = 0;
                Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(stack);

                for (Entry<Enchantment, Integer> entry : map.entrySet())
                {
                    Enchantment enchantment = entry.getKey();
                    Integer integer = entry.getValue();

                    if (!enchantment.isCurse())
                    {
                        l += enchantment.getMinEnchantability(integer);
                    }
                }

                return l;
            }
        });

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlot(new Slot(p_i1410_2_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k)
        {
            this.addSlot(new Slot(p_i1410_2_, k, 8 + k * 18, 142));
        }
    }

    public void onCraftMatrixChanged(IInventory inventoryIn)
    {
        super.onCraftMatrixChanged(inventoryIn);

        if (inventoryIn == this.inputInventory)
        {
            this.updateRecipeOutput();
        }
    }

    private void updateRecipeOutput()
    {
        ItemStack itemstack = this.inputInventory.getStackInSlot(0);
        ItemStack itemstack1 = this.inputInventory.getStackInSlot(1);
        boolean flag = !itemstack.isEmpty() || !itemstack1.isEmpty();
        boolean flag1 = !itemstack.isEmpty() && !itemstack1.isEmpty();

        if (!flag)
        {
            this.outputInventory.setInventorySlotContents(0, ItemStack.EMPTY);
        }
        else
        {
            boolean flag2 = !itemstack.isEmpty() && itemstack.getItem() != Items.ENCHANTED_BOOK && !itemstack.isEnchanted() || !itemstack1.isEmpty() && itemstack1.getItem() != Items.ENCHANTED_BOOK && !itemstack1.isEnchanted();

            if (itemstack.getCount() > 1 || itemstack1.getCount() > 1 || !flag1 && flag2)
            {
                this.outputInventory.setInventorySlotContents(0, ItemStack.EMPTY);
                this.detectAndSendChanges();
                return;
            }

            int j = 1;
            int i;
            ItemStack itemstack2;

            if (flag1)
            {
                if (itemstack.getItem() != itemstack1.getItem())
                {
                    this.outputInventory.setInventorySlotContents(0, ItemStack.EMPTY);
                    this.detectAndSendChanges();
                    return;
                }

                Item item = itemstack.getItem();
                int k = item.getMaxDamage() - itemstack.getDamage();
                int l = item.getMaxDamage() - itemstack1.getDamage();
                int i1 = k + l + item.getMaxDamage() * 5 / 100;
                i = Math.max(item.getMaxDamage() - i1, 0);
                itemstack2 = this.copyEnchantments(itemstack, itemstack1);

                if (!itemstack2.isDamageable())
                {
                    if (!ItemStack.areItemStacksEqual(itemstack, itemstack1))
                    {
                        this.outputInventory.setInventorySlotContents(0, ItemStack.EMPTY);
                        this.detectAndSendChanges();
                        return;
                    }

                    j = 2;
                }
            }
            else
            {
                boolean flag3 = !itemstack.isEmpty();
                i = flag3 ? itemstack.getDamage() : itemstack1.getDamage();
                itemstack2 = flag3 ? itemstack : itemstack1;
            }

            this.outputInventory.setInventorySlotContents(0, this.removeEnchantments(itemstack2, i, j));
        }

        this.detectAndSendChanges();
    }

    private ItemStack copyEnchantments(ItemStack copyTo, ItemStack copyFrom)
    {
        ItemStack itemstack = copyTo.copy();
        Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(copyFrom);

        for (Entry<Enchantment, Integer> entry : map.entrySet())
        {
            Enchantment enchantment = entry.getKey();

            if (!enchantment.isCurse() || EnchantmentHelper.getEnchantmentLevel(enchantment, itemstack) == 0)
            {
                itemstack.addEnchantment(enchantment, entry.getValue());
            }
        }

        return itemstack;
    }

    private ItemStack removeEnchantments(ItemStack stack, int damage, int count)
    {
        ItemStack itemstack = stack.copy();
        itemstack.removeChildTag("Enchantments");
        itemstack.removeChildTag("StoredEnchantments");

        if (damage > 0)
        {
            itemstack.setDamage(damage);
        }
        else
        {
            itemstack.removeChildTag("Damage");
        }

        itemstack.setCount(count);
        Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(stack).entrySet().stream().filter((p_217012_0_) ->
        {
            return p_217012_0_.getKey().isCurse();
        }).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
        EnchantmentHelper.setEnchantments(map, itemstack);
        itemstack.setRepairCost(0);

        if (itemstack.getItem() == Items.ENCHANTED_BOOK && map.size() == 0)
        {
            itemstack = new ItemStack(Items.BOOK);

            if (stack.hasDisplayName())
            {
                itemstack.setDisplayName(stack.getDisplayName());
            }
        }

        for (int i = 0; i < map.size(); ++i)
        {
            itemstack.setRepairCost(RepairContainer.getNewRepairCost(itemstack.getRepairCost()));
        }

        return itemstack;
    }

    public void onContainerClosed(PlayerEntity playerIn)
    {
        super.onContainerClosed(playerIn);
        this.worldPosCallable.consume((p_217009_2_, p_217009_3_) ->
        {
            this.clearContainer(playerIn, p_217009_2_, this.inputInventory);
        });
    }

    public boolean canInteractWith(PlayerEntity playerIn)
    {
        return isWithinUsableDistance(this.worldPosCallable, playerIn, Blocks.GRINDSTONE);
    }

    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            ItemStack itemstack2 = this.inputInventory.getStackInSlot(0);
            ItemStack itemstack3 = this.inputInventory.getStackInSlot(1);

            if (index == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index != 0 && index != 1)
            {
                if (!itemstack2.isEmpty() && !itemstack3.isEmpty())
                {
                    if (index >= 3 && index < 30)
                    {
                        if (!this.mergeItemStack(itemstack1, 30, 39, false))
                        {
                            return ItemStack.EMPTY;
                        }
                    }
                    else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (!this.mergeItemStack(itemstack1, 0, 2, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }
}
