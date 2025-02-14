package mapped;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Class3329 extends Item {
   private static String[] field18837;

   public Class3329(Properties var1) {
      super(var1);
   }

   @Override
   public ActionResultType onItemUse(ItemUseContext var1) {
      World var4 = var1.getWorld();
      BlockPos var5 = var1.getPos();
      Block var6 = var4.getBlockState(var5).getBlock();
      if (!var6.isIn(BlockTags.field32771)) {
         return ActionResultType.field14820;
      } else {
         PlayerEntity var7 = var1.method18358();
         if (!var4.isRemote && var7 != null) {
            method11880(var7, var4, var5);
         }

         return ActionResultType.method9002(var4.isRemote);
      }
   }

   public static ActionResultType method11880(PlayerEntity var0, World var1, BlockPos var2) {
      LeashKnotEntity var5 = null;
      boolean var6 = false;
      double var7 = 7.0;
      int var9 = var2.getX();
      int var10 = var2.getY();
      int var11 = var2.getZ();

      for (MobEntity var13 : var1.<MobEntity>getEntitiesWithinAABB(
         MobEntity.class,
         new AxisAlignedBB((double)var9 - 7.0, (double)var10 - 7.0, (double)var11 - 7.0, (double)var9 + 7.0, (double)var10 + 7.0, (double)var11 + 7.0)
      )) {
         if (var13.method4297() == var0) {
            if (var5 == null) {
               var5 = LeashKnotEntity.method4087(var1, var2);
            }

            var13.method4298(var5, true);
            var6 = true;
         }
      }

      return !var6 ? ActionResultType.field14820 : ActionResultType.SUCCESS;
   }
}
