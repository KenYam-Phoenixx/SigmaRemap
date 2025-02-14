package mapped;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.recipebook.RecipeList;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.util.ClientRecipeBook;
import net.minecraft.client.util.RecipeBookCategories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.network.play.client.CUpdateRecipeBookStatusPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Class1254 extends AbstractGui implements Class1190, IGuiEventListener2, Class1259, Class1253<Ingredient> {
   public static final ResourceLocation field6630 = new ResourceLocation("textures/gui/recipe_book.png");
   private static final ITextComponent field6631 = new TranslationTextComponent("gui.recipebook.search_hint")
      .mergeStyle(TextFormatting.ITALIC)
      .mergeStyle(TextFormatting.GRAY);
   private static final ITextComponent field6632 = new TranslationTextComponent("gui.recipebook.toggleRecipes.craftable");
   private static final ITextComponent field6633 = new TranslationTextComponent("gui.recipebook.toggleRecipes.all");
   private int field6634;
   private int field6635;
   private int field6636;
   public final Class9235 field6637 = new Class9235();
   private final List<Class1250> field6638 = Lists.newArrayList();
   private Class1250 field6639;
   public Class1249 field6640;
   public Class5828<?> field6641;
   public Minecraft field6642;
   private TextFieldWidget field6643;
   private String field6644 = "";
   private ClientRecipeBook field6645;
   private final Class2954 field6646 = new Class2954();
   private final Class6207 field6647 = new Class6207();
   private int field6648;
   private boolean field6649;

   public void method5833(int var1, int var2, Minecraft var3, boolean var4, Class5828<?> var5) {
      this.field6642 = var3;
      this.field6635 = var1;
      this.field6636 = var2;
      this.field6641 = var5;
      var3.player.openContainer = var5;
      this.field6645 = var3.player.getRecipeBook();
      this.field6648 = var3.player.inventory.method4055();
      if (this.method5839()) {
         this.method5834(var4);
      }

      var3.keyboardListener.enableRepeatEvents(true);
   }

   public void method5834(boolean var1) {
      this.field6634 = !var1 ? 86 : 0;
      int var4 = (this.field6635 - 147) / 2 - this.field6634;
      int var5 = (this.field6636 - 166) / 2;
      this.field6647.method19128();
      this.field6642.player.inventory.method4061(this.field6647);
      this.field6641.method18220(this.field6647);
      String var6 = this.field6643 == null ? "" : this.field6643.getText();
      this.field6643 = new TextFieldWidget(this.field6642.fontRenderer, var4 + 25, var5 + 14, 80, 14, new TranslationTextComponent("itemGroup.search"));
      this.field6643.method5657(50);
      this.field6643.method5661(false);
      this.field6643.method5671(true);
      this.field6643.method5662(16777215);
      this.field6643.method5635(var6);
      this.field6646.method11306(this.field6642, var4, var5);
      this.field6646.method11307(this);
      this.field6640 = new Class1249(var4 + 110, var5 + 12, 26, 16, this.field6645.method21370(this.field6641));
      this.method5835();
      this.field6638.clear();

      for (RecipeBookCategories var8 : RecipeBookCategories.func_243236_a(this.field6641.method18227())) {
         this.field6638.add(new Class1250(var8));
      }

      if (this.field6639 != null) {
         this.field6639 = this.field6638.stream().filter(var1x -> var1x.method5827().equals(this.field6639.method5827())).findFirst().orElse((Class1250)null);
      }

      if (this.field6639 == null) {
         this.field6639 = this.field6638.get(0);
      }

      this.field6639.method5822(true);
      this.method5842(false);
      this.method5843();
   }

   @Override
   public boolean changeFocus(boolean var1) {
      return false;
   }

   public void method5835() {
      this.field6640.method5821(152, 41, 28, 18, field6630);
   }

   public void method5836() {
      this.field6643 = null;
      this.field6639 = null;
      this.field6642.keyboardListener.enableRepeatEvents(false);
   }

   public int method5837(boolean var1, int var2, int var3) {
      int var6;
      if (this.method5839() && !var1) {
         var6 = 177 + (var2 - var3 - 200) / 2;
      } else {
         var6 = (var2 - var3) / 2;
      }

      return var6;
   }

   public void method5838() {
      this.method5840(!this.method5839());
   }

   public boolean method5839() {
      return this.field6645.method21368(this.field6641.method18227());
   }

   public void method5840(boolean var1) {
      this.field6645.method21369(this.field6641.method18227(), var1);
      if (!var1) {
         this.field6646.method11315();
      }

      this.method5859();
   }

   public void method5841(Slot var1) {
      if (var1 != null && var1.slotNumber < this.field6641.method18226()) {
         this.field6637.method34733();
         if (this.method5839()) {
            this.method5845();
         }
      }
   }

   private void method5842(boolean var1) {
      List<RecipeList> var4 = this.field6645.getRecipes(this.field6639.method5827());
      var4.forEach(var1x -> var1x.method34888(this.field6647, this.field6641.method18224(), this.field6641.method18225(), this.field6645));
      ArrayList<RecipeList> var5 = Lists.newArrayList(var4);
      var5.removeIf(var0 -> !var0.method34886());
      var5.removeIf(var0 -> !var0.method34891());
      String var6 = this.field6643.getText();
      if (!var6.isEmpty()) {
         ObjectLinkedOpenHashSet var7 = new ObjectLinkedOpenHashSet(
            this.field6642.<RecipeList>getSearchTree(SearchTreeManager.RECIPES).method21737(var6.toLowerCase(Locale.ROOT))
         );
         var5.removeIf(var1x -> !var7.contains(var1x));
      }

      if (this.field6645.method21370(this.field6641)) {
         var5.removeIf(var0 -> !var0.method34890());
      }

      this.field6646.method11308(var5, var1);
   }

   private void method5843() {
      int var3 = (this.field6635 - 147) / 2 - this.field6634 - 30;
      int var4 = (this.field6636 - 166) / 2 + 3;
      int var6 = 0;

      for (Class1250 var8 : this.field6638) {
         RecipeBookCategories var9 = var8.method5827();
         if (var9 == RecipeBookCategories.CRAFTING_SEARCH || var9 == RecipeBookCategories.FURNACE_SEARCH) {
            var8.visible = true;
            var8.method5824(var3, var4 + 27 * var6++);
         } else if (var8.method5828(this.field6645)) {
            var8.method5824(var3, var4 + 27 * var6++);
            var8.method5825(this.field6642);
         }
      }
   }

   public void method5844() {
      if (this.method5839()) {
         if (this.field6648 != this.field6642.player.inventory.method4055()) {
            this.method5845();
            this.field6648 = this.field6642.player.inventory.method4055();
         }

         this.field6643.method5633();
      }
   }

   private void method5845() {
      this.field6647.method19128();
      this.field6642.player.inventory.method4061(this.field6647);
      this.field6641.method18220(this.field6647);
      this.method5842(false);
   }

   @Override
   public void render(MatrixStack var1, int var2, int var3, float var4) {
      if (this.method5839()) {
         RenderSystem.pushMatrix();
         RenderSystem.translatef(0.0F, 0.0F, 100.0F);
         this.field6642.getTextureManager().bindTexture(field6630);
         RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
         int var7 = (this.field6635 - 147) / 2 - this.field6634;
         int var8 = (this.field6636 - 166) / 2;
         this.blit(var1, var7, var8, 1, 1, 147, 166);
         if (!this.field6643.method5746() && this.field6643.getText().isEmpty()) {
            drawString(var1, this.field6642.fontRenderer, field6631, var7 + 25, var8 + 14, -1);
         } else {
            this.field6643.render(var1, var2, var3, var4);
         }

         for (Class1250 var10 : this.field6638) {
            var10.render(var1, var2, var3, var4);
         }

         this.field6640.render(var1, var2, var3, var4);
         this.field6646.method11311(var1, var7, var8, var2, var3, var4);
         RenderSystem.popMatrix();
      }
   }

   public void method5846(MatrixStack var1, int var2, int var3, int var4, int var5) {
      if (this.method5839()) {
         this.field6646.method11312(var1, var4, var5);
         if (this.field6640.isHovered()) {
            ITextComponent var8 = this.method5847();
            if (this.field6642.currentScreen != null) {
               this.field6642.currentScreen.method2459(var1, var8, var4, var5);
            }
         }

         this.method5849(var1, var2, var3, var4, var5);
      }
   }

   private ITextComponent method5847() {
      return !this.field6640.method5823() ? field6633 : this.method5848();
   }

   public ITextComponent method5848() {
      return field6632;
   }

   private void method5849(MatrixStack var1, int var2, int var3, int var4, int var5) {
      ItemStack var8 = null;

      for (int var9 = 0; var9 < this.field6637.method34736(); var9++) {
         Class8055 var10 = this.field6637.method34735(var9);
         int var11 = var10.method27660() + var2;
         int var12 = var10.method27661() + var3;
         if (var4 >= var11 && var5 >= var12 && var4 < var11 + 16 && var5 < var12 + 16) {
            var8 = var10.method27662();
         }
      }

      if (var8 != null && this.field6642.currentScreen != null) {
         this.field6642.currentScreen.method2460(var1, this.field6642.currentScreen.method2458(var8), var4, var5);
      }
   }

   public void method5850(MatrixStack var1, int var2, int var3, boolean var4, float var5) {
      this.field6637.method34739(var1, this.field6642, var2, var3, var4, var5);
   }

   @Override
   public boolean mouseClicked(double var1, double var3, int var5) {
      if (this.method5839() && !this.field6642.player.isSpectator()) {
         if (this.field6646.method11316(var1, var3, var5, (this.field6635 - 147) / 2 - this.field6634, (this.field6636 - 166) / 2, 147, 166)) {
            IRecipe var11 = this.field6646.method11313();
            RecipeList var12 = this.field6646.method11314();
            if (var11 != null && var12 != null) {
               if (!var12.method34889(var11) && this.field6637.method34737() == var11) {
                  return false;
               }

               this.field6637.method34733();
               this.field6642.playerController.sendPlaceRecipePacket(this.field6642.player.openContainer.windowId, var11, Screen.method2476());
               if (!this.method5855()) {
                  this.method5840(false);
               }
            }

            return true;
         } else if (this.field6643.mouseClicked(var1, var3, var5)) {
            return true;
         } else if (this.field6640.mouseClicked(var1, var3, var5)) {
            boolean var10 = this.method5851();
            this.field6640.method5822(var10);
            this.method5859();
            this.method5842(false);
            return true;
         } else {
            for (Class1250 var9 : this.field6638) {
               if (var9.mouseClicked(var1, var3, var5)) {
                  if (this.field6639 != var9) {
                     this.field6639.method5822(false);
                     this.field6639 = var9;
                     this.field6639.method5822(true);
                     this.method5842(true);
                  }

                  return true;
               }
            }

            return false;
         }
      } else {
         return false;
      }
   }

   private boolean method5851() {
      RecipeBookCategory var3 = this.field6641.method18227();
      boolean var4 = !this.field6645.method21371(var3);
      this.field6645.method21372(var3, var4);
      return var4;
   }

   public boolean method5852(double var1, double var3, int var5, int var6, int var7, int var8, int var9) {
      if (!this.method5839()) {
         return true;
      } else {
         boolean var12 = var1 < (double)var5 || var3 < (double)var6 || var1 >= (double)(var5 + var7) || var3 >= (double)(var6 + var8);
         boolean var13 = (double)(var5 - 147) < var1 && var1 < (double)var5 && (double)var6 < var3 && var3 < (double)(var6 + var8);
         return var12 && !var13 && !this.field6639.isHovered();
      }
   }

   @Override
   public boolean keyPressed(int var1, int var2, int var3) {
      this.field6649 = false;
      if (!this.method5839() || this.field6642.player.isSpectator()) {
         return false;
      } else if (var1 == 256 && !this.method5855()) {
         this.method5840(false);
         return true;
      } else if (this.field6643.keyPressed(var1, var2, var3)) {
         this.method5853();
         return true;
      } else if (this.field6643.method5746() && this.field6643.method5670() && var1 != 256) {
         return true;
      } else if (this.field6642.gameSettings.keyBindChat.matchesKey(var1, var2) && !this.field6643.method5746()) {
         this.field6649 = true;
         this.field6643.method5654(true);
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean keyReleased(int var1, int var2, int var3) {
      this.field6649 = false;
      return IGuiEventListener2.super.keyReleased(var1, var2, var3);
   }

   @Override
   public boolean charTyped(char var1, int var2) {
      if (!this.field6649) {
         if (!this.method5839() || this.field6642.player.isSpectator()) {
            return false;
         } else if (!this.field6643.charTyped(var1, var2)) {
            return IGuiEventListener2.super.charTyped(var1, var2);
         } else {
            this.method5853();
            return true;
         }
      } else {
         return false;
      }
   }

   @Override
   public boolean isMouseOver(double var1, double var3) {
      return false;
   }

   private void method5853() {
      String var3 = this.field6643.getText().toLowerCase(Locale.ROOT);
      this.method5854(var3);
      if (!var3.equals(this.field6644)) {
         this.method5842(false);
         this.field6644 = var3;
      }
   }

   private void method5854(String var1) {
      if ("excitedze".equals(var1)) {
         LanguageManager var4 = this.field6642.getLanguageManager();
         Class2019 var5 = var4.method967("en_pt");
         if (var4.getCurrentLanguage().compareTo(var5) == 0) {
            return;
         }

         var4.method964(var5);
         this.field6642.gameSettings.language = var5.getCode();
         this.field6642.reloadResources();
         this.field6642.gameSettings.saveOptions();
      }
   }

   private boolean method5855() {
      return this.field6634 == 86;
   }

   public void method5856() {
      this.method5843();
      if (this.method5839()) {
         this.method5842(false);
      }
   }

   @Override
   public void method5857(List<IRecipe<?>> var1) {
      for (IRecipe var5 : var1) {
         this.field6642.player.method5398(var5);
      }
   }

   public void method5858(IRecipe<?> var1, List<Slot> var2) {
      ItemStack var5 = var1.getRecipeOutput();
      this.field6637.method34738(var1);
      this.field6637.method34734(Ingredient.method340(var5), ((Slot)var2.get(0)).field25580, ((Slot)var2.get(0)).field25581);
      this.method5832(this.field6641.method18224(), this.field6641.method18225(), this.field6641.method18223(), var1, var1.method14969().iterator(), 0);
   }

   @Override
   public void method5830(Iterator<Ingredient> var1, int var2, int var3, int var4, int var5) {
      Ingredient var8 = (Ingredient)var1.next();
      if (!var8.method337()) {
         Slot var9 = this.field6641.inventorySlots.get(var2);
         this.field6637.method34734(var8, var9.field25580, var9.field25581);
      }
   }

   public void method5859() {
      if (this.field6642.getConnection() != null) {
         RecipeBookCategory var3 = this.field6641.method18227();
         boolean var4 = this.field6645.method21374().method34686(var3);
         boolean var5 = this.field6645.method21374().method34688(var3);
         this.field6642.getConnection().sendPacket(new CUpdateRecipeBookStatusPacket(var3, var4, var5));
      }
   }
}
