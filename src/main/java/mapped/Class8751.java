package mapped;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.command.arguments.BlockPosArgument;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;

public class Class8751 {
   public static void method31569(CommandDispatcher<CommandSource> var0) {
      var0.register(
         (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder) Commands.method18839("setworldspawn")
                  .requires(var0x -> var0x.method20129(2)))
               .executes(var0x -> method31570((CommandSource)var0x.getSource(), new BlockPos(((CommandSource)var0x.getSource()).method20171()), 0.0F)))
            .then(
               ((RequiredArgumentBuilder) Commands.method18840("pos", BlockPosArgument.method20826())
                     .executes(var0x -> method31570((CommandSource)var0x.getSource(), BlockPosArgument.method20828(var0x, "pos"), 0.0F)))
                  .then(
                     Commands.method18840("angle", Class9076.method33816())
                        .executes(
                           var0x -> method31570((CommandSource)var0x.getSource(), BlockPosArgument.method20828(var0x, "pos"), Class9076.method33817(var0x, "angle"))
                        )
                  )
            )
      );
   }

   private static int method31570(CommandSource var0, BlockPos var1, float var2) {
      var0.method20172().method6946(var1, var2);
      var0.sendFeedback(new TranslationTextComponent("commands.setworldspawn.success", var1.getX(), var1.getY(), var1.getZ(), var2), true);
      return 1;
   }
}
