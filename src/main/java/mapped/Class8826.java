package mapped;

import net.minecraft.pathfinding.PathType;
import net.minecraft.util.Direction;

// $VF: synthetic class
public class Class8826 {
   private static String[] field39789;
   public static final int[] field39790;
   public static final int[] field39791 = new int[PathType.values().length];

   static {
      try {
         field39791[PathType.field12614.ordinal()] = 1;
      } catch (NoSuchFieldError var9) {
      }

      try {
         field39791[PathType.field12615.ordinal()] = 2;
      } catch (NoSuchFieldError var8) {
      }

      try {
         field39791[PathType.AIR.ordinal()] = 3;
      } catch (NoSuchFieldError var7) {
      }

      field39790 = new int[Direction.values().length];

      try {
         field39790[Direction.NORTH.ordinal()] = 1;
      } catch (NoSuchFieldError var6) {
      }

      try {
         field39790[Direction.SOUTH.ordinal()] = 2;
      } catch (NoSuchFieldError var5) {
      }

      try {
         field39790[Direction.WEST.ordinal()] = 3;
      } catch (NoSuchFieldError var4) {
      }

      try {
         field39790[Direction.EAST.ordinal()] = 4;
      } catch (NoSuchFieldError var3) {
      }
   }
}
