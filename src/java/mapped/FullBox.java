package mapped;

import java.io.IOException;

public class FullBox extends Class5041 {
   private static String[] field22849;
   public int field22850;
   public int field22851;

   public FullBox(String var1) {
      super(var1);
   }

   @Override
   public void method15262(MP4InputStream var1) throws IOException {
      this.field22850 = var1.readInt();
      this.field22851 = (int)var1.readBits(3);
   }
}
