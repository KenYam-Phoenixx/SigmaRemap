package mapped;

import com.mentalfrostbyte.jello.unmapped.CustomGuiScreen;
import com.mentalfrostbyte.jello.util.MultiUtilities;
import com.mentalfrostbyte.jello.util.render.animation.Animation;
import com.mentalfrostbyte.jello.util.ClientColors;
import org.lwjgl.opengl.GL11;

public class Class4241 extends ButtonPanel {
   public static final ColorHelper field20587 = new ColorHelper(ClientColors.LIGHT_GREYISH_BLUE.getColor(),
         MultiUtilities.method17691(ClientColors.LIGHT_GREYISH_BLUE.getColor(), 0.1F));
   public boolean field20588 = false;
   public Animation field20589 = new Animation(300, 250);

   public Class4241(CustomGuiScreen var1, String var2, int var3, int var4, int var5, int var6) {
      super(var1, var2, var3, var4, var5, var6, field20587);
   }

   @Override
   public void updatePanelDimensions(int newHeight, int newWidth) {
      this.field20589.changeDirection(!this.field20909 ? Animation.Direction.BACKWARDS : Animation.Direction.FORWARDS);
      super.updatePanelDimensions(newHeight, newWidth);
   }

   @Override
   public void draw(float partialTicks) {
      this.method13277(1.0F + this.field20589.calcPercent());
      this.method13278(1.0F + this.field20589.calcPercent());
      this.method13224();
      RenderUtil.drawString(
            this.getFont(), (float) this.getXA(), (float) this.getYA(), "" + this.field20589.calcPercent(),
            ClientColors.DEEP_TEAL.getColor());
      GL11.glPushMatrix();
      super.method13226(partialTicks);
      GL11.glPopMatrix();
   }
}
