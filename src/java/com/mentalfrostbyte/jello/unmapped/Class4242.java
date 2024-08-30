package com.mentalfrostbyte.jello.unmapped;

import com.mentalfrostbyte.jello.util.animation.Animation;
import com.mentalfrostbyte.jello.util.animation.Direction;
import mapped.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class Class4242 extends Class4240 {
    private static String[] field20583;
    private final Texture field20590;
    private final Animation field20592 = new Animation(150, 190, Direction.BACKWARDS);
    private boolean field20591;

    public Class4242(Class4305 var1, String var2, int var3, int var4, int var5, int var6, Texture var7) {
        super(var1, var2, var3, var4, var5, var6);
        this.field20590 = var7;
    }

    @Override
    public void method13028(int var1, int var2) {
        this.field20591 = this.method13298();
        super.method13028(var1, var2);
    }

    @Override
    public void draw(float var1) {
        this.field20592.changeDirection(!this.field20591 ? Direction.BACKWARDS : Direction.FORWARDS);
        float var4 = MathUtils.lerp(this.field20592.calcPercent(), 0.07, 0.73, 0.63, 1.01);
        if (this.field20592.getDirection() == Direction.BACKWARDS) {
            var4 = MathUtils.lerp(this.field20592.calcPercent(), 0.71, 0.18, 0.95, 0.57);
        }

        RenderUtil.method11419((float) this.method13263(), (float) this.method13265() - var4 * 3.0F, (float) this.method13267(), (float) this.method13269());
        int var5 = 40;
        float var6 = - GuiSwitch.field21070 / (float) Minecraft.getInstance().mainWindow.getWidth();
        float var7 = - GuiSwitch.field21071 / (float) Minecraft.getInstance().mainWindow.getHeight();
        RenderUtil.method11455(
                (float) var5 * var6,
                (float) var5 * var7,
                (float) (Minecraft.getInstance().mainWindow.getWidth() + var5),
                (float) (Minecraft.getInstance().mainWindow.getHeight() + var5),
                CustomResourceLoadProgressGui.field6780
        );
        RenderUtil.method11422();
        if (this.field20591) {
            RenderUtil.method11424(
                    (float) this.method13263(),
                    (float) this.method13265() - var4 * 3.0F,
                    (float) this.method13267(),
                    (float) this.method13269(),
                    ColorUtils.applyAlpha(-12319668, 0.5F)
            );
        }

        RenderUtil.method11449(
                (float) this.method13263(),
                (float) this.method13265() - var4 * 3.0F,
                (float) this.method13267(),
                (float) this.method13269(),
                this.field20590,
                ClientColors.LIGHT_GREYISH_BLUE.getColor
        );
        GL11.glPushMatrix();
        super.method13226(var1);
        GL11.glPopMatrix();
    }
}
