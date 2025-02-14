package mapped;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.TameableEntity;

import java.util.function.Predicate;

public class Class2716<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
   private static String[] field17187;
   private final TameableEntity field17205;

   public Class2716(TameableEntity var1, Class<T> var2, boolean var3, Predicate<LivingEntity> var4) {
      super(var1, var2, 10, var3, false, var4);
      this.field17205 = var1;
   }

   @Override
   public boolean method10803() {
      return !this.field17205.method4393() && super.method10803();
   }

   @Override
   public boolean method10806() {
      return this.field17191 == null ? super.method10806() : this.field17191.canTarget(this.field17153, this.field17190);
   }
}
