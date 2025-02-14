package net.minecraft.network.play.server;

import net.minecraft.network.PacketBuffer;
import net.minecraft.client.network.play.IClientPlayNetHandler;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;

import java.io.IOException;

public class SOpenSignMenuPacket implements IPacket<IClientPlayNetHandler> {
   private static String[] field24379;
   private BlockPos field24380;

   public SOpenSignMenuPacket() {
   }

   public SOpenSignMenuPacket(BlockPos var1) {
      this.field24380 = var1;
   }

   public void processPacket(IClientPlayNetHandler var1) {
      var1.handleSignEditorOpen(this);
   }

   @Override
   public void readPacketData(PacketBuffer var1) throws IOException {
      this.field24380 = var1.readBlockPos();
   }

   @Override
   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeBlockPos(this.field24380);
   }

   public BlockPos method17271() {
      return this.field24380;
   }
}
