package mapped;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.StringUtils;
import net.minecraft.util.math.MathHelper;

public final class Class7182 {
   public static String method22535(EffectInstance var0, float var1) {
      if (!var0.method8642()) {
         int var4 = MathHelper.floor((float)var0.method8628() * var1);
         return StringUtils.ticksToElapsedTime(var4);
      } else {
         return "**:**";
      }
   }

   public static boolean method22536(LivingEntity var0) {
      return var0.isPotionActive(Effects.HASTE) || var0.isPotionActive(Effects.CONDUIT_POWER);
   }

   public static int method22537(LivingEntity var0) {
      int var3 = 0;
      int var4 = 0;
      if (var0.isPotionActive(Effects.HASTE)) {
         var3 = var0.getActivePotionEffect(Effects.HASTE).getAmplifier();
      }

      if (var0.isPotionActive(Effects.CONDUIT_POWER)) {
         var4 = var0.getActivePotionEffect(Effects.CONDUIT_POWER).getAmplifier();
      }

      return Math.max(var3, var4);
   }

   public static boolean method22538(LivingEntity var0) {
      return var0.isPotionActive(Effects.WATER_BREATHING) || var0.isPotionActive(Effects.CONDUIT_POWER);
   }
}
