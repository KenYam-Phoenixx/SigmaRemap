package mapped;

import com.google.common.base.MoreObjects;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import javax.annotation.Nullable;

public class Class3459 extends Block {
   private static String[] field19280;
   public static final Class8553 field19281 = Class3198.field18484;
   public static final Class8551 field19282 = Class8820.field39704;
   public static final Class8551 field19283 = Class8820.field39682;
   public static final VoxelShape field19284 = Block.method11539(5.0, 0.0, 10.0, 11.0, 10.0, 16.0);
   public static final VoxelShape field19285 = Block.method11539(5.0, 0.0, 0.0, 11.0, 10.0, 6.0);
   public static final VoxelShape field19286 = Block.method11539(10.0, 0.0, 5.0, 16.0, 10.0, 11.0);
   public static final VoxelShape field19287 = Block.method11539(0.0, 0.0, 5.0, 6.0, 10.0, 11.0);

   public Class3459(AbstractBlock var1) {
      super(var1);
      this.method11578(
         this.field18612
            .method35393()
            .method23465(field19281, Direction.NORTH)
            .method23465(field19282, Boolean.valueOf(false))
            .method23465(field19283, Boolean.valueOf(false))
      );
   }

   @Override
   public VoxelShape method11483(BlockState var1, IBlockReader var2, BlockPos var3, ISelectionContext var4) {
      switch (Class7594.field32602[var1.<Direction>method23463(field19281).ordinal()]) {
         case 1:
         default:
            return field19287;
         case 2:
            return field19286;
         case 3:
            return field19285;
         case 4:
            return field19284;
      }
   }

   @Override
   public boolean method11492(BlockState var1, Class1662 var2, BlockPos var3) {
      Direction var6 = var1.<Direction>method23463(field19281);
      BlockPos var7 = var3.method8349(var6.method536());
      BlockState var8 = var2.getBlockState(var7);
      return var6.method544().method324() && var8.method23454(var2, var7, var6);
   }

   @Override
   public BlockState method11491(BlockState var1, Direction var2, BlockState var3, Class1660 var4, BlockPos var5, BlockPos var6) {
      return var2.method536() == var1.method23463(field19281) && !var1.method23443(var4, var5)
         ? Blocks.AIR.method11579()
         : super.method11491(var1, var2, var3, var4, var5, var6);
   }

   @Nullable
   @Override
   public BlockState method11495(Class5909 var1) {
      BlockState var4 = this.method11579().method23465(field19282, Boolean.valueOf(false)).method23465(field19283, Boolean.valueOf(false));
      World var5 = var1.method18360();
      BlockPos var6 = var1.method18345();
      Direction[] var7 = var1.method18349();

      for (Direction var11 : var7) {
         if (var11.method544().method324()) {
            Direction var12 = var11.method536();
            var4 = var4.method23465(field19281, var12);
            if (var4.method23443(var5, var6)) {
               return var4;
            }
         }
      }

      return null;
   }

   @Override
   public void method11563(World var1, BlockPos var2, BlockState var3, LivingEntity var4, ItemStack var5) {
      this.method12134(var1, var2, var3, false, false, -1, (BlockState)null);
   }

