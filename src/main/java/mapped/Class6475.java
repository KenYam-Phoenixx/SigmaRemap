package mapped;

import net.minecraft.entity.Pose;
import net.minecraft.network.PacketBuffer;

public final class Class6475 implements Class6466<Pose> {
   private static String[] field28422;

   public void method19646(PacketBuffer var1, Pose var2) {
      var1.writeEnumValue(var2);
   }

   public Pose method19645(PacketBuffer var1) {
      return var1.<Pose>readEnumValue(Pose.class);
   }

   public Pose method19644(Pose var1) {
      return var1;
   }
}
