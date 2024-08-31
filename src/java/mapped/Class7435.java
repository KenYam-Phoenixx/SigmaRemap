package mapped;

import com.mojang.serialization.Codec;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;

public class Class7435 extends ParticleType<Class7435> implements IParticleData {
   private static String[] field31997;
   private static final Class6865<Class7435> field31998 = new Class6868();
   private final Codec<Class7435> field31999 = Codec.unit(this::getType);

   public Class7435(boolean var1) {
      super(var1, field31998);
   }

   public Class7435 getType() {
      return this;
   }

   @Override
   public Codec<Class7435> method24005() {
      return this.field31999;
   }

   @Override
   public void write(PacketBuffer var1) {
   }

   @Override
   public String method24010() {
      return Registry.PARTICLE_TYPE.getKey(this).toString();
   }
}
