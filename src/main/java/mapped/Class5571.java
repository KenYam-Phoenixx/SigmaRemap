package mapped;

import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;

import java.io.IOException;

public class Class5571 implements IPacket<Class5108> {
   private int field24710;
   private PacketBuffer field24711;

   public Class5571() {
   }

   public Class5571(int var1, PacketBuffer var2) {
      this.field24710 = var1;
      this.field24711 = var2;
   }

   @Override
   public void readPacketData(PacketBuffer var1) throws IOException {
      this.field24710 = var1.readVarInt();
      if (!var1.readBoolean()) {
         this.field24711 = null;
      } else {
         int var4 = var1.readableBytes();
         if (var4 < 0 || var4 > 1048576) {
            throw new IOException("Payload may not be larger than 1048576 bytes");
         }

         this.field24711 = new PacketBuffer(var1.readBytes(var4));
      }
   }

   @Override
   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeVarInt(this.field24710);
      if (this.field24711 == null) {
         var1.writeBoolean(false);
      } else {
         var1.writeBoolean(true);
         var1.writeBytes(this.field24711.copy());
      }
   }

   public void processPacket(Class5108 var1) {
      var1.method15598(this);
   }
}
