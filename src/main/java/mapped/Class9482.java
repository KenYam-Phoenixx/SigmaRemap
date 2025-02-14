package mapped;

import com.google.common.collect.Lists;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.minecraft.command.CommandSource;
import net.minecraft.resources.ResourcePackList;
import net.minecraft.util.text.TranslationTextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Class9482 {
   private static final Logger field44075 = LogManager.getLogger();

   public static void method36605(Collection<String> var0, CommandSource var1) {
      var1.getServer().func_240780_a_(var0).exceptionally(var1x -> {
         field44075.warn("Failed to execute reload", var1x);
         var1.method20181(new TranslationTextComponent("commands.reload.failure"));
         return null;
      });
   }

   private static Collection<String> method36606(ResourcePackList var0, IServerConfiguration var1, Collection<String> var2) {
      var0.reloadPacksFromFinders();
      ArrayList var5 = Lists.newArrayList(var2);
      List var6 = var1.method20091().method26105();

      for (String var8 : var0.method1267()) {
         if (!var6.contains(var8) && !var5.contains(var8)) {
            var5.add(var8);
         }
      }

      return var5;
   }

   public static void method36607(CommandDispatcher<CommandSource> var0) {
      var0.register(
         (LiteralArgumentBuilder)((LiteralArgumentBuilder) Commands.method18839("reload").requires(var0x -> var0x.method20129(2))).executes(var0x -> {
            CommandSource var3 = (CommandSource)var0x.getSource();
            MinecraftServer var4 = var3.getServer();
            ResourcePackList var5 = var4.method1402();
            IServerConfiguration var6 = var4.func_240793_aU_();
            Collection var7 = var5.func_232621_d_();
            Collection var8 = method36606(var5, var6, var7);
            var3.sendFeedback(new TranslationTextComponent("commands.reload.success"), true);
            method36605(var8, var3);
            return 0;
         })
      );
   }
}
