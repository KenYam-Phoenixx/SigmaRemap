package mapped;

import java.util.Arrays;

public class Class1664 implements Class1663 {
   private static String[] field9061;
   private final Class1677 field9062;
   private final int field9063;
   private final int field9064;
   private final int field9065;
   private final int field9066;
   private final int field9067;
   private final int field9068;
   private final int field9069;
   private int[] field9070;
   private Class7380[] field9071;
   private Biome[] field9072;
   private final int field9073;
   private Class8391 field9074;
   private static final Class9712 field9075 = new Class9712(int.class, 16);
   private static final Class9712 field9076 = new Class9712(Class7380.class, 16);
   private static final Class9712 field9077 = new Class9712(Biome.class, 16);

   public Class1664(Class1677 var1, BlockPos var2, BlockPos var3, int var4) {
      this.field9062 = var1;
      int var7 = var2.method8304() - var4 >> 4;
      int var8 = var2.getY() - var4 >> 4;
      int var9 = var2.method8306() - var4 >> 4;
      int var10 = var3.method8304() + var4 >> 4;
      int var11 = var3.getY() + var4 >> 4;
      int var12 = var3.method8306() + var4 >> 4;
      this.field9066 = var10 - var7 + 1 << 4;
      this.field9067 = var11 - var8 + 1 << 4;
      this.field9068 = var12 - var9 + 1 << 4;
      this.field9069 = this.field9066 * this.field9068;
      this.field9073 = this.field9066 * this.field9067 * this.field9068;
      this.field9063 = var7 << 4;
      this.field9064 = var8 << 4;
      this.field9065 = var9 << 4;
   }

   public int method7023(BlockPos var1) {
      int var4 = var1.method8304() - this.field9063;
      if (var4 >= 0 && var4 < this.field9066) {
         int var5 = var1.getY() - this.field9064;
         if (var5 >= 0 && var5 < this.field9067) {
            int var6 = var1.method8306() - this.field9065;
            return var6 >= 0 && var6 < this.field9068 ? var5 * this.field9069 + var6 * this.field9066 + var4 : -1;
         } else {
            return -1;
         }
      } else {
         return -1;
      }
   }

   @Override
   public int method7020(Class1977 var1, BlockPos var2) {
      return this.field9062.method7020(var1, var2);
   }

   @Override
   public Class7380 method6738(BlockPos var1) {
      int var4 = this.method7023(var1);
      if (var4 >= 0 && var4 < this.field9073 && this.field9071 != null) {
         Class7380 var5 = this.field9071[var4];
         if (var5 == null) {
            var5 = this.field9062.method6738(var1);
            this.field9071[var4] = var5;
         }

         return var5;
      } else {
         return this.field9062.method6738(var1);
      }
   }

   public void method7024() {
      if (this.field9070 == null) {
         this.field9070 = (int[])field9075.method38051(this.field9073);
      }

      if (this.field9071 == null) {
         this.field9071 = (Class7380[])field9076.method38051(this.field9073);
      }

      if (this.field9072 == null) {
         this.field9072 = (Biome[])field9077.method38051(this.field9073);
      }

      Arrays.fill(this.field9070, -1);
      Arrays.fill(this.field9071, null);
      Arrays.fill(this.field9072, null);
      this.method7025();
   }

   private void method7025() {
      if (this.field9066 == 48 && this.field9067 == 48 && this.field9068 == 48) {
         Class1674 var3 = this.field9062.method7177(1, 1);
         Class2001 var4 = new Class2001();

         for (int var5 = 16; var5 < 32; var5++) {
            int var6 = var5 * this.field9069;

            for (int var7 = 16; var7 < 32; var7++) {
               int var8 = var7 * this.field9066;

               for (int var9 = 16; var9 < 32; var9++) {
                  var4.method8384(this.field9063 + var9, this.field9064 + var5, this.field9065 + var7);
                  int var10 = var6 + var8 + var9;
                  Class7380 var11 = var3.method6738(var4);
                  this.field9071[var10] = var11;
               }
            }
         }
      }
   }

   public void method7026() {
      field9075.method38052(this.field9070);
      this.field9070 = null;
      field9076.method38052(this.field9071);
      this.field9071 = null;
      field9077.method38052(this.field9072);
      this.field9072 = null;
   }

   public int[] method7027() {
      return this.field9070;
   }

   public Biome method7028(BlockPos var1) {
      int var4 = this.method7023(var1);
      if (var4 >= 0 && var4 < this.field9073 && this.field9072 != null) {
         Biome var5 = this.field9072[var4];
         if (var5 == null) {
            var5 = this.field9062.method7176(var1);
            this.field9072[var4] = var5;
         }

         return var5;
      } else {
         return this.field9062.method7176(var1);
      }
   }

   @Override
   public Class944 method6759(BlockPos var1) {
      return this.field9062.method7029(var1, Class2206.field14423);
   }

   public Class944 method7029(BlockPos var1, Class2206 var2) {
      return this.field9062.method7029(var1, var2);
   }

   @Override
   public boolean method7022(BlockPos var1) {
      return this.field9062.method7022(var1);
   }

   @Override
   public Class7379 method6739(BlockPos var1) {
      return this.method6738(var1).method23449();
   }

   @Override
   public int method6878(BlockPos var1, Class8980 var2) {
      return this.field9062.method6878(var1, var2);
   }

   @Override
   public Class196 method6737() {
      return this.field9062.method6737();
   }

   public Class8391 method7030() {
      return this.field9074;
   }

   public void method7031(Class8391 var1) {
      this.field9074 = var1;
   }

   @Override
   public float method6877(Direction var1, boolean var2) {
      return this.field9062.method6877(var1, var2);
   }
}
