package mapped;

import javax.swing.*;
import java.util.Vector;

public class Class2514 extends JList<String> {
   private static String[] field16634;
   private final MinecraftServer field16635;
   private int field16636;

   public Class2514(MinecraftServer var1) {
      this.field16635 = var1;
      var1.method1313(this::method10516);
   }

   public void method10516() {
      if (this.field16636++ % 20 == 0) {
         Vector var3 = new Vector();

         for (int var4 = 0; var4 < this.field16635.getPlayerList().getPlayers().size(); var4++) {
            var3.add(this.field16635.getPlayerList().getPlayers().get(var4).getGameProfile().getName());
         }

         this.setListData(var3);
      }
   }
}
