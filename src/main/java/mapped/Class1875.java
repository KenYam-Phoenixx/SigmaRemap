package mapped;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

public enum Class1875 implements Class1876 {
   field11013("is_alive"),
   field11014("is_burning"),
   field11015("is_child"),
   field11016("is_glowing"),
   field11017("is_hurt"),
   field11018("is_in_lava"),
   field11019("is_in_water"),
   field11020("is_invisible"),
   field11021("is_on_ground"),
   field11022("is_ridden"),
   field11023("is_riding"),
   field11024("is_sneaking"),
   field11025("is_sprinting"),
   field11026("is_wet");

   private String field11027;
   private EntityRendererManager field11028;
   private static final Class1875[] field11029 = values();
   private static final Class1875[] field11030 = new Class1875[]{
      field11013,
      field11014,
      field11015,
      field11016,
      field11017,
      field11018,
      field11019,
      field11020,
      field11021,
      field11022,
      field11023,
      field11024,
      field11025,
      field11026
   };

   private Class1875(String var3) {
      this.field11027 = var3;
      this.field11028 = Minecraft.getInstance().getRenderManager();
   }

   public String method8136() {
      return this.field11027;
   }

   @Override
   public boolean method8137() {
      Entity var3 = Minecraft.getInstance().getRenderViewEntity();
      if (var3 instanceof LivingEntity) {
         LivingEntity var4 = (LivingEntity)var3;
         switch (Class9308.field43219[this.ordinal()]) {
            case 1:
               return var4.isAlive();
            case 2:
               return var4.isBurning();
            case 3:
               return var4.isChild();
            case 4:
               return var4.isGlowing();
            case 5:
               return var4.hurtTime > 0;
            case 6:
               return var4.isInLava();
            case 7:
               return var4.isInWater();
            case 8:
               return var4.isInvisible();
            case 9:
               return var4.isOnGround();
            case 10:
               return var4.isBeingRidden();
            case 11:
               return var4.isPassenger();
            case 12:
               return var4.isCrouching();
            case 13:
               return var4.isSprinting();
            case 14:
               return var4.method3253();
         }
      }

      return false;
   }

   public static Class1875 method8138(String var0) {
      if (var0 == null) {
         return null;
      } else {
         for (int var3 = 0; var3 < field11029.length; var3++) {
            Class1875 var4 = field11029[var3];
            if (var4.method8136().equals(var0)) {
               return var4;
            }
         }

         return null;
      }
   }
}
