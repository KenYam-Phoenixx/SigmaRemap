package net.minecraft.util;

import java.util.Random;

public class RangedInteger {
   private final int field35929;
   private final int field35930;

   public RangedInteger(int var1, int var2) {
      if (var2 >= var1) {
         this.field35929 = var1;
         this.field35930 = var2;
      } else {
         throw new IllegalArgumentException("max must be >= minInclusive! Given minInclusive: " + var1 + ", Given max: " + var2);
      }
   }

   public static RangedInteger method29318(int var0, int var1) {
      return new RangedInteger(var0, var1);
   }

   public int method29319(Random var1) {
      return this.field35929 != this.field35930 ? var1.nextInt(this.field35930 - this.field35929 + 1) + this.field35929 : this.field35929;
   }

   public int method29320() {
      return this.field35929;
   }

   public int method29321() {
      return this.field35930;
   }

   @Override
   public String toString() {
      return "IntRange[" + this.field35929 + "-" + this.field35930 + "]";
   }
}
