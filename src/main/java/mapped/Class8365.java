package mapped;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class Class8365 {
   private static String[] field35919;

   public static Item method29304(ResourceLocation var0) {
      return Registry.ITEM.method9193(var0) ? Registry.ITEM.getOrDefault(var0) : null;
   }

   public static int method29305(Item var0) {
      return Registry.ITEM.getId(var0);
   }
}
