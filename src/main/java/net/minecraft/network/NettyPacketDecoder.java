package net.minecraft.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class NettyPacketDecoder extends ByteToMessageDecoder {
   private static final Logger field36043 = LogManager.getLogger();
   private static final Marker field36044 = MarkerManager.getMarker("PACKET_RECEIVED", NetworkManager.NETWORK_PACKETS_MARKER);
   private final PacketDirection field36045;

   public NettyPacketDecoder(PacketDirection var1) {
      this.field36045 = var1;
   }

   public void decode(ChannelHandlerContext var1, ByteBuf var2, List<Object> var3) throws Exception {
      if (var2.readableBytes() != 0) {
         PacketBuffer var6 = new PacketBuffer(var2);
         int var7 = var6.readVarInt();
         IPacket var8 = ((ProtocolType)var1.channel().attr(NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get()).method8103(this.field36045, var7);
         if (var8 == null) {
            throw new IOException("Bad packet id " + var7);
         }

         var8.readPacketData(var6);
         if (var6.readableBytes() > 0) {
            throw new IOException(
               "Packet "
                  + ((ProtocolType)var1.channel().attr(NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get()).method8104()
                  + "/"
                  + var7
                  + " ("
                  + var8.getClass().getSimpleName()
                  + ") was larger than I expected, found "
                  + var6.readableBytes()
                  + " bytes extra whilst reading packet "
                  + var7
            );
         }

         var3.add(var8);
         if (field36043.isDebugEnabled()) {
            field36043.debug(field36044, " IN: [{}:{}] {}", var1.channel().attr(NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get(), var7, var8.getClass().getName());
         }
      }
   }
}
