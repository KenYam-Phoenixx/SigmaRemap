package mapped;

import net.minecraft.world.raid.Raid;
import net.minecraft.world.server.ServerWorld;

public class Class3713 extends Class3712 {
   private static String[] field19778;

   public Class3713(float var1) {
      super(var1);
   }

   public boolean method12508(ServerWorld var1, CreatureEntity var2) {
      Raid var5 = var1.method6957(var2.getPosition());
      return var5 != null && var5.method25392() && super.method12508(var1, var2);
   }
}
