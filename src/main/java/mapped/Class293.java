package mapped;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.texture.NativeImage;
import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;
import net.optifine.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Class293 extends Texture {
   private static String[] field1135;
   private static final Logger field1136 = LogManager.getLogger();
   public final ResourceLocation field1137;
   private IResourceManager field1138;
   public ResourceLocation field1139;
   public boolean field1140;

   public Class293(ResourceLocation var1) {
      this.field1137 = var1;
   }

   @Override
   public void method1090(IResourceManager var1) throws IOException {
      this.field1138 = var1;
      Class1805 var4 = this.method1146(var1);
      var4.method7878();
      Class9620 var5 = var4.method7876();
      boolean var6;
      boolean var7;
      if (var5 == null) {
         var6 = false;
         var7 = false;
      } else {
         var6 = var5.method37495();
         var7 = var5.method37496();
      }

      NativeImage var8 = var4.method7877();
      if (RenderSystem.isOnRenderThreadOrInit()) {
         this.method1145(var8, var6, var7);
      } else {
         RenderSystem.recordRenderCall(() -> this.method1145(var8, var6, var7));
      }
   }

   private void method1145(NativeImage var1, boolean var2, boolean var3) {
      TextureUtil.method30370(this.getGlTextureId(), 0, var1.method7886(), var1.method7887());
      var1.method7895(0, 0, 0, 0, 0, var1.method7886(), var1.method7887(), var2, var3, false, true);
      if (Config.isShaders()) {
         Class9336.method35336(this.getGlTextureId(), var1, var2, var3, this.field1138, this.field1137, this.method1135());
      }

      if (EmissiveTextures.isActive()) {
         EmissiveTextures.method30607(this.field1137, this);
      }
   }

   public Class1805 method1146(IResourceManager var1) {
      return Class1805.method7875(var1, this.field1137);
   }

   // $VF: synthetic method
   public static Logger method1148() {
      return field1136;
   }
}
