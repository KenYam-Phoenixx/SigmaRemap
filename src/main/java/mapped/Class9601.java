package mapped;

import com.google.common.collect.Lists;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;

import net.minecraft.command.CommandSource;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.TranslationTextComponent;

public class Class9601 {
   private static final SimpleCommandExceptionType field44912 = new SimpleCommandExceptionType(
      new TranslationTextComponent("commands.scoreboard.objectives.add.duplicate")
   );
   private static final SimpleCommandExceptionType field44913 = new SimpleCommandExceptionType(
      new TranslationTextComponent("commands.scoreboard.objectives.display.alreadyEmpty")
   );
   private static final SimpleCommandExceptionType field44914 = new SimpleCommandExceptionType(
      new TranslationTextComponent("commands.scoreboard.objectives.display.alreadySet")
   );
   private static final SimpleCommandExceptionType field44915 = new SimpleCommandExceptionType(
      new TranslationTextComponent("commands.scoreboard.players.enable.failed")
   );
   private static final SimpleCommandExceptionType field44916 = new SimpleCommandExceptionType(
      new TranslationTextComponent("commands.scoreboard.players.enable.invalid")
   );
   private static final Dynamic2CommandExceptionType field44917 = new Dynamic2CommandExceptionType(
      (var0, var1) -> new TranslationTextComponent("commands.scoreboard.players.get.null", var0, var1)
   );

