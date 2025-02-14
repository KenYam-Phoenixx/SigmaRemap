package mapped;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

public class Class7194 extends Class7195<Class4728> {
   public Class7194(Codec<Class4728> var1, int var2) {
      super(var1, var2);
   }

   public boolean method22602(Random var1, int var2, int var3, Class4728 var4) {
      return var1.nextFloat() <= var4.field22399;
   }

   public boolean method22603(
           IChunk var1, Function<BlockPos, Biome> var2, Random var3, int var4, int var5, int var6, int var7, int var8, BitSet var9, Class4728 var10
   ) {
      int var13 = (this.method22607() * 2 - 1) * 16;
      int var14 = var3.nextInt(var3.nextInt(var3.nextInt(this.method22592()) + 1) + 1);

      for (int var15 = 0; var15 < var14; var15++) {
         double var16 = (double)(var5 * 16 + var3.nextInt(16));
         double var18 = (double)this.method22595(var3);
         double var20 = (double)(var6 * 16 + var3.nextInt(16));
         int var22 = 1;
         if (var3.nextInt(4) == 0) {
            double var24 = 0.5;
            float var26 = 1.0F + var3.nextFloat() * 6.0F;
            this.method22599(var1, var2, var3.nextLong(), var4, var7, var8, var16, var18, var20, var26, 0.5, var9);
            var22 += var3.nextInt(4);
         }

         for (int var23 = 0; var23 < var22; var23++) {
            float var27 = var3.nextFloat() * (float) (Math.PI * 2);
            float var31 = (var3.nextFloat() - 0.5F) / 4.0F;
            float var28 = this.method22593(var3);
            int var29 = var13 - var3.nextInt(var13 / 4);
            boolean var30 = false;
            this.method22600(var1, var2, var3.nextLong(), var4, var7, var8, var16, var18, var20, var28, var27, var31, 0, var29, this.method22594(), var9);
         }
      }

      return true;
   }

   public int method22592() {
      return 15;
   }

   public float method22593(Random var1) {
      float var4 = var1.nextFloat() * 2.0F + var1.nextFloat();
      if (var1.nextInt(10) == 0) {
         var4 *= var1.nextFloat() * var1.nextFloat() * 3.0F + 1.0F;
      }

      return var4;
   }

   public double method22594() {
      return 1.0;
   }

   public int method22595(Random var1) {
      return var1.nextInt(var1.nextInt(120) + 8);
   }

   public void method22599(
      IChunk var1,
      Function<BlockPos, Biome> var2,
      long var3,
      int var5,
      int var6,
      int var7,
      double var8,
      double var10,
      double var12,
      float var14,
      double var15,
      BitSet var17
   ) {
      double var20 = 1.5 + (double)(MathHelper.sin((float) (Math.PI / 2)) * var14);
      double var22 = var20 * var15;
      this.method22608(var1, var2, var3, var5, var6, var7, var8 + 1.0, var10, var12, var20, var22, var17);
   }

   public void method22600(
      IChunk var1,
      Function<BlockPos, Biome> var2,
      long var3,
      int var5,
      int var6,
      int var7,
      double var8,
      double var10,
      double var12,
      float var14,
      float var15,
      float var16,
      int var17,
      int var18,
      double var19,
      BitSet var21
   ) {
      Random var24 = new Random(var3);
      int var25 = var24.nextInt(var18 / 2) + var18 / 4;
      boolean var26 = var24.nextInt(6) == 0;
      float var27 = 0.0F;
      float var28 = 0.0F;

      for (int var29 = var17; var29 < var18; var29++) {
         double var30 = 1.5 + (double)(MathHelper.sin((float) Math.PI * (float)var29 / (float)var18) * var14);
         double var32 = var30 * var19;
         float var34 = MathHelper.cos(var16);
         var8 += (double)(MathHelper.cos(var15) * var34);
         var10 += (double) MathHelper.sin(var16);
         var12 += (double)(MathHelper.sin(var15) * var34);
         var16 *= !var26 ? 0.7F : 0.92F;
         var16 += var28 * 0.1F;
         var15 += var27 * 0.1F;
         var28 *= 0.9F;
         var27 *= 0.75F;
         var28 += (var24.nextFloat() - var24.nextFloat()) * var24.nextFloat() * 2.0F;
         var27 += (var24.nextFloat() - var24.nextFloat()) * var24.nextFloat() * 4.0F;
         if (var29 == var25 && var14 > 1.0F) {
            this.method22600(
               var1,
               var2,
               var24.nextLong(),
               var5,
               var6,
               var7,
               var8,
               var10,
               var12,
               var24.nextFloat() * 0.5F + 0.5F,
               var15 - (float) (Math.PI / 2),
               var16 / 3.0F,
               var29,
               var18,
               1.0,
               var21
            );
            this.method22600(
               var1,
               var2,
               var24.nextLong(),
               var5,
               var6,
               var7,
               var8,
               var10,
               var12,
               var24.nextFloat() * 0.5F + 0.5F,
               var15 + (float) (Math.PI / 2),
               var16 / 3.0F,
               var29,
               var18,
               1.0,
               var21
            );
            return;
         }

         if (var24.nextInt(4) != 0) {
            if (!this.method22613(var6, var7, var8, var12, var29, var18, var14)) {
               return;
            }

            this.method22608(var1, var2, var3, var5, var6, var7, var8, var10, var12, var30, var32, var21);
         }
      }
   }

   @Override
   public boolean method22601(double var1, double var3, double var5, int var7) {
      return var3 <= -0.7 || var1 * var1 + var3 * var3 + var5 * var5 >= 1.0;
   }
}
