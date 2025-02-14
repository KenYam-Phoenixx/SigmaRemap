package mapped;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.GameType;

public class Class4533 {
   private static final SimpleCommandExceptionType field21847 = new SimpleCommandExceptionType(new TranslationTextComponent("commands.spectate.self"));
   private static final DynamicCommandExceptionType field21848 = new DynamicCommandExceptionType(
      var0 -> new TranslationTextComponent("commands.spectate.not_spectator", var0)
   );

   public static void method14453(CommandDispatcher<CommandSource> var0) {
      var0.register(
         (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder) Commands.method18839("spectate").requires(var0x -> var0x.method20129(2)))
               .executes(var0x -> method14454((CommandSource)var0x.getSource(), (Entity)null, ((CommandSource)var0x.getSource()).method20175())))
            .then(
               ((RequiredArgumentBuilder) Commands.method18840("target", Class8700.method31345())
                     .executes(
                        var0x -> method14454((CommandSource)var0x.getSource(), Class8700.method31346(var0x, "target"), ((CommandSource)var0x.getSource()).method20175())
                     ))
                  .then(
                     Commands.method18840("player", Class8700.method31351())
                        .executes(
                           var0x -> method14454((CommandSource)var0x.getSource(), Class8700.method31346(var0x, "target"), Class8700.method31352(var0x, "player"))
                        )
                  )
            )
      );
   }

   private static int method14454(CommandSource var0, Entity var1, ServerPlayerEntity var2) throws CommandSyntaxException {
      if (var2 != var1) {
         if (var2.interactionManager.getGameType() == GameType.SPECTATOR) {
            var2.method2815(var1);
            if (var1 == null) {
               var0.sendFeedback(new TranslationTextComponent("commands.spectate.success.stopped"), false);
            } else {
               var0.sendFeedback(new TranslationTextComponent("commands.spectate.success.started", var1.getDisplayName()), false);
            }

            return 1;
         } else {
            throw field21848.create(var2.getDisplayName());
         }
      } else {
         throw field21847.create();
      }
   }
}
