package com.mentalfrostbyte.jello.command.impl;

import com.mentalfrostbyte.jello.command.Command;
import com.mentalfrostbyte.jello.command.CommandException;

import com.mentalfrostbyte.jello.command.CommandManager;
import com.mentalfrostbyte.jello.command.ChatCommandExecutor;
import mapped.*;
import net.minecraft.block.ContainerBlock;
import net.minecraft.client.gui.screen.inventory.ShulkerBoxScreen;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.NonNullList;

public class Peek extends Command {
   public Peek() {
      super("peek", "Preview a shulker content without opening it", "shulker");
   }

   @Override
   public void run(String var1, ChatCommandArguments[] var2, ChatCommandExecutor var3) throws CommandException {
      if (var2.length == 0) {
         ItemStack var6 = mc.player.inventory.method4028();
         if (var6.getItem() instanceof BlockItem && ((BlockItem)var6.getItem()).method11845() instanceof ContainerBlock) {
            method18337(var6);
            var3.send("Now peeking shulker");
         } else {
            throw new CommandException("You must hold the shulker you want to peek into first");
         }
      } else {
         throw new CommandException();
      }
   }

   public static void method18337(ItemStack var0) {
      CompoundNBT var3 = new CompoundNBT();
      if (var0.getTag() != null) {
         var3 = var0.getTag().copy();
      }

      NonNullList<ItemStack> var4 = NonNullList.method68(27, new ItemStack(Items.AIR));
      if (var3 != null && var3.contains("BlockEntityTag")) {
         CompoundNBT var5 = var3.getCompound("BlockEntityTag");
         method18338(var5);
         if (var5.contains("Items")) {
            ItemStackHelper.loadAllItems(var5, var4);
         }
      }

      Class927 var6 = new Class927(var4.toArray(new ItemStack[0]));
      CommandManager.method30238(
         () -> mc.displayGuiScreen(new ShulkerBoxScreen(new Class5814(-1, mc.player.inventory, var6), mc.player.inventory, var0.method32149()))
      );
   }

   public static void method18338(CompoundNBT var0) {
      if (var0.contains("Items")) {
         ListNBT var3 = var0.getList("Items", 10);

         for (int var4 = 0; var4 < var3.size(); var4++) {
            CompoundNBT var5 = var3.getCompound(var4);
            CompoundNBT var6 = var5.getCompound("tag");
            if (var6.contains("ench")) {
               ListNBT var7 = var6.getList("ench", 10);
               ListNBT var8 = new ListNBT();

               for (int var9 = 0; var9 < var7.size(); var9++) {
                  CompoundNBT var10 = var7.getCompound(var9);
                  short var11 = var10.getShort("lvl");
                  String var13 = "";
                  CompoundNBT var14 = new CompoundNBT();
                  var14.putShort("lvl", var11);
                  var14.putString("id", var13);
                  var8.add(var14);
               }

               var6.put("Enchantments", var8);
            }
         }
      }
   }
}
