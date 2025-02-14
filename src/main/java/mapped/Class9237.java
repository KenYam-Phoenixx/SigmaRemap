package mapped;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioFormat.Encoding;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.ALC10;

public class Class9237 {
   private static final Logger field42514 = LogManager.getLogger();

   private static String method34744(int var0) {
      switch (var0) {
         case 40961:
            return "Invalid name parameter.";
         case 40962:
            return "Invalid enumerated parameter value.";
         case 40963:
            return "Invalid parameter parameter value.";
         case 40964:
            return "Invalid operation.";
         case 40965:
            return "Unable to allocate memory.";
         default:
            return "An unrecognized error occurred.";
      }
   }

   public static boolean method34745(String var0) {
      int var3 = AL10.alGetError();
      if (var3 == 0) {
         return false;
      } else {
         field42514.error("{}: {}", var0, method34744(var3));
         return true;
      }
   }

   private static String method34746(int var0) {
      switch (var0) {
         case 40961:
            return "Invalid device.";
         case 40962:
            return "Invalid context.";
         case 40963:
            return "Illegal enum.";
         case 40964:
            return "Invalid value.";
         case 40965:
            return "Unable to allocate memory.";
         default:
            return "An unrecognized error occurred.";
      }
   }

   public static boolean method34747(long var0, String var2) {
      int var5 = ALC10.alcGetError(var0);
      if (var5 == 0) {
         return false;
      } else {
         field42514.error("{}{}: {}", var2, var0, method34746(var5));
         return true;
      }
   }

   public static int method34748(AudioFormat var0) {
      Encoding var3 = var0.getEncoding();
      int var4 = var0.getChannels();
      int var5 = var0.getSampleSizeInBits();
      if (var3.equals(Encoding.PCM_UNSIGNED) || var3.equals(Encoding.PCM_SIGNED)) {
         if (var4 != 1) {
            if (var4 == 2) {
               if (var5 == 8) {
                  return 4354;
               }

               if (var5 == 16) {
                  return 4355;
               }
            }
         } else {
            if (var5 == 8) {
               return 4352;
            }

            if (var5 == 16) {
               return 4353;
            }
         }
      }

      throw new IllegalArgumentException("Invalid audio format: " + var0);
   }
}
