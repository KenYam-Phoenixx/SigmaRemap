package mapped;

import com.mojang.blaze3d.platform.GlStateManager;

// $VF: synthetic class
public class Class9579 {
   private static String[] field44780;
   public static final int[] field44781;
   public static final int[] field44782;
   public static final int[] field44783 = new int[GlStateManager.TexGen.values().length];

   static {
      try {
         field44783[GlStateManager.TexGen.S.ordinal()] = 1;
      } catch (NoSuchFieldError var12) {
      }

      try {
         field44783[GlStateManager.TexGen.T.ordinal()] = 2;
      } catch (NoSuchFieldError var11) {
      }

      try {
         field44783[GlStateManager.TexGen.R.ordinal()] = 3;
      } catch (NoSuchFieldError var10) {
      }

      try {
         field44783[GlStateManager.TexGen.Q.ordinal()] = 4;
      } catch (NoSuchFieldError var9) {
      }

      field44782 = new int[GlStateManager.SupportType.values().length];

      try {
         field44782[GlStateManager.SupportType.BASE.ordinal()] = 1;
      } catch (NoSuchFieldError var8) {
      }

      try {
         field44782[GlStateManager.SupportType.EXT.ordinal()] = 2;
      } catch (NoSuchFieldError var7) {
      }

      try {
         field44782[GlStateManager.SupportType.NONE.ordinal()] = 3;
      } catch (NoSuchFieldError var6) {
      }

      field44781 = new int[GlStateManager.FramebufferExtension.values().length];

      try {
         field44781[GlStateManager.FramebufferExtension.BASE.ordinal()] = 1;
      } catch (NoSuchFieldError var5) {
      }

      try {
         field44781[GlStateManager.FramebufferExtension.ARB.ordinal()] = 2;
      } catch (NoSuchFieldError var4) {
      }

      try {
         field44781[GlStateManager.FramebufferExtension.EXT.ordinal()] = 3;
      } catch (NoSuchFieldError var3) {
      }
   }
}
