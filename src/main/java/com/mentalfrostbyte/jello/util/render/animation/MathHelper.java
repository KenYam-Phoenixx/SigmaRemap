package com.mentalfrostbyte.jello.util.render.animation;

public class MathHelper {
   private static String[] field34592;

   public static float calculateBackwardTransition(float var0, float var1, float var2, float var3) {
      var0 /= var3;
      return var2 * var0 * var0 * var0 + var1;
   }

   public static float calculateTransition(float var0, float var1, float var2, float var3) {
      var0 /= var3;
      return var2 * (var0 * var0 * --var0 + 1.0F) + var1;
   }

   public static float method27665(float var0, float var1, float var2, float var3) {
      var0 /= var3 / 2.0F;
      if (!(var0 < 1.0F)) {
         var0 -= 2.0F;
         return var2 / 2.0F * (var0 * var0 * var0 + 2.0F) + var1;
      } else {
         return var2 / 2.0F * var0 * var0 * var0 + var1;
      }
   }
}
