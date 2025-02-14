package mapped;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.util.Collection;
import java.util.Collections;

import net.minecraft.command.CommandSource;
import net.minecraft.command.arguments.BlockPosArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;

public class Class9160 {
   public static void method34194(CommandDispatcher<CommandSource> var0) {
      var0.register(
         (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder) Commands.method18839("spawnpoint").requires(var0x -> var0x.method20129(2)))
               .executes(
                  var0x -> method34195(
                        (CommandSource)var0x.getSource(),
                        Collections.<ServerPlayerEntity>singleton(((CommandSource)var0x.getSource()).method20175()),
                        new BlockPos(((CommandSource)var0x.getSource()).method20171()),
                        0.0F
                     )
               ))
            .then(
               ((RequiredArgumentBuilder) Commands.method18840("targets", Class8700.method31353())
                     .executes(
                        var0x -> method34195(
                              (CommandSource)var0x.getSource(),
                              Class8700.method31354(var0x, "targets"),
                              new BlockPos(((CommandSource)var0x.getSource()).method20171()),
                              0.0F
                           )
                     ))
                  .then(
                     ((RequiredArgumentBuilder) Commands.method18840("pos", BlockPosArgument.method20826())
                           .executes(
                              var0x -> method34195(
                                    (CommandSource)var0x.getSource(), Class8700.method31354(var0x, "targets"), BlockPosArgument.method20828(var0x, "pos"), 0.0F
                                 )
                           ))
                        .then(
                           Commands.method18840("angle", Class9076.method33816())
                              .executes(
                                 var0x -> method34195(
                                       (CommandSource)var0x.getSource(),
                                       Class8700.method31354(var0x, "targets"),
                                       BlockPosArgument.method20828(var0x, "pos"),
                                       Class9076.method33817(var0x, "angle")
                                    )
                              )
                        )
                  )
            )
      );
   }

   private static int method34195(CommandSource var0, Collection<ServerPlayerEntity> var1, BlockPos var2, float var3) {
      RegistryKey var6 = var0.method20172().getDimensionKey();

      for (ServerPlayerEntity var8 : var1) {
         var8.method2829(var6, var2, var3, true, false);
      }

      String var9 = var6.getLocation().toString();
      if (var1.size() != 1) {
         var0.sendFeedback(
            new TranslationTextComponent(
               "commands.spawnpoint.success.multiple", var2.getX(), var2.getY(), var2.getZ(), var3, var9, var1.size()
            ),
            true
         );
      } else {
         var0.sendFeedback(
            new TranslationTextComponent(
               "commands.spawnpoint.success.single",
               var2.getX(),
               var2.getY(),
               var2.getZ(),
               var3,
               var9,
               ((ServerPlayerEntity)var1.iterator().next()).getDisplayName()
            ),
            true
         );
      }

      return var1.size();
   }
}
