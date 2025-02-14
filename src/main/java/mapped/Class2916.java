package mapped;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Class2916 extends Class2914 {
   public Class2916(Codec<Class4712> var1) {
      super(var1);
   }

   @Override
   public boolean method11249(IWorld var1, Random var2, BlockPos var3, BlockState var4) {
      BlockPos.Mutable var7 = var3.method8354();
      int var8 = var2.nextInt(3) + 1;

      for (int var9 = 0; var9 < var8; var9++) {
         if (!this.method11250(var1, var2, var7, var4)) {
            return true;
         }

         var7.method8379(Direction.UP);
      }

      BlockPos var17 = var7.toImmutable();
      int var10 = var2.nextInt(3) + 2;
      List<Direction> var11 = Lists.newArrayList(Direction.Plane.HORIZONTAL);
      Collections.shuffle(var11, var2);

      for (Direction var13 : var11.subList(0, var10)) {
         var7.method8374(var17);
         var7.method8379(var13);
         int var14 = var2.nextInt(5) + 2;
         int var15 = 0;

         for (int var16 = 0; var16 < var14 && this.method11250(var1, var2, var7, var4); var16++) {
            var15++;
            var7.method8379(Direction.UP);
            if (var16 == 0 || var15 >= 2 && var2.nextFloat() < 0.25F) {
               var7.method8379(var13);
               var15 = 0;
            }
         }
      }

      return true;
   }
}
