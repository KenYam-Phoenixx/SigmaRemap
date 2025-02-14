package mapped;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Random;

public class Class4222 extends Class4213 {
   private static String[] field20550;

   public Class4222(Direction var1, Class9312 var2) {
      super(Class7792.field33470, 1, var1, var2, 1, 1, 1);
   }

   public Class4222(TemplateManager var1, CompoundNBT var2) {
      super(Class7792.field33470, var2);
   }

   @Override
   public boolean method12896(ISeedReader var1, StructureManager var2, ChunkGenerator var3, Random var4, MutableBoundingBox var5, ChunkPos var6, BlockPos var7) {
      this.method12927(var1, var5, 0, 3, 0, 2, 3, 7, field20529, field20529, false);
      this.method12927(var1, var5, 5, 3, 0, 7, 3, 7, field20529, field20529, false);
      this.method12927(var1, var5, 0, 2, 0, 1, 2, 7, field20529, field20529, false);
      this.method12927(var1, var5, 6, 2, 0, 7, 2, 7, field20529, field20529, false);
      this.method12927(var1, var5, 0, 1, 0, 0, 1, 7, field20529, field20529, false);
      this.method12927(var1, var5, 7, 1, 0, 7, 1, 7, field20529, field20529, false);
      this.method12927(var1, var5, 0, 1, 7, 7, 3, 7, field20529, field20529, false);
      this.method12927(var1, var5, 1, 1, 0, 2, 3, 0, field20529, field20529, false);
      this.method12927(var1, var5, 5, 1, 0, 6, 3, 0, field20529, field20529, false);
      if (Class9312.method35193(this.field20539)[Direction.NORTH.getIndex()]) {
         this.method13005(var1, var5, 3, 1, 7, 4, 2, 7);
      }

      if (Class9312.method35193(this.field20539)[Direction.WEST.getIndex()]) {
         this.method13005(var1, var5, 0, 1, 3, 1, 2, 4);
      }

      if (Class9312.method35193(this.field20539)[Direction.EAST.getIndex()]) {
         this.method13005(var1, var5, 6, 1, 3, 7, 2, 4);
      }

      return true;
   }
}
