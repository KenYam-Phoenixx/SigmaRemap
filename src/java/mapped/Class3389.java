package mapped;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Optional;
import java.util.Random;

public class Class3389 extends Block {
   private static String[] field18999;
   public static final Class8554 field19000 = Class8820.field39762;
   private static final ImmutableList<Class1998> field19001 = ImmutableList.of(
      new Class1998(0, 0, -1),
      new Class1998(-1, 0, 0),
      new Class1998(0, 0, 1),
      new Class1998(1, 0, 0),
      new Class1998(-1, 0, -1),
      new Class1998(1, 0, -1),
      new Class1998(-1, 0, 1),
      new Class1998(1, 0, 1)
   );
   private static final ImmutableList<Class1998> field19002 = new Builder()
      .addAll(field19001)
      .addAll(field19001.stream().<Class1998>map(Class1998::method8312).iterator())
      .addAll(field19001.stream().<Class1998>map(Class1998::method8310).iterator())
      .add(new Class1998(0, 1, 0))
      .build();

   public Class3389(AbstractBlock var1) {
      super(var1);
      this.method11578(this.field18612.method35393().method23465(field19000, Integer.valueOf(0)));
   }

   @Override
   public Class2274 method11505(Class7380 var1, Class1655 var2, BlockPos var3, PlayerEntity var4, Hand var5, Class8711 var6) {
      ItemStack var9 = var4.method3094(var5);
      if (var5 == Hand.field182 && !method11984(var9) && method11984(var4.method3094(Hand.field183))) {
         return Class2274.field14820;
      } else if (method11984(var9) && method11985(var1)) {
         method11989(var2, var3, var1);
         if (!var4.field4919.field29609) {
            var9.method32182(1);
         }

         return Class2274.method9002(var2.field9020);
      } else if (var1.<Integer>method23463(field19000) != 0) {
         if (!method11988(var2)) {
            if (!var2.field9020) {
               this.method11987(var1, var2, var3);
            }

            return Class2274.method9002(var2.field9020);
         } else {
            if (!var2.field9020) {
               Class878 var10 = (Class878)var4;
               if (var10.method2827() != var2.method6813() || !var10.method2825().equals(var3)) {
                  var10.method2829(var2.method6813(), var3, 0.0F, false, true);
                  var2.method6743(
                     (PlayerEntity)null,
                     (double)var3.method8304() + 0.5,
                     (double)var3.getY() + 0.5,
                     (double)var3.method8306() + 0.5,
                     Class6067.field27015,
                     Class2266.field14732,
                     1.0F,
                     1.0F
                  );
                  return Class2274.field14818;
               }
            }

            return Class2274.field14819;
         }
      } else {
         return Class2274.field14820;
      }
   }

   private static boolean method11984(ItemStack var0) {
      return var0.method32107() == Class8514.field37446;
   }

   private static boolean method11985(Class7380 var0) {
      return var0.<Integer>method23463(field19000) < 4;
   }

   private static boolean method11986(BlockPos var0, Class1655 var1) {
      Class7379 var4 = var1.method6739(var0);
      if (var4.method23486(Class8953.field40469)) {
         if (!var4.method23473()) {
            float var5 = (float)var4.method23477();
            if (!(var5 < 2.0F)) {
               Class7379 var6 = var1.method6739(var0.method8313());
               return !var6.method23486(Class8953.field40469);
            } else {
               return false;
            }
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   private void method11987(Class7380 var1, Class1655 var2, BlockPos var3) {
      var2.method6728(var3, false);
      boolean var6 = Class76.field161.method248().<BlockPos>map(var3::method8349).anyMatch(var1x -> method11986(var1x, var2));
      boolean var7 = var6 || var2.method6739(var3.method8311()).method23486(Class8953.field40469);
      Class5925 var8 = new Class5925(this, var7);
      var2.method6757(
         (Entity)null,
         Class8654.method31128(),
         var8,
         (double)var3.method8304() + 0.5,
         (double)var3.getY() + 0.5,
         (double)var3.method8306() + 0.5,
         5.0F,
         true,
         Class2141.field14016
      );
   }

   public static boolean method11988(Class1655 var0) {
      return var0.method6812().method36882();
   }

   public static void method11989(Class1655 var0, BlockPos var1, Class7380 var2) {
      var0.method6725(var1, var2.method23465(field19000, Integer.valueOf(var2.<Integer>method23463(field19000) + 1)), 3);
      var0.method6743(
         (PlayerEntity)null,
         (double)var1.method8304() + 0.5,
         (double)var1.getY() + 0.5,
         (double)var1.method8306() + 0.5,
         Class6067.field27013,
         Class2266.field14732,
         1.0F,
         1.0F
      );
   }

   @Override
   public void method11512(Class7380 var1, Class1655 var2, BlockPos var3, Random var4) {
      if (var1.<Integer>method23463(field19000) != 0) {
         if (var4.nextInt(100) == 0) {
            var2.method6743(
               (PlayerEntity)null,
               (double)var3.method8304() + 0.5,
               (double)var3.getY() + 0.5,
               (double)var3.method8306() + 0.5,
               Class6067.field27012,
               Class2266.field14732,
               1.0F,
               1.0F
            );
         }

         double var7 = (double)var3.method8304() + 0.5 + (0.5 - var4.nextDouble());
         double var9 = (double)var3.getY() + 1.0;
         double var11 = (double)var3.method8306() + 0.5 + (0.5 - var4.nextDouble());
         double var13 = (double)var4.nextFloat() * 0.04;
         var2.method6746(Class7940.field34118, var7, var9, var11, 0.0, var13, 0.0);
      }
   }

   @Override
   public void method11489(Class7558<Block, Class7380> var1) {
      var1.method24737(field19000);
   }

   @Override
   public boolean method11648(Class7380 var1) {
      return true;
   }

   public static int method11990(Class7380 var0, int var1) {
      return MathHelper.method37767((float)(var0.<Integer>method23463(field19000) - 0) / 4.0F * (float)var1);
   }

   @Override
   public int method11649(Class7380 var1, Class1655 var2, BlockPos var3) {
      return method11990(var1, 15);
   }

   public static Optional<Vector3d> method11991(Class8992<?> var0, Class1668 var1, BlockPos var2) {
      Optional var5 = method11992(var0, var1, var2, true);
      return !var5.isPresent() ? method11992(var0, var1, var2, false) : var5;
   }

   private static Optional<Vector3d> method11992(Class8992<?> var0, Class1668 var1, BlockPos var2, boolean var3) {
      Mutable var6 = new Mutable();
      UnmodifiableIterator var7 = field19002.iterator();

      while (var7.hasNext()) {
         Class1998 var8 = (Class1998)var7.next();
         var6.method8374(var2).method8382(var8);
         Vector3d var9 = Class4527.method14428(var0, var1, var6, var3);
         if (var9 != null) {
            return Optional.<Vector3d>of(var9);
         }
      }

      return Optional.<Vector3d>empty();
   }

   @Override
   public boolean method11494(Class7380 var1, Class1665 var2, BlockPos var3, Class1947 var4) {
      return false;
   }
}
