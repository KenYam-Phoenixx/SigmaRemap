package net.minecraft.block;

import mapped.Class5829;
import mapped.Class949;
import mapped.Class953;
import mapped.IWorldPosCallable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class CraftingTableBlock extends Block {
   private static final ITextComponent field19237 = new TranslationTextComponent("container.crafting");

   public CraftingTableBlock(Properties var1) {
      super(var1);
   }

   @Override
   public ActionResultType onBlockActivated(BlockState var1, World var2, BlockPos var3, PlayerEntity var4, Hand var5, BlockRayTraceResult var6) {
      if (!var2.isRemote) {
         var4.method2766(var1.method23445(var2, var3));
         var4.method2911(Stats.field40160);
         return ActionResultType.field14819;
      } else {
         return ActionResultType.SUCCESS;
      }
   }

   @Override
   public Class949 method11528(BlockState var1, World var2, BlockPos var3) {
      return new Class953((var2x, var3x, var4) -> new Class5829(var2x, var3x, IWorldPosCallable.method31714(var2, var3)), field19237);
   }
}
