package mapped;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class Class3314 extends Item {
   private static String[] field18824;

   public Class3314(Properties var1) {
      super(var1);
   }

   @Override
   public boolean method11726() {
      return true;
   }

   @Nullable
   public IPacket<?> method11858(ItemStack var1, World var2, PlayerEntity var3) {
      return null;
   }
}
