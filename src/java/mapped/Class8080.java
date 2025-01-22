package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class Class8080 implements IAmbientSoundHandler {
   private static String[] field34729;
   private final ClientPlayerEntity field34730;
   private boolean field34731;
   private boolean field34732 = true;

   public Class8080(ClientPlayerEntity var1) {
      this.field34730 = var1;
   }

   @Override
   public void tick() {
      World var3 = this.field34730.world;
      BlockState var4 = var3.method7004(this.field34730.getBoundingBox().grow(0.0, -0.4F, 0.0).shrink(0.001))
         .filter(var0 -> var0.isIn(Blocks.BUBBLE_COLUMN))
         .findFirst()
         .orElse((BlockState)null);
      if (var4 == null) {
         this.field34731 = false;
      } else {
         if (!this.field34731 && !this.field34732 && var4.isIn(Blocks.BUBBLE_COLUMN) && !this.field34730.isSpectator()) {
            boolean var5 = var4.<Boolean>get(Class3406.field19084);
            if (!var5) {
               this.field34730.playSound(SoundEvents.field26423, 1.0F, 1.0F);
            } else {
               this.field34730.playSound(SoundEvents.field26425, 1.0F, 1.0F);
            }
         }

         this.field34731 = true;
      }

      this.field34732 = false;
   }
}
