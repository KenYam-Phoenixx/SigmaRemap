package mapped;

import com.mentalfrostbyte.jello.unmapped.CustomGuiScreen;
import com.mentalfrostbyte.jello.util.MultiUtilities;
import com.mentalfrostbyte.jello.util.ClientColors;

import java.util.ArrayList;
import java.util.List;

public class VolumeSlider extends Class4247 {
   private static String[] field21371;
   private float field21372 = 1.0F;
   private boolean field21373 = false;
   private final List<Class6649> field21374 = new ArrayList<Class6649>();

   public VolumeSlider(CustomGuiScreen var1, String var2, int var3, int var4, int var5, int var6) {
      super(var1, var2, var3, var4, var5, var6, false);
   }

   @Override
   public void draw(float var1) {
      RenderUtil.drawRect(
            (float) this.xA,
            (float) this.yA,
            (float) (this.xA + this.widthA),
            (float) this.yA + (float) this.heightA * this.field21372,
            MultiUtilities.applyAlpha(ClientColors.DEEP_TEAL.getColor(), 0.2F));
      RenderUtil.drawRect(
            (float) this.xA,
            (float) (this.yA + this.heightA),
            (float) (this.xA + this.widthA),
            (float) this.yA + (float) this.heightA * this.field21372,
            MultiUtilities.applyAlpha(ClientColors.LIGHT_GREYISH_BLUE.getColor(), 0.2F));
      super.draw(var1);
   }

   @Override
   public boolean onClick(int mouseX, int mouseY, int mouseButton) {
      if (!super.onClick(this.xA, this.yA, mouseButton)) {
         this.field21373 = true;
         return false;
      } else {
         return true;
      }
   }

   public float method13706(int var1) {
      return (float) (var1 - this.method13272()) / (float) this.heightA;
   }

   @Override
   public void method13028(int var1, int var2) {
      super.method13028(var1, var2);
      if (this.field21373) {
         this.method13708(this.method13706(var2));
         this.method13710();
      }
   }

   @Override
   public void onClick2(int mouseX, int mouseY, int mouseButton) {
      super.onClick2(mouseX, mouseY, mouseButton);
      this.field21373 = false;
   }

   @Override
   public void onScrolling(float scroll) {
      if (this.method13298()) {
         this.method13708(this.method13707() - scroll / 2000.0F);
         this.method13710();
      }

      super.onScrolling(scroll);
   }

   public float method13707() {
      return this.field21372;
   }

   public void method13708(float var1) {
      this.field21372 = Math.min(Math.max(var1, 0.0F), 1.0F);
   }

   public AnimatedIconPanel method13709(Class6649 var1) {
      this.field21374.add(var1);
      return this;
   }

   public void method13710() {
      for (Class6649 var4 : this.field21374) {
         var4.method20301(this);
      }
   }
}
