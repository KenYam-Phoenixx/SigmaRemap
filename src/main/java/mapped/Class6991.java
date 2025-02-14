package mapped;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class Class6991 extends Class6990 {
   private static String[] field30263;
   private boolean field30264;

   public Class6991(MobEntity var1, World var2) {
      super(var1, var2);
   }

   @Override
   public Class9597 method21644(int var1) {
      this.field30257 = new Class6762();
      this.field30257.method20644(true);
      return new Class9597(this.field30257, var1);
   }

   @Override
   public boolean method21668() {
      return this.field30243.isOnGround() || this.method21669() || this.field30243.isPassenger();
   }

   @Override
   public Vector3d method21667() {
      return new Vector3d(this.field30243.getPosX(), (double)this.method21678(), this.field30243.getPosZ());
   }

   @Override
   public Class8238 method21651(BlockPos var1, int var2) {
      if (this.field30244.getBlockState(var1).isAir()) {
         BlockPos var5 = var1.down();

         while (var5.getY() > 0 && this.field30244.getBlockState(var5).isAir()) {
            var5 = var5.down();
         }

         if (var5.getY() > 0) {
            return super.method21651(var5.up(), var2);
         }

         while (var5.getY() < this.field30244.method7034() && this.field30244.getBlockState(var5).isAir()) {
            var5 = var5.up();
         }

         var1 = var5;
      }

      if (!this.field30244.getBlockState(var1).getMaterial().isSolid()) {
         return super.method21651(var1, var2);
      } else {
         BlockPos var6 = var1.up();

         while (var6.getY() < this.field30244.method7034() && this.field30244.getBlockState(var6).getMaterial().isSolid()) {
            var6 = var6.up();
         }

         return super.method21651(var6, var2);
      }
   }

   @Override
   public Class8238 method21652(Entity var1, int var2) {
      return this.method21651(var1.getPosition(), var2);
   }

   private int method21678() {
      if (this.field30243.isInWater() && this.method21675()) {
         int var3 = MathHelper.floor(this.field30243.getPosY());
         Block var4 = this.field30244.getBlockState(new BlockPos(this.field30243.getPosX(), (double)var3, this.field30243.getPosZ())).getBlock();
         int var5 = 0;

         while (var4 == Blocks.WATER) {
            var4 = this.field30244.getBlockState(new BlockPos(this.field30243.getPosX(), (double)(++var3), this.field30243.getPosZ())).getBlock();
            if (++var5 > 16) {
               return MathHelper.floor(this.field30243.getPosY());
            }
         }

         return var3;
      } else {
         return MathHelper.floor(this.field30243.getPosY() + 0.5);
      }
   }

   @Override
   public void method21670() {
      super.method21670();
      if (this.field30264) {
         if (this.field30244.method7022(new BlockPos(this.field30243.getPosX(), this.field30243.getPosY() + 0.5, this.field30243.getPosZ()))) {
            return;
         }

         for (int var3 = 0; var3 < this.field30245.method28698(); var3++) {
            Class7176 var4 = this.field30245.method28695(var3);
            if (this.field30244.method7022(new BlockPos(var4.field30847, var4.field30848, var4.field30849))) {
               this.field30245.method28696(var3);
               return;
            }
         }
      }
   }

   @Override
   public boolean method21671(Vector3d var1, Vector3d var2, int var3, int var4, int var5) {
      int var8 = MathHelper.floor(var1.x);
      int var9 = MathHelper.floor(var1.z);
      double var10 = var2.x - var1.x;
      double var12 = var2.z - var1.z;
      double var14 = var10 * var10 + var12 * var12;
      if (var14 < 1.0E-8) {
         return false;
      } else {
         double var16 = 1.0 / Math.sqrt(var14);
         var10 *= var16;
         var12 *= var16;
         var3 += 2;
         var5 += 2;
         if (!this.method21679(var8, MathHelper.floor(var1.y), var9, var3, var4, var5, var1, var10, var12)) {
            return false;
         } else {
            var3 -= 2;
            var5 -= 2;
            double var18 = 1.0 / Math.abs(var10);
            double var20 = 1.0 / Math.abs(var12);
            double var22 = (double)var8 - var1.x;
            double var24 = (double)var9 - var1.z;
            if (var10 >= 0.0) {
               var22++;
            }

            if (var12 >= 0.0) {
               var24++;
            }

            var22 /= var10;
            var24 /= var12;
            int var26 = !(var10 < 0.0) ? 1 : -1;
            int var27 = !(var12 < 0.0) ? 1 : -1;
            int var28 = MathHelper.floor(var2.x);
            int var29 = MathHelper.floor(var2.z);
            int var30 = var28 - var8;
            int var31 = var29 - var9;

            while (var30 * var26 > 0 || var31 * var27 > 0) {
               if (!(var22 < var24)) {
                  var24 += var20;
                  var9 += var27;
                  var31 = var29 - var9;
               } else {
                  var22 += var18;
                  var8 += var26;
                  var30 = var28 - var8;
               }

               if (!this.method21679(var8, MathHelper.floor(var1.y), var9, var3, var4, var5, var1, var10, var12)) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   private boolean method21679(int var1, int var2, int var3, int var4, int var5, int var6, Vector3d var7, double var8, double var10) {
      int var14 = var1 - var4 / 2;
      int var15 = var3 - var6 / 2;
      if (!this.method21681(var14, var2, var15, var4, var5, var6, var7, var8, var10)) {
         return false;
      } else {
         for (int var16 = var14; var16 < var14 + var4; var16++) {
            for (int var17 = var15; var17 < var15 + var6; var17++) {
               double var18 = (double)var16 + 0.5 - var7.x;
               double var20 = (double)var17 + 0.5 - var7.z;
               if (!(var18 * var8 + var20 * var10 < 0.0)) {
                  PathNodeType var22 = this.field30257.method20629(this.field30244, var16, var2 - 1, var17, this.field30243, var4, var5, var6, true, true);
                  if (!this.method21680(var22)) {
                     return false;
                  }

                  var22 = this.field30257.method20629(this.field30244, var16, var2, var17, this.field30243, var4, var5, var6, true, true);
                  float var23 = this.field30243.method4223(var22);
                  if (!(var23 < 0.0F) && !(var23 >= 8.0F)) {
                     if (var22 != PathNodeType.DAMAGE_FIRE && var22 != PathNodeType.DANGER_FIRE && var22 != PathNodeType.DAMAGE_OTHER) {
                        continue;
                     }

                     return false;
                  }

                  return false;
               }
            }
         }

         return true;
      }
   }

   public boolean method21680(PathNodeType var1) {
      if (var1 != PathNodeType.WATER) {
         return var1 != PathNodeType.LAVA ? var1 != PathNodeType.OPEN : false;
      } else {
         return false;
      }
   }

   private boolean method21681(int var1, int var2, int var3, int var4, int var5, int var6, Vector3d var7, double var8, double var10) {
      for (BlockPos var15 : BlockPos.method8359(new BlockPos(var1, var2, var3), new BlockPos(var1 + var4 - 1, var2 + var5 - 1, var3 + var6 - 1))) {
         double var16 = (double)var15.getX() + 0.5 - var7.x;
         double var18 = (double)var15.getZ() + 0.5 - var7.z;
         if (!(var16 * var8 + var18 * var10 < 0.0) && !this.field30244.getBlockState(var15).method23440(this.field30244, var15, PathType.field12614)) {
            return false;
         }
      }

      return true;
   }

   public void method21682(boolean var1) {
      this.field30257.method20645(var1);
   }

   public boolean method21683() {
      return this.field30257.method20647();
   }

   public void method21684(boolean var1) {
      this.field30264 = var1;
   }
}
