package mapped;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;

public class Class4704 implements Class4698 {
   public static final Codec<Class4704> field22317 = RecordCodecBuilder.create(
      var0 -> var0.group(
               BlockState.field31585.fieldOf("target").forGetter(var0x -> var0x.field22318),
               BlockState.field31585.fieldOf("state").forGetter(var0x -> var0x.field22319),
               Class8045.field34558.fieldOf("radius").forGetter(var0x -> var0x.field22320)
            )
            .apply(var0, Class4704::new)
   );
   public final BlockState field22318;
   public final BlockState field22319;
   private final Class8045 field22320;

   public Class4704(BlockState var1, BlockState var2, Class8045 var3) {
      this.field22318 = var1;
      this.field22319 = var2;
      this.field22320 = var3;
   }

   public Class8045 method14767() {
      return this.field22320;
   }
}
