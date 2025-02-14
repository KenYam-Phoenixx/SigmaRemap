package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class Class1255 extends Class1254 {
   private Iterator<Item> field6650;
   private Set<Item> field6651;
   private Slot field6652;
   private Item field6653;
   private float field6654;

   @Override
   public void method5835() {
      this.field6640.method5821(152, 182, 28, 18, field6630);
   }

   @Override
   public void method5841(Slot var1) {
      super.method5841(var1);
      if (var1 != null && var1.slotNumber < this.field6641.method18226()) {
         this.field6652 = null;
      }
   }

   @Override
   public void method5858(IRecipe<?> var1, List<Slot> var2) {
      ItemStack var5 = var1.getRecipeOutput();
      this.field6637.method34738(var1);
      this.field6637.method34734(Ingredient.method340(var5), ((Slot)var2.get(2)).field25580, ((Slot)var2.get(2)).field25581);
      NonNullList var6 = var1.method14969();
      this.field6652 = (Slot)var2.get(1);
      if (this.field6651 == null) {
         this.field6651 = this.method5866();
      }

      this.field6650 = this.field6651.iterator();
      this.field6653 = null;
      Iterator var7 = var6.iterator();

      for (int var8 = 0; var8 < 2; var8++) {
         if (!var7.hasNext()) {
            return;
         }

         Ingredient var9 = (Ingredient)var7.next();
         if (!var9.method337()) {
            Slot var10 = (Slot)var2.get(var8);
            this.field6637.method34734(var9, var10.field25580, var10.field25581);
         }
      }
   }

   public abstract Set<Item> method5866();

   @Override
   public void method5850(MatrixStack var1, int var2, int var3, boolean var4, float var5) {
      super.method5850(var1, var2, var3, var4, var5);
      if (this.field6652 != null) {
         if (!Screen.hasControlDown()) {
            this.field6654 += var5;
         }

         int var8 = this.field6652.field25580 + var2;
         int var9 = this.field6652.field25581 + var3;
         AbstractGui.fill(var1, var8, var9, var8 + 16, var9 + 16, 822018048);
         this.field6642.getItemRenderer().method795(this.field6642.player, this.method5867().method11742(), var8, var9);
         RenderSystem.depthFunc(516);
         AbstractGui.fill(var1, var8, var9, var8 + 16, var9 + 16, 822083583);
         RenderSystem.depthFunc(515);
      }
   }

   private Item method5867() {
      if (this.field6653 == null || this.field6654 > 30.0F) {
         this.field6654 = 0.0F;
         if (this.field6650 == null || !this.field6650.hasNext()) {
            if (this.field6651 == null) {
               this.field6651 = this.method5866();
            }

            this.field6650 = this.field6651.iterator();
         }

         this.field6653 = this.field6650.next();
      }

      return this.field6653;
   }
}
