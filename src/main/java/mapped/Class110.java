package mapped;

import com.mojang.serialization.Codec;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Class110 implements IStringSerializable {
   WARM("warm"),
   COLD("cold");

   public static final Codec<Class110> field375 = IStringSerializable.<Class110>createEnumCodec(Class110::values, Class110::method306);
   private static final Map<String, Class110> field376 = Arrays.<Class110>stream(values())
      .collect(Collectors.toMap(Class110::method305, var0 -> (Class110)var0));
   private final String field377;
   private static final Class110[] field378 = new Class110[]{WARM, COLD};

   private Class110(String var3) {
      this.field377 = var3;
   }

   public String method305() {
      return this.field377;
   }

   @Nullable
   public static Class110 method306(String var0) {
      return field376.get(var0);
   }

   @Override
   public String getString() {
      return this.field377;
   }
}
