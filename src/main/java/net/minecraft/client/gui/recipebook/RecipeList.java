package net.minecraft.client.gui.recipebook;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import it.unimi.dsi.fastutil.ints.IntList;
import mapped.Class6207;
import mapped.Class6941;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RecipeList {
   private static String[] field42624;
   private final List<IRecipe<?>> field42625;
   private final boolean field42626;
   private final Set<IRecipe<?>> field42627 = Sets.newHashSet();
   private final Set<IRecipe<?>> field42628 = Sets.newHashSet();
   private final Set<IRecipe<?>> field42629 = Sets.newHashSet();

   public RecipeList(List<IRecipe<?>> var1) {
      this.field42625 = ImmutableList.copyOf(var1);
      if (var1.size() > 1) {
         this.field42626 = method34885(var1);
      } else {
         this.field42626 = true;
      }
   }

   private static boolean method34885(List<IRecipe<?>> var0) {
      int var3 = var0.size();
      ItemStack var4 = ((IRecipe)var0.get(0)).getRecipeOutput();

      for (int var5 = 1; var5 < var3; var5++) {
         ItemStack var6 = ((IRecipe)var0.get(var5)).getRecipeOutput();
         if (!ItemStack.areItemStacksEqual(var4, var6) || !ItemStack.method32127(var4, var6)) {
            return false;
         }
      }

      return true;
   }

   public boolean method34886() {
      return !this.field42629.isEmpty();
   }

   public void method34887(Class6941 var1) {
      for (IRecipe var5 : this.field42625) {
         if (var1.method21360(var5)) {
            this.field42629.add(var5);
         }
      }
   }

   public void method34888(Class6207 var1, int var2, int var3, Class6941 var4) {
      for (IRecipe var8 : this.field42625) {
         boolean var9 = var8.method14960(var2, var3) && var4.method21360(var8);
         if (!var9) {
            this.field42628.remove(var8);
         } else {
            this.field42628.add(var8);
         }

         if (var9 && var1.method19123(var8, (IntList)null)) {
            this.field42627.add(var8);
         } else {
            this.field42627.remove(var8);
         }
      }
   }

   public boolean method34889(IRecipe<?> var1) {
      return this.field42627.contains(var1);
   }

   public boolean method34890() {
      return !this.field42627.isEmpty();
   }

   public boolean method34891() {
      return !this.field42628.isEmpty();
   }

   public List<IRecipe<?>> getRecipes() {
      return this.field42625;
   }

   public List<IRecipe<?>> method34893(boolean var1) {
      ArrayList var4 = Lists.newArrayList();
      Set var5 = !var1 ? this.field42628 : this.field42627;

      for (IRecipe var7 : this.field42625) {
         if (var5.contains(var7)) {
            var4.add(var7);
         }
      }

      return var4;
   }

   public List<IRecipe<?>> method34894(boolean var1) {
      ArrayList var4 = Lists.newArrayList();

      for (IRecipe var6 : this.field42625) {
         if (this.field42628.contains(var6) && this.field42627.contains(var6) == var1) {
            var4.add(var6);
         }
      }

      return var4;
   }

   public boolean method34895() {
      return this.field42626;
   }
}
