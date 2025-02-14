package mapped;

import com.google.common.collect.Maps;
import java.util.EnumMap;
import java.util.function.Supplier;

import net.minecraft.util.Util;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Class8539 {
   private static String[] field38385;
   private static final Logger field38386 = LogManager.getLogger();
   public static final EnumMap<Direction, Class6979> field38387 = Util.<EnumMap<Direction, Class6979>>make(
      Maps.newEnumMap(Direction.class),
      var0 -> {
         var0.put(Direction.SOUTH, Class6979.method21542());
         var0.put(
            Direction.EAST, new Class6979((Vector3f)null, new Quaternion(new Vector3f(0.0F, 1.0F, 0.0F), 90.0F, true), (Vector3f)null, (Quaternion)null)
         );
         var0.put(
            Direction.WEST, new Class6979((Vector3f)null, new Quaternion(new Vector3f(0.0F, 1.0F, 0.0F), -90.0F, true), (Vector3f)null, (Quaternion)null)
         );
         var0.put(
            Direction.NORTH, new Class6979((Vector3f)null, new Quaternion(new Vector3f(0.0F, 1.0F, 0.0F), 180.0F, true), (Vector3f)null, (Quaternion)null)
         );
         var0.put(
            Direction.UP, new Class6979((Vector3f)null, new Quaternion(new Vector3f(1.0F, 0.0F, 0.0F), -90.0F, true), (Vector3f)null, (Quaternion)null)
         );
         var0.put(
            Direction.DOWN, new Class6979((Vector3f)null, new Quaternion(new Vector3f(1.0F, 0.0F, 0.0F), 90.0F, true), (Vector3f)null, (Quaternion)null)
         );
      }
   );
   public static final EnumMap<Direction, Class6979> field38388 = Util.<EnumMap<Direction, Class6979>>make(Maps.newEnumMap(Direction.class), var0 -> {
      for (Direction var6 : Direction.values()) {
         var0.put(var6, field38387.get(var6).method21544());
      }
   });

   public static Class6979 method30383(Class6979 var0) {
      Matrix4f var3 = Matrix4f.method35516(0.5F, 0.5F, 0.5F);
      var3.method35508(var0.method21548());
      var3.method35508(Matrix4f.method35516(-0.5F, -0.5F, -0.5F));
      return new Class6979(var3);
   }

   public static Class6979 method30384(Class6979 var0, Direction var1, Supplier<String> var2) {
      Direction var5 = Direction.method531(var0.method21548(), var1);
      Class6979 var6 = var0.method21544();
      if (var6 != null) {
         Class6979 var7 = field38388.get(var1).method21543(var6).method21543(field38387.get(var5));
         return method30383(var7);
      } else {
         field38386.warn((String)var2.get());
         return new Class6979((Vector3f)null, (Quaternion)null, new Vector3f(0.0F, 0.0F, 0.0F), (Quaternion)null);
      }
   }
}
