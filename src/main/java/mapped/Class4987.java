package mapped;

import java.io.IOException;

public class Class4987 extends FullBox {
   private long field22884;
   private long field22885;
   private long field22886;
   private long field22887;
   private int field22888;
   private int field22889;
   private int field22890;
   private int field22891;
   private int field22892;

   public Class4987() {
      super("Apple Lossless Box");
   }

   @Override
   public void method15262(MP4InputStream var1) throws IOException {
      super.method15262(var1);
      this.field22884 = var1.readBits(4);
      var1.skipBytes(1L);
      this.field22888 = var1.readInt();
      this.field22889 = var1.readInt();
      this.field22890 = var1.readInt();
      this.field22891 = var1.readInt();
      this.field22892 = var1.readInt();
      var1.skipBytes(2L);
      this.field22885 = var1.readBits(4);
      this.field22886 = var1.readBits(4);
      this.field22887 = var1.readBits(4);
   }

   public long method15299() {
      return this.field22884;
   }

   public int method15300() {
      return this.field22888;
   }

   public int method15301() {
      return this.field22889;
   }

   public int method15302() {
      return this.field22890;
   }

   public int method15303() {
      return this.field22891;
   }

   public int method15304() {
      return this.field22892;
   }

   public long method15305() {
      return this.field22885;
   }

   public long method15306() {
      return this.field22886;
   }

   public long method15307() {
      return this.field22887;
   }
}
