package mapped;

import net.minecraft.entity.LivingEntity;

import java.util.function.Predicate;

public class EntityPredicate {
   private static String[] field38239;
   public static final EntityPredicate field38240 = new EntityPredicate();
   private double field38241 = -1.0;
   private boolean field38242;
   private boolean field38243;
   private boolean field38244;
   private boolean field38245;
   private boolean field38246 = true;
   private Predicate<LivingEntity> field38247;

   public EntityPredicate method30203(double var1) {
      this.field38241 = var1;
      return this;
   }

   public EntityPredicate method30204() {
      this.field38242 = true;
      return this;
   }

   public EntityPredicate method30205() {
      this.field38243 = true;
      return this;
   }

   public EntityPredicate method30206() {
      this.field38244 = true;
      return this;
   }

   public EntityPredicate method30207() {
      this.field38245 = true;
      return this;
   }

   public EntityPredicate method30208() {
      this.field38246 = false;
      return this;
   }

   public EntityPredicate method30209(Predicate<LivingEntity> var1) {
      this.field38247 = var1;
      return this;
   }

   public boolean canTarget(LivingEntity var1, LivingEntity var2) {
      if (var1 != var2) {
         if (!var2.isSpectator()) {
            if (var2.isAlive()) {
               if (!this.field38242 && var2.method3362()) {
                  return false;
               } else if (this.field38247 != null && !this.field38247.test(var2)) {
                  return false;
               } else {
                  if (var1 != null) {
                     if (!this.field38245) {
                        if (!var1.canAttack(var2)) {
                           return false;
                        }

                        if (!var1.canAttack(var2.getType())) {
                           return false;
                        }
                     }

                     if (!this.field38243 && var1.isOnSameTeam(var2)) {
                        return false;
                     }

                     if (this.field38241 > 0.0) {
                        double var5 = !this.field38246 ? 1.0 : var2.getVisibilityMultiplier(var1);
                        double var7 = Math.max(this.field38241 * var5, 2.0);
                        double var9 = var1.getDistanceSq(var2.getPosX(), var2.getPosY(), var2.getPosZ());
                        if (var9 > var7 * var7) {
                           return false;
                        }
                     }

                     if (!this.field38244 && var1 instanceof MobEntity && !((MobEntity)var1).method4231().method35460(var2)) {
                        return false;
                     }
                  }

                  return true;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }
}
