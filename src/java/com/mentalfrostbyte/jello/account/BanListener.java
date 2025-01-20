package com.mentalfrostbyte.jello.account;

import com.mentalfrostbyte.Client;
import com.mentalfrostbyte.jello.event.EventTarget;
import com.mentalfrostbyte.jello.event.impl.ReceivePacketEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.network.login.server.SDisconnectLoginPacket;
import net.minecraft.network.login.server.SLoginSuccessPacket;
import net.minecraft.network.play.server.SDisconnectPacket;
import net.minecraft.network.play.server.SChatPacket;
import totalcross.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BanListener {
    public Minecraft field38719 = Minecraft.getInstance();

    @EventTarget
    private void method30840(ReceivePacketEvent var1) throws JSONException {
        if (this.field38719.getCurrentServerData() != null) {
            if (var1.getPacket() instanceof SChatPacket) {
                SChatPacket var4 = (SChatPacket) var1.getPacket();
                ArrayList var5 = new ArrayList<String>(
                        Arrays.asList(
                                "You are permanently banned from MinemenClub. ",
                                "Your connection to the server leu-practice has been prevented due to you being associated to a blacklisted player.",
                                "You are blacklisted from MinemenClub. "
                        )
                );
                if (!var4.getChatComponent().getSiblings().isEmpty()
                        && var5.contains(var4.getChatComponent().getString())
                        && var4.getChatComponent().getSiblings().get(0).getStyle().getColor().toString().equalsIgnoreCase("red")) {
                    Account var6 = Client.getInstance().getAccountManager().containsAccount();
                    if (var6 != null) {
                        Ban var7 = new Ban(this.field38719.getCurrentServerData().serverIP, new Date(Long.MAX_VALUE));
                        var6.registerBan(var7);
                        Client.getInstance().getAccountManager().updateAccount(var6);
                        Client.getInstance().getAccountManager().saveAlts();
                    }
                }
            }

            if (!(var1.getPacket() instanceof SDisconnectLoginPacket)) {
                if (!(var1.getPacket() instanceof SDisconnectPacket)) {
                    if (var1.getPacket() instanceof SLoginSuccessPacket) {
                        long var11 = System.currentTimeMillis();
                        if (this.field38719.getCurrentServerData() == null) {
                            return;
                        }

                        Ban var15 = new Ban(this.field38719.getCurrentServerData().serverIP, new Date(var11));
                        Account var16 = Client.getInstance().getAccountManager().containsAccount();
                        if (var16 != null) {
                            var16.registerBan(var15);
                            Client.getInstance().getAccountManager().updateAccount(var16);
                            Client.getInstance().getAccountManager().saveAlts();
                        }
                    }
                } else {
                    SDisconnectPacket var13 = (SDisconnectPacket) var1.getPacket();
                    long var8 = this.method30841(var13.method17390().getString());
                    if (var8 == 0L) {
                        return;
                    }

                    Ban var17 = new Ban(this.field38719.getCurrentServerData().serverIP, new Date(var8));
                    Account var10 = Client.getInstance().getAccountManager().containsAccount();
                    if (var10 != null) {
                        var10.registerBan(var17);
                        Client.getInstance().getAccountManager().updateAccount(var10);
                        Client.getInstance().getAccountManager().saveAlts();
                    }
                }
            } else {
                SDisconnectLoginPacket var14 = (SDisconnectLoginPacket) var1.getPacket();
                long var19 = this.method30841(var14.getReason().getString());
                if (var19 == 0L) {
                    return;
                }

                Ban var18 = new Ban(this.field38719.getCurrentServerData().serverIP, new Date(var19));
                Account var20 = Client.getInstance().getAccountManager().containsAccount();
                if (var20 != null) {
                    var20.registerBan(var18);
                    Client.getInstance().getAccountManager().updateAccount(var20);
                    Client.getInstance().getAccountManager().saveAlts();
                }
            }
        }
    }

    private long method30841(String var1) {
        var1 = var1.toLowerCase();
        if (var1.contains("security") && var1.contains("alert")) {
            return 9223372036854775806L;
        } else if (!var1.contains("permanent")) {
            if (!var1.contains("your account has been suspended from")) {
                if (!var1.contains("tu cuenta ha sido suspendida. al reconectarte, tendr")) {
                    if (!var1.contains("compromised")) {
                        if (!var1.contains("gebannt")) {
                            long var4 = TimeUnit.DAYS.toMillis(this.method30842(var1));
                            long var6 = TimeUnit.HOURS.toMillis(this.method30843(var1));
                            long var8 = TimeUnit.MINUTES.toMillis(this.method30844(var1));
                            long var10 = TimeUnit.SECONDS.toMillis(this.method30845(var1));
                            if (var1.contains("§6 sentinel caught you cheating! (anticheat)") && var4 == 0L && var6 == 0L && var8 == 0L && var10 != 0L) {
                            }

                            return var1.contains("vous avez été banni") && var4 == 0L && var6 == 0L && var8 == 0L && var10 == 0L
                                    ? Long.MAX_VALUE
                                    : System.currentTimeMillis() + var4 + var6 + var8 + var10;
                        } else {
                            return Long.MAX_VALUE;
                        }
                    } else {
                        return 9223372036854775806L;
                    }
                } else {
                    return Long.MAX_VALUE;
                }
            } else {
                return Long.MAX_VALUE;
            }
        } else {
            return Long.MAX_VALUE;
        }
    }

    private int method30842(String var1) {
        String[] var4 = new String[]{"day", "jour", "tage", "día", "dia"};

        for (String var8 : var4) {
            Pattern var9 = Pattern.compile("([0-9]+)(?:d| " + var8 + "s|" + var8 + "s| " + var8 + "|" + var8 + ")[ |\\n]");
            Matcher var10 = var9.matcher(var1);
            if (var10.find()) {
                return Integer.parseInt(var10.group(1));
            }
        }

        return 0;
    }

    private int method30843(String var1) {
        String[] var4 = new String[]{"hour", "heure", "uhr", "hora"};

        for (String var8 : var4) {
            Pattern var9 = Pattern.compile("([0-9]+)(?:h| " + var8 + "s|" + var8 + "s| " + var8 + "|" + var8 + ")[ |\\n]");
            Matcher var10 = var9.matcher(var1);
            if (var10.find()) {
                return Integer.parseInt(var10.group(1));
            }
        }

        return 0;
    }

    private int method30844(String var1) {
        String[] var4 = new String[]{"minute", "min", "minuto", "mínuto"};

        for (String var8 : var4) {
            Pattern var9 = Pattern.compile("([0-9]+)(?:m| " + var8 + "s|" + var8 + "s| " + var8 + "|" + var8 + ")[ |\\n]");
            Matcher var10 = var9.matcher(var1);
            if (var10.find()) {
                return Integer.parseInt(var10.group(1));
            }
        }

        return 0;
    }

    private int method30845(String var1) {
        String[] var4 = new String[]{"second", "sec", "seconde", "sekunde", "segundo"};

        for (String var8 : var4) {
            Pattern var9 = Pattern.compile("([0-9]+)(?:s| " + var8 + "s|" + var8 + "s| " + var8 + "|" + var8 + ")[ |\\n]");
            Matcher var10 = var9.matcher(var1);
            if (var10.find()) {
                return Integer.parseInt(var10.group(1));
            }
        }

        return 0;
    }
}
