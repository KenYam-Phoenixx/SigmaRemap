package mapped;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.Random;

public class Class2941 extends Class2898<Class4704> {
   public Class2941(Codec<Class4704> var1) {
      super(var1);
   }

   public boolean method11213(Class1658 var1, ChunkGenerator var2, Random var3, BlockPos var4, Class4704 var5) {
      Block var8 = var5.field22318.getBlock();
      BlockPos var9 = method11285(var1, var4.method8354().method8383(Class113.field414, 1, var1.method7034() - 1), var8);
      if (var9 == null) {
         return false;
      } else {
         int var10 = var5.method14767().method27633(var3);
         boolean var11 = false;

         for (BlockPos var13 : BlockPos.method8356(var9, var10, var10, var10)) {
            if (var13.method8321(var9) > var10) {
               break;
            }

            BlockState var14 = var1.getBlockState(var13);
            if (var14.method23448(var8)) {
               this.method11217(var1, var13, var5.field22319);
               var11 = true;
            }
         }

         return var11;
      }
   }

   @Nullable
   private static BlockPos method11285(Class1660 var0, Mutable var1, Block var2) {
      while (var1.getY() > 1) {
         BlockState var5 = var0.getBlockState(var1);
         if (var5.method23448(var2)) {
            return var1;
         }

         var1.method8379(Direction.DOWN);
      }

      return null;
   }
}
