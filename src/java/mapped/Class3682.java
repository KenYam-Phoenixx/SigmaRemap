package mapped;

import com.google.common.collect.ImmutableMap;

public class Class3682<E extends Class1045> extends Class3676<E> {
   private static String[] field19694;
   private final Class8369 field19695;
   private final float field19696;

   public Class3682(Class8369 var1, float var2) {
      super(ImmutableMap.of(Class8830.field39846, Class2217.field14484, Class8830.field39824, Class2217.field14485));
      this.field19695 = var1;
      this.field19696 = var2;
   }

   public boolean method12508(ServerWorld var1, E var2) {
      if (!var2.method3005()) {
         return false;
      } else {
         Class1045 var5 = this.method12518((E)var2);
         return var2.method3213(var5, (double)(this.field19695.method29321() + 1)) && !var2.method3213(var5, (double)this.field19695.method29320());
      }
   }

   public void method12502(ServerWorld var1, E var2, long var3) {
      Class6983.method21576(var2, this.method12518((E)var2), this.field19696, this.field19695.method29320() - 1);
   }

   private Class1045 method12518(E var1) {
      return var1.method2992().<Class1045>method21410(Class8830.field39846).get();
   }
}
