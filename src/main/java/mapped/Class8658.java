package mapped;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.util.Collection;

import net.minecraft.command.CommandSource;
import net.minecraft.util.text.TranslationTextComponent;

public class Class8658 {
   public static void method31159(CommandDispatcher<CommandSource> var0) {
      var0.register(
         (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder) Commands.method18839("banlist")
                     .requires(var0x -> var0x.method20129(3)))
                  .executes(
                     var0x -> {
                        Class6395 var3 = ((CommandSource)var0x.getSource()).getServer().getPlayerList();
                        return method31160(
                           (CommandSource)var0x.getSource(),
                           Lists.newArrayList(Iterables.concat(var3.method19461().method14443(), var3.method19462().method14443()))
                        );
                     }
                  ))
               .then(
                  Commands.method18839("ips")
                     .executes(
                        var0x -> method31160(
                              (CommandSource)var0x.getSource(), ((CommandSource)var0x.getSource()).getServer().getPlayerList().method19462().method14443()
                           )
                     )
               ))
            .then(
               Commands.method18839("players")
                  .executes(
                     var0x -> method31160((CommandSource)var0x.getSource(), ((CommandSource)var0x.getSource()).getServer().getPlayerList().method19461().method14443())
                  )
            )
      );
   }

   private static int method31160(CommandSource var0, Collection<? extends Class6787<?>> var1) {
      if (!var1.isEmpty()) {
         var0.sendFeedback(new TranslationTextComponent("commands.banlist.list", var1.size()), false);

         for (Class6787 var5 : var1) {
            var0.sendFeedback(new TranslationTextComponent("commands.banlist.entry", var5.method20679(), var5.method20681(), var5.method20683()), false);
         }
      } else {
         var0.sendFeedback(new TranslationTextComponent("commands.banlist.none"), false);
      }

      return var1.size();
   }
}
