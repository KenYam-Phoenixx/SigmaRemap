package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;

import java.util.Arrays;
import java.util.List;

public class Class1292 extends Class1286<Class1160> {
   public final RealmsScreenReal field6856;

   public Class1292(RealmsScreenReal var1) {
      super(var1.width, var1.height, 32, var1.height - 40, 36);
      this.field6856 = var1;
   }

   public void method6123(int var1) {
      this.method6058(var1);
   }

   @Override
   public int method6036() {
      return this.method6031() * 36;
   }

   @Override
   public int method6022() {
      return 260;
   }

   @Override
   public boolean method6057() {
      return this.field6856.getListener() == this;
   }

   @Override
   public void method6039(MatrixStack var1) {
      this.field6856.renderBackground(var1);
   }

   @Override
   public void method6109(int var1) {
      this.method6108(var1);
      if (var1 != -1) {
         List var4 = RealmsScreenReal.method2390(this.field6856).getEventListeners();
         Class6110 var5 = Class1160.method5558((Class1160)var4.get(var1));
         String var6 = I18n.format("narrator.select.list.position", var1 + 1, var4.size());
         String var7 = Class9229.method34715(Arrays.<String>asList(var5.field27371, var5.field27372, Class9740.method38174(var5.field27374), var6));
         Class9229.method34711(I18n.format("narrator.select", var7));
      }

      this.method6124(var1);
   }

   public void method6124(int var1) {
      RealmsScreenReal.method2406(this.field6856, var1);
      RealmsScreenReal.method2407(this.field6856);
   }

   public void method6024(Class1160 var1) {
      super.method6024(var1);
      RealmsScreenReal.method2406(this.field6856, this.getEventListeners().indexOf(var1));
      RealmsScreenReal.method2407(this.field6856);
   }
}
