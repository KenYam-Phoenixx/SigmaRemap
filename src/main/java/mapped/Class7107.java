package mapped;

import net.optifine.reflect.IFieldLocator;

import java.lang.reflect.Field;

public class Class7107 implements IFieldLocator {
   private static String[] field30623;
   private Field field30624;

   public Class7107(Field var1) {
      this.field30624 = var1;
   }

   @Override
   public Field method22145() {
      return this.field30624;
   }
}
