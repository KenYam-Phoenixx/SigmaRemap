package mapped;

import com.google.common.collect.Maps;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.WorldSavedData;

import java.util.Map;
import java.util.stream.Stream;

public class Class7534 extends WorldSavedData {
   private final Map<String, CompoundNBT> field32339 = Maps.newHashMap();

   public Class7534(String var1) {
      super(var1);
   }

   @Override
   public void read(CompoundNBT compoundNBT) {
      CompoundNBT var4 = compoundNBT.getCompound("contents");

      for (String var6 : var4.keySet()) {
         this.field32339.put(var6, var4.getCompound(var6));
      }
   }

   @Override
   public CompoundNBT write(CompoundNBT compoundNBT) {
      CompoundNBT var4 = new CompoundNBT();
      this.field32339.forEach((var1x, var2) -> var4.put(var1x, var2.copy()));
      compoundNBT.put("contents", var4);
      return compoundNBT;
   }

   public CompoundNBT method24624(String var1) {
      CompoundNBT var4 = this.field32339.get(var1);
      return var4 == null ? new CompoundNBT() : var4;
   }

   public void method24625(String var1, CompoundNBT var2) {
      if (!var2.isEmpty()) {
         this.field32339.put(var1, var2);
      } else {
         this.field32339.remove(var1);
      }

      this.markDirty();
   }

   public Stream<ResourceLocation> method24626(String var1) {
      return this.field32339.keySet().stream().<ResourceLocation>map(var1x -> new ResourceLocation(var1, var1x));
   }
}
