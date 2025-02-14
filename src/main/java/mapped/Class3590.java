package mapped;

import com.google.common.collect.ComparisonChain;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.world.GameType;

import java.util.Comparator;

public class Class3590 implements Comparator<NetworkPlayerInfo> {
   public Class3590() {
   }

   public int compare(NetworkPlayerInfo var1, NetworkPlayerInfo var2) {
      ScorePlayerTeam var5 = var1.method19976();
      ScorePlayerTeam var6 = var2.method19976();
      return ComparisonChain.start()
         .compareTrueFirst(var1.method19967() != GameType.SPECTATOR, var2.method19967() != GameType.SPECTATOR)
         .compare(var5 == null ? "" : var5.method28567(), var6 == null ? "" : var6.method28567())
         .compare(var1.method19966().getName(), var2.method19966().getName(), String::compareToIgnoreCase)
         .result();
   }
}
