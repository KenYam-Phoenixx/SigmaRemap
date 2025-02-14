package net.minecraft.world.gen.carver;

import com.mojang.serialization.Codec;
import mapped.Class4729;
import mapped.Class7195;
import mapped.RegistryKeyCodec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;

import java.util.BitSet;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConfiguredCarver<WC extends Class4729> {
   private static String[] field29673;
   public static final Codec<ConfiguredCarver<?>> field29674 = Registry.field16110.dispatch(var0 -> var0.field29677, Class7195::method22606);
   public static final Codec<Supplier<ConfiguredCarver<?>>> field29675 = RegistryKeyCodec.create(Registry.field16101, field29674);
   public static final Codec<List<Supplier<ConfiguredCarver<?>>>> field29676 = RegistryKeyCodec.<ConfiguredCarver<?>>getValueCodecs(Registry.field16101, field29674);
   private final Class7195<WC> field29677;
   private final WC field29678;

   public ConfiguredCarver(Class7195<WC> var1, WC var2) {
      this.field29677 = var1;
      this.field29678 = (WC)var2;
   }

   public WC method20775() {
      return this.field29678;
   }

   public boolean shouldCarve(Random var1, int var2, int var3) {
      return this.field29677.method22602(var1, var2, var3, this.field29678);
   }

   public boolean carveRegion(IChunk var1, Function<BlockPos, Biome> var2, Random var3, int var4, int var5, int var6, int var7, int var8, BitSet var9) {
      return this.field29677.method22603(var1, var2, var3, var4, var5, var6, var7, var8, var9, this.field29678);
   }
}