   public static void method37271(CommandDispatcher<CommandSource> var0) {
      var0.register(
         (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder) Commands.method18839("scoreboard").requires(var0x -> var0x.method20129(2)))
               .then(
                  ((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder) Commands.method18839("objectives")
                                 .then(Commands.method18839("list").executes(var0x -> method37290((CommandSource)var0x.getSource()))))
                              .then(
                                 Commands.method18839("add")
                                    .then(
                                       Commands.method18840("objective", StringArgumentType.word())
                                          .then(
                                             ((RequiredArgumentBuilder) Commands.method18840("criteria", Class8371.method29322())
                                                   .executes(
                                                      var0x -> method37289(
                                                            (CommandSource)var0x.getSource(),
                                                            StringArgumentType.getString(var0x, "objective"),
                                                            Class8371.method29323(var0x, "criteria"),
                                                            new StringTextComponent(StringArgumentType.getString(var0x, "objective"))
                                                         )
                                                   ))
                                                .then(
                                                   Commands.method18840("displayName", Class8010.method27395())
                                                      .executes(
                                                         var0x -> method37289(
                                                               (CommandSource)var0x.getSource(),
                                                               StringArgumentType.getString(var0x, "objective"),
                                                               Class8371.method29323(var0x, "criteria"),
                                                               Class8010.method27394(var0x, "displayName")
                                                            )
                                                      )
                                                )
                                          )
                                    )
                              ))
                           .then(
                              Commands.method18839("modify")
                                 .then(
                                    ((RequiredArgumentBuilder) Commands.method18840("objective", Class9263.method34860())
                                          .then(
                                             Commands.method18839("displayname")
                                                .then(
                                                   Commands.method18840("displayName", Class8010.method27395())
                                                      .executes(
                                                         var0x -> method37286(
                                                               (CommandSource)var0x.getSource(),
                                                               Class9263.method34861(var0x, "objective"),
                                                               Class8010.method27394(var0x, "displayName")
                                                            )
                                                      )
                                                )
                                          ))
                                       .then(method37272())
                                 )
                           ))
                        .then(
                           Commands.method18839("remove")
                              .then(
                                 Commands.method18840("objective", Class9263.method34860())
                                    .executes(var0x -> method37288((CommandSource)var0x.getSource(), Class9263.method34861(var0x, "objective")))
                              )
                        ))
                     .then(
                        Commands.method18839("setdisplay")
                           .then(
                              ((RequiredArgumentBuilder) Commands.method18840("slot", Class9639.method37566())
                                    .executes(var0x -> method37284((CommandSource)var0x.getSource(), Class9639.method37567(var0x, "slot"))))
                                 .then(
                                    Commands.method18840("objective", Class9263.method34860())
                                       .executes(
                                          var0x -> method37285(
                                                (CommandSource)var0x.getSource(), Class9639.method37567(var0x, "slot"), Class9263.method34861(var0x, "objective")
                                             )
                                       )
                                 )
                           )
                     )
               ))
            .then(
               ((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder) Commands.method18839(
                                          "players"
                                       )
                                       .then(
                                          ((LiteralArgumentBuilder) Commands.method18839("list").executes(var0x -> method37282((CommandSource)var0x.getSource())))
                                             .then(
                                                Commands.method18840("target", Class7591.method24862())
                                                   .suggests(Class7591.field32590)
                                                   .executes(var0x -> method37283((CommandSource)var0x.getSource(), Class7591.method24858(var0x, "target")))
                                             )
                                       ))
                                    .then(
                                       Commands.method18839("set")
                                          .then(
                                             Commands.method18840("targets", Class7591.method24863())
                                                .suggests(Class7591.field32590)
                                                .then(
                                                   Commands.method18840("objective", Class9263.method34860())
                                                      .then(
                                                         Commands.method18840("score", IntegerArgumentType.integer())
                                                            .executes(
                                                               var0x -> method37279(
                                                                     (CommandSource)var0x.getSource(),
                                                                     Class7591.method24860(var0x, "targets"),
                                                                     Class9263.method34862(var0x, "objective"),
                                                                     IntegerArgumentType.getInteger(var0x, "score")
                                                                  )
                                                            )
                                                      )
                                                )
                                          )
                                    ))
                                 .then(
                                    Commands.method18839("get")
                                       .then(
                                          Commands.method18840("target", Class7591.method24862())
                                             .suggests(Class7591.field32590)
                                             .then(
                                                Commands.method18840("objective", Class9263.method34860())
                                                   .executes(
                                                      var0x -> method37274(
                                                            (CommandSource)var0x.getSource(),
                                                            Class7591.method24858(var0x, "target"),
                                                            Class9263.method34861(var0x, "objective")
                                                         )
                                                   )
                                             )
                                       )
                                 ))
                              .then(
                                 Commands.method18839("add")
                                    .then(
                                       Commands.method18840("targets", Class7591.method24863())
                                          .suggests(Class7591.field32590)
                                          .then(
                                             Commands.method18840("objective", Class9263.method34860())
                                                .then(
                                                   Commands.method18840("score", IntegerArgumentType.integer(0))
                                                      .executes(
                                                         var0x -> method37280(
                                                               (CommandSource)var0x.getSource(),
                                                               Class7591.method24860(var0x, "targets"),
                                                               Class9263.method34862(var0x, "objective"),
                                                               IntegerArgumentType.getInteger(var0x, "score")
                                                            )
                                                      )
                                                )
                                          )
                                    )
                              ))
                           .then(
                              Commands.method18839("remove")
                                 .then(
                                    Commands.method18840("targets", Class7591.method24863())
                                       .suggests(Class7591.field32590)
                                       .then(
                                          Commands.method18840("objective", Class9263.method34860())
                                             .then(
                                                Commands.method18840("score", IntegerArgumentType.integer(0))
                                                   .executes(
                                                      var0x -> method37281(
                                                            (CommandSource)var0x.getSource(),
                                                            Class7591.method24860(var0x, "targets"),
                                                            Class9263.method34862(var0x, "objective"),
                                                            IntegerArgumentType.getInteger(var0x, "score")
                                                         )
                                                   )
                                             )
                                       )
                                 )
                           ))
                        .then(
                           Commands.method18839("reset")
                              .then(
                                 ((RequiredArgumentBuilder) Commands.method18840("targets", Class7591.method24863())
                                       .suggests(Class7591.field32590)
                                       .executes(var0x -> method37277((CommandSource)var0x.getSource(), Class7591.method24860(var0x, "targets"))))
                                    .then(
                                       Commands.method18840("objective", Class9263.method34860())
                                          .executes(
                                             var0x -> method37278(
                                                   (CommandSource)var0x.getSource(),
                                                   Class7591.method24860(var0x, "targets"),
                                                   Class9263.method34861(var0x, "objective")
                                                )
                                          )
                                    )
                              )
                        ))
                     .then(
                        Commands.method18839("enable")
                           .then(
                              Commands.method18840("targets", Class7591.method24863())
                                 .suggests(Class7591.field32590)
                                 .then(
                                    Commands.method18840("objective", Class9263.method34860())
                                       .suggests((var0x, var1) -> method37273((CommandSource)var0x.getSource(), Class7591.method24860(var0x, "targets"), var1))
                                       .executes(
                                          var0x -> method37276(
                                                (CommandSource)var0x.getSource(),
                                                Class7591.method24860(var0x, "targets"),
                                                Class9263.method34861(var0x, "objective")
                                             )
                                       )
                                 )
                           )
                     ))
                  .then(
                     Commands.method18839("operation")
                        .then(
                           Commands.method18840("targets", Class7591.method24863())
                              .suggests(Class7591.field32590)
                              .then(
                                 Commands.method18840("targetObjective", Class9263.method34860())
                                    .then(
                                       Commands.method18840("operation", Class6888.method21028())
                                          .then(
                                             Commands.method18840("source", Class7591.method24863())
                                                .suggests(Class7591.field32590)
                                                .then(
                                                   Commands.method18840("sourceObjective", Class9263.method34860())
                                                      .executes(
                                                         var0x -> method37275(
                                                               (CommandSource)var0x.getSource(),
                                                               Class7591.method24860(var0x, "targets"),
                                                               Class9263.method34862(var0x, "targetObjective"),
                                                               Class6888.method21029(var0x, "operation"),
                                                               Class7591.method24860(var0x, "source"),
                                                               Class9263.method34861(var0x, "sourceObjective")
                                                            )
                                                      )
                                                )
                                          )
                                    )
                              )
                        )
                  )
            )
      );
   }

   private static LiteralArgumentBuilder<CommandSource> method37272() {
      LiteralArgumentBuilder var2 = Commands.method18839("rendertype");

      for (Class2316 var6 : Class2316.values()) {
         var2.then(
            Commands.method18839(var6.method9088()).executes(var1 -> method37287((CommandSource)var1.getSource(), Class9263.method34861(var1, "objective"), var6))
         );
      }

      return var2;
   }

   private static CompletableFuture<Suggestions> method37273(CommandSource var0, Collection<String> var1, SuggestionsBuilder var2) {
      ArrayList var5 = Lists.newArrayList();
      ServerScoreboard var6 = var0.getServer().method1409();

      for (ScoreObjective var8 : var6.method20982()) {
         if (var8.getCriteria() == Class9008.field41190) {
            boolean var9 = false;

            for (String var11 : var1) {
               if (!var6.method20979(var11, var8) || var6.method20980(var11, var8).isLocked()) {
                  var9 = true;
                  break;
               }
            }

            if (var9) {
               var5.add(var8.method29336());
            }
         }
      }

      return ISuggestionProvider.suggest(var5, var2);
   }

   private static int method37274(CommandSource var0, String var1, ScoreObjective var2) throws CommandSyntaxException {
      ServerScoreboard var5 = var0.getServer().method1409();
      if (var5.method20979(var1, var2)) {
         Score var6 = var5.method20980(var1, var2);
         var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.players.get.success", var1, var6.getScorePoints(), var2.method29340()), false);
         return var6.getScorePoints();
      } else {
         throw field44917.create(var2.method29336(), var1);
      }
   }

   private static int method37275(CommandSource var0, Collection<String> var1, ScoreObjective var2, Class8420 var3, Collection<String> var4, ScoreObjective var5) throws CommandSyntaxException {
      ServerScoreboard var8 = var0.getServer().method1409();
      int var9 = 0;

      for (String var11 : var1) {
         Score var12 = var8.method20980(var11, var2);

         for (String var14 : var4) {
            Score var15 = var8.method20980(var14, var5);
            var3.method29592(var12, var15);
         }

         var9 += var12.getScorePoints();
      }

      if (var1.size() != 1) {
         var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.players.operation.success.multiple", var2.method29340(), var1.size()), true);
      } else {
         var0.sendFeedback(
            new TranslationTextComponent("commands.scoreboard.players.operation.success.single", var2.method29340(), var1.iterator().next(), var9), true
         );
      }

      return var9;
   }

   private static int method37276(CommandSource var0, Collection<String> var1, ScoreObjective var2) throws CommandSyntaxException {
      if (var2.getCriteria() == Class9008.field41190) {
         ServerScoreboard var5 = var0.getServer().method1409();
         int var6 = 0;

         for (String var8 : var1) {
            Score var9 = var5.method20980(var8, var2);
            if (var9.isLocked()) {
               var9.setLocked(false);
               var6++;
            }
         }

         if (var6 != 0) {
            if (var1.size() != 1) {
               var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.players.enable.success.multiple", var2.method29340(), var1.size()), true);
            } else {
               var0.sendFeedback(
                  new TranslationTextComponent("commands.scoreboard.players.enable.success.single", var2.method29340(), var1.iterator().next()), true
               );
            }

            return var6;
         } else {
            throw field44915.create();
         }
      } else {
         throw field44916.create();
      }
   }

   private static int method37277(CommandSource var0, Collection<String> var1) {
      ServerScoreboard var4 = var0.getServer().method1409();

      for (String var6 : var1) {
         var4.method20985(var6, (ScoreObjective)null);
      }

      if (var1.size() != 1) {
         var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.players.reset.all.multiple", var1.size()), true);
      } else {
         var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.players.reset.all.single", var1.iterator().next()), true);
      }

      return var1.size();
   }

   private static int method37278(CommandSource var0, Collection<String> var1, ScoreObjective var2) {
      ServerScoreboard var5 = var0.getServer().method1409();

      for (String var7 : var1) {
         var5.method20985(var7, var2);
      }

      if (var1.size() != 1) {
         var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.players.reset.specific.multiple", var2.method29340(), var1.size()), true);
      } else {
         var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.players.reset.specific.single", var2.method29340(), var1.iterator().next()), true);
      }

      return var1.size();
   }

   private static int method37279(CommandSource var0, Collection<String> var1, ScoreObjective var2, int var3) {
      ServerScoreboard var6 = var0.getServer().method1409();

      for (String var8 : var1) {
         Score var9 = var6.method20980(var8, var2);
         var9.setScorePoints(var3);
      }

      if (var1.size() != 1) {
         var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.players.set.success.multiple", var2.method29340(), var1.size(), var3), true);
      } else {
         var0.sendFeedback(
            new TranslationTextComponent("commands.scoreboard.players.set.success.single", var2.method29340(), var1.iterator().next(), var3), true
         );
      }

      return var3 * var1.size();
   }

   private static int method37280(CommandSource var0, Collection<String> var1, ScoreObjective var2, int var3) {
      ServerScoreboard var6 = var0.getServer().method1409();
      int var7 = 0;

      for (String var9 : var1) {
         Score var10 = var6.method20980(var9, var2);
         var10.setScorePoints(var10.getScorePoints() + var3);
         var7 += var10.getScorePoints();
      }

      if (var1.size() != 1) {
         var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.players.add.success.multiple", var3, var2.method29340(), var1.size()), true);
      } else {
         var0.sendFeedback(
            new TranslationTextComponent("commands.scoreboard.players.add.success.single", var3, var2.method29340(), var1.iterator().next(), var7), true
         );
      }

      return var7;
   }

   private static int method37281(CommandSource var0, Collection<String> var1, ScoreObjective var2, int var3) {
      ServerScoreboard var6 = var0.getServer().method1409();
      int var7 = 0;

      for (String var9 : var1) {
         Score var10 = var6.method20980(var9, var2);
         var10.setScorePoints(var10.getScorePoints() - var3);
         var7 += var10.getScorePoints();
      }

      if (var1.size() != 1) {
         var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.players.remove.success.multiple", var3, var2.method29340(), var1.size()), true);
      } else {
         var0.sendFeedback(
            new TranslationTextComponent("commands.scoreboard.players.remove.success.single", var3, var2.method29340(), var1.iterator().next(), var7), true
         );
      }

      return var7;
   }

   private static int method37282(CommandSource var0) {
      Collection var3 = var0.getServer().method1409().method20984();
      if (!var3.isEmpty()) {
         var0.sendFeedback(
            new TranslationTextComponent("commands.scoreboard.players.list.success", var3.size(), TextComponentUtils.makeGreenSortedList(var3)), false
         );
      } else {
         var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.players.list.empty"), false);
      }

      return var3.size();
   }

   private static int method37283(CommandSource var0, String var1) {
      Map<ScoreObjective, Score> var4 = var0.getServer().method1409().method20986(var1);
      if (!var4.isEmpty()) {
         var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.players.list.entity.success", var1, var4.size()), false);

         for (Entry var6 : var4.entrySet()) {
            var0.sendFeedback(
               new TranslationTextComponent(
                  "commands.scoreboard.players.list.entity.entry", ((ScoreObjective)var6.getKey()).method29340(), ((Score)var6.getValue()).getScorePoints()
               ),
               false
            );
         }
      } else {
         var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.players.list.entity.empty", var1), false);
      }

      return var4.size();
   }

   private static int method37284(CommandSource var0, int var1) throws CommandSyntaxException {
      ServerScoreboard var4 = var0.getServer().method1409();
      if (var4.getObjectiveInDisplaySlot(var1) != null) {
         var4.method20988(var1, (ScoreObjective)null);
         var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.objectives.display.cleared", Scoreboard.method21010()[var1]), true);
         return 0;
      } else {
         throw field44913.create();
      }
   }

   private static int method37285(CommandSource var0, int var1, ScoreObjective var2) throws CommandSyntaxException {
      ServerScoreboard var5 = var0.getServer().method1409();
      if (var5.getObjectiveInDisplaySlot(var1) != var2) {
         var5.method20988(var1, var2);
         var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.objectives.display.set", Scoreboard.method21010()[var1], var2.method29338()), true);
         return 0;
      } else {
         throw field44914.create();
      }
   }

   private static int method37286(CommandSource var0, ScoreObjective var1, ITextComponent var2) {
      if (!var1.method29338().equals(var2)) {
         var1.method29341(var2);
         var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.objectives.modify.displayname", var1.method29336(), var1.method29340()), true);
      }

      return 0;
   }

   private static int method37287(CommandSource var0, ScoreObjective var1, Class2316 var2) {
      if (var1.method29342() != var2) {
         var1.method29343(var2);
         var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.objectives.modify.rendertype", var1.method29340()), true);
      }

      return 0;
   }

   private static int method37288(CommandSource var0, ScoreObjective var1) {
      ServerScoreboard var4 = var0.getServer().method1409();
      var4.method20987(var1);
      var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.objectives.remove.success", var1.method29340()), true);
      return var4.method20982().size();
   }

   private static int method37289(CommandSource var0, String var1, Class9008 var2, ITextComponent var3) throws CommandSyntaxException {
      ServerScoreboard var6 = var0.getServer().method1409();
      if (var6.method20976(var1) == null) {
         if (var1.length() <= 16) {
            var6.method20977(var1, var2, var3, var2.method33282());
            ScoreObjective var7 = var6.method20976(var1);
            var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.objectives.add.success", var7.method29340()), true);
            return var6.method20982().size();
         } else {
            throw Class9263.field42601.create(16);
         }
      } else {
         throw field44912.create();
      }
   }

   private static int method37290(CommandSource var0) {
      Collection var3 = var0.getServer().method1409().method20982();
      if (!var3.isEmpty()) {
         var0.sendFeedback(
            new TranslationTextComponent(
               "commands.scoreboard.objectives.list.success", var3.size(), TextComponentUtils.func_240649_b_(var3, ScoreObjective::method29340)
            ),
            false
         );
      } else {
         var0.sendFeedback(new TranslationTextComponent("commands.scoreboard.objectives.list.empty"), false);
      }

      return var3.size();
   }
}
