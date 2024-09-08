package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.stream.IntStream;

public class Class3421 extends Block implements Class3207 {
   private static String[] field19130;
   public static final Class8553 field19131 = Class3198.field18484;
   public static final Class8552<Class99> field19132 = Class8820.field39735;
   public static final Class8552<Class106> field19133 = Class8820.field39771;
   public static final Class8551 field19134 = Class8820.field39710;
   public static final VoxelShape field19135 = Class3208.field18608;
   public static final VoxelShape field19136 = Class3208.field18607;
   public static final VoxelShape field19137 = Block.method11539(0.0, 0.0, 0.0, 8.0, 8.0, 8.0);
   public static final VoxelShape field19138 = Block.method11539(0.0, 0.0, 8.0, 8.0, 8.0, 16.0);
   public static final VoxelShape field19139 = Block.method11539(0.0, 8.0, 0.0, 8.0, 16.0, 8.0);
   public static final VoxelShape field19140 = Block.method11539(0.0, 8.0, 8.0, 8.0, 16.0, 16.0);
   public static final VoxelShape field19141 = Block.method11539(8.0, 0.0, 0.0, 16.0, 8.0, 8.0);
   public static final VoxelShape field19142 = Block.method11539(8.0, 0.0, 8.0, 16.0, 8.0, 16.0);
   public static final VoxelShape field19143 = Block.method11539(8.0, 8.0, 0.0, 16.0, 16.0, 8.0);
   public static final VoxelShape field19144 = Block.method11539(8.0, 8.0, 8.0, 16.0, 16.0, 16.0);
   public static final VoxelShape[] field19145 = method12069(field19135, field19137, field19141, field19138, field19142);
   public static final VoxelShape[] field19146 = method12069(field19136, field19139, field19143, field19140, field19144);
   private static final int[] field19147 = new int[]{12, 5, 3, 10, 14, 13, 7, 11, 13, 7, 11, 14, 8, 4, 1, 2, 4, 1, 2, 8};
   private final Block field19148;
   private final BlockState field19149;

