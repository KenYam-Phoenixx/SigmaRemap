package mapped;

import com.mentalfrostbyte.Client;
import com.mentalfrostbyte.jello.module.Module;
import com.mentalfrostbyte.jello.resource.ResourceRegistry;
import com.mentalfrostbyte.jello.unmapped.CustomGuiScreen;
import com.mentalfrostbyte.jello.util.MathUtils;
import com.mentalfrostbyte.jello.unmapped.ResourceList;
import com.mentalfrostbyte.jello.util.MultiUtilities;
import com.mentalfrostbyte.jello.util.render.animation.Animation;
import com.mentalfrostbyte.jello.util.render.animation.MathHelper;
import com.mentalfrostbyte.jello.util.ClientColors;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Class4351 extends Class4278 {
   public CustomGuiScreen buttonList;
   public Animation field21264;
   public Animation field21265;
   public Animation animation;
   public Configuration currentConfig;
   public UIInput profileName;
   public int field21269;
   public final int field21270;
   public final int field21271;
   public boolean field21272 = false;

   public Class4351(CustomGuiScreen var1, String var2, int var3, int var4, int var5, int var6, Configuration config,
         int var8) {
      super(var1, var2, var3, var4, var5, var6, false);
      this.field21270 = (int) ((float) var5 * 0.8F);
      this.currentConfig = config;
      this.field21271 = var6;

      /*
       * File profileDirectory = new File(Client.getInstance().file +
       * "/profiles/");
       * if (profileDirectory.listFiles() != null) {
       * boolean profileExists = Files.exists(new File(profileDirectory,
       * config.getName + ".profile").toPath());
       * 
       * if (Client.getInstance().moduleManager.getConfigurationManager().checkConfig(
       * config) && !profileExists) {
       * Client.getInstance().moduleManager.getConfigurationManager().removeConfig(
       * config);
       * return;
       * } else if
       * (Client.getInstance().moduleManager.getConfigurationManager().checkConfig(
       * config) && profileExists) {
       * Client.getInstance().moduleManager.getConfigurationManager().listOnly(config)
       * ;
       * }
       * }
       * 
       */

      ColorHelper var11 = ColorHelper.field27961.method19415();
      var11.method19406(-11371052);
      var11.method19404(-12096331);
      var11.method19410(ClientColors.LIGHT_GREYISH_BLUE.getColor());
      ColorHelper var12 = ColorHelper.field27961.method19415();
      var12.method19406(-3254955);
      var12.method19404(-4700859);
      var12.method19410(ClientColors.LIGHT_GREYISH_BLUE.getColor());
      this.addToList(this.buttonList = new Class4284(this, "edit", var5 - this.field21270, 0, this.field21270, var6));
      ConfigScreenButton var13;
      this.buttonList.addToList(var13 = new ConfigScreenButton(this.buttonList, "rename", 0, 0, this.field21270 / 2,
            var6, var11, "Rename"));
      ConfigScreenButton deleteButton;
      this.buttonList.addToList(deleteButton = new ConfigScreenButton(this.buttonList, "remove", this.field21270 / 2, 0,
            this.field21270 / 2, var6, var12, "Delete"));
      this.buttonList.method13296(false);
      ColorHelper var15 = new ColorHelper(-892679478, -892679478, -892679478, ClientColors.DEEP_TEAL.getColor(),
            Class2218.field14488, Class2218.field14492);
      this.addToList(this.profileName = new UIInput(this, "profileName", 16, 8, this.getWidthA() - 60, 50, var15,
            config.getName));
      this.profileName.method13156(false);
      this.profileName.setFont(ResourceRegistry.JelloLightFont24);
      this.profileName.setEnabled(false);
      this.profileName.onType((var2x, var3x) -> {
         if (this.profileName.method13297() && var3x == 257) {
            this.profileName.setEnabled(false);
            this.profileName.method13145(false);
            if (Client.getInstance().moduleManager.getConfigurationManager()
                  .method20768(this.profileName.getTypedText())) {
               return;
            }

            config.getName = this.profileName.getTypedText();

            try {
               System.out.println("Saving and replacing old configs with new names.");
               Client.getInstance().moduleManager.getConfigurationManager().saveAndReplaceConfigs();
            } catch (IOException ignored) {
            }
         }
      });
      var13.setFont(ResourceRegistry.JelloLightFont18);
      deleteButton.setFont(ResourceRegistry.JelloLightFont18);
      var13.setSize((var0, var1x) -> var0.setWidthA(Math.round((float) var1x.getWidthA() / 2.0F)));
      deleteButton.setSize((var0, var1x) -> {
         var0.setXA(Math.round((float) var1x.getWidthA() / 2.0F));
         var0.setWidthA(Math.round((float) var1x.getWidthA() / 2.0F));
      });
      deleteButton.doThis((var1x, var2x) -> {
         this.animation.changeDirection(Animation.Direction.FORWARDS);
         try {
            boolean profileDeleted = Files.deleteIfExists(
                  new File(Client.getInstance().file + "/profiles/" + this.profileName.getTypedText() + ".profile")
                        .toPath());

            if (!profileDeleted) {
               File profilesFolder = new File(Client.getInstance().file + "/profiles/");
               File[] filesInProfiles = profilesFolder.listFiles();
               if (filesInProfiles == null || filesInProfiles.length == 0) {
                  System.out.println("Removing " + this.currentConfig.getName);
                  Client.getInstance().moduleManager.getConfigurationManager().removeConfig(this.currentConfig);
                  this.currentConfig.getName = "";
               }
            }
         } catch (IOException e) {
            System.out.println("Failed to delete " + this.profileName.getTypedText() + " - " + e.getMessage());
         }

      });
      var13.doThis((var1x, var2x) -> {
         this.field21265.changeDirection(Animation.Direction.BACKWARDS);
         this.profileName.setEnabled(true);
         this.profileName.method13148();
      });
      this.buttonList.setWidthA(0);
      this.buttonList.method13284(this.field21270);
      this.field21264 = new Animation(100, 100, Animation.Direction.BACKWARDS);
      this.field21265 = new Animation(290, 290, Animation.Direction.BACKWARDS);
      this.animation = new Animation(200, 100, Animation.Direction.BACKWARDS);
      this.doThis((var1x, var2x) -> {
         if (var2x != 1) {
            this.field21265.changeDirection(Animation.Direction.BACKWARDS);
            if (this.field21265.calcPercent() == 0.0F) {
               Client.getInstance().moduleManager.getConfigurationManager().loadConfig(this.currentConfig);
               Client.getInstance().soundManager.play("switch");
               ConfigButtonOnClickGui var5x = (ConfigButtonOnClickGui) this.getScreen().getScreen().getScreen();
               var5x.runThisOnDimensionUpdate(() -> var5x.method13615());

               for (Module module : Client.getInstance().moduleManager.getModuleMap().values()) {
                  if (!Client.getInstance().networkManager.isPremium()) {
                     module.setEnabledBasic(false);
                  }
               }
            }
         } else {
            this.field21265.changeDirection(Animation.Direction.FORWARDS);
         }
      });
   }

   @Override
   public void updatePanelDimensions(int newHeight, int newWidth) {
      if (!this.profileName.method13297() && this.profileName.isVisible()) {
         this.profileName.setEnabled(false);
         this.profileName.method13145(false);
         this.currentConfig.getName = this.profileName.getTypedText();

         try {
            System.out.println("Saving and replacing old configs with new names.");
            Client.getInstance().moduleManager.getConfigurationManager().saveAndReplaceConfigs();
         } catch (IOException var6) {
         }
      }

      this.field21264.changeDirection(this.method13114(newHeight, newWidth) ? Animation.Direction.FORWARDS : Animation.Direction.BACKWARDS);
      if (!this.method13114(newHeight, newWidth)) {
         this.field21265.changeDirection(Animation.Direction.BACKWARDS);
      }

      super.updatePanelDimensions(newHeight, newWidth);
   }

   @Override
   public void draw(float partialTicks) {
      if (this.animation.calcPercent() == 1.0F && !this.field21272) {
         this.field21272 = true;
         ConfigButtonOnClickGui var4 = (ConfigButtonOnClickGui) this.getScreen().getScreen().getScreen();
         Client.getInstance().moduleManager.getConfigurationManager().checkConfig(this.currentConfig);
         var4.runThisOnDimensionUpdate(() -> var4.method13615());
      }

      float var8 = MathUtils.lerp(this.animation.calcPercent(), 0.1, 0.81, 0.14, 1.0);
      this.setHeightA(Math.round((1.0F - var8) * (float) this.field21271));
      partialTicks *= 1.0F - this.animation.calcPercent();
      float var5 = MathUtils.lerp(this.field21265.calcPercent(), 0.28, 1.26, 0.33, 1.04);
      if (this.field21265.getDirection().equals(Animation.Direction.BACKWARDS)) {
         var5 = MathHelper.calculateBackwardTransition(this.field21265.calcPercent(), 0.0F, 1.0F, 1.0F);
      }

      this.buttonList.method13296(this.field21265.calcPercent() == 1.0F);
      this.buttonList.setWidthA(Math.max(0, (int) ((float) this.field21270 * var5)));
      this.buttonList.method13284((int) ((float) this.field21270 * (1.0F - var5)));
      RenderUtil.method11415(this);
      float var6 = this.method13212() && this.field21265.getDirection().equals(Animation.Direction.BACKWARDS) ? 0.03F : 0.0F;
      RenderUtil.renderBackgroundBox(
            (float) this.xA,
            (float) this.yA,
            (float) this.widthA,
            (float) this.heightA,
            MultiUtilities.applyAlpha(ClientColors.DEEP_TEAL.getColor(), 0.04F * this.field21264.calcPercent() + var6));
      if (!this.profileName.method13297()) {
         RenderUtil.drawString(
               ResourceRegistry.JelloLightFont24,
               (float) (this.xA + 20) - var5 * (float) this.widthA,
               (float) (this.yA + 18),
               this.currentConfig.getName,
               MultiUtilities.applyAlpha(ClientColors.DEEP_TEAL.getColor(), 0.9F * partialTicks));
      }

      this.profileName.method13284(Math.round(-var5 * (float) this.widthA));
      if (Client.getInstance().moduleManager.getConfigurationManager().getCurrentConfig() == this.currentConfig) {
         RenderUtil.drawImage(
               (float) (this.getXA() + this.getWidthA() - 35) - var5 * (float) this.widthA,
               (float) (this.getYA() + 27),
               17.0F,
               13.0F,
               ResourceList.activePNG,
               MultiUtilities.applyAlpha(ClientColors.LIGHT_GREYISH_BLUE.getColor(),
                     (1.0F - this.field21265.calcPercent()) * partialTicks));
      }

      super.draw(partialTicks);
      RenderUtil.endScissor();
   }
}
