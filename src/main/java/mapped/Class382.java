package mapped;

import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.exception.RealmsServiceException;

public class Class382 extends Thread {
   public final int field1642;
   public final RealmsScreenReal field1643;

   public Class382(RealmsScreenReal var1, String var2, int var3) {
      super(var2);
      this.field1643 = var1;
      this.field1642 = var3;
   }

   @Override
   public void run() {
      try {
         RealmsClient var3 = RealmsClient.method14543();
         var3.method14575(Class1160.method5558(RealmsScreenReal.method2390(this.field1643).getEventListeners().get(this.field1642)).field27370);
         RealmsScreenReal.method2393(this.field1643).execute(() -> RealmsScreenReal.method2392(this.field1643, field1642));
      } catch (RealmsServiceException var4) {
         RealmsScreenReal.method2388().error("Couldn't accept invite");
      }
   }
}
