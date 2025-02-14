package mapped;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType;
import com.mojang.brigadier.exceptions.Dynamic3CommandExceptionType;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import java.util.UUID;

import net.minecraft.command.CommandSource;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.command.arguments.ResourceLocationArgument;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;

public class Class6987 {
   private static final SuggestionProvider<CommandSource> field30228 = (var0, var1) -> ISuggestionProvider.suggestIterable(Registry.ATTRIBUTE.keySet(), var1);
   private static final DynamicCommandExceptionType field30229 = new DynamicCommandExceptionType(
      var0 -> new TranslationTextComponent("commands.attribute.failed.entity", var0)
   );
   private static final Dynamic2CommandExceptionType field30230 = new Dynamic2CommandExceptionType(
      (var0, var1) -> new TranslationTextComponent("commands.attribute.failed.no_attribute", var0, var1)
   );
   private static final Dynamic3CommandExceptionType field30231 = new Dynamic3CommandExceptionType(
      (var0, var1, var2) -> new TranslationTextComponent("commands.attribute.failed.no_modifier", var1, var0, var2)
   );
   private static final Dynamic3CommandExceptionType field30232 = new Dynamic3CommandExceptionType(
      (var0, var1, var2) -> new TranslationTextComponent("commands.attribute.failed.modifier_already_present", var2, var1, var0)
   );

