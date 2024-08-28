package mapped;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonSyntaxException;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap.Entry;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.util.text.StringTextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.*;

public class Class264 implements Class215, AutoCloseable {
   private static final Logger field930 = LogManager.getLogger();
   private static final ResourceLocation field931 = new ResourceLocation("textures/environment/moon_phases.png");
   private static final ResourceLocation field932 = new ResourceLocation("textures/environment/sun.png");
   private static final ResourceLocation field933 = new ResourceLocation("textures/environment/clouds.png");
   private static final ResourceLocation field934 = new ResourceLocation("textures/environment/end_sky.png");
   private static final ResourceLocation field935 = new ResourceLocation("textures/misc/forcefield.png");
   private static final ResourceLocation field936 = new ResourceLocation("textures/environment/rain.png");
   private static final ResourceLocation field937 = new ResourceLocation("textures/environment/snow.png");
   public static final Direction[] field938 = Direction.values();
   private final Minecraft field939;
   private final TextureManager field940;
   public final Class8853 field941;
   private final Class7911 field942;
   private Class1656 field943;
   private Set<Class8066> field944 = new ObjectLinkedOpenHashSet();
   private ObjectList<Class7002> field945 = new ObjectArrayList(69696);
   private final Set<Class944> field946 = Sets.newHashSet();
   private Class9242 field947;
   private final Class7831 field948 = Class9337.field43341;
   private Class1698 field949;
   private Class1698 field950;
   private Class1698 field951;
   private boolean field952 = true;
   private Class1698 field953;
   private final Class9633 field954 = new Class9633(100);
   private int field955;
   private final Int2ObjectMap<Class1995> field956 = new Int2ObjectOpenHashMap();
   private final Long2ObjectMap<SortedSet<Class1995>> field957 = new Long2ObjectOpenHashMap();
   private final Map<BlockPos, Class6340> field958 = Maps.newHashMap();
   public Framebuffer field959;
   private Class1647 field960;
   private Framebuffer field961;
   private Framebuffer field962;
   private Framebuffer field963;
   private Framebuffer field964;
   private Framebuffer field965;
   private Class1647 field966;
   private double field967 = Double.MIN_VALUE;
   private double field968 = Double.MIN_VALUE;
   private double field969 = Double.MIN_VALUE;
   private int field970 = Integer.MIN_VALUE;
   private int field971 = Integer.MIN_VALUE;
   private int field972 = Integer.MIN_VALUE;
   private double field973 = Double.MIN_VALUE;
   private double field974 = Double.MIN_VALUE;
   private double field975 = Double.MIN_VALUE;
   private double field976 = Double.MIN_VALUE;
   private double field977 = Double.MIN_VALUE;
   private int field978 = Integer.MIN_VALUE;
   private int field979 = Integer.MIN_VALUE;
   private int field980 = Integer.MIN_VALUE;
   private Vector3d field981 = Vector3d.field18047;
   private Class1904 field982;
   private Class9016 field983;
   private final Class7831 field984 = Class9337.field43334;
   private int field985 = -1;
   private int field986;
   private int field987;
   private boolean field988;
   private Class7647 field989;
   private final Class7755[] field990 = new Class7755[8];
   private final Class9184 field991 = new Class9184(0.0, 0.0, 0.0);
   private double field992;
   private double field993;
   private double field994;
   private boolean field995 = true;
   private int field996;
   private int field997;
   private final float[] field998 = new float[1024];
   private final float[] field999 = new float[1024];
   public Entity field1000;
   public Set field1001 = new LinkedHashSet();
   public Set field1002 = new LinkedHashSet();
   private Set<Class8066> field1003 = new ObjectLinkedOpenHashSet();
   private Deque field1004 = new ArrayDeque();
   private List<Class7002> field1005 = new ArrayList<Class7002>(1024);
   private List<Class7002> field1006 = new ArrayList<Class7002>(1024);
   private ObjectList field1007 = new ObjectArrayList(1024);
   private List field1008 = new ArrayList(1024);
   private List field1009 = new ArrayList(1024);
   private ObjectList field1010 = new ObjectArrayList(1024);
   private List field1011 = new ArrayList(1024);
   private List field1012 = new ArrayList(1024);
   private int field1013 = 0;
   private int field1014 = 0;
   private static final Set field1015 = Collections.<Direction>unmodifiableSet(new HashSet(Arrays.asList(Direction.field685)));
   private int field1016;
   private int field1017 = 0;
   private Class8391 field1018 = new Class8391(Blocks.AIR.method11579(), new BlockPos(0, 0, 0));
   public boolean field1019 = false;
   public boolean field1020 = false;
   private boolean field1021 = false;
   private static int field1022 = 0;
   public int field1023 = -1;
   public static final int field1024 = 201435902;
   private static boolean field1025 = false;
   private Map<String, List<Entity>> field1026 = new HashMap<String, List<Entity>>();
   private Map<Class4520, Map> field1027 = new LinkedHashMap<Class4520, Map>();

   @Nullable
   private Class8066 method854(BlockPos var1, Class8066 var2, Direction var3) {
      BlockPos var4 = var2.method27723(var3);
      if (MathHelper.method37772(var1.method8304() - var4.method8304()) > this.field985 * 16) {
         return null;
      } else if (var4.getY() >= 0 && var4.getY() < 256) {
         return MathHelper.method37772(var1.method8306() - var4.method8306()) > this.field985 * 16 ? null : this.field947.method34761(var4);
      } else {
         return null;
      }
   }

   public Class264(Minecraft var1, Class7911 var2) {
      this.field939 = var1;
      this.field941 = var1.method1554();
      this.field942 = var2;
      this.field940 = var1.getTextureManager();

      for (int var3 = 0; var3 < 32; var3++) {
         for (int var4 = 0; var4 < 32; var4++) {
            float var5 = (float)(var4 - 16);
            float var6 = (float)(var3 - 16);
            float var7 = MathHelper.method37765(var5 * var5 + var6 * var6);
            this.field998[var3 << 5 | var4] = -var6 / var7;
            this.field999[var3 << 5 | var4] = var5 / var7;
         }
      }

      this.method865();
      this.method863();
      this.method862();
   }

   private void method855(Class1699 var1, float var2, double var3, double var5, double var7) {
      if (Class9299.field42948.method20214()) {
         Class8296 var9 = (Class8296)Class9299.method35070(this.field943.method6830(), Class9299.field42948);
         if (var9 != null) {
            var9.method28999(this.field955, var2, this.field943, this.field939, var1, var3, var5, var7);
            return;
         }
      }

      float var48 = this.field939.field1338.method6792(var2);
      if (!(var48 <= 0.0F)) {
         if (Class7944.method26821()) {
            return;
         }

         var1.method7317();
         Class1656 var10 = this.field939.field1338;
         int var11 = MathHelper.method37769(var3);
         int var12 = MathHelper.method37769(var5);
         int var13 = MathHelper.method37769(var7);
         Class9352 var14 = Class9352.method35409();
         Class5425 var15 = var14.method35411();
         RenderSystem.disableAlphaTest();
         RenderSystem.method27850();
         RenderSystem.method27825(0.0F, 1.0F, 0.0F);
         RenderSystem.enableBlend();
         RenderSystem.method27938();
         RenderSystem.method27939();
         RenderSystem.enableDepthTest();
         int var16 = 5;
         if (Class7944.method26820()) {
            var16 = 10;
         }

         RenderSystem.depthMask(Minecraft.method1517());
         int var17 = -1;
         float var18 = (float)this.field955 + var2;
         RenderSystem.method27889(1.0F, 1.0F, 1.0F, 1.0F);
         Mutable var19 = new Mutable();

         for (int var20 = var13 - var16; var20 <= var13 + var16; var20++) {
            for (int var21 = var11 - var16; var21 <= var11 + var16; var21++) {
               int var22 = (var20 - var13 + 16) * 32 + var21 - var11 + 16;
               double var23 = (double)this.field998[var22] * 0.5;
               double var25 = (double)this.field999[var22] * 0.5;
               var19.method8372(var21, 0, var20);
               Class8907 var27 = var10.method7003(var19);
               if (var27.method32500() != Class87.field223) {
                  int var28 = var10.method7006(Class101.field299, var19).getY();
                  int var29 = var12 - var16;
                  int var30 = var12 + var16;
                  if (var29 < var28) {
                     var29 = var28;
                  }

                  if (var30 < var28) {
                     var30 = var28;
                  }

                  int var31 = var28;
                  if (var28 < var12) {
                     var31 = var12;
                  }

                  if (var29 != var30) {
                     Random var32 = new Random((long)(var21 * var21 * 3121 + var21 * 45238971 ^ var20 * var20 * 418711 + var20 * 13761));
                     var19.method8372(var21, var29, var20);
                     float var33 = var27.method32503(var19);
                     if (var33 >= 0.15F) {
                        if (var17 != 0) {
                           if (var17 >= 0) {
                              var14.method35410();
                           }

                           var17 = 0;
                           this.field939.getTextureManager().bindTexture(field936);
                           var15.method17063(7, Class9337.field43340);
                        }

                        int var34 = this.field955 + var21 * var21 * 3121 + var21 * 45238971 + var20 * var20 * 418711 + var20 * 13761 & 31;
                        float var35 = -((float)var34 + var2) / 32.0F * (3.0F + var32.nextFloat());
                        double var36 = (double)((float)var21 + 0.5F) - var3;
                        double var38 = (double)((float)var20 + 0.5F) - var7;
                        float var40 = MathHelper.method37766(var36 * var36 + var38 * var38) / (float)var16;
                        float var41 = ((1.0F - var40 * var40) * 0.5F + 0.5F) * var48;
                        var19.method8372(var21, var31, var20);
                        int var42 = method944(var10, var19);
                        var15.method17025((double)var21 - var3 - var23 + 0.5, (double)var30 - var5, (double)var20 - var7 - var25 + 0.5)
                           .method17027(0.0F, (float)var29 * 0.25F + var35)
                           .method17033(1.0F, 1.0F, 1.0F, var41)
                           .method17034(var42)
                           .method17031();
                        var15.method17025((double)var21 - var3 + var23 + 0.5, (double)var30 - var5, (double)var20 - var7 + var25 + 0.5)
                           .method17027(1.0F, (float)var29 * 0.25F + var35)
                           .method17033(1.0F, 1.0F, 1.0F, var41)
                           .method17034(var42)
                           .method17031();
                        var15.method17025((double)var21 - var3 + var23 + 0.5, (double)var29 - var5, (double)var20 - var7 + var25 + 0.5)
                           .method17027(1.0F, (float)var30 * 0.25F + var35)
                           .method17033(1.0F, 1.0F, 1.0F, var41)
                           .method17034(var42)
                           .method17031();
                        var15.method17025((double)var21 - var3 - var23 + 0.5, (double)var29 - var5, (double)var20 - var7 - var25 + 0.5)
                           .method17027(0.0F, (float)var30 * 0.25F + var35)
                           .method17033(1.0F, 1.0F, 1.0F, var41)
                           .method17034(var42)
                           .method17031();
                     } else {
                        if (var17 != 1) {
                           if (var17 >= 0) {
                              var14.method35410();
                           }

                           var17 = 1;
                           this.field939.getTextureManager().bindTexture(field937);
                           var15.method17063(7, Class9337.field43340);
                        }

                        float var49 = -((float)(this.field955 & 511) + var2) / 512.0F;
                        float var50 = (float)(var32.nextDouble() + (double)var18 * 0.01 * (double)((float)var32.nextGaussian()));
                        float var51 = (float)(var32.nextDouble() + (double)(var18 * (float)var32.nextGaussian()) * 0.001);
                        double var37 = (double)((float)var21 + 0.5F) - var3;
                        double var39 = (double)((float)var20 + 0.5F) - var7;
                        float var52 = MathHelper.method37766(var37 * var37 + var39 * var39) / (float)var16;
                        float var53 = ((1.0F - var52 * var52) * 0.3F + 0.5F) * var48;
                        var19.method8372(var21, var31, var20);
                        int var43 = method944(var10, var19);
                        int var44 = var43 >> 16 & 65535;
                        int var45 = (var43 & 65535) * 3;
                        int var46 = (var44 * 3 + 240) / 4;
                        int var47 = (var45 * 3 + 240) / 4;
                        var15.method17025((double)var21 - var3 - var23 + 0.5, (double)var30 - var5, (double)var20 - var7 - var25 + 0.5)
                           .method17027(0.0F + var50, (float)var29 * 0.25F + var49 + var51)
                           .method17033(1.0F, 1.0F, 1.0F, var53)
                           .method17029(var47, var46)
                           .method17031();
                        var15.method17025((double)var21 - var3 + var23 + 0.5, (double)var30 - var5, (double)var20 - var7 + var25 + 0.5)
                           .method17027(1.0F + var50, (float)var29 * 0.25F + var49 + var51)
                           .method17033(1.0F, 1.0F, 1.0F, var53)
                           .method17029(var47, var46)
                           .method17031();
                        var15.method17025((double)var21 - var3 + var23 + 0.5, (double)var29 - var5, (double)var20 - var7 + var25 + 0.5)
                           .method17027(1.0F + var50, (float)var30 * 0.25F + var49 + var51)
                           .method17033(1.0F, 1.0F, 1.0F, var53)
                           .method17029(var47, var46)
                           .method17031();
                        var15.method17025((double)var21 - var3 - var23 + 0.5, (double)var29 - var5, (double)var20 - var7 - var25 + 0.5)
                           .method17027(0.0F + var50, (float)var30 * 0.25F + var49 + var51)
                           .method17033(1.0F, 1.0F, 1.0F, var53)
                           .method17029(var47, var46)
                           .method17031();
                     }
                  }
               }
            }
         }

         if (var17 >= 0) {
            var14.method35410();
         }

         RenderSystem.method27849();
         RenderSystem.disableBlend();
         RenderSystem.method27939();
         RenderSystem.method27817();
         var1.method7316();
      }
   }

   public void method856(Class9624 var1) {
      float var2 = this.field939.field1338.method6792(1.0F) / (Minecraft.method1516() ? 1.0F : 2.0F);
      if (!Class7944.method26820()) {
         var2 /= 2.0F;
      }

      if (!(var2 <= 0.0F) && Class7944.method26847()) {
         Random var3 = new Random((long)this.field955 * 312987231L);
         Class1656 var4 = this.field939.field1338;
         BlockPos var5 = new BlockPos(var1.method37504());
         BlockPos var6 = null;
         int var7 = (int)(100.0F * var2 * var2) / (this.field939.field1299.field44674 == Class2294.field15247 ? 2 : 1);

         for (int var8 = 0; var8 < var7; var8++) {
            int var9 = var3.nextInt(21) - 10;
            int var10 = var3.nextInt(21) - 10;
            BlockPos var11 = var4.method7006(Class101.field299, var5.method8336(var9, 0, var10)).method8313();
            Class8907 var12 = var4.method7003(var11);
            if (var11.getY() > 0
               && var11.getY() <= var5.getY() + 10
               && var11.getY() >= var5.getY() - 10
               && var12.method32500() == Class87.field224
               && var12.method32503(var11) >= 0.15F) {
               var6 = var11;
               if (this.field939.field1299.field44674 == Class2294.field15248) {
                  break;
               }

               double var13 = var3.nextDouble();
               double var15 = var3.nextDouble();
               Class7380 var17 = var4.method6738(var11);
               Class7379 var18 = var4.method6739(var11);
               Class6408 var19 = var17.method23414(var4, var11);
               double var20 = var19.method19522(Class113.field414, var13, var15);
               double var22 = (double)var18.method23475(var4, var11);
               double var24 = Math.max(var20, var22);
               Class7435 var26 = !var18.method23486(Class8953.field40470) && !var17.method23448(Blocks.field36890) && !Class3244.method11655(var17)
                  ? Class7940.field34091
                  : Class7940.field34092;
               this.field939
                  .field1338
                  .method6746(var26, (double)var11.method8304() + var13, (double)var11.getY() + var24, (double)var11.method8306() + var15, 0.0, 0.0, 0.0);
            }
         }

         if (var6 != null && var3.nextInt(3) < this.field997++) {
            this.field997 = 0;
            if (var6.getY() > var5.getY() + 1
               && var4.method7006(Class101.field299, var5).getY() > MathHelper.method37767((float)var5.getY())) {
               this.field939.field1338.method6858(var6, Class6067.field27227, Class2266.field14731, 0.1F, 0.5F, false);
            } else {
               this.field939.field1338.method6858(var6, Class6067.field27226, Class2266.field14731, 0.2F, 1.0F, false);
            }
         }
      }
   }

   @Override
   public void close() {
      if (this.field960 != null) {
         this.field960.close();
      }

      if (this.field966 != null) {
         this.field966.close();
      }
   }

   @Override
   public void method737(Class191 var1) {
      this.field940.bindTexture(field935);
      RenderSystem.method27863(3553, 10242, 10497);
      RenderSystem.method27863(3553, 10243, 10497);
      RenderSystem.method27865(0);
      this.method857();
      if (Minecraft.method1517()) {
         this.method858();
      }
   }

   public void method857() {
      if (this.field960 != null) {
         this.field960.close();
      }

      ResourceLocation var1 = new ResourceLocation("shaders/post/entity_outline.json");

      try {
         this.field960 = new Class1647(this.field939.getTextureManager(), this.field939.method1537(), this.field939.method1464(), var1);
         this.field960.method6525(this.field939.method1580().method8041(), this.field939.method1580().method8042());
         this.field959 = this.field960.method6521("final");
      } catch (IOException var3) {
         field930.warn("Failed to load shader: {}", var1, var3);
         this.field960 = null;
         this.field959 = null;
      } catch (JsonSyntaxException var4) {
         field930.warn("Failed to parse shader: {}", var1, var4);
         this.field960 = null;
         this.field959 = null;
      }
   }

