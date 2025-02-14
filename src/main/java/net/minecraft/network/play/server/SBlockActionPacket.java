package net.minecraft.network.play.server;

import net.minecraft.block.Block;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.registry.Registry;
import net.minecraft.client.network.play.IClientPlayNetHandler;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;

import java.io.IOException;

public class SBlockActionPacket implements IPacket<IClientPlayNetHandler> {
   private static String[] field24391;
   private BlockPos field24392;
   private int field24393;
   private int field24394;
   private Block field24395;

   public SBlockActionPacket() {
   }

   public SBlockActionPacket(BlockPos var1, Block var2, int var3, int var4) {
      this.field24392 = var1;
      this.field24395 = var2;
      this.field24393 = var3;
      this.field24394 = var4;
   }

   @Override
   public void readPacketData(PacketBuffer var1) throws IOException {
      this.field24392 = var1.readBlockPos();
      this.field24393 = var1.readUnsignedByte();
      this.field24394 = var1.readUnsignedByte();
      this.field24395 = Registry.BLOCK.getByValue(var1.readVarInt());
   }

   @Override
   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeBlockPos(this.field24392);
      var1.writeByte(this.field24393);
      var1.writeByte(this.field24394);
      var1.writeVarInt(Registry.BLOCK.getId(this.field24395));
   }

   public void processPacket(IClientPlayNetHandler var1) {
      var1.handleBlockAction(this);
   }

   public BlockPos method17278() {
      return this.field24392;
   }

   public int method17279() {
      return this.field24393;
   }

   public int method17280() {
      return this.field24394;
   }

   public Block method17281() {
      return this.field24395;
   }
}
