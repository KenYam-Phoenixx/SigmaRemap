package mapped;

import it.unimi.dsi.fastutil.longs.Long2FloatLinkedOpenHashMap;
import net.minecraft.world.biome.Biome;

public class Class14 extends Long2FloatLinkedOpenHashMap {
    public final Biome field27;

   public Class14(Biome var1, int var2, float var3) {
      super(var2, var3);
      this.field27 = var1;
   }

   public void rehash(int var1) {
   }
}
