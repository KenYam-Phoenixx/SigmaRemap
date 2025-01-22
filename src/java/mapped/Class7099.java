package mapped;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nullable;

public class Class7099 extends Class7092 {
   public static final Codec<Class7099> field30538 = Codec.unit(() -> Class7099.field30539);
   public static final Class7099 field30539 = new Class7099();

   private Class7099() {
   }

   @Nullable
   @Override
   public Class8266 method22068(IWorldReader var1, BlockPos var2, BlockPos var3, Class8266 var4, Class8266 var5, Class9463 var6) {
      BlockState var9 = var5.field35531;
      if (var9.isIn(Blocks.JIGSAW)) {
         String var10 = var5.field35532.getString("final_state");
         Class8268 var11 = new Class8268(new StringReader(var10), false);

         try {
            var11.method28840(true);
         } catch (CommandSyntaxException var13) {
            throw new RuntimeException(var13);
         }

         return var11.method28837().isIn(Blocks.field36894) ? null : new Class8266(var5.field35530, var11.method28837(), (CompoundNBT)null);
      } else {
         return var5;
      }
   }

   @Override
   public Class7525<?> method22069() {
      return Class7525.field32297;
   }
}
