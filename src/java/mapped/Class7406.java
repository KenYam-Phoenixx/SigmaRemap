package mapped;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public final class Class7406 extends ItemGroup {
   public Class7406(int var1, String var2) {
      super(var1, var2);
   }

   @Override
   public ItemStack method23640() {
      return new ItemStack(Blocks.BOOKSHELF);
   }

   @Override
   public void method23658(NonNullList<ItemStack> var1) {
      throw new RuntimeException("Implement exception client-side.");
   }

   @Override
   public boolean method23654() {
      return true;
   }
}
