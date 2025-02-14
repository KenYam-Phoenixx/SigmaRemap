package mapped;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;

public final class Class6866 implements IParticleData.IDeserializer<Class7438> {
   private static String[] field29791;

   public Class7438 deserialize(ParticleType<Class7438> var1, StringReader var2) throws CommandSyntaxException {
      var2.expect(' ');
      Class9759 var5 = new Class9759(var2, false).method38359();
      ItemStack var6 = new Class176(var5.method38353(), var5.method38354()).method503(1, false);
      return new Class7438(var1, var6);
   }

   public Class7438 read(ParticleType<Class7438> var1, PacketBuffer var2) {
      return new Class7438(var1, var2.readItemStack());
   }
}
