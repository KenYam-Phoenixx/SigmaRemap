package mapped;

import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;
import java.util.Random;

public class Class4208 extends Class4194 {
   private final int field20515;

   public Class4208(int var1, MutableBoundingBox var2, Direction var3) {
      super(Class7792.field33445, var1);
      this.method12939(var3);
      this.field20444 = var2;
      this.field20515 = var3 != Direction.NORTH && var3 != Direction.SOUTH ? var2.method38398() : var2.method38400();
   }

   public Class4208(TemplateManager var1, CompoundNBT var2) {
      super(Class7792.field33445, var2);
      this.field20515 = var2.getInt("Steps");
   }

   @Override
   public void method12897(CompoundNBT var1) {
      super.method12897(var1);
      var1.putInt("Steps", this.field20515);
   }

   public static MutableBoundingBox method13001(List<Class4178> var0, Random var1, int var2, int var3, int var4, Direction var5) {
      byte var8 = 3;
      MutableBoundingBox var9 = MutableBoundingBox.method38388(var2, var3, var4, -1, -1, 0, 5, 5, 4, var5);
      Class4178 var10 = Class4178.method12918(var0, var9);
      if (var10 == null) {
         return null;
      } else {
         if (var10.method12915().minY == var9.minY) {
            for (int var11 = 3; var11 >= 1; var11--) {
               var9 = MutableBoundingBox.method38388(var2, var3, var4, -1, -1, 0, 5, 5, var11 - 1, var5);
               if (!var10.method12915().method38390(var9)) {
                  return MutableBoundingBox.method38388(var2, var3, var4, -1, -1, 0, 5, 5, var11, var5);
               }
            }
         }

         return null;
      }
   }

   @Override
   public boolean method12896(ISeedReader var1, StructureManager var2, ChunkGenerator var3, Random var4, MutableBoundingBox var5, ChunkPos var6, BlockPos var7) {
      for (int var10 = 0; var10 < this.field20515; var10++) {
         this.method12923(var1, Blocks.field36615.getDefaultState(), 0, 0, var10, var5);
         this.method12923(var1, Blocks.field36615.getDefaultState(), 1, 0, var10, var5);
         this.method12923(var1, Blocks.field36615.getDefaultState(), 2, 0, var10, var5);
         this.method12923(var1, Blocks.field36615.getDefaultState(), 3, 0, var10, var5);
         this.method12923(var1, Blocks.field36615.getDefaultState(), 4, 0, var10, var5);

         for (int var11 = 1; var11 <= 3; var11++) {
            this.method12923(var1, Blocks.field36615.getDefaultState(), 0, var11, var10, var5);
            this.method12923(var1, Blocks.field37012.getDefaultState(), 1, var11, var10, var5);
            this.method12923(var1, Blocks.field37012.getDefaultState(), 2, var11, var10, var5);
            this.method12923(var1, Blocks.field37012.getDefaultState(), 3, var11, var10, var5);
            this.method12923(var1, Blocks.field36615.getDefaultState(), 4, var11, var10, var5);
         }

         this.method12923(var1, Blocks.field36615.getDefaultState(), 0, 4, var10, var5);
         this.method12923(var1, Blocks.field36615.getDefaultState(), 1, 4, var10, var5);
         this.method12923(var1, Blocks.field36615.getDefaultState(), 2, 4, var10, var5);
         this.method12923(var1, Blocks.field36615.getDefaultState(), 3, 4, var10, var5);
         this.method12923(var1, Blocks.field36615.getDefaultState(), 4, 4, var10, var5);
      }

      return true;
   }
}
