package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.util.text.ITextComponent;

import java.util.Collections;
import java.util.List;

public class Class1187 extends Class1186 {
   private static String[] field6409;
   private final ITextComponent field6410;
   private final int field6411;
   public final Class1295 field6412;

   public Class1187(Class1295 var1, ITextComponent var2) {
      this.field6412 = var1;
      this.field6410 = var2;
      this.field6411 = var1.mc.fontRenderer.method38821(this.field6410);
   }

   @Override
   public void render(MatrixStack var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9, float var10) {
      this.field6412
         .mc
         .fontRenderer
         .func_243248_b(
            var1, this.field6410, (float)(this.field6412.mc.currentScreen.width / 2 - this.field6411 / 2), (float)(var3 + var6 - 9 - 1), 16777215
         );
   }

   @Override
   public boolean changeFocus(boolean var1) {
      return false;
   }

   @Override
   public List<? extends IGuiEventListener2> getEventListeners() {
      return Collections.emptyList();
   }
}
