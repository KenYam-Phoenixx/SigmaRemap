package mapped;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Set;

public class HoeItem extends ToolItem {
   private static String[] field18768;
   private static final Set<Block> field18769 = Sets.newHashSet(
      new Block[]{
         Blocks.CLAY,
         Blocks.DIRT,
         Blocks.COARSE_DIRT,
         Blocks.PODZOL,
         Blocks.FARMLAND,
         Blocks.GRASS_BLOCK,
         Blocks.GRAVEL,
         Blocks.MYCELIUM,
         Blocks.SAND,
         Blocks.RED_SAND,
         Blocks.SNOW_BLOCK,
         Blocks.SNOW,
         Blocks.SOUL_SAND,
         Blocks.GRASS_PATH,
         Blocks.WHITE_CONCRETE_POWDER,
         Blocks.ORANGE_CONCRETE_POWDER,
         Blocks.MAGENTA_CONCRETE_POWDER,
         Blocks.LIGHT_BLUE_CONCRETE_POWDER,
         Blocks.YELLOW_CONCRETE_POWDER,
         Blocks.LIME_CONCRETE_POWDER,
         Blocks.PINK_CONCRETE_POWDER,
         Blocks.GRAY_CONCRETE_POWDER,
         Blocks.LIGHT_GRAY_CONCRETE_POWDER,
         Blocks.CYAN_CONCRETE_POWDER,
         Blocks.PURPLE_CONCRETE_POWDER,
         Blocks.BLUE_CONCRETE_POWDER,
         Blocks.BROWN_CONCRETE_POWDER,
         Blocks.GREEN_CONCRETE_POWDER,
         Blocks.RED_CONCRETE_POWDER,
         Blocks.BLACK_CONCRETE_POWDER,
         Blocks.SOUL_SOIL
      }
   );
   public static final Map<Block, BlockState> field18770 = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK, Blocks.GRASS_PATH.getDefaultState()));

   public HoeItem(IItemTier var1, float var2, float var3, Properties var4) {
      super(var2, var3, var1, field18769, var4);
   }

   @Override
   public boolean canHarvestBlock(BlockState var1) {
      return var1.isIn(Blocks.SNOW) || var1.isIn(Blocks.SNOW_BLOCK);
   }

   @Override
   public ActionResultType onItemUse(ItemUseContext var1) {
      World var4 = var1.getWorld();
      BlockPos var5 = var1.getPos();
      BlockState var6 = var4.getBlockState(var5);
      if (var1.getFace() == Direction.DOWN) {
         return ActionResultType.field14820;
      } else {
         PlayerEntity var7 = var1.method18358();
         BlockState var8 = field18770.get(var6.getBlock());
         BlockState var9 = null;
         if (var8 != null && var4.getBlockState(var5.up()).isAir()) {
            var4.playSound(var7, var5, SoundEvents.field27042, SoundCategory.field14732, 1.0F, 1.0F);
            var9 = var8;
         } else if (var6.getBlock() instanceof Class3244 && var6.<Boolean>get(Class3244.field18698)) {
            if (!var4.isRemote()) {
               var4.method6869((PlayerEntity)null, 1009, var5, 0);
            }

            Class3244.method11652(var4, var5, var6);
            var9 = var6.with(Class3244.field18698, Boolean.valueOf(false));
         }

         if (var9 == null) {
            return ActionResultType.field14820;
         } else {
            if (!var4.isRemote) {
               var4.setBlockState(var5, var9, 11);
               if (var7 != null) {
                  var1.method18357().damageItem(1, var7, var1x -> var1x.sendBreakAnimation(var1.method18359()));
               }
            }

            return ActionResultType.method9002(var4.isRemote);
         }
      }
   }
}
