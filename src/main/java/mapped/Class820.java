package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.DialogTexts;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.Util;
import net.minecraft.realms.RealmsScreen;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class Class820 extends RealmsScreen {
   private static final ITextComponent field4473 = new TranslationTextComponent("mco.account.privacyinfo");
   private final Screen field4474;
   private Class5991 field4475 = Class5991.field26162;

   public Class820(Screen var1) {
      this.field4474 = var1;
   }

   @Override
   public void init() {
      Class9229.method34711(field4473.getString());
      TranslationTextComponent var3 = new TranslationTextComponent("mco.account.update");
      ITextComponent var4 = DialogTexts.field30663;
      int var5 = Math.max(this.font.method38821(var3), this.font.method38821(var4)) + 30;
      TranslationTextComponent var6 = new TranslationTextComponent("mco.account.privacy.info");
      int var7 = (int)((double)this.font.method38821(var6) * 1.2);
      this.<Button>addButton(
         new Button(
            this.width / 2 - var7 / 2, method1929(11), var7, 20, var6, var0 -> Util.getOSType().openLink("https://aka.ms/MinecraftGDPR")
         )
      );
      this.<Button>addButton(
         new Button(
            this.width / 2 - (var5 + 5), method1929(13), var5, 20, var3, var0 -> Util.getOSType().openLink("https://aka.ms/UpdateMojangAccount")
         )
      );
      this.<Button>addButton(new Button(this.width / 2 + 5, method1929(13), var5, 20, var4, var1 -> this.mc.displayGuiScreen(this.field4474)));
      this.field4475 = Class5991.method18584(this.font, field4473, (int)Math.round((double)this.width * 0.9));
   }

   @Override
   public void render(MatrixStack var1, int var2, int var3, float var4) {
      this.renderBackground(var1);
      this.field4475.method18589(var1, this.width / 2, 15, 15, 16777215);
      super.render(var1, var2, var3, var4);
   }
}
