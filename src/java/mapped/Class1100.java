package mapped;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class Class1100 extends Class1009 {
   public static final DataParameter<Byte> field6051 = EntityDataManager.<Byte>createKey(Class1100.class, DataSerializers.field33390);
   private Class1006 field6052;
   private BlockPos field6053;
   private boolean field6054;
   private int field6055;

   public Class1100(EntityType<? extends Class1100> var1, World var2) {
      super(var1, var2);
      this.field5596 = new Class6839(this, this);
      this.field5594 = 3;
   }

   @Override
   public void move(Class2107 var1, Vector3d var2) {
      super.move(var1, var2);
      this.method3240();
   }

   @Override
   public void tick() {
      this.noClip = true;
      super.tick();
      this.noClip = false;
      this.method3248(true);
      if (this.field6054 && --this.field6055 <= 0) {
         this.field6055 = 20;
         this.method2741(DamageSource.field39000, 1.0F);
      }
   }

   @Override
   public void method4219() {
      super.method4219();
      this.field5600.method20002(0, new Class2603(this));
      this.field5600.method20002(4, new Class2766(this));
      this.field5600.method20002(8, new Class2678(this));
      this.field5600.method20002(9, new Class2612(this, PlayerEntity.class, 3.0F, 1.0F));
      this.field5600.method20002(10, new Class2612(this, Class1006.class, 8.0F));
      this.field5601.method20002(1, new Class2704(this, Class1026.class).method10918());
      this.field5601.method20002(2, new Class2722(this, this));
      this.field5601.method20002(3, new Class2709<PlayerEntity>(this, PlayerEntity.class, true));
   }

   public static Class7037 method5269() {
      return Class1009.method4343().method21849(Attributes.field42105, 14.0).method21849(Attributes.field42110, 4.0);
   }

   @Override
   public void registerData() {
      super.registerData();
      this.dataManager.register(field6051, (byte)0);
   }

   @Override
   public void method2723(CompoundNBT var1) {
      super.method2723(var1);
      if (var1.contains("BoundX")) {
         this.field6053 = new BlockPos(var1.getInt("BoundX"), var1.getInt("BoundY"), var1.getInt("BoundZ"));
      }

      if (var1.contains("LifeTicks")) {
         this.method5278(var1.getInt("LifeTicks"));
      }
   }

   @Override
   public void method2724(CompoundNBT var1) {
      super.method2724(var1);
      if (this.field6053 != null) {
         var1.method102("BoundX", this.field6053.getX());
         var1.method102("BoundY", this.field6053.getY());
         var1.method102("BoundZ", this.field6053.getZ());
      }

      if (this.field6054) {
         var1.method102("LifeTicks", this.field6055);
      }
   }

   public Class1006 method5270() {
      return this.field6052;
   }

   @Nullable
   public BlockPos method5271() {
      return this.field6053;
   }

   public void method5272(BlockPos var1) {
      this.field6053 = var1;
   }

   private boolean method5273(int var1) {
      int var4 = this.dataManager.<Byte>method35445(field6051);
      return (var4 & var1) != 0;
   }

   private void method5274(int var1, boolean var2) {
      int var5 = this.dataManager.<Byte>method35445(field6051);
      if (!var2) {
         var5 &= ~var1;
      } else {
         var5 |= var1;
      }

      this.dataManager.method35446(field6051, (byte)(var5 & 0xFF));
   }

   public boolean method5275() {
      return this.method5273(1);
   }

   public void method5276(boolean var1) {
      this.method5274(1, var1);
   }

   public void method5277(Class1006 var1) {
      this.field6052 = var1;
   }

   public void method5278(int var1) {
      this.field6054 = true;
      this.field6055 = var1;
   }

   @Override
   public SoundEvent getAmbientSound() {
      return SoundEvents.field27185;
   }

   @Override
   public SoundEvent getDeathSound() {
      return SoundEvents.field27187;
   }

   @Override
   public SoundEvent getHurtSound(DamageSource var1) {
      return SoundEvents.field27188;
   }

   @Override
   public float getBrightness() {
      return 1.0F;
   }

   @Nullable
   @Override
   public Class5093 method4276(Class1659 var1, Class9755 var2, Class2202 var3, Class5093 var4, CompoundNBT var5) {
      this.method4270(var2);
      this.method4273(var2);
      return super.method4276(var1, var2, var3, var4, var5);
   }

   @Override
   public void method4270(Class9755 var1) {
      this.method2944(Class2106.field13731, new ItemStack(Items.field37820));
      this.method4279(Class2106.field13731, 0.0F);
   }

   // $VF: synthetic method
   public static Random method5279(Class1100 var0) {
      return var0.rand;
   }

   // $VF: synthetic method
   public static Class6829 method5280(Class1100 var0) {
      return var0.field5596;
   }

   // $VF: synthetic method
   public static Class6829 method5281(Class1100 var0) {
      return var0.field5596;
   }

   // $VF: synthetic method
   public static Class1006 method5282(Class1100 var0) {
      return var0.field6052;
   }

   // $VF: synthetic method
   public static Random method5283(Class1100 var0) {
      return var0.rand;
   }

   // $VF: synthetic method
   public static Random method5284(Class1100 var0) {
      return var0.rand;
   }

   // $VF: synthetic method
   public static Random method5285(Class1100 var0) {
      return var0.rand;
   }

   // $VF: synthetic method
   public static Random method5286(Class1100 var0) {
      return var0.rand;
   }

   // $VF: synthetic method
   public static Class6829 method5287(Class1100 var0) {
      return var0.field5596;
   }
}
