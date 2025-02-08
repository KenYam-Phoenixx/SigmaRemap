package mapped;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.Util;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

import java.util.Locale;
import java.util.Map;

public class Class5135 implements Class5119 {
   private final Map<Integer, Class8238> field23341 = Maps.newHashMap();
   private final Map<Integer, Float> field23342 = Maps.newHashMap();
   private final Map<Integer, Long> field23343 = Maps.newHashMap();

   public void method15902(int var1, Class8238 var2, float var3) {
      this.field23341.put(var1, var2);
      this.field23343.put(var1, Util.milliTime());
      this.field23342.put(var1, var3);
   }

   @Override
   public void method15813(MatrixStack var1, IRenderTypeBuffer var2, double var3, double var5, double var7) {
      if (!this.field23341.isEmpty()) {
         long var11 = Util.milliTime();

         for (Integer var14 : this.field23341.keySet()) {
            Class8238 var15 = this.field23341.get(var14);
            float var16 = this.field23342.get(var14);
            method15903(var15, var16, true, true, var3, var5, var7);
         }

         for (Integer var20 : this.field23343.keySet().<Integer>toArray(new Integer[0])) {
            if (var11 - this.field23343.get(var20) > 5000L) {
               this.field23341.remove(var20);
               this.field23343.remove(var20);
            }
         }
      }
   }

   public static void method15903(Class8238 var0, float var1, boolean var2, boolean var3, double var4, double var6, double var8) {
      RenderSystem.pushMatrix();
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.color4f(0.0F, 1.0F, 0.0F, 0.75F);
      RenderSystem.disableTexture();
      RenderSystem.lineWidth(6.0F);
      method15904(var0, var1, var2, var3, var4, var6, var8);
      RenderSystem.enableTexture();
      RenderSystem.disableBlend();
      RenderSystem.popMatrix();
   }

   private static void method15904(Class8238 var0, float var1, boolean var2, boolean var3, double var4, double var6, double var8) {
      method15905(var0, var4, var6, var8);
      BlockPos var12 = var0.method28712();
      if (method15906(var12, var4, var6, var8) <= 80.0F) {
         DebugRenderer.method27457(
            new AxisAlignedBB(
                  (double)((float)var12.getX() + 0.25F),
                  (double)((float)var12.getY() + 0.25F),
                  (double)var12.getZ() + 0.25,
                  (double)((float)var12.getX() + 0.75F),
                  (double)((float)var12.getY() + 0.75F),
                  (double)((float)var12.getZ() + 0.75F)
               )
               .offset(-var4, -var6, -var8),
            0.0F,
            1.0F,
            0.0F,
            0.5F
         );

         for (int var13 = 0; var13 < var0.method28698(); var13++) {
            Class7176 var14 = var0.method28695(var13);
            if (method15906(var14.method22531(), var4, var6, var8) <= 80.0F) {
               float var15 = var13 != var0.method28699() ? 0.0F : 1.0F;
               float var16 = var13 != var0.method28699() ? 1.0F : 0.0F;
               DebugRenderer.method27457(
                  new AxisAlignedBB(
                        (double)((float)var14.field30847 + 0.5F - var1),
                        (double)((float)var14.field30848 + 0.01F * (float)var13),
                        (double)((float)var14.field30849 + 0.5F - var1),
                        (double)((float)var14.field30847 + 0.5F + var1),
                        (double)((float)var14.field30848 + 0.25F + 0.01F * (float)var13),
                        (double)((float)var14.field30849 + 0.5F + var1)
                     )
                     .offset(-var4, -var6, -var8),
                  var15,
                  0.0F,
                  var16,
                  0.5F
               );
            }
         }
      }

      if (var2) {
         for (Class7176 var25 : var0.method28710()) {
            if (method15906(var25.method22531(), var4, var6, var8) <= 80.0F) {
               DebugRenderer.method27457(
                  new AxisAlignedBB(
                        (double)((float)var25.field30847 + 0.5F - var1 / 2.0F),
                        (double)((float)var25.field30848 + 0.01F),
                        (double)((float)var25.field30849 + 0.5F - var1 / 2.0F),
                        (double)((float)var25.field30847 + 0.5F + var1 / 2.0F),
                        (double)var25.field30848 + 0.1,
                        (double)((float)var25.field30849 + 0.5F + var1 / 2.0F)
                     )
                     .offset(-var4, -var6, -var8),
                  1.0F,
                  0.8F,
                  0.8F,
                  0.5F
               );
            }
         }

         for (Class7176 var26 : var0.method28709()) {
            if (method15906(var26.method22531(), var4, var6, var8) <= 80.0F) {
               DebugRenderer.method27457(
                  new AxisAlignedBB(
                        (double)((float)var26.field30847 + 0.5F - var1 / 2.0F),
                        (double)((float)var26.field30848 + 0.01F),
                        (double)((float)var26.field30849 + 0.5F - var1 / 2.0F),
                        (double)((float)var26.field30847 + 0.5F + var1 / 2.0F),
                        (double)var26.field30848 + 0.1,
                        (double)((float)var26.field30849 + 0.5F + var1 / 2.0F)
                     )
                     .offset(-var4, -var6, -var8),
                  0.8F,
                  1.0F,
                  1.0F,
                  0.5F
               );
            }
         }
      }

      if (var3) {
         for (int var19 = 0; var19 < var0.method28698(); var19++) {
            Class7176 var22 = var0.method28695(var19);
            if (method15906(var22.method22531(), var4, var6, var8) <= 80.0F) {
               DebugRenderer.method27462(
                  String.format("%s", var22.field30859),
                  (double)var22.field30847 + 0.5,
                  (double)var22.field30848 + 0.75,
                  (double)var22.field30849 + 0.5,
                  -1,
                  0.02F,
                  true,
                  0.0F,
                  true
               );
               DebugRenderer.method27462(
                  String.format(Locale.ROOT, "%.2f", var22.field30858),
                  (double)var22.field30847 + 0.5,
                  (double)var22.field30848 + 0.25,
                  (double)var22.field30849 + 0.5,
                  -1,
                  0.02F,
                  true,
                  0.0F,
                  true
               );
            }
         }
      }
   }

   public static void method15905(Class8238 var0, double var1, double var3, double var5) {
      Tessellator var9 = Tessellator.getInstance();
      BufferBuilder var10 = var9.getBuffer();
      var10.begin(3, DefaultVertexFormats.POSITION_COLOR);

      for (int var11 = 0; var11 < var0.method28698(); var11++) {
         Class7176 var12 = var0.method28695(var11);
         if (!(method15906(var12.method22531(), var1, var3, var5) > 80.0F)) {
            float var13 = (float)var11 / (float)var0.method28698() * 0.33F;
            int var14 = var11 != 0 ? MathHelper.method37818(var13, 0.9F, 0.9F) : 0;
            int var15 = var14 >> 16 & 0xFF;
            int var16 = var14 >> 8 & 0xFF;
            int var17 = var14 & 0xFF;
            var10.pos((double)var12.field30847 - var1 + 0.5, (double)var12.field30848 - var3 + 0.5, (double)var12.field30849 - var5 + 0.5)
               .color(var15, var16, var17, 255)
               .endVertex();
         }
      }

      var9.draw();
   }

   private static float method15906(BlockPos var0, double var1, double var3, double var5) {
      return (float)(Math.abs((double)var0.getX() - var1) + Math.abs((double)var0.getY() - var3) + Math.abs((double)var0.getZ() - var5));
   }
}
