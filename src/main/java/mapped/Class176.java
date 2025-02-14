package mapped;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.function.Predicate;

public class Class176 implements Predicate<ItemStack> {
   private static final Dynamic2CommandExceptionType field562 = new Dynamic2CommandExceptionType(
      (var0, var1) -> new TranslationTextComponent("arguments.item.overstacked", var0, var1)
   );
   private final Item field563;
   private final CompoundNBT field564;

   public Class176(Item var1, CompoundNBT var2) {
      this.field563 = var1;
      this.field564 = var2;
   }

   public Item method502() {
      return this.field563;
   }

   public boolean test(ItemStack var1) {
      return var1.getItem() == this.field563 && NBTUtil.areNBTEquals(this.field564, var1.getTag(), true);
   }

   public ItemStack method503(int var1, boolean var2) throws CommandSyntaxException {
      ItemStack var5 = new ItemStack(this.field563, var1);
      if (this.field564 != null) {
         var5.setTag(this.field564);
      }

      if (var2 && var1 > var5.getMaxStackSize()) {
         throw field562.create(Registry.ITEM.getKey(this.field563), var5.getMaxStackSize());
      } else {
         return var5;
      }
   }

   public String method504() {
      StringBuilder var3 = new StringBuilder(Registry.ITEM.getId(this.field563));
      if (this.field564 != null) {
         var3.append(this.field564);
      }

      return var3.toString();
   }
}
