package mapped;

import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.exception.RealmsServiceException;

public class Class378 extends Thread {
   public final Class825 field1634;

   public Class378(Class825 var1, String var2) {
      super(var2);
      this.field1634 = var1;
   }

   @Override
   public void run() {
      try {
         RealmsClient var3 = RealmsClient.method14543();
         var3.method14583(Class825.method2448(this.field1634).field27443);
      } catch (RealmsServiceException var4) {
         Class825.method2449().error("Couldn't delete world");
         Class825.method2449().error(var4);
      }

      Class825.method2450(this.field1634).execute(() -> Class825.method2452(this.field1634).displayGuiScreen(Class825.method2451(this.field1634)));
   }
}
