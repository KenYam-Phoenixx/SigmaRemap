package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class Class947 extends TileEntity implements IClearable {
   private ItemStack field5332 = ItemStack.EMPTY;

   public Class947() {
      super(TileEntityType.field21425);
   }

   @Override
   public void read(BlockState var1, CompoundNBT var2) {
      super.read(var1, var2);
      if (var2.contains("RecordItem", 10)) {
         this.method3804(ItemStack.read(var2.getCompound("RecordItem")));
      }
   }

   @Override
   public CompoundNBT write(CompoundNBT var1) {
      super.write(var1);
      if (!this.method3803().isEmpty()) {
         var1.put("RecordItem", this.method3803().method32112(new CompoundNBT()));
      }

      return var1;
   }

   public ItemStack method3803() {
      return this.field5332;
   }

   public void method3804(ItemStack var1) {
      this.field5332 = var1;
      this.markDirty();
   }

   @Override
   public void method3625() {
      this.method3804(ItemStack.EMPTY);
   }
}
