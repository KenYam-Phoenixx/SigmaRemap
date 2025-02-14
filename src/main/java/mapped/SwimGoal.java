package mapped;

import java.util.EnumSet;

public class SwimGoal extends Class2595 {
   private static String[] field16848;
   private final MobEntity field16849;

   public SwimGoal(MobEntity var1) {
      this.field16849 = var1;
      this.method10809(EnumSet.<Class2240>of(Class2240.field14659));
      var1.method4230().method21674(true);
   }

   @Override
   public boolean method10803() {
      return this.field16849.isInWater() && this.field16849.method3427(FluidTags.WATER) > this.field16849.func_233579_cu_() || this.field16849.isInLava();
   }

   @Override
   public void method10805() {
      if (this.field16849.getRNG().nextFloat() < 0.8F) {
         this.field16849.method4229().method27049();
      }
   }
}
