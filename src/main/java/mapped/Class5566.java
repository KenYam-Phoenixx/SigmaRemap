package mapped;

import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;

import java.io.IOException;

public class Class5566 implements IPacket<Class5114> {
   private static String[] field24698;

   @Override
   public void readPacketData(PacketBuffer var1) throws IOException {
   }

   @Override
   public void writePacketData(PacketBuffer var1) throws IOException {
   }

   public void processPacket(Class5114 var1) {
      var1.method15691(this);
   }
}
