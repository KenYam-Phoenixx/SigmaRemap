package mapped;

import com.google.common.collect.Sets;
import net.minecraft.enchantment.Enchantment;

import java.util.Set;

public class Class5878 extends Class5876<Class5878> {
   private static String[] field25669;
   private final Set<Enchantment> field25670 = Sets.newHashSet();

   public Class5878 method18305() {
      return this;
   }

   public Class5878 method18310(Enchantment var1) {
      this.field25670.add(var1);
      return this;
   }

   @Override
   public ILootFunction method18309() {
      return new Class134(this.method18306(), this.field25670);
   }
}
