package mapped;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class DrinkHelper {
   private static String[] field36360;

   public static ActionResult<ItemStack> method29977(World var0, PlayerEntity var1, Hand var2) {
      var1.setActiveHand(var2);
      return ActionResult.<ItemStack>method20697(var1.getHeldItem(var2));
   }

   public static ItemStack method29978(ItemStack var0, PlayerEntity var1, ItemStack var2, boolean var3) {
      boolean var6 = var1.abilities.isCreativeMode;
      if (var3 && var6) {
         if (!var1.inventory.method4058(var2)) {
            var1.inventory.method4045(var2);
         }

         return var0;
      } else {
         if (!var6) {
            var0.shrink(1);
         }

         if (!var0.isEmpty()) {
            if (!var1.inventory.method4045(var2)) {
               var1.dropItem(var2, false);
            }

            return var0;
         } else {
            return var2;
         }
      }
   }

   public static ItemStack method29979(ItemStack var0, PlayerEntity var1, ItemStack var2) {
      return method29978(var0, var1, var2, true);
   }
}
