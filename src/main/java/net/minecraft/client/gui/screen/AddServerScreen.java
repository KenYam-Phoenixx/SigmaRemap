package net.minecraft.client.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import mapped.Class2168;
import net.minecraft.util.StringUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.DialogTexts;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import java.net.IDN;
import java.util.function.Predicate;

public class AddServerScreen extends Screen {
    private static final ITextComponent field7036 = new TranslationTextComponent("addServer.enterName");
    private static final ITextComponent field7037 = new TranslationTextComponent("addServer.enterIp");
    private Button field7038;
    private final BooleanConsumer field7039;
    private final ServerData field7040;
    private TextFieldWidget field7041;
    private TextFieldWidget field7042;
    private Button field7043;
    private final Screen field7044;
    private final Predicate<String> field7045 = var0 -> {
        if (StringUtils.isNullOrEmpty(var0)) {
            return true;
        } else {
            String[] var3x = var0.split(":");
            if (var3x.length == 0) {
                return true;
            } else {
                try {
                    String var4 = IDN.toASCII(var3x[0]);
                    return true;
                } catch (IllegalArgumentException var5) {
                    return false;
                }
            }
        }
    };

    public AddServerScreen(Screen var1, BooleanConsumer var2, ServerData var3) {
        super(new TranslationTextComponent("addServer.title"));
        this.field7044 = var1;
        this.field7039 = var2;
        this.field7040 = var3;
    }

    @Override
    public void tick() {
        this.field7042.method5633();
        this.field7041.method5633();
    }

    @Override
    public void init() {
        this.mc.keyboardListener.enableRepeatEvents(true);
        this.field7042 = new TextFieldWidget(this.font, this.width / 2 - 100, 66, 200, 20, new TranslationTextComponent("addServer.enterName"));
        this.field7042.method5654(true);
        this.field7042.method5635(this.field7040.serverName);
        this.field7042.method5631(this::method6337);
        this.children.add(this.field7042);
        this.field7041 = new TextFieldWidget(this.font, this.width / 2 - 100, 106, 200, 20, new TranslationTextComponent("addServer.enterIp"));
        this.field7041.method5657(128);
        this.field7041.method5635(this.field7040.serverIP);
        this.field7041.method5638(this.field7045);
        this.field7041.method5631(this::method6337);
        this.children.add(this.field7041);
        this.field7043 = this.<Button>addButton(
                new Button(this.width / 2 - 100, this.height / 4 + 72, 200, 20, method6336(this.field7040.method25577()), var1 -> {
                    this.field7040.method25578(Class2168.values()[(this.field7040.method25577().ordinal() + 1) % Class2168.values().length]);
                    this.field7043.setMessage(method6336(this.field7040.method25577()));
                })
        );
        this.field7038 = this.<Button>addButton(
                new Button(
                        this.width / 2 - 100, this.height / 4 + 96 + 18, 200, 20, new TranslationTextComponent("addServer.add"), var1 -> this.method6338()
                )
        );
        this.<Button>addButton(
                new Button(this.width / 2 - 100, this.height / 4 + 120 + 18, 200, 20, DialogTexts.GUI_CANCEL, var1 -> this.field7039.accept(false))
        );
        this.method6339();
    }

    private static ITextComponent method6336(Class2168 var0) {
        return new TranslationTextComponent("addServer.resourcePack").appendString(": ").append(var0.method8891());
    }

    @Override
    public void resize(Minecraft var1, int var2, int var3) {
        String var6 = this.field7041.getText();
        String var7 = this.field7042.getText();
        this.init(var1, var2, var3);
        this.field7041.method5635(var6);
        this.field7042.method5635(var7);
    }

    private void method6337(String var1) {
        this.method6339();
    }

    @Override
    public void onClose() {
        this.mc.keyboardListener.enableRepeatEvents(false);
    }

    private void method6338() {
        this.field7040.serverName = this.field7042.getText();
        this.field7040.serverIP = this.field7041.getText();
        this.field7039.accept(true);
    }

    @Override
    public void method1945() {
        this.method6339();
        this.mc.displayGuiScreen(this.field7044);
    }

    private void method6339() {
        String var3 = this.field7041.getText();
        boolean var4 = !var3.isEmpty() && var3.split(":").length > 0 && var3.indexOf(32) == -1;
        this.field7038.active = var4 && !this.field7042.getText().isEmpty();
    }

    @Override
    public void render(MatrixStack var1, int var2, int var3, float var4) {
        this.renderBackground(var1);
        drawCenteredString(var1, this.font, this.title, this.width / 2, 17, 16777215);
        drawString(var1, this.font, field7036, this.width / 2 - 100, 53, 10526880);
        drawString(var1, this.font, field7037, this.width / 2 - 100, 94, 10526880);
        this.field7042.render(var1, var2, var3, var4);
        this.field7041.render(var1, var2, var3, var4);
        super.render(var1, var2, var3, var4);
    }
}
