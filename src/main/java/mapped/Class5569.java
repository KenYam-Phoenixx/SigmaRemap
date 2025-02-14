package mapped;

import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.CryptException;
import net.minecraft.util.CryptManager;

import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.SecretKey;

public class Class5569 implements IPacket<Class5108> {
   private static String[] field24704;
   private byte[] field24705 = new byte[0];
   private byte[] field24706 = new byte[0];

   public Class5569() {
   }

   public Class5569(SecretKey var1, PublicKey var2, byte[] var3) throws CryptException {
      this.field24705 = CryptManager.method32742(var2, var1.getEncoded());
      this.field24706 = CryptManager.method32742(var2, var3);
   }

   @Override
   public void readPacketData(PacketBuffer var1) throws IOException {
      this.field24705 = var1.readByteArray();
      this.field24706 = var1.readByteArray();
   }

   @Override
   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeByteArray(this.field24705);
      var1.writeByteArray(this.field24706);
   }

   public void processPacket(Class5108 var1) {
      var1.method15597(this);
   }

   public SecretKey method17495(PrivateKey var1) throws CryptException {
      return CryptManager.method32741(var1, this.field24705);
   }

   public byte[] method17496(PrivateKey var1) throws CryptException {
      return CryptManager.method32743(var1, this.field24706);
   }
}
