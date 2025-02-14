package net.minecraft.network.play.server;

import net.minecraft.network.PacketBuffer;
import net.minecraft.client.network.play.IClientPlayNetHandler;
import net.minecraft.network.IPacket;

import java.io.IOException;

public class SSetExperiencePacket implements IPacket<IClientPlayNetHandler> {
   private static String[] field24446;
   private float field24447;
   private int field24448;
   private int field24449;

   public SSetExperiencePacket() {
   }

   public SSetExperiencePacket(float var1, int var2, int var3) {
      this.field24447 = var1;
      this.field24448 = var2;
      this.field24449 = var3;
   }

   @Override
   public void readPacketData(PacketBuffer var1) throws IOException {
      this.field24447 = var1.readFloat();
      this.field24449 = var1.readVarInt();
      this.field24448 = var1.readVarInt();
   }

   @Override
   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeFloat(this.field24447);
      var1.writeVarInt(this.field24449);
      var1.writeVarInt(this.field24448);
   }

   public void processPacket(IClientPlayNetHandler var1) {
      var1.handleSetExperience(this);
   }

   public float method17321() {
      return this.field24447;
   }

   public int method17322() {
      return this.field24448;
   }

   public int method17323() {
      return this.field24449;
   }
}
