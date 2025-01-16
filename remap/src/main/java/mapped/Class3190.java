// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.HashMap;

public class Class3190 extends Class3167
{
    public HashMap<UUID, Class8124> field15594;
    private Class8013 field15595;
    
    public Class3190() {
        super(Class8013.field32984, "Waypoints", "Renders waypoints you added in Jello maps");
        this.field15594 = new HashMap<UUID, Class8124>();
        this.field15595 = Class8013.field32985;
        this.method9881(new Class4999("Unspawn Positions", "Adds a waypoint when a player unspawns", false));
        this.method9915(false);
    }
    
    @Class6753
    public void method10005(final Class5732 class5732) {
        this.field15594.clear();
    }
    
    @Class6753
    public void method10006(final Class5723 class5723) {
        if (Class3190.field15514.field4683 != null) {
            if (!(class5723.method16998() instanceof Class4325)) {
                if (!(class5723.method16998() instanceof Class4339)) {
                    if (!(class5723.method16998() instanceof Class4276)) {
                        if (class5723.method16998() instanceof Class4361) {
                            final Class4361 class5724 = (Class4361)class5723.method16998();
                            if (this.field15594.containsKey(class5724.method13116())) {
                                this.field15594.remove(class5724.method13116());
                            }
                        }
                    }
                    else {
                        final Class4276 class5725 = (Class4276)class5723.method16998();
                        if (this.field15594.containsKey(class5725.method12830())) {
                            this.field15594.remove(class5725.method12830());
                        }
                    }
                }
                else {
                    final Class4339 class5726 = (Class4339)class5723.method16998();
                    if (this.field15594.containsKey(class5726.method13024())) {
                        this.field15594.remove(class5726.method13024());
                    }
                }
            }
            else {
                final int[] method12989 = ((Class4325)class5723.method16998()).method12989();
                for (int length = method12989.length, i = 0; i < length; ++i) {
                    final Entity method12990 = Class3190.field15514.field4683.getEntityByID(method12989[i]);
                    if (method12990 != null) {
                        if (method12990 instanceof PlayerEntity) {
                            if (this.field15594.containsKey(method12990.method1865())) {
                                this.field15594.remove(method12990.method1865());
                            }
                            this.field15594.put(method12990.method1865(), new Class8124(method12990.getName().getUnformattedComponentText() + " Unspawn", (int)method12990.posX, (int)method12990.posY, (int)method12990.posZ, Class265.field1284.field1292));
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public void method9879() {
    }
    
    @Override
    public void method9897() {
        this.field15594.clear();
    }
    
    public List<Class8124> method10007(final List<Class8124> c) {
        final ArrayList list = new ArrayList((Collection<? extends E>)c);
        if (this.method9883("Unspawn Positions")) {
            list.addAll(this.field15594.values());
        }
        list.sort((class8124, class8125) -> (Class3190.field15514.field4684.method1733(class8124.field33469, class8124.field33472, class8124.field33470) >= Class3190.field15514.field4684.method1733(class8125.field33469, class8125.field33472, class8125.field33470)) ? -1 : 1);
        return list;
    }
    
    @Class6753
    public void method10008(final Class5739 class5739) {
        if (this.method9906()) {
            for (final Class8124 class5740 : this.method10007(Class9463.method35173().method35200().method24262())) {
                final BlockPos class5741 = new BlockPos(class5740.field33469 - ((class5740.field33469 <= 0) ? 1 : 0), class5740.field33472, class5740.field33470 - ((class5740.field33470 <= 0) ? 1 : 0));
                if (Math.sqrt(Class8591.method29092(class5741)) <= 300.0) {
                    if (Class3190.field15514.field4683.method6965(class5741) != null) {
                        if (class5740.field33473) {
                            int n = class5741.getX() % 16;
                            int n2 = class5741.getZ() % 16;
                            if (n2 < 0) {
                                n2 += 16;
                            }
                            if (n < 0) {
                                n += 16;
                            }
                            int method35713 = Class3190.field15514.field4683.method6965(class5741).method7017(Class2020.field11522).method35713(n, n2);
                            if (method35713 == 0) {
                                method35713 = 64;
                            }
                            if (method35713 != class5740.field33472) {
                                final Class8124 class5742 = class5740;
                                class5742.field33472 += (method35713 - class5740.field33472) * 0.1f;
                            }
                        }
                    }
                    final float n3 = (float)(class5740.field33472 - Class869.method5277().field4644.method5833().method18161().getY());
                    float n4 = (float)(class5740.field33469 - Class869.method5277().field4644.method5833().method18161().getX());
                    float n5 = (float)(class5740.field33470 - Class869.method5277().field4644.method5833().method18161().getZ());
                    if (class5740.field33469 < 0) {
                        --n4;
                    }
                    if (class5740.field33470 < 0) {
                        --n5;
                    }
                    this.method10014(n4, n3, n5, class5740.field33468, class5740.field33471, (float)Math.max(1.0, Math.sqrt(Class8591.method29092(class5741) / 30.0)));
                }
            }
            Class8726.method30084(33986, 240.0f, 240.0f);
            Class7777.method24931();
            final Class1663 method35714 = Class3190.field15514.method5290();
            Class3190.field15514.method5290();
            method35714.method5849(Class1663.field9428);
        }
    }
    
    private void method10009(final int n) {
        for (int i = 0; i <= 270; i += 90) {
            GL11.glPushMatrix();
            GL11.glRotatef((float)i, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
            this.method10010(Class6430.method19120(Class265.field1273.field1292, n, 0.04f * i / 90.0f));
            GL11.glPopMatrix();
        }
        for (int j = 0; j <= 270; j += 90) {
            GL11.glPushMatrix();
            GL11.glRotatef((float)j, 0.0f, 1.0f, 0.0f);
            this.method10010(Class6430.method19120(Class265.field1273.field1292, n, 0.04f * j / 90.0f));
            GL11.glPopMatrix();
        }
    }
    
    private void method10010(final int n) {
        GL11.glColor4fv(Class6430.method19139(n));
        GL11.glTranslatef(0.0f, 0.0f, 0.3f);
        GL11.glNormal3f(0.0f, 0.0f, 1.0f);
        GL11.glRotated(-37.0, 1.0, 0.0, 0.0);
        GL11.glBegin(6);
        GL11.glVertex2f(0.0f, 0.4985f);
        GL11.glVertex2f(-0.3f, 0.0f);
        GL11.glVertex2f(0.3f, 0.0f);
        GL11.glEnd();
    }
    
    private void method10011(final float n, final float n2, final float n3, final float n4) {
        GL11.glColor4f(n / 255.0f, n2 / 255.0f, n3 / 255.0f, n4);
        GL11.glTranslatef(0.0f, 0.0f, 0.3f);
        GL11.glNormal3f(0.0f, 0.0f, 1.0f);
        GL11.glRotated(-37.0, 1.0, 0.0, 0.0);
        GL11.glBegin(6);
        GL11.glVertex2f(0.0f, 0.0f);
        GL11.glVertex2f(0.0f, 0.5f);
        GL11.glVertex2f(0.5f, 0.5f);
        GL11.glVertex2f(0.5f, 0.0f);
        GL11.glEnd();
    }
    
    private void method10012(final float n) {
        GL11.glBegin(2);
        for (int i = 0; i < 360; ++i) {
            final double n2 = i * 3.141592653589793 / 180.0;
            GL11.glVertex2d(Math.cos(n2) * n, Math.sin(n2) * n);
        }
        GL11.glEnd();
    }
    
    private void method10013(final float n) {
        GL11.glBegin(6);
        for (int i = 0; i < 360; ++i) {
            final double n2 = i * 3.141592653589793 / 180.0;
            GL11.glVertex2d(Math.cos(n2) * n, Math.sin(n2) * n);
        }
        GL11.glEnd();
    }
    
    public void method10014(final float n, final float n2, final float n3, final String s, final int n4, final float n5) {
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glEnable(2848);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        GL11.glPushMatrix();
        GL11.glAlphaFunc(519, 0.0f);
        GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.114f);
        GL11.glTranslated(n + 0.5, (double)n2, n3 + 0.5);
        GL11.glRotatef(90.0f, -1.0f, 0.0f, 0.0f);
        this.method10013(0.5f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glColor4fv(Class6430.method19139(n4));
        GL11.glTranslated(n + 0.5, (double)(n2 + 0.7f), n3 + 0.5);
        GL11.glRotatef((float)(Class3190.field15514.field4684.ticksExisted % 90 * 4), 0.0f, -1.0f, 0.0f);
        GL11.glLineWidth(1.4f + 1.0f / n5 * 1.4f);
        this.method10012(0.6f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslated(n + 0.5, (double)(n2 + 0.7f), n3 + 0.5);
        GL11.glRotatef((float)(Class3190.field15514.field4684.ticksExisted % 90 * 4), 0.0f, 1.0f, 0.0f);
        this.method10009(n4);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glAlphaFunc(519, 0.0f);
        GL11.glTranslated(n + 0.5, n2 + 1.9, n3 + 0.5);
        GL11.glRotatef(Class3190.field15514.field4644.method5833().method18164(), 0.0f, -1.0f, 0.0f);
        GL11.glRotatef(Class3190.field15514.field4644.method5833().method18163(), 1.0f, 0.0f, 0.0f);
        final Class7524 field40314 = Class9400.field40314;
        GL11.glPushMatrix();
        GL11.glScalef(-0.009f * n5, -0.009f * n5, -0.009f * n5);
        GL11.glTranslated(0.0, -20.0 * Math.sqrt(Math.sqrt(n5)), 0.0);
        Class8154.method26876((float)(-field40314.method23505(s) / 2 - 14), -5.0f, field40314.method23505(s) / 2.0f + 14.0f, (float)(field40314.method23539() + 7), Class6430.method19118(Class6430.method19120(Class265.field1278.field1292, Class265.field1273.field1292, 75.0f), 0.5f));
        Class8154.method26913((float)(-field40314.method23505(s) / 2 - 14), -5.0f, (float)(field40314.method23505(s) + 28), (float)(field40314.method23539() + 12), 20.0f, 0.5f);
        GL11.glTranslated((double)(-field40314.method23505(s) / 2), 0.0, 0.0);
        Class8154.method26889(field40314, 0.0f, 0.0f, s, Class6430.method19118(Class265.field1278.field1292, 0.8f));
        GL11.glPopMatrix();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glEnable(2896);
        GL11.glDisable(2848);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
    }
}
