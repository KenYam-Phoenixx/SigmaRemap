package mapped;

import com.mentalfrostbyte.jello.command.Command;
import com.mentalfrostbyte.jello.command.CommandException;

import java.util.Map.Entry;

import com.mentalfrostbyte.jello.Client;
import com.mentalfrostbyte.jello.command.CommandManager;
import com.mentalfrostbyte.jello.module.Module;
import net.minecraft.util.text.StringTextComponent;

public class Bind extends Command {
   public Bind() {
      super("bind", "Bind a module to a key");
      this.registerSubCommands(new String[]{"module"});
      this.registerSubCommands(new String[]{"key/none"});
   }

   @Override
   public void run(String var1, Class8623[] var2, Class6669 var3) throws CommandException {
      Object var6 = null;
      if (var2.length == 0) {
         CommandManager.method30238(() -> mc.displayGuiScreen(new Class1144(new StringTextComponent("GuiKeybinds"))));
      }

      if (var2.length < 1) {
         throw new CommandException();
      } else {
         if (var2.length != 1) {
            if (var2.length != 2) {
               if (var2.length > 2) {
                  throw new CommandException("Too many arguments");
               }
            } else {
               var6 = this.method18330(var2[0].method30899());
               if (var6 == null || var2[0].method30895() != Class2193.field14335) {
                  throw new CommandException("Module " + var2[0].method30899() + " not found");
               }

               int var14 = this.method18329(var2[1].method30899().toLowerCase());
               if (var14 == -2) {
                  throw new CommandException("Key " + var2[1].method30899() + " not found");
               }

               if (var14 != -1) {
                  Client.getInstance().getModuleManager().method14668().method13725(var14, (Module)var6);
                  var3.method20327("Key " + var2[1].method30899() + " was set for module " + ((Module)var6).getSuffix());
               } else {
                  Client.getInstance().getModuleManager().method14668().method13727(var6);
                  var3.method20327("Keybind was reset for module " + ((Module)var6).getSuffix());
               }
            }
         } else {
            var6 = this.method18330(var2[0].method30899());
            if (var6 == null || var2[0].method30895() != Class2193.field14335) {
               throw new CommandException("Module " + var2[0].method30899() + " not found");
            }

            String var7 = "key.keyboard.";
            int var8 = Client.getInstance().getModuleManager().method14668().method13729((Module)var6);
            String var9 = null;

            for (Entry var11 : Class8115.field34877.entrySet()) {
               if (((String)var11.getKey()).startsWith(var7) && ((Class8115)var11.getValue()).field34875 == var8) {
                  var9 = ((String)var11.getKey()).substring(var7.length());
               }
            }

            if (var9 != null) {
               var3.method20327(((Module)var6).getSuffix() + " is bound to : " + var9);
            } else {
               var3.method20327("§c[Error] " + ((Module)var6).getSuffix() + " is bound to an unknown key");
            }
         }
      }
   }

   public int method18329(String var1) {
      if (!var1.equals("none") && !var1.equals("none")) {
         String var4 = "key.keyboard.";

         for (Entry var6 : Class8115.field34877.entrySet()) {
            if (((String)var6.getKey()).startsWith(var4)) {
               String var7 = ((String)var6.getKey()).substring(var4.length());
               var7 = var7.replace("keypad.", "");
               var7 = var7.replace(".", "_");
               if (var1.equals(var7)) {
                  return ((Class8115)var6.getValue()).field34875;
               }
            }
         }

         return -2;
      } else {
         return -1;
      }
   }

   public Module method18330(String var1) {
      for (Module var5 : Client.getInstance().getModuleManager().getModuleMap().values()) {
         if (var5.getName().replace(" ", "").equalsIgnoreCase(var1)) {
            return var5;
         }
      }

      return null;
   }
}
