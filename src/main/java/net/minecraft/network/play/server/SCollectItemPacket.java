package net.minecraft.network.play.server;

import net.minecraft.network.PacketBuffer;
import net.minecraft.client.network.play.IClientPlayNetHandler;
import net.minecraft.network.IPacket;

import java.io.IOException;

public class SCollectItemPacket implements IPacket<IClientPlayNetHandler> {
   private static String[] field24264;
   private int field24265;
   private int field24266;
   private int field24267;

   public SCollectItemPacket() {
   }

   public SCollectItemPacket(int var1, int var2, int var3) {
      this.field24265 = var1;
      this.field24266 = var2;
      this.field24267 = var3;
   }

   @Override
   public void readPacketData(PacketBuffer var1) throws IOException {
      this.field24265 = var1.readVarInt();
      this.field24266 = var1.readVarInt();
      this.field24267 = var1.readVarInt();
   }

   @Override
   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeVarInt(this.field24265);
      var1.writeVarInt(this.field24266);
      var1.writeVarInt(this.field24267);
   }

   public void processPacket(IClientPlayNetHandler var1) {
      var1.handleCollectItem(this);
   }

   public int method17186() {
      return this.field24265;
   }

   public int method17187() {
      return this.field24266;
   }

   public int method17188() {
      return this.field24267;
   }
}