   private void method858() {
      this.method859();
      ResourceLocation var1 = new ResourceLocation("shaders/post/transparency.json");

      try {
         Class1647 var2 = new Class1647(this.field939.getTextureManager(), this.field939.method1537(), this.field939.method1464(), var1);
         var2.method6525(this.field939.method1580().method8041(), this.field939.method1580().method8042());
         Framebuffer var10 = var2.method6521("translucent");
         Framebuffer var11 = var2.method6521("itemEntity");
         Framebuffer var12 = var2.method6521("particles");
         Framebuffer var14 = var2.method6521("weather");
         Framebuffer var7 = var2.method6521("clouds");
         this.field966 = var2;
         this.field961 = var10;
         this.field962 = var11;
         this.field963 = var12;
         this.field964 = var14;
         this.field965 = var7;
      } catch (Exception var9) {
         String var3 = var9 instanceof JsonSyntaxException ? "parse" : "load";
         String var4 = "Failed to " + var3 + " shader: " + var1;
         Class2493 var5 = new Class2493(var4, var9);
         if (this.field939.method1538().method1269().size() > 1) {
            StringTextComponent var6;
            try {
               var6 = new StringTextComponent(this.field939.method1537().method580(var1).method7765());
            } catch (IOException var8) {
               var6 = null;
            }

            this.field939.field1299.field44578 = Class2087.field13604;
            this.field939.method1459(var5, var6);
         } else {
            Class4526 var13 = this.field939.method1521(new Class4526(var4, var5));
            this.field939.field1299.field44578 = Class2087.field13604;
            this.field939.field1299.method37146();
            field930.fatal(var4, var5);
            this.field939.method1484();
            Minecraft.method1468(var13);
         }
      }
   }

   private void method859() {
      if (this.field966 != null) {
         this.field966.close();
         this.field961.method29105();
         this.field962.method29105();
         this.field963.method29105();
         this.field964.method29105();
         this.field965.method29105();
         this.field966 = null;
         this.field961 = null;
         this.field962 = null;
         this.field963 = null;
         this.field964 = null;
         this.field965 = null;
      }
   }

   public void method860() {
      if (this.method861()) {
         RenderSystem.enableBlend();
         RenderSystem.method27836(Class2339.field15997, Class1981.field12932, Class2339.field16000, Class1981.field12927);
         this.field959.method29117(this.field939.method1580().method8041(), this.field939.method1580().method8042(), false);
         RenderSystem.disableBlend();
      }
   }

   public boolean method861() {
      return !Class7944.method26921() && !Class7944.method26892() ? this.field959 != null && this.field960 != null && this.field939.field1339 != null : false;
   }

   private void method862() {
      Class9352 var1 = Class9352.method35409();
      Class5425 var2 = var1.method35411();
      if (this.field951 != null) {
         this.field951.close();
      }

      this.field951 = new Class1698(this.field948);
      this.method864(var2, -16.0F, true);
      var2.method17065();
      this.field951.method7303(var2);
   }

   private void method863() {
      Class9352 var1 = Class9352.method35409();
      Class5425 var2 = var1.method35411();
      if (this.field950 != null) {
         this.field950.close();
      }

      this.field950 = new Class1698(this.field948);
      this.method864(var2, 16.0F, false);
      var2.method17065();
      this.field950.method7303(var2);
   }

   private void method864(Class5425 var1, float var2, boolean var3) {
      int var4 = 64;
      int var5 = 6;
      var1.method17063(7, Class9337.field43341);
      int var6 = (this.field1013 / 64 + 1) * 64 + 64;

      for (int var7 = -var6; var7 <= var6; var7 += 64) {
         for (int var8 = -var6; var8 <= var6; var8 += 64) {
            float var9 = (float)var7;
            float var10 = (float)(var7 + 64);
            if (var3) {
               var10 = (float)var7;
               var9 = (float)(var7 + 64);
            }

            var1.method17025((double)var9, (double)var2, (double)var8).method17031();
            var1.method17025((double)var10, (double)var2, (double)var8).method17031();
            var1.method17025((double)var10, (double)var2, (double)(var8 + 64)).method17031();
            var1.method17025((double)var9, (double)var2, (double)(var8 + 64)).method17031();
         }
      }
   }

   private void method865() {
      Class9352 var1 = Class9352.method35409();
      Class5425 var2 = var1.method35411();
      if (this.field949 != null) {
         this.field949.close();
      }

      this.field949 = new Class1698(this.field948);
      this.method866(var2);
      var2.method17065();
      this.field949.method7303(var2);
   }

   private void method866(Class5425 var1) {
      Random var2 = new Random(10842L);
      var1.method17063(7, Class9337.field43341);

      for (int var3 = 0; var3 < 1500; var3++) {
         double var4 = (double)(var2.nextFloat() * 2.0F - 1.0F);
         double var6 = (double)(var2.nextFloat() * 2.0F - 1.0F);
         double var8 = (double)(var2.nextFloat() * 2.0F - 1.0F);
         double var10 = (double)(0.15F + var2.nextFloat() * 0.1F);
         double var12 = var4 * var4 + var6 * var6 + var8 * var8;
         if (var12 < 1.0 && var12 > 0.01) {
            var12 = 1.0 / Math.sqrt(var12);
            var4 *= var12;
            var6 *= var12;
            var8 *= var12;
            double var14 = var4 * 100.0;
            double var16 = var6 * 100.0;
            double var18 = var8 * 100.0;
            double var20 = Math.atan2(var4, var8);
            double var22 = Math.sin(var20);
            double var24 = Math.cos(var20);
            double var26 = Math.atan2(Math.sqrt(var4 * var4 + var8 * var8), var6);
            double var28 = Math.sin(var26);
            double var30 = Math.cos(var26);
            double var32 = var2.nextDouble() * Math.PI * 2.0;
            double var34 = Math.sin(var32);
            double var36 = Math.cos(var32);

            for (int var38 = 0; var38 < 4; var38++) {
               double var39 = 0.0;
               double var41 = (double)((var38 & 2) - 1) * var10;
               double var43 = (double)((var38 + 1 & 2) - 1) * var10;
               double var45 = 0.0;
               double var47 = var41 * var36 - var43 * var34;
               double var49 = var43 * var36 + var41 * var34;
               double var51 = var47 * var28 + 0.0 * var30;
               double var53 = 0.0 * var28 - var47 * var30;
               double var55 = var53 * var22 - var49 * var24;
               double var57 = var49 * var22 + var53 * var24;
               var1.method17025(var14 + var55, var16 + var51, var18 + var57).method17031();
            }
         }
      }
   }

   public void method867(Class1656 var1) {
      this.field967 = Double.MIN_VALUE;
      this.field968 = Double.MIN_VALUE;
      this.field969 = Double.MIN_VALUE;
      this.field970 = Integer.MIN_VALUE;
      this.field971 = Integer.MIN_VALUE;
      this.field972 = Integer.MIN_VALUE;
      this.field941.method32227(var1);
      this.field943 = var1;
      if (Class7944.method26970()) {
         Class9446.method36321();
      }

      Class8597.method30747();
      this.field1018.method29411((Class7380)null, (BlockPos)null);
      Class8708.method31403(this.field943);
      Class8981.method33043(this.field943);
      if (var1 != null) {
         this.method868();
      } else {
         this.field944.clear();
         this.field1003.clear();
         this.method931();
         if (this.field947 != null) {
            this.field947.method34756();
            this.field947 = null;
         }

         if (this.field983 != null) {
            this.field983.method33331();
         }

         this.field983 = null;
         this.field946.clear();
      }
   }

   public void method868() {
      if (this.field943 != null) {
         if (Minecraft.method1517()) {
            this.method858();
         } else {
            this.method859();
         }

         this.field943.method6842();
         if (this.field983 == null) {
            this.field983 = new Class9016(this.field943, this, Util.method38492(), this.field939.method1543(), this.field942.method26535());
         } else {
            this.field983.method33318(this.field943);
         }

         this.field995 = true;
         this.field952 = true;
         Class8928.method32635(Class7944.method26826());
         Class7551.method24695();
         if (Class7944.method26970()) {
            Class9446.method36321();
         }

         Class4501.method14214();
         field1025 = Minecraft.method1518();
         this.field985 = this.field939.field1299.field44574;
         this.field1013 = this.field985 * 16;
         this.field1014 = this.field1013 * this.field1013;
         this.method865();
         this.method863();
         this.method862();
         if (this.field947 != null) {
            this.field947.method34756();
         }

         this.method869();
         synchronized (this.field946) {
            this.field946.clear();
         }

         this.field947 = new Class9242(this.field983, this.field943, this.field939.field1299.field44574, this);
         if (this.field943 != null) {
            Entity var4 = this.field939.method1550();
            if (var4 != null) {
               this.field947.method34759(var4.getPosX(), var4.getPosZ());
            }
         }
      }

      if (this.field939.field1339 == null) {
         this.field1021 = true;
      }
   }

   public void method869() {
      this.field944.clear();
      this.field983.method33325();
   }

   public void method870(int var1, int var2) {
      this.method922();
      if (this.field960 != null) {
         this.field960.method6525(var1, var2);
      }

      if (this.field966 != null) {
         this.field966.method6525(var1, var2);
      }
   }

   public String method871() {
      int var1 = this.field947.field42528.length;
      int var2 = this.method872();
      return String.format(
         "C: %d/%d %sD: %d, %s", var2, var1, this.field939.field1366 ? "(s) " : "", this.field985, this.field983 == null ? "null" : this.field983.method33320()
      );
   }

   public int method872() {
      int var1 = 0;
      ObjectListIterator var2 = this.field945.iterator();

      while (var2.hasNext()) {
         Class7002 var3 = (Class7002)var2.next();
         if (!var3.field30281.method27715().method24109()) {
            var1++;
         }
      }

      return var1;
   }

   public String method873() {
      return "E: " + this.field986 + "/" + this.field943.method6844() + ", B: " + this.field987 + ", " + Class7944.method26778();
   }

   public void method874(Class9624 var1, Class7647 var2, boolean var3, int var4, boolean var5) {
      Vector3d var6 = var1.method37504();
      if (this.field939.field1299.field44574 != this.field985) {
         this.method868();
      }

      this.field943.method6820().method22503("camera");
      double var7 = this.field939.field1339.getPosX() - this.field967;
      double var9 = this.field939.field1339.getPosY() - this.field968;
      double var11 = this.field939.field1339.getPosZ() - this.field969;
      if (this.field970 != this.field939.field1339.field5072
         || this.field971 != this.field939.field1339.field5073
         || this.field972 != this.field939.field1339.field5074
         || var7 * var7 + var9 * var9 + var11 * var11 > 16.0) {
         this.field967 = this.field939.field1339.getPosX();
         this.field968 = this.field939.field1339.getPosY();
         this.field969 = this.field939.field1339.getPosZ();
         this.field970 = this.field939.field1339.field5072;
         this.field971 = this.field939.field1339.field5073;
         this.field972 = this.field939.field1339.field5074;
         this.field947.method34759(this.field939.field1339.getPosX(), this.field939.field1339.getPosZ());
      }

      if (Class7944.method26970()) {
         Class9446.method36309(this);
      }

      this.field983.method33321(var6);
      this.field943.method6820().method22506("cull");
      this.field939.method1574().method22506("culling");
      BlockPos var13 = var1.method37505();
      Class8066 var14 = this.field947.method34761(var13);
      int var15 = 16;
      BlockPos var16 = new BlockPos(
         MathHelper.method37769(var6.field18048 / 16.0) * 16,
         MathHelper.method37769(var6.field18049 / 16.0) * 16,
         MathHelper.method37769(var6.field18050 / 16.0) * 16
      );
      float var17 = var1.method37506();
      float var18 = var1.method37507();
      this.field995 = this.field995
         || !this.field944.isEmpty()
         || var6.field18048 != this.field973
         || var6.field18049 != this.field974
         || var6.field18050 != this.field975
         || (double)var17 != this.field976
         || (double)var18 != this.field977;
      this.field973 = var6.field18048;
      this.field974 = var6.field18049;
      this.field975 = var6.field18050;
      this.field976 = (double)var17;
      this.field977 = (double)var18;
      this.field939.method1574().method22506("update");
      Class8578.field38578.method31034();
      int var19 = this.method927();
      if (var19 != this.field1017) {
         this.field1017 = var19;
         this.field995 = true;
      }

      Entity var20 = var1.method37509();
      int var21 = 256;
      if (!Class8597.method30744()) {
         this.field995 = true;
      }

      if (!var3 && this.field995 && Class7944.method26983() && !Class8981.field40609) {
         var21 = Class8597.method30743(this.field943, var20, this.field985);
      }

      Class8066 var22 = this.field947.method34761(new BlockPos(var20.getPosX(), var20.getPosY(), var20.getPosZ()));
      if (Class8981.field40609) {
         this.field945 = this.field1010;
         this.field1005 = this.field1011;
         this.field1006 = this.field1012;
         if (!var3 && this.field995) {
            this.method931();
            if (var22 != null && var22.method27718().getY() > var21) {
               this.field1005.add(var22.method27746());
            }

            Iterator var23 = Class9252.method34804(this.field943, 0.0, var20, this.field985, this.field947);

            while (var23.hasNext()) {
               Class8066 var24 = (Class8066)var23.next();
               if (var24 != null && var24.method27718().getY() <= var21) {
                  Class7002 var25 = var24.method27746();
                  if (!var24.field34609.get().method24109()) {
                     this.field945.add(var25);
                  }

                  if (Class8674.method31216(var24.method27740())) {
                     this.field1005.add(var25);
                  }

                  if (var24.method27715().method24111().size() > 0) {
                     this.field1006.add(var25);
                  }
               }
            }
         }
      } else {
         this.field945 = this.field1007;
         this.field1005 = this.field1008;
         this.field1006 = this.field1009;
      }

      if (!var3 && this.field995 && !Class8981.field40609) {
         this.field995 = false;
         this.method931();
         this.field1004.clear();
         Deque var41 = this.field1004;
         Entity.method3378(MathHelper.method37778((double)this.field939.field1299.field44574 / 8.0, 1.0, 2.5) * (double)this.field939.field1299.field44575);
         boolean var43 = this.field939.field1366;
         BlockPos var45 = var1.method37505();
         int var26 = var45.getY();
         int var27 = var26 >> 4 << 4;
         if (var27 > var21) {
            var21 += 16;
            if (var27 > var21 && var21 < 256) {
               if (var22 != null) {
                  this.field1005.add(var22.method27746());
               }

               Vector3d var28 = new Vector3d((double)var45.method8304(), (double)var21, (double)var45.method8306());
               Vector3d var29 = new Vector3d(var28.method11320(), var28.method11321(), var28.method11322());
               Class7680 var30 = var1.method37516();
               Class7680 var31 = new Class7680(var30.method25269(), 0.0F, var30.method25271());
               if (!var31.method25280()) {
                  var31 = new Class7680(1.0F, 0.0F, 0.0F);
               }

               double var32 = (double)(var31.method25269() * 16.0F);
               double var34 = (double)(var31.method25271() * 16.0F);
               double var36 = (double)(this.field985 * 16);

               for (double var38 = var36 * var36; var29.method11342(var28) < var38; var29 = var29.method11339(var32, 0.0, var34)) {
                  Class8066 var40 = this.field947.method34761(new BlockPos(var29));
                  if (var40 == null) {
                     break;
                  }

                  if (var2.method25122(var40.field34614)) {
                     var40.method27710(var4);
                     var41.add(new Class7002(var40, (Direction)null, 0));
                     break;
                  }
               }
            }
         }

         if (var41.isEmpty()) {
            if (var14 != null && var14.method27718().getY() <= var21) {
               if (var5 && this.field943.method6738(var13).method23409(this.field943, var13)) {
                  var43 = false;
               }

               var14.method27710(var4);
               var41.add(new Class7002(var14, (Direction)null, 0));
            } else {
               int var49 = var16.getY() > 0 ? Math.min(var21, 248) : 8;
               if (var22 != null) {
                  this.field1005.add(var22.method27746());
               }

               int var52 = MathHelper.method37769(var6.field18048 / 16.0) * 16;
               int var54 = MathHelper.method37769(var6.field18050 / 16.0) * 16;
               List<Class7002> var56 = Lists.newArrayList();

               for (int var58 = -this.field985; var58 <= this.field985; var58++) {
                  for (int var33 = -this.field985; var33 <= this.field985; var33++) {
                     Class8066 var61 = this.field947.method34761(new BlockPos(var52 + (var58 << 4) + 8, var49, var54 + (var33 << 4) + 8));
                     if (var61 != null && var2.method25122(var61.field34614)) {
                        var61.method27710(var4);
                        Class7002 var35 = var61.method27746();
                        Class7002.method21715(var35, (Direction)null, 0, 0);
                        var56.add(var35);
                     }
                  }
               }

               var56.sort(Comparator.comparingDouble(var1x -> var13.method8318(var1x.field30281.method27718().method8336(8, 8, 8))));
               var41.addAll(var56);
            }
         }

         this.field939.method1574().method22503("iteration");
         boolean var50 = Class7944.method26807();

         while (!var41.isEmpty()) {
            Class7002 var53 = (Class7002)var41.poll();
            Class8066 var55 = var53.field30281;
            Direction var57 = Class7002.method21716(var53);
            Class7457 var59 = var55.field34609.get();
            if (!var59.method24109() || var55.method27721()) {
               this.field945.add(var53);
            }

            if (Class8674.method31216(var55.method27740())) {
               this.field1005.add(var53);
            }

            if (var59.method24111().size() > 0) {
               this.field1006.add(var53);
            }

            Direction[] var60 = var43 ? Class8597.method30746(Class7002.method21717(var53)) : Direction.field685;

            for (Direction var37 : var60) {
               if (!var43 || var57 == null || var59.method24107(var57.method536(), var37)) {
                  Class8066 var65 = this.method875(var16, var55, var37, var50, var21);
                  if (var65 != null && var65.method27710(var4) && var2.method25122(var65.field34614)) {
                     int var39 = Class7002.method21717(var53) | 1 << var37.ordinal();
                     Class7002 var66 = var65.method27746();
                     Class7002.method21715(var66, var37, var39, Class7002.method21718(var53) + 1);
                     var41.add(var66);
                  }
               }
            }
         }

         this.field939.method1574().method22505();
      }

      Class8578.field38578.method31035();
      if (Class8981.field40609) {
         Class8981.method33136();
      } else {
         this.field939.method1574().method22506("rebuildNear");
         Set var42 = this.field944;
         this.field944 = this.field1003;
         this.field1003 = var42;
         this.field944.clear();
         Class8578.field38577.method31034();
         ObjectListIterator var44 = this.field945.iterator();

         while (var44.hasNext()) {
            Class7002 var46 = (Class7002)var44.next();
            Class8066 var47 = var46.field30281;
            if (var47.method27721() || var42.contains(var47)) {
               this.field995 = true;
               BlockPos var48 = var47.method27718();
               boolean var51 = (double)Class7317.method23175(
                     var16, (float)(var48.method8304() + 8), (float)(var48.getY() + 8), (float)(var48.method8306() + 8)
                  )
                  < 768.0;
               if (!var47.method27722() && !var51) {
                  this.field944.add(var47);
               } else if (!var47.method27731()) {
                  this.field1002.add(var47);
               } else {
                  this.field939.method1574().method22503("build near");
                  this.field983.method33324(var47);
                  var47.method27720();
                  this.field939.method1574().method22505();
               }
            }
         }

         Class8578.field38577.method31035();
         this.field944.addAll(var42);
         this.field939.method1574().method22505();
      }
   }

