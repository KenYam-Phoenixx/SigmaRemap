package net.minecraft.client.shader;

import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import mapped.BufferBuilder;
import mapped.Tessellator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.optifine.reflect.ReflectorForge;

import java.nio.IntBuffer;

public class Framebuffer {
   public int framebufferTextureWidth;
   public int framebufferTextureHeight;
   public int framebufferWidth;
   public int framebufferHeight;
   public final boolean useDepth;
   public int framebufferObject;
   private int framebufferTexture;
   public int depthBuffer;
   public final float[] framebufferColor;
   public int framebufferFilter;
   private boolean stencilEnabled = false;

   public Framebuffer(int var1, int var2, boolean var3, boolean var4) {
      RenderSystem.assertThread(RenderSystem::isOnRenderThreadOrInit);
      this.useDepth = var3;
      this.framebufferObject = -1;
      this.framebufferTexture = -1;
      this.depthBuffer = -1;
      this.framebufferColor = new float[4];
      this.framebufferColor[0] = 1.0F;
      this.framebufferColor[1] = 1.0F;
      this.framebufferColor[2] = 1.0F;
      this.framebufferColor[3] = 0.0F;
      this.resize(var1, var2, var4);
   }

   public void resize(int var1, int var2, boolean var3) {
      if (RenderSystem.isOnRenderThread()) {
         this.resizeRaw(var1, var2, var3);
      } else {
         RenderSystem.recordRenderCall(() -> this.resizeRaw(var1, var2, var3));
      }
   }

   private void resizeRaw(int width, int height, boolean p_227586_3_) {
      RenderSystem.assertThread(RenderSystem::isOnRenderThreadOrInit);
      GlStateManager.enableDepthTest();

      if (this.framebufferObject >= 0)
      {
         this.deleteFramebuffer();
      }

      this.createBuffers(width, height, p_227586_3_);
      GlStateManager.bindFramebuffer(FramebufferConstants.GL_FRAMEBUFFER, 0);
   }

   public void deleteFramebuffer() {
      RenderSystem.assertThread(RenderSystem::isOnRenderThreadOrInit);
      this.unbindFramebufferTexture();
      this.unbindFramebuffer();

      if (this.depthBuffer > -1)
      {
         TextureUtil.releaseTextureId(this.depthBuffer);
         this.depthBuffer = -1;
      }

      if (this.framebufferTexture > -1)
      {
         TextureUtil.releaseTextureId(this.framebufferTexture);
         this.framebufferTexture = -1;
      }

      if (this.framebufferObject > -1)
      {
         GlStateManager.bindFramebuffer(FramebufferConstants.GL_FRAMEBUFFER, 0);
         GlStateManager.deleteFramebuffers(this.framebufferObject);
         this.framebufferObject = -1;
      }
   }

   public void func_237506_a_(Framebuffer p_237506_1_) {
      RenderSystem.assertThread(RenderSystem::isOnRenderThreadOrInit);

      if (GlStateManager.isFabulous())
      {
         GlStateManager.bindFramebuffer(36008, p_237506_1_.framebufferObject);
         GlStateManager.bindFramebuffer(36009, this.framebufferObject);
         GlStateManager.blitFramebuffer(0, 0, p_237506_1_.framebufferTextureWidth, p_237506_1_.framebufferTextureHeight, 0, 0, this.framebufferTextureWidth, this.framebufferTextureHeight, 256, 9728);
      }
      else
      {
         GlStateManager.bindFramebuffer(FramebufferConstants.GL_FRAMEBUFFER, this.framebufferObject);
         int i = GlStateManager.getFrameBufferAttachmentParam();

         if (i != 0)
         {
            int j = GlStateManager.getActiveTextureId();
            GlStateManager.bindTexture(i);
            GlStateManager.bindFramebuffer(FramebufferConstants.GL_FRAMEBUFFER, p_237506_1_.framebufferObject);
            GlStateManager.copySubImage(3553, 0, 0, 0, 0, 0, Math.min(this.framebufferTextureWidth, p_237506_1_.framebufferTextureWidth), Math.min(this.framebufferTextureHeight, p_237506_1_.framebufferTextureHeight));
            GlStateManager.bindTexture(j);
         }
      }

      GlStateManager.bindFramebuffer(FramebufferConstants.GL_FRAMEBUFFER, 0);
   }

