package mapped;

public final class Class6170 {
   private static String[] field27601;
   private static final long field27602 = 4294967295L;

   public static String method19068(long var0) {
      char[] var4 = new char[]{(char)((int)((var0 >> 10 & 31L) + 96L)), (char)((int)((var0 >> 5 & 31L) + 96L)), (char)((int)((var0 & 31L) + 96L))};
      return new String(var4);
   }

   public static long method19069(long var0) {
      long var4;
      if (var0 != 4294967295L) {
         var4 = var0;
      } else {
         var4 = -1L;
      }

      return var4;
   }
}
