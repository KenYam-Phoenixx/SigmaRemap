package net.minecraft.network.play.server;

import net.minecraft.network.PacketBuffer;
import net.minecraft.client.network.play.IClientPlayNetHandler;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;

import java.io.IOException;
import javax.annotation.Nullable;

public class SQueryNBTResponsePacket implements IPacket<IClientPlayNetHandler> {
   private static String[] field24456;
   private int field24457;
   private CompoundNBT field24458;

   public SQueryNBTResponsePacket() {
   }

   public SQueryNBTResponsePacket(int var1, CompoundNBT var2) {
      this.field24457 = var1;
      this.field24458 = var2;
   }

   @Override
   public void readPacketData(PacketBuffer var1) throws IOException {
      this.field24457 = var1.readVarInt();
      this.field24458 = var1.readCompoundTag();
   }

   @Override
   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeVarInt(this.field24457);
      var1.writeCompoundTag(this.field24458);
   }

   public void processPacket(IClientPlayNetHandler var1) {
      var1.handleNBTQueryResponse(this);
   }

   public int method17328() {
      return this.field24457;
   }

   @Nullable
   public CompoundNBT method17329() {
      return this.field24458;
   }

   @Override
   public boolean method17181() {
      return true;
   }
}
