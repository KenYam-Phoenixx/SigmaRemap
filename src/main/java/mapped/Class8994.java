package mapped;

import net.minecraft.world.Difficulty;

// $VF: synthetic class
public class Class8994 {
   private static String[] field41133;
   public static final int[] field41134;
   public static final int[] field41135 = new int[Difficulty.values().length];

   static {
      try {
         field41135[Difficulty.EASY.ordinal()] = 1;
      } catch (NoSuchFieldError var9) {
      }

      try {
         field41135[Difficulty.NORMAL.ordinal()] = 2;
      } catch (NoSuchFieldError var8) {
      }

      try {
         field41135[Difficulty.HARD.ordinal()] = 3;
      } catch (NoSuchFieldError var7) {
      }

      field41134 = new int[Class2127.values().length];

      try {
         field41134[Class2127.field13880.ordinal()] = 1;
      } catch (NoSuchFieldError var6) {
      }

      try {
         field41134[Class2127.field13879.ordinal()] = 2;
      } catch (NoSuchFieldError var5) {
      }

      try {
         field41134[Class2127.field13877.ordinal()] = 3;
      } catch (NoSuchFieldError var4) {
      }

      try {
         field41134[Class2127.field13881.ordinal()] = 4;
      } catch (NoSuchFieldError var3) {
      }
   }
}
