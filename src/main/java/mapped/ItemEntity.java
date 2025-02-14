package mapped;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.stats.Stats;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.UUID;

public class ItemEntity extends Entity {
   private static final DataParameter<ItemStack> field5514 = EntityDataManager.<ItemStack>createKey(ItemEntity.class, DataSerializers.field33396);
   private int field5515;
   private int field5516;
   private int field5517 = 5;
   private UUID field5518;
   private UUID field5519;
   public final float field5520;

   public ItemEntity(EntityType<? extends ItemEntity> var1, World var2) {
      super(var1, var2);
      this.field5520 = (float)(Math.random() * Math.PI * 2.0);
   }

   public ItemEntity(World var1, double var2, double var4, double var6) {
      this(EntityType.ITEM, var1);
      this.setPosition(var2, var4, var6);
      this.rotationYaw = this.rand.nextFloat() * 360.0F;
      this.setMotion(this.rand.nextDouble() * 0.2 - 0.1, 0.2, this.rand.nextDouble() * 0.2 - 0.1);
   }

   public ItemEntity(World var1, double var2, double var4, double var6, ItemStack var8) {
      this(var1, var2, var4, var6);
      this.method4125(var8);
   }

   private ItemEntity(ItemEntity var1) {
      super(var1.getType(), var1.world);
      this.method4125(var1.method4124().copy());
      this.method3364(var1);
      this.field5515 = var1.field5515;
      this.field5520 = var1.field5520;
   }

   @Override
   public boolean canTriggerWalking() {
      return false;
   }

   @Override
   public void registerData() {
      this.getDataManager().register(field5514, ItemStack.EMPTY);
   }

   @Override
   public void tick() {
      if (!this.method4124().isEmpty()) {
         super.tick();
         if (this.field5516 > 0 && this.field5516 != 32767) {
            this.field5516--;
         }

         this.prevPosX = this.getPosX();
         this.prevPosY = this.getPosY();
         this.prevPosZ = this.getPosZ();
         Vector3d var3 = this.getMotion();
         float var4 = this.getEyeHeight() - 0.11111111F;
         if (this.isInWater() && this.method3427(FluidTags.WATER) > (double)var4) {
            this.method4115();
         } else if (this.isInLava() && this.method3427(FluidTags.field40470) > (double)var4) {
            this.method4116();
         } else if (!this.method3247()) {
            this.setMotion(this.getMotion().add(0.0, -0.04, 0.0));
         }

         if (!this.world.isRemote) {
            this.noClip = !this.world.hasNoCollisions(this);
            if (this.noClip) {
               this.pushOutOfBlocks(this.getPosX(), (this.getBoundingBox().minY + this.getBoundingBox().maxY) / 2.0, this.getPosZ());
            }
         } else {
            this.noClip = false;
         }

         if (!this.onGround || horizontalMag(this.getMotion()) > 1.0E-5F || (this.ticksExisted + this.getEntityId()) % 4 == 0) {
            this.move(MoverType.SELF, this.getMotion());
            float var5 = 0.98F;
            if (this.onGround) {
               var5 = this.world.getBlockState(new BlockPos(this.getPosX(), this.getPosY() - 1.0, this.getPosZ())).getBlock().method11571()
                  * 0.98F;
            }

            this.setMotion(this.getMotion().mul((double)var5, 0.98, (double)var5));
            if (this.onGround) {
               Vector3d var6 = this.getMotion();
               if (var6.y < 0.0) {
                  this.setMotion(var6.mul(1.0, -0.5, 1.0));
               }
            }
         }

         boolean var9 = MathHelper.floor(this.prevPosX) != MathHelper.floor(this.getPosX())
            || MathHelper.floor(this.prevPosY) != MathHelper.floor(this.getPosY())
            || MathHelper.floor(this.prevPosZ) != MathHelper.floor(this.getPosZ());
         int var10 = !var9 ? 40 : 2;
         if (this.ticksExisted % var10 == 0) {
            if (this.world.getFluidState(this.getPosition()).method23486(FluidTags.field40470) && !this.isImmuneToFire()) {
               this.playSound(SoundEvents.field26606, 0.4F, 2.0F + this.rand.nextFloat() * 0.4F);
            }

            if (!this.world.isRemote && this.method4118()) {
               this.method4117();
            }
         }

         if (this.field5515 != -32768) {
            this.field5515++;
         }

         this.isAirBorne = this.isAirBorne | this.method3257();
         if (!this.world.isRemote) {
            double var7 = this.getMotion().subtract(var3).lengthSquared();
            if (var7 > 0.01) {
               this.isAirBorne = true;
            }
         }

         if (!this.world.isRemote && this.field5515 >= 6000) {
            this.remove();
         }
      } else {
         this.remove();
      }
   }

