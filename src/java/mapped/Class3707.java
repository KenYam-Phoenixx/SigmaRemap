package mapped;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Optional;

public class Class3707 extends Class3706 {
   private static String[] field19769;
   private static final List<Class3257> field19771 = ImmutableList.of(Class8514.field37841, Class8514.field38112);

   @Override
   public void method12585(ServerWorld var1, Class1042 var2) {
      Optional var5 = var2.method2992().<Class9378>method21410(Class8830.field39814);
      if (var5.isPresent()) {
         Class9378 var6 = (Class9378)var5.get();
         Class7380 var7 = var1.method6738(var6.method35579());
         if (var7.method23448(Blocks.field37115)) {
            this.method12589(var2);
            this.method12587(var1, var2, var6, var7);
         }
      }
   }

   private void method12587(ServerWorld var1, Class1042 var2, Class9378 var3, Class7380 var4) {
      BlockPos var7 = var3.method35579();
      if (var4.<Integer>method23463(Class3475.field19326) == 8) {
         var4 = Class3475.method12166(var4, var1, var7);
      }

      int var8 = 20;
      byte var9 = 10;
      int[] var10 = new int[field19771.size()];
      Class927 var11 = var2.method4752();
      int var12 = var11.method3629();
      Class7380 var13 = var4;

      for (int var14 = var12 - 1; var14 >= 0 && var8 > 0; var14--) {
         ItemStack var15 = var11.method3618(var14);
         int var16 = field19771.indexOf(var15.method32107());
         if (var16 != -1) {
            int var17 = var15.method32179();
            int var18 = var10[var16] + var17;
            var10[var16] = var18;
            int var19 = Math.min(Math.min(var18 - 10, var8), var17);
            if (var19 > 0) {
               var8 -= var19;

               for (int var20 = 0; var20 < var19; var20++) {
                  var13 = Class3475.method12165(var13, var1, var15, var7);
                  if (var13.<Integer>method23463(Class3475.field19326) == 7) {
                     this.method12588(var1, var4, var7, var13);
                     return;
                  }
               }
            }
         }
      }

      this.method12588(var1, var4, var7, var13);
   }

   private void method12588(ServerWorld var1, Class7380 var2, BlockPos var3, Class7380 var4) {
      var1.method6999(1500, var3, var4 == var2 ? 0 : 1);
   }

   private void method12589(Class1042 var1) {
      Class927 var4 = var1.method4752();
      if (var4.method3634(Class8514.field37843) <= 36) {
         int var5 = var4.method3634(Class8514.field37842);
         byte var6 = 3;
         byte var7 = 3;
         int var8 = Math.min(3, var5 / 3);
         if (var8 != 0) {
            int var9 = var8 * 3;
            var4.method3675(Class8514.field37842, var9);
            ItemStack var10 = var4.method3676(new ItemStack(Class8514.field37843, var8));
            if (!var10.method32105()) {
               var1.method3303(var10, 0.5F);
            }
         }
      }
   }
}
