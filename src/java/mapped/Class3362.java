package mapped;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class Class3362 extends Class3241 {
   private static String[] field18912;
   public static final Class8553 field18913 = Class8820.field39721;
   public static final Class8551 field18914 = Class8820.field39687;
   private static final VoxelShape field18915 = Block.method11539(0.0, 10.0, 0.0, 16.0, 16.0, 16.0);
   private static final VoxelShape field18916 = Block.method11539(4.0, 4.0, 4.0, 12.0, 10.0, 12.0);
   private static final VoxelShape field18917 = VoxelShapes.method27431(field18916, field18915);
   private static final VoxelShape field18918 = VoxelShapes.combineAndSimplify(field18917, Class937.field5296, IBooleanFunction.ONLY_FIRST);
   private static final VoxelShape field18919 = VoxelShapes.method27431(field18918, Block.method11539(6.0, 0.0, 6.0, 10.0, 4.0, 10.0));
   private static final VoxelShape field18920 = VoxelShapes.method27431(field18918, Block.method11539(12.0, 4.0, 6.0, 16.0, 8.0, 10.0));
   private static final VoxelShape field18921 = VoxelShapes.method27431(field18918, Block.method11539(6.0, 4.0, 0.0, 10.0, 8.0, 4.0));
   private static final VoxelShape field18922 = VoxelShapes.method27431(field18918, Block.method11539(6.0, 4.0, 12.0, 10.0, 8.0, 16.0));
   private static final VoxelShape field18923 = VoxelShapes.method27431(field18918, Block.method11539(0.0, 4.0, 6.0, 4.0, 8.0, 10.0));
   private static final VoxelShape field18924 = Class937.field5296;
   private static final VoxelShape field18925 = VoxelShapes.method27431(Class937.field5296, Block.method11539(12.0, 8.0, 6.0, 16.0, 10.0, 10.0));
   private static final VoxelShape field18926 = VoxelShapes.method27431(Class937.field5296, Block.method11539(6.0, 8.0, 0.0, 10.0, 10.0, 4.0));
   private static final VoxelShape field18927 = VoxelShapes.method27431(Class937.field5296, Block.method11539(6.0, 8.0, 12.0, 10.0, 10.0, 16.0));
   private static final VoxelShape field18928 = VoxelShapes.method27431(Class937.field5296, Block.method11539(0.0, 8.0, 6.0, 4.0, 10.0, 10.0));

   public Class3362(AbstractBlock var1) {
      super(var1);
      this.method11578(this.field18612.method35393().method23465(field18913, net.minecraft.util.Direction.DOWN).method23465(field18914, Boolean.valueOf(true)));
   }

   @Override
   public VoxelShape method11483(BlockState var1, IBlockReader var2, BlockPos var3, ISelectionContext var4) {
      switch (Class9391.field43583[var1.<net.minecraft.util.Direction>method23463(field18913).ordinal()]) {
         case 1:
            return field18919;
         case 2:
            return field18921;
         case 3:
            return field18922;
         case 4:
            return field18923;
         case 5:
            return field18920;
         default:
            return field18918;
      }
   }

   @Override
   public VoxelShape method11938(BlockState var1, IBlockReader var2, BlockPos var3) {
      switch (Class9391.field43583[var1.<net.minecraft.util.Direction>method23463(field18913).ordinal()]) {
         case 1:
            return field18924;
         case 2:
            return field18926;
         case 3:
            return field18927;
         case 4:
            return field18928;
         case 5:
            return field18925;
         default:
            return Class937.field5296;
      }
   }

   @Override
   public BlockState method11495(Class5909 var1) {
      net.minecraft.util.Direction var4 = var1.method18354().method536();
      return this.method11579()
         .method23465(field18913, var4.getAxis() != Direction.Y ? var4 : net.minecraft.util.Direction.DOWN)
         .method23465(field18914, Boolean.valueOf(true));
   }

   @Override
   public TileEntity method11646(IBlockReader var1) {
      return new Class936();
   }

   @Override
   public void method11563(World var1, BlockPos var2, BlockState var3, LivingEntity var4, ItemStack var5) {
      if (var5.method32152()) {
         TileEntity var8 = var1.getTileEntity(var2);
         if (var8 instanceof Class936) {
            ((Class936)var8).method3695(var5.method32149());
         }
      }
   }

   @Override
   public void method11589(BlockState var1, World var2, BlockPos var3, BlockState var4, boolean var5) {
      if (!var4.isIn(var1.getBlock())) {
         this.method11939(var2, var3, var1);
      }
   }

   @Override
   public ActionResultType method11505(BlockState var1, World var2, BlockPos var3, PlayerEntity var4, Hand var5, BlockRayTraceResult var6) {
      if (!var2.isRemote) {
         TileEntity var9 = var2.getTileEntity(var3);
         if (var9 instanceof Class936) {
            var4.method2766((Class936)var9);
            var4.method2911(Stats.field40150);
         }

         return ActionResultType.field14819;
      } else {
         return ActionResultType.SUCCESS;
      }
   }

   @Override
   public void method11506(BlockState var1, World var2, BlockPos var3, Block var4, BlockPos var5, boolean var6) {
      this.method11939(var2, var3, var1);
   }

   private void method11939(World var1, BlockPos var2, BlockState var3) {
      boolean var6 = !var1.method6780(var2);
      if (var6 != var3.<Boolean>method23463(field18914)) {
         var1.setBlockState(var2, var3.method23465(field18914, Boolean.valueOf(var6)), 4);
      }
   }

   @Override
   public void method11513(BlockState var1, World var2, BlockPos var3, BlockState var4, boolean var5) {
      if (!var1.isIn(var4.getBlock())) {
         TileEntity var8 = var2.getTileEntity(var3);
         if (var8 instanceof Class936) {
            Class7236.method22721(var2, var3, (Class936)var8);
            var2.updateComparatorOutputLevel(var3, this);
         }

         super.method11513(var1, var2, var3, var4, var5);
      }
   }

   @Override
   public BlockRenderType method11526(BlockState var1) {
      return BlockRenderType.MODEL;
   }

   @Override
   public boolean method11648(BlockState var1) {
      return true;
   }

   @Override
   public int method11649(BlockState var1, World var2, BlockPos var3) {
      return Container.calcRedstone(var2.getTileEntity(var3));
   }

   @Override
   public BlockState method11500(BlockState var1, Rotation var2) {
      return var1.method23465(field18913, var2.method252(var1.<net.minecraft.util.Direction>method23463(field18913)));
   }

   @Override
   public BlockState method11501(BlockState var1, Class2089 var2) {
      return var1.method23395(var2.method8749(var1.<net.minecraft.util.Direction>method23463(field18913)));
   }

   @Override
   public void method11489(Class7558<Block, BlockState> var1) {
      var1.method24737(field18913, field18914);
   }

   @Override
   public void method11523(BlockState var1, World var2, BlockPos var3, Entity var4) {
      TileEntity var7 = var2.getTileEntity(var3);
      if (var7 instanceof Class936) {
         ((Class936)var7).method3726(var4);
      }
   }

   @Override
   public boolean method11494(BlockState var1, IBlockReader var2, BlockPos var3, Class1947 var4) {
      return false;
   }
}
