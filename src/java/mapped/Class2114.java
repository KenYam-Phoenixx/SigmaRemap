package mapped;

import java.util.function.Supplier;

public enum Class2114 implements Class2115 {
   field13773("leather", 5, new int[]{1, 2, 3, 1}, 15, Sounds.field26354, 0.0F, 0.0F, () -> Class120.method339(Items.field37890)),
   field13774("chainmail", 15, new int[]{1, 4, 5, 2}, 12, Sounds.field26348, 0.0F, 0.0F, () -> Class120.method339(Items.field37801)),
   field13775("iron", 15, new int[]{2, 5, 6, 2}, 9, Sounds.field26353, 0.0F, 0.0F, () -> Class120.method339(Items.field37801)),
   field13776("gold", 7, new int[]{1, 3, 5, 2}, 25, Sounds.field26352, 0.0F, 0.0F, () -> Class120.method339(Items.field37802)),
   field13777("diamond", 33, new int[]{3, 6, 8, 3}, 10, Sounds.field26349, 2.0F, 0.0F, () -> Class120.method339(Items.field37800)),
   field13778("turtle", 25, new int[]{2, 5, 6, 2}, 9, Sounds.field26356, 0.0F, 0.0F, () -> Class120.method339(Items.field37793)),
   field13779("netherite", 37, new int[]{3, 6, 8, 3}, 15, Sounds.field26355, 3.0F, 0.1F, () -> Class120.method339(Items.field37803));

   private static final int[] field13780 = new int[]{13, 15, 16, 11};
   private final String field13781;
   private final int field13782;
   private final int[] field13783;
   private final int field13784;
   private final Class9455 field13785;
   private final float field13786;
   private final float field13787;
   private final Class8112<Class120> field13788;
   private static final Class2114[] field13789 = new Class2114[]{field13773, field13774, field13775, field13776, field13777, field13778, field13779};

   private Class2114(String var3, int var4, int[] var5, int var6, Class9455 var7, float var8, float var9, Supplier<Class120> var10) {
      this.field13781 = var3;
      this.field13782 = var4;
      this.field13783 = var5;
      this.field13784 = var6;
      this.field13785 = var7;
      this.field13786 = var8;
      this.field13787 = var9;
      this.field13788 = new Class8112<Class120>(var10);
   }

   @Override
   public int method8785(Class2106 var1) {
      return field13780[var1.method8773()] * this.field13782;
   }

   @Override
   public int method8786(Class2106 var1) {
      return this.field13783[var1.method8773()];
   }

   @Override
   public int method8787() {
      return this.field13784;
   }

   @Override
   public Class9455 method8788() {
      return this.field13785;
   }

   @Override
   public Class120 method8789() {
      return this.field13788.method28097();
   }

   @Override
   public String method8790() {
      return this.field13781;
   }

   @Override
   public float method8791() {
      return this.field13786;
   }

   @Override
   public float method8792() {
      return this.field13787;
   }
}
