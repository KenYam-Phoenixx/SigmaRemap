package mapped;

import com.google.common.collect.Lists;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ResultConsumer;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.IntFunction;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.command.CommandSource;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.command.arguments.BlockPosArgument;
import net.minecraft.command.arguments.ResourceLocationArgument;
import net.minecraft.command.arguments.Vec3Argument;
import net.minecraft.command.impl.BossBarCommand;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.*;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.server.CustomServerBossInfo;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.server.ServerWorld;

public class Class6137 {
   private static final Dynamic2CommandExceptionType field27531 = new Dynamic2CommandExceptionType(
      (var0, var1) -> new TranslationTextComponent("commands.execute.blocks.toobig", var0, var1)
   );
   private static final SimpleCommandExceptionType field27532 = new SimpleCommandExceptionType(
      new TranslationTextComponent("commands.execute.conditional.fail")
   );
   private static final DynamicCommandExceptionType field27533 = new DynamicCommandExceptionType(
      var0 -> new TranslationTextComponent("commands.execute.conditional.fail_count", var0)
   );
   private static final BinaryOperator<ResultConsumer<CommandSource>> field27534 = (var0, var1) -> (var2, var3, var4) -> {
         var0.onCommandComplete(var2, var3, var4);
         var1.onCommandComplete(var2, var3, var4);
      };
   private static final SuggestionProvider<CommandSource> field27535 = (var0, var1) -> {
      Class283 var4 = ((CommandSource)var0.getSource()).getServer().method1412();
      return ISuggestionProvider.suggestIterable(var4.method1053(), var1);
   };

