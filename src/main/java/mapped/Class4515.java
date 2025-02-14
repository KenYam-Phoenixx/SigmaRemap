package mapped;

import com.mojang.blaze3d.systems.RenderSystem;

public final class Class4515 extends Class4513 {
   private final float field21786;
   private final float field21787;

   public Class4515(float var1, float var2) {
      super("offset_texturing", () -> {
         RenderSystem.matrixMode(5890);
         RenderSystem.pushMatrix();
         RenderSystem.loadIdentity();
         RenderSystem.translatef(var1, var2, 0.0F);
         RenderSystem.matrixMode(5888);
      }, () -> {
         RenderSystem.matrixMode(5890);
         RenderSystem.popMatrix();
         RenderSystem.matrixMode(5888);
      });
      this.field21786 = var1;
      this.field21787 = var2;
   }

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         Class4515 var4 = (Class4515)var1;
         return Float.compare(var4.field21786, this.field21786) == 0 && Float.compare(var4.field21787, this.field21787) == 0;
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return Class8589.method30727(this.field21786, this.field21787);
   }
}
