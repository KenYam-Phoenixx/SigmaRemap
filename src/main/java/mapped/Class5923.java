package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import java.util.Optional;

public class Class5923 extends Class5924 {
   private static String[] field25806;
   private final Entity field25807;

   public Class5923(Entity var1) {
      this.field25807 = var1;
   }

   @Override
   public Optional<Float> method18423(Explosion var1, IBlockReader var2, BlockPos var3, BlockState var4, FluidState var5) {
      return super.method18423(var1, var2, var3, var4, var5).<Float>map(var6 -> this.field25807.getExplosionResistance(var1, var2, var3, var4, var5, var6));
   }

   @Override
   public boolean method18424(Explosion var1, IBlockReader var2, BlockPos var3, BlockState var4, float var5) {
      return this.field25807.method3369(var1, var2, var3, var4, var5);
   }
}