   public static void method18958(CommandDispatcher<CommandSource> var0) {
      LiteralCommandNode var3 = var0.register((LiteralArgumentBuilder) Commands.method18839("execute").requires(var0x -> var0x.method20129(2)));
      var0.register(
         (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder) Commands.method18839(
                                                   "execute"
                                                )
                                                .requires(var0x -> var0x.method20129(2)))
                                             .then(Commands.method18839("run").redirect(var0.getRoot())))
                                          .then(method18963(var3, Commands.method18839("if"), true)))
                                       .then(method18963(var3, Commands.method18839("unless"), false)))
                                    .then(Commands.method18839("as").then(Commands.method18840("targets", Class8700.method31347()).fork(var3, var0x -> {
                                       ArrayList var3x = Lists.newArrayList();

                                       for (Entity var5 : Class8700.method31349(var0x, "targets")) {
                                          var3x.add(((CommandSource)var0x.getSource()).method20157(var5));
                                       }

                                       return var3x;
                                    }))))
                                 .then(
                                    Commands.method18839("at")
                                       .then(
                                          Commands.method18840("targets", Class8700.method31347())
                                             .fork(
                                                var3,
                                                var0x -> {
                                                   ArrayList var3x = Lists.newArrayList();

                                                   for (Entity var5 : Class8700.method31349(var0x, "targets")) {
                                                      var3x.add(
                                                         ((CommandSource)var0x.getSource())
                                                            .method20166((ServerWorld)var5.world)
                                                            .method20158(var5.getPositionVec())
                                                            .method20159(var5.getPitchYaw())
                                                      );
                                                   }

                                                   return var3x;
                                                }
                                             )
                                       )
                                 ))
                              .then(
                                 ((LiteralArgumentBuilder) Commands.method18839("store").then(method18959(var3, Commands.method18839("result"), true)))
                                    .then(method18959(var3, Commands.method18839("success"), false))
                              ))
                           .then(
                              ((LiteralArgumentBuilder) Commands.method18839("positioned")
                                    .then(
                                       Commands.method18840("pos", Vec3Argument.method20857())
                                          .redirect(
                                             var3,
                                             var0x -> ((CommandSource)var0x.getSource())
                                                   .method20158(Vec3Argument.method20859(var0x, "pos"))
                                                   .method20165(Class2062.field13441)
                                          )
                                    ))
                                 .then(Commands.method18839("as").then(Commands.method18840("targets", Class8700.method31347()).fork(var3, var0x -> {
                                    ArrayList var3x = Lists.newArrayList();

                                    for (Entity var5 : Class8700.method31349(var0x, "targets")) {
                                       var3x.add(((CommandSource)var0x.getSource()).method20158(var5.getPositionVec()));
                                    }

                                    return var3x;
                                 })))
                           ))
                        .then(
                           ((LiteralArgumentBuilder) Commands.method18839("rotated")
                                 .then(
                                    Commands.method18840("rot", Class7918.method26558())
                                       .redirect(
                                          var3,
                                          var0x -> ((CommandSource)var0x.getSource())
                                                .method20159(Class7918.method26559(var0x, "rot").getRotation((CommandSource)var0x.getSource()))
                                       )
                                 ))
                              .then(Commands.method18839("as").then(Commands.method18840("targets", Class8700.method31347()).fork(var3, var0x -> {
                                 ArrayList var3x = Lists.newArrayList();

                                 for (Entity var5 : Class8700.method31349(var0x, "targets")) {
                                    var3x.add(((CommandSource)var0x.getSource()).method20159(var5.getPitchYaw()));
                                 }

                                 return var3x;
                              })))
                        ))
                     .then(
                        ((LiteralArgumentBuilder) Commands.method18839("facing")
                              .then(
                                 Commands.method18839("entity")
                                    .then(
                                       Commands.method18840("targets", Class8700.method31347())
                                          .then(Commands.method18840("anchor", Class9188.method34388()).fork(var3, var0x -> {
                                             ArrayList var3x = Lists.newArrayList();
                                             Class2062 var4 = Class9188.method34387(var0x, "anchor");

                                             for (Entity var6 : Class8700.method31349(var0x, "targets")) {
                                                var3x.add(((CommandSource)var0x.getSource()).method20167(var6, var4));
                                             }

                                             return var3x;
                                          }))
                                    )
                              ))
                           .then(
                              Commands.method18840("pos", Vec3Argument.method20857())
                                 .redirect(var3, var0x -> ((CommandSource)var0x.getSource()).method20168(Vec3Argument.method20859(var0x, "pos")))
                           )
                     ))
                  .then(
                     Commands.method18839("align")
                        .then(
                           Commands.method18840("axes", Class9560.method37040())
                              .redirect(
                                 var3,
                                 var0x -> ((CommandSource)var0x.getSource())
                                       .method20158(((CommandSource)var0x.getSource()).method20171().method11355(Class9560.method37041(var0x, "axes")))
                              )
                        )
                  ))
               .then(
                  Commands.method18839("anchored")
                     .then(
                        Commands.method18840("anchor", Class9188.method34388())
                           .redirect(var3, var0x -> ((CommandSource)var0x.getSource()).method20165(Class9188.method34387(var0x, "anchor")))
                     )
               ))
            .then(
               Commands.method18839("in")
                  .then(
                     Commands.method18840("dimension", Class9082.method33872())
                        .redirect(var3, var0x -> ((CommandSource)var0x.getSource()).method20166(Class9082.method33873(var0x, "dimension")))
                  )
            )
      );
   }

   private static ArgumentBuilder<CommandSource, ?> method18959(LiteralCommandNode<CommandSource> var0, LiteralArgumentBuilder<CommandSource> var1, boolean var2) {
      var1.then(
         Commands.method18839("score")
            .then(
               Commands.method18840("targets", Class7591.method24863())
                  .suggests(Class7591.field32590)
                  .then(
                     Commands.method18840("objective", Class9263.method34860())
                        .redirect(
                           var0,
                           var1x -> method18960(
                                 (CommandSource)var1x.getSource(), Class7591.method24860(var1x, "targets"), Class9263.method34861(var1x, "objective"), var2
                              )
                        )
                  )
            )
      );
      var1.then(
         Commands.method18839("bossbar")
            .then(
               ((RequiredArgumentBuilder) Commands.method18840("id", ResourceLocationArgument.method29031())
                     .suggests(BossBarCommand.SUGGESTIONS_PROVIDER)
                     .then(
                        Commands.method18839("value")
                           .redirect(var0, var1x -> method18961((CommandSource)var1x.getSource(), BossBarCommand.getBossbar(var1x), true, var2))
                     ))
                  .then(
                     Commands.method18839("max").redirect(var0, var1x -> method18961((CommandSource)var1x.getSource(), BossBarCommand.getBossbar(var1x), false, var2))
                  )
            )
      );

      for (Class8196 var6 : Class8158.field35113) {
         var6.method28504(
            var1,
            var3 -> var3.then(
                  ((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder) Commands.method18840(
                                       "path", Class8320.method29128()
                                    )
                                    .then(
                                       Commands.method18839("int")
                                          .then(
                                             Commands.method18840("scale", DoubleArgumentType.doubleArg())
                                                .redirect(
                                                   var0,
                                                   var2xx -> method18962(
                                                         (CommandSource)var2xx.getSource(),
                                                         var6.method28503(var2xx),
                                                         Class8320.method29129(var2xx, "path"),
                                                         var1xxx -> IntNBT.valueOf((int)((double)var1xxx * DoubleArgumentType.getDouble(var2xx, "scale"))),
                                                         var2
                                                      )
                                                )
                                          )
                                    ))
                                 .then(
                                    Commands.method18839("float")
                                       .then(
                                          Commands.method18840("scale", DoubleArgumentType.doubleArg())
                                             .redirect(
                                                var0,
                                                var2xx -> method18962(
                                                      (CommandSource)var2xx.getSource(),
                                                      var6.method28503(var2xx),
                                                      Class8320.method29129(var2xx, "path"),
                                                      var1xxx -> FloatNBT.valueOf((float)((double)var1xxx * DoubleArgumentType.getDouble(var2xx, "scale"))),
                                                      var2
                                                   )
                                             )
                                       )
                                 ))
                              .then(
                                 Commands.method18839("short")
                                    .then(
                                       Commands.method18840("scale", DoubleArgumentType.doubleArg())
                                          .redirect(
                                             var0,
                                             var2xx -> method18962(
                                                   (CommandSource)var2xx.getSource(),
                                                   var6.method28503(var2xx),
                                                   Class8320.method29129(var2xx, "path"),
                                                   var1xxx -> ShortNBT.valueOf((short)((int)((double)var1xxx * DoubleArgumentType.getDouble(var2xx, "scale")))),
                                                   var2
                                                )
                                          )
                                    )
                              ))
                           .then(
                              Commands.method18839("long")
                                 .then(
                                    Commands.method18840("scale", DoubleArgumentType.doubleArg())
                                       .redirect(
                                          var0,
                                          var2xx -> method18962(
                                                (CommandSource)var2xx.getSource(),
                                                var6.method28503(var2xx),
                                                Class8320.method29129(var2xx, "path"),
                                                var1xxx -> LongNBT.valueOf((long)((double)var1xxx * DoubleArgumentType.getDouble(var2xx, "scale"))),
                                                var2
                                             )
                                       )
                                 )
                           ))
                        .then(
                           Commands.method18839("double")
                              .then(
                                 Commands.method18840("scale", DoubleArgumentType.doubleArg())
                                    .redirect(
                                       var0,
                                       var2xx -> method18962(
                                             (CommandSource)var2xx.getSource(),
                                             var6.method28503(var2xx),
                                             Class8320.method29129(var2xx, "path"),
                                             var1xxx -> DoubleNBT.valueOf((double)var1xxx * DoubleArgumentType.getDouble(var2xx, "scale")),
                                             var2
                                          )
                                    )
                              )
                        ))
                     .then(
                        Commands.method18839("byte")
                           .then(
                              Commands.method18840("scale", DoubleArgumentType.doubleArg())
                                 .redirect(
                                    var0,
                                    var2xx -> method18962(
                                          (CommandSource)var2xx.getSource(),
                                          var6.method28503(var2xx),
                                          Class8320.method29129(var2xx, "path"),
                                          var1xxx -> ByteNBT.valueOf((byte)((int)((double)var1xxx * DoubleArgumentType.getDouble(var2xx, "scale")))),
                                          var2
                                       )
                                 )
                           )
                     )
               )
         );
      }

      return var1;
   }

   private static CommandSource method18960(CommandSource var0, Collection<String> var1, ScoreObjective var2, boolean var3) {
      ServerScoreboard var6 = var0.getServer().method1409();
      return var0.method20161((var4, var5, var6x) -> {
         for (String var10 : var1) {
            Score var11 = var6.method20980(var10, var2);
            int var12 = !var3 ? (!var5 ? 0 : 1) : var6x;
            var11.setScorePoints(var12);
         }
      }, field27534);
   }

   private static CommandSource method18961(CommandSource var0, CustomServerBossInfo var1, boolean var2, boolean var3) {
      return var0.method20161((var3x, var4, var5) -> {
         int var8 = !var3 ? (!var4 ? 0 : 1) : var5;
         if (!var2) {
            var1.setMax(var8);
         } else {
            var1.setValue(var8);
         }
      }, field27534);
   }

   private static CommandSource method18962(CommandSource var0, Class7151 var1, Class9670 var2, IntFunction<INBT> var3, boolean var4) {
      return var0.method20161((var4x, var5, var6) -> {
         try {
            CompoundNBT var9 = var1.method22312();
            int var10 = var4 ? var6 : (var5 ? 1 : 0);
            var2.method37730(var9, () -> (INBT)var3.apply(var10));
            var1.method22311(var9);
         } catch (CommandSyntaxException var11) {
         }
      }, field27534);
   }

   private static ArgumentBuilder<CommandSource, ?> method18963(CommandNode<CommandSource> var0, LiteralArgumentBuilder<CommandSource> var1, boolean var2) {
      ((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)var1.then(
                     Commands.method18839("block")
                        .then(
                           Commands.method18840("pos", BlockPosArgument.method20826())
                              .then(
                                 method18970(
                                    var0,
                                    Commands.method18840("block", Class7505.method24464()),
                                    var2,
                                    var0x -> Class7505.method24465(var0x, "block")
                                          .test(new CachedBlockInfo(((CommandSource)var0x.getSource()).method20172(), BlockPosArgument.method20827(var0x, "pos"), true))
                                 )
                              )
                        )
                  ))
                  .then(
                     Commands.method18839("score")
                        .then(
                           Commands.method18840("target", Class7591.method24862())
                              .suggests(Class7591.field32590)
                              .then(
                                 ((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder) Commands.method18840(
                                                      "targetObjective", Class9263.method34860()
                                                   )
                                                   .then(
                                                      Commands.method18839("=")
                                                         .then(
                                                            Commands.method18840("source", Class7591.method24862())
                                                               .suggests(Class7591.field32590)
                                                               .then(
                                                                  method18970(
                                                                     var0,
                                                                     Commands.method18840("sourceObjective", Class9263.method34860()),
                                                                     var2,
                                                                     var0x -> method18966(var0x, Integer::equals)
                                                                  )
                                                               )
                                                         )
                                                   ))
                                                .then(
                                                   Commands.method18839("<")
                                                      .then(
                                                         Commands.method18840("source", Class7591.method24862())
                                                            .suggests(Class7591.field32590)
                                                            .then(
                                                               method18970(
                                                                  var0,
                                                                  Commands.method18840("sourceObjective", Class9263.method34860()),
                                                                  var2,
                                                                  var0x -> method18966(var0x, (var0xx, var1x) -> var0xx < var1x)
                                                               )
                                                            )
                                                      )
                                                ))
                                             .then(
                                                Commands.method18839("<=")
                                                   .then(
                                                      Commands.method18840("source", Class7591.method24862())
                                                         .suggests(Class7591.field32590)
                                                         .then(
                                                            method18970(
                                                               var0,
                                                               Commands.method18840("sourceObjective", Class9263.method34860()),
                                                               var2,
                                                               var0x -> method18966(var0x, (var0xx, var1x) -> var0xx <= var1x)
                                                            )
                                                         )
                                                   )
                                             ))
                                          .then(
                                             Commands.method18839(">")
                                                .then(
                                                   Commands.method18840("source", Class7591.method24862())
                                                      .suggests(Class7591.field32590)
                                                      .then(
                                                         method18970(
                                                            var0,
                                                            Commands.method18840("sourceObjective", Class9263.method34860()),
                                                            var2,
                                                            var0x -> method18966(var0x, (var0xx, var1x) -> var0xx > var1x)
                                                         )
                                                      )
                                                )
                                          ))
                                       .then(
                                          Commands.method18839(">=")
                                             .then(
                                                Commands.method18840("source", Class7591.method24862())
                                                   .suggests(Class7591.field32590)
                                                   .then(
                                                      method18970(
                                                         var0,
                                                         Commands.method18840("sourceObjective", Class9263.method34860()),
                                                         var2,
                                                         var0x -> method18966(var0x, (var0xx, var1x) -> var0xx >= var1x)
                                                      )
                                                   )
                                             )
                                       ))
                                    .then(
                                       Commands.method18839("matches")
                                          .then(
                                             method18970(
                                                var0,
                                                Commands.method18840("range", Class8591.method30736()),
                                                var2,
                                                var0x -> method18967(var0x, Class8592.method30738(var0x, "range"))
                                             )
                                          )
                                    )
                              )
                        )
                  ))
               .then(
                  Commands.method18839("blocks")
                     .then(
                        Commands.method18840("start", BlockPosArgument.method20826())
                           .then(
                              Commands.method18840("end", BlockPosArgument.method20826())
                                 .then(
                                    ((RequiredArgumentBuilder) Commands.method18840("destination", BlockPosArgument.method20826())
                                          .then(method18971(var0, Commands.method18839("all"), var2, false)))
                                       .then(method18971(var0, Commands.method18839("masked"), var2, true))
                                 )
                           )
                     )
               ))
            .then(
               Commands.method18839("entity")
                  .then(
                     ((RequiredArgumentBuilder) Commands.method18840("entities", Class8700.method31347())
                           .fork(var0, var1x -> method18969(var1x, var2, !Class8700.method31349(var1x, "entities").isEmpty())))
                        .executes(method18964(var2, var0x -> Class8700.method31349(var0x, "entities").size()))
                  )
            ))
         .then(
            Commands.method18839("predicate")
               .then(
                  method18970(
                     var0,
                     Commands.method18840("predicate", ResourceLocationArgument.method29031()).suggests(field27535),
                     var2,
                     var0x -> method18968((CommandSource)var0x.getSource(), ResourceLocationArgument.method29034(var0x, "predicate"))
                  )
               )
         );

      for (Class8196 var6 : Class8158.field35114) {
         var1.then(
            var6.method28504(
               Commands.method18839("data"),
               var3 -> var3.then(
                     ((RequiredArgumentBuilder) Commands.method18840("path", Class8320.method29128())
                           .fork(var0, var2xx -> method18969(var2xx, var2, method18965(var6.method28503(var2xx), Class8320.method29129(var2xx, "path")) > 0)))
                        .executes(method18964(var2, var1xx -> method18965(var6.method28503(var1xx), Class8320.method29129(var1xx, "path"))))
                  )
            )
         );
      }

      return var1;
   }

   private static Command<CommandSource> method18964(boolean var0, Class9575 var1) {
      return !var0 ? var1x -> {
         int var4 = var1.method37178(var1x);
         if (var4 != 0) {
            throw field27533.create(var4);
         } else {
            ((CommandSource)var1x.getSource()).sendFeedback(new TranslationTextComponent("commands.execute.conditional.pass"), false);
            return 1;
         }
      } : var1x -> {
         int var4 = var1.method37178(var1x);
         if (var4 <= 0) {
            throw field27532.create();
         } else {
            ((CommandSource)var1x.getSource()).sendFeedback(new TranslationTextComponent("commands.execute.conditional.pass_count", var4), false);
            return var4;
         }
      };
   }

   private static int method18965(Class7151 var0, Class9670 var1) throws CommandSyntaxException {
      return var1.method37726(var0.method22312());
   }

   private static boolean method18966(CommandContext<CommandSource> var0, BiPredicate<Integer, Integer> var1) throws CommandSyntaxException {
      String var4 = Class7591.method24858(var0, "target");
      ScoreObjective var5 = Class9263.method34861(var0, "targetObjective");
      String var6 = Class7591.method24858(var0, "source");
      ScoreObjective var7 = Class9263.method34861(var0, "sourceObjective");
      ServerScoreboard var8 = ((CommandSource)var0.getSource()).getServer().method1409();
      if (var8.method20979(var4, var5) && var8.method20979(var6, var7)) {
         Score var9 = var8.method20980(var4, var5);
         Score var10 = var8.method20980(var6, var7);
         return var1.test(var9.getScorePoints(), var10.getScorePoints());
      } else {
         return false;
      }
   }

   private static boolean method18967(CommandContext<CommandSource> var0, Class8840 var1) throws CommandSyntaxException {
      String var4 = Class7591.method24858(var0, "target");
      ScoreObjective var5 = Class9263.method34861(var0, "targetObjective");
      ServerScoreboard var6 = ((CommandSource)var0.getSource()).getServer().method1409();
      return var6.method20979(var4, var5) ? var1.method32015(var6.method20980(var4, var5).getScorePoints()) : false;
   }

   private static boolean method18968(CommandSource var0, ILootCondition var1) {
      ServerWorld var4 = var0.method20172();
      Class9464 var5 = new Class9464(var4).method36454(Class9525.field44335, var0.method20171()).method36455(Class9525.field44330, var0.method20173());
      return var1.test(var5.method36460(Class8524.field38283));
   }

   private static Collection<CommandSource> method18969(CommandContext<CommandSource> var0, boolean var1, boolean var2) {
      return (Collection<CommandSource>)(var2 != var1 ? Collections.<CommandSource>emptyList() : Collections.<CommandSource>singleton((CommandSource)var0.getSource()));
   }

   private static ArgumentBuilder<CommandSource, ?> method18970(CommandNode<CommandSource> var0, ArgumentBuilder<CommandSource, ?> var1, boolean var2, Class6600 var3) {
      return var1.fork(var0, var2x -> method18969(var2x, var2, var3.method20000(var2x))).executes(var2x -> {
         if (var2 != var3.method20000(var2x)) {
            throw field27532.create();
         } else {
            ((CommandSource)var2x.getSource()).sendFeedback(new TranslationTextComponent("commands.execute.conditional.pass"), false);
            return 1;
         }
      });
   }

   private static ArgumentBuilder<CommandSource, ?> method18971(CommandNode<CommandSource> var0, ArgumentBuilder<CommandSource, ?> var1, boolean var2, boolean var3) {
      return var1.fork(var0, var2x -> method18969(var2x, var2, method18974(var2x, var3).isPresent()))
         .executes(!var2 ? var1x -> method18973(var1x, var3) : var1x -> method18972(var1x, var3));
   }

   private static int method18972(CommandContext<CommandSource> var0, boolean var1) throws CommandSyntaxException {
      OptionalInt var4 = method18974(var0, var1);
      if (!var4.isPresent()) {
         throw field27532.create();
      } else {
         ((CommandSource)var0.getSource()).sendFeedback(new TranslationTextComponent("commands.execute.conditional.pass_count", var4.getAsInt()), false);
         return var4.getAsInt();
      }
   }

   private static int method18973(CommandContext<CommandSource> var0, boolean var1) throws CommandSyntaxException {
      OptionalInt var4 = method18974(var0, var1);
      if (!var4.isPresent()) {
         ((CommandSource)var0.getSource()).sendFeedback(new TranslationTextComponent("commands.execute.conditional.pass"), false);
         return 1;
      } else {
         throw field27533.create(var4.getAsInt());
      }
   }

   private static OptionalInt method18974(CommandContext<CommandSource> var0, boolean var1) throws CommandSyntaxException {
      return method18975(
         ((CommandSource)var0.getSource()).method20172(),
         BlockPosArgument.method20827(var0, "start"),
         BlockPosArgument.method20827(var0, "end"),
         BlockPosArgument.method20827(var0, "destination"),
         var1
      );
   }

   private static OptionalInt method18975(ServerWorld var0, BlockPos var1, BlockPos var2, BlockPos var3, boolean var4) throws CommandSyntaxException {
      MutableBoundingBox var7 = new MutableBoundingBox(var1, var2);
      MutableBoundingBox var8 = new MutableBoundingBox(var3, var3.method8337(var7.method38397()));
      BlockPos var9 = new BlockPos(var8.minX - var7.minX, var8.minY - var7.minY, var8.minZ - var7.minZ);
      int var10 = var7.method38398() * var7.method38399() * var7.method38400();
      if (var10 > 32768) {
         throw field27531.create(32768, var10);
      } else {
         int var11 = 0;

         for (int var12 = var7.minZ; var12 <= var7.maxZ; var12++) {
            for (int var13 = var7.minY; var13 <= var7.maxY; var13++) {
               for (int var14 = var7.minX; var14 <= var7.maxX; var14++) {
                  BlockPos var15 = new BlockPos(var14, var13, var12);
                  BlockPos var16 = var15.method8337(var9);
                  BlockState var17 = var0.getBlockState(var15);
                  if (!var4 || !var17.isIn(Blocks.AIR)) {
                     if (var17 != var0.getBlockState(var16)) {
                        return OptionalInt.empty();
                     }

                     TileEntity var18 = var0.getTileEntity(var15);
                     TileEntity var19 = var0.getTileEntity(var16);
                     if (var18 != null) {
                        if (var19 == null) {
                           return OptionalInt.empty();
                        }

                        CompoundNBT var20 = var18.write(new CompoundNBT());
                        var20.remove("x");
                        var20.remove("y");
                        var20.remove("z");
                        CompoundNBT var21 = var19.write(new CompoundNBT());
                        var21.remove("x");
                        var21.remove("y");
                        var21.remove("z");
                        if (!var20.equals(var21)) {
                           return OptionalInt.empty();
                        }
                     }

                     var11++;
                  }
               }
            }
         }

         return OptionalInt.of(var11);
      }
   }
}
