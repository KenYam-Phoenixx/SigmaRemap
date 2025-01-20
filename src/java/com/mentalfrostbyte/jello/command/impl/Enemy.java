package com.mentalfrostbyte.jello.command.impl;

import com.mentalfrostbyte.jello.command.ChatCommandExecutor;
import com.mentalfrostbyte.jello.command.Command;
import com.mentalfrostbyte.jello.command.CommandException;

import com.mentalfrostbyte.Client;
import com.mentalfrostbyte.jello.command.CommandType;
import mapped.ChatCommandArguments;

import java.util.List;
import java.util.regex.Pattern;

public class Enemy extends Command {
   public Enemy() {
      super("enemy", "Manage enemies", "enemies", "target");
      this.registerSubCommands(new String[]{"add/remove/list/clear"});
   }

   @Override
   public void run(String var1, ChatCommandArguments[] var2, ChatCommandExecutor var3) throws CommandException {
      if (var2.length == 0) {
         throw new CommandException();
      } else if (var2[0].getCommandType() == CommandType.TEXT) {
         String var6 = var2[0].getArguments();
         String var7 = var6.toLowerCase();
         switch (var7) {
            case "add":
               if (var2.length != 2) {
                  var3.send("Usage : .enemy add <name>");
               } else {
                  Pattern var14 = Pattern.compile("[a-zA-Z0-9_]{2,16}");
                  boolean var15 = var14.matcher(var2[1].getArguments()).matches();
                  if (var15) {
                     boolean var16 = Client.getInstance().getFriendManager().method27002(var2[1].getArguments());
                     if (!var16) {
                        var3.send("\"" + var2[1].getArguments() + "\" is already your enemy.");
                     } else {
                        var3.send("\"" + var2[1].getArguments() + "\" is now your enemy.");
                     }
                  } else {
                     var3.send("Invalid name \"" + var2[1].getArguments() + "\"");
                  }
               }
               break;
            case "remove":
               if (var2.length != 2) {
                  var3.send("Usage : .enemy remove <name>");
               } else {
                  boolean var13 = Client.getInstance().getFriendManager().method27006(var2[1].getArguments());
                  if (!var13) {
                     var3.send("\"" + var2[1].getArguments() + "\" is not your enemy.");
                  } else {
                     var3.send("\"" + var2[1].getArguments() + "\" is no longer your enemy.");
                  }
               }
               break;
            case "list":
               List<String> var9 = Client.getInstance().getFriendManager().method27004();
               if (var9.isEmpty()) {
                  var3.send("You have no enemies");
               } else {
                  var3.send("Enemies : (" + var9.size() + ")");
                  String var10 = "";

                  for (String var12 : var9) {
                     if (var12.equals(var9.get(var9.size() - 1))) {
                        var10 = var10.concat(var12 + ".");
                     } else {
                        var10 = var10.concat(var12 + ", ");
                     }
                  }

                  var3.send(var10);
               }
               break;
            case "clear":
               if (Client.getInstance().getFriendManager().method27008()) {
                  var3.send("Cleared all your enemies.");
               } else {
                  var3.send("You have no enemies.");
               }
               break;
            default:
               throw new CommandException();
         }
      } else {
         throw new CommandException();
      }
   }
}
