package mapped;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ITickList;

public class Class6804<T> implements ITickList<T> {
   private static final Class6804<Object> field29618 = new Class6804<Object>();

   public static <T> Class6804<T> method20727() {
      return (Class6804<T>)field29618;
   }

   @Override
   public boolean method20718(BlockPos var1, T var2) {
      return false;
   }

   @Override
   public void scheduleTick(BlockPos var1, T var2, int var3) {
   }

   @Override
   public void method20719(BlockPos var1, T var2, int var3, Class2199 var4) {
   }

   @Override
   public boolean method20720(BlockPos var1, T var2) {
      return false;
   }
}