   @Nullable
   private Class8066 method875(BlockPos var1, Class8066 var2, Direction var3, boolean var4, int var5) {
      Class8066 var6 = var2.method27745(var3);
      if (var6 == null) {
         return null;
      } else if (var6.method27718().getY() > var5) {
         return null;
      } else {
         if (var4) {
            BlockPos var7 = var6.method27718();
            int var8 = var1.method8304() - var7.method8304();
            int var9 = var1.method8306() - var7.method8306();
            int var10 = var8 * var8 + var9 * var9;
            if (var10 > this.field1014) {
               return null;
            }
         }

         return var6;
      }
   }

   private void method876(Class9367 var1, Class9367 var2, double var3, double var5, double var7, Class7647 var9) {
      this.field989 = var9;
      Class9367 var10 = var2.method35514();
      var10.method35508(var1);
      var10.method35507();
      this.field991.field42185 = var3;
      this.field991.field42186 = var5;
      this.field991.field42187 = var7;
      this.field990[0] = new Class7755(-1.0F, -1.0F, -1.0F, 1.0F);
      this.field990[1] = new Class7755(1.0F, -1.0F, -1.0F, 1.0F);
      this.field990[2] = new Class7755(1.0F, 1.0F, -1.0F, 1.0F);
      this.field990[3] = new Class7755(-1.0F, 1.0F, -1.0F, 1.0F);
      this.field990[4] = new Class7755(-1.0F, -1.0F, 1.0F, 1.0F);
      this.field990[5] = new Class7755(1.0F, -1.0F, 1.0F, 1.0F);
      this.field990[6] = new Class7755(1.0F, 1.0F, 1.0F, 1.0F);
      this.field990[7] = new Class7755(-1.0F, 1.0F, 1.0F, 1.0F);

      for (int var11 = 0; var11 < 8; var11++) {
         this.field990[var11].method25709(var10);
         this.field990[var11].method25711();
      }
   }

   public void method877(Class9332 var1, float var2, long var3, boolean var5, Class9624 var6, Class214 var7, Class1699 var8, Class9367 var9) {
      Class8086.field34743.method27961(this.field943, this.field939.getTextureManager(), this.field939.field1294, var6, this.field939.field1346);
      this.field941.method32213(this.field943, var6, this.field939.field1345);
      Class7165 var10 = this.field943.method6820();
      var10.method22506("light_updates");
      this.field939.field1338.method6883().method7348().method600(Integer.MAX_VALUE, true, true);
      Vector3d var11 = var6.method37504();
      double var12 = var11.method11320();
      double var14 = var11.method11321();
      double var16 = var11.method11322();
      Class9367 var18 = var1.method35296().method32361();
      var10.method22506("culling");
      boolean var19 = this.field989 != null;
      Class7647 var20;
      if (var19) {
         var20 = this.field989;
         var20.method25119(this.field991.field42185, this.field991.field42186, this.field991.field42187);
      } else {
         var20 = new Class7647(var18, var9);
         var20.method25119(var12, var14, var16);
      }

      this.field939.method1574().method22506("captureFrustum");
      if (this.field988) {
         this.method876(var18, var9, var11.field18048, var11.field18049, var11.field18050, var19 ? new Class7647(var18, var9) : var20);
         this.field988 = false;
      }

      var10.method22506("clear");
      if (Class7944.method26921()) {
         Class8981.method33045(0, 0, this.field939.method1580().method8041(), this.field939.method1580().method8042());
      } else {
         RenderSystem.method27869(0, 0, this.field939.method1580().method8041(), this.field939.method1580().method8042());
      }

      Class8915.method32584(var6, var2, this.field939.field1338, this.field939.field1299.field44574, var7.method766(var2));
      RenderSystem.method27877(16640, Minecraft.field1272);
      boolean var21 = Class7944.method26921();
      if (var21) {
         Class8981.method33049();
      }

      if (var21) {
         Class8981.method33050(var1, var6, var2);
      }

      var20.field32828 = Class7944.method26921() && !Class8981.method33005();
      float var22 = var7.method767();
      boolean var23 = this.field939.field1338.method6830().method19300(MathHelper.method37769(var12), MathHelper.method37769(var14))
         || this.field939.field1298.method5995().method5959();
      if ((Class7944.method26879() || Class7944.method26880() || Class7944.method26884()) && !Class8981.field40609) {
         Class8915.method32587(var6, Class2040.field13337, var22, var23, var2);
         var10.method22506("sky");
         if (var21) {
            Class8981.method33068();
         }

         this.method888(var1, var2);
         if (var21) {
            Class8981.method33072();
         }
      } else {
         Class7414.method23714();
      }

      var10.method22506("fog");
      Class8915.method32587(var6, Class2040.field13338, Math.max(var22 - 16.0F, 32.0F), var23, var2);
      var10.method22506("terrain_setup");
      this.method940(var6, var20, this.field939.field1339.method2800());
      this.method874(var6, var20, var19, this.field996++, this.field939.field1339.method2800());
      var10.method22506("updatechunks");
      byte var24 = 30;
      int var25 = this.field939.field1299.field44576;
      long var26 = 33333333L;
      long var28;
      if ((double)var25 == Class5805.field25328.method18087()) {
         var28 = 0L;
      } else {
         var28 = (long)(1000000000 / var25);
      }

      long var30 = Util.method38488() - var3;
      long var32 = this.field954.method37554(var30);
      long var34 = var32 * 3L / 2L;
      long var36 = MathHelper.method37776(var34, var28, 33333333L);
      Class8578.field38576.method31034();
      this.method891(var3 + var36);
      Class8578.field38576.method31035();
      var10.method22506("terrain");
      Class8578.field38579.method31034();
      if (this.field939.field1299.field44682) {
         this.field939.method1574().method22506("finish");
         GL11.glFinish();
         this.field939.method1574().method22506("terrain");
      }

      if (Class7944.method26806() && Class8915.field40354) {
         Class7414.method23889(false);
      }

      this.method880(Class4520.method14300(), var1, var12, var14, var16);
      this.field939.getTextureManager().method1076(Class289.field1102).method1130(false, this.field939.field1299.field44600 > 0);
      this.method880(Class4520.method14301(), var1, var12, var14, var16);
      this.field939.getTextureManager().method1076(Class289.field1102).method1137();
      this.method880(Class4520.method14302(), var1, var12, var14, var16);
      if (var21) {
         Class5463.method17151();
      }

      Class8578.field38579.method31035();
      if (this.field943.method6830().method19307()) {
         Class7516.method24500(var1.method35296().method32361());
      } else {
         Class7516.method24501(var1.method35296().method32361());
      }

      if (var21) {
         Class8981.method33078();
      }

      Class5736.method17918();
      var10.method22506("entities");
      field1022++;
      this.field986 = 0;
      this.field987 = 0;
      this.field1016 = 0;
      if (this.field962 != null) {
         this.field962.method29119(Minecraft.field1272);
         this.field962.method29106(this.field939.method1464());
         this.field939.method1464().method29112(false);
      }

      if (this.field964 != null) {
         this.field964.method29119(Minecraft.field1272);
      }

      if (this.method861()) {
         this.field959.method29119(Minecraft.field1272);
         this.field939.method1464().method29112(false);
      }

      boolean var38 = false;
      Class7735 var39 = this.field942.method26536();
      if (Class7944.method26919()) {
         Class8861.method32258();
      }

      for (Class7002 var41 : this.field1005) {
         Class8066 var42 = var41.field30281;
         Class1674 var43 = var42.method27740();

         for (Entity var45 : var43.method7146()[var42.method27718().getY() / 16]) {
            if ((this.field941.method32218(var45, var20, var12, var14, var16) || var45.method3417(this.field939.field1339))
               && (var45 != var6.method37509() || var6.method37511() || var6.method37509() instanceof Class880 && ((Class880)var6.method37509()).isSleeping())
               && (!(var45 instanceof ClientPlayerEntity) || var6.method37509() == var45)) {
               String var46 = var45.getClass().getName();
               List<Entity> var47 = this.field1026.get(var46);
               if (var47 == null) {
                  var47 = new ArrayList<>();
                  this.field1026.put(var46, var47);
               }

               var47.add(var45);
            }
         }
      }

      for (List<Entity> var58 : this.field1026.values()) {
         for (Entity var65 : var58) {
            this.field986++;
            if (var65.field5055 == 0) {
               var65.field5048 = var65.getPosX();
               var65.field5049 = var65.getPosY();
               var65.field5050 = var65.getPosZ();
            }

            Object var71;
            if (this.method861() && this.field939.method1552(var65)) {
               var38 = true;
               Class7734 var76 = this.field942.method26538();
               var71 = var76;
               int var81 = var65.method3199();
               short var85 = 255;
               int var48 = var81 >> 16 & 0xFF;
               int var49 = var81 >> 8 & 0xFF;
               int var50 = var81 & 0xFF;
               var76.method25599(var48, var49, var50, 255);
            } else {
               var71 = var39;
            }

            this.field1000 = var65;
            if (var21) {
               Class8981.method33079(var65);
            }

            this.method879(var65, var12, var14, var16, var2, var1, (Class7733)var71);
            this.field1000 = null;
         }

         var58.clear();
      }

      this.method878(var1);
      var39.method25603(Class4520.method14309(Class289.field1102));
      var39.method25603(Class4520.method14310(Class289.field1102));
      var39.method25603(Class4520.method14312(Class289.field1102));
      var39.method25603(Class4520.method14319(Class289.field1102));
      if (var21) {
         Class8981.method33083();
         Class8981.method33089();
      }

      var10.method22506("blockentities");
      Class5947.method18475();
      boolean var57 = Class9299.field42943.method20214();
      Class7647 var59 = var20;

      for (Class7002 var66 : this.field1006) {
         List<Class944> var72 = var66.field30281.method27715().method24111();
         if (!var72.isEmpty()) {
            for (Class944 var82 : var72) {
               if (var57) {
                  Class6488 var86 = (Class6488)Class9299.method35070(var82, Class9299.field42943);
                  if (var86 != null && !var59.method25122(var86)) {
                     continue;
                  }
               }

               if (var21) {
                  Class8981.method33090(var82);
               }

               BlockPos var88 = var82.method3774();
               Object var89 = var39;
               var1.method35294();
               if (Minecraft.getInstance().field1359) {
                  var1.method35291((double)var88.method8304() - var12, (double)var88.getY() - var14, (double)var88.method8306() - var16);
               }

               SortedSet var91 = (SortedSet)this.field957.get(var88.method8332());
               if (var91 != null && !var91.isEmpty()) {
                  int var51 = ((Class1995)var91.last()).method8285();
                  if (var51 >= 0) {
                     Class8892 var52 = var1.method35296();
                     Class5427 var53 = new Class5427(
                        this.field942.method26537().method25597(Class8968.field40518.get(var51)), var52.method32361(), var52.method32362()
                     );
                     var89 = (Class7733)var2x -> {
                        Class5422 var3x = var39.method25597(var2x);
                        return var2x.method14355() ? Class7802.method26050(var53, var3x) : var3x;
                     };
                  }
               }

               Class8086.field34743.method27962(var82, var2, var1, (Class7733)var89);
               var1.method35295();
               this.field1016++;
            }
         }
      }

      synchronized (this.field946) {
         for (Class944 var73 : this.field946) {
            if (var57) {
               Class6488 var78 = (Class6488)Class9299.method35070(var73, Class9299.field42943);
               if (var78 != null && !var59.method25122(var78)) {
                  continue;
               }
            }

            if (var21) {
               Class8981.method33090(var73);
            }

            BlockPos var83 = var73.method3774();
            var1.method35294();
            var1.method35291((double)var83.method8304() - var12, (double)var83.getY() - var14, (double)var83.method8306() - var16);
            Class8086.field34743.method27962(var73, var2, var1, var39);
            var1.method35295();
            this.field1016++;
         }
      }

      this.method878(var1);
      var39.method25603(Class4520.method14300());
      var39.method25603(Class8624.method30906());
      var39.method25603(Class8624.method30907());
      var39.method25603(Class8624.method30902());
      var39.method25603(Class8624.method30903());
      var39.method25603(Class8624.method30904());
      var39.method25603(Class8624.method30905());
      var39.method25603(Class8624.method30900());
      this.field942.method26538().method25600();
      if (Class7944.method26919()) {
         Class8861.method32259();
      }

      if (var38) {
         this.field960.method6526(var2);
         this.field939.method1464().method29112(false);
      }

      if (var21) {
         Class8981.method33093();
      }

      this.field1019 = true;
      var10.method22506("destroyProgress");
      ObjectIterator var63 = this.field957.long2ObjectEntrySet().iterator();

      while (var63.hasNext()) {
         Entry var68 = (Entry)var63.next();
         BlockPos var74 = BlockPos.method8331(var68.getLongKey());
         double var79 = (double)var74.method8304() - var12;
         double var87 = (double)var74.getY() - var14;
         double var90 = (double)var74.method8306() - var16;
         if (!(var79 * var79 + var87 * var87 + var90 * var90 > 1024.0)) {
            SortedSet var92 = (SortedSet)var68.getValue();
            if (var92 != null && !var92.isEmpty()) {
               int var93 = ((Class1995)var92.last()).method8285();
               var1.method35294();
               var1.method35291((double)var74.method8304() - var12, (double)var74.getY() - var14, (double)var74.method8306() - var16);
               Class8892 var94 = var1.method35296();
               Class5427 var54 = new Class5427(
                  this.field942.method26537().method25597(Class8968.field40518.get(var93)), var94.method32361(), var94.method32362()
               );
               this.field939.method1553().method807(this.field943.method6738(var74), var74, this.field943, var1, var54);
               var1.method35295();
            }
         }
      }

      this.field1019 = false;
      field1022--;
      this.method878(var1);
      Class8710 var64 = this.field939.field1346;
      if (var5 && var64 != null && var64.method31417() == Class2100.field13690) {
         var10.method22506("outline");
         BlockPos var69 = ((Class8711)var64).method31423();
         Class7380 var75 = this.field943.method6738(var69);
         boolean var80;
         if (Class9299.field42830.method20214() && Class9299.field42882.method20214()) {
            var80 = !Class9299.method35056(Class9299.field42882, this, var6, var64, var2, var1, var39)
               && !Class9299.method35064(var75, Class9299.field42830, this.field943, var69)
               && this.field943.method6810().method24523(var69);
         } else {
            var80 = !var75.method23393() && this.field943.method6810().method24523(var69);
         }

         if (var80) {
            Class5422 var84 = var39.method25597(Class4520.method14345());
            this.method894(var1, var84, var6.method37509(), var12, var14, var16, var69, var75);
         }

         if (var21) {
            var39.method25603(Class4520.method14345());
         }
      } else if (var64 != null && var64.method31417() == Class2100.field13691) {
         Class9299.field42882.method20217(this, var6, var64, var2, var1, var39);
      }

      RenderSystem.pushMatrix();
      RenderSystem.method27888(var1.method35296().method32361());
      boolean var70 = Class7414.method23868();
      Class7414.method23780();
      this.field939.field1296.method27453(var1, var39, var12, var14, var16);
      Class7414.method23869(var70);
      RenderSystem.popMatrix();
      var39.method25603(Class8624.method30909());
      var39.method25603(Class8624.method30900());
      var39.method25603(Class8624.method30901());
      var39.method25603(Class4520.method14331());
      var39.method25603(Class4520.method14332());
      var39.method25603(Class4520.method14334());
      var39.method25603(Class4520.method14335());
      var39.method25603(Class4520.method14333());
      var39.method25603(Class4520.method14336());
      var39.method25603(Class4520.method14337());
      var39.method25603(Class4520.method14328());
      this.field942.method26537().method25602();
      if (var21) {
         var39.method25602();
         Class8981.method33100();
         Class5463.method17154(var7, var1, var6, var2);
         Class8981.method33101();
      }

      if (this.field966 != null) {
         var39.method25603(Class4520.method14345());
         var39.method25602();
         this.field961.method29119(Minecraft.field1272);
         this.field961.method29106(this.field939.method1464());
         var10.method22506("translucent");
         this.method880(Class4520.method14304(), var1, var12, var14, var16);
         var10.method22506("string");
         this.method880(Class4520.method14343(), var1, var12, var14, var16);
         this.field963.method29119(Minecraft.field1272);
         this.field963.method29106(this.field939.method1464());
         Class4510.field21779.method14231();
         var10.method22506("particles");
         this.field939.field1291.method1204(var1, var39, var8, var6, var2, var20);
         Class4510.field21779.method14232();
      } else {
         var10.method22506("translucent");
         if (var21) {
            Class8981.method33102();
         }

         this.method880(Class4520.method14304(), var1, var12, var14, var16);
         if (var21) {
            Class8981.method33103();
         }

         var39.method25603(Class4520.method14345());
         var39.method25602();
         var10.method22506("string");
         this.method880(Class4520.method14343(), var1, var12, var14, var16);
         var10.method22506("particles");
         if (var21) {
            Class8981.method33095();
         }

         this.field939.field1291.method1204(var1, var39, var8, var6, var2, var20);
         if (var21) {
            Class8981.method33096();
         }
      }

      Class7414.method23889(true);
      RenderSystem.pushMatrix();
      RenderSystem.method27888(var1.method35296().method32361());
      if (this.field939.field1299.method37153() != Class1904.field11184) {
         if (this.field966 != null) {
            this.field965.method29119(Minecraft.field1272);
            Class4510.field21781.method14231();
            var10.method22506("clouds");
            this.method889(var1, var2, var12, var14, var16);
            Class4510.field21781.method14232();
         } else {
            var10.method22506("clouds");
            this.method889(var1, var2, var12, var14, var16);
         }
      }

      if (this.field966 != null) {
         Class4510.field21780.method14231();
         var10.method22506("weather");
         this.method855(var8, var2, var12, var14, var16);
         this.method892(var6);
         Class4510.field21780.method14232();
         this.field966.method6526(var2);
         this.field939.method1464().method29112(false);
      } else {
         RenderSystem.depthMask(false);
         if (Class7944.method26921()) {
            Class7414.method23713(Class8981.method33002());
         }

         var10.method22506("weather");
         if (var21) {
            Class8981.method33098();
         }

         this.method855(var8, var2, var12, var14, var16);
         if (var21) {
            Class8981.method33099();
         }

         this.method892(var6);
         RenderSystem.depthMask(true);
      }

      this.method882(var6);
      RenderSystem.method27866(7424);
      RenderSystem.depthMask(true);
      RenderSystem.disableBlend();
      RenderSystem.popMatrix();
      Class8915.method32585();
   }

