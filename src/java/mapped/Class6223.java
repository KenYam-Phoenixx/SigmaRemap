package mapped;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;

public final class Class6223 extends Class6218 {
   private static String[] field27718;

   @Override
   public ItemStack method19192(Class2956 var1, ItemStack var2) {
      Direction var5 = var1.method11324().<Direction>method23463(Class3357.field18899);
      Class888 var6 = new Class888(var1.method11326(), var2, var1.getX(), var1.getY(), var1.getX(), true);
      Class6226.method19201(var1, var6, var5);
      var6.shoot((double)var5.method539(), (double)var5.method540(), (double)var5.method541(), 0.5F, 1.0F);
      var1.method11326().method6916(var6);
      var2.method32182(1);
      return var2;
   }

   @Override
   public void method19193(Class2956 var1) {
      var1.method11326().playEvent(1004, var1.method11323(), 0);
   }
}
