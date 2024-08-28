package mapped;

import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.StringReader;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import it.unimi.dsi.fastutil.ints.Int2ShortMap;
import it.unimi.dsi.fastutil.ints.Int2ShortOpenHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.ITextComponent$Serializer;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.filter.IChatFilter;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Class5111 implements Class5110 {
   private static final Logger field23223 = LogManager.getLogger();
   public final Class8586 field23224;
   private final Class314 server;
   public Class878 player;
   private int field23227;
   private long field23228;
   private boolean field23229;
   private long field23230;
   private int chatSpamThresholdCount;
   private int field23232;
   private final Int2ShortMap field23233 = new Int2ShortOpenHashMap();
   private double field23234;
   private double field23235;
   private double field23236;
   private double field23237;
   private double field23238;
   private double field23239;
   private Entity field23240;
   private double field23241;
   private double field23242;
   private double field23243;
   private double field23244;
   private double field23245;
   private double field23246;
   private Vector3d targetPos;
   private int field23248;
   private int field23249;
   private boolean field23250;
   private int field23251;
   private boolean field23252;
   private int field23253;
   private int field23254;
   private int field23255;

   public Class5111(Class314 var1, Class8586 var2, Class878 var3) {
      this.server = var1;
      this.field23224 = var2;
      var2.method30692(this);
      this.player = var3;
      var3.field4855 = this;
      IChatFilter var6 = var3.method2837();
      if (var6 != null) {
         var6.func_244800_a();
      }
   }

   public void method15655() {
      this.method15656();
      this.player.field5025 = this.player.getPosX();
      this.player.field5026 = this.player.getPosY();
      this.player.field5027 = this.player.getPosZ();
      this.player.method2735();
      this.player.method3269(this.field23234, this.field23235, this.field23236, this.player.field5031, this.player.field5032);
      this.field23227++;
      this.field23255 = this.field23254;
      if (this.field23250 && !this.player.isSleeping()) {
         if (++this.field23251 > 80) {
            field23223.warn("{} was kicked for floating too long!", this.player.method2941().getString());
            this.disconnect(new TranslationTextComponent("multiplayer.disconnect.flying"));
            return;
         }
      } else {
         this.field23250 = false;
         this.field23251 = 0;
      }

      this.field23240 = this.player.method3415();
      if (this.field23240 != this.player && this.field23240.method3407() == this.player) {
         this.field23241 = this.field23240.getPosX();
         this.field23242 = this.field23240.getPosY();
         this.field23243 = this.field23240.getPosZ();
         this.field23244 = this.field23240.getPosX();
         this.field23245 = this.field23240.getPosY();
         this.field23246 = this.field23240.getPosZ();
         if (this.field23252 && this.player.method3415().method3407() == this.player) {
            if (++this.field23253 > 80) {
               field23223.warn("{} was kicked for floating a vehicle too long!", this.player.method2941().getString());
               this.disconnect(new TranslationTextComponent("multiplayer.disconnect.flying"));
               return;
            }
         } else {
            this.field23252 = false;
            this.field23253 = 0;
         }
      } else {
         this.field23240 = null;
         this.field23252 = false;
         this.field23253 = 0;
      }

      this.server.method1420().method22503("keepAlive");
      long var3 = Util.method38487();
      if (var3 - this.field23228 >= 15000L) {
         if (!this.field23229) {
            this.field23229 = true;
            this.field23228 = var3;
            this.field23230 = var3;
            this.sendPacket(new Class5554(this.field23230));
         } else {
            this.disconnect(new TranslationTextComponent("disconnect.timeout"));
         }
      }

      this.server.method1420().method22505();
      if (this.chatSpamThresholdCount > 0) {
         this.chatSpamThresholdCount--;
      }

      if (this.field23232 > 0) {
         this.field23232--;
      }

      if (this.player.method2818() > 0L
         && this.server.method1382() > 0
         && Util.method38487() - this.player.method2818() > (long)(this.server.method1382() * 1000 * 60)) {
         this.disconnect(new TranslationTextComponent("multiplayer.disconnect.idling"));
      }
   }

   public void method15656() {
      this.field23234 = this.player.getPosX();
      this.field23235 = this.player.getPosY();
      this.field23236 = this.player.getPosZ();
      this.field23237 = this.player.getPosX();
      this.field23238 = this.player.getPosY();
      this.field23239 = this.player.getPosZ();
   }

   @Override
   public Class8586 method15589() {
      return this.field23224;
   }

   private boolean method15657() {
      return this.server.method1421(this.player.getGameProfile());
   }

   public void disconnect(ITextComponent var1) {
      this.field23224.method30694(new Class5530(var1), var2 -> this.field23224.method30701(var1));
      this.field23224.method30711();
      this.server.method1635(this.field23224::method30713);
   }

   private <T> void method15659(T var1, Consumer<T> var2, BiFunction<IChatFilter, T, CompletableFuture<Optional<T>>> var3) {
      Class314 var6 = this.player.getServerWorld().method6715();
      Consumer<T> var7 = var2x -> {
         if (!this.method15589().method30707()) {
            field23223.debug("Ignoring packet due to disconnection");
         } else {
            var2.accept(var2x);
         }
      };
      IChatFilter var8 = this.player.method2837();
      if (var8 == null) {
         var6.execute(() -> var7.accept(var1));
      } else {
         var3.apply(var8, var1).thenAcceptAsync(var1x -> var1x.ifPresent(var7), var6);
      }
   }

   private void method15660(String var1, Consumer<String> var2) {
      this.method15659(var1, var2, IChatFilter::func_244432_a);
   }

   private void method15661(List<String> var1, Consumer<List<String>> var2) {
      this.method15659(var1, var2, IChatFilter::func_244433_a);
   }

   @Override
   public void method15626(Class5471 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      this.player.method2775(var1.method17199(), var1.method17200(), var1.method17201(), var1.method17202());
   }

   private static boolean method15662(Class5603 var0) {
      return Doubles.isFinite(var0.method17625(0.0))
            && Doubles.isFinite(var0.method17626(0.0))
            && Doubles.isFinite(var0.method17627(0.0))
            && Floats.isFinite(var0.method17629(0.0F))
            && Floats.isFinite(var0.method17628(0.0F))
         ? Math.abs(var0.method17625(0.0)) > 3.0E7 || Math.abs(var0.method17626(0.0)) > 3.0E7 || Math.abs(var0.method17627(0.0)) > 3.0E7
         : true;
   }

   private static boolean method15663(Class5483 var0) {
      return !Doubles.isFinite(var0.method17246())
         || !Doubles.isFinite(var0.method17247())
         || !Doubles.isFinite(var0.method17248())
         || !Floats.isFinite(var0.method17250())
         || !Floats.isFinite(var0.method17249());
   }

   @Override
   public void method15635(Class5483 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (!method15663(var1)) {
         Entity var4 = this.player.method3415();
         if (var4 != this.player && var4.method3407() == this.player && var4 == this.field23240) {
            ServerWorld var5 = this.player.getServerWorld();
            double var6 = var4.getPosX();
            double var8 = var4.getPosY();
            double var10 = var4.getPosZ();
            double var12 = var1.method17246();
            double var14 = var1.method17247();
            double var16 = var1.method17248();
            float var18 = var1.method17249();
            float var19 = var1.method17250();
            double var20 = var12 - this.field23241;
            double var22 = var14 - this.field23242;
            double var24 = var16 - this.field23243;
            double var26 = var4.method3433().method11349();
            double var28 = var20 * var20 + var22 * var22 + var24 * var24;
            if (var28 - var26 > 100.0 && !this.method15657()) {
               field23223.warn(
                  "{} (vehicle of {}) moved too quickly! {},{},{}",
                  var4.method2941().getString(),
                  this.player.method2941().getString(),
                  var20,
                  var22,
                  var24
               );
               this.field23224.method30693(new Class5536(var4));
               return;
            }

            boolean var30 = var5.method7053(var4, var4.method3389().method19679(0.0625));
            var20 = var12 - this.field23244;
            var22 = var14 - this.field23245 - 1.0E-6;
            var24 = var16 - this.field23246;
            var4.move(Class2107.field13743, new Vector3d(var20, var22, var24));
            var20 = var12 - var4.getPosX();
            var22 = var14 - var4.getPosY();
            if (var22 > -0.5 || var22 < 0.5) {
               var22 = 0.0;
            }

            var24 = var16 - var4.getPosZ();
            var28 = var20 * var20 + var22 * var22 + var24 * var24;
            boolean var31 = false;
            if (var28 > 0.0625) {
               var31 = true;
               field23223.warn(
                  "{} (vehicle of {}) moved wrongly! {}", var4.method2941().getString(), this.player.method2941().getString(), Math.sqrt(var28)
               );
            }

            var4.method3269(var12, var14, var16, var18, var19);
            boolean var32 = var5.method7053(var4, var4.method3389().method19679(0.0625));
            if (var30 && (var31 || !var32)) {
               var4.method3269(var6, var8, var10, var18, var19);
               this.field23224.method30693(new Class5536(var4));
               return;
            }

            this.player.getServerWorld().method6883().method7376(this.player);
            this.player.method2919(this.player.getPosX() - var6, this.player.getPosY() - var8, this.player.getPosZ() - var10);
            this.field23252 = var22 >= -0.03125 && !this.server.method1359() && this.method15664(var4);
            this.field23244 = var4.getPosX();
            this.field23245 = var4.getPosY();
            this.field23246 = var4.getPosZ();
         }
      } else {
         this.disconnect(new TranslationTextComponent("multiplayer.disconnect.invalid_vehicle_movement"));
      }
   }

   private boolean method15664(Entity var1) {
      return var1.field5024.method7035(var1.method3389().method19664(0.0625).method19662(0.0, -0.55, 0.0)).allMatch(Class7377::method23393);
   }

   @Override
   public void method15636(Class5580 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (var1.method17524() == this.field23248) {
         this.player
            .method3269(
               this.targetPos.field18048, this.targetPos.field18049, this.targetPos.field18050, this.player.field5031, this.player.field5032
            );
         this.field23237 = this.targetPos.field18048;
         this.field23238 = this.targetPos.field18049;
         this.field23239 = this.targetPos.field18050;
         if (this.player.method2821()) {
            this.player.method2822();
         }

         this.targetPos = null;
      }
   }

   @Override
   public void method15637(Class5506 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      this.server.method1407().method1035(var1.method17320()).ifPresent(this.player.method2810()::method21365);
   }

   @Override
   public void method15638(Class5573 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      this.player.method2810().method21375(var1.method17503(), var1.method17504(), var1.method17505());
   }

   @Override
   public void method15639(Class5466 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (var1.method17184() == Class2238.field14644) {
         ResourceLocation var4 = var1.method17185();
         Class7952 var5 = this.server.method1396().method1065(var4);
         if (var5 != null) {
            this.player.method2823().method27415(var5);
         }
      }
   }

   @Override
   public void method15640(Class5562 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      StringReader var4 = new StringReader(var1.method17486());
      if (var4.canRead() && var4.peek() == '/') {
         var4.skip();
      }

      ParseResults<Class6619> var5 = this.server.getCommandManager().method18842().parse(var4, this.player.getCommandSource());
      this.server
         .getCommandManager()
         .method18842()
         .getCompletionSuggestions(var5)
         .thenAccept(var2 -> this.field23224.method30693(new Class5543(var1.method17485(), var2)));
   }

   @Override
   public void method15641(Class5578 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (!this.server.method1361()) {
         this.player.method1328(new TranslationTextComponent("advMode.notEnabled"), Util.field45724);
      } else if (!this.player.method2979()) {
         this.player.method1328(new TranslationTextComponent("advMode.notAllowed"), Util.field45724);
      } else {
         Class911 var4 = null;
         Class969 var5 = null;
         BlockPos var6 = var1.method17516();
         Class944 var7 = this.player.field5024.method6759(var6);
         if (var7 instanceof Class969) {
            var5 = (Class969)var7;
            var4 = var5.method4009();
         }

         String var8 = var1.method17517();
         boolean var9 = var1.method17518();
         if (var4 != null) {
            Class2037 var10 = var5.method4020();
            Direction var11 = this.player.field5024.method6738(var6).<Direction>method23463(Class3355.field18893);
            switch (Class9703.field45356[var1.method17521().ordinal()]) {
               case 1:
                  Class7380 var12 = Blocks.field36888.method11579();
                  this.player
                     .field5024
                     .method6725(var6, var12.method23465(Class3355.field18893, var11).method23465(Class3355.field18894, Boolean.valueOf(var1.method17519())), 2);
                  break;
               case 2:
                  Class7380 var13 = Blocks.field36887.method11579();
                  this.player
                     .field5024
                     .method6725(var6, var13.method23465(Class3355.field18893, var11).method23465(Class3355.field18894, Boolean.valueOf(var1.method17519())), 2);
                  break;
               case 3:
               default:
                  Class7380 var14 = Blocks.COMMAND_BLOCK.method11579();
                  this.player
                     .field5024
                     .method6725(var6, var14.method23465(Class3355.field18893, var11).method23465(Class3355.field18894, Boolean.valueOf(var1.method17519())), 2);
            }

            var7.method3779();
            this.player.field5024.method6761(var6, var7);
            var4.method3562(var8);
            var4.method3570(var9);
            if (!var9) {
               var4.method3569((ITextComponent)null);
            }

            var5.method4013(var1.method17520());
            if (var10 != var1.method17521()) {
               var5.method4014();
            }

            var4.method3568();
            if (!Class9001.method33256(var8)) {
               this.player.method1328(new TranslationTextComponent("advMode.setCommand.success", var8), Util.field45724);
            }
         }
      }
   }

   @Override
   public void method15642(Class5529 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (this.server.method1361()) {
         if (this.player.method2979()) {
            Class911 var4 = var1.method17387(this.player.field5024);
            if (var4 != null) {
               var4.method3562(var1.method17388());
               var4.method3570(var1.method17389());
               if (!var1.method17389()) {
                  var4.method3569((ITextComponent)null);
               }

               var4.method3568();
               this.player.method1328(new TranslationTextComponent("advMode.setCommand.success", var1.method17388()), Util.field45724);
            }
         } else {
            this.player.method1328(new TranslationTextComponent("advMode.notAllowed"), Util.field45724);
         }
      } else {
         this.player.method1328(new TranslationTextComponent("advMode.notEnabled"), Util.field45724);
      }
   }

   @Override
   public void method15643(Class5568 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      this.player.field4902.method4034(var1.method17494());
      this.player
         .field4855
         .sendPacket(new Class5501(-2, this.player.field4902.field5443, this.player.field4902.method3618(this.player.field4902.field5443)));
      this.player.field4855.sendPacket(new Class5501(-2, var1.method17494(), this.player.field4902.method3618(var1.method17494())));
      this.player.field4855.sendPacket(new Class5608(this.player.field4902.field5443));
   }

   @Override
   public void method15644(Class5558 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (this.player.field4905 instanceof Class5824) {
         Class5824 var4 = (Class5824)this.player.field4905;
         String var5 = SharedConstants.method34772(var1.method17477());
         if (var5.length() <= 35) {
            var4.method18197(var5);
         }
      }
   }

   @Override
   public void method15645(Class5597 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (this.player.field4905 instanceof Class5821) {
         ((Class5821)this.player.field4905).method18181(var1.method17599(), var1.method17600());
      }
   }

   @Override
   public void method15646(Class5601 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (this.player.method2979()) {
         BlockPos var4 = var1.method17609();
         Class7380 var5 = this.player.field5024.method6738(var4);
         Class944 var6 = this.player.field5024.method6759(var4);
         if (var6 instanceof Class964) {
            Class964 var7 = (Class964)var6;
            var7.method3951(var1.method17611());
            var7.method3937(var1.method17612());
            var7.method3941(var1.method17613());
            var7.method3943(var1.method17614());
            var7.method3945(var1.method17615());
            var7.method3947(var1.method17616());
            var7.method3949(var1.method17617());
            var7.method3954(var1.method17618());
            var7.method3974(var1.method17619());
            var7.method3976(var1.method17620());
            var7.method3956(var1.method17621());
            var7.method3958(var1.method17622());
            if (!var7.method3936()) {
               this.player.method2785(new TranslationTextComponent("structure_block.invalid_structure_name", var1.method17612()), false);
            } else {
               String var8 = var7.method3934();
               if (var1.method17610() != Class1897.field11139) {
                  if (var1.method17610() != Class1897.field11140) {
                     if (var1.method17610() == Class1897.field11141) {
                        if (!var7.method3959()) {
                           this.player.method2785(new TranslationTextComponent("structure_block.size_failure"), false);
                        } else {
                           this.player.method2785(new TranslationTextComponent("structure_block.size_success", var8), false);
                        }
                     }
                  } else if (var7.method3970()) {
                     if (!var7.method3965(this.player.getServerWorld())) {
                        this.player.method2785(new TranslationTextComponent("structure_block.load_prepare", var8), false);
                     } else {
                        this.player.method2785(new TranslationTextComponent("structure_block.load_success", var8), false);
                     }
                  } else {
                     this.player.method2785(new TranslationTextComponent("structure_block.load_not_found", var8), false);
                  }
               } else if (!var7.method3963()) {
                  this.player.method2785(new TranslationTextComponent("structure_block.save_failure", var8), false);
               } else {
                  this.player.method2785(new TranslationTextComponent("structure_block.save_success", var8), false);
               }
            }

            var7.method3622();
            this.player.field5024.method6731(var4, var5, var5, 3);
         }
      }
   }

   @Override
   public void method15651(Class5544 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (this.player.method2979()) {
         BlockPos var4 = var1.method17426();
         Class7380 var5 = this.player.field5024.method6738(var4);
         Class944 var6 = this.player.field5024.method6759(var4);
         if (var6 instanceof Class965) {
            Class965 var7 = (Class965)var6;
            var7.method3983(var1.method17427());
            var7.method3984(var1.method17428());
            var7.method3985(var1.method17429());
            var7.method3986(var1.method17430());
            var7.method3987(var1.method17431());
            var7.method3622();
            this.player.field5024.method6731(var4, var5, var5, 3);
         }
      }
   }

   @Override
   public void method15652(Class5468 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (this.player.method2979()) {
         BlockPos var4 = var1.method17189();
         Class944 var5 = this.player.field5024.method6759(var4);
         if (var5 instanceof Class965) {
            Class965 var6 = (Class965)var5;
            var6.method3988(this.player.getServerWorld(), var1.method17190(), var1.method17191());
         }
      }
   }

   @Override
   public void method15647(Class5541 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      int var4 = var1.method17420();
      Class5812 var5 = this.player.field4905;
      if (var5 instanceof Class5826) {
         Class5826 var6 = (Class5826)var5;
         var6.method18204(var4);
         var6.method18213(var4);
      }
   }

   @Override
   public void method15648(Class5551 var1) {
      ItemStack var4 = var1.method17465();
      if (var4.method32107() == Class8514.field38047) {
         Class39 var5 = var4.method32142();
         if (Class3291.method11833(var5)) {
            ArrayList var6 = Lists.newArrayList();
            boolean var7 = var1.method17466();
            if (var7) {
               var6.add(var5.method126("title"));
            }

            Class41 var8 = var5.method131("pages", 8);

            for (int var9 = 0; var9 < var8.size(); var9++) {
               var6.add(var8.method160(var9));
            }

            int var10 = var1.method17467();
            if (Class974.method4035(var10) || var10 == 40) {
               this.method15661(
                  var6, !var7 ? var2 -> this.method15665(var2, var10) : var2 -> this.method15666(var2.get(0), var2.subList(1, var2.size()), var10)
               );
            }
         }
      }
   }

   private void method15665(List<String> var1, int var2) {
      ItemStack var5 = this.player.field4902.method3618(var2);
      if (var5.method32107() == Class8514.field38047) {
         Class41 var6 = new Class41();
         var1.stream().<Class40>map(Class40::method150).forEach(var6::add);
         var5.method32164("pages", var6);
      }
   }

   private void method15666(String var1, List<String> var2, int var3) {
      ItemStack var6 = this.player.field4902.method3618(var3);
      if (var6.method32107() == Class8514.field38047) {
         ItemStack var7 = new ItemStack(Class8514.field38048);
         Class39 var8 = var6.method32142();
         if (var8 != null) {
            var7.method32148(var8.method79());
         }

         var7.method32164("author", Class40.method150(this.player.method2941().getString()));
         var7.method32164("title", Class40.method150(var1));
         Class41 var9 = new Class41();

         for (String var11 : var2) {
            StringTextComponent var12 = new StringTextComponent(var11);
            String var13 = ITextComponent$Serializer.toJson(var12);
            var9.add(Class40.method150(var13));
         }

         var7.method32164("pages", var9);
         this.player.field4902.method3621(var3, var7);
      }
   }

   @Override
   public void method15649(Class5559 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (this.player.method3424(2)) {
         Entity var4 = this.player.getServerWorld().method6774(var1.method17479());
         if (var4 != null) {
            Class39 var5 = var4.method3294(new Class39());
            this.player.field4855.sendPacket(new Class5510(var1.method17478(), var5));
         }
      }
   }

   @Override
   public void method15650(Class5486 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (this.player.method3424(2)) {
         Class944 var4 = this.player.getServerWorld().method6759(var1.method17255());
         Class39 var5 = var4 == null ? null : var4.method3646(new Class39());
         this.player.field4855.sendPacket(new Class5510(var1.method17254(), var5));
      }
   }

   @Override
   public void method15622(Class5603 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (!method15662(var1)) {
         ServerWorld var4 = this.player.getServerWorld();
         if (!this.player.field4892) {
            if (this.field23227 == 0) {
               this.method15656();
            }

            if (this.targetPos == null) {
               this.field23249 = this.field23227;
               if (!this.player.method3328()) {
                  double var5 = this.player.getPosX();
                  double var7 = this.player.getPosY();
                  double var9 = this.player.getPosZ();
                  double var11 = this.player.getPosY();
                  double var13 = var1.method17625(this.player.getPosX());
                  double var15 = var1.method17626(this.player.getPosY());
                  double var17 = var1.method17627(this.player.getPosZ());
                  float var19 = var1.method17628(this.player.field5031);
                  float var20 = var1.method17629(this.player.field5032);
                  double var21 = var13 - this.field23234;
                  double var23 = var15 - this.field23235;
                  double var25 = var17 - this.field23236;
                  double var27 = this.player.method3433().method11349();
                  double var29 = var21 * var21 + var23 * var23 + var25 * var25;
                  if (!this.player.isSleeping()) {
                     this.field23254++;
                     int var31 = this.field23254 - this.field23255;
                     if (var31 > 5) {
                        field23223.debug(
                           "{} is sending move packets too frequently ({} packets since last tick)", this.player.method2941().getString(), var31
                        );
                        var31 = 1;
                     }

                     if (!this.player.method2821()
                        && (!this.player.getServerWorld().method6789().method17135(Class5462.field24240) || !this.player.method3165())) {
                        float var32 = !this.player.method3165() ? 100.0F : 300.0F;
                        if (var29 - var27 > (double)(var32 * (float)var31) && !this.method15657()) {
                           field23223.warn("{} moved too quickly! {},{},{}", this.player.method2941().getString(), var21, var23, var25);
                           this.method15668(
                              this.player.getPosX(),
                              this.player.getPosY(),
                              this.player.getPosZ(),
                              this.player.field5031,
                              this.player.field5032
                           );
                           return;
                        }
                     }

                     Class6488 var42 = this.player.method3389();
                     var21 = var13 - this.field23237;
                     var23 = var15 - this.field23238;
                     var25 = var17 - this.field23239;
                     boolean var33 = var23 > 0.0;
                     if (this.player.method3226() && !var1.method17630() && var33) {
                        this.player.method2914();
                     }

                     this.player.move(Class2107.field13743, new Vector3d(var21, var23, var25));
                     var21 = var13 - this.player.getPosX();
                     var23 = var15 - this.player.getPosY();
                     if (var23 > -0.5 || var23 < 0.5) {
                        var23 = 0.0;
                     }

                     var25 = var17 - this.player.getPosZ();
                     var29 = var21 * var21 + var23 * var23 + var25 * var25;
                     boolean var34 = false;
                     if (!this.player.method2821()
                        && var29 > 0.0625
                        && !this.player.isSleeping()
                        && !this.player.field4857.method33866()
                        && this.player.field4857.method33863() != Class1894.field11105) {
                        var34 = true;
                        field23223.warn("{} moved wrongly!", this.player.method2941().getString());
                     }

                     this.player.method3269(var13, var15, var17, var19, var20);
                     if (this.player.field5052
                        || this.player.isSleeping()
                        || (!var34 || !var4.method7053(this.player, var42)) && !this.method15667(var4, var42)) {
                        this.field23250 = var23 >= -0.03125
                           && this.player.field4857.method33863() != Class1894.field11105
                           && !this.server.method1359()
                           && !this.player.field4919.field29608
                           && !this.player.method3033(Class8254.field35491)
                           && !this.player.method3165()
                           && this.method15664(this.player);
                        this.player.getServerWorld().method6883().method7376(this.player);
                        this.player.method2763(this.player.getPosY() - var11, var1.method17630());
                        this.player.method3061(var1.method17630());
                        if (var33) {
                           this.player.field5045 = 0.0F;
                        }

                        this.player
                           .method2919(this.player.getPosX() - var5, this.player.getPosY() - var7, this.player.getPosZ() - var9);
                        this.field23237 = this.player.getPosX();
                        this.field23238 = this.player.getPosY();
                        this.field23239 = this.player.getPosZ();
                     } else {
                        this.method15668(var5, var7, var9, var19, var20);
                     }
                  } else if (var29 > 1.0) {
                     this.method15668(
                        this.player.getPosX(),
                        this.player.getPosY(),
                        this.player.getPosZ(),
                        var1.method17628(this.player.field5031),
                        var1.method17629(this.player.field5032)
                     );
                  }
               } else {
                  this.player
                     .method3269(
                        this.player.getPosX(),
                        this.player.getPosY(),
                        this.player.getPosZ(),
                        var1.method17628(this.player.field5031),
                        var1.method17629(this.player.field5032)
                     );
                  this.player.getServerWorld().method6883().method7376(this.player);
               }
            } else if (this.field23227 - this.field23249 > 20) {
               this.field23249 = this.field23227;
               this.method15668(
                  this.targetPos.field18048, this.targetPos.field18049, this.targetPos.field18050, this.player.field5031, this.player.field5032
               );
            }
         }
      } else {
         this.disconnect(new TranslationTextComponent("multiplayer.disconnect.invalid_player_movement"));
      }
   }

   private boolean method15667(Class1662 var1, Class6488 var2) {
      Stream<Class6408> var5 = var1.method7047(this.player, this.player.method3389().method19679(1.0E-5F), var0 -> true);
      Class6408 var6 = Class8022.method27428(var2.method19679(1.0E-5F));
      return var5.anyMatch(var1x -> !Class8022.method27435(var1x, var6, Class9477.field44045));
   }

   public void method15668(double var1, double var3, double var5, float var7, float var8) {
      this.method15669(var1, var3, var5, var7, var8, Collections.<Class2033>emptySet());
   }

   public void method15669(double var1, double var3, double var5, float var7, float var8, Set<Class2033> var9) {
      double var12 = !var9.contains(Class2033.field13198) ? 0.0 : this.player.getPosX();
      double var14 = !var9.contains(Class2033.field13199) ? 0.0 : this.player.getPosY();
      double var16 = !var9.contains(Class2033.field13200) ? 0.0 : this.player.getPosZ();
      float var18 = !var9.contains(Class2033.field13201) ? 0.0F : this.player.field5031;
      float var19 = !var9.contains(Class2033.field13202) ? 0.0F : this.player.field5032;
      this.targetPos = new Vector3d(var1, var3, var5);
      if (++this.field23248 == Integer.MAX_VALUE) {
         this.field23248 = 0;
      }

      this.field23249 = this.field23227;
      this.player.method3269(var1, var3, var5, var7, var8);
      this.player.field4855.sendPacket(new Class5473(var1 - var12, var3 - var14, var5 - var16, var7 - var18, var8 - var19, var9, this.field23248));
   }

   @Override
   public void method15624(Class5492 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      BlockPos var4 = var1.method17272();
      this.player.markPlayerActive();
      Class2070 var5 = var1.method17274();
      switch (Class9703.field45357[var5.ordinal()]) {
         case 1:
            if (!this.player.method2800()) {
               ItemStack var6 = this.player.method3094(Hand.field183);
               this.player.method3095(Hand.field183, this.player.method3094(Hand.field182));
               this.player.method3095(Hand.field182, var6);
               this.player.method3162();
            }

            return;
         case 2:
            if (!this.player.method2800()) {
               this.player.method2881(false);
            }

            return;
         case 3:
            if (!this.player.method2800()) {
               this.player.method2881(true);
            }

            return;
         case 4:
            this.player.method3161();
            return;
         case 5:
         case 6:
         case 7:
            this.player.field4857.method33858(var4, var5, var1.method17273(), this.server.method1364());
            return;
         default:
            throw new IllegalArgumentException("Invalid player action");
      }
   }

   private static boolean method15670(Class878 var0, ItemStack var1) {
      if (var1.method32105()) {
         return false;
      } else {
         Class3257 var4 = var1.method32107();
         return (var4 instanceof Class3292 || var4 instanceof Class3287) && !var0.method2976().method19635(var4);
      }
   }

   @Override
   public void method15630(Class5570 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      ServerWorld var4 = this.player.getServerWorld();
      Hand var5 = var1.method17497();
      ItemStack var6 = this.player.method3094(var5);
      Class8711 var7 = var1.method17498();
      BlockPos var8 = var7.method31423();
      Direction var9 = var7.method31424();
      this.player.markPlayerActive();
      if (var8.getY() >= this.server.method1364()) {
         IFormattableTextComponent var10 = new TranslationTextComponent("build.tooHigh", this.server.method1364()).mergeStyle(TextFormatting.RED);
         this.player.field4855.sendPacket(new SChatPacket(var10, ChatType.GAME_INFO, Util.field45724));
      } else if (this.targetPos == null
         && this.player.method3276((double)var8.method8304() + 0.5, (double)var8.getY() + 0.5, (double)var8.method8306() + 0.5) < 64.0
         && var4.method6785(this.player, var8)) {
         Class2274 var12 = this.player.field4857.method33860(this.player, var4, var6, var5, var7);
         if (var9 == Direction.field673 && !var12.method9000() && var8.getY() >= this.server.method1364() - 1 && method15670(this.player, var6)) {
            IFormattableTextComponent var11 = new TranslationTextComponent("build.tooHigh", this.server.method1364()).mergeStyle(TextFormatting.RED);
            this.player.field4855.sendPacket(new SChatPacket(var11, ChatType.GAME_INFO, Util.field45724));
         } else if (var12.method9001()) {
            this.player.method3081(var5, true);
         }
      }

      this.player.field4855.sendPacket(new Class5607(var4, var8));
      this.player.field4855.sendPacket(new Class5607(var4, var8.method8349(var9)));
   }

   @Override
   public void method15631(Class5555 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      ServerWorld var4 = this.player.getServerWorld();
      Hand var5 = var1.method17472();
      ItemStack var6 = this.player.method3094(var5);
      this.player.markPlayerActive();
      if (!var6.method32105()) {
         Class2274 var7 = this.player.field4857.method33859(this.player, var4, var6, var5);
         if (var7.method9001()) {
            this.player.method3081(var5, true);
         }
      }
   }

   @Override
   public void method15632(Class5497 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (this.player.method2800()) {
         for (ServerWorld var5 : this.server.method1320()) {
            Entity var6 = var1.method17283(var5);
            if (var6 != null) {
               this.player.method2824(var5, var6.getPosX(), var6.getPosY(), var6.getPosZ(), var6.field5031, var6.field5032);
               return;
            }
         }
      }
   }

   @Override
   public void method15633(Class5557 var1) {
   }

   @Override
   public void method15634(Class5538 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      Entity var4 = this.player.getRidingEntity();
      if (var4 instanceof Class1002) {
         ((Class1002)var4).method4151(var1.method17414(), var1.method17415());
      }
   }

   @Override
   public void method15588(ITextComponent var1) {
      field23223.info("{} lost connection: {}", this.player.method2941().getString(), var1.getString());
      this.server.method1388();
      this.server
         .getPlayerList()
         .method19484(
            new TranslationTextComponent("multiplayer.player.left", this.player.getDisplayName()).mergeStyle(TextFormatting.YELLOW),
            ChatType.SYSTEM,
            Util.field45724
         );
      this.player.method2782();
      this.server.getPlayerList().method19450(this.player);
      IChatFilter var4 = this.player.method2837();
      if (var4 != null) {
         var4.func_244434_b();
      }

      if (this.method15657()) {
         field23223.info("Stopping singleplayer server as player logged out");
         this.server.method1296(false);
      }
   }

   public void sendPacket(Packet<?> var1) {
      this.method15672(var1, (GenericFutureListener<? extends Future<? super Void>>)null);
   }

   public void method15672(Packet<?> var1, GenericFutureListener<? extends Future<? super Void>> var2) {
      if (var1 instanceof SChatPacket) {
         SChatPacket var5 = (SChatPacket)var1;
         ChatVisibility var6 = this.player.getChatVisibility();
         if (var6 == ChatVisibility.HIDDEN && var5.method17650() != ChatType.GAME_INFO) {
            return;
         }

         if (var6 == ChatVisibility.SYSTEM && !var5.method17649()) {
            return;
         }
      }

      try {
         this.field23224.method30694(var1, var2);
      } catch (Throwable var8) {
         Class4526 var9 = Class4526.method14413(var8, "Sending packet");
         Class8965 var7 = var9.method14410("Packet being sent");
         var7.method32806("Packet class", () -> var1.getClass().getCanonicalName());
         throw new Class2506(var9);
      }
   }

   @Override
   public void method15627(Class5539 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (var1.method17416() >= 0 && var1.method17416() < Class974.method4029()) {
         if (this.player.field4902.field5443 != var1.method17416() && this.player.method3149() == Hand.field182) {
            this.player.method3162();
         }

         this.player.field4902.field5443 = var1.method17416();
         this.player.markPlayerActive();
      } else {
         field23223.warn("{} tried to set an invalid carried item", this.player.method2941().getString());
      }
   }

   @Override
   public void method15611(Class5522 var1) {
      String var4 = StringUtils.normalizeSpace(var1.method17359());
      if (!var4.startsWith("/")) {
         this.method15660(var4, this::func_244548_c);
      } else {
         PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
         this.func_244548_c(var4);
      }
   }

   private void func_244548_c(String p_244548_1_) {
      if (this.player.getChatVisibility() != ChatVisibility.HIDDEN) {
         this.player.markPlayerActive();

         for (int i = 0; i < p_244548_1_.length(); i++) {
            if (!SharedConstants.isAllowedCharacter(p_244548_1_.charAt(i))) {
               this.disconnect(new TranslationTextComponent("multiplayer.disconnect.illegal_characters"));
               return;
            }
         }

         if (!p_244548_1_.startsWith("/")) {
            TranslationTextComponent itextcomponent = new TranslationTextComponent("chat.type.text", this.player.getDisplayName(), p_244548_1_);
            this.server.getPlayerList().method19484(itextcomponent, ChatType.CHAT, this.player.getUniqueID());
         } else {
            this.handleSlashCommand(p_244548_1_);
         }

         this.chatSpamThresholdCount += 20;
         if (this.chatSpamThresholdCount > 200 && !this.server.getPlayerList().canSendCommands(this.player.getGameProfile())) {
            this.disconnect(new TranslationTextComponent("disconnect.spam"));
         }
      } else {
         this.sendPacket(new SChatPacket(new TranslationTextComponent("chat.cannotSend").mergeStyle(TextFormatting.RED), ChatType.SYSTEM, Util.field45724));
      }
   }

   private void handleSlashCommand(String command) {
      this.server.getCommandManager().handleCommand(this.player.getCommandSource(), command);
   }

   @Override
   public void handleAnimation(CAnimateHandPacket var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      this.player.markPlayerActive();
      this.player.swingArm(var1.getHand());
   }

   @Override
   public void processEntityAction(CEntityActionPacket packetIn) {
      PacketThreadUtil.checkThreadAndEnqueue(packetIn, this, this.player.getServerWorld());
      this.player.markPlayerActive();
      switch (Class9703.field45358[packetIn.getAction().ordinal()]) {
         case 1:
            this.player.setSneaking(true);
            break;
         case 2:
            this.player.setSneaking(false);
            break;
         case 3:
            this.player.setSprinting(true);
            break;
         case 4:
            this.player.setSprinting(false);
            break;
         case 5:
            if (this.player.isSleeping()) {
               this.player.stopSleepInBed(false, true);
               this.targetPos = this.player.getPositionVec();
            }
            break;
         case 6:
            if (this.player.getRidingEntity() instanceof IJumpingMount) {
               IJumpingMount ijumpingmount1 = (IJumpingMount)this.player.getRidingEntity();
               int i = packetIn.getAuxData();
               if (ijumpingmount1.canJump() && i > 0) {
                  ijumpingmount1.handleStartJump(i);
               }
            }
            break;
         case 7:
            if (this.player.getRidingEntity() instanceof IJumpingMount) {
               IJumpingMount var4 = (IJumpingMount)this.player.getRidingEntity();
               var4.handleStopJump();
            }
            break;
         case 8:
            if (this.player.getRidingEntity() instanceof AbstractHorseEntity) {
               ((AbstractHorseEntity)this.player.getRidingEntity()).openGUI(this.player);
            }
            break;
         case 9:
            if (!this.player.tryToStartFallFlying()) {
               this.player.stopFallFlying();
            }
            break;
         default:
            throw new IllegalArgumentException("Invalid client command!");
      }
   }

   @Override
   public void processUseEntity(CUseEntityPacket packetIn) {
      PacketThreadUtil.checkThreadAndEnqueue(packetIn, this, this.player.getServerWorld());
      ServerWorld serverworld = this.player.getServerWorld();
      Entity entity = packetIn.getEntityFromWorld(serverworld);
      this.player.markPlayerActive();
      this.player.setSneaking(packetIn.func_241792_e_());
      if (entity != null) {
         double var6 = 36.0;
         if (this.player.getDistanceSq(entity) < 36.0) {
            Hand var8 = packetIn.getHand();
            ItemStack var9 = var8 == null ? ItemStack.field39973 : this.player.method3094(var8).method32126();
            Optional var10 = Optional.empty();
            if (packetIn.method17316() != Class1968.field12832) {
               if (packetIn.method17316() != Class1968.field12834) {
                  if (packetIn.method17316() == Class1968.field12833) {
                     if (entity instanceof Class1000 || entity instanceof Class1003 || entity instanceof Class884 || entity == this.player) {
                        this.disconnect(new TranslationTextComponent("multiplayer.disconnect.invalid_entity_attacked"));
                        field23223.warn("Player {} tried to attack an invalid entity", this.player.method2941().getString());
                        return;
                     }

                     this.player.method2817(entity);
                  }
               } else {
                  var10 = Optional.<Class2274>of(entity.method3397(this.player, packetIn.method17318(), var8));
               }
            } else {
               var10 = Optional.<Class2274>of(this.player.method2893(entity, var8));
            }

            if (var10.isPresent() && ((Class2274)var10.get()).method9000()) {
               Class9551.field44506.method15127(this.player, var9, entity);
               if (((Class2274)var10.get()).method9001()) {
                  this.player.method3081(var8, true);
               }
            }
         }
      }
   }

   @Override
   public void method15612(Class5564 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      this.player.markPlayerActive();
      Class2175 var4 = var1.method17491();
      switch (Class9703.field45359[var4.ordinal()]) {
         case 1:
            if (this.player.field4892) {
               this.player.field4892 = false;
               this.player = this.server.getPlayerList().method19453(this.player, true);
               Class9551.field44486.method15146(this.player, Class1655.field9001, Class1655.field8999);
            } else {
               if (this.player.method3042() > 0.0F) {
                  return;
               }

               this.player = this.server.getPlayerList().method19453(this.player, false);
               if (this.server.method1287()) {
                  this.player.method2799(Class1894.field11105);
                  this.player.getServerWorld().method6789().<Class7466>method17128(Class5462.field24238).method24175(false, this.server);
               }
            }
            break;
         case 2:
            this.player.method2809().method28970(this.player);
      }
   }

   @Override
   public void method15618(Class5482 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      this.player.method2774();
   }

   @Override
   public void method15616(Class5594 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      this.player.markPlayerActive();
      if (this.player.field4905.field25471 == var1.method17579() && this.player.field4905.method18140(this.player)) {
         if (!this.player.method2800()) {
            ItemStack var4 = this.player.field4905.method18132(var1.method17580(), var1.method17581(), var1.method17584(), this.player);
            if (!ItemStack.method32128(var1.method17583(), var4)) {
               this.field23233.put(this.player.field4905.field25471, var1.method17582());
               this.player.field4855.sendPacket(new Class5542(var1.method17579(), var1.method17582(), false));
               this.player.field4905.method18141(this.player, false);
               Class25 var5 = Class25.method67();

               for (int var6 = 0; var6 < this.player.field4905.field25468.size(); var6++) {
                  ItemStack var7 = this.player.field4905.field25468.get(var6).method18265();
                  var5.add(!var7.method32105() ? var7 : ItemStack.field39973);
               }

               this.player.method2718(this.player.field4905, var5);
            } else {
               this.player.field4855.sendPacket(new Class5542(var1.method17579(), var1.method17582(), true));
               this.player.field4890 = true;
               this.player.field4905.method18130();
               this.player.method2773();
               this.player.field4890 = false;
            }
         } else {
            Class25 var8 = Class25.method67();

            for (int var9 = 0; var9 < this.player.field4905.field25468.size(); var9++) {
               var8.add(this.player.field4905.field25468.get(var9).method18265());
            }

            this.player.method2718(this.player.field4905, var8);
         }
      }
   }

   @Override
   public void method15617(Class5613 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      this.player.markPlayerActive();
      if (!this.player.method2800()
         && this.player.field4905.field25471 == var1.method17641()
         && this.player.field4905.method18140(this.player)
         && this.player.field4905 instanceof Class5828) {
         this.server
            .method1407()
            .method1035(var1.method17642())
            .ifPresent(var2 -> ((Class5828)this.player.field4905).method18219(var1.method17643(), (Class4843<?>)var2, this.player));
      }
   }

   @Override
   public void method15615(Class5533 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      this.player.markPlayerActive();
      if (this.player.field4905.field25471 == var1.method17395() && this.player.field4905.method18140(this.player) && !this.player.method2800()
         )
       {
         this.player.field4905.method18104(this.player, var1.method17396());
         this.player.field4905.method18130();
      }
   }

   @Override
   public void method15628(Class5514 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (this.player.field4857.method33866()) {
         boolean var4 = var1.method17336() < 0;
         ItemStack var5 = var1.method17337();
         Class39 var6 = var5.method32145("BlockEntityTag");
         if (!var5.method32105() && var6 != null && var6.method118("x") && var6.method118("y") && var6.method118("z")) {
            BlockPos var7 = new BlockPos(var6.method122("x"), var6.method122("y"), var6.method122("z"));
            Class944 var8 = this.player.field5024.method6759(var7);
            if (var8 != null) {
               Class39 var9 = var8.method3646(new Class39());
               var9.method133("x");
               var9.method133("y");
               var9.method133("z");
               var5.method32164("BlockEntityTag", var9);
            }
         }

         boolean var10 = var1.method17336() >= 1 && var1.method17336() <= 45;
         boolean var11 = var5.method32105() || var5.method32117() >= 0 && var5.method32179() <= 64 && !var5.method32105();
         if (var10 && var11) {
            if (!var5.method32105()) {
               this.player.field4904.method18136(var1.method17336(), var5);
            } else {
               this.player.field4904.method18136(var1.method17336(), ItemStack.field39973);
            }

            this.player.field4904.method18141(this.player, true);
            this.player.field4904.method18130();
         } else if (var4 && var11 && this.field23232 < 200) {
            this.field23232 += 20;
            this.player.method2882(var5, true);
         }
      }
   }

   @Override
   public void method15614(Class5493 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      int var4 = this.player.field4905.field25471;
      if (var4 == var1.method17275()
         && this.field23233.getOrDefault(var4, (short)(var1.method17276() + 1)) == var1.method17276()
         && !this.player.field4905.method18140(this.player)
         && !this.player.method2800()) {
         this.player.field4905.method18141(this.player, true);
      }
   }

   @Override
   public void method15629(Class5519 var1) {
      List var4 = Stream.<String>of(var1.method17352()).<String>map(TextFormatting::getTextWithoutFormattingCodes).collect(Collectors.toList());
      this.method15661(var4, var2 -> this.method15675(var1, var2));
   }

   private void method15675(Class5519 var1, List<String> var2) {
      this.player.markPlayerActive();
      ServerWorld var5 = this.player.getServerWorld();
      BlockPos var6 = var1.method17351();
      if (var5.method7017(var6)) {
         Class7380 var7 = var5.method6738(var6);
         Class944 var8 = var5.method6759(var6);
         if (!(var8 instanceof Class954)) {
            return;
         }

         Class954 var9 = (Class954)var8;
         if (!var9.method3838() || var9.method3841() != this.player) {
            field23223.warn("Player {} just tried to change non-editable sign", this.player.method2941().getString());
            return;
         }

         for (int var10 = 0; var10 < var2.size(); var10++) {
            var9.method3836(var10, new StringTextComponent((String)var2.get(var10)));
         }

         var9.method3622();
         var5.method6731(var6, var7, var7, 3);
      }
   }

   @Override
   public void method15621(Class5600 var1) {
      if (this.field23229 && var1.method17608() == this.field23230) {
         int var4 = (int)(Util.method38487() - this.field23228);
         this.player.field4891 = (this.player.field4891 * 3 + var4) / 4;
         this.field23229 = false;
      } else if (!this.method15657()) {
         this.disconnect(new TranslationTextComponent("disconnect.timeout"));
      }
   }

   @Override
   public void method15623(Class5612 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      this.player.field4919.field29607 = var1.method17640() && this.player.field4919.field29608;
   }

   @Override
   public void method15613(Class5561 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      this.player.method2804(var1);
   }

   @Override
   public void method15619(Class5527 var1) {
   }

   @Override
   public void method15653(Class5517 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (this.player.method3424(2) || this.method15657()) {
         this.server.method1336(var1.method17348(), false);
      }
   }

   @Override
   public void method15654(Class5494 var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, this, this.player.getServerWorld());
      if (this.player.method3424(2) || this.method15657()) {
         this.server.method1339(var1.method17277());
      }
   }
}
