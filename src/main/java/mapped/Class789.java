package mapped;

import com.mojang.realmsclient.gui.screens.RealmsLongRunningMcoTaskScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.ITextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Class789 implements Class796, Runnable {
   public static final Logger field4133 = LogManager.getLogger();
   public RealmsLongRunningMcoTaskScreen field4134;

   public static void method1904(int var0) {

   }

   public static void method1905(Screen var0) {
      Minecraft var3 = Minecraft.getInstance();
      var3.execute(() -> var3.displayGuiScreen(var0));
   }

   public void method1906(RealmsLongRunningMcoTaskScreen var1) {
      this.field4134 = var1;
   }

   @Override
   public void method1907(ITextComponent var1) {
      this.field4134.method1907(var1);
   }

   public void method1908(ITextComponent var1) {
      this.field4134.method1925(var1);
   }

   public boolean method1909() {
      return this.field4134.method1926();
   }

   public void method1910() {
   }

   public void method1911() {
   }

   public void method1912() {
   }
}
