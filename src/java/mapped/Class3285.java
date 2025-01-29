package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.StringUtils;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class Class3285 extends Item {
   public Class3285(Properties var1) {
      super(var1);
   }

   public static boolean method11817(CompoundNBT var0) {
      if (Class3291.method11833(var0)) {
         if (var0.contains("title", 8)) {
            String var3 = var0.getString("title");
            return var3.length() <= 32 ? var0.contains("author", 8) : false;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public static int method11818(ItemStack var0) {
      return var0.getTag().getInt("generation");
   }

   public static int method11819(ItemStack var0) {
      CompoundNBT var3 = var0.getTag();
      return var3 == null ? 0 : var3.getList("pages", 8).size();
   }

   @Override
   public ITextComponent method11731(ItemStack var1) {
      if (var1.method32141()) {
         CompoundNBT var4 = var1.getTag();
         String var5 = var4.getString("title");
         if (!StringUtils.isNullOrEmpty(var5)) {
            return new StringTextComponent(var5);
         }
      }

      return super.method11731(var1);
   }

   @Override
   public void method11730(ItemStack var1, World var2, List<ITextComponent> var3, Class2216 var4) {
      if (var1.method32141()) {
         CompoundNBT var7 = var1.getTag();
         String var8 = var7.getString("author");
         if (!StringUtils.isNullOrEmpty(var8)) {
            var3.add(new TranslationTextComponent("book.byAuthor", var8).mergeStyle(TextFormatting.GRAY));
         }

         var3.add(new TranslationTextComponent("book.generation." + var7.getInt("generation")).mergeStyle(TextFormatting.GRAY));
      }
   }

   @Override
   public ActionResultType onItemUse(ItemUseContext var1) {
      World var4 = var1.getWorld();
      BlockPos var5 = var1.getPos();
      BlockState var6 = var4.getBlockState(var5);
      if (!var6.isIn(Blocks.LECTERN)) {
         return ActionResultType.field14820;
      } else {
         return !Class3354.method11919(var4, var5, var6, var1.method18357()) ? ActionResultType.field14820 : ActionResultType.method9002(var4.isRemote);
      }
   }

   @Override
   public ActionResult<ItemStack> method11700(World var1, PlayerEntity var2, Hand var3) {
      ItemStack var6 = var2.getHeldItem(var3);
      var2.method2769(var6, var3);
      var2.addStat(Stats.field40098.method172(this));
      return ActionResult.<ItemStack>method20700(var6, var1.isRemote());
   }

   public static boolean method11820(ItemStack var0, CommandSource var1, PlayerEntity var2) {
      CompoundNBT var5 = var0.getTag();
      if (var5 != null && !var5.getBoolean("resolved")) {
         var5.putBoolean("resolved", true);
         if (!method11817(var5)) {
            return false;
         } else {
            ListNBT var6 = var5.getList("pages", 8);

            for (int var7 = 0; var7 < var6.size(); var7++) {
               String var8 = var6.getString(var7);

               Object var9;
               try {
                  var9 = ITextComponent.Serializer.getComponentFromJsonLenient(var8);
                  var9 = TextComponentUtils.func_240645_a_(var1, (ITextComponent)var9, var2, 0);
               } catch (Exception var11) {
                  var9 = new StringTextComponent(var8);
               }

               var6.set(var7, (INBT) StringNBT.valueOf(ITextComponent.Serializer.toJson((ITextComponent)var9)));
            }

            var5.put("pages", var6);
            return true;
         }
      } else {
         return false;
      }
   }

   @Override
   public boolean method11732(ItemStack var1) {
      return true;
   }
}
