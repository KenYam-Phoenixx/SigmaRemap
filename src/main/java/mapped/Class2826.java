package mapped;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.Entity;

public class Class2826<T extends Entity> extends Class2803<T> {
   private static String[] field17595;
   private final ModelRenderer field17596;
   private final ModelRenderer field17597;
   private final ModelRenderer field17598;
   private final ModelRenderer field17599;

   public Class2826(int var1) {
      this.field17596 = new ModelRenderer(this, 0, var1);
      this.field17597 = new ModelRenderer(this, 32, 0);
      this.field17598 = new ModelRenderer(this, 32, 4);
      this.field17599 = new ModelRenderer(this, 32, 8);
      if (var1 <= 0) {
         this.field17596.method22673(-4.0F, 16.0F, -4.0F, 8.0F, 8.0F, 8.0F);
      } else {
         this.field17596.method22673(-3.0F, 17.0F, -3.0F, 6.0F, 6.0F, 6.0F);
         this.field17597.method22673(-3.25F, 18.0F, -3.5F, 2.0F, 2.0F, 2.0F);
         this.field17598.method22673(1.25F, 18.0F, -3.5F, 2.0F, 2.0F, 2.0F);
         this.field17599.method22673(0.0F, 21.0F, -3.5F, 1.0F, 1.0F, 1.0F);
      }
   }

   @Override
   public void setRotationAngles(T var1, float var2, float var3, float var4, float var5, float var6) {
   }

   @Override
   public Iterable<ModelRenderer> method11015() {
      return ImmutableList.of(this.field17596, this.field17597, this.field17598, this.field17599);
   }
}
