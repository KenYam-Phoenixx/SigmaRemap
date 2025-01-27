// 
// Decompiled by Procyon v0.6.0
// 

package com.mentalfrostbyte.jello.mods;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import com.mentalfrostbyte.Client;
import com.mentalfrostbyte.jello.mods.util.InDevelopment;
import com.mentalfrostbyte.jello.settings.Setting;
import com.mentalfrostbyte.jello.settings.impl.StringSetting;
import mapped.*;

@InDevelopment
public class ModuleWithSettings extends Module
{
    public Module[] field15742;
    public Module field15743;
    private List<String> field15744;
    public StringSetting field15745;
    private final List<Class8510> field15746;
    
    public ModuleWithSettings(final Category class8013, final String str, final String s, final Module... field15742) {
        super(class8013, str, s);
        this.field15744 = new ArrayList<String>();
        this.field15746 = new ArrayList<Class8510>();
        this.field15742 = field15742;
        for (final Module class8014 : this.field15742) {
            Client.method35173().method35188().method21094(class8014);
            this.field15744.add(class8014.getName());
            class8014.method9913(this);
        }
        this.addSetting(this.field15745 = new StringSetting("Type", str + " mode", 0, (String[])this.field15744.toArray(new String[0])));
        this.field15745.method15195(class4997 -> this.method10258());
        this.method10258();
    }
    
    public void method10258() {
        this.method10259();
        for (final Module field15743 : this.field15742) {
            final boolean equals = this.method9887("Type").equals(field15743.name);
            if (this.method9906() && ModuleWithSettings.mc.player != null) {
                field15743.method9907(equals);
                if (equals) {
                    this.field15743 = field15743;
                }
            }
            else if (this.method9906()) {
                field15743.method9908(equals);
            }
            this.method10262(field15743, equals);
        }
    }
    
    private void method10259() {
        int n = 0;
        final Module[] field15742 = this.field15742;
        for (int length = field15742.length, i = 0; i < length; ++i) {
            if (this.method9887("Type").equals(field15742[i].name)) {
                n = 1;
            }
        }
        if (n == 0) {
            this.method9893("Type", this.field15742[0].name);
        }
    }
    
    public Module method10260() {
        this.method10259();
        for (final Module class3167 : this.field15742) {
            if (this.method9887("Type").equals(class3167.name)) {
                return class3167;
            }
        }
        return null;
    }
    
    @Override
    public boolean method9898() {
        if (this.field15743 == null) {
            this.method10258();
        }
        return (this.field15743 != null) ? this.field15743.method9898() : this.method9906();
    }
    
    @Override
    public JSONObject method9895(final JSONObject JSONObject) {
        final JSONObject method26637 = Class8105.method26637(JSONObject, "sub-options");
        if (method26637 != null) {
            for (final Module class4406 : this.field15742) {
                final Class88 method26638 = Class8105.method26638(method26637, class4406.getName());
                if (method26638 != null) {
                    for (int j = 0; j < method26638.method462(); ++j) {
                        final JSONObject method26639 = method26638.method457(j);
                        Object method26640 = null;
                        try {
                            method26640 = Class8105.method26636(method26639, "name", null);
                        }
                        catch (final JSONException class4407) {}
                        for (final Setting class4408 : class4406.field15525.values()) {
                            if (class4408.method15204().equals(method26640)) {
                                try {
                                    class4408.method15186(method26639);
                                }
                                catch (final JSONException class4409) {
                                    Client.method35173().method35187().method20241("Could not initialize settings of " + class4406.getName() + "." + class4408.method15204() + " from config.");
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        final JSONObject method26641 = super.method9895(JSONObject);
        if (this.enabled) {
            this.method10258();
        }
        return method26641;
    }
    
    @Override
    public JSONObject method9896(final JSONObject JSONObject) {
        final JSONObject class4406 = new JSONObject();
        for (final Module class4407 : this.field15742) {
            final Class88 class4408 = new Class88();
            final Iterator<Setting> iterator = class4407.field15525.values().iterator();
            while (iterator.hasNext()) {
                class4408.method486(iterator.next().method15193(new JSONObject()));
            }
            class4406.method13301(class4407.getName(), class4408);
        }
        JSONObject.method13301("sub-options", class4406);
        return super.method9896(JSONObject);
    }
    
    @Override
    public void method9879() {
        this.method10258();
        if (this.field15743 instanceof PremiumModule) {
            if (!Client.method35173().method35201().method19352()) {
                this.method9908(false);
            }
        }
    }
    
    @Override
    public void onDisable() {
        final Module[] field15742 = this.field15742;
        for (int length = field15742.length, i = 0; i < length; ++i) {
            field15742[i].method9909(false);
        }
    }
    
    @Override
    public void method9894() {
        final Module[] field15742 = this.field15742;
        for (int length = field15742.length, i = 0; i < length; ++i) {
            field15742[i].method9907(false);
        }
        super.method9894();
    }
    
    public final ModuleWithSettings method10261(final Class8510 class8510) {
        this.field15746.add(class8510);
        return this;
    }
    
    public final void method10262(final Module class3167, final boolean b) {
        final Iterator<Class8510> iterator = this.field15746.iterator();
        while (iterator.hasNext()) {
            iterator.next().method28430(this, class3167, b);
        }
    }
    
    @Override
    public void method9917() {
        super.method9917();
        final Module[] field15742 = this.field15742;
        for (int length = field15742.length, i = 0; i < length; ++i) {
            field15742[i].method9917();
        }
    }
}
