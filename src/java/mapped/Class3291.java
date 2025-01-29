package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Class3291 extends Item {
   public Class3291(Properties var1) {
      super(var1);
   }

   @Override
   public ActionResultType onItemUse(ItemUseContext var1) {
      World var4 = var1.getWorld();
      BlockPos var5 = var1.getPos();
      BlockState var6 = var4.getBlockState(var5);
      if (!var6.isIn(Blocks.LECTERN)) {
         return ActionResultType.field14820;
      } else {
         return !Class3354.method11919(var4, var5, var6, var1.method18357()) ? ActionResultType.field14820 : ActionResultType.method9002(var4.isRemote);
      }
   }

   @Override
   public ActionResult<ItemStack> method11700(World var1, PlayerEntity var2, Hand var3) {
      ItemStack var6 = var2.getHeldItem(var3);
      var2.method2769(var6, var3);
      var2.addStat(Stats.field40098.method172(this));
      return ActionResult.<ItemStack>method20700(var6, var1.isRemote());
   }

   public static boolean method11833(CompoundNBT var0) {
      if (var0 == null) {
         return false;
      } else if (!var0.contains("pages", 9)) {
         return false;
      } else {
         ListNBT var3 = var0.getList("pages", 8);

         for (int var4 = 0; var4 < var3.size(); var4++) {
            String var5 = var3.getString(var4);
            if (var5.length() > 32767) {
               return false;
            }
         }

         return true;
      }
   }
}
