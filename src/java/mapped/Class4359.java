package mapped;

import com.mentalfrostbyte.Client;
import com.mentalfrostbyte.jello.music.MusicManager;
import com.mentalfrostbyte.jello.unmapped.CustomGuiScreen;
import com.mentalfrostbyte.jello.unmapped.ResourceList;
import com.mentalfrostbyte.jello.util.MultiUtilities;
import com.mentalfrostbyte.jello.util.ClientColors;

public class Class4359 extends Class4247 {
   private static String[] field21313;
   private MusicManager field21314 = Client.getInstance().musicManager;
   public float field21315 = -1.0F;

   public Class4359(CustomGuiScreen var1, String var2, int var3, int var4, int var5, int var6) {
      super(var1, var2, var3, var4, var5, var6, false);
      this.method13247((var1x, var2x) -> {
         int var5x = (int) this.field21314.method24321();
         int var6x = this.field21314.method24327();
         this.field21315 = Math.min((float) var5x / (float) var6x, 1.0F);
      });
      this.method13249((var1x, var2x) -> {
         if (this.method13298() && this.method13297()) {
            int var5x = (int) Math.min((double) ((int) (this.field21315 * (float) this.field21314.method24327())),
                  this.field21314.method24322());
            this.field21314.method24329((double) var5x);
         }
      });
   }

   @Override
   public void draw(float var1) {
      int var4 = (int) this.field21314.method24321();
      double var5 = this.field21314.method24322();
      int var7 = this.field21314.method24327();
      float var8 = Math.max(0.0F, Math.min((float) var4 / (float) var7, 1.0F));
      float var9 = Math.max(0.0F, Math.min((float) var5 / (float) var7, 1.0F));
      if (this.method13212() && this.method13298() && var5 != 0.0) {
         int var10 = this.getHeightO() - this.method13271();
         this.field21315 = Math.min(Math.max((float) var10 / (float) this.getWidthA(), 0.0F), var9);
         var8 = this.field21315;
      }

      if (var4 == 0 && !this.field21314.method24319()) {
         RenderUtil.renderBackgroundBox(
               (float) this.getXA(),
               (float) this.getYA(),
               (float) this.getWidthA(),
               (float) this.getHeightA(),
               MultiUtilities.applyAlpha(ClientColors.DEEP_TEAL.getColor, 0.43F * var1));
      } else {
         RenderUtil.renderBackgroundBox(
               (float) this.getXA(),
               (float) this.getYA(),
               (float) this.getWidthA(),
               (float) this.getHeightA(),
               MultiUtilities.applyAlpha(ClientColors.MID_GREY.getColor, 0.075F));
         RenderUtil.renderBackgroundBox(
               (float) this.getXA() + (float) this.getWidthA() * var9,
               (float) this.getYA(),
               (float) this.getWidthA() * (1.0F - var9),
               (float) this.getHeightA(),
               MultiUtilities.applyAlpha(ClientColors.DEEP_TEAL.getColor, 0.43F * var1));
         RenderUtil.renderBackgroundBox(
               (float) this.getXA(),
               (float) this.getYA(),
               (float) this.getWidthA() * var8,
               (float) this.getHeightA(),
               MultiUtilities.applyAlpha(ClientColors.LIGHT_GREYISH_BLUE.getColor, var1 * var1));
         if (var8 != 0.0F) {
            RenderUtil.method11455((float) this.getXA() + (float) this.getWidthA() * var8, (float) this.getYA(), 5.0F,
                  5.0F, ResourceList.shadowRightPNG);
         }
      }
   }
}
