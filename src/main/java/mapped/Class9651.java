package mapped;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.tree.LiteralCommandNode;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import net.minecraft.command.CommandSource;
import net.minecraft.command.arguments.ILocationArgument;
import net.minecraft.command.arguments.Vec3Argument;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.TicketType;

public class Class9651 {
   private static final SimpleCommandExceptionType field45127 = new SimpleCommandExceptionType(
      new TranslationTextComponent("commands.teleport.invalidPosition")
   );

   public static void method37644(CommandDispatcher<CommandSource> var0) {
      LiteralCommandNode var3 = var0.register(
         (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder) Commands.method18839("teleport")
                     .requires(var0x -> var0x.method20129(2)))
                  .then(
                     ((RequiredArgumentBuilder) Commands.method18840("targets", Class8700.method31347())
                           .then(
                              ((RequiredArgumentBuilder)((RequiredArgumentBuilder) Commands.method18840("location", Vec3Argument.method20857())
                                       .executes(
                                          var0x -> method37646(
                                                (CommandSource)var0x.getSource(),
                                                Class8700.method31348(var0x, "targets"),
                                                ((CommandSource)var0x.getSource()).method20172(),
                                                Vec3Argument.method20860(var0x, "location"),
                                                (ILocationArgument)null,
                                                (Class8502)null
                                             )
                                       ))
                                    .then(
                                       Commands.method18840("rotation", Class7918.method26558())
                                          .executes(
                                             var0x -> method37646(
                                                   (CommandSource)var0x.getSource(),
                                                   Class8700.method31348(var0x, "targets"),
                                                   ((CommandSource)var0x.getSource()).method20172(),
                                                   Vec3Argument.method20860(var0x, "location"),
                                                   Class7918.method26559(var0x, "rotation"),
                                                   (Class8502)null
                                                )
                                          )
                                    ))
                                 .then(
                                    ((LiteralArgumentBuilder) Commands.method18839("facing")
                                          .then(
                                             Commands.method18839("entity")
                                                .then(
                                                   ((RequiredArgumentBuilder) Commands.method18840("facingEntity", Class8700.method31345())
                                                         .executes(
                                                            var0x -> method37646(
                                                                  (CommandSource)var0x.getSource(),
                                                                  Class8700.method31348(var0x, "targets"),
                                                                  ((CommandSource)var0x.getSource()).method20172(),
                                                                  Vec3Argument.method20860(var0x, "location"),
                                                                  (ILocationArgument)null,
                                                                  new Class8502(Class8700.method31346(var0x, "facingEntity"), Class2062.field13441)
                                                               )
                                                         ))
                                                      .then(
                                                         Commands.method18840("facingAnchor", Class9188.method34388())
                                                            .executes(
                                                               var0x -> method37646(
                                                                     (CommandSource)var0x.getSource(),
                                                                     Class8700.method31348(var0x, "targets"),
                                                                     ((CommandSource)var0x.getSource()).method20172(),
                                                                     Vec3Argument.method20860(var0x, "location"),
                                                                     (ILocationArgument)null,
                                                                     new Class8502(
                                                                        Class8700.method31346(var0x, "facingEntity"),
                                                                        Class9188.method34387(var0x, "facingAnchor")
                                                                     )
                                                                  )
                                                            )
                                                      )
                                                )
                                          ))
                                       .then(
                                          Commands.method18840("facingLocation", Vec3Argument.method20857())
                                             .executes(
                                                var0x -> method37646(
                                                      (CommandSource)var0x.getSource(),
                                                      Class8700.method31348(var0x, "targets"),
                                                      ((CommandSource)var0x.getSource()).method20172(),
                                                      Vec3Argument.method20860(var0x, "location"),
                                                      (ILocationArgument)null,
                                                      new Class8502(Vec3Argument.method20859(var0x, "facingLocation"))
                                                   )
                                             )
                                       )
                                 )
                           ))
                        .then(
                           Commands.method18840("destination", Class8700.method31345())
                              .executes(
                                 var0x -> method37645(
                                       (CommandSource)var0x.getSource(), Class8700.method31348(var0x, "targets"), Class8700.method31346(var0x, "destination")
                                    )
                              )
                        )
                  ))
               .then(
                  Commands.method18840("location", Vec3Argument.method20857())
                     .executes(
                        var0x -> method37646(
                              (CommandSource)var0x.getSource(),
                              Collections.singleton(((CommandSource)var0x.getSource()).method20174()),
                              ((CommandSource)var0x.getSource()).method20172(),
                              Vec3Argument.method20860(var0x, "location"),
                              Class7331.method23238(),
                              (Class8502)null
                           )
                     )
               ))
            .then(
               Commands.method18840("destination", Class8700.method31345())
                  .executes(
                     var0x -> method37645(
                           (CommandSource)var0x.getSource(),
                           Collections.singleton(((CommandSource)var0x.getSource()).method20174()),
                           Class8700.method31346(var0x, "destination")
                        )
                  )
            )
      );
      var0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder) Commands.method18839("tp").requires(var0x -> var0x.method20129(2))).redirect(var3));
   }

   private static int method37645(CommandSource var0, Collection<? extends Entity> var1, Entity var2) throws CommandSyntaxException {
      for (Entity var6 : var1) {
         method37647(
            var0,
            var6,
            (ServerWorld)var2.world,
            var2.getPosX(),
            var2.getPosY(),
            var2.getPosZ(),
            EnumSet.<Flags>noneOf(Flags.class),
            var2.rotationYaw,
            var2.rotationPitch,
            (Class8502)null
         );
      }

      if (var1.size() != 1) {
         var0.sendFeedback(new TranslationTextComponent("commands.teleport.success.entity.multiple", var1.size(), var2.getDisplayName()), true);
      } else {
         var0.sendFeedback(
            new TranslationTextComponent("commands.teleport.success.entity.single", ((Entity)var1.iterator().next()).getDisplayName(), var2.getDisplayName()), true
         );
      }

      return var1.size();
   }

   private static int method37646(CommandSource var0, Collection<? extends Entity> var1, ServerWorld var2, ILocationArgument var3, ILocationArgument var4, Class8502 var5) throws CommandSyntaxException {
      Vector3d var8 = var3.getPosition(var0);
      Vector2f var9 = var4 != null ? var4.getRotation(var0) : null;
      EnumSet var10 = EnumSet.<Flags>noneOf(Flags.class);
      if (var3.isXRelative()) {
         var10.add(Flags.field13198);
      }

      if (var3.isYRelative()) {
         var10.add(Flags.field13199);
      }

      if (var3.isZRelative()) {
         var10.add(Flags.field13200);
      }

      if (var4 != null) {
         if (var4.isXRelative()) {
            var10.add(Flags.field13202);
         }

         if (var4.isYRelative()) {
            var10.add(Flags.field13201);
         }
      } else {
         var10.add(Flags.field13202);
         var10.add(Flags.field13201);
      }

      for (Entity var12 : var1) {
         if (var4 != null) {
            method37647(var0, var12, var2, var8.x, var8.y, var8.z, var10, var9.y, var9.x, var5);
         } else {
            method37647(var0, var12, var2, var8.x, var8.y, var8.z, var10, var12.rotationYaw, var12.rotationPitch, var5);
         }
      }

      if (var1.size() != 1) {
         var0.sendFeedback(
            new TranslationTextComponent("commands.teleport.success.location.multiple", var1.size(), var8.x, var8.y, var8.z), true
         );
      } else {
         var0.sendFeedback(
            new TranslationTextComponent(
               "commands.teleport.success.location.single", ((Entity)var1.iterator().next()).getDisplayName(), var8.x, var8.y, var8.z
            ),
            true
         );
      }

      return var1.size();
   }

   private static void method37647(
           CommandSource var0, Entity var1, ServerWorld var2, double var3, double var5, double var7, Set<Flags> var9, float var10, float var11, Class8502 var12
   ) throws CommandSyntaxException {
      BlockPos var15 = new BlockPos(var3, var5, var7);
      if (World.isInvalidPosition(var15)) {
         if (!(var1 instanceof ServerPlayerEntity)) {
            float var16 = MathHelper.wrapDegrees(var10);
            float var17 = MathHelper.wrapDegrees(var11);
            var17 = MathHelper.clamp(var17, -90.0F, 90.0F);
            if (var2 != var1.world) {
               var1.detach();
               Entity var18 = var1;
               var1 = var1.getType().create(var2);
               if (var1 == null) {
                  return;
               }

               var1.method3365(var18);
               var1.setLocationAndAngles(var3, var5, var7, var16, var17);
               var1.setRotationYawHead(var16);
               var2.method6918(var1);
               var18.removed = true;
            } else {
               var1.setLocationAndAngles(var3, var5, var7, var16, var17);
               var1.setRotationYawHead(var16);
            }
         } else {
            ChunkPos var19 = new ChunkPos(new BlockPos(var3, var5, var7));
            var2.getChunkProvider().registerTicket(TicketType.POST_TELEPORT, var19, 1, var1.getEntityId());
            var1.stopRiding();
            if (((ServerPlayerEntity)var1).isSleeping()) {
               ((ServerPlayerEntity)var1).stopSleepInBed(true, true);
            }

            if (var2 != var1.world) {
               ((ServerPlayerEntity)var1).method2824(var2, var3, var5, var7, var10, var11);
            } else {
               ((ServerPlayerEntity)var1).connection.method15669(var3, var5, var7, var10, var11, var9);
            }

            var1.setRotationYawHead(var10);
         }

         if (var12 != null) {
            var12.method30092(var0, var1);
         }

         if (!(var1 instanceof LivingEntity) || !((LivingEntity)var1).isElytraFlying()) {
            var1.setMotion(var1.getMotion().mul(1.0, 0.0, 1.0));
            var1.setOnGround(true);
         }

         if (var1 instanceof CreatureEntity) {
            ((CreatureEntity)var1).method4230().method21666();
         }
      } else {
         throw field45127.create();
      }
   }
}
