package mapped;

import com.google.common.collect.ImmutableMap;

public class Class3720 extends Class3676<Class1006> {
   private static String[] field19804;
   private final float field19805;

   public Class3720(float var1) {
      super(
         ImmutableMap.of(
            Class8830.field39824,
            Class2217.field14486,
            Class8830.field39825,
            Class2217.field14486,
            Class8830.field39826,
            Class2217.field14484,
            Class8830.field39819,
            Class2217.field14486
         )
      );
      this.field19805 = var1;
   }

   public void method12502(ServerWorld var1, Class1006 var2, long var3) {
      Class880 var7 = var2.method2992().<Class880>method21410(Class8830.field39826).get();
      if (Class6983.method21583(var2, var7) && Class6983.method21580(var2, var7, 1)) {
         this.method12614(var2);
      } else {
         this.method12613(var2, var7);
      }
   }

   private void method12613(Class880 var1, Class880 var2) {
      Class6947 var5 = var1.method2992();
      var5.method21406(Class8830.field39825, new Class7865(var2, true));
      Class8999 var6 = new Class8999(new Class7865(var2, false), this.field19805, 0);
      var5.method21406(Class8830.field39824, var6);
   }

   private void method12614(Class880 var1) {
      var1.method2992().method21405(Class8830.field39824);
   }
}
