package mapped;

import java.io.IOException;

public class Class4986 extends FullBox {
   private int[] field22879;
   private int[] field22880;
   private long[] field22881;
   private long[][] field22882;
   private long[][] field22883;

   public Class4986() {
      super("Item Location Box");
   }

   @Override
   public void method15262(MP4InputStream var1) throws IOException {
      super.method15262(var1);
      long var4 = var1.readBits(2);
      int var6 = (int)(var4 >> 12) & 15;
      int var7 = (int)(var4 >> 8) & 15;
      int var8 = (int)(var4 >> 4) & 15;
      int var9 = (int)var1.readBits(2);
      this.field22880 = new int[var9];
      this.field22881 = new long[var9];
      this.field22882 = new long[var9][];
      this.field22883 = new long[var9][];

      for (int var10 = 0; var10 < var9; var10++) {
         this.field22879[var10] = (int)var1.readBits(2);
         this.field22880[var10] = (int)var1.readBits(2);
         this.field22881[var10] = var1.readBits(var8);
         int var11 = (int)var1.readBits(2);
         this.field22882[var10] = new long[var11];
         this.field22883[var10] = new long[var11];

         for (int var12 = 0; var12 < var11; var12++) {
            this.field22882[var10][var12] = var1.readBits(var6);
            this.field22883[var10][var12] = var1.readBits(var7);
         }
      }
   }

   public int[] method15294() {
      return this.field22879;
   }

   public int[] method15295() {
      return this.field22880;
   }

   public long[] method15296() {
      return this.field22881;
   }

   public long[][] method15297() {
      return this.field22882;
   }

   public long[][] method15298() {
      return this.field22883;
   }
}
