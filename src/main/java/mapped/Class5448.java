package mapped;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class Class5448 extends StructureStart<Class4728> {
   private static String[] field24206;

   public Class5448(Structure<Class4728> var1, int var2, int var3, MutableBoundingBox var4, int var5, long var6) {
      super(var1, var2, var3, var4, var5, var6);
   }

   public void method17109(DynamicRegistries var1, ChunkGenerator var2, TemplateManager var3, int var4, int var5, Biome var6, Class4728 var7) {
      int var10 = var4 * 16;
      int var11 = var5 * 16;
      BlockPos var12 = new BlockPos(var10 + 9, 90, var11 + 9);
      this.field24196.add(new Class4179(var12));
      this.method17113();
   }

   @Override
   public BlockPos method17120() {
      return new BlockPos((this.method17118() << 4) + 9, 0, (this.method17119() << 4) + 9);
   }
}
