package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;

public abstract class Class1202 extends Class1201 {
   private final int field6500;
   private final int field6501;

   public Class1202(int var1, int var2, int var3, int var4) {
      super(var1, var2);
      this.field6500 = var3;
      this.field6501 = var4;
   }

   @Override
   public void method5760(MatrixStack var1) {
      this.blit(var1, this.x + 2, this.y + 2, this.field6500, this.field6501, 18, 18);
   }
}
