package net.minecraft.client.network;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import mapped.*;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.ProtocolType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerPinger {
   private static final Splitter field41915 = Splitter.on('\u0000').limit(6);
   private static final Logger field41916 = LogManager.getLogger();
   private final List<NetworkManager> field41917 = Collections.<NetworkManager>synchronizedList(Lists.newArrayList());

   public void ping(ServerData var1, Runnable var2) throws UnknownHostException {
      Class9375 var5 = Class9375.method35574(var1.serverIP);
      NetworkManager var6 = NetworkManager.createNetworkManagerAndConnect(InetAddress.getByName(var5.method35572()), var5.method35573(), false);
      this.field41917.add(var6);
      var1.serverMOTD = new TranslationTextComponent("multiplayer.status.pinging");
      var1.pingToServer = -1L;
      var1.field33196 = null;
      var6.setNetHandler(new Class5113(this, var6, var1, var2));

      try {
         var6.sendPacket(new CHandshakePacket(var5.method35572(), var5.method35573(), ProtocolType.field9903));
         var6.sendPacket(new Class5566());
      } catch (Throwable var8) {
         field41916.error(var8);
      }
   }

   private void method34004(ServerData var1) {
      Class9375 var4 = Class9375.method35574(var1.serverIP);
      ((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group((EventLoopGroup) NetworkManager.CLIENT_NIO_EVENTLOOP.getValue())).handler(new Class7272(this, var4, var1)))
            .channel(NioSocketChannel.class))
         .connect(var4.method35572(), var4.method35573());
   }

   private static ITextComponent method34005(int var0, int var1) {
      return new StringTextComponent(Integer.toString(var0))
         .append(new StringTextComponent("/").mergeStyle(TextFormatting.DARK_GRAY))
         .appendString(Integer.toString(var1))
         .mergeStyle(TextFormatting.GRAY);
   }

   public void method34006() {
      synchronized (this.field41917) {
         Iterator var4 = this.field41917.iterator();

         while (var4.hasNext()) {
            NetworkManager var5 = (NetworkManager)var4.next();
            if (var5.isChannelOpen()) {
               var5.tick();
            } else {
               var4.remove();
               var5.handleDisconnection();
            }
         }
      }
   }

   public void method34007() {
      synchronized (this.field41917) {
         Iterator var4 = this.field41917.iterator();

         while (var4.hasNext()) {
            NetworkManager var5 = (NetworkManager)var4.next();
            if (var5.isChannelOpen()) {
               var4.remove();
               var5.closeChannel(new TranslationTextComponent("multiplayer.status.cancelled"));
            }
         }
      }
   }

   // $VF: synthetic method
   public static ITextComponent method34008(int var0, int var1) {
      return method34005(var0, var1);
   }

   // $VF: synthetic method
   public static Logger method34009() {
      return field41916;
   }

   // $VF: synthetic method
   public static void method34010(ServerPinger var0, ServerData var1) {
      var0.method34004(var1);
   }

   // $VF: synthetic method
   public static Splitter method34011() {
      return field41915;
   }
}
