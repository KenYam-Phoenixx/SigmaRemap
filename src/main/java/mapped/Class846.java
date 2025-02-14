package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.AbstractOption;
import net.minecraft.client.GameSettings;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.util.text.StringTextComponent;

public class Class846 extends Class838 {
   private Screen field4686;
   private GameSettings field4687;
   private static AbstractOption[] field4688 = new AbstractOption[]{
      AbstractOption.field25330,
      AbstractOption.field25376,
      AbstractOption.field25423,
      AbstractOption.field25422,
      AbstractOption.field25426,
      AbstractOption.field25415,
      AbstractOption.field25390,
      AbstractOption.field25412,
      AbstractOption.field25417,
      AbstractOption.field25418,
      AbstractOption.field25420,
      AbstractOption.field25425,
      AbstractOption.field25430,
      AbstractOption.field25421,
      AbstractOption.field25437,
      AbstractOption.field25440,
      AbstractOption.field25327,
      AbstractOption.field25325
   };
   private Class9046 field4689 = new Class9046(this, new Class7548());

   public Class846(Screen var1, GameSettings var2) {
      super(new StringTextComponent(I18n.format("of.options.qualityTitle")));
      this.field4686 = var1;
      this.field4687 = var2;
   }

   @Override
   public void init() {
      this.field4629.clear();

      for (int var3 = 0; var3 < field4688.length; var3++) {
         AbstractOption var4 = field4688[var3];
         int var5 = this.width / 2 - 155 + var3 % 2 * 160;
         int var6 = this.height / 6 + 21 * (var3 / 2) - 12;
         Widget var7 = this.<Widget>addButton(var4.createWidget(this.mc.gameSettings, var5, var6, 150));
         if (var4 == AbstractOption.field25423 || var4 == AbstractOption.field25422) {
            var7.active = false;
         }
      }

      this.<Class1210>addButton(new Class1210(200, this.width / 2 - 100, this.height / 6 + 168 + 11, I18n.format("gui.done")));
   }

   @Override
   public void method2563(Widget var1) {
      if (var1 instanceof Class1210) {
         Class1210 var4 = (Class1210)var1;
         if (var4.active && var4.field6523 == 200) {
            this.mc.gameSettings.saveOptions();
            this.mc.displayGuiScreen(this.field4686);
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
      drawCenteredString(var1, this.field4630, this.title, this.width / 2, 15, 16777215);
      super.render(var1, var2, var3, var4);
      this.field4689.method33640(var1, var2, var3, this.field4629);
   }
}
