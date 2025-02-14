package mapped;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.Property;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import java.util.Map;
import java.util.Map.Entry;

public class BlockModelShapes {
   private static String[] field45467;
   private final Map<BlockState, IBakedModel> field45468 = Maps.newIdentityHashMap();
   private final ModelManager field45469;

   public BlockModelShapes(ModelManager var1) {
      this.field45469 = var1;
   }

   public TextureAtlasSprite getTexture(BlockState var1) {
      return this.method38153(var1).getParticleTexture();
   }

   public IBakedModel method38153(BlockState var1) {
      IBakedModel var4 = this.field45468.get(var1);
      if (var4 == null) {
         var4 = this.field45469.getMissingModel();
      }

      return var4;
   }

   public ModelManager getModelManager() {
      return this.field45469;
   }

   public void method38155() {
      this.field45468.clear();

      for (Block var4 : Registry.BLOCK) {
         var4.getStateContainer().getValidStates().forEach(var1 -> {
            IBakedModel var4x = this.field45468.put(var1, this.field45469.method1023(method38156(var1)));
         });
      }
   }

   public static Class1997 method38156(BlockState var0) {
      return method38157(Registry.BLOCK.getKey(var0.getBlock()), var0);
   }

   public static Class1997 method38157(ResourceLocation var0, BlockState var1) {
      return new Class1997(var0, method38158(var1.getValues()));
   }

   public static String method38158(Map<Property<?>, Comparable<?>> var0) {
      StringBuilder var3 = new StringBuilder();

      for (Entry var5 : var0.entrySet()) {
         if (var3.length() != 0) {
            var3.append(',');
         }

         Property var6 = (Property)var5.getKey();
         var3.append(var6.getName());
         var3.append('=');
         var3.append(method38159(var6, (Comparable<?>)var5.getValue()));
      }

      return var3.toString();
   }

   private static <T extends Comparable<T>> String method38159(Property<T> var0, Comparable<?> var1) {
      return var0.getName((T)var1);
   }
}
