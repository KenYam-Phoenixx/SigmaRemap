package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class Class6765 extends Class6764 {
   private static String[] field29484;
   private final boolean field29485;

   public Class6765(boolean var1) {
      this.field29485 = var1;
   }

   @Override
   public Class7176 method20615() {
      return super.method20641(
         MathHelper.floor(this.field29476.getBoundingBox().minX),
         MathHelper.floor(this.field29476.getBoundingBox().minY + 0.5),
         MathHelper.floor(this.field29476.getBoundingBox().minZ)
      );
   }

   @Override
   public Class7175 method20616(double var1, double var3, double var5) {
      return new Class7175(
         super.method20641(
            MathHelper.floor(var1 - (double)(this.field29476.getWidth() / 2.0F)),
            MathHelper.floor(var3 + 0.5),
            MathHelper.floor(var5 - (double)(this.field29476.getWidth() / 2.0F))
         )
      );
   }

   @Override
   public int method20617(Class7176[] var1, Class7176 var2) {
      int var5 = 0;

      for (Direction var9 : Direction.values()) {
         Class7176 var10 = this.method20651(var2.field30847 + var9.getXOffset(), var2.field30848 + var9.getYOffset(), var2.field30849 + var9.getZOffset());
         if (var10 != null && !var10.field30856) {
            var1[var5++] = var10;
         }
      }

      return var5;
   }

   @Override
   public PathNodeType method20629(IBlockReader var1, int var2, int var3, int var4, MobEntity var5, int var6, int var7, int var8, boolean var9, boolean var10) {
      return this.method20621(var1, var2, var3, var4);
   }

   @Override
   public PathNodeType method20621(IBlockReader var1, int var2, int var3, int var4) {
      BlockPos var7 = new BlockPos(var2, var3, var4);
      FluidState var8 = var1.getFluidState(var7);
      BlockState var9 = var1.getBlockState(var7);
      if (var8.isEmpty() && var9.method23440(var1, var7.down(), PathType.field12615) && var9.isAir()) {
         return PathNodeType.BREACH;
      } else {
         return var8.method23486(FluidTags.WATER) && var9.method23440(var1, var7, PathType.field12615) ? PathNodeType.WATER : PathNodeType.BLOCKED;
      }
   }

   @Nullable
   private Class7176 method20651(int var1, int var2, int var3) {
      PathNodeType var6 = this.method20652(var1, var2, var3);
      return (!this.field29485 || var6 != PathNodeType.BREACH) && var6 != PathNodeType.WATER ? null : this.method20641(var1, var2, var3);
   }

   @Nullable
   @Override
   public Class7176 method20641(int var1, int var2, int var3) {
      Class7176 var6 = null;
      PathNodeType var7 = this.method20621(this.field29476.world, var1, var2, var3);
      float var8 = this.field29476.method4223(var7);
      if (var8 >= 0.0F) {
         var6 = super.method20641(var1, var2, var3);
         var6.field30859 = var7;
         var6.field30858 = Math.max(var6.field30858, var8);
         if (this.field29475.getFluidState(new BlockPos(var1, var2, var3)).isEmpty()) {
            var6.field30858 += 8.0F;
         }
      }

      return var7 != PathNodeType.OPEN ? var6 : var6;
   }

   private PathNodeType method20652(int var1, int var2, int var3) {
      BlockPos.Mutable var6 = new BlockPos.Mutable();

      for (int var7 = var1; var7 < var1 + this.field29478; var7++) {
         for (int var8 = var2; var8 < var2 + this.field29479; var8++) {
            for (int var9 = var3; var9 < var3 + this.field29480; var9++) {
               FluidState var10 = this.field29475.getFluidState(var6.setPos(var7, var8, var9));
               BlockState var11 = this.field29475.getBlockState(var6.setPos(var7, var8, var9));
               if (var10.isEmpty() && var11.method23440(this.field29475, var6.down(), PathType.field12615) && var11.isAir()) {
                  return PathNodeType.BREACH;
               }

               if (!var10.method23486(FluidTags.WATER)) {
                  return PathNodeType.BLOCKED;
               }
            }
         }
      }

      BlockState var12 = this.field29475.getBlockState(var6);
      return !var12.method23440(this.field29475, var6, PathType.field12615) ? PathNodeType.BLOCKED : PathNodeType.WATER;
   }
}
