package net.minecraft.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mapped.ParticleTypes;
import net.minecraft.particles.IParticleData;

import java.util.Random;

public class ParticleEffectAmbience {
   public static final Codec<ParticleEffectAmbience> field33229 = RecordCodecBuilder.create(
      var0 -> var0.group(
               ParticleTypes.field34120.fieldOf("options").forGetter(var0x -> var0x.field33230),
               Codec.FLOAT.fieldOf("probability").forGetter(var0x -> var0x.field33231)
            )
            .apply(var0, ParticleEffectAmbience::new)
   );
   private final IParticleData field33230;
   private final float field33231;

   public ParticleEffectAmbience(IParticleData var1, float var2) {
      this.field33230 = var1;
      this.field33231 = var2;
   }

   public IParticleData method25614() {
      return this.field33230;
   }

   public boolean method25615(Random var1) {
      return var1.nextFloat() <= this.field33231;
   }
}
