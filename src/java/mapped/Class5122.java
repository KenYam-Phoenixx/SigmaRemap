package mapped;

import com.google.common.collect.Sets;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.SectionPos;

import java.util.Set;

public class Class5122 implements Class5119 {
   private static String[] field23299;
   private final Set<SectionPos> field23300 = Sets.newHashSet();

   @Override
   public void method15814() {
      this.field23300.clear();
   }

   public void method15817(SectionPos var1) {
      this.field23300.add(var1);
   }

   public void method15818(SectionPos var1) {
      this.field23300.remove(var1);
   }

   @Override
   public void method15813(MatrixStack var1, IRenderTypeBuffer var2, double var3, double var5, double var7) {
      RenderSystem.pushMatrix();
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.disableTexture();
      this.method15819(var3, var5, var7);
      RenderSystem.enableTexture();
      RenderSystem.disableBlend();
      RenderSystem.popMatrix();
   }

   private void method15819(double var1, double var3, double var5) {
      BlockPos var9 = new BlockPos(var1, var3, var5);
      this.field23300.forEach(var1x -> {
         if (var9.withinDistance(var1x.method8422(), 60.0)) {
            method15820(var1x);
         }
      });
   }

   private static void method15820(SectionPos var0) {
      float var3 = 1.0F;
      BlockPos var4 = var0.method8422();
      BlockPos var5 = var4.method8335(-1.0, -1.0, -1.0);
      BlockPos var6 = var4.method8335(1.0, 1.0, 1.0);
      DebugRenderer.method27455(var5, var6, 0.2F, 1.0F, 0.2F, 0.15F);
   }
}
