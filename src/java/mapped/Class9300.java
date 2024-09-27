package mapped;

import com.mojang.serialization.Codec;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;
import java.util.function.Supplier;

public class Class9300<FC extends Class4698, F extends Structure<FC>> {
   public static final Codec<Class9300<?, ?>> field43171 = Registry.field16114.dispatch(var0 -> var0.field43174, Structure::method11367);
   public static final Codec<Supplier<Class9300<?, ?>>> field43172 = RegistryKeyCodec.create(Registry.field16103, field43171);
   public static final Codec<List<Supplier<Class9300<?, ?>>>> field43173 = RegistryKeyCodec.<Class9300<?, ?>>method33672(Registry.field16103, field43171);
   public final F field43174;
   public final FC field43175;

   public Class9300(F var1, FC var2) {
      this.field43174 = (F)var1;
      this.field43175 = (FC)var2;
   }

   public StructureStart<?> method35098(
           DynamicRegistries var1, ChunkGenerator var2, BiomeProvider var3, TemplateManager var4, long var5, ChunkPos var7, Biome var8, int var9, Class8483 var10
   ) {
      return this.field43174.method11372(var1, var2, var3, var4, var5, var7, var8, var9, new Class2420(), var10, this.field43175);
   }
}
