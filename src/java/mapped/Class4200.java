package mapped;

import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.SlabType;
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

public class Class4200 extends Class4194 {
   private final boolean field20503;
   private final boolean field20504;
   private final boolean field20505;
   private final boolean field20506;

   public Class4200(int var1, Random var2, MutableBoundingBox var3, Direction var4) {
      super(Class7792.field33446, var1);
      this.method12939(var4);
      this.field20495 = this.method12985(var2);
      this.field20444 = var3;
      this.field20503 = var2.nextBoolean();
      this.field20504 = var2.nextBoolean();
      this.field20505 = var2.nextBoolean();
      this.field20506 = var2.nextInt(3) > 0;
   }

   public Class4200(TemplateManager var1, CompoundNBT var2) {
      super(Class7792.field33446, var2);
      this.field20503 = var2.getBoolean("leftLow");
      this.field20504 = var2.getBoolean("leftHigh");
      this.field20505 = var2.getBoolean("rightLow");
      this.field20506 = var2.getBoolean("rightHigh");
   }

   @Override
   public void method12897(CompoundNBT var1) {
      super.method12897(var1);
      var1.putBoolean("leftLow", this.field20503);
      var1.putBoolean("leftHigh", this.field20504);
      var1.putBoolean("rightLow", this.field20505);
      var1.putBoolean("rightHigh", this.field20506);
   }

   @Override
   public void method12894(Class4178 var1, List<Class4178> var2, Random var3) {
      int var6 = 3;
      int var7 = 5;
      Direction var8 = this.method12938();
      if (var8 == Direction.WEST || var8 == Direction.NORTH) {
         var6 = 8 - var6;
         var7 = 8 - var7;
      }

      this.method12986((Class4196)var1, var2, var3, 5, 1);
      if (this.field20503) {
         this.method12987((Class4196)var1, var2, var3, var6, 1);
      }

      if (this.field20504) {
         this.method12987((Class4196)var1, var2, var3, var7, 7);
      }

      if (this.field20505) {
         this.method12988((Class4196)var1, var2, var3, var6, 1);
      }

      if (this.field20506) {
         this.method12988((Class4196)var1, var2, var3, var7, 7);
      }
   }

   public static Class4200 method12993(List<Class4178> var0, Random var1, int var2, int var3, int var4, Direction var5, int var6) {
      MutableBoundingBox var9 = MutableBoundingBox.method38388(var2, var3, var4, -4, -3, 0, 10, 9, 11, var5);
      return method12989(var9) && Class4178.method12918(var0, var9) == null ? new Class4200(var6, var1, var9, var5) : null;
   }

   @Override
   public boolean method12896(ISeedReader var1, StructureManager var2, ChunkGenerator var3, Random var4, MutableBoundingBox var5, ChunkPos var6, BlockPos var7) {
      this.method12928(var1, var5, 0, 0, 0, 9, 8, 10, true, var4, Class9331.method35288());
      this.method12984(var1, var4, var5, this.field20495, 4, 3, 0);
      if (this.field20503) {
         this.method12927(var1, var5, 0, 3, 1, 0, 5, 3, field20443, field20443, false);
      }

      if (this.field20505) {
         this.method12927(var1, var5, 9, 3, 1, 9, 5, 3, field20443, field20443, false);
      }

      if (this.field20504) {
         this.method12927(var1, var5, 0, 5, 7, 0, 7, 9, field20443, field20443, false);
      }

      if (this.field20506) {
         this.method12927(var1, var5, 9, 5, 7, 9, 7, 9, field20443, field20443, false);
      }

      this.method12927(var1, var5, 5, 1, 10, 7, 3, 10, field20443, field20443, false);
      this.method12928(var1, var5, 1, 2, 1, 8, 2, 6, false, var4, Class9331.method35288());
      this.method12928(var1, var5, 4, 1, 5, 4, 4, 9, false, var4, Class9331.method35288());
      this.method12928(var1, var5, 8, 1, 5, 8, 4, 9, false, var4, Class9331.method35288());
      this.method12928(var1, var5, 1, 4, 7, 3, 4, 9, false, var4, Class9331.method35288());
      this.method12928(var1, var5, 1, 3, 5, 3, 3, 6, false, var4, Class9331.method35288());
      this.method12927(var1, var5, 1, 3, 4, 3, 3, 4, Blocks.SMOOTH_STONE_SLAB.getDefaultState(), Blocks.SMOOTH_STONE_SLAB.getDefaultState(), false);
      this.method12927(var1, var5, 1, 4, 6, 3, 4, 6, Blocks.SMOOTH_STONE_SLAB.getDefaultState(), Blocks.SMOOTH_STONE_SLAB.getDefaultState(), false);
      this.method12928(var1, var5, 5, 1, 7, 7, 1, 8, false, var4, Class9331.method35288());
      this.method12927(var1, var5, 5, 1, 9, 7, 1, 9, Blocks.SMOOTH_STONE_SLAB.getDefaultState(), Blocks.SMOOTH_STONE_SLAB.getDefaultState(), false);
      this.method12927(var1, var5, 5, 2, 7, 7, 2, 7, Blocks.SMOOTH_STONE_SLAB.getDefaultState(), Blocks.SMOOTH_STONE_SLAB.getDefaultState(), false);
      this.method12927(var1, var5, 4, 5, 7, 4, 5, 9, Blocks.SMOOTH_STONE_SLAB.getDefaultState(), Blocks.SMOOTH_STONE_SLAB.getDefaultState(), false);
      this.method12927(var1, var5, 8, 5, 7, 8, 5, 9, Blocks.SMOOTH_STONE_SLAB.getDefaultState(), Blocks.SMOOTH_STONE_SLAB.getDefaultState(), false);
      this.method12927(
         var1,
         var5,
         5,
         5,
         7,
         7,
         5,
         9,
         Blocks.SMOOTH_STONE_SLAB.getDefaultState().with(SlabBlock.field18605, SlabType.field220),
         Blocks.SMOOTH_STONE_SLAB.getDefaultState().with(SlabBlock.field18605, SlabType.field220),
         false
      );
      this.method12923(var1, Blocks.WALL_TORCH.getDefaultState().with(Class3382.field18985, Direction.SOUTH), 6, 5, 6, var5);
      return true;
   }
}
