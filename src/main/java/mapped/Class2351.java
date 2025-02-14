package mapped;

import com.mojang.serialization.Lifecycle;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.Random;

public class Class2351<T> extends SimpleRegistry<T> {
   private static String[] field16150;
   private final ResourceLocation field16151;
   private T field16152;

   public Class2351(String var1, RegistryKey<? extends Registry<T>> var2, Lifecycle var3) {
      super(var2, var3);
      this.field16151 = new ResourceLocation(var1);
   }

   @Override
   public <V extends T> V method9249(int var1, RegistryKey<T> var2, V var3, Lifecycle var4) {
      if (this.field16151.equals(var2.getLocation())) {
         this.field16152 = (T)var3;
      }

      return super.<V>method9249(var1, var2, (V)var3, var4);
   }

   @Override
   public int getId(T var1) {
      int var4 = super.getId((T)var1);
      return var4 != -1 ? var4 : super.getId(this.field16152);
   }

   @Nonnull
   @Override
   public ResourceLocation getKey(T var1) {
      ResourceLocation var4 = super.getKey((T)var1);
      return var4 != null ? var4 : this.field16151;
   }

   @Nonnull
   @Override
   public T getOrDefault(ResourceLocation var1) {
      Object var4 = super.getOrDefault(var1);
      return (T)(var4 != null ? var4 : this.field16152);
   }

   @Override
   public Optional<T> method9187(ResourceLocation var1) {
      return Optional.<T>ofNullable(super.getOrDefault(var1));
   }

   @Nonnull
   @Override
   public T getByValue(int var1) {
      Object var4 = super.getByValue(var1);
      return (T)(var4 != null ? var4 : this.field16152);
   }

   @Nonnull
   @Override
   public T method9254(Random var1) {
      Object var4 = super.method9254(var1);
      return (T)(var4 != null ? var4 : this.field16152);
   }

   public ResourceLocation method9267() {
      return this.field16151;
   }
}
