package mapped;

import net.minecraft.util.Direction;

// $VF: synthetic class
public class Class8024 {
   private static String[] field34485;
   public static final int[] field34486;
   public static final int[] field34487 = new int[Direction.values().length];

   static {
      try {
         field34487[Direction.EAST.ordinal()] = 1;
      } catch (NoSuchFieldError var11) {
      }

      try {
         field34487[Direction.WEST.ordinal()] = 2;
      } catch (NoSuchFieldError var10) {
      }

      try {
         field34487[Direction.UP.ordinal()] = 3;
      } catch (NoSuchFieldError var9) {
      }

      try {
         field34487[Direction.DOWN.ordinal()] = 4;
      } catch (NoSuchFieldError var8) {
      }

      try {
         field34487[Direction.SOUTH.ordinal()] = 5;
      } catch (NoSuchFieldError var7) {
      }

      try {
         field34487[Direction.NORTH.ordinal()] = 6;
      } catch (NoSuchFieldError var6) {
      }

      field34486 = new int[Direction.Axis.values().length];

      try {
         field34486[Direction.Axis.X.ordinal()] = 1;
      } catch (NoSuchFieldError var5) {
      }

      try {
         field34486[Direction.Axis.Y.ordinal()] = 2;
      } catch (NoSuchFieldError var4) {
      }

      try {
         field34486[Direction.Axis.Z.ordinal()] = 3;
      } catch (NoSuchFieldError var3) {
      }
   }
}
