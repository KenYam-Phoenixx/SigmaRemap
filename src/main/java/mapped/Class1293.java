package mapped;

import net.minecraft.client.Minecraft;

public abstract class Class1293<E extends Class1178<E>> extends Class1273<E> {
   public Class1293(Minecraft var1, int var2, int var3, int var4, int var5, int var6) {
      super(var1, var2, var3, var4, var5, var6);
   }

   @Override
   public boolean changeFocus(boolean var1) {
      boolean var4 = super.changeFocus(var1);
      if (var4) {
         this.method6042(this.getListener());
      }

      return var4;
   }

   @Override
   public boolean method6032(int var1) {
      return false;
   }
}
