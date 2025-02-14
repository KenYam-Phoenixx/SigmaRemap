package mapped;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.SectionPos;
import net.minecraft.world.LightType;

public class Class5124 implements Class5119 {
   private static String[] field23304;
   private final Minecraft field23305;

   public Class5124(Minecraft var1) {
      this.field23305 = var1;
   }

   @Override
   public void method15813(MatrixStack var1, IRenderTypeBuffer var2, double var3, double var5, double var7) {
      ClientWorld var11 = this.field23305.world;
      RenderSystem.pushMatrix();
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.disableTexture();
      BlockPos var12 = new BlockPos(var3, var5, var7);
      LongOpenHashSet var13 = new LongOpenHashSet();

      for (BlockPos var15 : BlockPos.method8359(var12.add(-10, -10, -10), var12.add(10, 10, 10))) {
         int var16 = var11.getLightFor(LightType.SKY, var15);
         float var17 = (float)(15 - var16) / 15.0F * 0.5F + 0.16F;
         int var18 = MathHelper.method37818(var17, 0.9F, 0.9F);
         long var19 = SectionPos.worldToSection(var15.toLong());
         if (var13.add(var19)) {
            DebugRenderer.method27461(
               var11.getChunkProvider().getLightManager().method639(LightType.SKY, SectionPos.from(var19)),
               (double)(SectionPos.extractX(var19) * 16 + 8),
               (double)(SectionPos.extractY(var19) * 16 + 8),
               (double)(SectionPos.extractZ(var19) * 16 + 8),
               16711680,
               0.3F
            );
         }

         if (var16 != 15) {
            DebugRenderer.method27460(
               String.valueOf(var16), (double)var15.getX() + 0.5, (double)var15.getY() + 0.25, (double)var15.getZ() + 0.5, var18
            );
         }
      }

      RenderSystem.enableTexture();
      RenderSystem.popMatrix();
   }
}
