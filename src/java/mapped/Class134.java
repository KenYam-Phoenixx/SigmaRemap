package mapped;

import com.google.common.collect.ImmutableList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Class134 extends Class128 {
   private static final Logger field454 = LogManager.getLogger();
   private final List<Class6069> field455;

   public Class134(Class122[] var1, Collection<Class6069> var2) {
      super(var1);
      this.field455 = ImmutableList.copyOf(var2);
   }

   @Override
   public Class7128 method368() {
      return Class8585.field38620;
   }

   @Override
   public ItemStack method371(ItemStack var1, Class7812 var2) {
      Random var5 = var2.method26088();
      Class6069 var6;
      if (!this.field455.isEmpty()) {
         var6 = this.field455.get(var5.nextInt(this.field455.size()));
      } else {
         boolean var7 = var1.method32107() == Class8514.field37900;
         List var8 = Registry.field16073
            .method9192()
            .filter(Class6069::method18827)
            .filter(var2x -> var7 || var2x.method18821(var1))
            .collect(Collectors.toList());
         if (var8.isEmpty()) {
            field454.warn("Couldn't find a compatible enchantment for {}", var1);
            return var1;
         }

         var6 = (Class6069)var8.get(var5.nextInt(var8.size()));
      }

      return method391(var1, var6, var5);
   }

   private static ItemStack method391(ItemStack var0, Class6069 var1, Random var2) {
      int var5 = MathHelper.method37782(var2, var1.method18813(), var1.method18809());
      if (var0.method32107() != Class8514.field37900) {
         var0.method32162(var1, var5);
      } else {
         var0 = new ItemStack(Class8514.field38070);
         Class3290.method11831(var0, new Class6694(var1, var5));
      }

      return var0;
   }

   public static Class5876<?> method392() {
      return method372(var0 -> new Class134(var0, ImmutableList.of()));
   }

   // $VF: synthetic method
   public static List<Class6069> method395(Class134 var0) {
      return var0.field455;
   }
}
