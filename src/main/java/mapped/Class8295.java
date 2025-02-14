package mapped;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.util.text.TranslationTextComponent;

public class Class8295 {
   public static void method28988(CommandDispatcher<CommandSource> var0) {
      var0.register(
         (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder) Commands.method18839("weather")
                     .requires(var0x -> var0x.method20129(2)))
                  .then(
                     ((LiteralArgumentBuilder) Commands.method18839("clear").executes(var0x -> method28989((CommandSource)var0x.getSource(), 6000)))
                        .then(
                           Commands.method18840("duration", IntegerArgumentType.integer(0, 1000000))
                              .executes(var0x -> method28989((CommandSource)var0x.getSource(), IntegerArgumentType.getInteger(var0x, "duration") * 20))
                        )
                  ))
               .then(
                  ((LiteralArgumentBuilder) Commands.method18839("rain").executes(var0x -> method28990((CommandSource)var0x.getSource(), 6000)))
                     .then(
                        Commands.method18840("duration", IntegerArgumentType.integer(0, 1000000))
                           .executes(var0x -> method28990((CommandSource)var0x.getSource(), IntegerArgumentType.getInteger(var0x, "duration") * 20))
                     )
               ))
            .then(
               ((LiteralArgumentBuilder) Commands.method18839("thunder").executes(var0x -> method28991((CommandSource)var0x.getSource(), 6000)))
                  .then(
                     Commands.method18840("duration", IntegerArgumentType.integer(0, 1000000))
                        .executes(var0x -> method28991((CommandSource)var0x.getSource(), IntegerArgumentType.getInteger(var0x, "duration") * 20))
                  )
            )
      );
   }

   private static int method28989(CommandSource var0, int var1) {
      var0.method20172().method6892(var1, 0, false, false);
      var0.sendFeedback(new TranslationTextComponent("commands.weather.set.clear"), true);
      return var1;
   }

   private static int method28990(CommandSource var0, int var1) {
      var0.method20172().method6892(0, var1, true, false);
      var0.sendFeedback(new TranslationTextComponent("commands.weather.set.rain"), true);
      return var1;
   }

   private static int method28991(CommandSource var0, int var1) {
      var0.method20172().method6892(0, var1, true, true);
      var0.sendFeedback(new TranslationTextComponent("commands.weather.set.thunder"), true);
      return var1;
   }
}
