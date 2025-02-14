package mapped;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class Class7098 extends Class7092 {
   public static final Codec<Class7098> field30535 = RecordCodecBuilder.create(
      var0 -> var0.group(
               Heightmap.Type.field301.fieldOf("heightmap").orElse(Heightmap.Type.WORLD_SURFACE_WG).forGetter(var0x -> var0x.field30536),
               Codec.INT.fieldOf("offset").orElse(0).forGetter(var0x -> var0x.field30537)
            )
            .apply(var0, Class7098::new)
   );
   private final Heightmap.Type field30536;
   private final int field30537;

   public Class7098(Heightmap.Type var1, int var2) {
      this.field30536 = var1;
      this.field30537 = var2;
   }

   @Nullable
   @Override
   public Class8266 method22068(IWorldReader var1, BlockPos var2, BlockPos var3, Class8266 var4, Class8266 var5, Class9463 var6) {
      Heightmap.Type var9;
      if (!(var1 instanceof ServerWorld)) {
         var9 = this.field30536;
      } else if (this.field30536 != Heightmap.Type.WORLD_SURFACE_WG) {
         if (this.field30536 != Heightmap.Type.OCEAN_FLOOR_WG) {
            var9 = this.field30536;
         } else {
            var9 = Heightmap.Type.OCEAN_FLOOR;
         }
      } else {
         var9 = Heightmap.Type.WORLD_SURFACE;
      }

      int var10 = var1.method6736(var9, var5.field35530.getX(), var5.field35530.getZ()) + this.field30537;
      int var11 = var4.field35530.getY();
      return new Class8266(new BlockPos(var5.field35530.getX(), var10 + var11, var5.field35530.getZ()), var5.field35531, var5.field35532);
   }

   @Override
   public Class7525<?> method22069() {
      return Class7525.field32296;
   }
}