   public void createBuffers(int p_216492_1_, int p_216492_2_, boolean p_216492_3_) {
      RenderSystem.assertThread(RenderSystem::isOnRenderThreadOrInit);
      this.framebufferWidth = p_216492_1_;
      this.framebufferHeight = p_216492_2_;
      this.framebufferTextureWidth = p_216492_1_;
      this.framebufferTextureHeight = p_216492_2_;

      if (!GLX.isUsingFBOs())
      {
         this.framebufferClear(p_216492_3_);
      }
      else
      {
          this.framebufferObject = GlStateManager.genFramebuffers();
         this.framebufferTexture = TextureUtil.generateTextureId();

         if (this.useDepth)
         {
            this.depthBuffer = TextureUtil.generateTextureId();
            GlStateManager.bindTexture(this.depthBuffer);
            GlStateManager.texParameter(3553, 10241, 9728);
            GlStateManager.texParameter(3553, 10240, 9728);
            GlStateManager.texParameter(3553, 10242, 10496);
            GlStateManager.texParameter(3553, 10243, 10496);
            GlStateManager.texParameter(3553, 34892, 0);

            if (this.stencilEnabled)
            {
               GlStateManager.texImage2D(3553, 0, 36013, this.framebufferTextureWidth, this.framebufferTextureHeight, 0, 34041, 36269, (IntBuffer)null);
            }
            else
            {
               GlStateManager.texImage2D(3553, 0, 6402, this.framebufferTextureWidth, this.framebufferTextureHeight, 0, 6402, 5126, (IntBuffer)null);
            }
         }

         this.setFramebufferFilter(9728);
         GlStateManager.bindTexture(this.framebufferTexture);
         GlStateManager.texImage2D(3553, 0, 32856, this.framebufferTextureWidth, this.framebufferTextureHeight, 0, 6408, 5121, (IntBuffer)null);
         GlStateManager.bindFramebuffer(FramebufferConstants.GL_FRAMEBUFFER, this.framebufferObject);
         GlStateManager.framebufferTexture2D(FramebufferConstants.GL_FRAMEBUFFER, FramebufferConstants.GL_COLOR_ATTACHMENT0, 3553, this.framebufferTexture, 0);

         if (this.useDepth)
         {
            if (this.stencilEnabled)
            {
               if (ReflectorForge.getForgeUseCombinedDepthStencilAttachment())
               {
                  GlStateManager.framebufferTexture2D(FramebufferConstants.GL_FRAMEBUFFER, 33306, 3553, this.depthBuffer, 0);
               }
               else
               {
                  GlStateManager.framebufferTexture2D(FramebufferConstants.GL_FRAMEBUFFER, 36096, 3553, this.depthBuffer, 0);
                  GlStateManager.framebufferTexture2D(FramebufferConstants.GL_FRAMEBUFFER, 36128, 3553, this.depthBuffer, 0);
               }
            }
            else
            {
               GlStateManager.framebufferTexture2D(FramebufferConstants.GL_FRAMEBUFFER, FramebufferConstants.GL_DEPTH_ATTACHMENT, 3553, this.depthBuffer, 0);
            }
         }

         this.checkFramebufferComplete();
         this.framebufferClear(p_216492_3_);
         this.unbindFramebufferTexture();
      }
   }

   public void setFramebufferFilter(int framebufferFilterIn) {
      RenderSystem.assertThread(RenderSystem::isOnRenderThreadOrInit);
      this.framebufferFilter = framebufferFilterIn;
      GlStateManager.bindTexture(this.framebufferTexture);
      GlStateManager.texParameter(3553, 10241, framebufferFilterIn);
      GlStateManager.texParameter(3553, 10240, framebufferFilterIn);
      GlStateManager.texParameter(3553, 10242, 10496);
      GlStateManager.texParameter(3553, 10243, 10496);
      GlStateManager.bindTexture(0);
   }