   public void method12134(World var1, BlockPos var2, BlockState var3, boolean var4, boolean var5, int var6, BlockState var7) {
      Direction var10 = var3.<Direction>method23463(field19281);
      boolean var11 = var3.<Boolean>method23463(field19283);
      boolean var12 = var3.<Boolean>method23463(field19282);
      boolean var13 = !var4;
      boolean var14 = false;
      int var15 = 0;
      BlockState[] var16 = new BlockState[42];

      for (int var17 = 1; var17 < 42; var17++) {
         BlockPos var18 = var2.method8350(var10, var17);
         BlockState var19 = var1.getBlockState(var18);
         if (var19.method23448(Blocks.TRIPWIRE_HOOK)) {
            if (var19.<Direction>method23463(field19281) == var10.method536()) {
               var15 = var17;
            }
            break;
         }

         if (!var19.method23448(Blocks.TRIPWIRE) && var17 != var6) {
            var16[var17] = null;
            var13 = false;
         } else {
            if (var17 == var6) {
               var19 = (BlockState)MoreObjects.firstNonNull(var7, var19);
            }

            boolean var20 = !var19.<Boolean>method23463(Class3425.field19165);
            boolean var21 = var19.<Boolean>method23463(Class3425.field19163);
            var14 |= var20 && var21;
            var16[var17] = var19;
            if (var17 == var6) {
               var1.method6860().method20726(var2, this, 10);
               var13 &= var20;
            }
         }
      }

      var13 &= var15 > 1;
      var14 &= var13;
      BlockState var24 = this.method11579().method23465(field19283, Boolean.valueOf(var13)).method23465(field19282, Boolean.valueOf(var14));
      if (var15 > 0) {
         BlockPos var25 = var2.method8350(var10, var15);
         Direction var27 = var10.method536();
         var1.setBlockState(var25, var24.method23465(field19281, var27), 3);
         this.method12136(var1, var25, var27);
         this.method12135(var1, var25, var13, var14, var11, var12);
      }

      this.method12135(var1, var2, var13, var14, var11, var12);
      if (!var4) {
         var1.setBlockState(var2, var24.method23465(field19281, var10), 3);
         if (var5) {
            this.method12136(var1, var2, var10);
         }
      }

      if (var11 != var13) {
         for (int var26 = 1; var26 < var15; var26++) {
            BlockPos var28 = var2.method8350(var10, var26);
            BlockState var29 = var16[var26];
            if (var29 != null) {
               var1.setBlockState(var28, var29.method23465(field19283, Boolean.valueOf(var13)), 3);
               if (var1.getBlockState(var28).isAir()) {
               }
            }
         }
      }
   }

   @Override
   public void method11522(BlockState var1, ServerWorld var2, BlockPos var3, Random var4) {
      this.method12134(var2, var3, var1, false, true, -1, (BlockState)null);
   }

   private void method12135(World var1, BlockPos var2, boolean var3, boolean var4, boolean var5, boolean var6) {
      if (var4 && !var6) {
         var1.method6742((PlayerEntity)null, var2, SoundEvents.field27158, Class2266.field14732, 0.4F, 0.6F);
      } else if (!var4 && var6) {
         var1.method6742((PlayerEntity)null, var2, SoundEvents.field27157, Class2266.field14732, 0.4F, 0.5F);
      } else if (var3 && !var5) {
         var1.method6742((PlayerEntity)null, var2, SoundEvents.field27156, Class2266.field14732, 0.4F, 0.7F);
      } else if (!var3 && var5) {
         var1.method6742((PlayerEntity)null, var2, SoundEvents.field27159, Class2266.field14732, 0.4F, 1.2F / (var1.rand.nextFloat() * 0.2F + 0.9F));
      }
   }

   private void method12136(World var1, BlockPos var2, Direction var3) {
      var1.notifyNeighborsOfStateChange(var2, this);
      var1.notifyNeighborsOfStateChange(var2.method8349(var3.method536()), this);
   }

   @Override
   public void method11513(BlockState var1, World var2, BlockPos var3, BlockState var4, boolean var5) {
      if (!var5 && !var1.method23448(var4.getBlock())) {
         boolean var8 = var1.<Boolean>method23463(field19283);
         boolean var9 = var1.<Boolean>method23463(field19282);
         if (var8 || var9) {
            this.method12134(var2, var3, var1, true, false, -1, (BlockState)null);
         }

         if (var9) {
            var2.notifyNeighborsOfStateChange(var3, this);
            var2.notifyNeighborsOfStateChange(var3.method8349(var1.<Direction>method23463(field19281).method536()), this);
         }

         super.method11513(var1, var2, var3, var4, var5);
      }
   }

   @Override
   public int method11514(BlockState var1, IBlockReader var2, BlockPos var3, Direction var4) {
      return !var1.<Boolean>method23463(field19282) ? 0 : 15;
   }

   @Override
   public int method11515(BlockState var1, IBlockReader var2, BlockPos var3, Direction var4) {
      if (var1.<Boolean>method23463(field19282)) {
         return var1.method23463(field19281) != var4 ? 0 : 15;
      } else {
         return 0;
      }
   }

   @Override
   public boolean method11516(BlockState var1) {
      return true;
   }

   @Override
   public BlockState method11500(BlockState var1, Class80 var2) {
      return var1.method23465(field19281, var2.method252(var1.<Direction>method23463(field19281)));
   }

   @Override
   public BlockState method11501(BlockState var1, Class2089 var2) {
      return var1.method23395(var2.method8749(var1.<Direction>method23463(field19281)));
   }

   @Override
   public void method11489(Class7558<Block, BlockState> var1) {
      var1.method24737(field19281, field19282, field19283);
   }
}