   private void method4115() {
      Vector3d var3 = this.getMotion();
      this.setMotion(var3.x * 0.99F, var3.y + (double)(!(var3.y < 0.06F) ? 0.0F : 5.0E-4F), var3.z * 0.99F);
   }

   private void method4116() {
      Vector3d var3 = this.getMotion();
      this.setMotion(var3.x * 0.95F, var3.y + (double)(!(var3.y < 0.06F) ? 0.0F : 5.0E-4F), var3.z * 0.95F);
   }

   private void method4117() {
      if (this.method4118()) {
         for (ItemEntity var4 : this.world
            .<ItemEntity>getEntitiesInAABBexcluding(ItemEntity.class, this.getBoundingBox().grow(0.5, 0.0, 0.5), var1 -> var1 != this && var1.method4118())) {
            if (var4.method4118()) {
               this.method4119(var4);
               if (this.removed) {
                  break;
               }
            }
         }
      }
   }

   private boolean method4118() {
      ItemStack var3 = this.method4124();
      return this.isAlive() && this.field5516 != 32767 && this.field5515 != -32768 && this.field5515 < 6000 && var3.getCount() < var3.getMaxStackSize();
   }

   private void method4119(ItemEntity var1) {
      ItemStack var4 = this.method4124();
      ItemStack var5 = var1.method4124();
      if (Objects.equals(this.method4126(), var1.method4126()) && method4120(var4, var5)) {
         if (var5.getCount() >= var4.getCount()) {
            method4123(var1, var5, this, var4);
         } else {
            method4123(this, var4, var1, var5);
         }
      }
   }

   public static boolean method4120(ItemStack var0, ItemStack var1) {
      if (var1.getItem() != var0.getItem()) {
         return false;
      } else if (var1.getCount() + var0.getCount() <= var1.getMaxStackSize()) {
         return var1.method32141() ^ var0.method32141() ? false : !var1.method32141() || var1.getTag().equals(var0.getTag());
      } else {
         return false;
      }
   }

   public static ItemStack method4121(ItemStack var0, ItemStack var1, int var2) {
      int var5 = Math.min(Math.min(var0.getMaxStackSize(), var2) - var0.getCount(), var1.getCount());
      ItemStack var6 = var0.copy();
      var6.grow(var5);
      var1.shrink(var5);
      return var6;
   }

   private static void method4122(ItemEntity var0, ItemStack var1, ItemStack var2) {
      ItemStack var5 = method4121(var1, var2, 64);
      var0.method4125(var5);
   }

   private static void method4123(ItemEntity var0, ItemStack var1, ItemEntity var2, ItemStack var3) {
      method4122(var0, var1, var3);
      var0.field5516 = Math.max(var0.field5516, var2.field5516);
      var0.field5515 = Math.min(var0.field5515, var2.field5515);
      if (var3.isEmpty()) {
         var2.remove();
      }
   }

   @Override
   public boolean isImmuneToFire() {
      return this.method4124().getItem().method11748() || super.isImmuneToFire();
   }

