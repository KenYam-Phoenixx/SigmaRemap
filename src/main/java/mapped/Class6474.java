package mapped;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;

import java.util.Optional;

public final class Class6474 implements Class6466<Optional<BlockPos>> {
   private static String[] field28421;

   public void method19646(PacketBuffer var1, Optional<BlockPos> var2) {
      var1.writeBoolean(var2.isPresent());
      if (var2.isPresent()) {
         var1.writeBlockPos((BlockPos)var2.get());
      }
   }

   public Optional<BlockPos> method19645(PacketBuffer var1) {
      return var1.readBoolean() ? Optional.<BlockPos>of(var1.readBlockPos()) : Optional.<BlockPos>empty();
   }

   public Optional<BlockPos> method19644(Optional<BlockPos> var1) {
      return var1;
   }
}
