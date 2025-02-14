package mapped;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.state.Property;

import java.util.Set;

public class Class5880 extends Class5876<Class5880> {
   private final Block field25674;
   private final Set<Property<?>> field25675 = Sets.newHashSet();

   public Class5880(Block var1) {
      this.field25674 = var1;
   }

   public Class5880 method18312(Property<?> var1) {
      if (this.field25674.getStateContainer().method35395().contains(var1)) {
         this.field25675.add(var1);
         return this;
      } else {
         throw new IllegalStateException("Property " + var1 + " is not present on block " + this.field25674);
      }
   }

   public Class5880 method18305() {
      return this;
   }

   @Override
   public ILootFunction method18309() {
      return new Class129(this.method18306(), this.field25674, this.field25675);
   }
}
