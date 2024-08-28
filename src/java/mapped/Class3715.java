package mapped;

import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.function.Predicate;

public class Class3715 extends Class3676<Class880> {
   private static String[] field19785;
   private final Class8992<?> field19786;
   private final int field19787;
   private final Predicate<Class880> field19788;
   private final Predicate<Class880> field19789;

   public Class3715(Class8992<?> var1, int var2, Predicate<Class880> var3, Predicate<Class880> var4) {
      super(ImmutableMap.of(Class8830.field39825, Class2217.field14486, Class8830.field39828, Class2217.field14485, Class8830.field39819, Class2217.field14484));
      this.field19786 = var1;
      this.field19787 = var2 * var2;
      this.field19788 = var4;
      this.field19789 = var3;
   }

   public Class3715(Class8992<?> var1, int var2) {
      this(var1, var2, var0 -> true, var0 -> true);
   }

   @Override
   public boolean method12508(ServerWorld var1, Class880 var2) {
      return this.field19789.test(var2) && this.method12598(var2).stream().anyMatch(this::method12597);
   }

   @Override
   public void method12502(ServerWorld var1, Class880 var2, long var3) {
      super.method12502(var1, var2, var3);
      Class6947<?> var7 = var2.method2992();
      var7.<List<Class880>>method21410(Class8830.field39819)
         .ifPresent(
            var3x -> var3x.stream()
                  .filter(var2xx -> var2xx.getDistanceSq(var2) <= (double)this.field19787)
                  .filter(this::method12597)
                  .findFirst()
                  .ifPresent(var1xx -> {
                     var7.method21406(Class8830.field39828, var1xx);
                     var7.method21406(Class8830.field39825, new Class7865(var1xx, true));
                  })
         );
   }

   private boolean method12597(Class880 var1) {
      return this.field19786.equals(var1.method3204()) && this.field19788.test(var1);
   }

   private List<Class880> method12598(Class880 var1) {
      return var1.method2992().<List<Class880>>method21410(Class8830.field39819).get();
   }
}