   public static void method21610(CommandDispatcher<CommandSource> var0) {
      var0.register(
         (LiteralArgumentBuilder)((LiteralArgumentBuilder) Commands.method18839("attribute").requires(var0x -> var0x.method20129(2)))
            .then(
               Commands.method18840("target", Class8700.method31345())
                  .then(
                     ((RequiredArgumentBuilder)((RequiredArgumentBuilder) Commands.method18840("attribute", ResourceLocationArgument.method29031())
                              .suggests(field30228)
                              .then(
                                 ((LiteralArgumentBuilder) Commands.method18839("get")
                                       .executes(
                                          var0x -> method21614(
                                                (CommandSource)var0x.getSource(),
                                                Class8700.method31346(var0x, "target"),
                                                ResourceLocationArgument.method29035(var0x, "attribute"),
                                                1.0
                                             )
                                       ))
                                    .then(
                                       Commands.method18840("scale", DoubleArgumentType.doubleArg())
                                          .executes(
                                             var0x -> method21614(
                                                   (CommandSource)var0x.getSource(),
                                                   Class8700.method31346(var0x, "target"),
                                                   ResourceLocationArgument.method29035(var0x, "attribute"),
                                                   DoubleArgumentType.getDouble(var0x, "scale")
                                                )
                                          )
                                    )
                              ))
                           .then(
                              ((LiteralArgumentBuilder) Commands.method18839("base")
                                    .then(
                                       Commands.method18839("set")
                                          .then(
                                             Commands.method18840("value", DoubleArgumentType.doubleArg())
                                                .executes(
                                                   var0x -> method21617(
                                                         (CommandSource)var0x.getSource(),
                                                         Class8700.method31346(var0x, "target"),
                                                         ResourceLocationArgument.method29035(var0x, "attribute"),
                                                         DoubleArgumentType.getDouble(var0x, "value")
                                                      )
                                                )
                                          )
                                    ))
                                 .then(
                                    ((LiteralArgumentBuilder) Commands.method18839("get")
                                          .executes(
                                             var0x -> method21615(
                                                   (CommandSource)var0x.getSource(),
                                                   Class8700.method31346(var0x, "target"),
                                                   ResourceLocationArgument.method29035(var0x, "attribute"),
                                                   1.0
                                                )
                                          ))
                                       .then(
                                          Commands.method18840("scale", DoubleArgumentType.doubleArg())
                                             .executes(
                                                var0x -> method21615(
                                                      (CommandSource)var0x.getSource(),
                                                      Class8700.method31346(var0x, "target"),
                                                      ResourceLocationArgument.method29035(var0x, "attribute"),
                                                      DoubleArgumentType.getDouble(var0x, "scale")
                                                   )
                                             )
                                       )
                                 )
                           ))
                        .then(
                           ((LiteralArgumentBuilder)((LiteralArgumentBuilder) Commands.method18839("modifier")
                                    .then(
                                       Commands.method18839("add")
                                          .then(
                                             Commands.method18840("uuid", Class9728.method38110())
                                                .then(
                                                   Commands.method18840("name", StringArgumentType.string())
                                                      .then(
                                                         ((RequiredArgumentBuilder)((RequiredArgumentBuilder) Commands.method18840(
                                                                     "value", DoubleArgumentType.doubleArg()
                                                                  )
                                                                  .then(
                                                                     Commands.method18839("add")
                                                                        .executes(
                                                                           var0x -> method21618(
                                                                                 (CommandSource)var0x.getSource(),
                                                                                 Class8700.method31346(var0x, "target"),
                                                                                 ResourceLocationArgument.method29035(var0x, "attribute"),
                                                                                 Class9728.method38109(var0x, "uuid"),
                                                                                 StringArgumentType.getString(var0x, "name"),
                                                                                 DoubleArgumentType.getDouble(var0x, "value"),
                                                                                 AttributeModifier.Operation.ADDITION
                                                                              )
                                                                        )
                                                                  ))
                                                               .then(
                                                                  Commands.method18839("multiply")
                                                                     .executes(
                                                                        var0x -> method21618(
                                                                              (CommandSource)var0x.getSource(),
                                                                              Class8700.method31346(var0x, "target"),
                                                                              ResourceLocationArgument.method29035(var0x, "attribute"),
                                                                              Class9728.method38109(var0x, "uuid"),
                                                                              StringArgumentType.getString(var0x, "name"),
                                                                              DoubleArgumentType.getDouble(var0x, "value"),
                                                                              AttributeModifier.Operation.MULTIPLY_TOTAL
                                                                           )
                                                                     )
                                                               ))
                                                            .then(
                                                               Commands.method18839("multiply_base")
                                                                  .executes(
                                                                     var0x -> method21618(
                                                                           (CommandSource)var0x.getSource(),
                                                                           Class8700.method31346(var0x, "target"),
                                                                           ResourceLocationArgument.method29035(var0x, "attribute"),
                                                                           Class9728.method38109(var0x, "uuid"),
                                                                           StringArgumentType.getString(var0x, "name"),
                                                                           DoubleArgumentType.getDouble(var0x, "value"),
                                                                           AttributeModifier.Operation.field13353
                                                                        )
                                                                  )
                                                            )
                                                      )
                                                )
                                          )
                                    ))
                                 .then(
                                    Commands.method18839("remove")
                                       .then(
                                          Commands.method18840("uuid", Class9728.method38110())
                                             .executes(
                                                var0x -> method21619(
                                                      (CommandSource)var0x.getSource(),
                                                      Class8700.method31346(var0x, "target"),
                                                      ResourceLocationArgument.method29035(var0x, "attribute"),
                                                      Class9728.method38109(var0x, "uuid")
                                                   )
                                             )
                                       )
                                 ))
                              .then(
                                 Commands.method18839("value")
                                    .then(
                                       Commands.method18839("get")
                                          .then(
                                             ((RequiredArgumentBuilder) Commands.method18840("uuid", Class9728.method38110())
                                                   .executes(
                                                      var0x -> method21616(
                                                            (CommandSource)var0x.getSource(),
                                                            Class8700.method31346(var0x, "target"),
                                                            ResourceLocationArgument.method29035(var0x, "attribute"),
                                                            Class9728.method38109(var0x, "uuid"),
                                                            1.0
                                                         )
                                                   ))
                                                .then(
                                                   Commands.method18840("scale", DoubleArgumentType.doubleArg())
                                                      .executes(
                                                         var0x -> method21616(
                                                               (CommandSource)var0x.getSource(),
                                                               Class8700.method31346(var0x, "target"),
                                                               ResourceLocationArgument.method29035(var0x, "attribute"),
                                                               Class9728.method38109(var0x, "uuid"),
                                                               DoubleArgumentType.getDouble(var0x, "scale")
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

   private static ModifiableAttributeInstance method21611(Entity var0, Attribute var1) throws CommandSyntaxException {
      ModifiableAttributeInstance var4 = method21612(var0).getAttributeManager().createInstanceIfAbsent(var1);
      if (var4 != null) {
         return var4;
      } else {
         throw field30230.create(var0.getName(), new TranslationTextComponent(var1.getAttributeName()));
      }
   }

   private static LivingEntity method21612(Entity var0) throws CommandSyntaxException {
      if (var0 instanceof LivingEntity) {
         return (LivingEntity)var0;
      } else {
         throw field30229.create(var0.getName());
      }
   }

   private static LivingEntity method21613(Entity var0, Attribute var1) throws CommandSyntaxException {
      LivingEntity var4 = method21612(var0);
      if (var4.getAttributeManager().hasAttributeInstance(var1)) {
         return var4;
      } else {
         throw field30230.create(var0.getName(), new TranslationTextComponent(var1.getAttributeName()));
      }
   }

   private static int method21614(CommandSource var0, Entity var1, Attribute var2, double var3) throws CommandSyntaxException {
      LivingEntity var7 = method21613(var1, var2);
      double var8 = var7.getAttributeValue(var2);
      var0.sendFeedback(
         new TranslationTextComponent("commands.attribute.value.get.success", new TranslationTextComponent(var2.getAttributeName()), var1.getName(), var8), false
      );
      return (int)(var8 * var3);
   }

   private static int method21615(CommandSource var0, Entity var1, Attribute var2, double var3) throws CommandSyntaxException {
      LivingEntity var7 = method21613(var1, var2);
      double var8 = var7.method3087(var2);
      var0.sendFeedback(
         new TranslationTextComponent("commands.attribute.base_value.get.success", new TranslationTextComponent(var2.getAttributeName()), var1.getName(), var8),
         false
      );
      return (int)(var8 * var3);
   }

   private static int method21616(CommandSource var0, Entity var1, Attribute var2, UUID var3, double var4) throws CommandSyntaxException {
      LivingEntity var8 = method21613(var1, var2);
      AttributeModifierManager var9 = var8.getAttributeManager();
      if (var9.hasModifier(var2, var3)) {
         double var10 = var9.getModifierValue(var2, var3);
         var0.sendFeedback(
            new TranslationTextComponent(
               "commands.attribute.modifier.value.get.success", var3, new TranslationTextComponent(var2.getAttributeName()), var1.getName(), var10
            ),
            false
         );
         return (int)(var10 * var4);
      } else {
         throw field30231.create(var1.getName(), new TranslationTextComponent(var2.getAttributeName()), var3);
      }
   }

   private static int method21617(CommandSource var0, Entity var1, Attribute var2, double var3) throws CommandSyntaxException {
      method21611(var1, var2).method38661(var3);
      var0.sendFeedback(
         new TranslationTextComponent("commands.attribute.base_value.set.success", new TranslationTextComponent(var2.getAttributeName()), var1.getName(), var3),
         false
      );
      return 1;
   }

   private static int method21618(CommandSource var0, Entity var1, Attribute var2, UUID var3, String var4, double var5, AttributeModifier.Operation var7) throws CommandSyntaxException {
      ModifiableAttributeInstance var10 = method21611(var1, var2);
      AttributeModifier var11 = new AttributeModifier(var3, var4, var5, var7);
      if (!var10.method38665(var11)) {
         var10.method38668(var11);
         var0.sendFeedback(
            new TranslationTextComponent("commands.attribute.modifier.add.success", var3, new TranslationTextComponent(var2.getAttributeName()), var1.getName()),
            false
         );
         return 1;
      } else {
         throw field30232.create(var1.getName(), new TranslationTextComponent(var2.getAttributeName()), var3);
      }
   }

   private static int method21619(CommandSource var0, Entity var1, Attribute var2, UUID var3) throws CommandSyntaxException {
      ModifiableAttributeInstance var6 = method21611(var1, var2);
      if (!var6.method38672(var3)) {
         throw field30231.create(var1.getName(), new TranslationTextComponent(var2.getAttributeName()), var3);
      } else {
         var0.sendFeedback(
            new TranslationTextComponent(
               "commands.attribute.modifier.remove.success", var3, new TranslationTextComponent(var2.getAttributeName()), var1.getName()
            ),
            false
         );
         return 1;
      }
   }
}
