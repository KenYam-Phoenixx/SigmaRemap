package mapped;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.LivingEntity;

import java.util.List;
import java.util.Map;

public class Class3693<E extends LivingEntity> extends Class3692<E> {
   private static String[] field19724;

   public Class3693(List<Pair<Class3676<? super E>, Integer>> var1) {
      this(ImmutableMap.of(), var1);
   }

   public Class3693(Map<MemoryModuleType<?>, Class2217> var1, List<Pair<Class3676<? super E>, Integer>> var2) {
      super(var1, ImmutableSet.of(), Class1956.field12750, Class2111.field13770, var2);
   }
}
