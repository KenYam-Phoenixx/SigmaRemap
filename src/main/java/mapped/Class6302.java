package mapped;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Class6302 extends Class6272<Class4719> {
   public Class6302(Codec<Class4719> var1) {
      super(var1);
   }

   public Stream<BlockPos> method19240(Class9010 var1, Random var2, Class4719 var3, BlockPos var4) {
      double var7 = Biome.INFO_NOISE.noiseAt((double)var4.getX() / 200.0, (double)var4.getZ() / 200.0, false);
      int var9 = !(var7 < var3.field22370) ? var3.field22372 : var3.field22371;
      return IntStream.range(0, var9).<BlockPos>mapToObj(var1x -> var4);
   }
}
