package mapped;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.server.ServerWorld;

public class Class3694 extends Class3676<LivingEntity> {
   private static String[] field19725;
   private final float field19726;
   private final int field19727;

   public Class3694(float var1, int var2) {
      super(ImmutableMap.of(MemoryModuleType.field39824, Class2217.field14485, MemoryModuleType.field39825, Class2217.field14484));
      this.field19726 = var1;
      this.field19727 = var2;
   }

   @Override
   public void method12502(ServerWorld var1, LivingEntity var2, long var3) {
      Brain<?> var7 = var2.getBrain();
      Class7864 var8 = var7.<Class7864>getMemory(MemoryModuleType.field39825).get();
      var7.method21406(MemoryModuleType.field39824, new Class8999(var8, this.field19726, this.field19727));
   }
}
