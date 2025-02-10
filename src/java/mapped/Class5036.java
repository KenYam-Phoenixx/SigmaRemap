package mapped;

import java.awt.Color;
import java.io.IOException;

public class Class5036 extends FullBox {
   private long field23012;
   private Color field23013;

   public Class5036() {
      super("Video Media Header Box");
   }

   @Override
   public void method15262(MP4InputStream var1) throws IOException {
      super.method15262(var1);
      this.field23012 = var1.readBits(2);
      int[] var4 = new int[3];

      for (int var5 = 0; var5 < 3; var5++) {
         var4[var5] = var1.readInt() & 0xFF | var1.readInt() << 8 & 0xFF;
      }

      this.field23013 = new Color(var4[0], var4[1], var4[2]);
   }

   public long method15414() {
      return this.field23012;
   }

   public Color method15415() {
      return this.field23013;
   }
}
