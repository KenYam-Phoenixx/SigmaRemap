package mapped;

import java.io.IOException;

public class Class5085 extends FullBox {
   private long field23143;
   private long[] field23144;
   private long[] field23145;

   public Class5085() {
      super("Sample To Group Box");
   }

   @Override
   public void method15262(MP4InputStream var1) throws IOException {
      super.method15262(var1);
      this.field23143 = var1.readBits(4);
      int var4 = (int)var1.readBits(4);
      this.field23144 = new long[var4];
      this.field23145 = new long[var4];

      for (int var5 = 0; var5 < var4; var5++) {
         this.field23144[var5] = var1.readBits(4);
         this.field23145[var5] = var1.readBits(4);
      }
   }

   public long method15541() {
      return this.field23143;
   }

   public long[] method15542() {
      return this.field23144;
   }

   public long[] method15543() {
      return this.field23145;
   }
}
