package mapped;

import java.util.Set;

public class Class152 implements ILootCondition {
   private static String[] field499;
   private final ILootCondition field500;

   public Class152(ILootCondition var1) {
      this.field500 = var1;
   }

   @Override
   public Class7130 method354() {
      return Class8582.field38595;
   }

   public final boolean test(LootContext var1) {
      return !this.field500.test(var1);
   }

   @Override
   public Set<Class9821<?>> method355() {
      return this.field500.method355();
   }

   @Override
   public void method367(Class8478 var1) {
      ILootCondition.super.method367(var1);
      this.field500.method367(var1);
   }

   public static Class7519 method459(Class7519 var0) {
      Class152 var3 = new Class152(var0.method24517());
      return () -> var3;
   }

   // $VF: synthetic method
   public static ILootCondition method461(Class152 var0) {
      return var0.field500;
   }
}
