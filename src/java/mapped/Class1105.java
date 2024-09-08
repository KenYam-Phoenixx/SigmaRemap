package mapped;

import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Random;

public class Class1105 extends Class1009 {
   private static String[] field6065;
   private static final DataParameter<Boolean> field6066 = EntityDataManager.<Boolean>createKey(Class1105.class, DataSerializers.field33398);
   private static final DataParameter<Integer> field6067 = EntityDataManager.<Integer>createKey(Class1105.class, DataSerializers.field33391);
   private float field6068;
   private float field6069;
   private float field6070;
   private float field6071;
   private float field6072;
   private LivingEntity field6073;
   private int field6074;
   private boolean field6075;
   public Class2736 field6076;

   public Class1105(EntityType<? extends Class1105> var1, World var2) {
      super(var1, var2);
      this.field5594 = 10;
      this.method4224(Class2163.field14191, 0.0F);
      this.field5596 = new Class6828(this);
      this.field6068 = this.rand.nextFloat();
      this.field6069 = this.field6068;
   }

   @Override
   public void method4219() {
      Class2660 var3 = new Class2660(this, 1.0);
      this.field6076 = new Class2736(this, 1.0, 80);
      this.field5600.method20002(4, new Class2724(this));
      this.field5600.method20002(5, var3);
      this.field5600.method20002(7, this.field6076);
      this.field5600.method20002(8, new Class2612(this, PlayerEntity.class, 8.0F));
      this.field5600.method20002(8, new Class2612(this, Class1105.class, 12.0F, 0.01F));
      this.field5600.method20002(9, new Class2668(this));
      this.field6076.method10809(EnumSet.<Class2240>of(Class2240.field14657, Class2240.field14658));
      var3.method10809(EnumSet.<Class2240>of(Class2240.field14657, Class2240.field14658));
      this.field5601.method20002(1, new Class2709<LivingEntity>(this, LivingEntity.class, 10, true, false, new Class121(this)));
   }

   public static Class7037 method5300() {
      return Class1009.method4343()
         .method21849(Attributes.field42110, 6.0)
         .method21849(Attributes.MOVEMENT_SPEED, 0.5)
         .method21849(Attributes.field42106, 16.0)
         .method21849(Attributes.field42105, 30.0);
   }

   @Override
   public Class6990 method4221(World var1) {
      return new Class6997(this, var1);
   }

   @Override
   public void registerData() {
      super.registerData();
      this.dataManager.register(field6066, false);
      this.dataManager.register(field6067, 0);
   }

   @Override
   public boolean method2998() {
      return true;
   }

   @Override
   public Class7809 method3089() {
      return Class7809.field33509;
   }

   public boolean method5301() {
      return this.dataManager.<Boolean>method35445(field6066);
   }

   private void method5302(boolean var1) {
      this.dataManager.method35446(field6066, var1);
   }

   public int method5303() {
      return 80;
   }

   private void method5304(int var1) {
      this.dataManager.method35446(field6067, var1);
   }

   public boolean method5305() {
      return this.dataManager.<Integer>method35445(field6067) != 0;
   }

   @Nullable
   public LivingEntity method5306() {
      if (this.method5305()) {
         if (!this.world.isRemote) {
            return this.method4232();
         } else if (this.field6073 == null) {
            Entity var3 = this.world.getEntityByID(this.dataManager.<Integer>method35445(field6067));
            if (!(var3 instanceof LivingEntity)) {
               return null;
            } else {
               this.field6073 = (LivingEntity)var3;
               return this.field6073;
            }
         } else {
            return this.field6073;
         }
      } else {
         return null;
      }
   }

   @Override
   public void method3155(DataParameter<?> var1) {
      super.method3155(var1);
      if (field6067.equals(var1)) {
         this.field6074 = 0;
         this.field6073 = null;
      }
   }

   @Override
   public int method4236() {
      return 160;
   }

   @Override
   public SoundEvent method4241() {
      return !this.method3255() ? Sounds.field26644 : Sounds.field26643;
   }

   @Override
   public SoundEvent method2879(Class8654 var1) {
      return !this.method3255() ? Sounds.field26650 : Sounds.field26649;
   }

   @Override
   public SoundEvent method2880() {
      return !this.method3255() ? Sounds.field26647 : Sounds.field26646;
   }

   @Override
   public boolean method2940() {
      return false;
   }

   @Override
   public float method2957(Pose var1, EntitySize var2) {
      return var2.field39969 * 0.5F;
   }

   @Override
   public float method4339(BlockPos var1, Class1662 var2) {
      return !var2.getFluidState(var1).method23486(Class8953.field40469) ? super.method4339(var1, var2) : 10.0F + var2.method7009(var1) - 0.5F;
   }

