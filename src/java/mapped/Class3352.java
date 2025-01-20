package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.Random;

public class Class3352 extends Class3350 {
   private static String[] field18878;

   public Class3352(Properties var1) {
      super(var1);
   }

   @Override
   public TileEntity method11646(IBlockReader var1) {
      return new Class985();
   }

   @Override
   public void method11918(World var1, BlockPos var2, PlayerEntity var3) {
      TileEntity var6 = var1.getTileEntity(var2);
      if (var6 instanceof Class985) {
         var3.method2766((Class949)var6);
         var3.method2911(Stats.field40166);
      }
   }

   @Override
   public void animateTick(BlockState var1, World var2, BlockPos var3, Random var4) {
      if (var1.<Boolean>get(field18876)) {
         double var7 = (double)var3.getX() + 0.5;
         double var9 = (double)var3.getY();
         double var11 = (double)var3.getZ() + 0.5;
         if (var4.nextDouble() < 0.1) {
            var2.playSound(var7, var9, var11, SoundEvents.field27107, SoundCategory.field14732, 1.0F, 1.0F, false);
         }

         var2.addParticle(ParticleTypes.field34092, var7, var9 + 1.1, var11, 0.0, 0.0, 0.0);
      }
   }
}
