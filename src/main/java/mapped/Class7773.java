package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.optifine.Config;

public class Class7773 {
   private static String[] field33348;
   private Class7078[] field33349 = new Class7078[0];
   private boolean field33350 = false;

   public void method25749(BipedModel var1, AbstractClientPlayerEntity var2, MatrixStack var3, IRenderTypeBuffer var4, int var5, int var6) {
      if (this.field33350) {
         for (int var9 = 0; var9 < this.field33349.length; var9++) {
            Class7078 var10 = this.field33349[var9];
            var10.method21991(var1, var2, var3, var4, var5, var6);
         }
      }
   }

   public boolean method25750() {
      return this.field33350;
   }

   public void method25751(boolean var1) {
      this.field33350 = var1;
   }

   public Class7078[] method25752() {
      return this.field33349;
   }

   public void method25753(Class7078 var1) {
      this.field33349 = (Class7078[]) Config.method26948(this.field33349, var1);
   }
}
