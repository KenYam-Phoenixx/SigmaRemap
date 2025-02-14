package mapped;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;

public class Class5868 extends Slot {
   private static String[] field25641;
   private final Class988 field25642;
   private final PlayerEntity field25643;
   private int field25644;
   private final Class1060 field25645;

   public Class5868(PlayerEntity var1, Class1060 var2, Class988 var3, int var4, int var5, int var6) {
      super(var3, var4, var5, var6);
      this.field25643 = var1;
      this.field25645 = var2;
      this.field25642 = var3;
   }

   @Override
   public boolean isItemValid(ItemStack var1) {
      return false;
   }

   @Override
   public ItemStack decrStackSize(int var1) {
      if (this.getHasStack()) {
         this.field25644 = this.field25644 + Math.min(var1, this.getStack().getCount());
      }

      return super.decrStackSize(var1);
   }

   @Override
   public void onCrafting(ItemStack var1, int var2) {
      this.field25644 += var2;
      this.onCrafting(var1);
   }

   @Override
   public void onCrafting(ItemStack var1) {
      var1.method32136(this.field25643.world, this.field25643, this.field25644);
      this.field25644 = 0;
   }

   @Override
   public ItemStack onTake(PlayerEntity var1, ItemStack var2) {
      this.onCrafting(var2);
      Class9346 var5 = this.field25642.method4067();
      if (var5 != null) {
         ItemStack var6 = this.field25642.getStackInSlot(0);
         ItemStack var7 = this.field25642.getStackInSlot(1);
         if (var5.method35389(var6, var7) || var5.method35389(var7, var6)) {
            this.field25645.method4745(var5);
            var1.method2911(Stats.field40140);
            this.field25642.setInventorySlotContents(0, var6);
            this.field25642.setInventorySlotContents(1, var7);
         }

         this.field25645.method4744(this.field25645.method4721() + var5.method35381());
      }

      return var2;
   }
}
