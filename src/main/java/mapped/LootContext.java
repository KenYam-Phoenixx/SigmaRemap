package mapped;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.server.ServerWorld;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.annotation.Nullable;

public class LootContext {
   private static String[] field33511;
   private final Random field33512;
   private final float field33513;
   private final ServerWorld field33514;
   private final Function<ResourceLocation, Class7318> field33515;
   private final Set<Class7318> field33516 = Sets.newLinkedHashSet();
   private final Function<ResourceLocation, ILootCondition> field33517;
   private final Set<ILootCondition> field33518 = Sets.newLinkedHashSet();
   private final Map<Class9821<?>, Object> field33519;
   private final Map<ResourceLocation, Class9100> field33520;

   LootContext(
           Random var1,
           float var2,
           ServerWorld var3,
           Function<ResourceLocation, Class7318> var4,
           Function<ResourceLocation, ILootCondition> var5,
           Map<Class9821<?>, Object> var6,
           Map<ResourceLocation, Class9100> var7
   ) {
      this.field33512 = var1;
      this.field33513 = var2;
      this.field33514 = var3;
      this.field33515 = var4;
      this.field33517 = var5;
      this.field33519 = ImmutableMap.copyOf(var6);
      this.field33520 = ImmutableMap.copyOf(var7);
   }

   public boolean method26079(Class9821<?> var1) {
      return this.field33519.containsKey(var1);
   }

   public void method26080(ResourceLocation var1, Consumer<ItemStack> var2) {
      Class9100 var5 = this.field33520.get(var1);
      if (var5 != null) {
         var5.method33936(this, var2);
      }
   }

   @Nullable
   public <T> T method26081(Class9821<T> var1) {
      return (T)this.field33519.get(var1);
   }

   public boolean method26082(Class7318 var1) {
      return this.field33516.add(var1);
   }

   public void method26083(Class7318 var1) {
      this.field33516.remove(var1);
   }

   public boolean method26084(ILootCondition var1) {
      return this.field33518.add(var1);
   }

   public void method26085(ILootCondition var1) {
      this.field33518.remove(var1);
   }

   public Class7318 method26086(ResourceLocation var1) {
      return this.field33515.apply(var1);
   }

   public ILootCondition method26087(ResourceLocation var1) {
      return this.field33517.apply(var1);
   }

   public Random method26088() {
      return this.field33512;
   }

   public float method26089() {
      return this.field33513;
   }

   public ServerWorld method26090() {
      return this.field33514;
   }
}
