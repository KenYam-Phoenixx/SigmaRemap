package mapped;

import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Vector3f;

public class Class5427 extends Class5424 {
   private static String[] field24143;
   private final IVertexBuilder field24144;
   private final Matrix4f field24145;
   private final Matrix3f field24146;
   private float field24147;
   private float field24148;
   private float field24149;
   private int field24150;
   private int field24151;
   private int field24152;
   private float field24153;
   private float field24154;
   private float field24155;

   public Class5427(IVertexBuilder var1, Matrix4f var2, Matrix3f var3) {
      this.field24144 = var1;
      this.field24145 = var2.method35514();
      this.field24145.method35507();
      this.field24146 = var3.method32831();
      this.field24146.method32826();
      this.method17095();
   }

   private void method17095() {
      this.field24147 = 0.0F;
      this.field24148 = 0.0F;
      this.field24149 = 0.0F;
      this.field24150 = 0;
      this.field24151 = 10;
      this.field24152 = 15728880;
      this.field24153 = 0.0F;
      this.field24154 = 1.0F;
      this.field24155 = 0.0F;
   }

   @Override
   public void endVertex() {
      Vector3f var3 = new Vector3f(this.field24153, this.field24154, this.field24155);
      var3.method25282(this.field24146);
      Direction var4 = Direction.getFacingFromVector(var3.method25269(), var3.method25270(), var3.method25271());
      Class7755 var5 = new Class7755(this.field24147, this.field24148, this.field24149, 1.0F);
      var5.method25709(this.field24145);
      var5.method25710(Vector3f.YP.rotationDegrees(180.0F));
      var5.method25710(Vector3f.XP.rotationDegrees(-90.0F));
      var5.method25710(var4.method532());
      float var6 = -var5.method25701();
      float var7 = -var5.method25702();
      this.field24144
         .pos((double)this.field24147, (double)this.field24148, (double)this.field24149)
         .color(1.0F, 1.0F, 1.0F, 1.0F)
         .tex(var6, var7)
         .method17028(this.field24150, this.field24151)
         .method17034(this.field24152)
         .method17030(this.field24153, this.field24154, this.field24155)
         .endVertex();
      this.method17095();
   }

   @Override
   public IVertexBuilder pos(double var1, double var3, double var5) {
      this.field24147 = (float)var1;
      this.field24148 = (float)var3;
      this.field24149 = (float)var5;
      return this;
   }

   @Override
   public IVertexBuilder color(int var1, int var2, int var3, int var4) {
      return this;
   }

   @Override
   public IVertexBuilder tex(float var1, float var2) {
      return this;
   }

   @Override
   public IVertexBuilder method17028(int var1, int var2) {
      this.field24150 = var1;
      this.field24151 = var2;
      return this;
   }

   @Override
   public IVertexBuilder method17029(int var1, int var2) {
      this.field24152 = var1 | var2 << 16;
      return this;
   }

   @Override
   public IVertexBuilder method17030(float var1, float var2, float var3) {
      this.field24153 = var1;
      this.field24154 = var2;
      this.field24155 = var3;
      return this;
   }
}
