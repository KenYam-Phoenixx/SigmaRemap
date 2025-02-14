package mapped;

import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.EndCityPieces;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class Class5452 extends StructureStart<Class4712> {
   private static String[] field24211;

   public Class5452(Structure<Class4712> var1, int var2, int var3, MutableBoundingBox var4, int var5, long var6) {
      super(var1, var2, var3, var4, var5, var6);
   }

   public void method17109(DynamicRegistries var1, ChunkGenerator var2, TemplateManager var3, int var4, int var5, Biome var6, Class4712 var7) {
      Rotation var10 = Rotation.randomRotation(this.field24201);
      int var11 = Class2960.method11362(var4, var5, var2);
      if (var11 >= 60) {
         BlockPos var12 = new BlockPos(var4 * 16 + 8, var11, var5 * 16 + 8);
         EndCityPieces.method36640(var3, var12, var10, this.field24196, this.field24201);
         this.method17113();
      }
   }
}