   private static VoxelShape[] method12069(VoxelShape var0, VoxelShape var1, VoxelShape var2, VoxelShape var3, VoxelShape var4) {
      return IntStream.range(0, 16).<VoxelShape>mapToObj(var5 -> method12070(var5, var0, var1, var2, var3, var4)).<VoxelShape>toArray(VoxelShape[]::new);
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code
   private static VoxelShape method12070(int var0, VoxelShape var1, VoxelShape var2, VoxelShape var3, VoxelShape var4, VoxelShape var5) {
      int var6 = -1615302540;

      label28:
      while (true) {
         label25: {
            if ((var6 & 1073741824) == 0) {
               if ((var6 & 1) == 0) {
               }
            } else if ((var6 & 262144) == 0) {
               break label25;
            }

            do {
               if ((var6 & 8192) != 0 && (var6 & 2097152) == 0) {
                  continue label28;
               }
            } while ((var6 & 262144) != 0);
         }

         if ((var6 & 268435456) != 0) {
            return var1;
         }
      }
   }

   public Class3421(BlockState var1, AbstractBlock var2) {
      super(var2);
      this.method11578(
         this.field18612
            .method35393()
            .method23465(field19131, Direction.NORTH)
            .method23465(field19132, Class99.field271)
            .method23465(field19133, Class106.field329)
            .method23465(field19134, Boolean.valueOf(false))
      );
      this.field19148 = var1.getBlock();
      this.field19149 = var1;
   }

   @Override
   public boolean method11534(BlockState var1) {
      return true;
   }

   @Override
   public VoxelShape method11483(BlockState var1, IBlockReader var2, BlockPos var3, ISelectionContext var4) {
      return (var1.method23463(field19132) != Class99.field270 ? field19146 : field19145)[field19147[this.method12071(var1)]];
   }

   private int method12071(BlockState var1) {
      return var1.<Class106>method23463(field19133).ordinal() * 4 + var1.<Direction>method23463(field19131).method534();
   }

   @Override
   public void method11512(BlockState var1, World var2, BlockPos var3, Random var4) {
      this.field19148.method11512(var1, var2, var3, var4);
   }

   @Override
   public void method11602(BlockState var1, World var2, BlockPos var3, PlayerEntity var4) {
      this.field19149.method23436(var2, var3, var4);
   }

   @Override
   public void method11551(Class1660 var1, BlockPos var2, BlockState var3) {
      this.field19148.method11551(var1, var2, var3);
   }

   @Override
   public float method11559() {
      return this.field19148.method11559();
   }

   @Override
   public void method11589(BlockState var1, World var2, BlockPos var3, BlockState var4, boolean var5) {
      if (!var1.method23448(var1.getBlock())) {
         this.field19149.method23423(var2, var3, Blocks.AIR, var3, false);
         this.field19148.method11589(this.field19149, var2, var3, var4, false);
      }
   }

   @Override
   public void method11513(BlockState var1, World var2, BlockPos var3, BlockState var4, boolean var5) {
      if (!var1.method23448(var4.getBlock())) {
         this.field19149.method23429(var2, var3, var4, var5);
      }
   }

   @Override
   public void method11561(World var1, BlockPos var2, Entity var3) {
      this.field19148.method11561(var1, var2, var3);
   }

   @Override
   public boolean method11499(BlockState var1) {
      return this.field19148.method11499(var1);
   }

   @Override
   public void method11484(BlockState var1, ServerWorld var2, BlockPos var3, Random var4) {
      this.field19148.method11484(var1, var2, var3, var4);
   }

   @Override
   public void method11522(BlockState var1, ServerWorld var2, BlockPos var3, Random var4) {
      this.field19148.method11522(var1, var2, var3, var4);
   }

   @Override
   public ActionResultType method11505(BlockState var1, World var2, BlockPos var3, PlayerEntity var4, Hand var5, BlockRayTraceResult var6) {
      return this.field19149.method23435(var2, var4, var5, var6);
   }

   @Override
   public void method11560(World var1, BlockPos var2, Class7782 var3) {
      this.field19148.method11560(var1, var2, var3);
   }

   @Override
   public BlockState method11495(Class5909 var1) {
      Direction var4 = var1.method18354();
      BlockPos var5 = var1.method18345();
      FluidState var6 = var1.method18360().getFluidState(var5);
      BlockState var7 = this.method11579()
         .method23465(field19131, var1.method18350())
         .method23465(
            field19132,
            var4 != Direction.DOWN && (var4 == Direction.field673 || !(var1.method18355().y - (double)var5.getY() > 0.5))
               ? Class99.field271
               : Class99.field270
         )
         .method23465(field19134, Boolean.valueOf(var6.method23472() == Class9479.field44066));
      return var7.method23465(field19133, method12072(var7, var1.method18360(), var5));
   }

   @Override
   public BlockState method11491(BlockState var1, Direction var2, BlockState var3, Class1660 var4, BlockPos var5, BlockPos var6) {
      if (var1.<Boolean>method23463(field19134)) {
         var4.method6861().method20726(var5, Class9479.field44066, Class9479.field44066.method25057(var4));
      }

      return !var2.method544().method324()
         ? super.method11491(var1, var2, var3, var4, var5, var6)
         : var1.method23465(field19133, method12072(var1, var4, var5));
   }

   public static Class106 method12072(BlockState var0, IBlockReader var1, BlockPos var2) {
      Direction var5 = var0.<Direction>method23463(field19131);
      BlockState var6 = var1.getBlockState(var2.method8349(var5));
      if (method12074(var6) && var0.<Class99>method23463(field19132) == var6.<Class99>method23463(field19132)) {
         Direction var7 = var6.<Direction>method23463(field19131);
         if (var7.method544() != var0.<Direction>method23463(field19131).method544() && method12073(var0, var1, var2, var7.method536())) {
            if (var7 != var5.method538()) {
               return Class106.field333;
            }

            return Class106.field332;
         }
      }

      BlockState var9 = var1.getBlockState(var2.method8349(var5.method536()));
      if (method12074(var9) && var0.<Class99>method23463(field19132) == var9.<Class99>method23463(field19132)) {
         Direction var8 = var9.<Direction>method23463(field19131);
         if (var8.method544() != var0.<Direction>method23463(field19131).method544() && method12073(var0, var1, var2, var8)) {
            if (var8 != var5.method538()) {
               return Class106.field331;
            }

            return Class106.field330;
         }
      }

      return Class106.field329;
   }

   private static boolean method12073(BlockState var0, IBlockReader var1, BlockPos var2, Direction var3) {
      BlockState var6 = var1.getBlockState(var2.method8349(var3));
      return !method12074(var6)
         || var6.<Direction>method23463(field19131) != var0.<Direction>method23463(field19131)
         || var6.<Class99>method23463(field19132) != var0.<Class99>method23463(field19132);
   }

   public static boolean method12074(BlockState var0) {
      return var0.getBlock() instanceof Class3421;
   }

   @Override
   public BlockState method11500(BlockState var1, Class80 var2) {
      return var1.method23465(field19131, var2.method252(var1.<Direction>method23463(field19131)));
   }

   @Override
   public BlockState method11501(BlockState var1, Class2089 var2) {
      Direction var5 = var1.<Direction>method23463(field19131);
      Class106 var6 = var1.<Class106>method23463(field19133);
      switch (Class8332.field35835[var2.ordinal()]) {
         case 1:
            if (var5.method544() == Class113.field415) {
               switch (Class8332.field35834[var6.ordinal()]) {
                  case 1:
                     return var1.method23395(Class80.field187).method23465(field19133, Class106.field331);
                  case 2:
                     return var1.method23395(Class80.field187).method23465(field19133, Class106.field330);
                  case 3:
                     return var1.method23395(Class80.field187).method23465(field19133, Class106.field333);
                  case 4:
                     return var1.method23395(Class80.field187).method23465(field19133, Class106.field332);
                  default:
                     return var1.method23395(Class80.field187);
               }
            }
            break;
         case 2:
            if (var5.method544() == Class113.field413) {
               switch (Class8332.field35834[var6.ordinal()]) {
                  case 1:
                     return var1.method23395(Class80.field187).method23465(field19133, Class106.field330);
                  case 2:
                     return var1.method23395(Class80.field187).method23465(field19133, Class106.field331);
                  case 3:
                     return var1.method23395(Class80.field187).method23465(field19133, Class106.field333);
                  case 4:
                     return var1.method23395(Class80.field187).method23465(field19133, Class106.field332);
                  case 5:
                     return var1.method23395(Class80.field187);
               }
            }
      }

      return super.method11501(var1, var2);
   }

   @Override
   public void method11489(Class7558<Block, BlockState> var1) {
      var1.method24737(field19131, field19132, field19133, field19134);
   }

   @Override
   public FluidState method11498(BlockState var1) {
      return !var1.<Boolean>method23463(field19134) ? super.method11498(var1) : Class9479.field44066.method25078(false);
   }

   @Override
   public boolean method11494(BlockState var1, IBlockReader var2, BlockPos var3, Class1947 var4) {
      return false;
   }
}
