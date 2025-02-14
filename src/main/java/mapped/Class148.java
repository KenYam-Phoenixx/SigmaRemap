package mapped;

import com.google.common.collect.ImmutableList;
import net.minecraft.util.Util;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Class148 extends Class128 {
   private static String[] field491;
   private final List<Class6884> field492;

   public Class148(ILootCondition[] var1, List<Class6884> var2) {
      super(var1);
      this.field492 = ImmutableList.copyOf(var2);
   }

   @Override
   public LootFunctionType getFunctionType() {
      return LootFunctionManager.SET_ATTRIBUTES;
   }

   @Override
   public ItemStack method371(ItemStack var1, LootContext var2) {
      Random var5 = var2.method26088();

      for (Class6884 var7 : this.field492) {
         UUID var8 = Class6884.method20964(var7);
         if (var8 == null) {
            var8 = UUID.randomUUID();
         }

         EquipmentSlotType var9 = Util.<EquipmentSlotType>getRandomObject(Class6884.method20965(var7), var5);
         var1.method32172(
            Class6884.method20966(var7),
            new AttributeModifier(var8, Class6884.method20967(var7), (double)Class6884.method20968(var7).method20924(var5), Class6884.method20969(var7)),
            var9
         );
      }

      return var1;
   }

   // $VF: synthetic method
   public static List<Class6884> method451(Class148 var0) {
      return var0.field492;
   }
}
