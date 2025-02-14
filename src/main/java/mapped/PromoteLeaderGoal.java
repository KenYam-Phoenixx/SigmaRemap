package mapped;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.raid.Raid;

import java.util.EnumSet;
import java.util.List;

public class PromoteLeaderGoal<T extends AbstractRaiderEntity> extends Class2595 {
   private static String[] field17054;
   private final T field17055;
   public final AbstractRaiderEntity field17056;

   public PromoteLeaderGoal(T var1, AbstractRaiderEntity var2) {
      this.field17056 = var1;
      this.field17055 = (T)var2;
      this.method10809(EnumSet.<Class2240>of(Class2240.field14657));
   }

   @Override
   public boolean method10803() {
      Raid var3 = this.field17055.method4551();
      if (this.field17055.method4552()
         && !this.field17055.method4551().method25388()
         && this.field17055.method4570()
         && !ItemStack.areItemStacksEqual(this.field17055.getItemStackFromSlot(EquipmentSlotType.HEAD), Raid.method25421())) {
         AbstractRaiderEntity var4 = var3.method25422(this.field17055.method4554());
         if (var4 == null || !var4.isAlive()) {
            List var5 = this.field17055
               .world
               .<ItemEntity>getEntitiesInAABBexcluding(ItemEntity.class, this.field17055.getBoundingBox().grow(16.0, 8.0, 16.0), AbstractRaiderEntity.method4566());
            if (!var5.isEmpty()) {
               return this.field17055.method4230().method21655((Entity)var5.get(0), 1.15F);
            }
         }

         return false;
      } else {
         return false;
      }
   }

   @Override
   public void method10805() {
      if (this.field17055.method4230().method21643().withinDistance(this.field17055.getPositionVec(), 1.414)) {
         List var3 = this.field17055
            .world
            .<ItemEntity>getEntitiesInAABBexcluding(ItemEntity.class, this.field17055.getBoundingBox().grow(4.0, 4.0, 4.0), AbstractRaiderEntity.method4566());
         if (!var3.isEmpty()) {
            this.field17055.method4246((ItemEntity)var3.get(0));
         }
      }
   }
}
