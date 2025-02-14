package mapped;

import net.minecraft.util.Util;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPlayerDiggingPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Class9080 extends Class9081 {
   private boolean field41565;
   private boolean field41566;
   private int field41567;
   private int field41568;

   public Class9080(ServerWorld var1) {
      super(var1);
   }

   @Override
   public void method33856() {
      super.method33856();
      this.field41568++;
      long var3 = this.field41570.getGameTime();
      long var5 = var3 / 24000L + 1L;
      if (!this.field41565 && this.field41568 > 20) {
         this.field41565 = true;
         this.field41571.connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field24565, 0.0F));
      }

      this.field41566 = var3 > 120500L;
      if (this.field41566) {
         this.field41567++;
      }

      if (var3 % 24000L != 500L) {
         if (var5 != 1L) {
            if (var5 == 5L && var3 % 24000L == 22000L) {
               this.field41571.sendMessage(new TranslationTextComponent("demo.day.warning"), Util.DUMMY_UUID);
            }
         } else if (var3 != 100L) {
            if (var3 != 175L) {
               if (var3 == 250L) {
                  this.field41571.connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field24565, 103.0F));
               }
            } else {
               this.field41571.connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field24565, 102.0F));
            }
         } else {
            this.field41571.connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field24565, 101.0F));
         }
      } else if (var5 <= 6L) {
         if (var5 != 6L) {
            this.field41571.sendMessage(new TranslationTextComponent("demo.day." + var5), Util.DUMMY_UUID);
         } else {
            this.field41571.connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field24565, 104.0F));
         }
      }
   }

   private void method33857() {
      if (this.field41567 > 100) {
         this.field41571.sendMessage(new TranslationTextComponent("demo.reminder"), Util.DUMMY_UUID);
         this.field41567 = 0;
      }
   }

   @Override
   public void method33858(BlockPos var1, CPlayerDiggingPacket.Action var2, Direction var3, int var4) {
      if (!this.field41566) {
         super.method33858(var1, var2, var3, var4);
      } else {
         this.method33857();
      }
   }

   @Override
   public ActionResultType method33859(ServerPlayerEntity var1, World var2, ItemStack var3, Hand var4) {
      if (!this.field41566) {
         return super.method33859(var1, var2, var3, var4);
      } else {
         this.method33857();
         return ActionResultType.field14820;
      }
   }

   @Override
   public ActionResultType method33860(ServerPlayerEntity var1, World var2, ItemStack var3, Hand var4, BlockRayTraceResult var5) {
      if (!this.field41566) {
         return super.method33860(var1, var2, var3, var4, var5);
      } else {
         this.method33857();
         return ActionResultType.field14820;
      }
   }
}
