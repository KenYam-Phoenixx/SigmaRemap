package mapped;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;

public class Class149 extends Class128 {
   private final ResourceLocation field493;
   private final long field494;

   public Class149(ILootCondition[] var1, ResourceLocation var2, long var3) {
      super(var1);
      this.field493 = var2;
      this.field494 = var3;
   }

   @Override
   public LootFunctionType getFunctionType() {
      return LootFunctionManager.SET_LOOT_TABLE;
   }

   @Override
   public ItemStack method371(ItemStack var1, LootContext var2) {
      if (!var1.isEmpty()) {
         CompoundNBT var5 = new CompoundNBT();
         var5.putString("LootTable", this.field493.toString());
         if (this.field494 != 0L) {
            var5.putLong("LootTableSeed", this.field494);
         }

         var1.getOrCreateTag().put("BlockEntityTag", var5);
         return var1;
      } else {
         return var1;
      }
   }

   @Override
   public void method367(Class8478 var1) {
      if (!var1.method29959(this.field493)) {
         super.method367(var1);
         Class7318 var4 = var1.method29963(this.field493);
         if (var4 != null) {
            var4.method23184(var1.method29957("->{" + this.field493 + "}", this.field493));
         } else {
            var1.method29955("Unknown loot table called " + this.field493);
         }
      } else {
         var1.method29955("Table " + this.field493 + " is recursively called");
      }
   }

   // $VF: synthetic method
   public static ResourceLocation method452(Class149 var0) {
      return var0.field493;
   }

   // $VF: synthetic method
   public static long method453(Class149 var0) {
      return var0.field494;
   }
}
