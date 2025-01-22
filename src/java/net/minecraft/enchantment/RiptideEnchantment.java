package net.minecraft.enchantment;

import net.minecraft.inventory.EquipmentSlotType;

public class RiptideEnchantment extends Enchantment {
   private static String[] field27322;

   public RiptideEnchantment(Rarity var1, EquipmentSlotType... var2) {
      super(var1, EnchantmentType.TRIDENT, var2);
   }

   @Override
   public int method18807(int var1) {
      return 10 + var1 * 7;
   }

   @Override
   public int method18808(int var1) {
      return 50;
   }

   @Override
   public int method18809() {
      return 3;
   }

   @Override
   public boolean method18817(Enchantment var1) {
      return super.method18817(var1) && var1 != Enchantments.LOYALTY && var1 != Enchantments.CHANNELING;
   }
}