   public void checkFramebufferComplete() {
      RenderSystem.assertThread(RenderSystem::isOnRenderThreadOrInit);
      int i = GlStateManager.checkFramebufferStatus(FramebufferConstants.GL_FRAMEBUFFER);

      if (i != FramebufferConstants.GL_FRAMEBUFFER_COMPLETE)
      {
         if (i == FramebufferConstants.GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT)
         {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT");
         }
         else if (i == FramebufferConstants.GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT)
         {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT");
         }
         else if (i == FramebufferConstants.GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER)
         {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER");
         }
         else if (i == FramebufferConstants.GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER)
         {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER");
         }
         else
         {
            throw new RuntimeException("glCheckFramebufferStatus returned unknown status:" + i);
         }
      }
   }

   public void bindFramebufferTexture() {
      RenderSystem.assertThread(RenderSystem::isOnRenderThread);
      GlStateManager.bindTexture(this.framebufferTexture);
   }

   public void unbindFramebufferTexture() {
      RenderSystem.assertThread(RenderSystem::isOnRenderThreadOrInit);
      GlStateManager.bindTexture(0);
   }

   public void bindFramebuffer(boolean setViewportIn) {
      if (!RenderSystem.isOnRenderThread())
      {
         RenderSystem.recordRenderCall(() -> this.bindFramebufferRaw(setViewportIn));
      }
      else
      {
         this.bindFramebufferRaw(setViewportIn);
      }
   }

   private void bindFramebufferRaw(boolean setViewportIn) {
      RenderSystem.assertThread(RenderSystem::isOnRenderThreadOrInit);

      if (setViewportIn)
      {
         GlStateManager.viewport(0, 0, this.framebufferWidth, this.framebufferHeight);
      }

      if (framebufferObject != -1)
      {
         GlStateManager.bindFramebuffer(FramebufferConstants.GL_FRAMEBUFFER, this.framebufferObject);
      }
      else
      {
         Framebuffer framebuffer = Minecraft.getInstance().getFramebuffer();
         framebuffer.resizeCustom();
      }
   }

   public void resizeCustom() {
      if (!RenderSystem.isOnRenderThread())
      {
         RenderSystem.recordRenderCall(this::resizeRawCustom);
      }
      else
      {
         this.resizeRawCustom();
      }
   }

   private void resizeRawCustom() {
      RenderSystem.assertThread(RenderSystem::isOnRenderThreadOrInit);
      GlStateManager.enableDepthTest();
      if (this.framebufferObject >= 0)
      {
         this.deleteFramebuffer();
      }

      this.createBuffersCustom();
   }

   public void createBuffersCustom() {
      RenderSystem.assertThread(RenderSystem::isOnRenderThreadOrInit);

      this.framebufferObject = GlStateManager.genFramebuffers();
      this.framebufferTexture = TextureUtil.generateTextureId();

      if (this.useDepth)
      {
         this.depthBuffer = TextureUtil.generateTextureId();
         GlStateManager.bindTexture(this.depthBuffer);
         GlStateManager.texParameter(3553, 10241, 9728);
         GlStateManager.texParameter(3553, 10240, 9728);
         GlStateManager.texParameter(3553, 10242, 10496);
         GlStateManager.texParameter(3553, 10243, 10496);
         GlStateManager.texParameter(3553, 34892, 0);
         GlStateManager.texImage2D(3553, 0, 6402, this.framebufferTextureWidth, this.framebufferTextureHeight, 0, 6402, 5126, (IntBuffer)null);
      }

      this.setFramebufferFilter(9728);
      GlStateManager.bindTexture(this.framebufferTexture);
      GlStateManager.texImage2D(3553, 0, 32856, this.framebufferTextureWidth, this.framebufferTextureHeight, 0, 6408, 5121, (IntBuffer)null);
      GlStateManager.bindFramebuffer(FramebufferConstants.GL_FRAMEBUFFER, this.framebufferObject);
      GlStateManager.framebufferTexture2D(FramebufferConstants.GL_FRAMEBUFFER, FramebufferConstants.GL_COLOR_ATTACHMENT0, 3553, this.framebufferTexture, 0);

      if (this.useDepth)
      {
         GlStateManager.framebufferTexture2D(FramebufferConstants.GL_FRAMEBUFFER, FramebufferConstants.GL_DEPTH_ATTACHMENT, 3553, this.depthBuffer, 0);
      }
   }

