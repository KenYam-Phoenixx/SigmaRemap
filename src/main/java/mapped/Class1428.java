package mapped;

import com.mentalfrostbyte.jello.account.Account;
import com.mentalfrostbyte.jello.gui.screens.AltManagerScreen;
import com.mentalfrostbyte.jello.unmapped.CustomGuiScreen;
import net.minecraft.client.Minecraft;

import java.util.List;

public class Class1428 implements Runnable {
   public final AltManagerScreen field7661;
   public final List<Account> field7662;
   public final boolean field7663;
   public final AltManagerScreen field7664;

   public Class1428(AltManagerScreen var1, AltManagerScreen var2, List var3, boolean var4) {
      this.field7664 = var1;
      this.field7661 = var2;
      this.field7662 = var3;
      this.field7663 = var4;
   }

   @Override
   public void run() {
      int var3 = 0;
      if (AltManagerScreen.method13382(this.field7664) != null) {
         var3 = AltManagerScreen.method13382(this.field7664).method13513();
         this.field7661.method13236(AltManagerScreen.method13382(this.field7664));
      }

      CustomGuiScreen var4 = this.field7661.method13221("alts");
      if (var4 != null) {
         this.field7661.method13236(var4);
      }

      this.field7661
         .method13233(
            AltManagerScreen.method13383(
               this.field7664,
               new Class4339(
                  this.field7661,
                  "alts",
                  0,
                  114,
                  (int)((float) Minecraft.getInstance().mainWindow.getWidth() * AltManagerScreen.method13384(this.field7664)) - 4,
                  Minecraft.getInstance().mainWindow.getHeight() - 119 - AltManagerScreen.method13385(this.field7664)
               )
            )
         );

      for (Account var6 : this.field7662) {
         AltManagerScreen.method13386(this.field7664, var6, this.field7663);
      }

      AltManagerScreen.method13382(this.field7664).method13512(var3);
      AltManagerScreen.method13382(this.field7664).method13300(false);
      AltManagerScreen.method13382(this.field7664).method13515(false);
   }
}
