package mapped;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class Class2001 extends BlockPos {
   private int field13042;
   private int field13043;
   private int field13044;
   private int field13045;
   private Class2001[] field13046;
   private boolean field13047;

   public Class2001() {
      this(0, 0, 0, 0);
   }

   public Class2001(int var1, int var2, int var3) {
      this(var1, var2, var3, 0);
   }

   public Class2001(double var1, double var3, double var5) {
      this(MathHelper.floor(var1), MathHelper.floor(var3), MathHelper.floor(var5));
   }

   public Class2001(int var1, int var2, int var3, int var4) {
      super(0, 0, 0);
      this.field13042 = var1;
      this.field13043 = var2;
      this.field13044 = var3;
      this.field13045 = var4;
   }

   @Override
   public int getX() {
      return this.field13042;
   }

   @Override
   public int getY() {
      return this.field13043;
   }

   @Override
   public int getZ() {
      return this.field13044;
   }

   public void method8384(int var1, int var2, int var3) {
      this.field13042 = var1;
      this.field13043 = var2;
      this.field13044 = var3;
      this.field13047 = true;
   }

   public void method8385(double var1, double var3, double var5) {
      this.method8384(MathHelper.floor(var1), MathHelper.floor(var3), MathHelper.floor(var5));
   }

   @Override
   public BlockPos offset(Direction var1) {
      if (this.field13045 > 0) {
         if (this.field13046 == null) {
            this.field13046 = new Class2001[Direction.VALUES.length];
         }

         if (this.field13047) {
            this.method8388();
         }

         int var4 = var1.getIndex();
         Class2001 var5 = this.field13046[var4];
         if (var5 == null) {
            int var6 = this.field13042 + var1.getXOffset();
            int var7 = this.field13043 + var1.getYOffset();
            int var8 = this.field13044 + var1.getZOffset();
            var5 = new Class2001(var6, var7, var8, this.field13045 - 1);
            this.field13046[var4] = var5;
         }

         return var5;
      } else {
         return super.method8350(var1, 1).toImmutable();
      }
   }

   @Override
   public BlockPos method8350(Direction var1, int var2) {
      return var2 != 1 ? super.method8350(var1, var2).toImmutable() : this.offset(var1);
   }

   public void method8386(BlockPos var1, Direction var2) {
      this.field13042 = var1.getX() + var2.getXOffset();
      this.field13043 = var1.getY() + var2.getYOffset();
      this.field13044 = var1.getZ() + var2.getZOffset();
   }

   public void method8387(BlockPos var1, Direction var2, Direction var3) {
      this.field13042 = var1.getX() + var2.getXOffset() + var3.getXOffset();
      this.field13043 = var1.getY() + var2.getYOffset() + var3.getYOffset();
      this.field13044 = var1.getZ() + var2.getZOffset() + var3.getZOffset();
   }

   private void method8388() {
      for (int var3 = 0; var3 < 6; var3++) {
         Class2001 var4 = this.field13046[var3];
         if (var4 != null) {
            Direction var5 = Direction.VALUES[var3];
            int var6 = this.field13042 + var5.getXOffset();
            int var7 = this.field13043 + var5.getYOffset();
            int var8 = this.field13044 + var5.getZOffset();
            var4.method8384(var6, var7, var8);
         }
      }

      this.field13047 = false;
   }

   @Override
   public BlockPos toImmutable() {
      return new BlockPos(this.field13042, this.field13043, this.field13044);
   }

   public static Iterable<BlockPos> method8359(BlockPos var0, BlockPos var1) {
      BlockPos var4 = new BlockPos(
         Math.min(var0.getX(), var1.getX()), Math.min(var0.getY(), var1.getY()), Math.min(var0.getZ(), var1.getZ())
      );
      BlockPos var5 = new BlockPos(
         Math.max(var0.getX(), var1.getX()), Math.max(var0.getY(), var1.getY()), Math.max(var0.getZ(), var1.getZ())
      );
      return new Class50(var4, var5);
   }
}
