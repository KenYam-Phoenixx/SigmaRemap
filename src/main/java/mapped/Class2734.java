package mapped;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import java.util.Random;

public class Class2734 extends Class2595 {
   private static String[] field17253;
   private final EndermanEntity field17254;

   public Class2734(EndermanEntity var1) {
      this.field17254 = var1;
   }

   @Override
   public boolean method10803() {
      if (this.field17254.method4357() == null) {
         return this.field17254.world.getGameRules().getBoolean(GameRules.field24224) ? this.field17254.getRNG().nextInt(20) == 0 : false;
      } else {
         return false;
      }
   }

   @Override
   public void method10805() {
      Random var3 = this.field17254.getRNG();
      World var4 = this.field17254.world;
      int var5 = MathHelper.floor(this.field17254.getPosX() - 2.0 + var3.nextDouble() * 4.0);
      int var6 = MathHelper.floor(this.field17254.getPosY() + var3.nextDouble() * 3.0);
      int var7 = MathHelper.floor(this.field17254.getPosZ() - 2.0 + var3.nextDouble() * 4.0);
      BlockPos var8 = new BlockPos(var5, var6, var7);
      BlockState var9 = var4.getBlockState(var8);
      Block var10 = var9.getBlock();
      Vector3d var11 = new Vector3d(
         (double) MathHelper.floor(this.field17254.getPosX()) + 0.5,
         (double)var6 + 0.5,
         (double) MathHelper.floor(this.field17254.getPosZ()) + 0.5
      );
      Vector3d var12 = new Vector3d((double)var5 + 0.5, (double)var6 + 0.5, (double)var7 + 0.5);
      BlockRayTraceResult var13 = var4.rayTraceBlocks(new RayTraceContext(var11, var12, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, this.field17254));
      boolean var14 = var13.getPos().equals(var8);
      if (var10.isIn(BlockTags.field32778) && var14) {
         var4.removeBlock(var8, false);
         this.field17254.method4356(var9.getBlock().getDefaultState());
      }
   }
}
