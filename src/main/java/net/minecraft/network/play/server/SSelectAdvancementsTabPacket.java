package net.minecraft.network.play.server;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.network.play.IClientPlayNetHandler;
import net.minecraft.network.IPacket;

import java.io.IOException;
import javax.annotation.Nullable;

public class SSelectAdvancementsTabPacket implements IPacket<IClientPlayNetHandler> {
   private static String[] field24462;
   private ResourceLocation field24463;

   public SSelectAdvancementsTabPacket() {
   }

   public SSelectAdvancementsTabPacket(ResourceLocation var1) {
      this.field24463 = var1;
   }

   public void processPacket(IClientPlayNetHandler var1) {
      var1.handleSelectAdvancementsTab(this);
   }

   @Override
   public void readPacketData(PacketBuffer var1) throws IOException {
      if (var1.readBoolean()) {
         this.field24463 = var1.readResourceLocation();
      }
   }

   @Override
   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeBoolean(this.field24463 != null);
      if (this.field24463 != null) {
         var1.writeResourceLocation(this.field24463);
      }
   }

   @Nullable
   public ResourceLocation method17335() {
      return this.field24463;
   }
}
