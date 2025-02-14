package com.mentalfrostbyte.jello.gui.screens;

import com.mentalfrostbyte.jello.gui.Screen;
import com.mentalfrostbyte.jello.module.ModuleCategory;
import com.mentalfrostbyte.jello.util.MultiUtilities;
import com.mentalfrostbyte.jello.util.render.animation.Animation;
import com.mentalfrostbyte.jello.util.ClientColors;
import mapped.*;
import net.minecraft.client.Minecraft;
import totalcross.json.JSONObject;

public class ClassicScreenk extends Screen {
    private static final Minecraft field21078 = Minecraft.getInstance();
    private static Animation field21079;
    private static final boolean field21080 = true;
    private Class4333 field21081;

    public ClassicScreenk() {
        super("ClassicScreen");
        field21079 = new Animation(250, 200, Animation.Direction.FORWARDS);
        this.method13419();
        MultiUtilities.method17739();
    }

    public void method13417() {
        this.runThisOnDimensionUpdate(() -> this.method13419());
    }

    public void method13418(String var1, ModuleCategory... var2) {
        this.runThisOnDimensionUpdate(() -> {
            if (this.field21081 != null) {
                this.method13236(this.field21081);
            }

            this.addToList(
                    this.field21081 = new Class4335(this, var1, this.getWidthA() / 2, this.getHeightA() / 2, var2));
        });
    }

    private void method13419() {
        if (this.field21081 != null) {
            this.method13236(this.field21081);
        }

        this.addToList(this.field21081 = new Class4334(this, "Sigma", this.getWidthA() / 2, this.getHeightA() / 2));
    }

    @Override
    public void updatePanelDimensions(int newHeight, int newWidth) {
        super.updatePanelDimensions(newHeight, newWidth);
    }

    @Override
    public int method13313() {
        return Minecraft.getFps();
    }

    @Override
    public JSONObject method13160(JSONObject var1) {
        MultiUtilities.resetShaders();
        return super.method13160(var1);
    }

    @Override
    public void loadConfig(JSONObject var1) {
        super.loadConfig(var1);
    }

    @Override
    public void keyPressed(int keyCode) {
        super.keyPressed(keyCode);
        if (keyCode == 256) {
            field21078.displayGuiScreen(null);
        }
    }

    @Override
    public void draw(float partialTicks) {
        float var4 = field21079.calcPercent();
        RenderUtil.drawRect(
                (float) this.xA,
                (float) this.yA,
                (float) (this.xA + this.widthA),
                (float) (this.yA + this.heightA),
                MultiUtilities.applyAlpha(ClientColors.DEEP_TEAL.getColor(), var4 * 0.35F));
        super.draw(partialTicks);
    }
}
