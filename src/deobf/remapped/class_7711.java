package remapped;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.stream.Stream;

public class class_7711 extends class_7186 {
   private final Map<String, CompoundNBT> field_39117 = Maps.newHashMap();

   public class_7711(String var1) {
      super(var1);
   }

   @Override
   public void method_32924(CompoundNBT var1) {
      CompoundNBT var4 = var1.method_25937("contents");

      for (String var6 : var4.method_25952()) {
         this.field_39117.put(var6, var4.method_25937(var6));
      }
   }

   @Override
   public CompoundNBT method_32920(CompoundNBT var1) {
      CompoundNBT var4 = new CompoundNBT();
      this.field_39117.forEach((var1x, var2) -> var4.method_25946(var1x, var2.method_25944()));
      var1.method_25946("contents", var4);
      return var1;
   }

   public CompoundNBT method_34898(String var1) {
      CompoundNBT var4 = this.field_39117.get(var1);
      return var4 == null ? new CompoundNBT() : var4;
   }

   public void method_34896(String var1, CompoundNBT var2) {
      if (!var2.method_25940()) {
         this.field_39117.put(var1, var2);
      } else {
         this.field_39117.remove(var1);
      }

      this.method_32923();
   }

   public Stream<Identifier> method_34897(String var1) {
      return this.field_39117.keySet().stream().<Identifier>map(var1x -> new Identifier(var1, var1x));
   }
}
