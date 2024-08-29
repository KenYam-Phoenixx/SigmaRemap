package mapped;

import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;

public class Class3282 extends Item {
   private static String[] field18790;
   private static final Class6226 field18791 = new Class6244();
   private final MinecartType field18792;

   public Class3282(MinecartType var1, Class5643 var2) {
      super(var2);
      this.field18792 = var1;
      Class3357.method11931(this, field18791);
   }

   @Override
   public ActionResultType method11707(Class5911 var1) {
      World var4 = var1.method18360();
      BlockPos var5 = var1.method18345();
      BlockState var6 = var4.getBlockState(var5);
      if (var6.method23446(BlockTags.field32766)) {
         ItemStack var7 = var1.method18357();
         if (!var4.isRemote) {
            Class96 var8 = !(var6.getBlock() instanceof Class3429)
               ? Class96.field247
               : var6.<Class96>method23463(((Class3429)var6.getBlock()).method12093());
            double var9 = 0.0;
            if (var8.method275()) {
               var9 = 0.5;
            }

            AbstractMinecartEntity var11 = AbstractMinecartEntity.method3585(
               var4, (double)var5.getX() + 0.5, (double)var5.getY() + 0.0625 + var9, (double)var5.getZ() + 0.5, this.field18792
            );
            if (var7.method32152()) {
               var11.method3379(var7.method32149());
            }

            var4.method6916(var11);
         }

         var7.method32182(1);
         return ActionResultType.method9002(var4.isRemote);
      } else {
         return ActionResultType.FAIL;
      }
   }

   // $VF: synthetic method
   public static MinecartType method11811(Class3282 var0) {
      return var0.field18792;
   }
}
