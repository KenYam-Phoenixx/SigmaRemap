package mapped;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import java.util.List;
import java.util.function.Predicate;

public class Class896 extends Class890 implements Class889 {
   public static final Predicate<Class880> field5131 = Class880::method3124;

   public Class896(EntityType<? extends Class896> var1, World var2) {
      super(var1, var2);
   }

   public Class896(World var1, Class880 var2) {
      super(EntityType.field41092, var2, var1);
   }

   public Class896(World var1, double var2, double var4, double var6) {
      super(EntityType.field41092, var2, var4, var6, var1);
   }

   @Override
   public Item method3512() {
      return Items.field38115;
   }

   @Override
   public float method3515() {
      return 0.05F;
   }

   @Override
   public void method3466(BlockRayTraceResult var1) {
      super.method3466(var1);
      if (!this.world.isRemote) {
         ItemStack var4 = this.method3509();
         Class8812 var5 = Class9741.method38185(var4);
         List var6 = Class9741.method38176(var4);
         boolean var7 = var5 == Class8137.field34977 && var6.isEmpty();
         Direction var8 = var1.getFace();
         BlockPos var9 = var1.getPos();
         BlockPos var10 = var9.method8349(var8);
         if (var7) {
            this.method3521(var10, var8);
            this.method3521(var10.method8349(var8.method536()), var8);

            for (Direction var12 : Class76.field161) {
               this.method3521(var10.method8349(var12), var12);
            }
         }
      }
   }

   @Override
   public void method3464(RayTraceResult var1) {
      super.method3464(var1);
      if (!this.world.isRemote) {
         ItemStack var4 = this.method3509();
         Class8812 var5 = Class9741.method38185(var4);
         List var6 = Class9741.method38176(var4);
         boolean var7 = var5 == Class8137.field34977 && var6.isEmpty();
         if (!var7) {
            if (!var6.isEmpty()) {
               if (!this.method3520()) {
                  this.method3518(var6, var1.getType() != RayTraceResult.Type.ENTITY ? null : ((EntityRayTraceResult)var1).getEntity());
               } else {
                  this.method3519(var4, var5);
               }
            }
         } else {
            this.method3517();
         }

         int var8 = !var5.method31817() ? 2002 : 2007;
         this.world.playEvent(var8, this.getPosition(), Class9741.method38182(var4));
         this.method2904();
      }
   }

   private void method3517() {
      AxisAlignedBB var3 = this.getBoundingBox().method19663(4.0, 2.0, 4.0);
      List<Class880> var4 = this.world.method6772(Class880.class, var3, field5131);
      if (!var4.isEmpty()) {
         for (Class880 var6 : var4) {
            double var7 = this.getDistanceSq(var6);
            if (var7 < 16.0 && var6.method3124()) {
               var6.method2741(Class8654.method31124(var6, this.method3460()), 1.0F);
            }
         }
      }
   }

   private void method3518(List<Class2023> var1, Entity var2) {
      AxisAlignedBB var5 = this.getBoundingBox().method19663(4.0, 2.0, 4.0);
      List<Class880> var6 = this.world.method7182(Class880.class, var5);
      if (!var6.isEmpty()) {
         for (Class880 var8 : var6) {
            if (var8.method3169()) {
               double var9 = this.getDistanceSq(var8);
               if (var9 < 16.0) {
                  double var11 = 1.0 - Math.sqrt(var9) / 4.0;
                  if (var8 == var2) {
                     var11 = 1.0;
                  }

                  for (Class2023 var14 : var1) {
                     Effect var15 = var14.method8627();
                     if (!var15.method22292()) {
                        int var16 = (int)(var11 * (double)var14.method8628() + 0.5);
                        if (var16 > 20) {
                           var8.method3035(new Class2023(var15, var16, var14.method8629(), var14.method8630(), var14.method8631()));
                        }
                     } else {
                        var15.method22290(this, this.method3460(), var8, var14.method8629(), var11);
                     }
                  }
               }
            }
         }
      }
   }

   private void method3519(ItemStack var1, Class8812 var2) {
      Class999 var5 = new Class999(this.world, this.getPosX(), this.getPosY(), this.getPosZ());
      Entity var6 = this.method3460();
      if (var6 instanceof Class880) {
         var5.method4113((Class880)var6);
      }

      var5.method4097(3.0F);
      var5.method4110(-0.5F);
      var5.method4112(10);
      var5.method4111(-var5.method4098() / (float)var5.method4108());
      var5.method4099(var2);

      for (Class2023 var8 : Class9741.method38179(var1)) {
         var5.method4101(new Class2023(var8));
      }

      CompoundNBT var9 = var1.method32142();
      if (var9 != null && var9.method119("CustomPotionColor", 99)) {
         var5.method4103(var9.method122("CustomPotionColor"));
      }

      this.world.method6916(var5);
   }

   private boolean method3520() {
      return this.method3509().getItem() == Items.field38118;
   }

   private void method3521(BlockPos var1, Direction var2) {
      BlockState var5 = this.world.getBlockState(var1);
      if (!var5.method23446(BlockTags.field32798)) {
         if (Class3244.method11655(var5)) {
            this.world.method6869((PlayerEntity)null, 1009, var1, 0);
            Class3244.method11652(this.world, var1, var5);
            this.world.setBlockState(var1, var5.method23465(Class3244.field18698, Boolean.valueOf(false)));
         }
      } else {
         this.world.removeBlock(var1, false);
      }
   }
}
