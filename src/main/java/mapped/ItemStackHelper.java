package mapped;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.NonNullList;

import java.util.List;
import java.util.function.Predicate;

public class ItemStackHelper {
   public static ItemStack method26563(List<ItemStack> var0, int var1, int var2) {
      return var1 >= 0 && var1 < var0.size() && !((ItemStack)var0.get(var1)).isEmpty() && var2 > 0
         ? ((ItemStack)var0.get(var1)).split(var2)
         : ItemStack.EMPTY;
   }

   public static ItemStack method26564(List<ItemStack> var0, int var1) {
      return var1 >= 0 && var1 < var0.size() ? var0.set(var1, ItemStack.EMPTY) : ItemStack.EMPTY;
   }

   public static CompoundNBT saveAllItems(CompoundNBT var0, NonNullList<ItemStack> var1) {
      return method26566(var0, var1, true);
   }

   public static CompoundNBT method26566(CompoundNBT var0, NonNullList<ItemStack> var1, boolean var2) {
      ListNBT var5 = new ListNBT();

      for (int var6 = 0; var6 < var1.size(); var6++) {
         ItemStack var7 = (ItemStack)var1.get(var6);
         if (!var7.isEmpty()) {
            CompoundNBT var8 = new CompoundNBT();
            var8.putByte("Slot", (byte)var6);
            var7.method32112(var8);
            var5.add(var8);
         }
      }

      if (!var5.isEmpty() || var2) {
         var0.put("Items", var5);
      }

      return var0;
   }

   public static void loadAllItems(CompoundNBT var0, NonNullList<ItemStack> var1) {
      ListNBT var4 = var0.getList("Items", 10);

      for (int var5 = 0; var5 < var4.size(); var5++) {
         CompoundNBT var6 = var4.getCompound(var5);
         int var7 = var6.getByte("Slot") & 255;
         if (var7 >= 0 && var7 < var1.size()) {
            var1.set(var7, ItemStack.read(var6));
         }
      }
   }

   public static int method26568(IInventory var0, Predicate<ItemStack> var1, int var2, boolean var3) {
      int var6 = 0;

      for (int var7 = 0; var7 < var0.getSizeInventory(); var7++) {
         ItemStack var8 = var0.getStackInSlot(var7);
         int var9 = method26569(var8, var1, var2 - var6, var3);
         if (var9 > 0 && !var3 && var8.isEmpty()) {
            var0.setInventorySlotContents(var7, ItemStack.EMPTY);
         }

         var6 += var9;
      }

      return var6;
   }

   public static int method26569(ItemStack var0, Predicate<ItemStack> var1, int var2, boolean var3) {
      if (var0.isEmpty() || !var1.test(var0)) {
         return 0;
      } else if (!var3) {
         int var6 = var2 >= 0 ? Math.min(var2, var0.getCount()) : var0.getCount();
         var0.shrink(var6);
         return var6;
      } else {
         return var0.getCount();
      }
   }
}
