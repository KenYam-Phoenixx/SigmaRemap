package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.Arrays;

public class Class931 extends Class932 implements Class930, ITickableTileEntity {
   private static final int[] field5270 = new int[]{3};
   private static final int[] field5271 = new int[]{0, 1, 2, 3};
   private static final int[] field5272 = new int[]{0, 1, 2, 4};
   private NonNullList<ItemStack> field5273 = NonNullList.<ItemStack>method68(5, ItemStack.EMPTY);
   private int field5274;
   private boolean[] field5275;
   private Item field5276;
   private int field5277;
   public final Class8202 field5278 = new Class8203(this);

   public Class931() {
      super(TileEntityType.field21431);
   }

   @Override
   public ITextComponent getDefaultName() {
      return new TranslationTextComponent("container.brewing");
   }

   @Override
   public int getSizeInventory() {
      return this.field5273.size();
   }

   @Override
   public boolean isEmpty() {
      for (ItemStack var4 : this.field5273) {
         if (!var4.isEmpty()) {
            return false;
         }
      }

      return true;
   }

   @Override
   public void tick() {
      ItemStack var3 = this.field5273.get(4);
      if (this.field5277 <= 0 && var3.getItem() == Items.field37975) {
         this.field5277 = 20;
         var3.shrink(1);
         this.markDirty();
      }

      boolean var4 = this.method3688();
      boolean var5 = this.field5274 > 0;
      ItemStack var6 = this.field5273.get(3);
      if (!var5) {
         if (var4 && this.field5277 > 0) {
            this.field5277--;
            this.field5274 = 400;
            this.field5276 = var6.getItem();
            this.markDirty();
         }
      } else {
         this.field5274--;
         boolean var7 = this.field5274 == 0;
         if (var7 && var4) {
            this.method3689();
            this.markDirty();
         } else if (var4) {
            if (this.field5276 != var6.getItem()) {
               this.field5274 = 0;
               this.markDirty();
            }
         } else {
            this.field5274 = 0;
            this.markDirty();
         }
      }

      if (!this.world.isRemote) {
         boolean[] var10 = this.method3687();
         if (!Arrays.equals(var10, this.field5275)) {
            this.field5275 = var10;
            BlockState var8 = this.world.getBlockState(this.getPos());
            if (!(var8.getBlock() instanceof Class3376)) {
               return;
            }

            for (int var9 = 0; var9 < Class3376.field18975.length; var9++) {
               var8 = var8.with(Class3376.field18975[var9], Boolean.valueOf(var10[var9]));
            }

            this.world.setBlockState(this.pos, var8, 2);
         }
      }
   }

   public boolean[] method3687() {
      boolean[] var3 = new boolean[3];

      for (int var4 = 0; var4 < 3; var4++) {
         if (!this.field5273.get(var4).isEmpty()) {
            var3[var4] = true;
         }
      }

      return var3;
   }

   private boolean method3688() {
      ItemStack var3 = this.field5273.get(3);
      if (!var3.isEmpty()) {
         if (Class7105.method22132(var3)) {
            for (int var4 = 0; var4 < 3; var4++) {
               ItemStack var5 = this.field5273.get(var4);
               if (!var5.isEmpty() && Class7105.method22136(var5, var3)) {
                  return true;
               }
            }

            return false;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private void method3689() {
      ItemStack var3 = this.field5273.get(3);

      for (int var4 = 0; var4 < 3; var4++) {
         this.field5273.set(var4, Class7105.method22139(var3, this.field5273.get(var4)));
      }

      var3.shrink(1);
      BlockPos var6 = this.getPos();
      if (var3.getItem().method11723()) {
         ItemStack var5 = new ItemStack(var3.getItem().method11722());
         if (!var3.isEmpty()) {
            if (!this.world.isRemote) {
               Class7236.method22725(this.world, (double)var6.getX(), (double)var6.getY(), (double)var6.getZ(), var5);
            }
         } else {
            var3 = var5;
         }
      }

      this.field5273.set(3, var3);
      this.world.playEvent(1035, var6, 0);
   }

   @Override
   public void read(BlockState var1, CompoundNBT var2) {
      super.read(var1, var2);
      this.field5273 = NonNullList.<ItemStack>method68(this.getSizeInventory(), ItemStack.EMPTY);
      ItemStackHelper.loadAllItems(var2, this.field5273);
      this.field5274 = var2.getShort("BrewTime");
      this.field5277 = var2.getByte("Fuel");
   }

   @Override
   public CompoundNBT write(CompoundNBT var1) {
      super.write(var1);
      var1.putShort("BrewTime", (short)this.field5274);
      ItemStackHelper.saveAllItems(var1, this.field5273);
      var1.putByte("Fuel", (byte)this.field5277);
      return var1;
   }

   @Override
   public ItemStack getStackInSlot(int var1) {
      return var1 >= 0 && var1 < this.field5273.size() ? this.field5273.get(var1) : ItemStack.EMPTY;
   }

   @Override
   public ItemStack decrStackSize(int var1, int var2) {
      return ItemStackHelper.method26563(this.field5273, var1, var2);
   }

   @Override
   public ItemStack removeStackFromSlot(int var1) {
      return ItemStackHelper.method26564(this.field5273, var1);
   }

   @Override
   public void setInventorySlotContents(int var1, ItemStack var2) {
      if (var1 >= 0 && var1 < this.field5273.size()) {
         this.field5273.set(var1, var2);
      }
   }

   @Override
   public boolean isUsableByPlayer(PlayerEntity var1) {
      return this.world.getTileEntity(this.pos) == this
         ? !(
            var1.getDistanceNearest((double)this.pos.getX() + 0.5, (double)this.pos.getY() + 0.5, (double)this.pos.getZ() + 0.5)
               > 64.0
         )
         : false;
   }

   @Override
   public boolean isItemValidForSlot(int var1, ItemStack var2) {
      if (var1 != 3) {
         Item var5 = var2.getItem();
         return var1 == 4
            ? var5 == Items.field37975
            : (var5 == Items.field37971 || var5 == Items.SPLASH_POTION || var5 == Items.field38118 || var5 == Items.field37972)
               && this.getStackInSlot(var1).isEmpty();
      } else {
         return Class7105.method22132(var2);
      }
   }

   @Override
   public int[] method3653(Direction var1) {
      if (var1 != Direction.UP) {
         return var1 != Direction.DOWN ? field5272 : field5271;
      } else {
         return field5270;
      }
   }

   @Override
   public boolean method3654(int var1, ItemStack var2, Direction var3) {
      return this.isItemValidForSlot(var1, var2);
   }

   @Override
   public boolean method3655(int var1, ItemStack var2, Direction var3) {
      return var1 != 3 ? true : var2.getItem() == Items.field37972;
   }

   @Override
   public void method3625() {
      this.field5273.clear();
   }

   @Override
   public Container createMenu(int var1, PlayerInventory var2) {
      return new Class5819(var1, var2, this, this.field5278);
   }

   // $VF: synthetic method
   public static int method3691(Class931 var0) {
      return var0.field5274;
   }

   // $VF: synthetic method
   public static int method3692(Class931 var0) {
      return var0.field5277;
   }

   // $VF: synthetic method
   public static int method3693(Class931 var0, int var1) {
      return var0.field5274 = var1;
   }

   // $VF: synthetic method
   public static int method3694(Class931 var0, int var1) {
      return var0.field5277 = var1;
   }

   @Override
   public ITextComponent getDefaultName2() {
      return new TranslationTextComponent("container.brewing");
   }
}