   public void method878(Class9332 var1) {
      if (!var1.method35297()) {
         throw new IllegalStateException("Pose stack not empty");
      }
   }

   public void method879(Entity var1, double var2, double var4, double var6, float var8, Class9332 var9, Class7733 var10) {
      double var11 = MathHelper.method37822((double)var8, var1.field5048, var1.getPosX());
      double var13 = MathHelper.method37822((double)var8, var1.field5049, var1.getPosY());
      double var15 = MathHelper.method37822((double)var8, var1.field5050, var1.getPosZ());
      float var17 = MathHelper.method37821(var8, var1.field5033, var1.field5031);
      this.field941.method32219(var1, var11 - var2, var13 - var4, var15 - var6, var17, var8, var9, var10, this.field941.method32208(var1, var8));
   }

   public void method880(Class4520 var1, Class9332 var2, double var3, double var5, double var7) {
      var1.method14231();
      boolean var9 = Class7944.method26921();
      if (var1 == Class4520.method14304() && !Class8981.field40609) {
         this.field939.method1574().method22503("translucent_sort");
         double var10 = var3 - this.field992;
         double var12 = var5 - this.field993;
         double var14 = var7 - this.field994;
         if (var10 * var10 + var12 * var12 + var14 * var14 > 1.0) {
            this.field992 = var3;
            this.field993 = var5;
            this.field994 = var7;
            int var16 = 0;
            this.field1001.clear();
            ObjectListIterator var17 = this.field945.iterator();

            while (var17.hasNext()) {
               Class7002 var18 = (Class7002)var17.next();
               if (var16 < 15 && var18.field30281.method27715().method24113(var1)) {
                  this.field1001.add(var18.field30281);
                  var16++;
               }
            }
         }

         this.field939.method1574().method22505();
      }

      this.field939.method1574().method22503("filterempty");
      if (var9) {
         Class5463.method17162(var1);
      }

      boolean var29 = Class4501.method14213();
      RenderSystem.pushMatrix();
      RenderSystem.method27879();
      RenderSystem.method27888(var2.method35296().method32361());
      this.field939.method1574().method22507(() -> "render_" + var1);
      boolean var11 = var1 != Class4520.method14304();
      ObjectListIterator<Class7002> var30 = this.field945.listIterator(var11 ? 0 : this.field945.size());
      if (Class7944.method26977()) {
         int var31 = Integer.MIN_VALUE;
         int var33 = Integer.MIN_VALUE;
         Class8836 var34 = null;
         Map<Class7126, Map<Class8836,  List<Class1698>>> var36 = this.field1027.computeIfAbsent(var1, var0 -> new LinkedHashMap<>(16));
         Map var38 = null;
         List<Class1698> var39 = null;

         while (var11 ? var30.hasNext() : var30.hasPrevious()) {
            Class7002 var19 = var11 ? var30.next() : var30.previous();
            Class8066 var20 = var19.field30281;
            if (!var20.method27715().method24110(var1)) {
               Class1698 var21 = var20.method27711(var1);
               Class8836 var22 = var21.method7310();
               if (var20.field34624 != var31 || var20.field34625 != var33) {
                  Class7126 var23 = Class7126.method22234(var20.field34624, var20.field34625);
                  var38 = (Map) var36.computeIfAbsent(var23, var0 -> new LinkedHashMap<>(8));
                  var31 = var20.field34624;
                  var33 = var20.field34625;
                  var34 = null;
               }

               if (var22 != var34) {
                  var39 = (List<Class1698>) var38.computeIfAbsent(var22, var0 -> new ArrayList<>());
                  var34 = var22;
               }

               var39.add(var21);
               if (Class4501.method14213()) {
                  BitSet var44 = var20.method27715().method24112(var1);
                  if (var44 != null) {
                     Class4501.method14216(var44);
                  }
               }
            }
         }

         for (java.util.Map.Entry<Class7126, Map<Class8836,  List<Class1698>>> var41 : var36.entrySet()) {
            Class7126 var42 = var41.getKey();
            Map<Class8836,  List<Class1698>> var43 = var41.getValue();

            for (java.util.Map.Entry<Class8836,  List<Class1698>> var24 : var43.entrySet()) {
               Class8836 var25 = var24.getKey();
               List<Class1698> var26 = var24.getValue();

               for (Class1698 var28 : var26) {
                  var28.method7307(7);
               }

               this.method881(var42.method22235(), 0, var42.method22236(), var3, var5, var7, var25);
               var26.clear();
            }
         }
      } else {
         while (var11 ? var30.hasNext() : var30.hasPrevious()) {
            Class7002 var13 = var11 ? (Class7002)var30.next() : (Class7002)var30.previous();
            Class8066 var32 = var13.field30281;
            if (!var32.method27715().method24110(var1)) {
               Class1698 var15 = var32.method27711(var1);
               Class7414.method23832();
               BlockPos var35 = var32.method27718();
               Class7414.method23840((double)var35.method8304() - var3, (double)var35.getY() - var5, (double)var35.method8306() - var7);
               var15.method7302();
               Class9337.field43334.method26218(0L);
               Class7414.method23890();
               if (var9) {
                  Class5463.method17166();
               }

               var15.method7307(7);
               Class7414.method23833();
               if (var29) {
                  BitSet var37 = var32.method27715().method24112(var1);
                  if (var37 != null) {
                     Class4501.method14216(var37);
                  }
               }
            }
         }
      }

      Class7414.method23891();
      RenderSystem.popMatrix();
      Class1698.method7308();
      RenderSystem.method27891();
      Class9337.field43334.method26219();
      this.field939.method1574().method22505();
      if (var9) {
         Class5463.method17163(var1);
      }

      var1.method14232();
   }

   private void method881(int var1, int var2, int var3, double var4, double var6, double var8, Class8836 var10) {
      Class7414.method23832();
      Class7414.method23840((double)var1 - var4, (double)var2 - var6, (double)var3 - var8);
      var10.method31986();
      Class7414.method23890();
      Class7414.method23833();
   }

