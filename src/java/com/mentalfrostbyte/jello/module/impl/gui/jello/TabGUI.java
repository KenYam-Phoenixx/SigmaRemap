package com.mentalfrostbyte.jello.module.impl.gui.jello;

import com.mentalfrostbyte.Client;
import com.mentalfrostbyte.jello.event.EventTarget;
import com.mentalfrostbyte.jello.event.impl.EventKeyPress;
import com.mentalfrostbyte.jello.event.impl.EventRender;
import com.mentalfrostbyte.jello.event.impl.Render2DEvent;
import com.mentalfrostbyte.jello.event.impl.Render3DEvent;
import com.mentalfrostbyte.jello.event.priority.HigestPriority;
import com.mentalfrostbyte.jello.module.Module;
import com.mentalfrostbyte.jello.module.ModuleCategory;
import com.mentalfrostbyte.jello.resource.ResourceRegistry;
import com.mentalfrostbyte.jello.util.render.blur.BlurEngine;
import com.mentalfrostbyte.jello.unmapped.ResourceList;
import com.mentalfrostbyte.jello.util.MultiUtilities;
import mapped.Class8224;
import com.mentalfrostbyte.jello.util.ClientColors;
import mapped.QuadraticEasing;
import mapped.RenderUtil;
import net.minecraft.client.Minecraft;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TabGUI extends Module {
    private static final int field23762 = 3;
    public static TabGUI field23788;
    public List<ModuleCategory> field23772 = new ArrayList<ModuleCategory>();
    public HashMap<ModuleCategory, Float> field23773 = new HashMap<ModuleCategory, Float>();
    public HashMap<Module, Float> field23774 = new HashMap<Module, Float>();
    public boolean field23781 = false;
    public ArrayList<Class8224> field23789 = new ArrayList<Class8224>();
    public int field23790 = MultiUtilities.applyAlpha(ClientColors.DEEP_TEAL.getColor, 0.0625F);
    public int field23791 = MultiUtilities.applyAlpha(ClientColors.LIGHT_GREYISH_BLUE.getColor, 0.3F);
    public List<ModuleCategory> field23792 = this.method16597();
    public int field23793 = MultiUtilities.applyAlpha(ClientColors.MID_GREY.getColor, 0.05F);
    private final Color[] field23763 = new Color[3];
    private final Color[] field23764 = new Color[3];
    private final Color[] field23765 = new Color[3];
    private final Color[] field23766 = new Color[3];
    private final Color[] field23767 = new Color[3];
    private final int field23768 = 10;
    private int field23769 = 90;
    private final int field23770 = 150;
    private int field23771 = 150;
    private int field23775 = 0;
    private int field23776 = 0;
    private int field23777 = 0;
    private final int field23778 = 30;
    private final int field23779 = 4;
    private float field23780 = 1.0F;
    private ModuleCategory field23782;
    private int field23783 = 0;
    private int field23784;
    private Module field23785;
    private final int field23786 = 170;
    private float field23787 = 0.0F;

    public TabGUI() {
        super(ModuleCategory.GUI, "TabGUI", "Manage mods without opening the ClickGUI");
        this.method16005(false);
        field23788 = this;
    }

    @EventTarget
    @HigestPriority
    private void method16590(Render2DEvent var1) {
        if (this.isEnabled() && mc.player != null) {
            if (Client.getInstance().guiManager.method33472()) {
                if (!Minecraft.getInstance().gameSettings.showDebugInfo) {
                    if (!Minecraft.getInstance().gameSettings.hideGUI) {
                        BlurEngine.drawBlur(this.field23768, this.field23769, this.field23770, this.field23771);
                        if (this.field23781) {
                            BlurEngine.drawBlur(170, this.field23769, this.field23786, this.field23783);
                        }
                    }
                }
            }
        }
    }

    @EventTarget
    @HigestPriority
    private void method16591(EventRender var1) {
        if (this.isEnabled() && mc.player != null && mc.world != null) {
            if (!Minecraft.getInstance().gameSettings.showDebugInfo) {
                if (!Minecraft.getInstance().gameSettings.hideGUI) {
                    this.field23771 = 5 * this.field23778 + this.field23779;
                    float var4 = Math.abs((float) this.method16592() - this.field23787);
                    boolean var5 = (float) this.method16592() - this.field23787 < 0.0F;
                    this.field23787 = this.field23787
                            + Math.min(var4, var4 * 0.14F * this.field23780) * (float) (!var5 ? 1 : -1);
                    this.field23769 = var1.method13960();
                    this.method16600(this.field23768, this.field23769, this.field23770, this.field23771,
                            this.field23763, null, this.field23764, 1.0F);
                    RenderUtil.startScissor((float) this.field23768, (float) this.field23769, (float) this.field23770,
                            (float) this.field23771);
                    this.method16596(
                            this.field23768,
                            this.field23769 - Math.round(this.field23787),
                            this.field23792.size() * this.field23778 + this.field23779,
                            this.field23770,
                            this.field23775,
                            false,
                            1.0F);
                    this.method16595(this.field23768, this.field23769 - Math.round(this.field23787), this.field23792);
                    RenderUtil.endScissor();
                    if (this.field23781) {
                        this.field23783 = this.method16593(this.field23782).size() * this.field23778 + this.field23779;
                        this.method16600(170, this.field23769, this.field23786, this.field23783, this.field23765,
                                this.field23767, this.field23766, 1.0F);
                        this.method16596(170, this.field23769, this.field23783, this.field23786, this.field23784, true,
                                1.0F);
                        this.method16594(170, this.field23769, this.method16593(this.field23782), 1.0F);
                    }

                    var1.method13962(this.field23771 + 10);
                }
            }
        }
    }

    private int method16592() {
        return Math.max(this.field23775 * this.field23778 - 4 * this.field23778, 0);
    }

    private List<Module> method16593(ModuleCategory var1) {
        ArrayList var4 = new ArrayList();

        for (Module var6 : Client.getInstance().moduleManager.getModulesByCategory(var1)) {
            var4.add(var6);
        }

        return var4;
    }

    private void method16594(int var1, int var2, List<Module> var3, float var4) {
        int var7 = 0;

        for (Module var9 : var3) {
            if (this.field23784 == var7) {
                this.field23785 = var9;
            }

            if (!this.field23774.containsKey(var9)) {
                this.field23774.put(var9, 0.0F);
            }

            if (this.field23784 == var7 && this.field23774.get(var9) < 14.0F) {
                this.field23774.put(var9, this.field23774.get(var9) + this.field23780);
            } else if (this.field23784 != var7 && this.field23774.get(var9) > 0.0F) {
                this.field23774.put(var9, this.field23774.get(var9) - this.field23780);
            }

            if (var9.isEnabled()) {
                RenderUtil.drawString(
                        ResourceRegistry.JelloMediumFont20,
                        (float) (var1 + 11) + this.field23774.get(var9),
                        (float) (var2 + this.field23778 / 2 - ResourceRegistry.JelloMediumFont20.method23952() / 2 + 3
                                + var7 * this.field23778),
                        var9.getName(),
                        ClientColors.LIGHT_GREYISH_BLUE.getColor);
            } else {
                RenderUtil.drawString(
                        ResourceRegistry.JelloLightFont20,
                        (float) (var1 + 11) + this.field23774.get(var9),
                        (float) (var2 + this.field23778 / 2 - ResourceRegistry.JelloLightFont20.method23952() / 2 + 2
                                + var7 * this.field23778),
                        var9.getName(),
                        ClientColors.LIGHT_GREYISH_BLUE.getColor);
            }

            var7++;
        }
    }

    private void method16595(int var1, int var2, List<ModuleCategory> var3) {
        int var6 = 0;

        for (ModuleCategory var8 : var3) {
            if (this.field23775 == var6) {
                this.field23782 = var8;
            }

            if (!this.field23773.containsKey(var8)) {
                this.field23773.put(var8, 0.0F);
            }

            if (this.field23775 == var6 && this.field23773.get(var8) < 14.0F) {
                this.field23773.put(var8, this.field23773.get(var8) + this.field23780);
            } else if (this.field23775 != var6 && this.field23773.get(var8) > 0.0F) {
                this.field23773.put(var8, this.field23773.get(var8) - this.field23780);
            }

            RenderUtil.drawString(
                    ResourceRegistry.JelloLightFont20,
                    (float) (var1 + 11) + this.field23773.get(var8),
                    (float) (var2 + this.field23778 / 2 - ResourceRegistry.JelloLightFont20.method23952() / 2 + 2
                            + var6 * this.field23778),
                    var8.toString(),
                    -1);
            var6++;
        }
    }

    private void method16596(int var1, int var2, int var3, int var4, int var5, boolean var6, float var7) {
        int var10 = 0;
        if (var6) {
            if (var6) {
                float var11 = (float) (var5 * this.field23778 - this.field23777);
                if (this.field23777 > var5 * this.field23778) {
                    this.field23777 = (int) ((float) this.field23777
                            + (!(var11 * 0.14F * this.field23780 >= 1.0F) ? var11 * 0.14F * this.field23780
                                    : -this.field23780));
                }

                if (this.field23777 < var5 * this.field23778) {
                    this.field23777 = (int) ((float) this.field23777
                            + (!(var11 * 0.14F * this.field23780 <= 1.0F) ? var11 * 0.14F * this.field23780
                                    : this.field23780));
                }

                if (var11 > 0.0F && this.field23777 > var5 * this.field23778) {
                    this.field23777 = var5 * this.field23778;
                }

                if (var11 < 0.0F && this.field23777 < var5 * this.field23778) {
                    this.field23777 = var5 * this.field23778;
                }

                var10 = this.field23777;
            }
        } else {
            float var15 = (float) (var5 * this.field23778 - this.field23776);
            if (this.field23776 > var5 * this.field23778) {
                this.field23776 = (int) ((float) this.field23776
                        + (!(var15 * 0.14F * this.field23780 >= 1.0F) ? var15 * 0.14F * this.field23780
                                : -this.field23780));
            }

            if (this.field23776 < var5 * this.field23778) {
                this.field23776 = (int) ((float) this.field23776
                        + (!(var15 * 0.14F * this.field23780 <= 1.0F) ? var15 * 0.14F * this.field23780
                                : this.field23780));
            }

            if (var15 > 0.0F && this.field23776 > var5 * this.field23778) {
                this.field23776 = var5 * this.field23778;
            }

            if (var15 < 0.0F && this.field23776 < var5 * this.field23778) {
                this.field23776 = var5 * this.field23778;
            }

            var10 = this.field23776;
        }

        if (Math.round(this.field23787) > 0 && this.field23776 > 120) {
            this.field23776 = Math.max(this.field23776, 120 + Math.round(this.field23787));
        }

        RenderUtil.drawRect(
                (float) var1,
                var10 >= 0 ? (float) (var10 + var2) : (float) var2,
                (float) (var1 + var4),
                var10 + this.field23779 + this.field23778 <= var3
                        ? (float) (var10 + var2 + this.field23778 + this.field23779)
                        : (float) (var2 + var3 + this.field23779),
                this.field23790);
        RenderUtil.drawImage(
                (float) var1,
                var10 + this.field23779 + this.field23778 <= var3 ? (float) (var10 + var2 + this.field23778 - 10)
                        : (float) (var2 + var3 - 10),
                (float) var4,
                14.0F,
                ResourceList.shadowTopPNG,
                this.field23791);
        RenderUtil.drawImage((float) var1, var10 >= 0 ? (float) (var10 + var2) : (float) var2, (float) var4, 14.0F,
                ResourceList.shadowBottomPNG, this.field23791);
        RenderUtil.drawPortalBackground(
                var1,
                var10 >= 0 ? var10 + var2 : var2,
                var1 + var4,
                var10 + this.field23779 + this.field23778 <= var3 ? var10 + var2 + this.field23778 + this.field23779
                        : var2 + var3 + this.field23779);
        Iterator var16 = this.field23789.iterator();

        while (var16.hasNext()) {
            Class8224 var12 = (Class8224) var16.next();
            if (var12.field35322 == var6) {
                float var13 = var12.field35323.calcPercent();
                int var14 = MultiUtilities.applyAlpha(-5658199, (1.0F - var13 * (0.5F + var13 * 0.5F)) * 0.8F);
                if (Client.getInstance().guiManager.method33472()) {
                    var14 = MultiUtilities.applyAlpha(-1, (1.0F - var13) * 0.14F);
                }

                RenderUtil.method11436(
                        (float) var1, var10 >= 0 ? (float) (var10 + var2 + 14) : (float) var2,
                        (float) var4 * QuadraticEasing.easeOutQuad(var13, 0.0F, 1.0F, 1.0F) + 4.0F, var14);
                if (var12.field35323.calcPercent() == 1.0F) {
                    var16.remove();
                }
            }
        }

        RenderUtil.endScissor();
    }

    private List<ModuleCategory> method16597() {
        ArrayList var3 = new ArrayList();
        var3.add(ModuleCategory.MOVEMENT);
        var3.add(ModuleCategory.PLAYER);
        var3.add(ModuleCategory.COMBAT);
        var3.add(ModuleCategory.ITEM);
        var3.add(ModuleCategory.RENDER);
        var3.add(ModuleCategory.WORLD);
        var3.add(ModuleCategory.MISC);
        return var3;
    }

    @EventTarget
    private void method16598(Render3DEvent var1) {
        if (this.isEnabled() && mc.player != null) {
            this.method16601();
            this.field23780 = (float) Math.max(Math.round(6.0F - (float) Minecraft.getFps() / 10.0F), 1);
        }
    }

    @EventTarget
    private void method16599(EventKeyPress var1) {
        if (this.isEnabled()) {
            switch (var1.getKey()) {
                case 257:
                    if (this.field23781) {
                        this.field23785.toggle();
                        this.field23789.add(new Class8224(this, this.field23781));
                    }
                    break;
                case 258:
                case 259:
                case 260:
                case 261:
                default:
                    return;
                case 262:
                    this.field23789.add(new Class8224(this, this.field23781));
                    if (this.field23781) {
                        this.field23785.toggle();
                    }

                    this.field23781 = true;
                    break;
                case 263:
                    this.field23781 = false;
                    break;
                case 264:
                    if (!this.field23781) {
                        this.field23775++;
                        this.field23784 = 0;
                    } else {
                        this.field23784++;
                    }
                    break;
                case 265:
                    if (!this.field23781) {
                        this.field23775--;
                        this.field23784 = 0;
                    } else {
                        this.field23784--;
                    }
            }

            if (this.field23775 >= this.field23792.size()) {
                this.field23775 = 0;
                this.field23776 = this.field23775 * this.field23778 - this.field23778;
            } else if (this.field23775 < 0) {
                this.field23775 = this.field23792.size() - 1;
                this.field23776 = this.field23775 * this.field23778 + this.field23778;
            }

            if (this.field23784 >= this.method16593(this.field23782).size()) {
                this.field23784 = this.method16593(this.field23782).size() - 1;
            } else if (this.field23784 < 0) {
                this.field23784 = 0;
            }
        }
    }

    private void method16600(int var1, int var2, int var3, int var4, Color[] var5, Color[] var6, Color[] var7,
            float var8) {
        boolean var11 = Client.getInstance().guiManager.method33472();
        int var14 = MultiUtilities.method17682(var5).getRGB();
        int var15 = MultiUtilities.method17682(var7).getRGB();
        if (var6 != null) {
            int var16 = MultiUtilities.method17682(var6).getRGB();
            var14 = MultiUtilities.method17690(var14, var16, 0.75F);
            var15 = MultiUtilities.method17690(var15, var16, 0.75F);
        }

        if (!var11) {
            RenderUtil.method11431(var1, var2, var1 + var3, var2 + var4, var14, var15);
        } else {
            RenderUtil.startScissor((float) var1, (float) var2, (float) var3, (float) var4);
            BlurEngine.endBlur();
            RenderUtil.endScissor();
            RenderUtil.drawRect((float) var1, (float) var2, (float) (var1 + var3), (float) (var2 + var4),
                    this.field23793);
        }

        RenderUtil.drawRoundedRect((float) var1, (float) var2, (float) var3, (float) var4, 8.0F, 0.7F * var8);
    }

    private void method16601() {
        if (!Client.getInstance().guiManager.method33472()) {
            if (!Minecraft.getInstance().gameSettings.showDebugInfo) {
                if (!Minecraft.getInstance().gameSettings.hideGUI) {
                    for (int var4 = 0; var4 < 3; var4++) {
                        this.field23763[var4] = this.method16602(this.field23768 + this.field23770 / 3 * var4,
                                this.field23769, this.field23763[var4]);
                        this.field23764[var4] = this.method16602(
                                this.field23768 + this.field23770 / 3 * var4, this.field23769 + this.field23771,
                                this.field23764[var4]);
                        this.field23765[var4] = this.method16602(this.field23768 + this.field23770 + 56 * var4,
                                this.field23769, this.field23765[var4]);
                        this.field23766[var4] = this.method16602(
                                this.field23768 + this.field23770 + 56 * var4, this.field23769 + this.field23783,
                                this.field23766[var4]);
                        this.field23767[var4] = this.method16602(
                                this.field23768 + this.field23770 + 56 * var4, this.field23769 + this.field23783 / 2,
                                this.field23767[var4]);
                    }
                }
            }
        }
    }

    private Color method16602(int var1, int var2, Color var3) {
        Color var6 = RenderUtil.getColorFromScreen(var1, var2, var3);
        if (var3 != null) {
            var6 = MultiUtilities.method17681(var6, var3, 0.08F * this.field23780);
        }

        return var6;
    }
}
