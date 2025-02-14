package net.minecraft.network.play.server;

import net.minecraft.network.PacketBuffer;
import net.minecraft.client.network.play.IClientPlayNetHandler;
import net.minecraft.network.IPacket;

import java.io.IOException;

public class SUpdateViewDistancePacket implements IPacket<IClientPlayNetHandler> {
   private static String[] field24427;
   private int field24428;

   public SUpdateViewDistancePacket() {
   }

   public SUpdateViewDistancePacket(int var1) {
      this.field24428 = var1;
   }

   @Override
   public void readPacketData(PacketBuffer var1) throws IOException {
      this.field24428 = var1.readVarInt();
   }

   @Override
   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeVarInt(this.field24428);
   }

   public void processPacket(IClientPlayNetHandler var1) {
      var1.handleUpdateViewDistancePacket(this);
   }

   public int method17306() {
      return this.field24428;
   }
}
