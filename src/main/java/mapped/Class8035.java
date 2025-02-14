package mapped;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class Class8035 extends Class8033 {
   public static final Codec<Class8035> field34523 = RecordCodecBuilder.create(
      var0 -> var0.group(
               Codec.FLOAT.fieldOf("min_chance").orElse(0.0F).forGetter(var0x -> var0x.field34524),
               Codec.FLOAT.fieldOf("max_chance").orElse(0.0F).forGetter(var0x -> var0x.field34525),
               Codec.INT.fieldOf("min_dist").orElse(0).forGetter(var0x -> var0x.field34526),
               Codec.INT.fieldOf("max_dist").orElse(0).forGetter(var0x -> var0x.field34527),
               Direction.Axis.CODEC.fieldOf("axis").orElse(Direction.Axis.Y).forGetter(var0x -> var0x.field34528)
            )
            .apply(var0, Class8035::new)
   );
   private final float field34524;
   private final float field34525;
   private final int field34526;
   private final int field34527;
   private final Direction.Axis field34528;

   public Class8035(float var1, float var2, int var3, int var4, Direction.Axis var5) {
      if (var3 < var4) {
         this.field34524 = var1;
         this.field34525 = var2;
         this.field34526 = var3;
         this.field34527 = var4;
         this.field34528 = var5;
      } else {
         throw new IllegalArgumentException("Invalid range: [" + var3 + "," + var4 + "]");
      }
   }

   @Override
   public boolean method27553(BlockPos var1, BlockPos var2, BlockPos var3, Random var4) {
      Direction var7 = Direction.getFacingFromAxis(Direction.AxisDirection.POSITIVE, this.field34528);
      float var8 = (float)Math.abs((var2.getX() - var3.getX()) * var7.getXOffset());
      float var9 = (float)Math.abs((var2.getY() - var3.getY()) * var7.getYOffset());
      float var10 = (float)Math.abs((var2.getZ() - var3.getZ()) * var7.getZOffset());
      int var11 = (int)(var8 + var9 + var10);
      float var12 = var4.nextFloat();
      return (double)var12
         <= MathHelper.method37779(
            (double)this.field34524, (double)this.field34525, MathHelper.method37813((double)var11, (double)this.field34526, (double)this.field34527)
         );
   }

   @Override
   public Class8989<?> method27554() {
      return Class8989.field41003;
   }
}
