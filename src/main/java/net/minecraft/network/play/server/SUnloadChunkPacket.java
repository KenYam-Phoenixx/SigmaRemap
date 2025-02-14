package net.minecraft.network.play.server;

import net.minecraft.network.PacketBuffer;
import net.minecraft.client.network.play.IClientPlayNetHandler;
import net.minecraft.network.IPacket;

import java.io.IOException;

public class SUnloadChunkPacket implements IPacket<IClientPlayNetHandler> {
   private static String[] field24699;
   private int field24700;
   private int field24701;

   public SUnloadChunkPacket() {
   }

   public SUnloadChunkPacket(int var1, int var2) {
      this.field24700 = var1;
      this.field24701 = var2;
   }

   @Override
   public void readPacketData(PacketBuffer var1) throws IOException {
      this.field24700 = var1.readInt();
      this.field24701 = var1.readInt();
   }

   @Override
   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeInt(this.field24700);
      var1.writeInt(this.field24701);
   }

   public void processPacket(IClientPlayNetHandler var1) {
      var1.processChunkUnload(this);
   }

   public int method17492() {
      return this.field24700;
   }

   public int method17493() {
      return this.field24701;
   }
}
