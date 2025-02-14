package mapped;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.ControlsScreen;
import net.minecraft.util.text.TranslationTextComponent;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Class1295 extends Class1293<Class1186> {
   private static String[] field6859;
   private final ControlsScreen field6860;
   private int field6861;

   public Class1295(ControlsScreen var1, Minecraft var2) {
      super(var2, var1.width + 45, var1.height, 43, var1.height - 32, 20);
      this.field6860 = var1;
      KeyBinding[] var5 = (KeyBinding[])ArrayUtils.clone(var2.gameSettings.field44658);
      Arrays.sort(var5);
      String var6 = null;

      for (KeyBinding var10 : var5) {
         String var11 = var10.getKeyCategory();
         if (!var11.equals(var6)) {
            var6 = var11;
            this.method6030(new Class1187(this, new TranslationTextComponent(var11)));
         }

         TranslationTextComponent var12 = new TranslationTextComponent(var10.getKeyDescription());
         int var13 = var2.fontRenderer.method38821(var12);
         if (var13 > this.field6861) {
            this.field6861 = var13;
         }

         this.method6030(new Class1188(this, var10, var12));
      }
   }

   @Override
   public int method6048() {
      return super.method6048() + 15;
   }

   @Override
   public int method6022() {
      return super.method6022() + 32;
   }

   // $VF: synthetic method
   public static ControlsScreen method6127(Class1295 var0) {
      return var0.field6860;
   }

   // $VF: synthetic method
   public static int method6128(Class1295 var0) {
      return var0.field6861;
   }
}