   @Override
   public void method2871() {
      if (this.isAlive()) {
         if (this.world.isRemote) {
            this.field6069 = this.field6068;
            if (this.method3250()) {
               if (!this.method5301()) {
                  this.field6070 = this.field6070 + (0.125F - this.field6070) * 0.2F;
               } else if (!(this.field6070 < 0.5F)) {
                  this.field6070 = this.field6070 + (0.5F - this.field6070) * 0.1F;
               } else {
                  this.field6070 = 4.0F;
               }
            } else {
               this.field6070 = 2.0F;
               Vector3d var3 = this.getVec();
               if (var3.y > 0.0 && this.field6075 && !this.method3245()) {
                  this.world.method6745(this.getPosX(), this.getPosY(), this.getPosZ(), this.method5307(), this.method2864(), 1.0F, 1.0F, false);
               }

               this.field6075 = var3.y < 0.0 && this.world.method6765(this.getPosition().down(), this);
            }

            this.field6068 = this.field6068 + this.field6070;
            this.field6072 = this.field6071;
            if (this.method3255()) {
               if (!this.method5301()) {
                  this.field6071 = this.field6071 + (1.0F - this.field6071) * 0.06F;
               } else {
                  this.field6071 = this.field6071 + (0.0F - this.field6071) * 0.25F;
               }
            } else {
               this.field6071 = this.rand.nextFloat();
            }

            if (this.method5301() && this.method3250()) {
               Vector3d var17 = this.method3281(0.0F);

               for (int var4 = 0; var4 < 2; var4++) {
                  this.world
                     .method6746(
                        ParticleTypes.field34052,
                        this.method3438(0.5) - var17.x * 1.5,
                        this.method3441() - var17.y * 1.5,
                        this.method3445(0.5) - var17.z * 1.5,
                        0.0,
                        0.0,
                        0.0
                     );
               }
            }

            if (this.method5305()) {
               if (this.field6074 < this.method5303()) {
                  this.field6074++;
               }

               LivingEntity var18 = this.method5306();
               if (var18 != null) {
                  this.method4227().method28040(var18, 90.0F, 90.0F);
                  this.method4227().method28037();
                  double var5 = (double)this.method5310(0.0F);
                  double var7 = var18.getPosX() - this.getPosX();
                  double var9 = var18.method3440(0.5) - this.method3442();
                  double var11 = var18.getPosZ() - this.getPosZ();
                  double var13 = Math.sqrt(var7 * var7 + var9 * var9 + var11 * var11);
                  var7 /= var13;
                  var9 /= var13;
                  var11 /= var13;
                  double var15 = this.rand.nextDouble();

                  while (var15 < var13) {
                     var15 += 1.8 - var5 + this.rand.nextDouble() * (1.7 - var5);
                     this.world
                        .method6746(
                           ParticleTypes.field34052,
                           this.getPosX() + var7 * var15,
                           this.method3442() + var9 * var15,
                           this.getPosZ() + var11 * var15,
                           0.0,
                           0.0,
                           0.0
                        );
                  }
               }
            }
         }

         if (!this.method3255()) {
            if (this.onGround) {
               this.method3434(
                  this.getVec()
                     .method11339((double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F), 0.5, (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F))
               );
               this.rotationYaw = this.rand.nextFloat() * 360.0F;
               this.onGround = false;
               this.isAirBorne = true;
            }
         } else {
            this.method3352(300);
         }

         if (this.method5305()) {
            this.rotationYaw = this.field4967;
         }
      }

      super.method2871();
   }

   public SoundEvent method5307() {
      return Sounds.field26648;
   }

   public float method5308(float var1) {
      return MathHelper.lerp(var1, this.field6069, this.field6068);
   }

   public float method5309(float var1) {
      return MathHelper.lerp(var1, this.field6072, this.field6071);
   }

   public float method5310(float var1) {
      return ((float)this.field6074 + var1) / (float)this.method5303();
   }

   @Override
   public boolean method4266(Class1662 var1) {
      return var1.method7050(this);
   }

   public static boolean method5311(EntityType<? extends Class1105> var0, Class1660 var1, Class2202 var2, BlockPos var3, Random var4) {
      return (var4.nextInt(20) == 0 || !var1.method7008(var3))
         && var1.method6997() != Difficulty.field14351
         && (var2 == Class2202.field14393 || var1.getFluidState(var3).method23486(Class8953.field40469));
   }

   @Override
   public boolean method2741(Class8654 var1, float var2) {
      if (!this.method5301() && !var1.method31144() && var1.method31113() instanceof LivingEntity) {
         LivingEntity var5 = (LivingEntity)var1.method31113();
         if (!var1.method31131()) {
            var5.method2741(Class8654.method31125(this), 2.0F);
         }
      }

      if (this.field6076 != null) {
         this.field6076.method10944();
      }

      return super.method2741(var1, var2);
   }

   @Override
   public int method4259() {
      return 180;
   }

   @Override
   public void method2915(Vector3d var1) {
      if (this.method3138() && this.method3250()) {
         this.method3265(0.1F, var1);
         this.move(Class2107.field13742, this.getVec());
         this.method3434(this.getVec().method11344(0.9));
         if (!this.method5301() && this.method4232() == null) {
            this.method3434(this.getVec().method11339(0.0, -0.005, 0.0));
         }
      } else {
         super.method2915(var1);
      }
   }

   // $VF: synthetic method
   public static void method5312(Class1105 var0, int var1) {
      var0.method5304(var1);
   }

   // $VF: synthetic method
   public static void method5313(Class1105 var0, boolean var1) {
      var0.method5302(var1);
   }
}
