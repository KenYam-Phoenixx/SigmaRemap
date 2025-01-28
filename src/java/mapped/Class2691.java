package mapped;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.RangedInteger;

import java.util.EnumSet;

public class Class2691<T extends MonsterEntity & Class1022 & ICrossbowUser> extends Class2595 {
   private static String[] field17123;
   public static final RangedInteger field17124 = new RangedInteger(20, 40);
   private final T field17125;
   private Class2229 field17126 = Class2229.field14613;
   private final double field17127;
   private final float field17128;
   private int field17129;
   private int field17130;
   private int field17131;

   public Class2691(T var1, double var2, float var4) {
      this.field17125 = (T)var1;
      this.field17127 = var2;
      this.field17128 = var4 * var4;
      this.method10809(EnumSet.<Class2240>of(Class2240.field14657, Class2240.field14658));
   }

   @Override
   public boolean method10803() {
      return this.method10908() && this.method10907();
   }

   private boolean method10907() {
      return this.field17125.method3092(Items.CROSSBOW);
   }

   @Override
   public boolean method10806() {
      return this.method10908() && (this.method10803() || !this.field17125.method4230().method21664()) && this.method10907();
   }

   private boolean method10908() {
      return this.field17125.getAttackTarget() != null && this.field17125.getAttackTarget().isAlive();
   }

   @Override
   public void method10807() {
      super.method10807();
      this.field17125.method4304(false);
      this.field17125.setAttackTarget((LivingEntity)null);
      this.field17129 = 0;
      if (this.field17125.isHandActive()) {
         this.field17125.resetActiveHand();
         this.field17125.method4535(false);
         CrossbowItem.method11756(this.field17125.getActiveItemStack(), false);
      }
   }

   @Override
   public void method10805() {
      LivingEntity var3 = this.field17125.getAttackTarget();
      if (var3 != null) {
         boolean var4 = this.field17125.method4231().method35460(var3);
         boolean var5 = this.field17129 > 0;
         if (var4 != var5) {
            this.field17129 = 0;
         }

         if (!var4) {
            this.field17129--;
         } else {
            this.field17129++;
         }

         double var6 = this.field17125.getDistanceSq(var3);
         boolean var8 = (var6 > (double)this.field17128 || this.field17129 < 5) && this.field17130 == 0;
         if (!var8) {
            this.field17131 = 0;
            this.field17125.method4230().method21666();
         } else {
            this.field17131--;
            if (this.field17131 <= 0) {
               this.field17125.method4230().method21655(var3, !this.method10909() ? this.field17127 * 0.5 : this.field17127);
               this.field17131 = field17124.method29319(this.field17125.getRNG());
            }
         }

         this.field17125.method4227().method28040(var3, 30.0F, 30.0F);
         if (this.field17126 != Class2229.field14613) {
            if (this.field17126 != Class2229.field14614) {
               if (this.field17126 != Class2229.field14615) {
                  if (this.field17126 == Class2229.field14616 && var4) {
                     this.field17125.method4530(var3, 1.0F);
                     ItemStack var9 = this.field17125.getHeldItem(ProjectileHelper.method36389(this.field17125, Items.CROSSBOW));
                     CrossbowItem.method11756(var9, false);
                     this.field17126 = Class2229.field14613;
                  }
               } else {
                  this.field17130--;
                  if (this.field17130 == 0) {
                     this.field17126 = Class2229.field14616;
                  }
               }
            } else {
               if (!this.field17125.isHandActive()) {
                  this.field17126 = Class2229.field14613;
               }

               int var11 = this.field17125.getItemInUseMaxCount();
               ItemStack var10 = this.field17125.getActiveItemStack();
               if (var11 >= CrossbowItem.method11767(var10)) {
                  this.field17125.stopActiveHand();
                  this.field17126 = Class2229.field14615;
                  this.field17130 = 20 + this.field17125.getRNG().nextInt(20);
                  this.field17125.method4535(false);
               }
            }
         } else if (!var8) {
            this.field17125.setActiveHand(ProjectileHelper.method36389(this.field17125, Items.CROSSBOW));
            this.field17126 = Class2229.field14614;
            this.field17125.method4535(true);
         }
      }
   }

   private boolean method10909() {
      return this.field17126 == Class2229.field14613;
   }
}
