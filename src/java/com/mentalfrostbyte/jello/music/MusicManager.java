package com.mentalfrostbyte.jello.music;

import com.mentalfrostbyte.Client;
import com.mentalfrostbyte.ClientMode;
import com.mentalfrostbyte.jello.event.EventTarget;
import com.mentalfrostbyte.jello.event.impl.EventRender;
import com.mentalfrostbyte.jello.event.impl.EventRender2D;
import com.mentalfrostbyte.jello.event.impl.TickEvent;
import com.mentalfrostbyte.jello.notification.Notification;
import com.mentalfrostbyte.jello.resource.ResourceRegistry;
import com.mentalfrostbyte.jello.util.youtube.YoutubeType;
import com.mentalfrostbyte.jello.util.youtube.YoutubeVideoData;
import com.mentalfrostbyte.jello.unmapped.MusicPlayerVideo;
import com.mentalfrostbyte.jello.util.ImageUtil;
import com.mentalfrostbyte.jello.util.MultiUtilities;
import com.mentalfrostbyte.jello.util.TextureUtil;
import com.sapher.youtubedl.YoutubeDL;
import com.sapher.youtubedl.YoutubeDLException;
import com.sapher.youtubedl.YoutubeDLRequest;
import com.sapher.youtubedl.YoutubeDLResponse;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinReg;
import lol.ClientColors;
import lol.Texture;
import mapped.*;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Util;
import org.lwjgl.opengl.GL11;
import totalcross.json.JSONException;
import totalcross.json.JSONObject;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.sound.sampled.FloatControl.Type;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class MusicManager {
    private static final float field32167 = 32768.0F;
    private static final Minecraft field32143 = Minecraft.getInstance();
    public BufferedImage field32149;
    public String field32150 = "";
    public List<double[]> field32163 = new ArrayList<double[]>();
    public ArrayList<Double> field32165 = new ArrayList<Double>();
    public SourceDataLine field32166;
    private boolean field32144 = false;
    private MusicPlayerVideo field32145;
    private int field32146 = 50;
    private long field32147 = -1L;
    private Texture field32151;
    private BufferedImage field32152;
    private Texture field32153;
    private boolean field32154 = false;
    private transient volatile Thread field32156 = null;
    private int field32157;
    private long field32158 = 0L;
    private int field32159;
    private YoutubeVideoData field32160;
    private boolean field32161 = true;
    private Class189 field32162 = Class189.field717;
    private boolean finished = false;
    private double field32168;
    private boolean field32169 = false;
    private double field32170 = 0.0;

    private static float[] method24305(byte[] var0, AudioFormat var1) {
        float[] var4 = new float[var0.length / var1.getFrameSize()];

        for (int var5 = 0; var5 < var0.length; var5 += var1.getFrameSize()) {
            int var6 = !var1.isBigEndian() ? method24307(var0, var5, var1.getFrameSize()) : method24308(var0, var5, var1.getFrameSize());
            var4[var5 / var1.getFrameSize()] = (float) var6 / 32768.0F;
        }

        return var4;
    }

    private static double[] method24306(float[] var0, float[] var1) {
        double[] var4 = new double[var0.length / 2];

        for (int var5 = 0; var5 < var4.length; var5++) {
            var4[var5] = Math.sqrt(var0[var5] * var0[var5] + var1[var5] * var1[var5]);
        }

        return var4;
    }

    private static int method24307(byte[] var0, int var1, int var2) {
        int var5 = 0;

        for (int var6 = 0; var6 < var2; var6++) {
            int var7 = var0[var1 + var6] & 255;
            var5 += var7 << 8 * var6;
        }

        return var5;
    }

    private static int method24308(byte[] var0, int var1, int var2) {
        int var5 = 0;

        for (int var6 = 0; var6 < var2; var6++) {
            int var7 = var0[var1 + var6] & 255;
            var5 += var7 << 8 * (var2 - var6 - 1);
        }

        return var5;
    }

    public void init(){
        Client.getInstance().getEventManager().register(this);
        try {
            this.method24295();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        if (!this.method24330()) {
            this.method24331();
        }

        this.finished = false;
    }

    public void method24294() {
        JSONObject var3 = new JSONObject();
        var3.put("volume", this.field32146);
        var3.put("spectrum", this.field32161);
        var3.put("repeat", this.field32162.field719);
        Client.getInstance().getConfig().put("music", var3);
    }

    private void method24295() throws JSONException {
        if (Client.getInstance().getConfig().has("music")) {
            JSONObject var3 = Client.getInstance().getConfig().getJSONObject("music");
            if (var3 != null) {
                if (var3.has("volume")) {
                    this.field32146 = Math.max(0, Math.min(100, var3.getInt("volume")));
                }

                if (var3.has("spectrum")) {
                    this.field32161 = var3.getBoolean("spectrum");
                }

                if (var3.has("repeat")) {
                    this.field32162 = Class189.method578(var3.getInt("repeat"));
                }
            }
        }
    }

    @EventTarget
    private void method24296(EventRender var1) {
        if (Client.getInstance().getClientMode() == ClientMode.JELLO) {
            if (this.field32144 && this.field32163.size() != 0) {
                double[] var4 = this.field32163.get(0);
                if (this.field32165.isEmpty()) {
                    for (double v : var4) {
                        if (this.field32165.size() < 1024) {
                            this.field32165.add(v);
                        }
                    }
                }

                float var10 = 60.0F / (float) Minecraft.getFps();

                for (int var6 = 0; var6 < var4.length; var6++) {
                    double var7 = this.field32165.get(var6) - var4[var6];
                    boolean var9 = !(this.field32165.get(var6) < Double.MAX_VALUE);
                    this.field32165.set(var6, Math.min(2.256E7, Math.max(0.0, this.field32165.get(var6) - var7 * (double) Math.min(0.335F * var10, 1.0F))));
                    if (var9) {
                        this.field32165.set(var6, 0.0);
                    }
                }
            }
        }
    }

    @EventTarget
    private void method24297(EventRender2D var1) {
        if (this.field32144 && !this.field32163.isEmpty() && this.field32161) {
            this.method24298();
        }
    }

    private void method24298() {
        if (!this.field32163.isEmpty()) {
            if (this.field32151 != null) {
                if (!this.field32165.isEmpty()) {
                    float var3 = 114.0F;
                    float var4 = (float) Math.ceil((float) field32143.mainWindow.getWidth() / var3);

                    for (int var5 = 0; (float) var5 < var3; var5++) {
                        float var6 = 1.0F - (float) (var5 + 1) / var3;
                        float var7 = (float) field32143.mainWindow.getHeight() / 1080.0F;
                        float var8 = ((float) (Math.sqrt(this.field32165.get(var5)) / 12.0) - 5.0F) * var7;
                        RenderUtil.renderBackgroundBox(
                                (float) var5 * var4,
                                (float) field32143.mainWindow.getHeight() - var8,
                                var4,
                                var8,
                                MultiUtilities.applyAlpha(ClientColors.MID_GREY.getColor, 0.2F * var6)
                        );
                    }

                    RenderUtil.method11476();

                    for (int var13 = 0; (float) var13 < var3; var13++) {
                        float var14 = (float) field32143.mainWindow.getHeight() / 1080.0F;
                        float var15 = ((float) (Math.sqrt(this.field32165.get(var13)) / 12.0) - 5.0F) * var14;
                        RenderUtil.renderBackgroundBox((float) var13 * var4, (float) field32143.mainWindow.getHeight() - var15, var4, var15, ClientColors.LIGHT_GREYISH_BLUE.getColor);
                    }

                    RenderUtil.method11477(Class2329.field15940);
                    if (this.field32151 != null && this.field32153 != null) {
                        RenderUtil.drawImage(0.0F, 0.0F, (float) field32143.mainWindow.getWidth(), (float) field32143.mainWindow.getHeight(), this.field32153, 0.4F);
                    }

                    RenderUtil.method11478();
                    double var9 = 0.0;
                    float var16 = 4750;

                    for (int var17 = 0; var17 < 3; var17++) {
                        var9 = Math.max(var9, Math.sqrt(this.field32165.get(var17)) - 1000.0);
                    }

                    float var18 = 1.0F + (float) Math.round((float) (var9 / (double) (var16 - 1000)) * 0.14F * 75.0F) / 75.0F;
                    GL11.glPushMatrix();
                    GL11.glTranslated(60.0, field32143.mainWindow.getHeight() - 55, 0.0);
                    GL11.glScalef(var18, var18, 0.0F);
                    GL11.glTranslated(-60.0, -(field32143.mainWindow.getHeight() - 55), 0.0);
                    RenderUtil.method11455(10.0F, (float) (field32143.mainWindow.getHeight() - 110), 100.0F, 100.0F, this.field32151);
                    RenderUtil.drawRoundedRect(10.0F, (float) (field32143.mainWindow.getHeight() - 110), 100.0F, 100.0F, 14.0F, 0.3F);
                    GL11.glPopMatrix();
                    String[] var11 = this.field32150.split(" - ");
                    int var12 = 30;
                    if (var11.length <= 1) {
                        RenderUtil.drawString(
                                ResourceRegistry.JelloLightFont18_1,
                                130.0F,
                                (float) (field32143.mainWindow.getHeight() - 70),
                                var11[0],
                                MultiUtilities.applyAlpha(ClientColors.DEEP_TEAL.getColor, 0.5F)
                        );
                        RenderUtil.drawString(
                                ResourceRegistry.JelloLightFont18,
                                130.0F,
                                (float) (field32143.mainWindow.getHeight() - 70),
                                var11[0],
                                MultiUtilities.applyAlpha(ClientColors.LIGHT_GREYISH_BLUE.getColor, 0.7F)
                        );
                    } else {
                        RenderUtil.drawString(
                                ResourceRegistry.JelloMediumFont20_1,
                                130.0F,
                                (float) (field32143.mainWindow.getHeight() - 81),
                                var11[0],
                                MultiUtilities.applyAlpha(ClientColors.DEEP_TEAL.getColor, 0.4F)
                        );
                        RenderUtil.drawString(
                                ResourceRegistry.JelloLightFont18_1,
                                130.0F,
                                (float) (field32143.mainWindow.getHeight() - 56),
                                var11[1],
                                MultiUtilities.applyAlpha(ClientColors.DEEP_TEAL.getColor, 0.5F)
                        );
                        RenderUtil.drawString(
                                ResourceRegistry.JelloLightFont18,
                                130.0F,
                                (float) (field32143.mainWindow.getHeight() - 56),
                                var11[1],
                                MultiUtilities.applyAlpha(ClientColors.LIGHT_GREYISH_BLUE.getColor, 0.7F)
                        );
                        RenderUtil.drawString(
                                ResourceRegistry.JelloMediumFont20,
                                130.0F,
                                (float) (field32143.mainWindow.getHeight() - 81),
                                var11[0],
                                MultiUtilities.applyAlpha(ClientColors.LIGHT_GREYISH_BLUE.getColor, 0.6F)
                        );
                    }
                }
            }
        }
    }

    @EventTarget
    private void method24299(TickEvent var1) {
        if (!this.field32144) {
            this.field32163.clear();
            this.field32165.clear();
        }

        try {
            if (this.field32154 && this.field32152 != null && this.field32149 != null && this.field32160 == null && !field32143.isGamePaused()) {
                if (this.field32153 != null) {
                    this.field32153.release();
                }

                if (this.field32151 != null) {
                    this.field32151.release();
                }

                this.field32153 = TextureUtil.method32933("picture", this.field32152);
                this.field32151 = TextureUtil.method32933("picture", this.field32149);
                Client.getInstance().getNotificationManager().send(new Notification("Now Playing", this.field32150, 7000, this.field32151));
                this.field32154 = false;
            }
        } catch (IOException var5) {
            var5.printStackTrace();
        }

        if (!this.field32154) {
            this.method24301();
        }
    }

    private void method24301() {
        if (this.field32160 != null) {
            this.field32163.clear();
            new Thread(() -> this.method24309(this.field32160)).start();
        }
    }

    private void method24302() {
        this.field32163.clear();
        if (this.field32145 != null) {
            while (this.field32156 != null && this.field32156.isAlive()) {
                this.field32156.interrupt();
            }

            this.field32156 = new Thread(
                    () -> {
                        Object var3 = null;
                        if (this.field32159 < 0 || this.field32159 >= this.field32145.youtubeVideos.size()) {
                            this.field32159 = 0;
                        }

                        for (int var4 = this.field32159; var4 < this.field32145.youtubeVideos.size(); var4++) {
                            URL var5 = Class9275.method34960(this.field32145.youtubeVideos.get(var4).videoId);
                            Client.getClientLogger().dummyMethod(var5.toString());
                            this.field32157 = var4;
                            this.field32160 = this.field32145.youtubeVideos.get(var4);
                            this.field32163.clear();

                            while (!this.field32144) {

                                this.field32163.clear();
                                if (Thread.interrupted()) {
                                    if (this.field32166 != null) {
                                        this.field32166.close();
                                    }
                                    return;
                                }
                            }

                            try {
                                System.out.println(var5);
                                URL var28 = this.method24323(var5);
                                Client.getClientLogger().dummyMethod(var28 == null ? "No stream" : var28.toString());
                                if (var28 != null) {
                                    URLConnection var7 = var28.openConnection();
                                    var7.setConnectTimeout(14000);
                                    var7.setReadTimeout(14000);
                                    var7.setUseCaches(true);
                                    var7.setDoOutput(true);
                                    var7.setRequestProperty("Connection", "Keep-Alive");
                                    InputStream var8 = var7.getInputStream();
                                    Class1782 var9 = new Class1782(var8, new Class8808(this));
                                    Class8490 var10 = new Class8490(var9);
                                    Class8583 var11 = var10.method30073();
                                    List<Class7354> var12 = var11.method30672();
                                    if (var12.isEmpty()) {
                                        Client.getClientLogger().dummyMethod("No content");
                                    }

                                    Class7356 var13 = (Class7356) var11.method30672().get(1);
                                    AudioFormat var14 = new AudioFormat((float) var13.method23338(), var13.method23339(), var13.method23337(), true, true);
                                    this.field32166 = AudioSystem.getSourceDataLine(var14);
                                    this.field32166.open();
                                    this.field32166.start();
                                    this.field32147 = (long) var11.method30680();
                                    if (this.field32147 > 1300L) {
                                        var9.close();
                                        Client.getInstance().getNotificationManager().send(new Notification("Now Playing", "Music is too long."));
                                    }

                                    Class6542 var15 = new Class6542(var13.method23320());
                                    Class8210 var16 = new Class8210();

                                    while (var13.method23323()) {
                                        while (!this.field32144) {
                                            this.field32163.clear();
                                            if (Thread.interrupted()) {
                                                this.field32166.close();
                                                return;
                                            }
                                        }

                                        Class1994 var18 = var13.method23324();
                                        var15.method19888(var18.method8282(), var16);
                                        var3 = var16.method28523();
                                        this.field32166.write((byte[]) var3, 0, ((byte[]) var3).length);
                                        float[] var29 = method24305(var16.method28523(), var14);
                                        Class7898 var19 = new Class7898(var29.length);
                                        float[][] var20 = var19.method26462(var29);
                                        float[] var21 = var20[0];
                                        float[] var22 = var20[1];
                                        this.field32163.add(method24306(var21, var22));
                                        if (this.field32163.size() > 18) {
                                            this.field32163.remove(0);
                                        }

                                        this.method24328(this.field32166, this.field32146);
                                        if (!Thread.interrupted()) {
                                            this.field32158 = Math.round(var13.method23327());
                                            this.field32170 = var13.method23326();
                                            if (this.field32169) {
                                                var13.method23325(this.field32168);
                                                this.field32158 = (long) this.field32168;
                                                this.field32169 = false;
                                            }
                                        }

                                        if (!var13.method23323()
                                                && (this.field32162 == Class189.field718 || this.field32162 == Class189.field717 && this.field32145.youtubeVideos.size() == 1)) {
                                            var13.method23325(0.0);
                                            this.field32158 = 0L;
                                        }

                                        if (Thread.interrupted()) {
                                            this.field32166.close();
                                            return;
                                        }
                                    }

                                    this.field32166.close();
                                    var9.close();
                                }
                            } catch (IOException var24) {
                                if (var24.getMessage() != null && var24.getMessage().contains("403")) {
                                    System.out.println("installing");
                                    this.download();
                                }
                            } catch (LineUnavailableException var25) {
                                var25.printStackTrace();
                            }

                            if (this.field32162 == Class189.field718) {
                                var4--;
                            } else if (this.field32162 == Class189.field717 && var4 == this.field32145.youtubeVideos.size() - 1) {
                                var4 = -1;
                            } else if (this.field32162 == Class189.field716) {
                                return;
                            }

                            if (var4 >= this.field32145.youtubeVideos.size()) {
                                var4 = 0;
                            }
                        }
                    }
            );
            this.field32156.start();
        }
    }

    public void method24303(Class189 var1) {
        this.field32162 = var1;
        this.method24294();
    }

    public Class189 method24304() {
        return this.field32162;
    }

    public void method24309(YoutubeVideoData var1) {
        try {
            this.field32154 = true;
            BufferedImage var4 = ImageIO.read(new URL(var1.fullUrl));
            this.field32152 = ImageUtil.method35032(var4, 15);
            this.field32152 = this.field32152
                    .getSubimage(0, (int) ((float) this.field32152.getHeight() * 0.75F), this.field32152.getWidth(), (int) ((float) this.field32152.getHeight() * 0.2F));
            this.field32150 = var1.title;
            if (var4.getHeight() != var4.getWidth()) {
                if (this.field32150.contains("[NCS Release]")) {
                    this.field32149 = var4.getSubimage(1, 3, 170, 170);
                } else {
                    this.field32149 = var4.getSubimage(70, 0, 180, 180);
                }
            } else {
                this.field32149 = var4;
            }

            this.field32160 = null;
        } catch (IOException | NumberFormatException var5) {
            var5.printStackTrace();
        }
    }

    public void method24310(boolean var1) {
        if (!var1 && this.field32166 != null) {
            this.field32166.flush();
        }

        this.field32144 = var1;
    }

    public void method24311(int var1) {
        this.field32146 = var1;
        this.method24294();
    }

    public void method24312(boolean var1) {
        this.field32161 = var1;
        this.method24294();
    }

    public boolean method24313() {
        return this.field32161;
    }

    public int method24314() {
        return this.field32146;
    }

    public void method24315() {
        if (this.field32145 != null) {
            this.field32159 = this.field32157 - 1;
            this.field32158 = 0L;
            this.field32170 = 0.0;
            this.method24302();
        }
    }

    public void method24316() {
        if (this.field32145 != null) {
            this.field32159 = this.field32157 + 1;
            this.field32158 = 0L;
            this.field32170 = 0.0;
            this.method24302();
        }
    }

    public void method24317(MusicPlayerVideo var1, YoutubeVideoData var2) {
        if (var1 == null) {
            var1 = new MusicPlayerVideo("temp", "temp", YoutubeType.PLAYLIST);
            var1.youtubeVideos.add(var2);
        }

        this.field32145 = var1;
        this.field32144 = true;
        this.field32158 = 0L;
        this.field32170 = 0.0;

        for (int var5 = 0; var5 < var1.youtubeVideos.size(); var5++) {
            if (var1.youtubeVideos.get(var5) == var2) {
                this.field32159 = var5;
            }
        }

        this.method24302();
    }

    public boolean method24319() {
        return this.field32144;
    }

    public long method24321() {
        return this.field32158;
    }

    public double method24322() {
        return this.field32170;
    }

    public URL method24323(URL var1) {
        String var4 = var1.toString();
        String var5 = System.getProperty("user.home");
        YoutubeDLRequest request = new YoutubeDLRequest(var4, var5);
        request.setOption("get-url");
        request.setOption("no-check-certificate");
        request.setOption("rm-cache-dir");
        request.setOption("retries", "10");
        request.setOption("format", "18");

        try {
            YoutubeDL.setExecutablePath(this.method24333());
            YoutubeDLResponse var7 = YoutubeDL.execute(request);
            String var8 = var7.getOut();
            return new URL(var8);
        } catch (YoutubeDLException var9) {
            Client.getInstance().getNotificationManager().send(
                    new Notification("Failed to Play Song", "Check the logs for more details.")
            );

            this.stopYtDlp();

            return null;
        } catch (MalformedURLException var10) {
            MultiUtilities.addChatMessage("URL Error: " + var10.toString());
            var10.printStackTrace();

            Client.getInstance().getNotificationManager().send(
                    new Notification("Failed to Play Song", "Invalid URL encountered.")
            );

            this.stopYtDlp();

            return null;
        }
    }

    private void stopYtDlp() {
        try {
            String fileName = Util.getOSType() == Util.OS.WINDOWS ? "yt-dlp.exe"
                    : Util.getOSType() == Util.OS.LINUX ? "yt-dlp_linux"
                    : "yt-dlp_macos";

            File ytDlpFile = new File(Client.getInstance().getFile() + "/music/" + fileName);

            if (ytDlpFile.exists()) {
                ProcessBuilder pb = new ProcessBuilder("taskkill", "/F", "/IM", ytDlpFile.getName());
                pb.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String method24324() {
        return this.field32150;
    }

    public Texture method24325() {
        return this.field32153;
    }

    public Texture method24326() {
        return this.field32151;
    }

    public int method24327() {
        return (int) this.field32147;
    }

    private void method24328(SourceDataLine var1, int var2) {
        try {
            FloatControl var5 = (FloatControl) var1.getControl(Type.MASTER_GAIN);
            BooleanControl var6 = (BooleanControl) var1.getControl(javax.sound.sampled.BooleanControl.Type.MUTE);
            if (var2 == 0) {
                var6.setValue(true);
            } else {
                var6.setValue(false);
                var5.setValue((float) (Math.log((double) var2 / 100.0) / Math.log(10.0) * 20.0));
            }
        } catch (Exception ignored) {
        }
    }

    public void method24329(double var1) {
        this.field32168 = var1;
        this.field32158 = (long) this.field32168;
        this.field32169 = true;
    }

    public boolean method24330() {
        File var3 = new File(Client.getInstance().getFile() + "/music/yt-dlp");
        if (Util.getOSType() == Util.OS.WINDOWS) {
            var3 = new File(Client.getInstance().getFile() + "/music/yt-dlp.exe");
        } else if (Util.getOSType() == Util.OS.LINUX) {
            var3 = new File(Client.getInstance().getFile() + "/music/yt-dlp_linux");
        } else if (Util.getOSType() == Util.OS.OSX) {
            var3 = new File(Client.getInstance().getFile() + "/music/yt-dlp_macos");
        }

        return var3.exists();
    }

    public void method24331() {
        Client.getInstance().getLogger().dummyMethod("Updating dependencies threaded");
        new Thread(this::download).start();
    }

    public void download() {
        if (!this.finished) {
            if (Util.getOSType() == Util.OS.WINDOWS || Util.getOSType() == Util.OS.OSX || Util.getOSType() == Util.OS.LINUX) {
                File musicDir = new File(Client.getInstance().getFile() + "/music/");
                musicDir.mkdirs();

                String fileName =
                        Util.getOSType() == Util.OS.WINDOWS ? "yt-dlp.exe"
                        : Util.getOSType() == Util.OS.LINUX ? "yt-dlp_linux"
                                                       : "yt-dlp_macos";

                File targetFile = new File(Client.getInstance().getFile() + "/music/" + fileName);

                String urlString = "https://github.com/yt-dlp/yt-dlp/releases/download/2024.11.04/" + fileName;
                try (BufferedInputStream in = new BufferedInputStream(new URL(urlString).openStream());
                     FileOutputStream fileOutputStream = new FileOutputStream(targetFile)) {
                    byte[] dataBuffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                        fileOutputStream.write(dataBuffer, 0, bytesRead);
                    }
                    finished = true;
                    System.out.println("Finished downloading yt-dlp");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    finished = false;
                }
            } else {
                System.out.println("Failed to extract yt-dlp, because your OS is unsupported.");
                finished = false;
            }
        }
    }

    public String method24333() {
        String fileName =
        Util.getOSType() == Util.OS.WINDOWS ? "yt-dlp.exe"
        : Util.getOSType() == Util.OS.LINUX ? "yt-dlp_linux"
                                       : "yt-dlp_macos";
        String var3 = Client.getInstance().getFile().getAbsolutePath() + "/music/" + fileName;
        if (Util.getOSType() != Util.OS.WINDOWS) {
            File var4 = new File(var3);
            var4.setExecutable(true);
        }

        return var3;
    }

    public boolean hasPython() {
        if (Util.getOSType() == Util.OS.WINDOWS) {
            return true;
        } else {
            File var3 = new File("/usr/local/bin/python");
            if (var3.exists()) {
                Process var4;

                try {
                    var4 = new ProcessBuilder("/usr/local/bin/python", "-V").start();
                    InputStream var5 = var4.getErrorStream();
                    InputStreamReader var6 = new InputStreamReader(var5);
                    BufferedReader bufferedReader = new BufferedReader(var6);

                    String version;
                    try {
                        while ((version = bufferedReader.readLine()) != null) {
                            if (version.contains("3.12.5")) {
                                return true;
                            }
                        }
                    } catch (IOException ignored) {
                    }
                } catch (IOException ignored) {
                }
            }

            return false;
        }
    }

    public boolean hasVCRedist() {
        if (Util.getOSType() != Util.OS.WINDOWS) {
            return true;
        } else {
            boolean var3 = false;

            try {
                var3 = Advapi32Util.registryGetIntValue(
                        WinReg.HKEY_LOCAL_MACHINE, "SOFTWARE\\WOW6432Node\\Microsoft\\VisualStudio\\10.0\\VC\\VCRedist\\x86", "Installed"
                )
                        == 1;
            } catch (RuntimeException ignored) {
            }

            try {
                var3 = var3
                        || Advapi32Util.registryGetIntValue(WinReg.HKEY_LOCAL_MACHINE, "SOFTWARE\\Microsoft\\VisualStudio\\10.0\\VC\\VCRedist\\x86", "Installed") == 1;
            } catch (RuntimeException ignored) {
            }

            return var3;
        }
    }
}
