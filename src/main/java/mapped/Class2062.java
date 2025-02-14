package mapped;

import com.google.common.collect.Maps;
import net.minecraft.util.Util;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.vector.Vector3d;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.function.BiFunction;

public enum Class2062 {
   field13441("feet", (var0, var1) -> var0),
   field13442("eyes", (var0, var1) -> new Vector3d(var0.x, var0.y + (double)var1.getEyeHeight(), var0.z));

   private static final Map<String, Class2062> field13443 = Util.<Map<String, Class2062>>make(Maps.newHashMap(), var0 -> {
      for (Class2062 var6 : values()) {
         var0.put(var6.field13444, var6);
      }
   });
   private final String field13444;
   private final BiFunction<Vector3d, Entity, Vector3d> field13445;
   private static final Class2062[] field13446 = new Class2062[]{field13441, field13442};

   private Class2062(String var3, BiFunction<Vector3d, Entity, Vector3d> var4) {
      this.field13444 = var3;
      this.field13445 = var4;
   }

   @Nullable
   public static Class2062 method8710(String var0) {
      return field13443.get(var0);
   }

   public Vector3d method8711(Entity var1) {
      return this.field13445.apply(var1.getPositionVec(), var1);
   }

   public Vector3d method8712(CommandSource var1) {
      Entity var4 = var1.method20173();
      return var4 != null ? this.field13445.apply(var1.method20171(), var4) : var1.method20171();
   }

   // $VF: synthetic method
   public static Map method8716() {
      return field13443;
   }
}
