package mapped;

import com.google.common.collect.Lists;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import net.minecraft.block.BlockState;
import net.minecraft.command.CommandSource;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.command.arguments.BlockPosArgument;
import net.minecraft.command.arguments.ResourceLocationArgument;
import net.minecraft.command.arguments.Vec3Argument;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.server.ServerWorld;

public class Class9653 {
   public static final SuggestionProvider<CommandSource> field45128 = (var0, var1) -> {
      Class284 var4 = ((CommandSource)var0.getSource()).getServer().method1411();
      return ISuggestionProvider.suggestIterable(var4.method1061(), var1);
   };
   private static final DynamicCommandExceptionType field45129 = new DynamicCommandExceptionType(
      var0 -> new TranslationTextComponent("commands.drop.no_held_items", var0)
   );
   private static final DynamicCommandExceptionType field45130 = new DynamicCommandExceptionType(
      var0 -> new TranslationTextComponent("commands.drop.no_loot_table", var0)
   );

   public static void method37658(CommandDispatcher<CommandSource> var0) {
      var0.register(
         method37659(
            Commands.method18839("loot").requires(var0x -> var0x.method20129(2)),
            (var0x, var1) -> var0x.then(
                     Commands.method18839("fish")
                        .then(
                           Commands.method18840("loot_table", ResourceLocationArgument.method29031())
                              .suggests(field45128)
                              .then(
                                 ((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder) Commands.method18840(
                                                "pos", BlockPosArgument.method20826()
                                             )
                                             .executes(
                                                var1x -> method37675(
                                                      var1x,
                                                      ResourceLocationArgument.getResourceLocation(var1x, "loot_table"),
                                                      BlockPosArgument.method20827(var1x, "pos"),
                                                      ItemStack.EMPTY,
                                                      var1
                                                   )
                                             ))
                                          .then(
                                             Commands.method18840("tool", Class8722.method31481())
                                                .executes(
                                                   var1x -> method37675(
                                                         var1x,
                                                         ResourceLocationArgument.getResourceLocation(var1x, "loot_table"),
                                                         BlockPosArgument.method20827(var1x, "pos"),
                                                         Class8722.method31482(var1x, "tool").method503(1, false),
                                                         var1
                                                      )
                                                )
                                          ))
                                       .then(
                                          Commands.method18839("mainhand")
                                             .executes(
                                                var1x -> method37675(
                                                      var1x,
                                                      ResourceLocationArgument.getResourceLocation(var1x, "loot_table"),
                                                      BlockPosArgument.method20827(var1x, "pos"),
                                                      method37671((CommandSource)var1x.getSource(), EquipmentSlotType.MAINHAND),
                                                      var1
                                                   )
                                             )
                                       ))
                                    .then(
                                       Commands.method18839("offhand")
                                          .executes(
                                             var1x -> method37675(
                                                   var1x,
                                                   ResourceLocationArgument.getResourceLocation(var1x, "loot_table"),
                                                   BlockPosArgument.method20827(var1x, "pos"),
                                                   method37671((CommandSource)var1x.getSource(), EquipmentSlotType.OFFHAND),
                                                   var1
                                                )
                                          )
                                    )
                              )
                        )
                  )
                  .then(
                     Commands.method18839("loot")
                        .then(
                           Commands.method18840("loot_table", ResourceLocationArgument.method29031())
                              .suggests(field45128)
                              .executes(var1x -> method37674(var1x, ResourceLocationArgument.getResourceLocation(var1x, "loot_table"), var1))
                        )
                  )
                  .then(
                     Commands.method18839("kill")
                        .then(
                           Commands.method18840("target", Class8700.method31345())
                              .executes(var1x -> method37673(var1x, Class8700.method31346(var1x, "target"), var1))
                        )
                  )
                  .then(
                     Commands.method18839("mine")
                        .then(
                           ((RequiredArgumentBuilder)((RequiredArgumentBuilder)((RequiredArgumentBuilder) Commands.method18840("pos", BlockPosArgument.method20826())
                                       .executes(var1x -> method37672(var1x, BlockPosArgument.method20827(var1x, "pos"), ItemStack.EMPTY, var1)))
                                    .then(
                                       Commands.method18840("tool", Class8722.method31481())
                                          .executes(
                                             var1x -> method37672(
                                                   var1x, BlockPosArgument.method20827(var1x, "pos"), Class8722.method31482(var1x, "tool").method503(1, false), var1
                                                )
                                          )
                                    ))
                                 .then(
                                    Commands.method18839("mainhand")
                                       .executes(
                                          var1x -> method37672(
                                                var1x,
                                                BlockPosArgument.method20827(var1x, "pos"),
                                                method37671((CommandSource)var1x.getSource(), EquipmentSlotType.MAINHAND),
                                                var1
                                             )
                                       )
                                 ))
                              .then(
                                 Commands.method18839("offhand")
                                    .executes(
                                       var1x -> method37672(
                                             var1x, BlockPosArgument.method20827(var1x, "pos"), method37671((CommandSource)var1x.getSource(), EquipmentSlotType.OFFHAND), var1
                                          )
                                    )
                              )
                        )
                  )
         )
      );
   }

   private static <T extends ArgumentBuilder<CommandSource, T>> T method37659(T var0, Class8236 var1) {
      return (T)var0.then(
            ((LiteralArgumentBuilder) Commands.method18839("replace")
                  .then(
                     Commands.method18839("entity")
                        .then(
                           Commands.method18840("entities", Class8700.method31347())
                              .then(
                                 var1.method28672(
                                       Commands.method18840("slot", Class4914.method15195()),
                                       (var0x, var1x, var2) -> method37667(
                                             Class8700.method31348(var0x, "entities"), Class4914.method15196(var0x, "slot"), var1x.size(), var1x, var2
                                          )
                                    )
                                    .then(
                                       var1.method28672(
                                          Commands.method18840("count", IntegerArgumentType.integer(0)),
                                          (var0x, var1x, var2) -> method37667(
                                                Class8700.method31348(var0x, "entities"),
                                                Class4914.method15196(var0x, "slot"),
                                                IntegerArgumentType.getInteger(var0x, "count"),
                                                var1x,
                                                var2
                                             )
                                       )
                                    )
                              )
                        )
                  ))
               .then(
                  Commands.method18839("block")
                     .then(
                        Commands.method18840("targetPos", BlockPosArgument.method20826())
                           .then(
                              var1.method28672(
                                    Commands.method18840("slot", Class4914.method15195()),
                                    (var0x, var1x, var2) -> method37663(
                                          (CommandSource)var0x.getSource(),
                                          BlockPosArgument.method20827(var0x, "targetPos"),
                                          Class4914.method15196(var0x, "slot"),
                                          var1x.size(),
                                          var1x,
                                          var2
                                       )
                                 )
                                 .then(
                                    var1.method28672(
                                       Commands.method18840("count", IntegerArgumentType.integer(0)),
                                       (var0x, var1x, var2) -> method37663(
                                             (CommandSource)var0x.getSource(),
                                             BlockPosArgument.method20827(var0x, "targetPos"),
                                             IntegerArgumentType.getInteger(var0x, "slot"),
                                             IntegerArgumentType.getInteger(var0x, "count"),
                                             var1x,
                                             var2
                                          )
                                    )
                                 )
                           )
                     )
               )
         )
         .then(
            Commands.method18839("insert")
               .then(
                  var1.method28672(
                     Commands.method18840("targetPos", BlockPosArgument.method20826()),
                     (var0x, var1x, var2) -> method37661((CommandSource)var0x.getSource(), BlockPosArgument.method20827(var0x, "targetPos"), var1x, var2)
                  )
               )
         )
         .then(
            Commands.method18839("give")
               .then(
                  var1.method28672(
                     Commands.method18840("players", Class8700.method31353()),
                     (var0x, var1x, var2) -> method37665(Class8700.method31354(var0x, "players"), var1x, var2)
                  )
               )
         )
         .then(
            Commands.method18839("spawn")
               .then(
                  var1.method28672(
                     Commands.method18840("targetPos", Vec3Argument.method20857()),
                     (var0x, var1x, var2) -> method37668((CommandSource)var0x.getSource(), Vec3Argument.method20859(var0x, "targetPos"), var1x, var2)
                  )
               )
         );
   }

   private static IInventory method37660(CommandSource var0, BlockPos var1) throws CommandSyntaxException {
      TileEntity var4 = var0.method20172().getTileEntity(var1);
      if (var4 instanceof IInventory) {
         return (IInventory)var4;
      } else {
         throw Class9195.field42233.create();
      }
   }

   private static int method37661(CommandSource var0, BlockPos var1, List<ItemStack> var2, Class7946 var3) throws CommandSyntaxException {
      IInventory var6 = method37660(var0, var1);
      ArrayList var7 = Lists.newArrayListWithCapacity(var2.size());

      for (ItemStack var9 : var2) {
         if (method37662(var6, var9.copy())) {
            var6.markDirty();
            var7.add(var9);
         }
      }

      var3.method27014(var7);
      return var7.size();
   }

   private static boolean method37662(IInventory var0, ItemStack var1) {
      boolean var4 = false;

      for (int var5 = 0; var5 < var0.getSizeInventory() && !var1.isEmpty(); var5++) {
         ItemStack var6 = var0.getStackInSlot(var5);
         if (var0.isItemValidForSlot(var5, var1)) {
            if (var6.isEmpty()) {
               var0.setInventorySlotContents(var5, var1);
               var4 = true;
               break;
            }

            if (method37664(var6, var1)) {
               int var7 = var1.getMaxStackSize() - var6.getCount();
               int var8 = Math.min(var1.getCount(), var7);
               var1.shrink(var8);
               var6.grow(var8);
               var4 = true;
            }
         }
      }

      return var4;
   }

   private static int method37663(CommandSource var0, BlockPos var1, int var2, int var3, List<ItemStack> var4, Class7946 var5) throws CommandSyntaxException {
      IInventory var8 = method37660(var0, var1);
      int var9 = var8.getSizeInventory();
      if (var2 >= 0 && var2 < var9) {
         ArrayList var10 = Lists.newArrayListWithCapacity(var4.size());

         for (int var11 = 0; var11 < var3; var11++) {
            int var12 = var2 + var11;
            ItemStack var13 = var11 >= var4.size() ? ItemStack.EMPTY : (ItemStack)var4.get(var11);
            if (var8.isItemValidForSlot(var12, var13)) {
               var8.setInventorySlotContents(var12, var13);
               var10.add(var13);
            }
         }

         var5.method27014(var10);
         return var10.size();
      } else {
         throw Class9195.field42234.create(var2);
      }
   }

   private static boolean method37664(ItemStack var0, ItemStack var1) {
      return var0.getItem() == var1.getItem()
         && var0.method32117() == var1.method32117()
         && var0.getCount() <= var0.getMaxStackSize()
         && Objects.equals(var0.getTag(), var1.getTag());
   }

   private static int method37665(Collection<ServerPlayerEntity> var0, List<ItemStack> var1, Class7946 var2) throws CommandSyntaxException {
      ArrayList var5 = Lists.newArrayListWithCapacity(var1.size());

      for (ItemStack var7 : var1) {
         for (ServerPlayerEntity var9 : var0) {
            if (var9.inventory.method4045(var7.copy())) {
               var5.add(var7);
            }
         }
      }

      var2.method27014(var5);
      return var5.size();
   }

   private static void method37666(Entity var0, List<ItemStack> var1, int var2, int var3, List<ItemStack> var4) {
      for (int var7 = 0; var7 < var3; var7++) {
         ItemStack var8 = var7 >= var1.size() ? ItemStack.EMPTY : (ItemStack)var1.get(var7);
         if (var0.method2963(var2 + var7, var8.copy())) {
            var4.add(var8);
         }
      }
   }

   private static int method37667(Collection<? extends Entity> var0, int var1, int var2, List<ItemStack> var3, Class7946 var4) throws CommandSyntaxException {
      ArrayList var7 = Lists.newArrayListWithCapacity(var3.size());

      for (Entity var9 : var0) {
         if (!(var9 instanceof ServerPlayerEntity)) {
            method37666(var9, var3, var1, var2, var7);
         } else {
            ServerPlayerEntity var10 = (ServerPlayerEntity)var9;
            var10.container.detectAndSendChanges();
            method37666(var9, var3, var1, var2, var7);
            var10.container.detectAndSendChanges();
         }
      }

      var4.method27014(var7);
      return var7.size();
   }

   private static int method37668(CommandSource var0, Vector3d var1, List<ItemStack> var2, Class7946 var3) throws CommandSyntaxException {
      ServerWorld var6 = var0.method20172();
      var2.forEach(var2x -> {
         ItemEntity var5 = new ItemEntity(var6, var1.x, var1.y, var1.z, var2x.copy());
         var5.setDefaultPickupDelay();
         var6.addEntity(var5);
      });
      var3.method27014(var2);
      return var2.size();
   }

   private static void method37669(CommandSource var0, List<ItemStack> var1) {
      if (var1.size() != 1) {
         var0.sendFeedback(new TranslationTextComponent("commands.drop.success.multiple", var1.size()), false);
      } else {
         ItemStack var4 = (ItemStack)var1.get(0);
         var0.sendFeedback(new TranslationTextComponent("commands.drop.success.single", var4.getCount(), var4.method32173()), false);
      }
   }

   private static void method37670(CommandSource var0, List<ItemStack> var1, ResourceLocation var2) {
      if (var1.size() != 1) {
         var0.sendFeedback(new TranslationTextComponent("commands.drop.success.multiple_with_table", var1.size(), var2), false);
      } else {
         ItemStack var5 = (ItemStack)var1.get(0);
         var0.sendFeedback(new TranslationTextComponent("commands.drop.success.single_with_table", var5.getCount(), var5.method32173(), var2), false);
      }
   }

   private static ItemStack method37671(CommandSource var0, EquipmentSlotType var1) throws CommandSyntaxException {
      Entity var4 = var0.method20174();
      if (!(var4 instanceof LivingEntity)) {
         throw field45129.create(var4.getDisplayName());
      } else {
         return ((LivingEntity)var4).getItemStackFromSlot(var1);
      }
   }

   private static int method37672(CommandContext<CommandSource> var0, BlockPos var1, ItemStack var2, Class8914 var3) throws CommandSyntaxException {
      CommandSource var6 = (CommandSource)var0.getSource();
      ServerWorld var7 = var6.method20172();
      BlockState var8 = var7.getBlockState(var1);
      TileEntity var9 = var7.getTileEntity(var1);
      Class9464 var10 = new Class9464(var7)
         .method36454(Class9525.field44335, Vector3d.method11328(var1))
         .method36454(Class9525.field44336, var8)
         .method36455(Class9525.field44337, var9)
         .method36455(Class9525.field44330, var6.method20173())
         .method36454(Class9525.field44338, var2);
      List var11 = var8.method23434(var10);
      return var3.method32583(var0, var11, var2x -> method37670(var6, var2x, var8.getBlock().getLootTable()));
   }

   private static int method37673(CommandContext<CommandSource> var0, Entity var1, Class8914 var2) throws CommandSyntaxException {
      if (var1 instanceof LivingEntity) {
         ResourceLocation var5 = ((LivingEntity)var1).getLootTableResourceLocation();
         CommandSource var6 = (CommandSource)var0.getSource();
         Class9464 var7 = new Class9464(var6.method20172());
         Entity var8 = var6.method20173();
         if (var8 instanceof PlayerEntity) {
            var7.method36454(Class9525.field44331, (PlayerEntity)var8);
         }

         var7.method36454(Class9525.field44332, DamageSource.field39006);
         var7.method36455(Class9525.field44334, var8);
         var7.method36455(Class9525.field44333, var8);
         var7.method36454(Class9525.field44330, var1);
         var7.method36454(Class9525.field44335, var6.method20171());
         Class7318 var9 = var6.getServer().method1411().method1058(var5);
         List var10 = var9.method23182(var7.method36460(Class8524.field38286));
         return var2.method32583(var0, var10, var2x -> method37670(var6, var2x, var5));
      } else {
         throw field45130.create(var1.getDisplayName());
      }
   }

   private static int method37674(CommandContext<CommandSource> var0, ResourceLocation var1, Class8914 var2) throws CommandSyntaxException {
      CommandSource var5 = (CommandSource)var0.getSource();
      Class9464 var6 = new Class9464(var5.method20172())
         .method36455(Class9525.field44330, var5.method20173())
         .method36454(Class9525.field44335, var5.method20171());
      return method37676(var0, var1, var6.method36460(Class8524.field38282), var2);
   }

   private static int method37675(CommandContext<CommandSource> var0, ResourceLocation var1, BlockPos var2, ItemStack var3, Class8914 var4) throws CommandSyntaxException {
      CommandSource var7 = (CommandSource)var0.getSource();
      LootContext var8 = new Class9464(var7.method20172())
         .method36454(Class9525.field44335, Vector3d.method11328(var2))
         .method36454(Class9525.field44338, var3)
         .method36455(Class9525.field44330, var7.method20173())
         .method36460(Class8524.field38285);
      return method37676(var0, var1, var8, var4);
   }

   private static int method37676(CommandContext<CommandSource> var0, ResourceLocation var1, LootContext var2, Class8914 var3) throws CommandSyntaxException {
      CommandSource var6 = (CommandSource)var0.getSource();
      Class7318 var7 = var6.getServer().method1411().method1058(var1);
      List var8 = var7.method23182(var2);
      return var3.method32583(var0, var8, var1x -> method37669(var6, var1x));
   }
}
