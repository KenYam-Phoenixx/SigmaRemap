package mapped;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.Entity;

public class Class2884<T extends Entity> extends Class2803<T> {
   private static String[] field17874;
   private final Class7219 field17875 = new Class7219(this);

   public Class2884() {
      this(0.0F);
   }

   public Class2884(float var1) {
      byte var4 = 2;
      this.field17875.method22671(0, 0).method22675(-4.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, var1);
      this.field17875.method22671(0, 0).method22675(0.0F, -4.0F, 0.0F, 2.0F, 2.0F, 2.0F, var1);
      this.field17875.method22671(0, 0).method22675(0.0F, 0.0F, -4.0F, 2.0F, 2.0F, 2.0F, var1);
      this.field17875.method22671(0, 0).method22675(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, var1);
      this.field17875.method22671(0, 0).method22675(2.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, var1);
      this.field17875.method22671(0, 0).method22675(0.0F, 2.0F, 0.0F, 2.0F, 2.0F, 2.0F, var1);
      this.field17875.method22671(0, 0).method22675(0.0F, 0.0F, 2.0F, 2.0F, 2.0F, 2.0F, var1);
      this.field17875.method22679(0.0F, 0.0F, 0.0F);
   }

   @Override
   public void method10998(T var1, float var2, float var3, float var4, float var5, float var6) {
   }

   @Override
   public Iterable<Class7219> method11015() {
      return ImmutableList.of(this.field17875);
   }
}
