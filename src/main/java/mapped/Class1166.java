package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.AbstractGui;

public class Class1166 extends Class1155<Class1166> {
   private static String[] field6328;
   private final Class6114 field6329;
   public final RealmGUI field6330;

   public Class1166(RealmGUI var1, Class6114 var2) {
      this.field6330 = var1;
      this.field6329 = var2;
   }

   @Override
   public void render(MatrixStack var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9, float var10) {
      this.method5567(var1, this.field6329, var4, var3, var7, var8);
   }

   private void method5567(MatrixStack var1, Class6114 var2, int var3, int var4, int var5, int var6) {
      int var9;
      if (var2.method18881()) {
         if (!var2.method18883()) {
            var9 = 16777215;
         } else {
            var9 = 8388479;
         }
      } else {
         var9 = 10526880;
      }

      RealmGUI.method2426(this.field6330).method38801(var1, var2.method18875(), (float)(RealmGUI.method2425(this.field6330) + 3 + 12), (float)(var4 + 1), var9);
      if (!var2.method18879()) {
         RealmGUI.method2429(this.field6330, var1, RealmGUI.method2425(this.field6330) + RealmGUI.method2427(this.field6330) - 10, var4 + 1, var5, var6);
      } else {
         RealmGUI.method2428(this.field6330, var1, RealmGUI.method2425(this.field6330) + RealmGUI.method2427(this.field6330) - 10, var4 + 1, var5, var6);
      }

      RealmGUI.method2430(this.field6330, var1, RealmGUI.method2425(this.field6330) + RealmGUI.method2427(this.field6330) - 22, var4 + 2, var5, var6);
      Class8087.method27973(var2.method18877(), () -> {
         RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
         AbstractGui.method5698(var1, RealmGUI.method2425(this.field6330) + 2 + 2, var4 + 1, 8, 8, 8.0F, 8.0F, 8, 8, 64, 64);
         AbstractGui.method5698(var1, RealmGUI.method2425(this.field6330) + 2 + 2, var4 + 1, 8, 8, 40.0F, 8.0F, 8, 8, 64, 64);
      });
   }
}
