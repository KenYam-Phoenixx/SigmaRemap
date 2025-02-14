package mapped;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Class8162 {
   private int field35121;
   private long field35122;
   private int field35123;
   private long field35124;
   private int field35125;
   private long field35126;
   private int field35127;
   private long field35128;
   private int field35129;
   private long field35130;
   private Class8174 field35131;
   private Class8174 field35132;
   private Class8174 field35133;
   private boolean field35134 = false;
   private boolean field35135 = false;

   public Class8162(long var1, long var3, long var5) {
      if (var1 > 1L && var3 > 1L && var5 > 1L) {
         this.field35121 = (int)var1;
         this.field35123 = (int)var3;
         this.field35125 = (int)var5;
         this.field35122 = var1;
         this.field35124 = var3;
         this.field35126 = var5;
         this.field35127 = (int)(var3 * var5);
         this.field35129 = (int)var5;
         this.field35128 = var3 * var5;
         this.field35130 = var5;
         if (var1 * var3 * var5 >= Class7796.method25894()) {
            this.field35135 = true;
         }

         if (Class7796.method25908(var1) && Class7796.method25908(var3) && Class7796.method25908(var5)) {
            this.field35134 = true;
         }

         Class7796.method25902(var1 * var3 * var5 > (long)Class2373.method9693());
         this.field35131 = new Class8174(var1);
         if (var1 != var3) {
            this.field35132 = new Class8174(var3);
         } else {
            this.field35132 = this.field35131;
         }

         if (var1 != var5) {
            if (var3 != var5) {
               this.field35133 = new Class8174(var5);
            } else {
               this.field35133 = this.field35132;
            }
         } else {
            this.field35133 = this.field35131;
         }
      } else {
         throw new IllegalArgumentException("slices, rows and columns must be greater than 1");
      }
   }

   public void method28371(float[] var1) {
      int var4 = Class7008.method21726();
      if (this.field35134) {
         if (var4 > 1 && this.field35135) {
            this.method28383(-1, var1, true);
            this.method28386(-1, var1, true);
         } else {
            this.method28377(-1, var1, true);
            this.method28380(-1, var1, true);
         }

         this.method28389(var1);
      } else {
         if (var4 > 1 && this.field35135 && this.field35121 >= var4 && this.field35123 >= var4 && this.field35125 >= var4) {
            Future[] var19 = new Future[var4];
            int var22 = this.field35121 / var4;

            for (int var26 = 0; var26 < var4; var26++) {
               int var30 = var26 * var22;
               int var36 = var26 == var4 - 1 ? this.field35121 : var30 + var22;
               var19[var26] = Class7008.method21729(new Class1453(this, var30, var36, var1));
            }

            try {
               Class7008.method21730(var19);
            } catch (InterruptedException var15) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var15);
            } catch (ExecutionException var16) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var16);
            }

            for (int var27 = 0; var27 < var4; var27++) {
               int var31 = var27 * var22;
               int var37 = var27 == var4 - 1 ? this.field35121 : var31 + var22;
               var19[var27] = Class7008.method21729(new Class550(this, var31, var37, var1));
            }

            try {
               Class7008.method21730(var19);
            } catch (InterruptedException var13) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var13);
            } catch (ExecutionException var14) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var14);
            }

            var22 = this.field35123 / var4;

            for (int var28 = 0; var28 < var4; var28++) {
               int var32 = var28 * var22;
               int var38;
               if (var28 == var4 - 1) {
                  var38 = this.field35123;
               } else {
                  var38 = var32 + var22;
               }

               var19[var28] = Class7008.method21729(new Class1540(this, var32, var38, var1));
            }

            try {
               Class7008.method21730(var19);
            } catch (InterruptedException var11) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var11);
            } catch (ExecutionException var12) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var12);
            }
         } else {
            for (int var5 = 0; var5 < this.field35121; var5++) {
               int var6 = var5 * this.field35127;

               for (int var7 = 0; var7 < this.field35123; var7++) {
                  this.field35133.method28457(var1, var6 + var7 * this.field35129);
               }
            }

            float[] var17 = new float[this.field35123];

            for (int var20 = 0; var20 < this.field35121; var20++) {
               int var24 = var20 * this.field35127;

               for (int var8 = 0; var8 < this.field35125; var8++) {
                  for (int var9 = 0; var9 < this.field35123; var9++) {
                     int var10 = var24 + var9 * this.field35129 + var8;
                     var17[var9] = var1[var10];
                  }

                  this.field35132.method28455(var17);

                  for (int var33 = 0; var33 < this.field35123; var33++) {
                     int var39 = var24 + var33 * this.field35129 + var8;
                     var1[var39] = var17[var33];
                  }
               }
            }

            var17 = new float[this.field35121];

            for (int var21 = 0; var21 < this.field35123; var21++) {
               int var25 = var21 * this.field35129;

               for (int var29 = 0; var29 < this.field35125; var29++) {
                  for (int var34 = 0; var34 < this.field35121; var34++) {
                     int var40 = var34 * this.field35127 + var25 + var29;
                     var17[var34] = var1[var40];
                  }

                  this.field35131.method28455(var17);

                  for (int var35 = 0; var35 < this.field35121; var35++) {
                     int var41 = var35 * this.field35127 + var25 + var29;
                     var1[var41] = var17[var35];
                  }
               }
            }
         }

         this.method28389(var1);
      }
   }

   public void method28372(Class2378 var1) {
      int var4 = Class7008.method21726();
      if (this.field35134) {
         if (var4 > 1 && this.field35135) {
            this.method28384(-1, var1, true);
            this.method28387(-1, var1, true);
         } else {
            this.method28378(-1, var1, true);
            this.method28381(-1, var1, true);
         }

         this.method28390(var1);
      } else {
         if (var4 > 1 && this.field35135 && this.field35122 >= (long)var4 && this.field35124 >= (long)var4 && this.field35126 >= (long)var4) {
            Future[] var32 = new Future[var4];
            long var34 = this.field35122 / (long)var4;

            for (int var8 = 0; var8 < var4; var8++) {
               long var38 = (long)var8 * var34;
               long var11 = var8 == var4 - 1 ? this.field35122 : var38 + var34;
               var32[var8] = Class7008.method21729(new Class1582(this, var38, var11, var1));
            }

            try {
               Class7008.method21730(var32);
            } catch (InterruptedException var29) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var29);
            } catch (ExecutionException var30) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var30);
            }

            for (int var36 = 0; var36 < var4; var36++) {
               long var39 = (long)var36 * var34;
               long var41 = var36 == var4 - 1 ? this.field35122 : var39 + var34;
               var32[var36] = Class7008.method21729(new Class742(this, var39, var41, var1));
            }

            try {
               Class7008.method21730(var32);
            } catch (InterruptedException var27) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var27);
            } catch (ExecutionException var28) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var28);
            }

            var34 = this.field35124 / (long)var4;

            for (int var37 = 0; var37 < var4; var37++) {
               long var40 = (long)var37 * var34;
               long var42;
               if (var37 == var4 - 1) {
                  var42 = this.field35124;
               } else {
                  var42 = var40 + var34;
               }

               var32[var37] = Class7008.method21729(new Class598(this, var40, var42, var1));
            }

            try {
               Class7008.method21730(var32);
            } catch (InterruptedException var25) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var25);
            } catch (ExecutionException var26) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var26);
            }
         } else {
            for (long var13 = 0L; var13 < this.field35122; var13++) {
               long var15 = var13 * (long)this.field35127;

               for (long var9 = 0L; var9 < this.field35124; var9++) {
                  this.field35133.method28458(var1, var15 + var9 * (long)this.field35129);
               }
            }

            Class2378 var5 = new Class2378(this.field35124, false);

            for (long var6 = 0L; var6 < this.field35122; var6++) {
               long var17 = var6 * (long)this.field35127;

               for (long var19 = 0L; var19 < this.field35126; var19++) {
                  for (long var21 = 0L; var21 < this.field35124; var21++) {
                     long var23 = var17 + var21 * (long)this.field35129 + var19;
                     var5.method9685(var21, var1.method9651(var23));
                  }

                  this.field35132.method28456(var5);

                  for (long var45 = 0L; var45 < this.field35124; var45++) {
                     long var48 = var17 + var45 * (long)this.field35129 + var19;
                     var1.method9685(var48, var5.method9651(var45));
                  }
               }
            }

            var5 = new Class2378(this.field35122, false);

            for (long var33 = 0L; var33 < this.field35124; var33++) {
               long var43 = var33 * (long)this.field35129;

               for (long var44 = 0L; var44 < this.field35126; var44++) {
                  for (long var46 = 0L; var46 < this.field35122; var46++) {
                     long var49 = var46 * (long)this.field35127 + var43 + var44;
                     var5.method9685(var46, var1.method9651(var49));
                  }

                  this.field35131.method28456(var5);

                  for (long var47 = 0L; var47 < this.field35122; var47++) {
                     long var50 = var47 * (long)this.field35127 + var43 + var44;
                     var1.method9685(var50, var5.method9651(var47));
                  }
               }
            }
         }

         this.method28390(var1);
      }
   }

   public void method28373(float[][][] var1) {
      int var4 = Class7008.method21726();
      if (this.field35134) {
         if (var4 > 1 && this.field35135) {
            this.method28385(-1, var1, true);
            this.method28388(-1, var1, true);
         } else {
            this.method28379(-1, var1, true);
            this.method28382(-1, var1, true);
         }

         this.method28391(var1);
      } else {
         if (var4 > 1 && this.field35135 && this.field35121 >= var4 && this.field35123 >= var4 && this.field35125 >= var4) {
            Future[] var18 = new Future[var4];
            int var21 = this.field35121 / var4;

            for (int var24 = 0; var24 < var4; var24++) {
               int var30 = var24 * var21;
               int var9 = var24 == var4 - 1 ? this.field35121 : var30 + var21;
               var18[var24] = Class7008.method21729(new Class1390(this, var30, var9, var1));
            }

            try {
               Class7008.method21730(var18);
            } catch (InterruptedException var14) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var14);
            } catch (ExecutionException var15) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var15);
            }

            for (int var25 = 0; var25 < var4; var25++) {
               int var31 = var25 * var21;
               int var33 = var25 == var4 - 1 ? this.field35121 : var31 + var21;
               var18[var25] = Class7008.method21729(new Class1382(this, var31, var33, var1));
            }

            try {
               Class7008.method21730(var18);
            } catch (InterruptedException var12) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var12);
            } catch (ExecutionException var13) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var13);
            }

            var21 = this.field35123 / var4;

            for (int var26 = 0; var26 < var4; var26++) {
               int var32 = var26 * var21;
               int var34 = var26 == var4 - 1 ? this.field35123 : var32 + var21;
               var18[var26] = Class7008.method21729(new Class1478(this, var32, var34, var1));
            }

            try {
               Class7008.method21730(var18);
            } catch (InterruptedException var10) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var10);
            } catch (ExecutionException var11) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var11);
            }
         } else {
            for (int var5 = 0; var5 < this.field35121; var5++) {
               for (int var6 = 0; var6 < this.field35123; var6++) {
                  this.field35133.method28455(var1[var5][var6]);
               }
            }

            float[] var16 = new float[this.field35123];

            for (int var19 = 0; var19 < this.field35121; var19++) {
               for (int var7 = 0; var7 < this.field35125; var7++) {
                  for (int var8 = 0; var8 < this.field35123; var8++) {
                     var16[var8] = var1[var19][var8][var7];
                  }

                  this.field35132.method28455(var16);

                  for (int var27 = 0; var27 < this.field35123; var27++) {
                     var1[var19][var27][var7] = var16[var27];
                  }
               }
            }

            var16 = new float[this.field35121];

            for (int var20 = 0; var20 < this.field35123; var20++) {
               for (int var23 = 0; var23 < this.field35125; var23++) {
                  for (int var28 = 0; var28 < this.field35121; var28++) {
                     var16[var28] = var1[var28][var20][var23];
                  }

                  this.field35131.method28455(var16);

                  for (int var29 = 0; var29 < this.field35121; var29++) {
                     var1[var29][var20][var23] = var16[var29];
                  }
               }
            }
         }

         this.method28391(var1);
      }
   }

   public void method28374(float[] var1, boolean var2) {
      int var5 = Class7008.method21726();
      if (this.field35134) {
         if (var5 > 1 && this.field35135) {
            this.method28383(1, var1, var2);
            this.method28386(1, var1, var2);
         } else {
            this.method28377(1, var1, var2);
            this.method28380(1, var1, var2);
         }

         this.method28389(var1);
      } else {
         if (var5 > 1 && this.field35135 && this.field35121 >= var5 && this.field35123 >= var5 && this.field35125 >= var5) {
            Future[] var20 = new Future[var5];
            int var23 = this.field35121 / var5;

            for (int var27 = 0; var27 < var5; var27++) {
               int var31 = var27 * var23;
               int var37 = var27 == var5 - 1 ? this.field35121 : var31 + var23;
               var20[var27] = Class7008.method21729(new Class434(this, var31, var37, var1, var2));
            }

            try {
               Class7008.method21730(var20);
            } catch (InterruptedException var16) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var16);
            } catch (ExecutionException var17) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var17);
            }

            for (int var28 = 0; var28 < var5; var28++) {
               int var32 = var28 * var23;
               int var38 = var28 == var5 - 1 ? this.field35121 : var32 + var23;
               var20[var28] = Class7008.method21729(new Class1586(this, var32, var38, var1, var2));
            }

            try {
               Class7008.method21730(var20);
            } catch (InterruptedException var14) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var14);
            } catch (ExecutionException var15) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var15);
            }

            var23 = this.field35123 / var5;

            for (int var29 = 0; var29 < var5; var29++) {
               int var33 = var29 * var23;
               int var39 = var29 == var5 - 1 ? this.field35123 : var33 + var23;
               var20[var29] = Class7008.method21729(new Class455(this, var33, var39, var1, var2));
            }

            try {
               Class7008.method21730(var20);
            } catch (InterruptedException var12) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var12);
            } catch (ExecutionException var13) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var13);
            }
         } else {
            for (int var6 = 0; var6 < this.field35121; var6++) {
               int var7 = var6 * this.field35127;

               for (int var8 = 0; var8 < this.field35123; var8++) {
                  this.field35133.method28461(var1, var7 + var8 * this.field35129, var2);
               }
            }

            float[] var18 = new float[this.field35123];

            for (int var21 = 0; var21 < this.field35121; var21++) {
               int var25 = var21 * this.field35127;

               for (int var9 = 0; var9 < this.field35125; var9++) {
                  for (int var10 = 0; var10 < this.field35123; var10++) {
                     int var11 = var25 + var10 * this.field35129 + var9;
                     var18[var10] = var1[var11];
                  }

                  this.field35132.method28459(var18, var2);

                  for (int var34 = 0; var34 < this.field35123; var34++) {
                     int var40 = var25 + var34 * this.field35129 + var9;
                     var1[var40] = var18[var34];
                  }
               }
            }

            var18 = new float[this.field35121];

            for (int var22 = 0; var22 < this.field35123; var22++) {
               int var26 = var22 * this.field35129;

               for (int var30 = 0; var30 < this.field35125; var30++) {
                  for (int var35 = 0; var35 < this.field35121; var35++) {
                     int var41 = var35 * this.field35127 + var26 + var30;
                     var18[var35] = var1[var41];
                  }

                  this.field35131.method28459(var18, var2);

                  for (int var36 = 0; var36 < this.field35121; var36++) {
                     int var42 = var36 * this.field35127 + var26 + var30;
                     var1[var42] = var18[var36];
                  }
               }
            }
         }

         this.method28389(var1);
      }
   }

   public void method28375(Class2378 var1, boolean var2) {
      int var5 = Class7008.method21726();
      if (this.field35134) {
         if (var5 > 1 && this.field35135) {
            this.method28384(1, var1, var2);
            this.method28387(1, var1, var2);
         } else {
            this.method28378(1, var1, var2);
            this.method28381(1, var1, var2);
         }

         this.method28390(var1);
      } else {
         if (var5 > 1 && this.field35135 && this.field35122 >= (long)var5 && this.field35124 >= (long)var5 && this.field35126 >= (long)var5) {
            Future[] var33 = new Future[var5];
            long var35 = this.field35122 / (long)var5;

            for (int var9 = 0; var9 < var5; var9++) {
               long var39 = (long)var9 * var35;
               long var12 = var9 == var5 - 1 ? this.field35122 : var39 + var35;
               var33[var9] = Class7008.method21729(new Class553(this, var39, var12, var1, var2));
            }

            try {
               Class7008.method21730(var33);
            } catch (InterruptedException var30) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var30);
            } catch (ExecutionException var31) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var31);
            }

            for (int var37 = 0; var37 < var5; var37++) {
               long var40 = (long)var37 * var35;
               long var42 = var37 == var5 - 1 ? this.field35122 : var40 + var35;
               var33[var37] = Class7008.method21729(new Class1628(this, var40, var42, var1, var2));
            }

            try {
               Class7008.method21730(var33);
            } catch (InterruptedException var28) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var28);
            } catch (ExecutionException var29) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var29);
            }

            var35 = this.field35124 / (long)var5;

            for (int var38 = 0; var38 < var5; var38++) {
               long var41 = (long)var38 * var35;
               long var43 = var38 == var5 - 1 ? this.field35124 : var41 + var35;
               var33[var38] = Class7008.method21729(new Class432(this, var41, var43, var1, var2));
            }

            try {
               Class7008.method21730(var33);
            } catch (InterruptedException var26) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var26);
            } catch (ExecutionException var27) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var27);
            }
         } else {
            for (long var14 = 0L; var14 < this.field35122; var14++) {
               long var16 = var14 * this.field35128;

               for (long var10 = 0L; var10 < this.field35124; var10++) {
                  this.field35133.method28462(var1, var16 + var10 * this.field35130, var2);
               }
            }

            Class2378 var6 = new Class2378(this.field35124, false);

            for (long var7 = 0L; var7 < this.field35122; var7++) {
               long var18 = var7 * this.field35128;

               for (long var20 = 0L; var20 < this.field35126; var20++) {
                  for (long var22 = 0L; var22 < this.field35124; var22++) {
                     long var24 = var18 + var22 * this.field35130 + var20;
                     var6.method9685(var22, var1.method9651(var24));
                  }

                  this.field35132.method28460(var6, var2);

                  for (long var46 = 0L; var46 < this.field35124; var46++) {
                     long var49 = var18 + var46 * this.field35130 + var20;
                     var1.method9685(var49, var6.method9651(var46));
                  }
               }
            }

            var6 = new Class2378(this.field35122, false);

            for (long var34 = 0L; var34 < this.field35124; var34++) {
               long var44 = var34 * this.field35130;

               for (long var45 = 0L; var45 < this.field35126; var45++) {
                  for (long var47 = 0L; var47 < this.field35122; var47++) {
                     long var50 = var47 * this.field35128 + var44 + var45;
                     var6.method9685(var47, var1.method9651(var50));
                  }

                  this.field35131.method28460(var6, var2);

                  for (long var48 = 0L; var48 < this.field35122; var48++) {
                     long var51 = var48 * this.field35128 + var44 + var45;
                     var1.method9685(var51, var6.method9651(var48));
                  }
               }
            }
         }

         this.method28390(var1);
      }
   }

   public void method28376(float[][][] var1, boolean var2) {
      int var5 = Class7008.method21726();
      if (this.field35134) {
         if (var5 > 1 && this.field35135) {
            this.method28385(1, var1, var2);
            this.method28388(1, var1, var2);
         } else {
            this.method28379(1, var1, var2);
            this.method28382(1, var1, var2);
         }

         this.method28391(var1);
      } else {
         if (var5 > 1 && this.field35135 && this.field35121 >= var5 && this.field35123 >= var5 && this.field35125 >= var5) {
            Future[] var19 = new Future[var5];
            int var22 = this.field35121 / var5;

            for (int var25 = 0; var25 < var5; var25++) {
               int var31 = var25 * var22;
               int var10 = var25 == var5 - 1 ? this.field35121 : var31 + var22;
               var19[var25] = Class7008.method21729(new Class732(this, var31, var10, var1, var2));
            }

            try {
               Class7008.method21730(var19);
            } catch (InterruptedException var15) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var15);
            } catch (ExecutionException var16) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var16);
            }

            for (int var26 = 0; var26 < var5; var26++) {
               int var32 = var26 * var22;
               int var34 = var26 == var5 - 1 ? this.field35121 : var32 + var22;
               var19[var26] = Class7008.method21729(new Class1447(this, var32, var34, var1, var2));
            }

            try {
               Class7008.method21730(var19);
            } catch (InterruptedException var13) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var13);
            } catch (ExecutionException var14) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var14);
            }

            var22 = this.field35123 / var5;

            for (int var27 = 0; var27 < var5; var27++) {
               int var33 = var27 * var22;
               int var35 = var27 == var5 - 1 ? this.field35123 : var33 + var22;
               var19[var27] = Class7008.method21729(new Class585(this, var33, var35, var1, var2));
            }

            try {
               Class7008.method21730(var19);
            } catch (InterruptedException var11) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var11);
            } catch (ExecutionException var12) {
               Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var12);
            }
         } else {
            for (int var6 = 0; var6 < this.field35121; var6++) {
               for (int var7 = 0; var7 < this.field35123; var7++) {
                  this.field35133.method28459(var1[var6][var7], var2);
               }
            }

            float[] var17 = new float[this.field35123];

            for (int var20 = 0; var20 < this.field35121; var20++) {
               for (int var8 = 0; var8 < this.field35125; var8++) {
                  for (int var9 = 0; var9 < this.field35123; var9++) {
                     var17[var9] = var1[var20][var9][var8];
                  }

                  this.field35132.method28459(var17, var2);

                  for (int var28 = 0; var28 < this.field35123; var28++) {
                     var1[var20][var28][var8] = var17[var28];
                  }
               }
            }

            var17 = new float[this.field35121];

            for (int var21 = 0; var21 < this.field35123; var21++) {
               for (int var24 = 0; var24 < this.field35125; var24++) {
                  for (int var29 = 0; var29 < this.field35121; var29++) {
                     var17[var29] = var1[var29][var21][var24];
                  }

                  this.field35131.method28459(var17, var2);

                  for (int var30 = 0; var30 < this.field35121; var30++) {
                     var1[var30][var21][var24] = var17[var30];
                  }
               }
            }
         }

         this.method28391(var1);
      }
   }

   private void method28377(int var1, float[] var2, boolean var3) {
      int var6 = 4 * this.field35123;
      if (this.field35125 == 2) {
         var6 >>= 1;
      }

      float[] var7 = new float[var6];
      if (var1 != -1) {
         for (int var8 = 0; var8 < this.field35121; var8++) {
            int var9 = var8 * this.field35127;

            for (int var10 = 0; var10 < this.field35123; var10++) {
               this.field35133.method28461(var2, var9 + var10 * this.field35129, var3);
            }

            if (this.field35125 <= 2) {
               if (this.field35125 == 2) {
                  for (int var17 = 0; var17 < this.field35123; var17++) {
                     int var27 = var9 + var17 * this.field35129;
                     var7[var17] = var2[var27];
                     var7[this.field35123 + var17] = var2[var27 + 1];
                  }

                  this.field35132.method28461(var7, 0, var3);
                  this.field35132.method28461(var7, this.field35123, var3);

                  for (int var18 = 0; var18 < this.field35123; var18++) {
                     int var28 = var9 + var18 * this.field35129;
                     var2[var28] = var7[var18];
                     var2[var28 + 1] = var7[this.field35123 + var18];
                  }
               }
            } else {
               for (int var16 = 0; var16 < this.field35125; var16 += 4) {
                  for (int var11 = 0; var11 < this.field35123; var11++) {
                     int var12 = var9 + var11 * this.field35129 + var16;
                     int var13 = this.field35123 + var11;
                     var7[var11] = var2[var12];
                     var7[var13] = var2[var12 + 1];
                     var7[var13 + this.field35123] = var2[var12 + 2];
                     var7[var13 + 2 * this.field35123] = var2[var12 + 3];
                  }

                  this.field35132.method28461(var7, 0, var3);
                  this.field35132.method28461(var7, this.field35123, var3);
                  this.field35132.method28461(var7, 2 * this.field35123, var3);
                  this.field35132.method28461(var7, 3 * this.field35123, var3);

                  for (int var23 = 0; var23 < this.field35123; var23++) {
                     int var26 = var9 + var23 * this.field35129 + var16;
                     int var33 = this.field35123 + var23;
                     var2[var26] = var7[var23];
                     var2[var26 + 1] = var7[var33];
                     var2[var26 + 2] = var7[var33 + this.field35123];
                     var2[var26 + 3] = var7[var33 + 2 * this.field35123];
                  }
               }
            }
         }
      } else {
         for (int var14 = 0; var14 < this.field35121; var14++) {
            int var15 = var14 * this.field35127;

            for (int var19 = 0; var19 < this.field35123; var19++) {
               this.field35133.method28457(var2, var15 + var19 * this.field35129);
            }

            if (this.field35125 <= 2) {
               if (this.field35125 == 2) {
                  for (int var21 = 0; var21 < this.field35123; var21++) {
                     int var31 = var15 + var21 * this.field35129;
                     var7[var21] = var2[var31];
                     var7[this.field35123 + var21] = var2[var31 + 1];
                  }

                  this.field35132.method28457(var7, 0);
                  this.field35132.method28457(var7, this.field35123);

                  for (int var22 = 0; var22 < this.field35123; var22++) {
                     int var32 = var15 + var22 * this.field35129;
                     var2[var32] = var7[var22];
                     var2[var32 + 1] = var7[this.field35123 + var22];
                  }
               }
            } else {
               for (int var20 = 0; var20 < this.field35125; var20 += 4) {
                  for (int var24 = 0; var24 < this.field35123; var24++) {
                     int var29 = var15 + var24 * this.field35129 + var20;
                     int var34 = this.field35123 + var24;
                     var7[var24] = var2[var29];
                     var7[var34] = var2[var29 + 1];
                     var7[var34 + this.field35123] = var2[var29 + 2];
                     var7[var34 + 2 * this.field35123] = var2[var29 + 3];
                  }

                  this.field35132.method28457(var7, 0);
                  this.field35132.method28457(var7, this.field35123);
                  this.field35132.method28457(var7, 2 * this.field35123);
                  this.field35132.method28457(var7, 3 * this.field35123);

                  for (int var25 = 0; var25 < this.field35123; var25++) {
                     int var30 = var15 + var25 * this.field35129 + var20;
                     int var35 = this.field35123 + var25;
                     var2[var30] = var7[var25];
                     var2[var30 + 1] = var7[var35];
                     var2[var30 + 2] = var7[var35 + this.field35123];
                     var2[var30 + 3] = var7[var35 + 2 * this.field35123];
                  }
               }
            }
         }
      }
   }

   private void method28378(int var1, Class2378 var2, boolean var3) {
      long var6 = 4L * this.field35124;
      if (this.field35126 == 2L) {
         var6 >>= 1;
      }

      Class2378 var8 = new Class2378(var6);
      if (var1 != -1) {
         for (long var9 = 0L; var9 < this.field35122; var9++) {
            long var11 = var9 * this.field35128;

            for (long var13 = 0L; var13 < this.field35124; var13++) {
               this.field35133.method28462(var2, var11 + var13 * this.field35130, var3);
            }

            if (this.field35126 <= 2L) {
               if (this.field35126 == 2L) {
                  for (long var24 = 0L; var24 < this.field35124; var24++) {
                     long var34 = var11 + var24 * this.field35130;
                     var8.method9685(var24, var2.method9651(var34));
                     var8.method9685(this.field35124 + var24, var2.method9651(var34 + 1L));
                  }

                  this.field35132.method28462(var8, 0L, var3);
                  this.field35132.method28462(var8, this.field35124, var3);

                  for (long var25 = 0L; var25 < this.field35124; var25++) {
                     long var35 = var11 + var25 * this.field35130;
                     var2.method9685(var35, var8.method9651(var25));
                     var2.method9685(var35 + 1L, var8.method9651(this.field35124 + var25));
                  }
               }
            } else {
               for (long var23 = 0L; var23 < this.field35126; var23 += 4L) {
                  for (long var15 = 0L; var15 < this.field35124; var15++) {
                     long var17 = var11 + var15 * this.field35130 + var23;
                     long var19 = this.field35124 + var15;
                     var8.method9685(var15, var2.method9651(var17));
                     var8.method9685(var19, var2.method9651(var17 + 1L));
                     var8.method9685(var19 + this.field35124, var2.method9651(var17 + 2L));
                     var8.method9685(var19 + 2L * this.field35124, var2.method9651(var17 + 3L));
                  }

                  this.field35132.method28462(var8, 0L, var3);
                  this.field35132.method28462(var8, this.field35124, var3);
                  this.field35132.method28462(var8, 2L * this.field35124, var3);
                  this.field35132.method28462(var8, 3L * this.field35124, var3);

                  for (long var30 = 0L; var30 < this.field35124; var30++) {
                     long var33 = var11 + var30 * this.field35130 + var23;
                     long var40 = this.field35124 + var30;
                     var2.method9685(var33, var8.method9651(var30));
                     var2.method9685(var33 + 1L, var8.method9651(var40));
                     var2.method9685(var33 + 2L, var8.method9651(var40 + this.field35124));
                     var2.method9685(var33 + 3L, var8.method9651(var40 + 2L * this.field35124));
                  }
               }
            }
         }
      } else {
         for (long var21 = 0L; var21 < this.field35122; var21++) {
            long var22 = var21 * this.field35128;

            for (long var26 = 0L; var26 < this.field35124; var26++) {
               this.field35133.method28458(var2, var22 + var26 * this.field35130);
            }

            if (this.field35126 <= 2L) {
               if (this.field35126 == 2L) {
                  for (long var28 = 0L; var28 < this.field35124; var28++) {
                     long var38 = var22 + var28 * this.field35130;
                     var8.method9685(var28, var2.method9651(var38));
                     var8.method9685(this.field35124 + var28, var2.method9651(var38 + 1L));
                  }

                  this.field35132.method28458(var8, 0L);
                  this.field35132.method28458(var8, this.field35124);

                  for (long var29 = 0L; var29 < this.field35124; var29++) {
                     long var39 = var22 + var29 * this.field35130;
                     var2.method9685(var39, var8.method9651(var29));
                     var2.method9685(var39 + 1L, var8.method9651(this.field35124 + var29));
                  }
               }
            } else {
               for (long var27 = 0L; var27 < this.field35126; var27 += 4L) {
                  for (long var31 = 0L; var31 < this.field35124; var31++) {
                     long var36 = var22 + var31 * this.field35130 + var27;
                     long var41 = this.field35124 + var31;
                     var8.method9685(var31, var2.method9651(var36));
                     var8.method9685(var41, var2.method9651(var36 + 1L));
                     var8.method9685(var41 + this.field35124, var2.method9651(var36 + 2L));
                     var8.method9685(var41 + 2L * this.field35124, var2.method9651(var36 + 3L));
                  }

                  this.field35132.method28458(var8, 0L);
                  this.field35132.method28458(var8, this.field35124);
                  this.field35132.method28458(var8, 2L * this.field35124);
                  this.field35132.method28458(var8, 3L * this.field35124);

                  for (long var32 = 0L; var32 < this.field35124; var32++) {
                     long var37 = var22 + var32 * this.field35130 + var27;
                     long var42 = this.field35124 + var32;
                     var2.method9685(var37, var8.method9651(var32));
                     var2.method9685(var37 + 1L, var8.method9651(var42));
                     var2.method9685(var37 + 2L, var8.method9651(var42 + this.field35124));
                     var2.method9685(var37 + 3L, var8.method9651(var42 + 2L * this.field35124));
                  }
               }
            }
         }
      }
   }

   private void method28379(int var1, float[][][] var2, boolean var3) {
      int var6 = 4 * this.field35123;
      if (this.field35126 == 2L) {
         var6 >>= 1;
      }

      float[] var7 = new float[var6];
      if (var1 != -1) {
         for (int var8 = 0; var8 < this.field35121; var8++) {
            for (int var9 = 0; var9 < this.field35123; var9++) {
               this.field35133.method28459(var2[var8][var9], var3);
            }

            if (this.field35125 <= 2) {
               if (this.field35125 == 2) {
                  for (int var14 = 0; var14 < this.field35123; var14++) {
                     var7[var14] = var2[var8][var14][0];
                     var7[this.field35123 + var14] = var2[var8][var14][1];
                  }

                  this.field35132.method28461(var7, 0, var3);
                  this.field35132.method28461(var7, this.field35123, var3);

                  for (int var15 = 0; var15 < this.field35123; var15++) {
                     var2[var8][var15][0] = var7[var15];
                     var2[var8][var15][1] = var7[this.field35123 + var15];
                  }
               }
            } else {
               for (int var13 = 0; var13 < this.field35125; var13 += 4) {
                  for (int var10 = 0; var10 < this.field35123; var10++) {
                     int var11 = this.field35123 + var10;
                     var7[var10] = var2[var8][var10][var13];
                     var7[var11] = var2[var8][var10][var13 + 1];
                     var7[var11 + this.field35123] = var2[var8][var10][var13 + 2];
                     var7[var11 + 2 * this.field35123] = var2[var8][var10][var13 + 3];
                  }

                  this.field35132.method28461(var7, 0, var3);
                  this.field35132.method28461(var7, this.field35123, var3);
                  this.field35132.method28461(var7, 2 * this.field35123, var3);
                  this.field35132.method28461(var7, 3 * this.field35123, var3);

                  for (int var20 = 0; var20 < this.field35123; var20++) {
                     int var23 = this.field35123 + var20;
                     var2[var8][var20][var13] = var7[var20];
                     var2[var8][var20][var13 + 1] = var7[var23];
                     var2[var8][var20][var13 + 2] = var7[var23 + this.field35123];
                     var2[var8][var20][var13 + 3] = var7[var23 + 2 * this.field35123];
                  }
               }
            }
         }
      } else {
         for (int var12 = 0; var12 < this.field35121; var12++) {
            for (int var16 = 0; var16 < this.field35123; var16++) {
               this.field35133.method28455(var2[var12][var16]);
            }

            if (this.field35125 <= 2) {
               if (this.field35125 == 2) {
                  for (int var18 = 0; var18 < this.field35123; var18++) {
                     var7[var18] = var2[var12][var18][0];
                     var7[this.field35123 + var18] = var2[var12][var18][1];
                  }

                  this.field35132.method28457(var7, 0);
                  this.field35132.method28457(var7, this.field35123);

                  for (int var19 = 0; var19 < this.field35123; var19++) {
                     var2[var12][var19][0] = var7[var19];
                     var2[var12][var19][1] = var7[this.field35123 + var19];
                  }
               }
            } else {
               for (int var17 = 0; var17 < this.field35125; var17 += 4) {
                  for (int var21 = 0; var21 < this.field35123; var21++) {
                     int var24 = this.field35123 + var21;
                     var7[var21] = var2[var12][var21][var17];
                     var7[var24] = var2[var12][var21][var17 + 1];
                     var7[var24 + this.field35123] = var2[var12][var21][var17 + 2];
                     var7[var24 + 2 * this.field35123] = var2[var12][var21][var17 + 3];
                  }

                  this.field35132.method28457(var7, 0);
                  this.field35132.method28457(var7, this.field35123);
                  this.field35132.method28457(var7, 2 * this.field35123);
                  this.field35132.method28457(var7, 3 * this.field35123);

                  for (int var22 = 0; var22 < this.field35123; var22++) {
                     int var25 = this.field35123 + var22;
                     var2[var12][var22][var17] = var7[var22];
                     var2[var12][var22][var17 + 1] = var7[var25];
                     var2[var12][var22][var17 + 2] = var7[var25 + this.field35123];
                     var2[var12][var22][var17 + 3] = var7[var25 + 2 * this.field35123];
                  }
               }
            }
         }
      }
   }

   private void method28380(int var1, float[] var2, boolean var3) {
      int var6 = 4 * this.field35121;
      if (this.field35125 == 2) {
         var6 >>= 1;
      }

      float[] var7 = new float[var6];
      if (var1 != -1) {
         if (this.field35125 <= 2) {
            if (this.field35125 == 2) {
               for (int var8 = 0; var8 < this.field35123; var8++) {
                  int var9 = var8 * this.field35129;

                  for (int var10 = 0; var10 < this.field35121; var10++) {
                     int var12 = var10 * this.field35127 + var9;
                     var7[var10] = var2[var12];
                     var7[this.field35121 + var10] = var2[var12 + 1];
                  }

                  this.field35131.method28461(var7, 0, var3);
                  this.field35131.method28461(var7, this.field35121, var3);

                  for (int var20 = 0; var20 < this.field35121; var20++) {
                     int var28 = var20 * this.field35127 + var9;
                     var2[var28] = var7[var20];
                     var2[var28 + 1] = var7[this.field35121 + var20];
                  }
               }
            }
         } else {
            for (int var14 = 0; var14 < this.field35123; var14++) {
               int var17 = var14 * this.field35129;

               for (int var21 = 0; var21 < this.field35125; var21 += 4) {
                  for (int var11 = 0; var11 < this.field35121; var11++) {
                     int var29 = var11 * this.field35127 + var17 + var21;
                     int var13 = this.field35121 + var11;
                     var7[var11] = var2[var29];
                     var7[var13] = var2[var29 + 1];
                     var7[var13 + this.field35121] = var2[var29 + 2];
                     var7[var13 + 2 * this.field35121] = var2[var29 + 3];
                  }

                  this.field35131.method28461(var7, 0, var3);
                  this.field35131.method28461(var7, this.field35121, var3);
                  this.field35131.method28461(var7, 2 * this.field35121, var3);
                  this.field35131.method28461(var7, 3 * this.field35121, var3);

                  for (int var25 = 0; var25 < this.field35121; var25++) {
                     int var30 = var25 * this.field35127 + var17 + var21;
                     int var35 = this.field35121 + var25;
                     var2[var30] = var7[var25];
                     var2[var30 + 1] = var7[var35];
                     var2[var30 + 2] = var7[var35 + this.field35121];
                     var2[var30 + 3] = var7[var35 + 2 * this.field35121];
                  }
               }
            }
         }
      } else if (this.field35125 <= 2) {
         if (this.field35125 == 2) {
            for (int var15 = 0; var15 < this.field35123; var15++) {
               int var18 = var15 * this.field35129;

               for (int var22 = 0; var22 < this.field35121; var22++) {
                  int var31 = var22 * this.field35127 + var18;
                  var7[var22] = var2[var31];
                  var7[this.field35121 + var22] = var2[var31 + 1];
               }

               this.field35131.method28457(var7, 0);
               this.field35131.method28457(var7, this.field35121);

               for (int var23 = 0; var23 < this.field35121; var23++) {
                  int var32 = var23 * this.field35127 + var18;
                  var2[var32] = var7[var23];
                  var2[var32 + 1] = var7[this.field35121 + var23];
               }
            }
         }
      } else {
         for (int var16 = 0; var16 < this.field35123; var16++) {
            int var19 = var16 * this.field35129;

            for (int var24 = 0; var24 < this.field35125; var24 += 4) {
               for (int var26 = 0; var26 < this.field35121; var26++) {
                  int var33 = var26 * this.field35127 + var19 + var24;
                  int var36 = this.field35121 + var26;
                  var7[var26] = var2[var33];
                  var7[var36] = var2[var33 + 1];
                  var7[var36 + this.field35121] = var2[var33 + 2];
                  var7[var36 + 2 * this.field35121] = var2[var33 + 3];
               }

               this.field35131.method28457(var7, 0);
               this.field35131.method28457(var7, this.field35121);
               this.field35131.method28457(var7, 2 * this.field35121);
               this.field35131.method28457(var7, 3 * this.field35121);

               for (int var27 = 0; var27 < this.field35121; var27++) {
                  int var34 = var27 * this.field35127 + var19 + var24;
                  int var37 = this.field35121 + var27;
                  var2[var34] = var7[var27];
                  var2[var34 + 1] = var7[var37];
                  var2[var34 + 2] = var7[var37 + this.field35121];
                  var2[var34 + 3] = var7[var37 + 2 * this.field35121];
               }
            }
         }
      }
   }

   private void method28381(int var1, Class2378 var2, boolean var3) {
      long var6 = 4L * this.field35122;
      if (this.field35126 == 2L) {
         var6 >>= 1;
      }

      Class2378 var8 = new Class2378(var6);
      if (var1 != -1) {
         if (this.field35126 <= 2L) {
            if (this.field35126 == 2L) {
               for (long var9 = 0L; var9 < this.field35124; var9++) {
                  long var11 = var9 * this.field35130;

                  for (long var13 = 0L; var13 < this.field35122; var13++) {
                     long var17 = var13 * this.field35128 + var11;
                     var8.method9685(var13, var2.method9651(var17));
                     var8.method9685(this.field35122 + var13, var2.method9651(var17 + 1L));
                  }

                  this.field35131.method28462(var8, 0L, var3);
                  this.field35131.method28462(var8, this.field35122, var3);

                  for (long var27 = 0L; var27 < this.field35122; var27++) {
                     long var35 = var27 * this.field35128 + var11;
                     var2.method9685(var35, var8.method9651(var27));
                     var2.method9685(var35 + 1L, var8.method9651(this.field35122 + var27));
                  }
               }
            }
         } else {
            for (long var21 = 0L; var21 < this.field35124; var21++) {
               long var24 = var21 * this.field35130;

               for (long var28 = 0L; var28 < this.field35126; var28 += 4L) {
                  for (long var15 = 0L; var15 < this.field35122; var15++) {
                     long var36 = var15 * this.field35128 + var24 + var28;
                     long var19 = this.field35122 + var15;
                     var8.method9685(var15, var2.method9651(var36));
                     var8.method9685(var19, var2.method9651(var36 + 1L));
                     var8.method9685(var19 + this.field35122, var2.method9651(var36 + 2L));
                     var8.method9685(var19 + 2L * this.field35122, var2.method9651(var36 + 3L));
                  }

                  this.field35131.method28462(var8, 0L, var3);
                  this.field35131.method28462(var8, this.field35122, var3);
                  this.field35131.method28462(var8, 2L * this.field35122, var3);
                  this.field35131.method28462(var8, 3L * this.field35122, var3);

                  for (long var32 = 0L; var32 < this.field35122; var32++) {
                     long var37 = var32 * this.field35128 + var24 + var28;
                     long var42 = this.field35122 + var32;
                     var2.method9685(var37, var8.method9651(var32));
                     var2.method9685(var37 + 1L, var8.method9651(var42));
                     var2.method9685(var37 + 2L, var8.method9651(var42 + this.field35122));
                     var2.method9685(var37 + 3L, var8.method9651(var42 + 2L * this.field35122));
                  }
               }
            }
         }
      } else if (this.field35126 <= 2L) {
         if (this.field35126 == 2L) {
            for (long var22 = 0L; var22 < this.field35124; var22++) {
               long var25 = var22 * this.field35130;

               for (long var29 = 0L; var29 < this.field35122; var29++) {
                  long var38 = var29 * this.field35128 + var25;
                  var8.method9685(var29, var2.method9651(var38));
                  var8.method9685(this.field35122 + var29, var2.method9651(var38 + 1L));
               }

               this.field35131.method28458(var8, 0L);
               this.field35131.method28458(var8, this.field35122);

               for (long var30 = 0L; var30 < this.field35122; var30++) {
                  long var39 = var30 * this.field35128 + var25;
                  var2.method9685(var39, var8.method9651(var30));
                  var2.method9685(var39 + 1L, var8.method9651(this.field35122 + var30));
               }
            }
         }
      } else {
         for (long var23 = 0L; var23 < this.field35124; var23++) {
            long var26 = var23 * this.field35130;

            for (long var31 = 0L; var31 < this.field35126; var31 += 4L) {
               for (long var33 = 0L; var33 < this.field35122; var33++) {
                  long var40 = var33 * this.field35128 + var26 + var31;
                  long var43 = this.field35122 + var33;
                  var8.method9685(var33, var2.method9651(var40));
                  var8.method9685(var43, var2.method9651(var40 + 1L));
                  var8.method9685(var43 + this.field35122, var2.method9651(var40 + 2L));
                  var8.method9685(var43 + 2L * this.field35122, var2.method9651(var40 + 3L));
               }

               this.field35131.method28458(var8, 0L);
               this.field35131.method28458(var8, this.field35122);
               this.field35131.method28458(var8, 2L * this.field35122);
               this.field35131.method28458(var8, 3L * this.field35122);

               for (long var34 = 0L; var34 < this.field35122; var34++) {
                  long var41 = var34 * this.field35128 + var26 + var31;
                  long var44 = this.field35122 + var34;
                  var2.method9685(var41, var8.method9651(var34));
                  var2.method9685(var41 + 1L, var8.method9651(var44));
                  var2.method9685(var41 + 2L, var8.method9651(var44 + this.field35122));
                  var2.method9685(var41 + 3L, var8.method9651(var44 + 2L * this.field35122));
               }
            }
         }
      }
   }

   private void method28382(int var1, float[][][] var2, boolean var3) {
      int var6 = 4 * this.field35121;
      if (this.field35125 == 2) {
         var6 >>= 1;
      }

      float[] var7 = new float[var6];
      if (var1 != -1) {
         if (this.field35125 <= 2) {
            if (this.field35125 == 2) {
               for (int var8 = 0; var8 < this.field35123; var8++) {
                  for (int var9 = 0; var9 < this.field35121; var9++) {
                     var7[var9] = var2[var9][var8][0];
                     var7[this.field35121 + var9] = var2[var9][var8][1];
                  }

                  this.field35131.method28461(var7, 0, var3);
                  this.field35131.method28461(var7, this.field35121, var3);

                  for (int var15 = 0; var15 < this.field35121; var15++) {
                     var2[var15][var8][0] = var7[var15];
                     var2[var15][var8][1] = var7[this.field35121 + var15];
                  }
               }
            }
         } else {
            for (int var12 = 0; var12 < this.field35123; var12++) {
               for (int var16 = 0; var16 < this.field35125; var16 += 4) {
                  for (int var10 = 0; var10 < this.field35121; var10++) {
                     int var11 = this.field35121 + var10;
                     var7[var10] = var2[var10][var12][var16];
                     var7[var11] = var2[var10][var12][var16 + 1];
                     var7[var11 + this.field35121] = var2[var10][var12][var16 + 2];
                     var7[var11 + 2 * this.field35121] = var2[var10][var12][var16 + 3];
                  }

                  this.field35131.method28461(var7, 0, var3);
                  this.field35131.method28461(var7, this.field35121, var3);
                  this.field35131.method28461(var7, 2 * this.field35121, var3);
                  this.field35131.method28461(var7, 3 * this.field35121, var3);

                  for (int var20 = 0; var20 < this.field35121; var20++) {
                     int var23 = this.field35121 + var20;
                     var2[var20][var12][var16] = var7[var20];
                     var2[var20][var12][var16 + 1] = var7[var23];
                     var2[var20][var12][var16 + 2] = var7[var23 + this.field35121];
                     var2[var20][var12][var16 + 3] = var7[var23 + 2 * this.field35121];
                  }
               }
            }
         }
      } else if (this.field35125 <= 2) {
         if (this.field35125 == 2) {
            for (int var13 = 0; var13 < this.field35123; var13++) {
               for (int var17 = 0; var17 < this.field35121; var17++) {
                  var7[var17] = var2[var17][var13][0];
                  var7[this.field35121 + var17] = var2[var17][var13][1];
               }

               this.field35131.method28457(var7, 0);
               this.field35131.method28457(var7, this.field35121);

               for (int var18 = 0; var18 < this.field35121; var18++) {
                  var2[var18][var13][0] = var7[var18];
                  var2[var18][var13][1] = var7[this.field35121 + var18];
               }
            }
         }
      } else {
         for (int var14 = 0; var14 < this.field35123; var14++) {
            for (int var19 = 0; var19 < this.field35125; var19 += 4) {
               for (int var21 = 0; var21 < this.field35121; var21++) {
                  int var24 = this.field35121 + var21;
                  var7[var21] = var2[var21][var14][var19];
                  var7[var24] = var2[var21][var14][var19 + 1];
                  var7[var24 + this.field35121] = var2[var21][var14][var19 + 2];
                  var7[var24 + 2 * this.field35121] = var2[var21][var14][var19 + 3];
               }

               this.field35131.method28457(var7, 0);
               this.field35131.method28457(var7, this.field35121);
               this.field35131.method28457(var7, 2 * this.field35121);
               this.field35131.method28457(var7, 3 * this.field35121);

               for (int var22 = 0; var22 < this.field35121; var22++) {
                  int var25 = this.field35121 + var22;
                  var2[var22][var14][var19] = var7[var22];
                  var2[var22][var14][var19 + 1] = var7[var25];
                  var2[var22][var14][var19 + 2] = var7[var25 + this.field35121];
                  var2[var22][var14][var19 + 3] = var7[var25 + 2 * this.field35121];
               }
            }
         }
      }
   }

   private void method28383(int var1, float[] var2, boolean var3) {
      int var6 = Class7008.method21726() > this.field35121 ? this.field35121 : Class7008.method21726();
      int var7 = 4 * this.field35123;
      if (this.field35125 == 2) {
         var7 >>= 1;
      }

      int var8 = var7;
      Future[] var9 = new Future[var6];

      for (int var10 = 0; var10 < var6; var10++) {
         var9[var10] = Class7008.method21729(new Class1504(this, var8, var1, var10, var6, var2, var3));
      }

      try {
         Class7008.method21730(var9);
      } catch (InterruptedException var12) {
         Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var12);
      } catch (ExecutionException var13) {
         Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var13);
      }
   }

   private void method28384(int var1, Class2378 var2, boolean var3) {
      int var6 = (int)((long)Class7008.method21726() > this.field35122 ? this.field35122 : (long)Class7008.method21726());
      long var7 = 4L * this.field35124;
      if (this.field35126 == 2L) {
         var7 >>= 1;
      }

      long var9 = var7;
      Future[] var11 = new Future[var6];

      for (int var12 = 0; var12 < var6; var12++) {
         long var13 = (long)var12;
         var11[var12] = Class7008.method21729(new Class716(this, var9, var1, var13, var6, var2, var3));
      }

      try {
         Class7008.method21730(var11);
      } catch (InterruptedException var15) {
         Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var15);
      } catch (ExecutionException var16) {
         Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var16);
      }
   }

   private void method28385(int var1, float[][][] var2, boolean var3) {
      int var6 = Class7008.method21726() > this.field35121 ? this.field35121 : Class7008.method21726();
      int var7 = 4 * this.field35123;
      if (this.field35125 == 2) {
         var7 >>= 1;
      }

      int var8 = var7;
      Future[] var9 = new Future[var6];

      for (int var10 = 0; var10 < var6; var10++) {
         var9[var10] = Class7008.method21729(new Class589(this, var8, var1, var10, var6, var2, var3));
      }

      try {
         Class7008.method21730(var9);
      } catch (InterruptedException var12) {
         Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var12);
      } catch (ExecutionException var13) {
         Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var13);
      }
   }

   private void method28386(int var1, float[] var2, boolean var3) {
      int var6 = Class7008.method21726() > this.field35123 ? this.field35123 : Class7008.method21726();
      int var7 = 4 * this.field35121;
      if (this.field35125 == 2) {
         var7 >>= 1;
      }

      int var8 = var7;
      Future[] var9 = new Future[var6];

      for (int var10 = 0; var10 < var6; var10++) {
         var9[var10] = Class7008.method21729(new Class431(this, var8, var1, var10, var6, var2, var3));
      }

      try {
         Class7008.method21730(var9);
      } catch (InterruptedException var12) {
         Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var12);
      } catch (ExecutionException var13) {
         Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var13);
      }
   }

   private void method28387(int var1, Class2378 var2, boolean var3) {
      int var6 = (int)((long)Class7008.method21726() > this.field35124 ? this.field35124 : (long)Class7008.method21726());
      long var7 = 4L * this.field35122;
      if (this.field35126 == 2L) {
         var7 >>= 1;
      }

      long var9 = var7;
      Future[] var11 = new Future[var6];

      for (int var12 = 0; var12 < var6; var12++) {
         long var13 = (long)var12;
         var11[var12] = Class7008.method21729(new Class750(this, var9, var1, var13, var6, var2, var3));
      }

      try {
         Class7008.method21730(var11);
      } catch (InterruptedException var15) {
         Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var15);
      } catch (ExecutionException var16) {
         Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var16);
      }
   }

   private void method28388(int var1, float[][][] var2, boolean var3) {
      int var6 = Class7008.method21726() > this.field35123 ? this.field35123 : Class7008.method21726();
      int var7 = 4 * this.field35121;
      if (this.field35125 == 2) {
         var7 >>= 1;
      }

      int var8 = var7;
      Future[] var9 = new Future[var6];

      for (int var10 = 0; var10 < var6; var10++) {
         var9[var10] = Class7008.method21729(new Class1395(this, var8, var1, var10, var6, var2, var3));
      }

      try {
         Class7008.method21730(var9);
      } catch (InterruptedException var12) {
         Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var12);
      } catch (ExecutionException var13) {
         Logger.getLogger(Class8162.class.getName()).log(Level.SEVERE, null, var13);
      }
   }

   private void method28389(float[] var1) {
      for (int var4 = 0; var4 <= this.field35121 / 2; var4++) {
         int var5 = (this.field35121 - var4) % this.field35121;
         int var6 = var4 * this.field35127;
         int var7 = var5 * this.field35127;

         for (int var8 = 0; var8 <= this.field35123 / 2; var8++) {
            int var9 = (this.field35123 - var8) % this.field35123;
            int var10 = var8 * this.field35129;
            int var11 = var9 * this.field35129;

            for (int var12 = 0; var12 <= this.field35125 / 2; var12++) {
               int var13 = (this.field35125 - var12) % this.field35125;
               int var14 = var6 + var11 + var12;
               int var15 = var6 + var10 + var13;
               int var16 = var7 + var10 + var12;
               int var17 = var7 + var11 + var13;
               int var18 = var7 + var11 + var12;
               int var19 = var7 + var10 + var13;
               int var20 = var6 + var10 + var12;
               int var21 = var6 + var11 + var13;
               float var22 = var1[var14];
               float var23 = var1[var15];
               float var24 = var1[var16];
               float var25 = var1[var17];
               float var26 = var1[var18];
               float var27 = var1[var19];
               float var28 = var1[var20];
               float var29 = var1[var21];
               var1[var20] = (var22 + var23 + var24 - var25) / 2.0F;
               var1[var16] = (var26 + var27 + var28 - var29) / 2.0F;
               var1[var14] = (var28 + var29 + var26 - var27) / 2.0F;
               var1[var18] = (var24 + var25 + var22 - var23) / 2.0F;
               var1[var15] = (var29 + var28 + var27 - var26) / 2.0F;
               var1[var19] = (var25 + var24 + var23 - var22) / 2.0F;
               var1[var21] = (var23 + var22 + var25 - var24) / 2.0F;
               var1[var17] = (var27 + var26 + var29 - var28) / 2.0F;
            }
         }
      }
   }

   private void method28390(Class2378 var1) {
      for (long var4 = 0L; var4 <= this.field35122 / 2L; var4++) {
         long var6 = (this.field35122 - var4) % this.field35122;
         long var8 = var4 * this.field35128;
         long var10 = var6 * this.field35128;

         for (long var12 = 0L; var12 <= this.field35124 / 2L; var12++) {
            long var14 = (this.field35124 - var12) % this.field35124;
            long var16 = var12 * this.field35130;
            long var18 = var14 * this.field35130;

            for (long var20 = 0L; var20 <= this.field35126 / 2L; var20++) {
               long var22 = (this.field35126 - var20) % this.field35126;
               long var24 = var8 + var18 + var20;
               long var26 = var8 + var16 + var22;
               long var28 = var10 + var16 + var20;
               long var30 = var10 + var18 + var22;
               long var32 = var10 + var18 + var20;
               long var34 = var10 + var16 + var22;
               long var36 = var8 + var16 + var20;
               long var38 = var8 + var18 + var22;
               float var40 = var1.method9651(var24);
               float var41 = var1.method9651(var26);
               float var42 = var1.method9651(var28);
               float var43 = var1.method9651(var30);
               float var44 = var1.method9651(var32);
               float var45 = var1.method9651(var34);
               float var46 = var1.method9651(var36);
               float var47 = var1.method9651(var38);
               var1.method9685(var36, (var40 + var41 + var42 - var43) / 2.0F);
               var1.method9685(var28, (var44 + var45 + var46 - var47) / 2.0F);
               var1.method9685(var24, (var46 + var47 + var44 - var45) / 2.0F);
               var1.method9685(var32, (var42 + var43 + var40 - var41) / 2.0F);
               var1.method9685(var26, (var47 + var46 + var45 - var44) / 2.0F);
               var1.method9685(var34, (var43 + var42 + var41 - var40) / 2.0F);
               var1.method9685(var38, (var41 + var40 + var43 - var42) / 2.0F);
               var1.method9685(var30, (var45 + var44 + var47 - var46) / 2.0F);
            }
         }
      }
   }

   private void method28391(float[][][] var1) {
      for (int var4 = 0; var4 <= this.field35121 / 2; var4++) {
         int var5 = (this.field35121 - var4) % this.field35121;

         for (int var6 = 0; var6 <= this.field35123 / 2; var6++) {
            int var7 = (this.field35123 - var6) % this.field35123;

            for (int var8 = 0; var8 <= this.field35125 / 2; var8++) {
               int var9 = (this.field35125 - var8) % this.field35125;
               float var10 = var1[var4][var7][var8];
               float var11 = var1[var4][var6][var9];
               float var12 = var1[var5][var6][var8];
               float var13 = var1[var5][var7][var9];
               float var14 = var1[var5][var7][var8];
               float var15 = var1[var5][var6][var9];
               float var16 = var1[var4][var6][var8];
               float var17 = var1[var4][var7][var9];
               var1[var4][var6][var8] = (var10 + var11 + var12 - var13) / 2.0F;
               var1[var5][var6][var8] = (var14 + var15 + var16 - var17) / 2.0F;
               var1[var4][var7][var8] = (var16 + var17 + var14 - var15) / 2.0F;
               var1[var5][var7][var8] = (var12 + var13 + var10 - var11) / 2.0F;
               var1[var4][var6][var9] = (var17 + var16 + var15 - var14) / 2.0F;
               var1[var5][var6][var9] = (var13 + var12 + var11 - var10) / 2.0F;
               var1[var4][var7][var9] = (var11 + var10 + var13 - var12) / 2.0F;
               var1[var5][var7][var9] = (var15 + var14 + var17 - var16) / 2.0F;
            }
         }
      }
   }

   // $VF: synthetic method
   public static int method28392(Class8162 var0) {
      return var0.field35127;
   }

   // $VF: synthetic method
   public static int method28393(Class8162 var0) {
      return var0.field35123;
   }

   // $VF: synthetic method
   public static int method28394(Class8162 var0) {
      return var0.field35129;
   }

   // $VF: synthetic method
   public static Class8174 method28395(Class8162 var0) {
      return var0.field35133;
   }

   // $VF: synthetic method
   public static int method28396(Class8162 var0) {
      return var0.field35125;
   }

   // $VF: synthetic method
   public static Class8174 method28397(Class8162 var0) {
      return var0.field35132;
   }

   // $VF: synthetic method
   public static int method28398(Class8162 var0) {
      return var0.field35121;
   }

   // $VF: synthetic method
   public static Class8174 method28399(Class8162 var0) {
      return var0.field35131;
   }

   // $VF: synthetic method
   public static long method28400(Class8162 var0) {
      return var0.field35124;
   }

   // $VF: synthetic method
   public static long method28401(Class8162 var0) {
      return var0.field35126;
   }

   // $VF: synthetic method
   public static long method28402(Class8162 var0) {
      return var0.field35122;
   }

   // $VF: synthetic method
   public static long method28403(Class8162 var0) {
      return var0.field35128;
   }

   // $VF: synthetic method
   public static long method28404(Class8162 var0) {
      return var0.field35130;
   }
}