   private void method882(Class9624 var1) {
      Class9352 var2 = Class9352.method35409();
      Class5425 var3 = var2.method35411();
      if (this.field939.field1364 || this.field939.field1365) {
         double var4 = var1.method37504().method11320();
         double var6 = var1.method37504().method11321();
         double var8 = var1.method37504().method11322();
         RenderSystem.depthMask(true);
         RenderSystem.method27850();
         RenderSystem.enableBlend();
         RenderSystem.method27938();
         RenderSystem.method27862();

         for (ObjectListIterator var10 = this.field945.iterator(); var10.hasNext(); RenderSystem.popMatrix()) {
            Class7002 var11 = (Class7002)var10.next();
            Class8066 var12 = var11.field30281;
            RenderSystem.pushMatrix();
            BlockPos var13 = var12.method27718();
            RenderSystem.translated((double)var13.method8304() - var4, (double)var13.getY() - var6, (double)var13.method8306() - var8);
            if (this.field939.field1364) {
               var3.method17063(1, Class9337.field43342);
               RenderSystem.method27893(10.0F);
               int var14 = Class7002.method21718(var11) == 0 ? 0 : MathHelper.method37818((float)Class7002.method21718(var11) / 50.0F, 0.9F, 0.9F);
               int var15 = var14 >> 16 & 0xFF;
               int var16 = var14 >> 8 & 0xFF;
               int var17 = var14 & 0xFF;
               Direction var18 = Class7002.method21716(var11);
               if (var18 != null) {
                  var3.method17025(8.0, 8.0, 8.0).method17026(var15, var16, var17, 255).method17031();
                  var3.method17025((double)(8 - 16 * var18.method539()), (double)(8 - 16 * var18.method540()), (double)(8 - 16 * var18.method541()))
                     .method17026(var15, var16, var17, 255)
                     .method17031();
               }

               var2.method35410();
               RenderSystem.method27893(1.0F);
            }

            if (this.field939.field1365 && !var12.method27715().method24109()) {
               var3.method17063(1, Class9337.field43342);
               RenderSystem.method27893(10.0F);
               int var24 = 0;

               for (Direction var30 : field938) {
                  for (Direction var22 : field938) {
                     boolean var23 = var12.method27715().method24107(var30, var22);
                     if (!var23) {
                        var24++;
                        var3.method17025((double)(8 + 8 * var30.method539()), (double)(8 + 8 * var30.method540()), (double)(8 + 8 * var30.method541()))
                           .method17026(1, 0, 0, 1)
                           .method17031();
                        var3.method17025((double)(8 + 8 * var22.method539()), (double)(8 + 8 * var22.method540()), (double)(8 + 8 * var22.method541()))
                           .method17026(1, 0, 0, 1)
                           .method17031();
                     }
                  }
               }

               var2.method35410();
               RenderSystem.method27893(1.0F);
               if (var24 > 0) {
                  var3.method17063(7, Class9337.field43342);
                  float var26 = 0.5F;
                  float var28 = 0.2F;
                  var3.method17025(0.5, 15.5, 0.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(15.5, 15.5, 0.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(15.5, 15.5, 15.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(0.5, 15.5, 15.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(0.5, 0.5, 15.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(15.5, 0.5, 15.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(15.5, 0.5, 0.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(0.5, 0.5, 0.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(0.5, 15.5, 0.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(0.5, 15.5, 15.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(0.5, 0.5, 15.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(0.5, 0.5, 0.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(15.5, 0.5, 0.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(15.5, 0.5, 15.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(15.5, 15.5, 15.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(15.5, 15.5, 0.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(0.5, 0.5, 0.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(15.5, 0.5, 0.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(15.5, 15.5, 0.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(0.5, 15.5, 0.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(0.5, 15.5, 15.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(15.5, 15.5, 15.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(15.5, 0.5, 15.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var3.method17025(0.5, 0.5, 15.5).method17033(0.9F, 0.9F, 0.0F, 0.2F).method17031();
                  var2.method35410();
               }
            }
         }

         RenderSystem.depthMask(true);
         RenderSystem.disableBlend();
         RenderSystem.method27849();
         RenderSystem.method27861();
      }

      if (this.field989 != null) {
         RenderSystem.method27850();
         RenderSystem.method27862();
         RenderSystem.enableBlend();
         RenderSystem.method27938();
         RenderSystem.method27893(10.0F);
         RenderSystem.pushMatrix();
         RenderSystem.translatef(
            (float)(this.field991.field42185 - var1.method37504().field18048),
            (float)(this.field991.field42186 - var1.method37504().field18049),
            (float)(this.field991.field42187 - var1.method37504().field18050)
         );
         RenderSystem.depthMask(true);
         var3.method17063(7, Class9337.field43342);
         this.method884(var3, 0, 1, 2, 3, 0, 1, 1);
         this.method884(var3, 4, 5, 6, 7, 1, 0, 0);
         this.method884(var3, 0, 1, 5, 4, 1, 1, 0);
         this.method884(var3, 2, 3, 7, 6, 0, 0, 1);
         this.method884(var3, 0, 4, 7, 3, 0, 1, 0);
         this.method884(var3, 1, 5, 6, 2, 1, 0, 1);
         var2.method35410();
         RenderSystem.depthMask(false);
         var3.method17063(1, Class9337.field43341);
         RenderSystem.method27889(1.0F, 1.0F, 1.0F, 1.0F);
         this.method883(var3, 0);
         this.method883(var3, 1);
         this.method883(var3, 1);
         this.method883(var3, 2);
         this.method883(var3, 2);
         this.method883(var3, 3);
         this.method883(var3, 3);
         this.method883(var3, 0);
         this.method883(var3, 4);
         this.method883(var3, 5);
         this.method883(var3, 5);
         this.method883(var3, 6);
         this.method883(var3, 6);
         this.method883(var3, 7);
         this.method883(var3, 7);
         this.method883(var3, 4);
         this.method883(var3, 0);
         this.method883(var3, 4);
         this.method883(var3, 1);
         this.method883(var3, 5);
         this.method883(var3, 2);
         this.method883(var3, 6);
         this.method883(var3, 3);
         this.method883(var3, 7);
         var2.method35410();
         RenderSystem.popMatrix();
         RenderSystem.depthMask(true);
         RenderSystem.disableBlend();
         RenderSystem.method27849();
         RenderSystem.method27861();
         RenderSystem.method27893(1.0F);
      }
   }

   private void method883(Class5422 var1, int var2) {
      var1.method17025((double)this.field990[var2].method25701(), (double)this.field990[var2].method25702(), (double)this.field990[var2].method25703())
         .method17031();
   }

   private void method884(Class5422 var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      float var9 = 0.25F;
      var1.method17025((double)this.field990[var2].method25701(), (double)this.field990[var2].method25702(), (double)this.field990[var2].method25703())
         .method17033((float)var6, (float)var7, (float)var8, 0.25F)
         .method17031();
      var1.method17025((double)this.field990[var3].method25701(), (double)this.field990[var3].method25702(), (double)this.field990[var3].method25703())
         .method17033((float)var6, (float)var7, (float)var8, 0.25F)
         .method17031();
      var1.method17025((double)this.field990[var4].method25701(), (double)this.field990[var4].method25702(), (double)this.field990[var4].method25703())
         .method17033((float)var6, (float)var7, (float)var8, 0.25F)
         .method17031();
      var1.method17025((double)this.field990[var5].method25701(), (double)this.field990[var5].method25702(), (double)this.field990[var5].method25703())
         .method17033((float)var6, (float)var7, (float)var8, 0.25F)
         .method17031();
   }

   public void method885() {
      this.field955++;
      if (this.field955 % 20 == 0) {
         ObjectIterator var1 = this.field956.values().iterator();

         while (var1.hasNext()) {
            Class1995 var2 = (Class1995)var1.next();
            int var3 = var2.method8287();
            if (this.field955 - var3 > 400) {
               var1.remove();
               this.method886(var2);
            }
         }
      }

      if (Class7944.method26977() && this.field955 % 20 == 0) {
         this.field1027.clear();
      }
   }

   private void method886(Class1995 var1) {
      long var2 = var1.method8283().method8332();
      Set var4 = (Set)this.field957.get(var2);
      var4.remove(var1);
      if (var4.isEmpty()) {
         this.field957.remove(var2);
      }
   }

   private void method887(Class9332 var1) {
      if (Class7944.method26879()) {
         RenderSystem.method27817();
         RenderSystem.enableBlend();
         RenderSystem.method27938();
         RenderSystem.depthMask(false);
         this.field940.bindTexture(field934);
         Class9352 var2 = Class9352.method35409();
         Class5425 var3 = var2.method35411();

         for (int var4 = 0; var4 < 6; var4++) {
            var1.method35294();
            if (var4 == 1) {
               var1.method35293(Class7680.field32898.method25286(90.0F));
            }

            if (var4 == 2) {
               var1.method35293(Class7680.field32898.method25286(-90.0F));
            }

            if (var4 == 3) {
               var1.method35293(Class7680.field32898.method25286(180.0F));
            }

            if (var4 == 4) {
               var1.method35293(Class7680.field32902.method25286(90.0F));
            }

            if (var4 == 5) {
               var1.method35293(Class7680.field32902.method25286(-90.0F));
            }

            Class9367 var5 = var1.method35296().method32361();
            var3.method17063(7, Class9337.field43346);
            int var6 = 40;
            int var7 = 40;
            int var8 = 40;
            if (Class7944.method26911()) {
               Vector3d var9 = new Vector3d((double)var6 / 255.0, (double)var7 / 255.0, (double)var8 / 255.0);
               var9 = Class9680.method37877(var9, this.field943, this.field939.method1550(), 0.0F);
               var6 = (int)(var9.field18048 * 255.0);
               var7 = (int)(var9.field18049 * 255.0);
               var8 = (int)(var9.field18050 * 255.0);
            }

            var3.method17040(var5, -100.0F, -100.0F, -100.0F).method17027(0.0F, 0.0F).method17026(var6, var7, var8, 255).method17031();
            var3.method17040(var5, -100.0F, -100.0F, 100.0F).method17027(0.0F, 16.0F).method17026(var6, var7, var8, 255).method17031();
            var3.method17040(var5, 100.0F, -100.0F, 100.0F).method17027(16.0F, 16.0F).method17026(var6, var7, var8, 255).method17031();
            var3.method17040(var5, 100.0F, -100.0F, -100.0F).method17027(16.0F, 0.0F).method17026(var6, var7, var8, 255).method17031();
            var2.method35410();
            var1.method35295();
         }

         RenderSystem.depthMask(true);
         RenderSystem.method27861();
         RenderSystem.disableBlend();
         RenderSystem.disableAlphaTest();
      }
   }

   public void method888(Class9332 var1, float var2) {
      if (Class9299.field42947.method20214()) {
         Class9797 var3 = (Class9797)Class9299.method35070(this.field943.method6830(), Class9299.field42947);
         if (var3 != null) {
            var3.method38636(this.field955, var2, var1, this.field943, this.field939);
            return;
         }
      }

      if (this.field939.field1338.method6830().method19305() == Class2078.field13537) {
         this.method887(var1);
      } else if (this.field939.field1338.method6830().method19305() == Class2078.field13536) {
         RenderSystem.method27862();
         boolean var20 = Class7944.method26921();
         if (var20) {
            Class8981.method33116();
         }

         Vector3d var4 = this.field943.method6873(this.field939.field1295.method768().method37505(), var2);
         var4 = Class9680.method37869(
            var4,
            this.field939.field1338,
            this.field939.method1550().getPosX(),
            this.field939.method1550().getPosY() + 1.0,
            this.field939.method1550().getPosZ()
         );
         if (var20) {
            Class8981.method33069(var4);
         }

         float var5 = (float)var4.field18048;
         float var6 = (float)var4.field18049;
         float var7 = (float)var4.field18050;
         Class8915.method32588();
         Class5425 var8 = Class9352.method35409().method35411();
         RenderSystem.depthMask(false);
         RenderSystem.method27840();
         if (var20) {
            Class8981.method33121();
         }

         RenderSystem.method27890(var5, var6, var7);
         if (var20) {
            Class8981.method33071(var1);
         }

         if (Class7944.method26879()) {
            this.field950.method7302();
            this.field948.method26218(0L);
            this.field950.method7306(var1.method35296().method32361(), 7);
            Class1698.method7308();
            this.field948.method26219();
         }

         RenderSystem.method27841();
         if (var20) {
            Class8981.method33122();
         }

         RenderSystem.method27817();
         RenderSystem.enableBlend();
         RenderSystem.method27938();
         float[] var9 = this.field943.method6830().method19302(this.field943.method7001(var2), var2);
         if (var9 != null && Class7944.method26880()) {
            RenderSystem.method27862();
            if (var20) {
               Class8981.method33116();
            }

            RenderSystem.method27866(7425);
            var1.method35294();
            var1.method35293(Class7680.field32898.method25286(90.0F));
            float var10 = MathHelper.method37763(this.field943.method6750(var2)) < 0.0F ? 180.0F : 0.0F;
            var1.method35293(Class7680.field32902.method25286(var10));
            var1.method35293(Class7680.field32902.method25286(90.0F));
            float var11 = var9[0];
            float var12 = var9[1];
            float var13 = var9[2];
            Class9367 var14 = var1.method35296().method32361();
            var8.method17063(6, Class9337.field43342);
            var8.method17040(var14, 0.0F, 100.0F, 0.0F).method17033(var11, var12, var13, var9[3]).method17031();
            int var15 = 16;

            for (int var16 = 0; var16 <= 16; var16++) {
               float var17 = (float)var16 * (float) (Math.PI * 2) / 16.0F;
               float var18 = MathHelper.method37763(var17);
               float var19 = MathHelper.method37764(var17);
               var8.method17040(var14, var18 * 120.0F, var19 * 120.0F, -var19 * 40.0F * var9[3]).method17033(var9[0], var9[1], var9[2], 0.0F).method17031();
            }

            var8.method17065();
            Class4395.method13895(var8);
            var1.method35295();
            RenderSystem.method27866(7424);
         }

         RenderSystem.method27861();
         if (var20) {
            Class8981.method33115();
         }

         RenderSystem.method27836(Class2339.field15997, Class1981.field12927, Class2339.field15990, Class1981.field12936);
         var1.method35294();
         float var22 = 1.0F - this.field943.method6792(var2);
         RenderSystem.method27889(1.0F, 1.0F, 1.0F, var22);
         var1.method35293(Class7680.field32900.method25286(-90.0F));
         Class8862.method32263(this.field943, this.field940, var1, var2);
         if (var20) {
            Class8981.method33054(var1);
         }

         var1.method35293(Class7680.field32898.method25286(this.field943.method7001(var2) * 360.0F));
         if (var20) {
            Class8981.method33055(var1);
         }

         Class9367 var23 = var1.method35296().method32361();
         float var24 = 30.0F;
         if (Class7944.method26881()) {
            this.field940.bindTexture(field932);
            var8.method17063(7, Class9337.field43344);
            var8.method17040(var23, -var24, 100.0F, -var24).method17027(0.0F, 0.0F).method17031();
            var8.method17040(var23, var24, 100.0F, -var24).method17027(1.0F, 0.0F).method17031();
            var8.method17040(var23, var24, 100.0F, var24).method17027(1.0F, 1.0F).method17031();
            var8.method17040(var23, -var24, 100.0F, var24).method17027(0.0F, 1.0F).method17031();
            var8.method17065();
            Class4395.method13895(var8);
         }

         var24 = 20.0F;
         if (Class7944.method26882()) {
            this.field940.bindTexture(field931);
            int var26 = this.field943.method7002();
            int var28 = var26 % 4;
            int var30 = var26 / 4 % 2;
            float var31 = (float)(var28 + 0) / 4.0F;
            float var34 = (float)(var30 + 0) / 2.0F;
            float var35 = (float)(var28 + 1) / 4.0F;
            float var36 = (float)(var30 + 1) / 2.0F;
            var8.method17063(7, Class9337.field43344);
            var8.method17040(var23, -var24, -100.0F, var24).method17027(var35, var36).method17031();
            var8.method17040(var23, var24, -100.0F, var24).method17027(var31, var36).method17031();
            var8.method17040(var23, var24, -100.0F, -var24).method17027(var31, var34).method17031();
            var8.method17040(var23, -var24, -100.0F, -var24).method17027(var35, var34).method17031();
            var8.method17065();
            Class4395.method13895(var8);
         }

         RenderSystem.method27862();
         if (var20) {
            Class8981.method33116();
         }

         float var27 = this.field943.method6875(var2) * var22;
         if (var27 > 0.0F && Class7944.method26884() && !Class8862.method32264(this.field943)) {
            RenderSystem.method27889(var27, var27, var27, var27);
            this.field949.method7302();
            this.field948.method26218(0L);
            this.field949.method7306(var1.method35296().method32361(), 7);
            Class1698.method7308();
            this.field948.method26219();
         }

         RenderSystem.method27889(1.0F, 1.0F, 1.0F, 1.0F);
         RenderSystem.disableBlend();
         RenderSystem.disableAlphaTest();
         RenderSystem.method27840();
         if (var20) {
            Class8981.method33121();
         }

         var1.method35295();
         RenderSystem.method27862();
         if (var20) {
            Class8981.method33116();
         }

         RenderSystem.method27890(0.0F, 0.0F, 0.0F);
         double var29 = this.field939.field1339.method3286(var2).field18049 - this.field943.method6788().method20052();
         boolean var32 = false;
         if (var29 < 0.0) {
            var1.method35294();
            var1.method35291(0.0, 12.0, 0.0);
            this.field951.method7302();
            this.field948.method26218(0L);
            this.field951.method7306(var1.method35296().method32361(), 7);
            Class1698.method7308();
            this.field948.method26219();
            var1.method35295();
            var32 = true;
         }

         if (this.field943.method6830().method19304()) {
            RenderSystem.method27890(var5 * 0.2F + 0.04F, var6 * 0.2F + 0.04F, var7 * 0.6F + 0.1F);
         } else {
            RenderSystem.method27890(var5, var6, var7);
         }

         RenderSystem.method27861();
         RenderSystem.depthMask(true);
         RenderSystem.method27841();
      }
   }

   public void method889(Class9332 var1, float var2, double var3, double var5, double var7) {
      if (!Class7944.method26823()) {
         if (Class9299.field42946.method20214()) {
            Class8098 var9 = (Class8098)Class9299.method35070(this.field943.method6830(), Class9299.field42946);
            if (var9 != null) {
               var9.method28052(this.field955, var2, var1, this.field943, this.field939, var3, var5, var7);
               return;
            }
         }

         float var31 = this.field943.method6830().method19303();
         if (!Float.isNaN(var31)) {
            if (Class7944.method26921()) {
               Class8981.method33076();
            }

            RenderSystem.method27850();
            RenderSystem.enableBlend();
            RenderSystem.disableAlphaTest();
            RenderSystem.enableDepthTest();
            RenderSystem.method27939();
            RenderSystem.method27836(Class2339.field15997, Class1981.field12932, Class2339.field15990, Class1981.field12932);
            RenderSystem.method27840();
            RenderSystem.depthMask(true);
            float var10 = 12.0F;
            float var11 = 4.0F;
            double var12 = 2.0E-4;
            double var14 = (double)(((float)this.field955 + var2) * 0.03F);
            double var16 = (var3 + var14) / 12.0;
            double var18 = (double)(var31 - (float)var5 + 0.33F);
            var18 += this.field939.field1299.field44691 * 128.0;
            double var20 = var7 / 12.0 + 0.33F;
            var16 -= (double)(MathHelper.method37769(var16 / 2048.0) * 2048);
            var20 -= (double)(MathHelper.method37769(var20 / 2048.0) * 2048);
            float var22 = (float)(var16 - (double) MathHelper.method37769(var16));
            float var23 = (float)(var18 / 4.0 - (double) MathHelper.method37769(var18 / 4.0)) * 4.0F;
            float var24 = (float)(var20 - (double) MathHelper.method37769(var20));
            Vector3d var25 = this.field943.method6874(var2);
            int var26 = (int)Math.floor(var16);
            int var27 = (int)Math.floor(var18 / 4.0);
            int var28 = (int)Math.floor(var20);
            if (var26 != this.field978
               || var27 != this.field979
               || var28 != this.field980
               || this.field939.field1299.method37153() != this.field982
               || this.field981.method11342(var25) > 2.0E-4) {
               this.field978 = var26;
               this.field979 = var27;
               this.field980 = var28;
               this.field981 = var25;
               this.field982 = this.field939.field1299.method37153();
               this.field952 = true;
            }

            if (this.field952) {
               this.field952 = false;
               Class5425 var29 = Class9352.method35409().method35411();
               if (this.field953 != null) {
                  this.field953.close();
               }

               this.field953 = new Class1698(Class9337.field43349);
               this.method890(var29, var16, var18, var20, var25);
               var29.method17065();
               this.field953.method7303(var29);
            }

            this.field940.bindTexture(field933);
            var1.method35294();
            var1.method35292(12.0F, 1.0F, 12.0F);
            var1.method35291((double)(-var22), (double)var23, (double)(-var24));
            if (this.field953 != null) {
               this.field953.method7302();
               Class9337.field43349.method26218(0L);
               int var35 = this.field982 == Class1904.field11186 ? 0 : 1;

               for (int var30 = var35; var30 < 2; var30++) {
                  if (var30 == 0) {
                     RenderSystem.method27870(false, false, false, false);
                  } else {
                     RenderSystem.method27870(true, true, true, true);
                  }

                  this.field953.method7306(var1.method35296().method32361(), 7);
               }

               Class1698.method7308();
               Class9337.field43349.method26219();
            }

            var1.method35295();
            RenderSystem.method27889(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.method27817();
            RenderSystem.method27849();
            RenderSystem.disableBlend();
            RenderSystem.method27841();
            if (Class7944.method26921()) {
               Class8981.method33077();
            }
         }
      }
   }

   private void method890(Class5425 var1, double var2, double var4, double var6, Vector3d var8) {
      float var9 = 4.0F;
      float var10 = 0.00390625F;
      int var11 = 8;
      int var12 = 4;
      float var13 = 9.765625E-4F;
      float var14 = (float) MathHelper.method37769(var2) * 0.00390625F;
      float var15 = (float) MathHelper.method37769(var6) * 0.00390625F;
      float var16 = (float)var8.field18048;
      float var17 = (float)var8.field18049;
      float var18 = (float)var8.field18050;
      float var19 = var16 * 0.9F;
      float var20 = var17 * 0.9F;
      float var21 = var18 * 0.9F;
      float var22 = var16 * 0.7F;
      float var23 = var17 * 0.7F;
      float var24 = var18 * 0.7F;
      float var25 = var16 * 0.8F;
      float var26 = var17 * 0.8F;
      float var27 = var18 * 0.8F;
      var1.method17063(7, Class9337.field43349);
      float var28 = (float)Math.floor(var4 / 4.0) * 4.0F;
      if (Class7944.method26822()) {
         for (int var29 = -3; var29 <= 4; var29++) {
            for (int var30 = -3; var30 <= 4; var30++) {
               float var31 = (float)(var29 * 8);
               float var32 = (float)(var30 * 8);
               if (var28 > -5.0F) {
                  var1.method17025((double)(var31 + 0.0F), (double)(var28 + 0.0F), (double)(var32 + 8.0F))
                     .method17027((var31 + 0.0F) * 0.00390625F + var14, (var32 + 8.0F) * 0.00390625F + var15)
                     .method17033(var22, var23, var24, 0.8F)
                     .method17030(0.0F, -1.0F, 0.0F)
                     .method17031();
                  var1.method17025((double)(var31 + 8.0F), (double)(var28 + 0.0F), (double)(var32 + 8.0F))
                     .method17027((var31 + 8.0F) * 0.00390625F + var14, (var32 + 8.0F) * 0.00390625F + var15)
                     .method17033(var22, var23, var24, 0.8F)
                     .method17030(0.0F, -1.0F, 0.0F)
                     .method17031();
                  var1.method17025((double)(var31 + 8.0F), (double)(var28 + 0.0F), (double)(var32 + 0.0F))
                     .method17027((var31 + 8.0F) * 0.00390625F + var14, (var32 + 0.0F) * 0.00390625F + var15)
                     .method17033(var22, var23, var24, 0.8F)
                     .method17030(0.0F, -1.0F, 0.0F)
                     .method17031();
                  var1.method17025((double)(var31 + 0.0F), (double)(var28 + 0.0F), (double)(var32 + 0.0F))
                     .method17027((var31 + 0.0F) * 0.00390625F + var14, (var32 + 0.0F) * 0.00390625F + var15)
                     .method17033(var22, var23, var24, 0.8F)
                     .method17030(0.0F, -1.0F, 0.0F)
                     .method17031();
               }

               if (var28 <= 5.0F) {
                  var1.method17025((double)(var31 + 0.0F), (double)(var28 + 4.0F - 9.765625E-4F), (double)(var32 + 8.0F))
                     .method17027((var31 + 0.0F) * 0.00390625F + var14, (var32 + 8.0F) * 0.00390625F + var15)
                     .method17033(var16, var17, var18, 0.8F)
                     .method17030(0.0F, 1.0F, 0.0F)
                     .method17031();
                  var1.method17025((double)(var31 + 8.0F), (double)(var28 + 4.0F - 9.765625E-4F), (double)(var32 + 8.0F))
                     .method17027((var31 + 8.0F) * 0.00390625F + var14, (var32 + 8.0F) * 0.00390625F + var15)
                     .method17033(var16, var17, var18, 0.8F)
                     .method17030(0.0F, 1.0F, 0.0F)
                     .method17031();
                  var1.method17025((double)(var31 + 8.0F), (double)(var28 + 4.0F - 9.765625E-4F), (double)(var32 + 0.0F))
                     .method17027((var31 + 8.0F) * 0.00390625F + var14, (var32 + 0.0F) * 0.00390625F + var15)
                     .method17033(var16, var17, var18, 0.8F)
                     .method17030(0.0F, 1.0F, 0.0F)
                     .method17031();
                  var1.method17025((double)(var31 + 0.0F), (double)(var28 + 4.0F - 9.765625E-4F), (double)(var32 + 0.0F))
                     .method17027((var31 + 0.0F) * 0.00390625F + var14, (var32 + 0.0F) * 0.00390625F + var15)
                     .method17033(var16, var17, var18, 0.8F)
                     .method17030(0.0F, 1.0F, 0.0F)
                     .method17031();
               }

               if (var29 > -1) {
                  for (int var33 = 0; var33 < 8; var33++) {
                     var1.method17025((double)(var31 + (float)var33 + 0.0F), (double)(var28 + 0.0F), (double)(var32 + 8.0F))
                        .method17027((var31 + (float)var33 + 0.5F) * 0.00390625F + var14, (var32 + 8.0F) * 0.00390625F + var15)
                        .method17033(var19, var20, var21, 0.8F)
                        .method17030(-1.0F, 0.0F, 0.0F)
                        .method17031();
                     var1.method17025((double)(var31 + (float)var33 + 0.0F), (double)(var28 + 4.0F), (double)(var32 + 8.0F))
                        .method17027((var31 + (float)var33 + 0.5F) * 0.00390625F + var14, (var32 + 8.0F) * 0.00390625F + var15)
                        .method17033(var19, var20, var21, 0.8F)
                        .method17030(-1.0F, 0.0F, 0.0F)
                        .method17031();
                     var1.method17025((double)(var31 + (float)var33 + 0.0F), (double)(var28 + 4.0F), (double)(var32 + 0.0F))
                        .method17027((var31 + (float)var33 + 0.5F) * 0.00390625F + var14, (var32 + 0.0F) * 0.00390625F + var15)
                        .method17033(var19, var20, var21, 0.8F)
                        .method17030(-1.0F, 0.0F, 0.0F)
                        .method17031();
                     var1.method17025((double)(var31 + (float)var33 + 0.0F), (double)(var28 + 0.0F), (double)(var32 + 0.0F))
                        .method17027((var31 + (float)var33 + 0.5F) * 0.00390625F + var14, (var32 + 0.0F) * 0.00390625F + var15)
                        .method17033(var19, var20, var21, 0.8F)
                        .method17030(-1.0F, 0.0F, 0.0F)
                        .method17031();
                  }
               }

               if (var29 <= 1) {
                  for (int var38 = 0; var38 < 8; var38++) {
                     var1.method17025((double)(var31 + (float)var38 + 1.0F - 9.765625E-4F), (double)(var28 + 0.0F), (double)(var32 + 8.0F))
                        .method17027((var31 + (float)var38 + 0.5F) * 0.00390625F + var14, (var32 + 8.0F) * 0.00390625F + var15)
                        .method17033(var19, var20, var21, 0.8F)
                        .method17030(1.0F, 0.0F, 0.0F)
                        .method17031();
                     var1.method17025((double)(var31 + (float)var38 + 1.0F - 9.765625E-4F), (double)(var28 + 4.0F), (double)(var32 + 8.0F))
                        .method17027((var31 + (float)var38 + 0.5F) * 0.00390625F + var14, (var32 + 8.0F) * 0.00390625F + var15)
                        .method17033(var19, var20, var21, 0.8F)
                        .method17030(1.0F, 0.0F, 0.0F)
                        .method17031();
                     var1.method17025((double)(var31 + (float)var38 + 1.0F - 9.765625E-4F), (double)(var28 + 4.0F), (double)(var32 + 0.0F))
                        .method17027((var31 + (float)var38 + 0.5F) * 0.00390625F + var14, (var32 + 0.0F) * 0.00390625F + var15)
                        .method17033(var19, var20, var21, 0.8F)
                        .method17030(1.0F, 0.0F, 0.0F)
                        .method17031();
                     var1.method17025((double)(var31 + (float)var38 + 1.0F - 9.765625E-4F), (double)(var28 + 0.0F), (double)(var32 + 0.0F))
                        .method17027((var31 + (float)var38 + 0.5F) * 0.00390625F + var14, (var32 + 0.0F) * 0.00390625F + var15)
                        .method17033(var19, var20, var21, 0.8F)
                        .method17030(1.0F, 0.0F, 0.0F)
                        .method17031();
                  }
               }

               if (var30 > -1) {
                  for (int var39 = 0; var39 < 8; var39++) {
                     var1.method17025((double)(var31 + 0.0F), (double)(var28 + 4.0F), (double)(var32 + (float)var39 + 0.0F))
                        .method17027((var31 + 0.0F) * 0.00390625F + var14, (var32 + (float)var39 + 0.5F) * 0.00390625F + var15)
                        .method17033(var25, var26, var27, 0.8F)
                        .method17030(0.0F, 0.0F, -1.0F)
                        .method17031();
                     var1.method17025((double)(var31 + 8.0F), (double)(var28 + 4.0F), (double)(var32 + (float)var39 + 0.0F))
                        .method17027((var31 + 8.0F) * 0.00390625F + var14, (var32 + (float)var39 + 0.5F) * 0.00390625F + var15)
                        .method17033(var25, var26, var27, 0.8F)
                        .method17030(0.0F, 0.0F, -1.0F)
                        .method17031();
                     var1.method17025((double)(var31 + 8.0F), (double)(var28 + 0.0F), (double)(var32 + (float)var39 + 0.0F))
                        .method17027((var31 + 8.0F) * 0.00390625F + var14, (var32 + (float)var39 + 0.5F) * 0.00390625F + var15)
                        .method17033(var25, var26, var27, 0.8F)
                        .method17030(0.0F, 0.0F, -1.0F)
                        .method17031();
                     var1.method17025((double)(var31 + 0.0F), (double)(var28 + 0.0F), (double)(var32 + (float)var39 + 0.0F))
                        .method17027((var31 + 0.0F) * 0.00390625F + var14, (var32 + (float)var39 + 0.5F) * 0.00390625F + var15)
                        .method17033(var25, var26, var27, 0.8F)
                        .method17030(0.0F, 0.0F, -1.0F)
                        .method17031();
                  }
               }

               if (var30 <= 1) {
                  for (int var40 = 0; var40 < 8; var40++) {
                     var1.method17025((double)(var31 + 0.0F), (double)(var28 + 4.0F), (double)(var32 + (float)var40 + 1.0F - 9.765625E-4F))
                        .method17027((var31 + 0.0F) * 0.00390625F + var14, (var32 + (float)var40 + 0.5F) * 0.00390625F + var15)
                        .method17033(var25, var26, var27, 0.8F)
                        .method17030(0.0F, 0.0F, 1.0F)
                        .method17031();
                     var1.method17025((double)(var31 + 8.0F), (double)(var28 + 4.0F), (double)(var32 + (float)var40 + 1.0F - 9.765625E-4F))
                        .method17027((var31 + 8.0F) * 0.00390625F + var14, (var32 + (float)var40 + 0.5F) * 0.00390625F + var15)
                        .method17033(var25, var26, var27, 0.8F)
                        .method17030(0.0F, 0.0F, 1.0F)
                        .method17031();
                     var1.method17025((double)(var31 + 8.0F), (double)(var28 + 0.0F), (double)(var32 + (float)var40 + 1.0F - 9.765625E-4F))
                        .method17027((var31 + 8.0F) * 0.00390625F + var14, (var32 + (float)var40 + 0.5F) * 0.00390625F + var15)
                        .method17033(var25, var26, var27, 0.8F)
                        .method17030(0.0F, 0.0F, 1.0F)
                        .method17031();
                     var1.method17025((double)(var31 + 0.0F), (double)(var28 + 0.0F), (double)(var32 + (float)var40 + 1.0F - 9.765625E-4F))
                        .method17027((var31 + 0.0F) * 0.00390625F + var14, (var32 + (float)var40 + 0.5F) * 0.00390625F + var15)
                        .method17033(var25, var26, var27, 0.8F)
                        .method17030(0.0F, 0.0F, 1.0F)
                        .method17031();
                  }
               }
            }
         }
      } else {
         boolean var34 = true;
         int var35 = 32;

         for (int var36 = -32; var36 < 32; var36 += 32) {
            for (int var37 = -32; var37 < 32; var37 += 32) {
               var1.method17025((double)(var36 + 0), (double)var28, (double)(var37 + 32))
                  .method17027((float)(var36 + 0) * 0.00390625F + var14, (float)(var37 + 32) * 0.00390625F + var15)
                  .method17033(var16, var17, var18, 0.8F)
                  .method17030(0.0F, -1.0F, 0.0F)
                  .method17031();
               var1.method17025((double)(var36 + 32), (double)var28, (double)(var37 + 32))
                  .method17027((float)(var36 + 32) * 0.00390625F + var14, (float)(var37 + 32) * 0.00390625F + var15)
                  .method17033(var16, var17, var18, 0.8F)
                  .method17030(0.0F, -1.0F, 0.0F)
                  .method17031();
               var1.method17025((double)(var36 + 32), (double)var28, (double)(var37 + 0))
                  .method17027((float)(var36 + 32) * 0.00390625F + var14, (float)(var37 + 0) * 0.00390625F + var15)
                  .method17033(var16, var17, var18, 0.8F)
                  .method17030(0.0F, -1.0F, 0.0F)
                  .method17031();
               var1.method17025((double)(var36 + 0), (double)var28, (double)(var37 + 0))
                  .method17027((float)(var36 + 0) * 0.00390625F + var14, (float)(var37 + 0) * 0.00390625F + var15)
                  .method17033(var16, var17, var18, 0.8F)
                  .method17030(0.0F, -1.0F, 0.0F)
                  .method17031();
            }
         }
      }
   }

   public void method891(long var1) {
      var1 = (long)((double)var1 + 1.0E8);
      this.field995 = this.field995 | this.field983.method33323();
      long var3 = Util.method38488();
      boolean var5 = false;
      if (this.field1002.size() > 0) {
         Iterator var6 = this.field1002.iterator();

         while (var6.hasNext()) {
            Class8066 var7 = (Class8066)var6.next();
            if (!this.field983.method33335(var7)) {
               break;
            }

            var7.method27720();
            var6.remove();
            this.field944.remove(var7);
            this.field1001.remove(var7);
         }
      }

      if (this.field1001.size() > 0) {
         Iterator var16 = this.field1001.iterator();
         if (var16.hasNext()) {
            Class8066 var18 = (Class8066)var16.next();
            if (this.field983.method33336(var18)) {
               var16.remove();
            }
         }
      }

      double var17 = 0.0;
      int var8 = Class7944.method26816();
      if (!this.field944.isEmpty()) {
         Iterator var9 = this.field944.iterator();

         while (var9.hasNext()) {
            Class8066 var10 = (Class8066)var9.next();
            boolean var11 = var10.method27742();
            boolean var12;
            if (!var10.method27722() && !var11) {
               var12 = this.field983.method33335(var10);
            } else {
               var12 = this.field983.method33334(var10);
            }

            if (!var12) {
               break;
            }

            var10.method27720();
            var9.remove();
            if (!var11) {
               double var13 = 2.0 * Class9333.method35300(var10);
               var17 += var13;
               if (var17 > (double)var8) {
                  break;
               }
            }
         }
      }
   }

   private void method892(Class9624 var1) {
      Class5425 var2 = Class9352.method35409().method35411();
      Class7522 var3 = this.field943.method6810();
      double var4 = (double)(this.field939.field1299.field44574 * 16);
      if (!(var1.method37504().field18048 < var3.method24532() - var4)
         || !(var1.method37504().field18048 > var3.method24530() + var4)
         || !(var1.method37504().field18050 < var3.method24533() - var4)
         || !(var1.method37504().field18050 > var3.method24531() + var4)) {
         if (Class7944.method26921()) {
            Class8981.method33117();
            Class8981.method33021(Class8981.field40819);
         }

         double var6 = 1.0 - var3.method24528(var1.method37504().field18048, var1.method37504().field18050) / var4;
         var6 = Math.pow(var6, 4.0);
         double var8 = var1.method37504().field18048;
         double var10 = var1.method37504().field18049;
         double var12 = var1.method37504().field18050;
         RenderSystem.enableBlend();
         RenderSystem.enableDepthTest();
         RenderSystem.method27836(Class2339.field15997, Class1981.field12927, Class2339.field15990, Class1981.field12936);
         this.field940.bindTexture(field935);
         RenderSystem.depthMask(Minecraft.method1517());
         RenderSystem.pushMatrix();
         int var14 = var3.method24529().method8765();
         float var15 = (float)(var14 >> 16 & 0xFF) / 255.0F;
         float var16 = (float)(var14 >> 8 & 0xFF) / 255.0F;
         float var17 = (float)(var14 & 0xFF) / 255.0F;
         RenderSystem.method27889(var15, var16, var17, (float)var6);
         RenderSystem.method27856(-3.0F, -3.0F);
         RenderSystem.method27852();
         RenderSystem.method27939();
         RenderSystem.disableAlphaTest();
         RenderSystem.method27850();
         float var18 = (float)(Util.method38487() % 3000L) / 3000.0F;
         float var19 = 0.0F;
         float var20 = 0.0F;
         float var21 = 128.0F;
         var2.method17063(7, Class9337.field43344);
         double var22 = Math.max((double) MathHelper.method37769(var12 - var4), var3.method24531());
         double var24 = Math.min((double) MathHelper.method37774(var12 + var4), var3.method24533());
         if (var8 > var3.method24532() - var4) {
            float var26 = 0.0F;

            for (double var27 = var22; var27 < var24; var26 += 0.5F) {
               double var29 = Math.min(1.0, var24 - var27);
               float var31 = (float)var29 * 0.5F;
               this.method893(var2, var8, var10, var12, var3.method24532(), 256, var27, var18 + var26, var18 + 0.0F);
               this.method893(var2, var8, var10, var12, var3.method24532(), 256, var27 + var29, var18 + var31 + var26, var18 + 0.0F);
               this.method893(var2, var8, var10, var12, var3.method24532(), 0, var27 + var29, var18 + var31 + var26, var18 + 128.0F);
               this.method893(var2, var8, var10, var12, var3.method24532(), 0, var27, var18 + var26, var18 + 128.0F);
               var27++;
            }
         }

         if (var8 < var3.method24530() + var4) {
            float var35 = 0.0F;

            for (double var38 = var22; var38 < var24; var35 += 0.5F) {
               double var41 = Math.min(1.0, var24 - var38);
               float var44 = (float)var41 * 0.5F;
               this.method893(var2, var8, var10, var12, var3.method24530(), 256, var38, var18 + var35, var18 + 0.0F);
               this.method893(var2, var8, var10, var12, var3.method24530(), 256, var38 + var41, var18 + var44 + var35, var18 + 0.0F);
               this.method893(var2, var8, var10, var12, var3.method24530(), 0, var38 + var41, var18 + var44 + var35, var18 + 128.0F);
               this.method893(var2, var8, var10, var12, var3.method24530(), 0, var38, var18 + var35, var18 + 128.0F);
               var38++;
            }
         }

         var22 = Math.max((double) MathHelper.method37769(var8 - var4), var3.method24530());
         var24 = Math.min((double) MathHelper.method37774(var8 + var4), var3.method24532());
         if (var12 > var3.method24533() - var4) {
            float var36 = 0.0F;

            for (double var39 = var22; var39 < var24; var36 += 0.5F) {
               double var42 = Math.min(1.0, var24 - var39);
               float var45 = (float)var42 * 0.5F;
               this.method893(var2, var8, var10, var12, var39, 256, var3.method24533(), var18 + var36, var18 + 0.0F);
               this.method893(var2, var8, var10, var12, var39 + var42, 256, var3.method24533(), var18 + var45 + var36, var18 + 0.0F);
               this.method893(var2, var8, var10, var12, var39 + var42, 0, var3.method24533(), var18 + var45 + var36, var18 + 128.0F);
               this.method893(var2, var8, var10, var12, var39, 0, var3.method24533(), var18 + var36, var18 + 128.0F);
               var39++;
            }
         }

         if (var12 < var3.method24531() + var4) {
            float var37 = 0.0F;

            for (double var40 = var22; var40 < var24; var37 += 0.5F) {
               double var43 = Math.min(1.0, var24 - var40);
               float var46 = (float)var43 * 0.5F;
               this.method893(var2, var8, var10, var12, var40, 256, var3.method24531(), var18 + var37, var18 + 0.0F);
               this.method893(var2, var8, var10, var12, var40 + var43, 256, var3.method24531(), var18 + var46 + var37, var18 + 0.0F);
               this.method893(var2, var8, var10, var12, var40 + var43, 0, var3.method24531(), var18 + var46 + var37, var18 + 128.0F);
               this.method893(var2, var8, var10, var12, var40, 0, var3.method24531(), var18 + var37, var18 + 128.0F);
               var40++;
            }
         }

         var2.method17065();
         Class4395.method13895(var2);
         RenderSystem.method27849();
         RenderSystem.method27817();
         RenderSystem.method27856(0.0F, 0.0F);
         RenderSystem.method27853();
         RenderSystem.disableAlphaTest();
         RenderSystem.method27836(Class2339.field15997, Class1981.field12932, Class2339.field15990, Class1981.field12936);
         RenderSystem.disableBlend();
         RenderSystem.popMatrix();
         RenderSystem.depthMask(true);
         if (Class7944.method26921()) {
            Class8981.method33118();
         }
      }
   }

   private void method893(Class5425 var1, double var2, double var4, double var6, double var8, int var10, double var11, float var13, float var14) {
      var1.method17025(var8 - var2, (double)var10 - var4, var11 - var6).method17027(var13, var14).method17031();
   }

   private void method894(Class9332 var1, Class5422 var2, Entity var3, double var4, double var6, double var8, BlockPos var10, Class7380 var11) {
      method896(
         var1,
         var2,
         var11.method23413(this.field943, var10, Class4832.method14948(var3)),
         (double)var10.method8304() - var4,
         (double)var10.getY() - var6,
         (double)var10.method8306() - var8,
         0.0F,
         0.0F,
         0.0F,
         0.4F
      );
   }

   public static void method895(
      Class9332 var0, Class5422 var1, Class6408 var2, double var3, double var5, double var7, float var9, float var10, float var11, float var12
   ) {
      List var13 = var2.method19521();
      int var14 = MathHelper.method37774((double)var13.size() / 3.0);

      for (int var15 = 0; var15 < var13.size(); var15++) {
         Class6488 var16 = (Class6488)var13.get(var15);
         float var17 = ((float)var15 % (float)var14 + 1.0F) / (float)var14;
         float var18 = (float)(var15 / var14);
         float var19 = var17 * (float)(var18 == 0.0F ? 1 : 0);
         float var20 = var17 * (float)(var18 == 1.0F ? 1 : 0);
         float var21 = var17 * (float)(var18 == 2.0F ? 1 : 0);
         method896(var0, var1, Class8022.method27428(var16.method19667(0.0, 0.0, 0.0)), var3, var5, var7, var19, var20, var21, 1.0F);
      }
   }

   private static void method896(
      Class9332 var0, Class5422 var1, Class6408 var2, double var3, double var5, double var7, float var9, float var10, float var11, float var12
   ) {
      Class9367 var13 = var0.method35296().method32361();
      var2.method19519((var12x, var14, var16, var18, var20, var22) -> {
         var1.method17040(var13, (float)(var12x + var3), (float)(var14 + var5), (float)(var16 + var7)).method17033(var9, var10, var11, var12).method17031();
         var1.method17040(var13, (float)(var18 + var3), (float)(var20 + var5), (float)(var22 + var7)).method17033(var9, var10, var11, var12).method17031();
      });
   }

   public static void method897(Class9332 var0, Class5422 var1, Class6488 var2, float var3, float var4, float var5, float var6) {
      method899(
         var0,
         var1,
         var2.field28449,
         var2.field28450,
         var2.field28451,
         var2.field28452,
         var2.field28453,
         var2.field28454,
         var3,
         var4,
         var5,
         var6,
         var3,
         var4,
         var5
      );
   }

   public static void method898(
      Class9332 var0,
      Class5422 var1,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      float var14,
      float var15,
      float var16,
      float var17
   ) {
      method899(var0, var1, var2, var4, var6, var8, var10, var12, var14, var15, var16, var17, var14, var15, var16);
   }

   public static void method899(
      Class9332 var0,
      Class5422 var1,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      float var14,
      float var15,
      float var16,
      float var17,
      float var18,
      float var19,
      float var20
   ) {
      Class9367 var21 = var0.method35296().method32361();
      float var22 = (float)var2;
      float var23 = (float)var4;
      float var24 = (float)var6;
      float var25 = (float)var8;
      float var26 = (float)var10;
      float var27 = (float)var12;
      var1.method17040(var21, var22, var23, var24).method17033(var14, var19, var20, var17).method17031();
      var1.method17040(var21, var25, var23, var24).method17033(var14, var19, var20, var17).method17031();
      var1.method17040(var21, var22, var23, var24).method17033(var18, var15, var20, var17).method17031();
      var1.method17040(var21, var22, var26, var24).method17033(var18, var15, var20, var17).method17031();
      var1.method17040(var21, var22, var23, var24).method17033(var18, var19, var16, var17).method17031();
      var1.method17040(var21, var22, var23, var27).method17033(var18, var19, var16, var17).method17031();
      var1.method17040(var21, var25, var23, var24).method17033(var14, var15, var16, var17).method17031();
      var1.method17040(var21, var25, var26, var24).method17033(var14, var15, var16, var17).method17031();
      var1.method17040(var21, var25, var26, var24).method17033(var14, var15, var16, var17).method17031();
      var1.method17040(var21, var22, var26, var24).method17033(var14, var15, var16, var17).method17031();
      var1.method17040(var21, var22, var26, var24).method17033(var14, var15, var16, var17).method17031();
      var1.method17040(var21, var22, var26, var27).method17033(var14, var15, var16, var17).method17031();
      var1.method17040(var21, var22, var26, var27).method17033(var14, var15, var16, var17).method17031();
      var1.method17040(var21, var22, var23, var27).method17033(var14, var15, var16, var17).method17031();
      var1.method17040(var21, var22, var23, var27).method17033(var14, var15, var16, var17).method17031();
      var1.method17040(var21, var25, var23, var27).method17033(var14, var15, var16, var17).method17031();
      var1.method17040(var21, var25, var23, var27).method17033(var14, var15, var16, var17).method17031();
      var1.method17040(var21, var25, var23, var24).method17033(var14, var15, var16, var17).method17031();
      var1.method17040(var21, var22, var26, var27).method17033(var14, var15, var16, var17).method17031();
      var1.method17040(var21, var25, var26, var27).method17033(var14, var15, var16, var17).method17031();
      var1.method17040(var21, var25, var23, var27).method17033(var14, var15, var16, var17).method17031();
      var1.method17040(var21, var25, var26, var27).method17033(var14, var15, var16, var17).method17031();
      var1.method17040(var21, var25, var26, var24).method17033(var14, var15, var16, var17).method17031();
      var1.method17040(var21, var25, var26, var27).method17033(var14, var15, var16, var17).method17031();
   }

   public static void method900(
      Class5425 var0, double var1, double var3, double var5, double var7, double var9, double var11, float var13, float var14, float var15, float var16
   ) {
      var0.method17025(var1, var3, var5).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var1, var3, var5).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var1, var3, var5).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var1, var3, var11).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var1, var9, var5).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var1, var9, var11).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var1, var9, var11).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var1, var3, var11).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var7, var9, var11).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var7, var3, var11).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var7, var3, var11).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var7, var3, var5).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var7, var9, var11).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var7, var9, var5).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var7, var9, var5).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var7, var3, var5).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var1, var9, var5).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var1, var3, var5).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var1, var3, var5).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var7, var3, var5).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var1, var3, var11).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var7, var3, var11).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var7, var3, var11).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var1, var9, var5).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var1, var9, var5).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var1, var9, var11).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var7, var9, var5).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var7, var9, var11).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var7, var9, var11).method17033(var13, var14, var15, var16).method17031();
      var0.method17025(var7, var9, var11).method17033(var13, var14, var15, var16).method17031();
   }

   public void method901(Class1665 var1, BlockPos var2, Class7380 var3, Class7380 var4, int var5) {
      this.method902(var2, false);
   }

   private void method902(BlockPos var1, boolean var2) {
      for (int var3 = var1.method8306() - 1; var3 <= var1.method8306() + 1; var3++) {
         for (int var4 = var1.method8304() - 1; var4 <= var1.method8304() + 1; var4++) {
            for (int var5 = var1.getY() - 1; var5 <= var1.getY() + 1; var5++) {
               this.method907(var4 >> 4, var5 >> 4, var3 >> 4, var2);
            }
         }
      }
   }

   public void method903(int var1, int var2, int var3, int var4, int var5, int var6) {
      for (int var7 = var3 - 1; var7 <= var6 + 1; var7++) {
         for (int var8 = var1 - 1; var8 <= var4 + 1; var8++) {
            for (int var9 = var2 - 1; var9 <= var5 + 1; var9++) {
               this.method906(var8 >> 4, var9 >> 4, var7 >> 4);
            }
         }
      }
   }

   public void method904(BlockPos var1, Class7380 var2, Class7380 var3) {
      if (this.field939.method1570().method1026(var2, var3)) {
         this.method903(var1.method8304(), var1.getY(), var1.method8306(), var1.method8304(), var1.getY(), var1.method8306());
      }
   }

   public void method905(int var1, int var2, int var3) {
      for (int var4 = var3 - 1; var4 <= var3 + 1; var4++) {
         for (int var5 = var1 - 1; var5 <= var1 + 1; var5++) {
            for (int var6 = var2 - 1; var6 <= var2 + 1; var6++) {
               this.method906(var5, var6, var4);
            }
         }
      }
   }

   public void method906(int var1, int var2, int var3) {
      this.method907(var1, var2, var3, false);
   }

   private void method907(int var1, int var2, int var3, boolean var4) {
      this.field947.method34760(var1, var2, var3, var4);
   }

   public void method908(Class9455 var1, BlockPos var2) {
      this.method909(var1, var2, var1 == null ? null : Class3283.method11814(var1));
   }

   public void method909(Class9455 var1, BlockPos var2, Class3283 var3) {
      Class6340 var4 = this.field958.get(var2);
      if (var4 != null) {
         this.field939.method1546().method1009(var4);
         this.field958.remove(var2);
      }

      if (var1 != null) {
         Class3283 var5 = Class3283.method11814(var1);
         if (Class9299.field42969.method20245()) {
            var5 = var3;
         }

         if (var5 != null) {
            this.field939.field1298.method5984(var5.method11813());
         }

         Class6339 var6 = Class6339.method19295(var1, (double)var2.method8304(), (double)var2.getY(), (double)var2.method8306());
         this.field958.put(var2, var6);
         this.field939.method1546().method1000(var6);
      }

      this.method910(this.field943, var2, var1 != null);
   }

   private void method910(Class1655 var1, BlockPos var2, boolean var3) {
      for (Class880 var5 : var1.<Class880>method7182(Class880.class, new Class6488(var2).method19664(3.0))) {
         var5.method3171(var2, var3);
      }
   }

   public void method911(Class7436 var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13) {
      this.method912(var1, var2, false, var3, var5, var7, var9, var11, var13);
   }

   public void method912(Class7436 var1, boolean var2, boolean var3, double var4, double var6, double var8, double var10, double var12, double var14) {
      try {
         this.method915(var1, var2, var3, var4, var6, var8, var10, var12, var14);
      } catch (Throwable var19) {
         Class4526 var17 = Class4526.method14413(var19, "Exception while adding particle");
         Class8965 var18 = var17.method14410("Particle being added");
         var18.method32807("ID", Class2348.field16077.method9181(var1.method24011()));
         var18.method32807("Parameters", var1.method24010());
         var18.method32806("Position", () -> Class8965.method32803(var4, var6, var8));
         throw new Class2506(var17);
      }
   }

   private <T extends Class7436> void method913(T var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      this.method911(var1, var1.method24011().method24006(), var2, var4, var6, var8, var10, var12);
   }

   @Nullable
   private Class4587 method914(Class7436 var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13) {
      return this.method915(var1, var2, false, var3, var5, var7, var9, var11, var13);
   }

   @Nullable
   private Class4587 method915(Class7436 var1, boolean var2, boolean var3, double var4, double var6, double var8, double var10, double var12, double var14) {
      Class9624 var16 = this.field939.field1295.method768();
      if (this.field939 != null && var16.method37510() && this.field939.field1291 != null) {
         Class2294 var17 = this.method916(var3);
         if (var1 == Class7940.field34069 && !Class7944.method26842()) {
            return null;
         } else if (var1 == Class7940.field34070 && !Class7944.method26842()) {
            return null;
         } else if (var1 == Class7940.field34089 && !Class7944.method26842()) {
            return null;
         } else if (var1 == Class7940.field34098 && !Class7944.method26846()) {
            return null;
         } else if (var1 == Class7940.field34092 && !Class7944.method26844()) {
            return null;
         } else if (var1 == Class7940.field34085 && !Class7944.method26844()) {
            return null;
         } else if (var1 == Class7940.field34068 && !Class7944.method26849()) {
            return null;
         } else if (var1 == Class7940.field34048 && !Class7944.method26849()) {
            return null;
         } else if (var1 == Class7940.field34063 && !Class7944.method26849()) {
            return null;
         } else if (var1 == Class7940.field34081 && !Class7944.method26849()) {
            return null;
         } else if (var1 == Class7940.field34100 && !Class7944.method26849()) {
            return null;
         } else if (var1 == Class7940.field34090 && !Class7944.method26848()) {
            return null;
         } else if (var1 == Class7940.field34074 && !Class7944.method26843()) {
            return null;
         } else if (var1 == Class7940.field34075 && !Class7944.method26843()) {
            return null;
         } else if (var1 == Class7940.field34062 && !Class7944.method26841()) {
            return null;
         } else if (var1 == Class7940.field34060 && !Class7944.method26897()) {
            return null;
         } else if (var1 == Class7940.field34057 && !Class7944.method26897()) {
            return null;
         } else if (var1 == Class7940.field34072 && !Class7944.method26850()) {
            return null;
         } else {
            if (!var2) {
               double var18 = 1024.0;
               if (var1 == Class7940.field34054) {
                  var18 = 38416.0;
               }

               if (var16.method37504().method11343(var4, var6, var8) > var18) {
                  return null;
               }

               if (var17 == Class2294.field15248) {
                  return null;
               }
            }

            Class4587 var20 = this.field939.field1291.method1197(var1, var4, var6, var8, var10, var12, var14);
            if (var1 == Class7940.field34052) {
               Class9680.method37864(var20, this.field943, var4, var6, var8, this.field1018);
            }

            if (var1 == Class7940.field34099) {
               Class9680.method37864(var20, this.field943, var4, var6, var8, this.field1018);
            }

            if (var1 == Class7940.field34091) {
               Class9680.method37864(var20, this.field943, var4, var6, var8, this.field1018);
            }

            if (var1 == Class7940.field34087) {
               Class9680.method37857(var20);
            }

            if (var1 == Class7940.field34090) {
               Class9680.method37856(var20);
            }

            if (var1 == Class7940.field34062) {
               Class9680.method37859(var20, this.field943, var4, var6, var8);
            }

            return var20;
         }
      } else {
         return null;
      }
   }

   private Class2294 method916(boolean var1) {
      Class2294 var2 = this.field939.field1299.field44674;
      if (var1 && var2 == Class2294.field15248 && this.field943.field9016.nextInt(10) == 0) {
         var2 = Class2294.field15247;
      }

      if (var2 == Class2294.field15247 && this.field943.field9016.nextInt(3) == 0) {
         var2 = Class2294.field15248;
      }

      return var2;
   }

   public void method917() {
   }

   public void method918(int var1, BlockPos var2, int var3) {
      switch (var1) {
         case 1023:
         case 1028:
         case 1038:
            Class9624 var4 = this.field939.field1295.method768();
            if (var4.method37510()) {
               double var5 = (double)var2.method8304() - var4.method37504().field18048;
               double var7 = (double)var2.getY() - var4.method37504().field18049;
               double var9 = (double)var2.method8306() - var4.method37504().field18050;
               double var11 = Math.sqrt(var5 * var5 + var7 * var7 + var9 * var9);
               double var13 = var4.method37504().field18048;
               double var15 = var4.method37504().field18049;
               double var17 = var4.method37504().field18050;
               if (var11 > 0.0) {
                  var13 += var5 / var11 * 2.0;
                  var15 += var7 / var11 * 2.0;
                  var17 += var9 / var11 * 2.0;
               }

               if (var1 == 1023) {
                  this.field943.method6745(var13, var15, var17, Class6067.field27248, Class2266.field14733, 1.0F, 1.0F, false);
               } else if (var1 == 1038) {
                  this.field943.method6745(var13, var15, var17, Class6067.field26558, Class2266.field14733, 1.0F, 1.0F, false);
               } else {
                  this.field943.method6745(var13, var15, var17, Class6067.field26537, Class2266.field14733, 5.0F, 1.0F, false);
               }
            }
      }
   }

   public void method919(PlayerEntity var1, int var2, BlockPos var3, int var4) {
      Random var5 = this.field943.field9016;
      switch (var2) {
         case 1000:
            this.field943.method6858(var3, Class6067.field26495, Class2266.field14732, 1.0F, 1.0F, false);
            break;
         case 1001:
            this.field943.method6858(var3, Class6067.field26496, Class2266.field14732, 1.0F, 1.2F, false);
            break;
         case 1002:
            this.field943.method6858(var3, Class6067.field26497, Class2266.field14732, 1.0F, 1.2F, false);
            break;
         case 1003:
            this.field943.method6858(var3, Class6067.field26544, Class2266.field14734, 1.0F, 1.2F, false);
            break;
         case 1004:
            this.field943.method6858(var3, Class6067.field26578, Class2266.field14734, 1.0F, 1.2F, false);
            break;
         case 1005:
            this.field943.method6858(var3, Class6067.field26699, Class2266.field14732, 1.0F, var5.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1006:
            this.field943.method6858(var3, Class6067.field27259, Class2266.field14732, 1.0F, var5.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1007:
            this.field943.method6858(var3, Class6067.field27261, Class2266.field14732, 1.0F, var5.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1008:
            this.field943.method6858(var3, Class6067.field26571, Class2266.field14732, 1.0F, var5.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1009:
            this.field943.method6858(var3, Class6067.field26582, Class2266.field14732, 0.5F, 2.6F + (var5.nextFloat() - var5.nextFloat()) * 0.8F, false);
            break;
         case 1010:
            if (Class3257.method11702(var4) instanceof Class3283) {
               if (Class9299.field42969.method20245()) {
                  this.method909(((Class3283)Class3257.method11702(var4)).method11815(), var3, (Class3283)Class3257.method11702(var4));
               } else {
                  this.method908(((Class3283)Class3257.method11702(var4)).method11815(), var3);
               }
            } else {
               this.method908((Class9455)null, var3);
            }
            break;
         case 1011:
            this.field943.method6858(var3, Class6067.field26698, Class2266.field14732, 1.0F, var5.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1012:
            this.field943.method6858(var3, Class6067.field27258, Class2266.field14732, 1.0F, var5.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1013:
            this.field943.method6858(var3, Class6067.field27260, Class2266.field14732, 1.0F, var5.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1014:
            this.field943.method6858(var3, Class6067.field26570, Class2266.field14732, 1.0F, var5.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1015:
            this.field943.method6858(var3, Class6067.field26621, Class2266.field14733, 10.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1016:
            this.field943.method6858(var3, Class6067.field26620, Class2266.field14733, 10.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1017:
            this.field943.method6858(var3, Class6067.field26542, Class2266.field14733, 10.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1018:
            this.field943.method6858(var3, Class6067.field26406, Class2266.field14733, 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1019:
            this.field943.method6858(var3, Class6067.field27283, Class2266.field14733, 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1020:
            this.field943.method6858(var3, Class6067.field27284, Class2266.field14733, 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1021:
            this.field943.method6858(var3, Class6067.field27285, Class2266.field14733, 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1022:
            this.field943.method6858(var3, Class6067.field27240, Class2266.field14733, 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1024:
            this.field943.method6858(var3, Class6067.field27243, Class2266.field14733, 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1025:
            this.field943.method6858(var3, Class6067.field26384, Class2266.field14734, 0.05F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1026:
            this.field943.method6858(var3, Class6067.field27293, Class2266.field14733, 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1027:
            this.field943.method6858(var3, Class6067.field27300, Class2266.field14734, 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1029:
            this.field943.method6858(var3, Class6067.field26341, Class2266.field14732, 1.0F, var5.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1030:
            this.field943.method6858(var3, Class6067.field26347, Class2266.field14732, 1.0F, var5.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1031:
            this.field943.method6858(var3, Class6067.field26344, Class2266.field14732, 0.3F, this.field943.field9016.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1032:
            this.field939.method1546().method1000(Class6339.method19296(Class6067.field26977, var5.nextFloat() * 0.4F + 0.8F, 0.25F));
            break;
         case 1033:
            this.field943.method6858(var3, Class6067.field26456, Class2266.field14732, 1.0F, 1.0F, false);
            break;
         case 1034:
            this.field943.method6858(var3, Class6067.field26455, Class2266.field14732, 1.0F, 1.0F, false);
            break;
         case 1035:
            this.field943.method6858(var3, Class6067.field26420, Class2266.field14732, 1.0F, 1.0F, false);
            break;
         case 1036:
            this.field943.method6858(var3, Class6067.field26706, Class2266.field14732, 1.0F, var5.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1037:
            this.field943.method6858(var3, Class6067.field26707, Class2266.field14732, 1.0F, var5.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1039:
            this.field943.method6858(var3, Class6067.field26919, Class2266.field14733, 0.3F, this.field943.field9016.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1040:
            this.field943.method6858(var3, Class6067.field27286, Class2266.field14734, 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1041:
            this.field943.method6858(var3, Class6067.field26687, Class2266.field14734, 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
            break;
         case 1042:
            this.field943.method6858(var3, Class6067.field26642, Class2266.field14732, 1.0F, this.field943.field9016.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1043:
            this.field943.method6858(var3, Class6067.field26414, Class2266.field14732, 1.0F, this.field943.field9016.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1044:
            this.field943.method6858(var3, Class6067.field27106, Class2266.field14732, 1.0F, this.field943.field9016.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 1500:
            Class3475.method12164(this.field943, var3, var4 > 0);
            break;
         case 1501:
            this.field943.method6858(var3, Class6067.field26726, Class2266.field14732, 0.5F, 2.6F + (var5.nextFloat() - var5.nextFloat()) * 0.8F, false);

            for (int var40 = 0; var40 < 8; var40++) {
               this.field943
                  .method6746(
                     Class7940.field34085,
                     (double)var3.method8304() + var5.nextDouble(),
                     (double)var3.getY() + 1.2,
                     (double)var3.method8306() + var5.nextDouble(),
                     0.0,
                     0.0,
                     0.0
                  );
            }
            break;
         case 1502:
            this.field943.method6858(var3, Class6067.field27011, Class2266.field14732, 0.5F, 2.6F + (var5.nextFloat() - var5.nextFloat()) * 0.8F, false);

            for (int var39 = 0; var39 < 5; var39++) {
               double var42 = (double)var3.method8304() + var5.nextDouble() * 0.6 + 0.2;
               double var44 = (double)var3.getY() + var5.nextDouble() * 0.6 + 0.2;
               double var45 = (double)var3.method8306() + var5.nextDouble() * 0.6 + 0.2;
               this.field943.method6746(Class7940.field34092, var42, var44, var45, 0.0, 0.0, 0.0);
            }
            break;
         case 1503:
            this.field943.method6858(var3, Class6067.field26557, Class2266.field14732, 1.0F, 1.0F, false);

            for (int var38 = 0; var38 < 16; var38++) {
               double var41 = (double)var3.method8304() + (5.0 + var5.nextDouble() * 6.0) / 16.0;
               double var43 = (double)var3.getY() + 0.8125;
               double var11 = (double)var3.method8306() + (5.0 + var5.nextDouble() * 6.0) / 16.0;
               this.field943.method6746(Class7940.field34092, var41, var43, var11, 0.0, 0.0, 0.0);
            }
            break;
         case 2000:
            Direction var6 = Direction.method546(var4);
            int var7 = var6.method539();
            int var8 = var6.method540();
            int var9 = var6.method541();
            double var10 = (double)var3.method8304() + (double)var7 * 0.6 + 0.5;
            double var12 = (double)var3.getY() + (double)var8 * 0.6 + 0.5;
            double var14 = (double)var3.method8306() + (double)var9 * 0.6 + 0.5;

            for (int var46 = 0; var46 < 10; var46++) {
               double var48 = var5.nextDouble() * 0.2 + 0.01;
               double var50 = var10 + (double)var7 * 0.01 + (var5.nextDouble() - 0.5) * (double)var9 * 0.5;
               double var51 = var12 + (double)var8 * 0.01 + (var5.nextDouble() - 0.5) * (double)var8 * 0.5;
               double var53 = var14 + (double)var9 * 0.01 + (var5.nextDouble() - 0.5) * (double)var7 * 0.5;
               double var54 = (double)var7 * var48 + var5.nextGaussian() * 0.01;
               double var55 = (double)var8 * var48 + var5.nextGaussian() * 0.01;
               double var62 = (double)var9 * var48 + var5.nextGaussian() * 0.01;
               this.method913(Class7940.field34092, var50, var51, var53, var54, var55, var62);
            }
            break;
         case 2001:
            Class7380 var16 = Block.method11536(var4);
            if (!Class9561.method37050(var16, this.field943, var3)) {
               Class8447 var47 = var16.method23452();
               if (Class9299.field42827.method20214()) {
                  var47 = (Class8447)Class9299.method35070(var16, Class9299.field42827, this.field943, var3, null);
               }

               this.field943
                  .method6858(var3, var47.method29712(), Class2266.field14732, (var47.method29710() + 1.0F) / 2.0F, var47.method29711() * 0.8F, false);
            }

            this.field939.field1291.method1206(var3, var16);
            break;
         case 2002:
         case 2007:
            Vector3d var17 = Vector3d.method11330(var3);

            for (int var18 = 0; var18 < 8; var18++) {
               this.method913(
                  new Class7438(Class7940.field34082, new ItemStack(Class8514.field38115)),
                  var17.field18048,
                  var17.field18049,
                  var17.field18050,
                  var5.nextGaussian() * 0.15,
                  var5.nextDouble() * 0.2,
                  var5.nextGaussian() * 0.15
               );
            }

            float var49 = (float)(var4 >> 16 & 0xFF) / 255.0F;
            float var19 = (float)(var4 >> 8 & 0xFF) / 255.0F;
            float var20 = (float)(var4 >> 0 & 0xFF) / 255.0F;
            Class7435 var21 = var2 == 2007 ? Class7940.field34081 : Class7940.field34063;

            for (int var52 = 0; var52 < 100; var52++) {
               double var23 = var5.nextDouble() * 4.0;
               double var25 = var5.nextDouble() * Math.PI * 2.0;
               double var27 = Math.cos(var25) * var23;
               double var61 = 0.01 + var5.nextDouble() * 0.5;
               double var64 = Math.sin(var25) * var23;
               Class4587 var66 = this.method914(
                  var21,
                  var21.method24011().method24006(),
                  var17.field18048 + var27 * 0.1,
                  var17.field18049 + 0.3,
                  var17.field18050 + var64 * 0.1,
                  var27,
                  var61,
                  var64
               );
               if (var66 != null) {
                  float var34 = 0.75F + var5.nextFloat() * 0.25F;
                  var66.method14514(var49 * var34, var19 * var34, var20 * var34);
                  var66.method14513((float)var23);
               }
            }

            this.field943.method6858(var3, Class6067.field27123, Class2266.field14734, 1.0F, var5.nextFloat() * 0.1F + 0.9F, false);
            break;
         case 2003:
            double var22 = (double)var3.method8304() + 0.5;
            double var24 = (double)var3.getY();
            double var26 = (double)var3.method8306() + 0.5;

            for (int var58 = 0; var58 < 8; var58++) {
               this.method913(
                  new Class7438(Class7940.field34082, new ItemStack(Class8514.field37979)),
                  var22,
                  var24,
                  var26,
                  var5.nextGaussian() * 0.15,
                  var5.nextDouble() * 0.2,
                  var5.nextGaussian() * 0.15
               );
            }

            for (double var59 = 0.0; var59 < Math.PI * 2; var59 += Math.PI / 20) {
               this.method913(
                  Class7940.field34090,
                  var22 + Math.cos(var59) * 5.0,
                  var24 - 0.4,
                  var26 + Math.sin(var59) * 5.0,
                  Math.cos(var59) * -5.0,
                  0.0,
                  Math.sin(var59) * -5.0
               );
               this.method913(
                  Class7940.field34090,
                  var22 + Math.cos(var59) * 5.0,
                  var24 - 0.4,
                  var26 + Math.sin(var59) * 5.0,
                  Math.cos(var59) * -7.0,
                  0.0,
                  Math.sin(var59) * -7.0
               );
            }
            break;
         case 2004:
            for (int var57 = 0; var57 < 20; var57++) {
               double var60 = (double)var3.method8304() + 0.5 + (var5.nextDouble() - 0.5) * 2.0;
               double var63 = (double)var3.getY() + 0.5 + (var5.nextDouble() - 0.5) * 2.0;
               double var65 = (double)var3.method8306() + 0.5 + (var5.nextDouble() - 0.5) * 2.0;
               this.field943.method6746(Class7940.field34092, var60, var63, var65, 0.0, 0.0, 0.0);
               this.field943.method6746(Class7940.field34074, var60, var63, var65, 0.0, 0.0, 0.0);
            }
            break;
         case 2005:
            Class3336.method11885(this.field943, var3, var4);
            break;
         case 2006:
            for (int var56 = 0; var56 < 200; var56++) {
               float var29 = var5.nextFloat() * 4.0F;
               float var30 = var5.nextFloat() * (float) (Math.PI * 2);
               double var31 = (double)(MathHelper.method37764(var30) * var29);
               double var33 = 0.01 + var5.nextDouble() * 0.5;
               double var35 = (double)(MathHelper.method37763(var30) * var29);
               Class4587 var37 = this.method914(
                  Class7940.field34056,
                  false,
                  (double)var3.method8304() + var31 * 0.1,
                  (double)var3.getY() + 0.3,
                  (double)var3.method8306() + var35 * 0.1,
                  var31,
                  var33,
                  var35
               );
               if (var37 != null) {
                  var37.method14513(var29);
               }
            }

            if (var4 == 1) {
               this.field943.method6858(var3, Class6067.field26538, Class2266.field14733, 1.0F, var5.nextFloat() * 0.1F + 0.9F, false);
            }
            break;
         case 2008:
            this.field943
               .method6746(
                  Class7940.field34070, (double)var3.method8304() + 0.5, (double)var3.getY() + 0.5, (double)var3.method8306() + 0.5, 0.0, 0.0, 0.0
               );
            break;
         case 2009:
            for (int var28 = 0; var28 < 8; var28++) {
               this.field943
                  .method6746(
                     Class7940.field34053,
                     (double)var3.method8304() + var5.nextDouble(),
                     (double)var3.getY() + 1.2,
                     (double)var3.method8306() + var5.nextDouble(),
                     0.0,
                     0.0,
                     0.0
                  );
            }
            break;
         case 3000:
            this.field943
               .method6747(
                  Class7940.field34069, true, (double)var3.method8304() + 0.5, (double)var3.getY() + 0.5, (double)var3.method8306() + 0.5, 0.0, 0.0, 0.0
               );
            this.field943
               .method6858(
                  var3,
                  Class6067.field26556,
                  Class2266.field14732,
                  10.0F,
                  (1.0F + (this.field943.field9016.nextFloat() - this.field943.field9016.nextFloat()) * 0.2F) * 0.7F,
                  false
               );
            break;
         case 3001:
            this.field943.method6858(var3, Class6067.field26540, Class2266.field14733, 64.0F, 0.8F + this.field943.field9016.nextFloat() * 0.3F, false);
      }
   }

   public void method920(int var1, BlockPos var2, int var3) {
      if (var3 >= 0 && var3 < 10) {
         Class1995 var5 = (Class1995)this.field956.get(var1);
         if (var5 != null) {
            this.method886(var5);
         }

         if (var5 == null
            || var5.method8283().method8304() != var2.method8304()
            || var5.method8283().getY() != var2.getY()
            || var5.method8283().method8306() != var2.method8306()) {
            var5 = new Class1995(var1, var2);
            this.field956.put(var1, var5);
         }

         var5.method8284(var3);
         var5.method8286(this.field955);
         ((SortedSet)this.field957.computeIfAbsent(var5.method8283().method8332(), var0 -> Sets.newTreeSet())).add(var5);
      } else {
         Class1995 var4 = (Class1995)this.field956.remove(var1);
         if (var4 != null) {
            this.method886(var4);
         }
      }
   }

   public boolean method921() {
      return this.field944.isEmpty() && this.field983.method33330();
   }

   public void method922() {
      this.field995 = true;
      this.field952 = true;
   }

   public int method923() {
      return this.field947.field42528.length;
   }

   public int method924() {
      return this.field945.size();
   }

   public int method925() {
      return this.field986;
   }

   public int method926() {
      return this.field1016;
   }

   public int method927() {
      if (this.field943 == null) {
         return 0;
      } else {
         Class1705 var1 = this.field943.method6883();
         return var1 == null ? 0 : var1.method7405();
      }
   }

   public int method928() {
      return this.field944.size();
   }

   public Class8066 method929(BlockPos var1) {
      return this.field947.method34761(var1);
   }

   public Class1656 method930() {
      return this.field943;
   }

   private void method931() {
      if (field1022 > 0) {
         this.field945 = new ObjectArrayList(this.field945.size() + 16);
         this.field1005 = new ArrayList<Class7002>(this.field1005.size() + 16);
         this.field1006 = new ArrayList<Class7002>(this.field1006.size() + 16);
      } else {
         this.field945.clear();
         this.field1005.clear();
         this.field1006.clear();
      }
   }

   public void method932() {
      if (this.field1021) {
         this.method868();
         this.field1021 = false;
      }
   }

   public void method933() {
      if (this.field983 != null) {
         this.field983.method33332();
      }
   }

   public void method934() {
      if (this.field983 != null) {
         this.field983.method33333();
      }
   }

   public int method935() {
      return this.field996;
   }

   public int method936() {
      return ++this.field996;
   }

   public Class7911 method937() {
      return this.field942;
   }

   public List<Class7002> method938() {
      return this.field1005;
   }

   public List<Class7002> method939() {
      return this.field1006;
   }

   private void method940(Class9624 var1, Class7647 var2, boolean var3) {
      if (this.field1023 == 0) {
         this.method941(var1, var2, var3);
         this.field939.field1298.method5989().method5941(201435902);
      }

      if (this.field1023 > -1) {
         this.field1023--;
      }
   }

   private void method941(Class9624 var1, Class7647 var2, boolean var3) {
      int var4 = this.field939.field1299.field44705;
      boolean var5 = this.field939.field1299.field44684;

      try {
         this.field939.field1299.field44705 = 1000;
         this.field939.field1299.field44684 = false;
         Class264 var6 = Class7944.method26874();
         int var7 = var6.method927();
         long var8 = System.currentTimeMillis();
         Class7944.method26810("Loading visible chunks");
         long var10 = System.currentTimeMillis() + 5000L;
         int var12 = 0;
         boolean var13 = false;

         do {
            var13 = false;

            for (int var14 = 0; var14 < 100; var14++) {
               var6.method922();
               var6.method874(var1, var2, false, this.field996++, var3);
               if (!var6.method921()) {
                  var13 = true;
               }

               var12 += var6.method928();

               while (!var6.method921()) {
                  var6.method891(System.nanoTime() + 1000000000L);
               }

               var12 -= var6.method928();
               if (!var13) {
                  break;
               }
            }

            if (var6.method927() != var7) {
               var13 = true;
               var7 = var6.method927();
            }

            if (System.currentTimeMillis() > var10) {
               Class7944.method26815("Chunks loaded: " + var12);
               var10 = System.currentTimeMillis() + 5000L;
            }
         } while (var13);

         Class7944.method26815("Chunks loaded: " + var12);
         Class7944.method26815("Finished loading visible chunks");
         Class9016.field41247 = 0;
      } finally {
         this.field939.field1299.field44705 = var4;
         this.field939.field1299.field44684 = var5;
      }
   }

   public Class1991 method942() {
      return Class1990.field12988;
   }

   public void method943(Collection<Class944> var1, Collection<Class944> var2) {
      synchronized (this.field946) {
         this.field946.removeAll(var1);
         this.field946.addAll(var2);
      }
   }

   public static int method944(Class1663 var0, BlockPos var1) {
      return method945(var0, var0.method6738(var1), var1);
   }

   public static int method945(Class1663 var0, Class7380 var1, BlockPos var2) {
      if (var1.method23398(var0, var2)) {
         return 15728880;
      } else {
         int var3 = var0.method7020(Class1977.field12881, var2);
         int var4 = var0.method7020(Class1977.field12882, var2);
         int var5 = var1.method23494(var0, var2);
         if (var4 < var5) {
            var4 = var5;
         }

         int var6 = var3 << 20 | var4 << 4;
         if (Class7944.method26970() && var0 instanceof Class1665 && (!field1025 || !var1.method23409(var0, var2))) {
            var6 = Class9446.method36314(var2, var6);
         }

         return var6;
      }
   }

   @Nullable
   public Framebuffer method946() {
      return this.field959;
   }

   @Nullable
   public Framebuffer method947() {
      return this.field961;
   }

   @Nullable
   public Framebuffer method948() {
      return this.field962;
   }

   @Nullable
   public Framebuffer method949() {
      return this.field963;
   }

   @Nullable
   public Framebuffer method950() {
      return this.field964;
   }

   @Nullable
   public Framebuffer method951() {
      return this.field965;
   }
}
