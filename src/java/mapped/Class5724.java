package mapped;

import java.util.Random;

public class Class5724 extends Class5715<Class1000> {
   private static String[] field25128;
   private final Class216 field25129;
   private final Random field25130 = new Random();

   public Class5724(Class8853 var1, Class216 var2) {
      super(var1);
      this.field25129 = var2;
      this.field25098 = 0.15F;
      this.field25099 = 0.75F;
   }

   private int method17910(ItemStack var1) {
      byte var4 = 1;
      if (var1.method32179() <= 48) {
         if (var1.method32179() <= 32) {
            if (var1.method32179() <= 16) {
               if (var1.method32179() > 1) {
                  var4 = 2;
               }
            } else {
               var4 = 3;
            }
         } else {
            var4 = 4;
         }
      } else {
         var4 = 5;
      }

      return var4;
   }

   public void method17853(Class1000 var1, float var2, float var3, Class9332 var4, Class7733 var5, int var6) {
      var4.method35294();
      ItemStack var9 = var1.method4124();
      int var10 = !var9.method32105() ? Class3257.method11701(var9.method32107()) + var9.method32117() : 187;
      this.field25130.setSeed((long)var10);
      Class7202 var11 = this.field25129.method788(var9, var1.field5024, (Class880)null);
      boolean var12 = var11.method22621();
      int var13 = this.method17910(var9);
      float var14 = 0.25F;
      float var15 = MathHelper.method37763(((float)var1.method4130() + var3) / 10.0F + var1.field5520) * 0.1F + 0.1F;
      if (!this.method17912()) {
         var15 = 0.0F;
      }

      float var16 = var11.method22625().method34866(Class2327.field15931).field29591.method25270();
      var4.method35291(0.0, (double)(var15 + 0.25F * var16), 0.0);
      float var17 = var1.method4138(var3);
      var4.method35293(Class7680.field32900.method25285(var17));
      float var18 = var11.method22625().field42610.field29591.method25269();
      float var19 = var11.method22625().field42610.field29591.method25270();
      float var20 = var11.method22625().field42610.field29591.method25271();
      if (!var12) {
         float var21 = -0.0F * (float)(var13 - 1) * 0.5F * var18;
         float var22 = -0.0F * (float)(var13 - 1) * 0.5F * var19;
         float var23 = -0.09375F * (float)(var13 - 1) * 0.5F * var20;
         var4.method35291((double)var21, (double)var22, (double)var23);
      }

      for (int var25 = 0; var25 < var13; var25++) {
         var4.method35294();
         if (var25 > 0) {
            if (!var12) {
               float var26 = (this.field25130.nextFloat() * 2.0F - 1.0F) * 0.15F * 0.5F;
               float var28 = (this.field25130.nextFloat() * 2.0F - 1.0F) * 0.15F * 0.5F;
               var4.method35291((double)var26, (double)var28, 0.0);
            } else {
               float var27 = (this.field25130.nextFloat() * 2.0F - 1.0F) * 0.15F;
               float var29 = (this.field25130.nextFloat() * 2.0F - 1.0F) * 0.15F;
               float var24 = (this.field25130.nextFloat() * 2.0F - 1.0F) * 0.15F;
               if (!this.method17911()) {
                  var27 = 0.0F;
                  var29 = 0.0F;
               }

               var4.method35291((double)var27, (double)var29, (double)var24);
            }
         }

         this.field25129.method781(var9, Class2327.field15931, false, var4, var5, var6, Class213.field798, var11);
         var4.method35295();
         if (!var12) {
            var4.method35291((double)(0.0F * var18), (double)(0.0F * var19), (double)(0.09375F * var20));
         }
      }

      var4.method35295();
      super.method17853(var1, var2, var3, var4, var5, var6);
   }

   public ResourceLocation method17843(Class1000 var1) {
      return Class289.field1102;
   }

   public boolean method17911() {
      return true;
   }

   public boolean method17912() {
      return true;
   }
}
