package mapped;

public class Class5129 implements Class5119 {
   private static String[] field23318;
   private final Minecraft field23319;

   public Class5129(Minecraft var1) {
      this.field23319 = var1;
   }

   @Override
   public void method15813(MatrixStack var1, Class7733 var2, double var3, double var5, double var7) {
      BlockPos var11 = this.field23319.player.getPosition();
      World var12 = this.field23319.player.world;
      RenderSystem.enableBlend();
      RenderSystem.method27938();
      RenderSystem.method27889(0.0F, 1.0F, 0.0F, 0.75F);
      RenderSystem.disableTexture();
      RenderSystem.lineWidth(6.0F);

      for (BlockPos var14 : BlockPos.method8359(var11.method8336(-10, -10, -10), var11.method8336(10, 10, 10))) {
         Class7379 var15 = var12.method6739(var14);
         if (var15.method23486(Class8953.field40469)) {
            double var16 = (double)((float)var14.getY() + var15.method23475(var12, var14));
            DebugRenderer.method27457(
               new AxisAlignedBB(
                     (double)((float)var14.getX() + 0.01F),
                     (double)((float)var14.getY() + 0.01F),
                     (double)((float)var14.getZ() + 0.01F),
                     (double)((float)var14.getX() + 0.99F),
                     var16,
                     (double)((float)var14.getZ() + 0.99F)
                  )
                  .method19667(-var3, -var5, -var7),
               1.0F,
               1.0F,
               1.0F,
               0.2F
            );
         }
      }

      for (BlockPos var19 : BlockPos.method8359(var11.method8336(-10, -10, -10), var11.method8336(10, 10, 10))) {
         Class7379 var20 = var12.method6739(var19);
         if (var20.method23486(Class8953.field40469)) {
            DebugRenderer.method27460(
               String.valueOf(var20.method23477()),
               (double)var19.getX() + 0.5,
               (double)((float)var19.getY() + var20.method23475(var12, var19)),
               (double)var19.getZ() + 0.5,
               -16777216
            );
         }
      }

      RenderSystem.enableTexture();
      RenderSystem.disableBlend();
   }
}
