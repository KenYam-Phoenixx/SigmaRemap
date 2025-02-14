package mapped;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.optifine.Config;
import net.optifine.shaders.Shaders;
import net.optifine.util.BiomeUtils;

public enum Class1910 {
   field11209("biome"),
   field11210("biome_category"),
   field11211("biome_precipitation"),
   field11212("temperature"),
   field11213("rainfall"),
   field11214(Shaders.field40721),
   field11215(Shaders.field40722),
   field11216(Shaders.field40723),
   field11217(Shaders.field40724),
   field11218(Shaders.field40729),
   field11219(Shaders.field40730),
   field11220(Shaders.field40731),
   field11221(Shaders.field40732),
   field11222(Shaders.field40733),
   field11223(Shaders.field40734),
   field11224(Shaders.field40735),
   field11225(Shaders.field40736),
   field11226(Shaders.field40737),
   field11227(Shaders.field40738),
   field11228(Shaders.field40739),
   field11229(Shaders.field40740),
   field11230(Shaders.field40741),
   field11231(Shaders.field40742),
   field11232(Shaders.field40759),
   field11233(Shaders.field40760),
   field11234(Shaders.field40761, new String[]{"x", "y"}),
   field11235(Shaders.field40763, new String[]{"x", "y"}),
   field11236(Shaders.field40764),
   field11237(Shaders.field40765),
   field11238(Shaders.field40766),
   field11239(Shaders.field40767),
   field11240(Shaders.field40768),
   field11241(Shaders.field40769),
   field11242(Shaders.field40770),
   field11243(Shaders.field40771, new String[]{"x", "y"}),
   field11244(Shaders.field40774),
   field11245(Shaders.field40748, new String[]{"x", "y", "z"}),
   field11246(Shaders.field40747, new String[]{"x", "y", "z"}),
   field11247(Shaders.field40743, new String[]{"x", "y", "z"}),
   field11248(Shaders.field40744, new String[]{"x", "y", "z"}),
   field11249(Shaders.field40745, new String[]{"x", "y", "z"}),
   field11250(Shaders.field40746, new String[]{"x", "y", "z"}),
   field11251(Shaders.field40728, new String[]{"r", "g", "b"}),
   field11252(Shaders.field40752, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"}),
   field11253(Shaders.field40753, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"}),
   field11254(Shaders.field40751, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"}),
   field11255(Shaders.field40749, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"}),
   field11256(Shaders.field40750, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"}),
   field11257(Shaders.field40754, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"}),
   field11258(Shaders.field40755, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"}),
   field11259(Shaders.field40756, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"}),
   field11260(Shaders.field40757, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"}),
   field11261(Shaders.field40758, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"});

   private String field11262;
   private Class3614 field11263;
   private String[] field11264;
   private String[] field11265;
   private static final Class1910[] field11266 = new Class1910[]{
      field11209,
      field11210,
      field11211,
      field11212,
      field11213,
      field11214,
      field11215,
      field11216,
      field11217,
      field11218,
      field11219,
      field11220,
      field11221,
      field11222,
      field11223,
      field11224,
      field11225,
      field11226,
      field11227,
      field11228,
      field11229,
      field11230,
      field11231,
      field11232,
      field11233,
      field11234,
      field11235,
      field11236,
      field11237,
      field11238,
      field11239,
      field11240,
      field11241,
      field11242,
      field11243,
      field11244,
      field11245,
      field11246,
      field11247,
      field11248,
      field11249,
      field11250,
      field11251,
      field11252,
      field11253,
      field11254,
      field11255,
      field11256,
      field11257,
      field11258,
      field11259,
      field11260,
      field11261
   };

   private Class1910(String var3) {
      this.field11262 = var3;
   }

   private Class1910(Class3614 var3) {
      this.field11262 = var3.method12239();
      this.field11263 = var3;
      if (!method8188(var3, Class3620.class, Class3617.class)) {
         throw new IllegalArgumentException("Invalid uniform type for enum: " + this + ", uniform: " + var3.getClass().getName());
      }
   }

   private Class1910(Class3614 var3, String[] var4) {
      this.field11262 = var3.method12239();
      this.field11263 = var3;
      this.field11264 = var4;
      if (!method8188(var3, Class3621.class, Class3619.class, Class3618.class, Class3613.class)) {
         throw new IllegalArgumentException("Invalid uniform type for enum: " + this + ", uniform: " + var3.getClass().getName());
      }
   }

   private Class1910(Class3614 var3, String[] var4, String[] var5) {
      this.field11262 = var3.method12239();
      this.field11263 = var3;
      this.field11264 = var4;
      this.field11265 = var5;
      if (!method8188(var3, Class3615.class)) {
         throw new IllegalArgumentException("Invalid uniform type for enum: " + this + ", uniform: " + var3.getClass().getName());
      }
   }

   public String method8183() {
      return this.field11262;
   }

   public Class3614 method8184() {
      return this.field11263;
   }

   public String[] method8185() {
      return this.field11264;
   }

   public String[] method8186() {
      return this.field11265;
   }

   public float method8187(int var1, int var2) {
      if (this.field11264 == null || var1 >= 0 && var1 <= this.field11264.length) {
         if (this.field11265 == null || var2 >= 0 && var2 <= this.field11265.length) {
            switch (Class5431.field24169[this.ordinal()]) {
               case 1:
                  BlockPos var5 = Shaders.method33165();
                  Biome var6 = Shaders.method33164().getBiome(var5);
                  return (float) BiomeUtils.getId(var6);
               case 2:
                  BlockPos var7 = Shaders.method33165();
                  Biome var8 = Shaders.method33164().getBiome(var7);
                  return var8 != null ? (float)var8.getCategory().ordinal() : 0.0F;
               case 3:
                  BlockPos var9 = Shaders.method33165();
                  Biome var10 = Shaders.method33164().getBiome(var9);
                  return var10 != null ? (float)var10.getPrecipitation().ordinal() : 0.0F;
               case 4:
                  BlockPos var11 = Shaders.method33165();
                  Biome var12 = Shaders.method33164().getBiome(var11);
                  return var12 != null ? var12.getTemperature(var11) : 0.0F;
               case 5:
                  BlockPos var13 = Shaders.method33165();
                  Biome var14 = Shaders.method33164().getBiome(var13);
                  return var14 != null ? var14.getDownfall() : 0.0F;
               default:
                  if (this.field11263 instanceof Class3620) {
                     return ((Class3620)this.field11263).method12258();
                  } else if (this.field11263 instanceof Class3617) {
                     return (float)((Class3617)this.field11263).method12252();
                  } else if (this.field11263 instanceof Class3621) {
                     return (float)((Class3621)this.field11263).method12260()[var1];
                  } else if (this.field11263 instanceof Class3619) {
                     return ((Class3619)this.field11263).method12256()[var1];
                  } else if (this.field11263 instanceof Class3618) {
                     return ((Class3618)this.field11263).method12254()[var1];
                  } else if (this.field11263 instanceof Class3613) {
                     return ((Class3613)this.field11263).method12234()[var1];
                  } else if (this.field11263 instanceof Class3615) {
                     return ((Class3615)this.field11263).method12248(var1, var2);
                  } else {
                     throw new IllegalArgumentException("Unknown uniform type: " + this);
                  }
            }
         } else {
            Config.method26811("Invalid index2, parameter: " + this + ", index: " + var2);
            return 0.0F;
         }
      } else {
         Config.method26811("Invalid index1, parameter: " + this + ", index: " + var1);
         return 0.0F;
      }
   }

   private static boolean method8188(Object var0, Class... var1) {
      if (var0 == null) {
         return false;
      } else {
         Class var4 = var0.getClass();

         for (int var5 = 0; var5 < var1.length; var5++) {
            Class var6 = var1[var5];
            if (var6.isAssignableFrom(var4)) {
               return true;
            }
         }

         return false;
      }
   }
}
