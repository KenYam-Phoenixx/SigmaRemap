package mapped;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import java.util.Collection;

import net.minecraft.command.CommandSource;
import net.minecraft.command.arguments.ResourceLocationArgument;
import net.minecraft.command.arguments.Vec3Argument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.play.server.SPlaySoundPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;

public class Class8621 {
   private static final SimpleCommandExceptionType field38754 = new SimpleCommandExceptionType(new TranslationTextComponent("commands.playsound.failed"));

   public static void method30876(CommandDispatcher<CommandSource> var0) {
      RequiredArgumentBuilder var3 = Commands.method18840("sound", ResourceLocationArgument.method29031()).suggests(Class9222.field42455);

      for (SoundCategory var7 : SoundCategory.values()) {
         var3.then(method30877(var7));
      }

      var0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder) Commands.method18839("playsound").requires(var0x -> var0x.method20129(2))).then(var3));
   }

   private static LiteralArgumentBuilder<CommandSource> method30877(SoundCategory var0) {
      return (LiteralArgumentBuilder<CommandSource>) Commands.method18839(var0.method8995())
         .then(
            ((RequiredArgumentBuilder) Commands.method18840("targets", Class8700.method31353())
                  .executes(
                     var1 -> method30878(
                           (CommandSource)var1.getSource(),
                           Class8700.method31354(var1, "targets"),
                           ResourceLocationArgument.getResourceLocation(var1, "sound"),
                           var0,
                           ((CommandSource)var1.getSource()).method20171(),
                           1.0F,
                           1.0F,
                           0.0F
                        )
                  ))
               .then(
                  ((RequiredArgumentBuilder) Commands.method18840("pos", Vec3Argument.method20857())
                        .executes(
                           var1 -> method30878(
                                 (CommandSource)var1.getSource(),
                                 Class8700.method31354(var1, "targets"),
                                 ResourceLocationArgument.getResourceLocation(var1, "sound"),
                                 var0,
                                 Vec3Argument.method20859(var1, "pos"),
                                 1.0F,
                                 1.0F,
                                 0.0F
                              )
                        ))
                     .then(
                        ((RequiredArgumentBuilder) Commands.method18840("volume", FloatArgumentType.floatArg(0.0F))
                              .executes(
                                 var1 -> method30878(
                                       (CommandSource)var1.getSource(),
                                       Class8700.method31354(var1, "targets"),
                                       ResourceLocationArgument.getResourceLocation(var1, "sound"),
                                       var0,
                                       Vec3Argument.method20859(var1, "pos"),
                                       (Float)var1.getArgument("volume", Float.class),
                                       1.0F,
                                       0.0F
                                    )
                              ))
                           .then(
                              ((RequiredArgumentBuilder) Commands.method18840("pitch", FloatArgumentType.floatArg(0.0F, 2.0F))
                                    .executes(
                                       var1 -> method30878(
                                             (CommandSource)var1.getSource(),
                                             Class8700.method31354(var1, "targets"),
                                             ResourceLocationArgument.getResourceLocation(var1, "sound"),
                                             var0,
                                             Vec3Argument.method20859(var1, "pos"),
                                             (Float)var1.getArgument("volume", Float.class),
                                             (Float)var1.getArgument("pitch", Float.class),
                                             0.0F
                                          )
                                    ))
                                 .then(
                                    Commands.method18840("minVolume", FloatArgumentType.floatArg(0.0F, 1.0F))
                                       .executes(
                                          var1 -> method30878(
                                                (CommandSource)var1.getSource(),
                                                Class8700.method31354(var1, "targets"),
                                                ResourceLocationArgument.getResourceLocation(var1, "sound"),
                                                var0,
                                                Vec3Argument.method20859(var1, "pos"),
                                                (Float)var1.getArgument("volume", Float.class),
                                                (Float)var1.getArgument("pitch", Float.class),
                                                (Float)var1.getArgument("minVolume", Float.class)
                                             )
                                       )
                                 )
                           )
                     )
               )
         );
   }

   private static int method30878(CommandSource var0, Collection<ServerPlayerEntity> var1, ResourceLocation var2, SoundCategory var3, Vector3d var4, float var5, float var6, float var7) throws CommandSyntaxException {
      double var10 = Math.pow(!(var5 > 1.0F) ? 16.0 : (double)(var5 * 16.0F), 2.0);
      int var12 = 0;

      for (ServerPlayerEntity var14 : var1) {
         double var15 = var4.x - var14.getPosX();
         double var17 = var4.y - var14.getPosY();
         double var19 = var4.z - var14.getPosZ();
         double var21 = var15 * var15 + var17 * var17 + var19 * var19;
         Vector3d var23 = var4;
         float var24 = var5;
         if (var21 > var10) {
            if (var7 <= 0.0F) {
               continue;
            }

            double var25 = (double) MathHelper.sqrt(var21);
            var23 = new Vector3d(var14.getPosX() + var15 / var25 * 2.0, var14.getPosY() + var17 / var25 * 2.0, var14.getPosZ() + var19 / var25 * 2.0);
            var24 = var7;
         }

         var14.connection.sendPacket(new SPlaySoundPacket(var2, var3, var23, var24, var6));
         var12++;
      }

      if (var12 != 0) {
         if (var1.size() != 1) {
            var0.sendFeedback(new TranslationTextComponent("commands.playsound.success.multiple", var2, var1.size()), true);
         } else {
            var0.sendFeedback(new TranslationTextComponent("commands.playsound.success.single", var2, ((ServerPlayerEntity)var1.iterator().next()).getDisplayName()), true);
         }

         return var12;
      } else {
         throw field38754.create();
      }
   }
}
