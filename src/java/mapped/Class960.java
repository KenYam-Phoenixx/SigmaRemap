package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;

import javax.annotation.Nullable;

public class Class960 extends TileEntity implements Class935 {
   private final Class7574 field5390 = new Class7573(this);

   public Class960() {
      super(Class4387.field21429);
   }

   @Override
   public void method3645(BlockState var1, CompoundNBT var2) {
      super.method3645(var1, var2);
      this.field5390.method24794(var2);
   }

   @Override
   public CompoundNBT write(CompoundNBT var1) {
      super.write(var1);
      this.field5390.method24795(var1);
      return var1;
   }

   @Override
   public void method3647() {
      this.field5390.method24792();
   }

   @Nullable
   @Override
   public SUpdateTileEntityPacket method3776() {
      return new SUpdateTileEntityPacket(this.field5325, 1, this.method3777());
   }

   @Override
   public CompoundNBT method3777() {
      CompoundNBT var3 = this.write(new CompoundNBT());
      var3.method133("SpawnPotentials");
      return var3;
   }

   @Override
   public boolean method3751(int var1, int var2) {
      return !this.field5390.method24797(var1) ? super.method3751(var1, var2) : true;
   }

   @Override
   public boolean method3783() {
      return true;
   }

   public Class7574 method3911() {
      return this.field5390;
   }
}
