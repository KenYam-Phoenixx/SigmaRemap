package mapped;

import java.util.Arrays;

public class Class6534 implements Class6529 {
   private static String[] field28810;
   private static final int[] field28811 = new int[]{13, 15, 20, 21, 23, 32, 32, 35, 48, 64, 70, 96};
   private static final int[][] field28812 = new int[][]{
      {0, 2, 4, 6, 8, 11, 14, 18, 22, 26, 31, 37, 44, 51},
      {0, 2, 4, 6, 8, 11, 14, 18, 22, 26, 31, 36, 42, 49},
      {0, 2, 4, 6, 8, 11, 14, 17, 21, 25, 29, 34, 39, 44},
      {0, 2, 4, 6, 8, 11, 14, 17, 20, 24, 28, 33, 38, 43},
      {0, 2, 4, 6, 8, 11, 14, 17, 20, 24, 28, 32, 36, 41},
      {0, 2, 4, 6, 8, 10, 12, 14, 17, 20, 23, 26, 29, 32},
      {0, 2, 4, 6, 8, 10, 12, 14, 17, 20, 23, 26, 29, 32},
      {0, 1, 3, 5, 7, 9, 11, 13, 15, 17, 20, 23, 26, 29},
      {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16},
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, -1, -2, -3, -4, -5, -6, -6, -6, -6, -6, -6, -6, -6},
      {0, -3, -6, -9, -12, -15, -18, -20, -22, -24, -26, -28, -30, -32}
   };
   private static final float[] field28813 = new float[]{1.327152F, 1.185093F, 1.119872F};

   public static int method19836(int var0, int var1, Class2288 var2) {
      int var5 = field28768[var2.method9032()];
      int var6 = field28769[var2.method9032()];
      return var1 == 0 ? var5 + field28770[6][var0] : var5 + field28770[var6][var0];
   }

   public static int method19837(int var0, Class2288 var1, int var2) {
      if (var0 != 15) {
         if (var0 != 14) {
            int var5 = field28811[var1.method9032()];
            return Math.min(64, var5 + field28812[var1.method9032()][Math.min(var0, 13)]);
         } else {
            return Math.min(64, var2 * 2);
         }
      } else {
         return Math.min(64, var2 * 3);
      }
   }

   public static int method19838(Class6528 var0, int var1, int var2, boolean var3) {
      int[] var6 = new int[64];
      if (var2 <= var1) {
         var0.field28664 = 0;
         return 1;
      } else {
         int var7 = !var3 ? 1 : 2;
         int var8;
         if (!var3) {
            var8 = var2 - var1 >> 1 << 1;
         } else {
            var8 = var2 - var1 + 2 >> 2 << 1;
         }

         var8 = Math.min(var8, 63);
         if (var8 <= 0) {
            return 1;
         } else {
            int var9 = var1 + var8 * var7;
            int var10 = var2 - var9;

            for (int var11 = 0; var11 < var8; var11++) {
               var6[var11] = var7;
            }

            if (var10 != 0) {
               int var12 = var10 <= 0 ? 1 : -1;

               for (int var14 = var10 <= 0 ? 0 : var8 - 1; var10 != 0; var10 += var12) {
                  var6[var14] -= var12;
                  var14 += var12;
               }
            }

            var0.field28670[0] = var1;

            for (int var15 = 1; var15 <= var8; var15++) {
               var0.field28670[var15] = var0.field28670[var15 - 1] + var6[var15 - 1];
            }

            var0.field28664 = var8;
            var0.field28664 = Math.min(var0.field28664, 64);
            return 0;
         }
      }
   }

   public static int method19839(int var0, int var1, int var2, int var3) {
      float var6 = (float)Math.log(2.0);
      if (var0 != 0) {
         var6 *= 1.3F;
      }

      return (int)((double)var1 * Math.log((double)((float)var3 / (float)var2)) / (double)var6 + 0.5);
   }

   public static float method19840(int var0, int var1, int var2) {
      return (float)Math.pow((double)((float)var2 / (float)var1), (double)(1.0F / (float)var0));
   }

   public static int method19841(Class6528 var0, int var1, int var2, int var3, boolean var4) {
      int[] var7 = new int[64];
      int[] var8 = new int[64];
      int[] var9 = new int[64];
      int[] var10 = new int[64];
      int[] var11 = new int[]{6, 5, 4};
      if (var2 <= var1) {
         var0.field28664 = 0;
         return 1;
      } else {
         int var12 = var11[var3 - 1];
         boolean var13;
         int var14;
         if (!((double)((float)var2 / (float)var1) > 2.2449)) {
            var13 = false;
            var14 = var2;
         } else {
            var13 = true;
            var14 = var1 << 1;
         }

         int var15 = 2 * method19839(0, var12, var1, var14);
         var15 = Math.min(var15, 63);
         if (var15 <= 0) {
            return 1;
         } else {
            float var16 = method19840(var15, var1, var14);
            float var17 = (float)var1;
            int var18 = (int)(var17 + 0.5F);

            for (int var19 = 0; var19 <= var15; var19++) {
               int var20 = var18;
               var17 *= var16;
               var18 = (int)(var17 + 0.5F);
               var7[var19] = var18 - var20;
            }

            Arrays.sort(var7, 0, var15);
            var9[0] = var1;

            for (int var26 = 1; var26 <= var15; var26++) {
               var9[var26] = var9[var26 - 1] + var7[var26 - 1];
               if (var7[var26 - 1] == 0) {
                  return 1;
               }
            }

            if (var13) {
               int var21 = 2 * method19839(1, var12, var14, var2);
               var21 = Math.min(var21, 63);
               var16 = method19840(var21, var14, var2);
               var17 = (float)var14;
               var18 = (int)(var17 + 0.5F);

               for (int var28 = 0; var28 <= var21 - 1; var28++) {
                  int var32 = var18;
                  var17 *= var16;
                  var18 = (int)(var17 + 0.5F);
                  var8[var28] = var18 - var32;
               }

               if (var8[0] < var7[var15 - 1]) {
                  Arrays.sort(var8, 0, var21 + 1);
                  int var33 = var7[var15 - 1] - var8[0];
                  var8[0] = var7[var15 - 1];
                  var8[var21 - 1] = var8[var21 - 1] - var33;
               }

               Arrays.sort(var8, 0, var21);
               var10[0] = var14;

               for (int var29 = 1; var29 <= var21; var29++) {
                  var10[var29] = var10[var29 - 1] + var8[var29 - 1];
                  if (var8[var29 - 1] == 0) {
                     return 1;
                  }
               }

               var0.field28664 = var15 + var21;
               var0.field28664 = Math.min(var0.field28664, 64);

               for (int var30 = 0; var30 <= var15; var30++) {
                  var0.field28670[var30] = var9[var30];
               }

               for (int var31 = var15 + 1; var31 <= var0.field28664; var31++) {
                  var0.field28670[var31] = var10[var31 - var15];
               }

               return 0;
            } else {
               for (int var27 = 0; var27 <= var15; var27++) {
                  var0.field28670[var27] = var9[var27];
               }

               var0.field28664 = var15;
               var0.field28664 = Math.min(var0.field28664, 64);
               return 0;
            }
         }
      }
   }

   public static int method19842(Class6528 var0, int var1, int var2) {
      int var5 = 0;
      if (var0.field28664 <= var1) {
         return 1;
      } else {
         var0.field28665 = var0.field28664 - var1;
         var0.field28666 = (var0.field28665 >> 1) + (var0.field28665 - (var0.field28665 >> 1 << 1));
         var0.field28669[0] = var0.field28666;
         var0.field28669[1] = var0.field28665;

         for (int var6 = 0; var6 <= var0.field28665; var6++) {
            var0.field28671[1][var6] = var0.field28670[var6 + var1];
         }

         var0.field28663 = var0.field28671[1][var0.field28665] - var0.field28671[1][0];
         var0.field28662 = var0.field28671[1][0];
         if (var0.field28662 > 32) {
            return 1;
         } else if (var0.field28662 + var0.field28663 > 64) {
            return 1;
         } else {
            int var7 = (var0.field28665 & 1) == 0 ? 0 : 1;

            for (int var9 = 0; var9 <= var0.field28666; var9++) {
               if (var9 != 0) {
                  var5 = 2 * var9 - var7;
               } else {
                  var5 = 0;
               }

               var0.field28671[0][var9] = var0.field28671[1][var5];
            }

            var0.field28667 = 0;
            if (var0.field28745 != 0) {
               var0.field28667 = Math.max(1, method19839(0, var0.field28745, var0.field28662, var2));
               var0.field28667 = Math.min(5, var0.field28667);
            } else {
               var0.field28667 = 1;
            }

            for (int var10 = 0; var10 <= var0.field28667; var10++) {
               if (var10 != 0) {
                  var5 += (var0.field28666 - var5) / (var0.field28667 + 1 - var10);
               } else {
                  var5 = 0;
               }

               var0.field28672[var10] = var0.field28671[0][var5];
            }

            for (int var11 = 0; var11 < 64; var11++) {
               for (int var8 = 0; var8 < var0.field28667; var8++) {
                  if (var0.field28672[var8] <= var11 && var11 < var0.field28672[var8 + 1]) {
                     var0.field28674[var11] = var8;
                     break;
                  }
               }
            }

            return 0;
         }
      }
   }

   public static void method19843(Class6528 var0) {
      var0.field28673[0][0] = var0.field28671[0][0] - var0.field28662;
      var0.field28673[0][1] = var0.field28671[0][var0.field28666] - var0.field28662;
      var0.field28668[0] = 1;

      for (int var3 = 1; var3 < 4; var3++) {
         int[] var4 = new int[100];
         int[] var5 = new int[64];
         var5[0] = var0.field28662;

         for (int var6 = 1; var6 <= var0.field28703; var6++) {
            var5[var6] = var5[var6 - 1] + var0.field28704[var6 - 1];
         }

         for (int var12 = 0; var12 <= var0.field28666; var12++) {
            var4[var12] = var0.field28671[0][var12];
         }

         for (int var13 = 1; var13 < var0.field28703; var13++) {
            var4[var13 + var0.field28666] = var5[var13];
         }

         Arrays.sort(var4, 0, var0.field28703 + var0.field28666);
         int var14 = 1;
         int var7 = var0.field28703 + var0.field28666 - 1;
         if (var7 < 0) {
            return;
         }

         while (var14 <= var7) {
            float var8;
            if (var4[var14 - 1] == 0) {
               var8 = 0.0F;
            } else {
               var8 = (float)var4[var14] / (float)var4[var14 - 1];
            }

            if (!(var8 < field28813[var3 - 1])) {
               var14++;
            } else {
               if (var4[var14] != var4[var14 - 1]) {
                  boolean var9 = false;
                  boolean var10 = false;

                  for (int var11 = 0; var11 <= var0.field28703; var11++) {
                     if (var4[var14] == var5[var11]) {
                        var9 = true;
                     }
                  }

                  if (var9) {
                     var10 = false;

                     for (int var17 = 0; var17 <= var0.field28703; var17++) {
                        if (var4[var14 - 1] == var5[var17]) {
                           var10 = true;
                        }
                     }

                     if (!var10) {
                        var4[var14 - 1] = var0.field28671[0][var0.field28666];
                        Arrays.sort(var4, 0, var0.field28703 + var0.field28666);
                        var7--;
                     } else {
                        var14++;
                     }
                     continue;
                  }
               }

               var4[var14] = var0.field28671[0][var0.field28666];
               Arrays.sort(var4, 0, var7);
               var7--;
            }
         }

         var0.field28668[var3] = var7;

         for (int var15 = 0; var15 <= var7; var15++) {
            var0.field28673[var3][var15] = var4[var15] - var0.field28662;
         }
      }
   }
}