   @Override
   public boolean attackEntityFrom(DamageSource var1, float var2) {
      if (!this.isInvulnerableTo(var1)) {
         if (!this.method4124().isEmpty() && this.method4124().getItem() == Items.field38066 && var1.method31131()) {
            return false;
         } else if (this.method4124().getItem().method11749(var1)) {
            this.markVelocityChanged();
            this.field5517 = (int)((float)this.field5517 - var2);
            if (this.field5517 <= 0) {
               this.remove();
            }

            return false;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   public void writeAdditional(CompoundNBT var1) {
      var1.putShort("Health", (short)this.field5517);
      var1.putShort("Age", (short)this.field5515);
      var1.putShort("PickupDelay", (short)this.field5516);
      if (this.method4128() != null) {
         var1.putUniqueID("Thrower", this.method4128());
      }

      if (this.method4126() != null) {
         var1.putUniqueID("Owner", this.method4126());
      }

      if (!this.method4124().isEmpty()) {
         var1.put("Item", this.method4124().method32112(new CompoundNBT()));
      }
   }

   @Override
   public void readAdditional(CompoundNBT var1) {
      this.field5517 = var1.getShort("Health");
      this.field5515 = var1.getShort("Age");
      if (var1.contains("PickupDelay")) {
         this.field5516 = var1.getShort("PickupDelay");
      }

      if (var1.hasUniqueID("Owner")) {
         this.field5519 = var1.getUniqueID("Owner");
      }

      if (var1.hasUniqueID("Thrower")) {
         this.field5518 = var1.getUniqueID("Thrower");
      }

      CompoundNBT var4 = var1.getCompound("Item");
      this.method4125(ItemStack.read(var4));
      if (this.method4124().isEmpty()) {
         this.remove();
      }
   }

   @Override
   public void onCollideWithPlayer(PlayerEntity var1) {
      if (!this.world.isRemote) {
         ItemStack var4 = this.method4124();
         Item var5 = var4.getItem();
         int var6 = var4.getCount();
         if (this.field5516 == 0 && (this.field5519 == null || this.field5519.equals(var1.getUniqueID())) && var1.inventory.method4045(var4)) {
            var1.onItemPickup(this, var6);
            if (var4.isEmpty()) {
               this.remove();
               var4.setCount(var6);
            }

            var1.method2776(Stats.field40100.method172(var5), var6);
            var1.triggerItemPickupTrigger(this);
         }
      }
   }

   @Override
   public ITextComponent getName() {
      ITextComponent var3 = this.method3380();
      return (ITextComponent)(var3 == null ? new TranslationTextComponent(this.method4124().getTranslationKey()) : var3);
   }

   @Override
   public boolean canBeAttackedWithItem() {
      return false;
   }

   @Nullable
   @Override
   public Entity changeDimension(ServerWorld var1) {
      Entity var4 = super.changeDimension(var1);
      if (!this.world.isRemote && var4 instanceof ItemEntity) {
         ((ItemEntity)var4).method4117();
      }

      return var4;
   }

   public ItemStack method4124() {
      return this.getDataManager().<ItemStack>method35445(field5514);
   }

   public void method4125(ItemStack var1) {
      this.getDataManager().set(field5514, var1);
   }

   @Override
   public void notifyDataManagerChange(DataParameter<?> var1) {
      super.notifyDataManagerChange(var1);
      if (field5514.equals(var1)) {
         this.method4124().method32166(this);
      }
   }

   @Nullable
   public UUID method4126() {
      return this.field5519;
   }

   public void method4127(UUID var1) {
      this.field5519 = var1;
   }

   @Nullable
   public UUID method4128() {
      return this.field5518;
   }

   public void method4129(UUID var1) {
      this.field5518 = var1;
   }

   public int method4130() {
      return this.field5515;
   }

   public void setDefaultPickupDelay() {
      this.field5516 = 10;
   }

   public void method4132() {
      this.field5516 = 0;
   }

   public void method4133() {
      this.field5516 = 32767;
   }

   public void method4134(int var1) {
      this.field5516 = var1;
   }

   public boolean method4135() {
      return this.field5516 > 0;
   }

   public void method4136() {
      this.field5515 = -6000;
   }

   public void method4137() {
      this.method4133();
      this.field5515 = 5999;
   }

   public float method4138(float var1) {
      return ((float)this.method4130() + var1) / 20.0F + this.field5520;
   }

   @Override
   public IPacket<?> createSpawnPacket() {
      return new SSpawnObjectPacket(this);
   }

   public ItemEntity method4139() {
      return new ItemEntity(this);
   }
}
