package mapped;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.raid.Raid;
import net.minecraft.world.server.ServerWorld;

public class Class3752 extends Class3751 {
   private static String[] field19902;

   public Class3752(int var1, float var2) {
      super(var1, var2, 1);
   }

   @Override
   public boolean method12508(ServerWorld var1, LivingEntity var2) {
      Raid var5 = var1.method6957(var2.getPosition());
      return super.method12508(var1, var2) && var5 != null && var5.method25433() && !var5.method25392() && !var5.method25393();
   }
}
