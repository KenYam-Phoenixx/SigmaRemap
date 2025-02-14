package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.realmsclient.RealmsMainScreen;
import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.dto.RealmsServer;
import com.mojang.realmsclient.exception.RealmsServiceException;
import com.mojang.realmsclient.gui.screens.RealmsLongRunningMcoTaskScreen;
import com.mojang.realmsclient.gui.screens.RealmsResetWorldScreen;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.DialogTexts;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Class815 extends Class813 {
   private static final Logger field4407 = LogManager.getLogger();
   private static final ResourceLocation field4408 = new ResourceLocation("realms", "textures/gui/realms/on_icon.png");
   private static final ResourceLocation field4409 = new ResourceLocation("realms", "textures/gui/realms/off_icon.png");
   private static final ResourceLocation field4410 = new ResourceLocation("realms", "textures/gui/realms/expired_icon.png");
   private static final ResourceLocation field4411 = new ResourceLocation("realms", "textures/gui/realms/expires_soon_icon.png");
   private static final ITextComponent field4412 = new TranslationTextComponent("mco.configure.worlds.title");
   private static final ITextComponent field4413 = new TranslationTextComponent("mco.configure.world.title");
   private static final ITextComponent field4414 = new TranslationTextComponent("mco.configure.current.minigame").appendString(": ");
   private static final ITextComponent field4415 = new TranslationTextComponent("mco.selectServer.expired");
   private static final ITextComponent field4416 = new TranslationTextComponent("mco.selectServer.expires.soon");
   private static final ITextComponent field4417 = new TranslationTextComponent("mco.selectServer.expires.day");
   private static final ITextComponent field4418 = new TranslationTextComponent("mco.selectServer.open");
   private static final ITextComponent field4419 = new TranslationTextComponent("mco.selectServer.closed");
   private ITextComponent field4420;
   private final RealmsMainScreen field4421;
   private RealmsServer field4422;
   private final long field4423;
   private int field4424;
   private int field4425;
   private Button field4426;
   private Button field4427;
   private Button field4428;
   private Button field4429;
   private Button field4430;
   private Button field4431;
   private Button field4432;
   private boolean field4433;
   private int field4434;
   private int field4435;

   public Class815(RealmsMainScreen var1, long var2) {
      this.field4421 = var1;
      this.field4423 = var2;
   }

   @Override
   public void init() {
      if (this.field4422 == null) {
         this.method2276(this.field4423);
      }

      this.field4424 = this.width / 2 - 187;
      this.field4425 = this.width / 2 + 190;
      this.mc.keyboardListener.enableRepeatEvents(true);
      this.field4426 = this.<Button>addButton(
         new Button(
            this.method2273(0, 3),
            method1929(0),
            100,
            20,
            new TranslationTextComponent("mco.configure.world.buttons.players"),
            var1 -> this.mc.displayGuiScreen(new RealmGUI(this, this.field4422))
         )
      );
      this.field4427 = this.<Button>addButton(
         new Button(
            this.method2273(1, 3),
            method1929(0),
            100,
            20,
            new TranslationTextComponent("mco.configure.world.buttons.settings"),
            var1 -> this.mc.displayGuiScreen(new Class818(this, this.field4422.clone()))
         )
      );
      this.field4428 = this.<Button>addButton(
         new Button(
            this.method2273(2, 3),
            method1929(0),
            100,
            20,
            new TranslationTextComponent("mco.configure.world.buttons.subscription"),
            var1 -> this.mc.displayGuiScreen(new Class825(this, this.field4422.clone(), this.field4421))
         )
      );

      for (int var3 = 1; var3 < 5; var3++) {
         this.method2271(var3);
      }

      this.field4432 = this.<Button>addButton(
         new Button(this.method2272(0), method1929(13) - 5, 100, 20, new TranslationTextComponent("mco.configure.world.buttons.switchminigame"), var1 -> {
            Class804 var4 = new Class804(this, Class2049.field13370);
            var4.method1956(new TranslationTextComponent("mco.template.title.minigame"));
            this.mc.displayGuiScreen(var4);
         })
      );
      this.field4429 = this.<Button>addButton(
         new Button(
            this.method2272(0),
            method1929(13) - 5,
            90,
            20,
            new TranslationTextComponent("mco.configure.world.buttons.options"),
            var1 -> this.mc
                  .displayGuiScreen(
                     new Class1343(this, this.field4422.field27451.get(this.field4422.field27456).clone(), this.field4422.field27455, this.field4422.field27456)
                  )
         )
      );
      this.field4430 = this.<Button>addButton(
         new Button(
            this.method2272(1),
            method1929(13) - 5,
            90,
            20,
            new TranslationTextComponent("mco.configure.world.backup"),
            var1 -> this.mc.displayGuiScreen(new Class807(this, this.field4422.clone(), this.field4422.field27456))
         )
      );
      this.field4431 = this.<Button>addButton(
         new Button(
            this.method2272(2),
            method1929(13) - 5,
            90,
            20,
            new TranslationTextComponent("mco.configure.world.buttons.resetworld"),
            var1 -> this.mc
                  .displayGuiScreen(
                     new RealmsResetWorldScreen(
                        this, this.field4422.clone(), () -> this.mc.displayGuiScreen(this.method2298()), () -> this.mc.displayGuiScreen(this.method2298())
                     )
                  )
         )
      );
      this.<Button>addButton(new Button(this.field4425 - 80 + 8, method1929(13) - 5, 70, 20, DialogTexts.field30663, var1 -> this.method2275()));
      this.field4430.active = true;
      if (this.field4422 != null) {
         this.method2277();
         if (!this.method2288()) {
            this.method2292();
         } else {
            this.method2289();
         }
      } else {
         this.method2292();
         this.method2289();
         this.field4426.active = false;
         this.field4427.active = false;
         this.field4428.active = false;
      }
   }

   private void method2271(int var1) {
      int var4 = this.method2274(var1);
      int var5 = method1929(5) + 5;
      Class1218 var6 = new Class1218(var4, var5, 80, 80, () -> this.field4422, var1x -> this.field4420 = var1x, var1, var2 -> {
         Class8638 var5x = ((Class1218)var2).method5775();
         if (var5x != null) {
            switch (Class7876.field33816[var5x.field38887.ordinal()]) {
               case 1:
                  break;
               case 2:
                  this.method2278(this.field4422);
                  break;
               case 3:
                  if (var5x.field38886) {
                     this.method2279();
                  } else if (var5x.field38885) {
                     this.method2281(var1, this.field4422);
                  } else {
                     this.method2280(var1, this.field4422);
                  }
                  break;
               default:
                  throw new IllegalStateException("Unknown action " + var5x.field38887);
            }
         }
      });
      this.<Class1218>addButton(var6);
   }

   private int method2272(int var1) {
      return this.field4424 + var1 * 95;
   }

   private int method2273(int var1, int var2) {
      return this.width / 2 - (var2 * 105 - 5) / 2 + var1 * 105;
   }

   @Override
   public void tick() {
      super.tick();
      this.field4434++;
      this.field4435--;
      if (this.field4435 < 0) {
         this.field4435 = 0;
      }
   }

   @Override
   public void render(MatrixStack var1, int var2, int var3, float var4) {
      this.field4420 = null;
      this.renderBackground(var1);
      drawCenteredString(var1, this.font, field4412, this.width / 2, method1929(4), 16777215);
      super.render(var1, var2, var3, var4);
      if (this.field4422 != null) {
         String var7 = this.field4422.method18907();
         int var8 = this.font.getStringWidth(var7);
         int var9 = this.field4422.field27447 != Class2261.field14706 ? 8388479 : 10526880;
         int var10 = this.font.method38821(field4413);
         drawCenteredString(var1, this.font, field4413, this.width / 2, 12, 16777215);
         drawCenteredString(var1, this.font, var7, this.width / 2, 24, var9);
         int var11 = Math.min(this.method2273(2, 3) + 80 - 11, this.width / 2 + var8 / 2 + var10 / 2 + 10);
         this.method2283(var1, var11, 7, var2, var3);
         if (this.method2288()) {
            this.font
               .func_243248_b(
                  var1,
                  field4414.deepCopy().appendString(this.field4422.method18908()),
                  (float)(this.field4424 + 80 + 20 + 10),
                  (float)method1929(13),
                  16777215
               );
         }

         if (this.field4420 != null) {
            this.method2282(var1, this.field4420, var2, var3);
         }
      } else {
         drawCenteredString(var1, this.font, field4413, this.width / 2, 17, 16777215);
      }
   }

   private int method2274(int var1) {
      return this.field4424 + (var1 - 1) * 98;
   }

   @Override
   public void onClose() {
      this.mc.keyboardListener.enableRepeatEvents(false);
   }

   @Override
   public boolean keyPressed(int var1, int var2, int var3) {
      if (var1 != 256) {
         return super.keyPressed(var1, var2, var3);
      } else {
         this.method2275();
         return true;
      }
   }

   private void method2275() {
      if (this.field4433) {
         this.field4421.method2037();
      }

      this.mc.displayGuiScreen(this.field4421);
   }

   private void method2276(long var1) {
      new Thread(() -> {
         RealmsClient var5 = RealmsClient.method14543();

         try {
            this.field4422 = var5.method14548(var1);
            this.method2277();
            if (this.method2288()) {
               this.method2291(this.field4432);
            } else {
               this.method2291(this.field4429);
               this.method2291(this.field4430);
               this.method2291(this.field4431);
            }
         } catch (RealmsServiceException var7) {
            field4407.error("Couldn't get own world");
            this.mc.execute(() -> this.mc.displayGuiScreen(new Class821(ITextComponent.func_244388_a(var7.getMessage()), this.field4421)));
         }
      }).start();
   }

   private void method2277() {
      this.field4426.active = !this.field4422.field27452;
      this.field4427.active = !this.field4422.field27452;
      this.field4428.active = true;
      this.field4432.active = !this.field4422.field27452;
      this.field4429.active = !this.field4422.field27452;
      this.field4431.active = !this.field4422.field27452;
   }

   private void method2278(RealmsServer var1) {
      if (this.field4422.field27447 != Class2261.field14707) {
         this.method2295(true, new Class815(this.field4421.func_223942_f(), this.field4423));
      } else {
         this.field4421.method2046(var1, new Class815(this.field4421.func_223942_f(), this.field4423));
      }
   }

   private void method2279() {
      Class804 var3 = new Class804(this, Class2049.field13370);
      var3.method1956(new TranslationTextComponent("mco.template.title.minigame"));
      var3.method1957(new TranslationTextComponent("mco.minigame.world.info.line1"), new TranslationTextComponent("mco.minigame.world.info.line2"));
      this.mc.displayGuiScreen(var3);
   }

   private void method2280(int var1, RealmsServer var2) {
      TranslationTextComponent var5 = new TranslationTextComponent("mco.configure.world.slot.switch.question.line1");
      TranslationTextComponent var6 = new TranslationTextComponent("mco.configure.world.slot.switch.question.line2");
      this.mc.displayGuiScreen(new Class808(var3 -> {
         if (!var3) {
            this.mc.displayGuiScreen(this);
         } else {
            this.mc.displayGuiScreen(new RealmsLongRunningMcoTaskScreen(this.field4421, new Class790(var2.field27443, var1, () -> this.mc.displayGuiScreen(this.method2298()))));
         }
      }, Class2134.field13980, var5, var6, true));
   }

   private void method2281(int var1, RealmsServer var2) {
      TranslationTextComponent var5 = new TranslationTextComponent("mco.configure.world.slot.switch.question.line1");
      TranslationTextComponent var6 = new TranslationTextComponent("mco.configure.world.slot.switch.question.line2");
      this.mc
         .displayGuiScreen(
            new Class808(
               var3 -> {
                  if (!var3) {
                     this.mc.displayGuiScreen(this);
                  } else {
                     RealmsResetWorldScreen var6x = new RealmsResetWorldScreen(
                        this,
                        var2,
                        new TranslationTextComponent("mco.configure.world.switch.slot"),
                        new TranslationTextComponent("mco.configure.world.switch.slot.subtitle"),
                        10526880,
                        DialogTexts.GUI_CANCEL,
                        () -> this.mc.displayGuiScreen(this.method2298()),
                        () -> this.mc.displayGuiScreen(this.method2298())
                     );
                     var6x.method2246(var1);
                     var6x.func_224432_a(new TranslationTextComponent("mco.create.world.reset.title"));
                     this.mc.displayGuiScreen(var6x);
                  }
               },
               Class2134.field13980,
               var5,
               var6,
               true
            )
         );
   }

   public void method2282(MatrixStack var1, ITextComponent var2, int var3, int var4) {
      int var7 = var3 + 12;
      int var8 = var4 - 12;
      int var9 = this.font.method38821(var2);
      if (var7 + var9 + 3 > this.field4425) {
         var7 = var7 - var9 - 20;
      }

      this.method5688(var1, var7 - 3, var8 - 3, var7 + var9 + 3, var8 + 8 + 3, -1073741824, -1073741824);
      this.font.method38803(var1, var2, (float)var7, (float)var8, 16777215);
   }

   private void method2283(MatrixStack var1, int var2, int var3, int var4, int var5) {
      if (!this.field4422.field27452) {
         if (this.field4422.field27447 != Class2261.field14706) {
            if (this.field4422.field27447 == Class2261.field14707) {
               if (this.field4422.field27454 >= 7) {
                  this.method2286(var1, var2, var3, var4, var5);
               } else {
                  this.method2285(var1, var2, var3, var4, var5, this.field4422.field27454);
               }
            }
         } else {
            this.method2287(var1, var2, var3, var4, var5);
         }
      } else {
         this.method2284(var1, var2, var3, var4, var5);
      }
   }

   private void method2284(MatrixStack var1, int var2, int var3, int var4, int var5) {
      this.mc.getTextureManager().bindTexture(field4410);
      RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      AbstractGui.method5699(var1, var2, var3, 0.0F, 0.0F, 10, 28, 10, 28);
      if (var4 >= var2 && var4 <= var2 + 9 && var5 >= var3 && var5 <= var3 + 27) {
         this.field4420 = field4415;
      }
   }

   private void method2285(MatrixStack var1, int var2, int var3, int var4, int var5, int var6) {
      this.mc.getTextureManager().bindTexture(field4411);
      RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      if (this.field4434 % 20 >= 10) {
         AbstractGui.method5699(var1, var2, var3, 10.0F, 0.0F, 10, 28, 20, 28);
      } else {
         AbstractGui.method5699(var1, var2, var3, 0.0F, 0.0F, 10, 28, 20, 28);
      }

      if (var4 >= var2 && var4 <= var2 + 9 && var5 >= var3 && var5 <= var3 + 27) {
         if (var6 > 0) {
            if (var6 != 1) {
               this.field4420 = new TranslationTextComponent("mco.selectServer.expires.days", var6);
            } else {
               this.field4420 = field4417;
            }
         } else {
            this.field4420 = field4416;
         }
      }
   }

   private void method2286(MatrixStack var1, int var2, int var3, int var4, int var5) {
      this.mc.getTextureManager().bindTexture(field4408);
      RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      AbstractGui.method5699(var1, var2, var3, 0.0F, 0.0F, 10, 28, 10, 28);
      if (var4 >= var2 && var4 <= var2 + 9 && var5 >= var3 && var5 <= var3 + 27) {
         this.field4420 = field4418;
      }
   }

   private void method2287(MatrixStack var1, int var2, int var3, int var4, int var5) {
      this.mc.getTextureManager().bindTexture(field4409);
      RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      AbstractGui.method5699(var1, var2, var3, 0.0F, 0.0F, 10, 28, 10, 28);
      if (var4 >= var2 && var4 <= var2 + 9 && var5 >= var3 && var5 <= var3 + 27) {
         this.field4420 = field4419;
      }
   }

   private boolean method2288() {
      return this.field4422 != null && this.field4422.field27455 == Class2049.field13370;
   }

   private void method2289() {
      this.method2290(this.field4429);
      this.method2290(this.field4430);
      this.method2290(this.field4431);
   }

   private void method2290(Button var1) {
      var1.visible = false;
      this.children.remove(var1);
      this.field4566.remove(var1);
   }

   private void method2291(Button var1) {
      var1.visible = true;
      this.<Button>addButton(var1);
   }

   private void method2292() {
      this.method2290(this.field4432);
   }

   public void method2293(Class6125 var1) {
      Class6125 var4 = this.field4422.field27451.get(this.field4422.field27456);
      var1.field27431 = var4.field27431;
      var1.field27432 = var4.field27432;
      RealmsClient var5 = RealmsClient.method14543();

      try {
         var5.method14560(this.field4422.field27443, this.field4422.field27456, var1);
         this.field4422.field27451.put(this.field4422.field27456, var1);
      } catch (RealmsServiceException var7) {
         field4407.error("Couldn't save slot settings");
         this.mc.displayGuiScreen(new Class821(var7, this));
         return;
      }

      this.mc.displayGuiScreen(this);
   }

   public void method2294(String var1, String var2) {
      String var5 = var2.trim().isEmpty() ? null : var2;
      RealmsClient var6 = RealmsClient.method14543();

      try {
         var6.method14559(this.field4422.field27443, var1, var5);
         this.field4422.method18909(var1);
         this.field4422.method18910(var5);
      } catch (RealmsServiceException var8) {
         field4407.error("Couldn't save settings");
         this.mc.displayGuiScreen(new Class821(var8, this));
         return;
      }

      this.mc.displayGuiScreen(this);
   }

   public void method2295(boolean var1, Screen var2) {
      this.mc.displayGuiScreen(new RealmsLongRunningMcoTaskScreen(var2, new Class794(this.field4422, this, this.field4421, var1)));
   }

   public void method2296(Screen var1) {
      this.mc.displayGuiScreen(new RealmsLongRunningMcoTaskScreen(var1, new Class1345(this.field4422, this)));
   }

   public void method2297() {
      this.field4433 = true;
   }

   @Override
   public void method2245(Class6130 var1) {
      if (var1 != null && Class2320.field15899 == var1.field27472) {
         this.mc.displayGuiScreen(new RealmsLongRunningMcoTaskScreen(this.field4421, new Class795(this.field4422.field27443, var1, this.method2298())));
      }
   }

   public Class815 method2298() {
      return new Class815(this.field4421, this.field4423);
   }
}
