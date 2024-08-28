package mapped;

import java.util.Comparator;
import java.util.Optional;

public class Class3634 {
   private static String[] field19667;
   private final ServerWorld field19668;

   public Class3634(ServerWorld var1) {
      this.field19668 = var1;
   }

   public Optional<Class9502> method12331(BlockPos var1, boolean var2) {
      Class1653 var5 = this.field19668.method6951();
      int var6 = !var2 ? 128 : 16;
      var5.method6682(this.field19668, var1, var6);
      Optional<Class9343> var7 = var5.method6665(var0 -> var0 == Class4913.field22770, var1, var6, Class2093.field13637)
         .sorted(Comparator.<Class9343>comparingDouble(var1x -> var1x.method35355().method8318(var1)).thenComparingInt(var0 -> var0.method35355().getY()))
         .filter(var1x -> this.field19668.method6738(var1x.method35355()).method23462(Class8820.field39712))
         .findFirst();
      return var7.<Class9502>map(
         var1x -> {
            BlockPos var4 = var1x.method35355();
            this.field19668.method6883().method7374(Class8561.field38485, new Class7481(var4), 3, var4);
            Class7380 var5x = this.field19668.method6738(var4);
            return Class7215.method22658(
               var4, var5x.<Class113>method23463(Class8820.field39712), 21, Class113.field414, 21, var2x -> this.field19668.method6738(var2x) == var5x
            );
         }
      );
   }

   public Optional<Class9502> method12332(BlockPos var1, Class113 var2) {
      Direction var5 = Direction.method555(Class1892.field11092, var2);
      double var6 = -1.0;
      BlockPos var8 = null;
      double var9 = -1.0;
      BlockPos var11 = null;
      Class7522 var12 = this.field19668.method6810();
      int var13 = this.field19668.method6998() - 1;
      Mutable var14 = var1.method8354();

      for (Mutable var16 : BlockPos.method8365(var1, 16, Direction.EAST, Direction.SOUTH)) {
         int var17 = Math.min(var13, this.field19668.method6736(Class101.field299, var16.method8304(), var16.method8306()));
         boolean var18 = true;
         if (var12.method24523(var16) && var12.method24523(var16.method8380(var5, 1))) {
            var16.method8380(var5.method536(), 1);

            for (int var19 = var17; var19 >= 0; var19--) {
               var16.method8308(var19);
               if (this.field19668.method7007(var16)) {
                  int var20 = var19;

                  while (var19 > 0 && this.field19668.method7007(var16.method8379(Direction.field672))) {
                     var19--;
                  }

                  if (var19 + 4 <= var13) {
                     int var21 = var20 - var19;
                     if (var21 <= 0 || var21 >= 3) {
                        var16.method8308(var19);
                        if (this.method12333(var16, var14, var5, 0)) {
                           double var22 = var1.method8318(var16);
                           if (this.method12333(var16, var14, var5, -1) && this.method12333(var16, var14, var5, 1) && (var6 == -1.0 || var6 > var22)) {
                              var6 = var22;
                              var8 = var16.method8353();
                           }

                           if (var6 == -1.0 && (var9 == -1.0 || var9 > var22)) {
                              var9 = var22;
                              var11 = var16.method8353();
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if (var6 == -1.0 && var9 != -1.0) {
         var8 = var11;
         var6 = var9;
      }

      if (var6 == -1.0) {
         var8 = new BlockPos(var1.method8304(), MathHelper.method37775(var1.getY(), 70, this.field19668.method6998() - 10), var1.method8306())
            .method8353();
         Direction var24 = var5.method537();
         if (!var12.method24523(var8)) {
            return Optional.<Class9502>empty();
         }

         for (int var27 = -1; var27 < 2; var27++) {
            for (int var30 = 0; var30 < 2; var30++) {
               for (int var32 = -1; var32 < 3; var32++) {
                  Class7380 var33 = var32 >= 0 ? Blocks.AIR.method11579() : Blocks.field36527.method11579();
                  var14.method8378(var8, var30 * var5.method539() + var27 * var24.method539(), var32, var30 * var5.method541() + var27 * var24.method541());
                  this.field19668.method6730(var14, var33);
               }
            }
         }
      }

      for (int var25 = -1; var25 < 3; var25++) {
         for (int var28 = -1; var28 < 4; var28++) {
            if (var25 == -1 || var25 == 2 || var28 == -1 || var28 == 3) {
               var14.method8378(var8, var25 * var5.method539(), var28, var25 * var5.method541());
               this.field19668.method6725(var14, Blocks.field36527.method11579(), 3);
            }
         }
      }

      Class7380 var26 = Blocks.field36588.method11579().method23465(Class3401.field19060, var2);

      for (int var29 = 0; var29 < 2; var29++) {
         for (int var31 = 0; var31 < 3; var31++) {
            var14.method8378(var8, var29 * var5.method539(), var31, var29 * var5.method541());
            this.field19668.method6725(var14, var26, 18);
         }
      }

      return Optional.<Class9502>of(new Class9502(var8.method8353(), 2, 3));
   }

   private boolean method12333(BlockPos var1, Mutable var2, Direction var3, int var4) {
      Direction var7 = var3.method537();

      for (int var8 = -1; var8 < 3; var8++) {
         for (int var9 = -1; var9 < 4; var9++) {
            var2.method8378(var1, var3.method539() * var8 + var7.method539() * var4, var9, var3.method541() * var8 + var7.method541() * var4);
            if (var9 < 0 && !this.field19668.method6738(var2).method23384().method31086()) {
               return false;
            }

            if (var9 >= 0 && !this.field19668.method7007(var2)) {
               return false;
            }
         }
      }

      return true;
   }
}
