package remapped;

import com.google.common.collect.ForwardingList;
import java.util.List;

public class class_2024 extends ForwardingList<ItemStack> {
   private static String[] field_10259;
   private final class_2831<ItemStack> field_10260 = class_2831.<ItemStack>method_12872(class_7051.method_32422(), ItemStack.EMPTY);

   public List<ItemStack> delegate() {
      return this.field_10260;
   }

   public class_3416 method_9442() {
      class_3416 var3 = new class_3416();

      for (ItemStack var5 : this.delegate()) {
         var3.add(var5.method_27998(new CompoundNBT()));
      }

      return var3;
   }

   public void method_9444(class_3416 var1) {
      List var4 = this.delegate();

      for (int var5 = 0; var5 < var4.size(); var5++) {
         var4.set(var5, ItemStack.method_28015(var1.method_15764(var5)));
      }
   }

   public boolean isEmpty() {
      for (ItemStack var4 : this.delegate()) {
         if (!var4.method_28022()) {
            return false;
         }
      }

      return true;
   }
}
