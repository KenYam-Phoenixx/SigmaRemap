package mapped;

public class Class981 extends Class927 {
   private static String[] field5458;
   public final Class5836 field5459;

   public Class981(Class5836 var1, int var2) {
      super(var2);
      this.field5459 = var1;
   }

   @Override
   public void markDirty() {
      this.field5459.onCraftMatrixChanged(this);
      super.markDirty();
   }
}
