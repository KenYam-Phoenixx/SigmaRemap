package mapped;

import net.minecraft.util.SoundEvent;

public abstract class Class6333 extends Class6338 implements Class6341 {
   private boolean field27845;

   public Class6333(SoundEvent var1, SoundCategory var2) {
      super(var1, var2);
   }

   @Override
   public boolean method19270() {
      return this.field27845;
   }

   public final void method19271() {
      this.field27845 = true;
      this.field27861 = false;
   }
}
