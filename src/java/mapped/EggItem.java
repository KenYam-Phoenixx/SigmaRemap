package mapped;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class EggItem extends Item {
   private static String[] field18828;

   public EggItem(Properties var1) {
      super(var1);
   }

   @Override
   public ActionResult<ItemStack> method11700(World var1, PlayerEntity var2, Hand var3) {
      ItemStack var6 = var2.getHeldItem(var3);
      var1.playSound(
         (PlayerEntity)null,
         var2.getPosX(),
         var2.getPosY(),
         var2.getPosZ(),
         SoundEvents.field26523,
         SoundCategory.field14735,
         0.5F,
         0.4F / (field18735.nextFloat() * 0.4F + 0.8F)
      );
      if (!var1.isRemote) {
         EggEntity var7 = new EggEntity(var1, var2);
         var7.method3511(var6);
         var7.method3463(var2, var2.rotationPitch, var2.rotationYaw, 0.0F, 1.5F, 1.0F);
         var1.addEntity(var7);
      }

      var2.addStat(Stats.field40098.method172(this));
      if (!var2.abilities.isCreativeMode) {
         var6.shrink(1);
      }

      return ActionResult.<ItemStack>method20700(var6, var1.isRemote());
   }
}