   public void unbindFramebuffer() {
      if (!RenderSystem.isOnRenderThread())
      {
         RenderSystem.recordRenderCall(() ->
         {
            GlStateManager.bindFramebuffer(FramebufferConstants.GL_FRAMEBUFFER, 0);
         });
      }
      else
      {
         GlStateManager.bindFramebuffer(FramebufferConstants.GL_FRAMEBUFFER, 0);
      }
   }

   public void setFramebufferColor(float var1, float var2, float var3, float var4) {
      this.framebufferColor[0] = var1;
      this.framebufferColor[1] = var2;
      this.framebufferColor[2] = var3;
      this.framebufferColor[3] = var4;
   }

   public void framebufferRender(int var1, int var2) {
      this.framebufferRenderExt(var1, var2, true);
   }

   public void framebufferRenderExt(int width, int height, boolean p_178038_3_) {
      RenderSystem.assertThread(RenderSystem::isOnGameThreadOrInit);

      if (!RenderSystem.isInInitPhase())
      {
         RenderSystem.recordRenderCall(() ->
         {
            this.framebufferRenderExtRaw(width, height, p_178038_3_);
         });
      }
      else
      {
         this.framebufferRenderExtRaw(width, height, p_178038_3_);
      }
   }

   private void framebufferRenderExtRaw(int width, int height, boolean p_227588_3_) {
      RenderSystem.assertThread(RenderSystem::isOnRenderThread);
      GlStateManager.colorMask(true, true, true, false);
      GlStateManager.disableDepthTest();
      GlStateManager.depthMask(false);
      GlStateManager.matrixMode(5889);
      GlStateManager.loadIdentity();
      GlStateManager.ortho(0.0D, (double)width, (double)height, 0.0D, 1000.0D, 3000.0D);
      GlStateManager.matrixMode(5888);
      GlStateManager.loadIdentity();
      GlStateManager.translatef(0.0F, 0.0F, -2000.0F);
      GlStateManager.viewport(0, 0, width, height);
      GlStateManager.enableTexture();
      GlStateManager.disableLighting();
      GlStateManager.disableAlphaTest();

      if (p_227588_3_)
      {
         GlStateManager.disableBlend();
         GlStateManager.enableColorMaterial();
      }

      GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.bindFramebufferTexture();
      float f = (float)width;
      float f1 = (float)height;
      float f2 = (float)this.framebufferWidth / (float)this.framebufferTextureWidth;
      float f3 = (float)this.framebufferHeight / (float)this.framebufferTextureHeight;
      Tessellator tessellator = RenderSystem.renderThreadTesselator();
      BufferBuilder bufferbuilder = tessellator.getBuffer();
      bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
      bufferbuilder.pos(0.0D, (double)f1, 0.0D).tex(0.0F, 0.0F).color(255, 255, 255, 255).endVertex();
      bufferbuilder.pos((double)f, (double)f1, 0.0D).tex(f2, 0.0F).color(255, 255, 255, 255).endVertex();
      bufferbuilder.pos((double)f, 0.0D, 0.0D).tex(f2, f3).color(255, 255, 255, 255).endVertex();
      bufferbuilder.pos(0.0D, 0.0D, 0.0D).tex(0.0F, f3).color(255, 255, 255, 255).endVertex();
      tessellator.draw();
      this.unbindFramebufferTexture();
      GlStateManager.depthMask(true);
      GlStateManager.colorMask(true, true, true, true);
   }

   public void framebufferClear(boolean onMac) {
      RenderSystem.assertThread(RenderSystem::isOnRenderThreadOrInit);
      this.bindFramebuffer(true);
      GlStateManager.clearColor(this.framebufferColor[0], this.framebufferColor[1], this.framebufferColor[2], this.framebufferColor[3]);
      int i = 16384;

      if (this.useDepth)
      {
         GlStateManager.clearDepth(1.0D);
         i |= 256;
      }

      GlStateManager.clear(i, onMac);
      this.unbindFramebuffer();
   }

   public int getFramebufferTexture() {
      return this.framebufferTexture;
   }

   public int getDepthBuffer() {
      return this.depthBuffer;
   }

   public void enableStencil()
   {
      if (!this.stencilEnabled)
      {
         this.stencilEnabled = true;
         this.resize(this.framebufferWidth, this.framebufferHeight, Minecraft.IS_RUNNING_ON_MAC);
      }
   }

   public boolean isStencilEnabled()
   {
      return this.stencilEnabled;
   }
}
