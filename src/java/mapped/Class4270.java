package mapped;

import com.mentalfrostbyte.jello.unmapped.Class4305;

import java.util.ArrayList;
import java.util.List;

public class Class4270 extends Class4247 {
   private List<Class4240> field20695 = new ArrayList<Class4240>();
   public int field20696;

   public Class4270(Class4305 var1, String var2, int var3, int var4) {
      super(var1, var2, var3, var4, 1060, 357, false);

      for (Class2287 var10 : Class2287.values()) {
         Class4268 var11;
         this.method13230(
            var11 = new Class4268(
               this,
               "KEY_" + var10.field15204 + this.method13241().size(),
               var10.method9027(),
               var10.method9026(),
               var10.method9028(),
               var10.method9029(),
               var10.field15201,
               var10.field15204
            )
         );
         var11.method13251((var2x, var3x) -> {
            this.field20696 = var11.field20690;
            this.method13037();
         });
      }

      this.method13300(false);
   }

   @Override
   public boolean method13078(int var1, int var2, int var3) {
      if (var3 <= 1) {
         return super.method13078(var1, var2, var3);
      } else {
         this.field20696 = var3;
         this.method13037();
         return false;
      }
   }

   @Override
   public void method13065(int var1) {
      for (Class2287 var7 : Class2287.values()) {
         if (var7.field15204 == var1) {
            super.method13065(var1);
            return;
         }
      }

      this.field20696 = var1;
      this.method13037();
      super.method13065(var1);
   }

   public void method13104() {
      for (Class4305 var4 : this.method13241()) {
         if (var4 instanceof Class4268) {
            Class4268 var5 = (Class4268)var4;
            var5.method13102();
         }
      }
   }

   public int[] method13105(int var1) {
      for (Class2287 var7 : Class2287.values()) {
         if (var7.field15204 == var1) {
            return new int[]{var7.method9027() + var7.method9028() / 2, var7.method9026() + var7.method9029()};
         }
      }

      return new int[]{this.method13267() / 2, 20};
   }

   @Override
   public void method13028(int var1, int var2) {
      super.method13028(var1, var2);
   }

   @Override
   public void method13027(float var1) {
      byte var4 = 20;
      byte var5 = 14;
      int var6 = this.field20895 - var4;
      int var7 = this.field20896 - var4;
      int var8 = this.field20897 + var4 * 2;
      int var9 = this.field20898 + 5 + var4 * 2;
      Class3192.method11463((float)(var6 + var5 / 2), (float)(var7 + var5 / 2), (float)(var8 - var5), (float)(var9 - var5), 20.0F, var1 * 0.5F);
      Class3192.method11474((float)var6, (float)var7, (float)var8, (float)var9, 14.0F, ClientColors.LIGHT_GREYISH_BLUE.getColor);
      super.method13027(var1);
   }
}
