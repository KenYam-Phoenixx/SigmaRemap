package net.minecraft.world;

import mapped.Class2199;
import net.minecraft.util.math.BlockPos;

public interface ITickList<T> {
   boolean method20718(BlockPos var1, T var2);

   default void scheduleTick(BlockPos var1, T var2, int var3) {
      this.method20719(var1, (T)var2, var3, Class2199.field14370);
   }

   void method20719(BlockPos var1, T var2, int var3, Class2199 var4);

   boolean method20720(BlockPos var1, T var2);
}
