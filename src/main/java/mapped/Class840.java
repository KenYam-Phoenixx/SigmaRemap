package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.AbstractOption;
import net.minecraft.client.GameSettings;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.util.text.StringTextComponent;

public class Class840 extends Class838 {
   private Screen field4636;
   private GameSettings field4637;
   private static AbstractOption[] field4638 = new AbstractOption[]{
      AbstractOption.field25382,
      AbstractOption.field25383,
      AbstractOption.field25384,
      AbstractOption.field25385,
      AbstractOption.field25391,
      AbstractOption.field25392,
      AbstractOption.field25393,
      AbstractOption.field25394,
      AbstractOption.field25404,
      AbstractOption.field25405,
      AbstractOption.field25406,
      AbstractOption.field25407,
      AbstractOption.field25408,
      AbstractOption.field25411,
      AbstractOption.field25413,
      AbstractOption.field25424,
      AbstractOption.field25409,
      AbstractOption.field25347
   };

   public Class840(Screen var1, GameSettings var2) {
      super(new StringTextComponent(I18n.format("of.options.animationsTitle")));
      this.field4636 = var1;
      this.field4637 = var2;
   }

   @Override
   public void init() {
      this.field4629.clear();

      for (int var3 = 0; var3 < field4638.length; var3++) {
         AbstractOption var4 = field4638[var3];
         int var5 = this.width / 2 - 155 + var3 % 2 * 160;
         int var6 = this.height / 6 + 21 * (var3 / 2) - 12;
         this.<Widget>addButton(var4.createWidget(this.mc.gameSettings, var5, var6, 150));
      }

      this.<Class1210>addButton(
         new Class1210(210, this.width / 2 - 155, this.height / 6 + 168 + 11, 70, 20, Class8043.method27619("of.options.animation.allOn"))
      );
      this.<Class1210>addButton(
         new Class1210(211, this.width / 2 - 155 + 80, this.height / 6 + 168 + 11, 70, 20, Class8043.method27619("of.options.animation.allOff"))
      );
      this.<Class1211>addButton(new Class1211(200, this.width / 2 + 5, this.height / 6 + 168 + 11, I18n.format("gui.done")));
   }

   @Override
   public void method2563(Widget var1) {
      if (var1 instanceof Class1210) {
         Class1210 var4 = (Class1210)var1;
         if (var4.active) {
            if (var4.field6523 == 200) {
               this.mc.gameSettings.saveOptions();
               this.mc.displayGuiScreen(this.field4636);
            }

            if (var4.field6523 == 210) {
               this.mc.gameSettings.method37166(true);
            }

            if (var4.field6523 == 211) {
               this.mc.gameSettings.method37166(false);
            }

            this.mc.updateWindowSize();
         }
      }
   }

   @Override
   public void onClose() {
      this.mc.gameSettings.saveOptions();
      super.onClose();
   }

   @Override
   public void render(MatrixStack var1, int var2, int var3, float var4) {
      this.renderBackground(var1);
      drawCenteredString(var1, this.mc.fontRenderer, this.title, this.width / 2, 15, 16777215);
      super.render(var1, var2, var3, var4);
   }
}
