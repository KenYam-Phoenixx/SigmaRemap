package net.minecraft.network;

import java.io.IOException;

public interface IPacket<T extends INetHandler> {
   void readPacketData(PacketBuffer var1) throws IOException;

   void writePacketData(PacketBuffer var1) throws IOException;

   void processPacket(T var1);

   default boolean method17181() {
      return false;
   }
}
