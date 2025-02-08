package net.minecraft.client.shader;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.mojang.blaze3d.systems.RenderSystem;
import mapped.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;
import totalcross.json.JSONException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class ShaderGroup implements AutoCloseable {
   private final Framebuffer mainFramebuffer;
   private final IResourceManager resourceManager;
   private final String shaderGroupName;
   public final List<Shader> listShaders = Lists.newArrayList();
   private final Map<String, Framebuffer> mapFramebuffers = Maps.newHashMap();
   private final List<Framebuffer> listFramebuffers = Lists.newArrayList();
   private Matrix4f projectionMatrix;
   private int mainFramebufferWidth;
   private int mainFramebufferHeight;
   private float time;
   private float lastStamp;

   public ShaderGroup(TextureManager var1, IResourceManager var2, Framebuffer var3, ResourceLocation var4) throws IOException, JsonSyntaxException {
      this.resourceManager = var2;
      this.mainFramebuffer = var3;
      this.time = 0.0F;
      this.lastStamp = 0.0F;
      this.mainFramebufferWidth = var3.framebufferWidth;
      this.mainFramebufferHeight = var3.framebufferHeight;
      this.shaderGroupName = var4.toString();
      this.method6524();
      this.method6517(var1, var4);
   }

   private void method6517(TextureManager var1, ResourceLocation var2) throws IOException, JsonSyntaxException {
      IResource var5 = null;

      try {
         var5 = this.resourceManager.getResource(var2);
         JsonObject var6 = JSONUtils.fromJson(new InputStreamReader(var5.getInputStream(), StandardCharsets.UTF_8));
         if (JSONUtils.method32759(var6, "targets")) {
            JsonArray var22 = var6.getAsJsonArray("targets");
            int var24 = 0;

            for (JsonElement var10 : var22) {
               try {
                  this.method6518(var10);
               } catch (Exception var19) {
                  JSONException var12 = JSONException.method10464(var19);
                  var12.method10462("targets[" + var24 + "]");
                  throw var12;
               }

               var24++;
            }
         }

         if (JSONUtils.method32759(var6, "passes")) {
            JsonArray var23 = var6.getAsJsonArray("passes");
            int var25 = 0;

            for (JsonElement var27 : var23) {
               try {
                  this.method6519(var1, var27);
               } catch (Exception var18) {
                  JSONException var28 = JSONException.method10464(var18);
                  var28.method10462("passes[" + var25 + "]");
                  throw var28;
               }

               var25++;
            }
         }
      } catch (Exception var20) {
         String var7;
         if (var5 != null) {
            var7 = " (" + var5.getPackName() + ")";
         } else {
            var7 = "";
         }

         JSONException var8 = JSONException.method10464(var20);
         var8.method10463(var2.getPath() + var7);
         throw var8;
      } finally {
         IOUtils.closeQuietly(var5);
      }
   }

   private void method6518(JsonElement var1) throws JSONException {
      if (!JSONUtils.method32756(var1)) {
         JsonObject var4 = JSONUtils.getJSONObject(var1, "target");
         String var5 = JSONUtils.getString(var4, "name");
         int var6 = JSONUtils.getInt(var4, "width", this.mainFramebufferWidth);
         int var7 = JSONUtils.getInt(var4, "height", this.mainFramebufferHeight);
         if (this.mapFramebuffers.containsKey(var5)) {
            throw new JSONException(var5 + " is already defined");
         }

         this.method6522(var5, var6, var7);
      } else {
         this.method6522(var1.getAsString(), this.mainFramebufferWidth, this.mainFramebufferHeight);
      }
   }

   private void method6519(TextureManager var1, JsonElement var2) throws IOException {
      JsonObject var5 = JSONUtils.getJSONObject(var2, "pass");
      String var6 = JSONUtils.getString(var5, "name");
      String var7 = JSONUtils.getString(var5, "intarget");
      String var8 = JSONUtils.getString(var5, "outtarget");
      Framebuffer var9 = this.getFramebuffer(var7);
      Framebuffer var10 = this.getFramebuffer(var8);
      if (var9 == null) {
         throw new JSONException("Input target '" + var7 + "' does not exist");
      } else if (var10 == null) {
         throw new JSONException("Output target '" + var8 + "' does not exist");
      } else {
         Shader var11 = this.method6523(var6, var9, var10);
         JsonArray var12 = JSONUtils.method32786(var5, "auxtargets", (JsonArray)null);
         if (var12 != null) {
            int var13 = 0;

            for (JsonElement var15 : var12) {
               try {
                  JsonObject var16 = JSONUtils.getJSONObject(var15, "auxtarget");
                  String var40 = JSONUtils.getString(var16, "name");
                  String var18 = JSONUtils.getString(var16, "id");
                  boolean var19;
                  String var20;
                  if (var18.endsWith(":depth")) {
                     var19 = true;
                     var20 = var18.substring(0, var18.lastIndexOf(58));
                  } else {
                     var19 = false;
                     var20 = var18;
                  }

                  Framebuffer var21 = this.getFramebuffer(var20);
                  if (var21 == null) {
                     if (var19) {
                        throw new JSONException("Render target '" + var20 + "' can't be used as depth buffer");
                     }

                     ResourceLocation var22 = new ResourceLocation("textures/effect/" + var20 + ".png");
                     IResource var23 = null;

                     try {
                        var23 = this.resourceManager.getResource(var22);
                     } catch (FileNotFoundException var33) {
                        throw new JSONException("Render target or texture '" + var20 + "' does not exist");
                     } finally {
                        IOUtils.closeQuietly(var23);
                     }

                     var1.bindTexture(var22);
                     Texture var24 = var1.getTexture(var22);
                     int var25 = JSONUtils.method32777(var16, "width");
                     int var26 = JSONUtils.method32777(var16, "height");
                     boolean var27 = JSONUtils.method32768(var16, "bilinear");
                     if (var27) {
                        RenderSystem.texParameter(3553, 10241, 9729);
                        RenderSystem.texParameter(3553, 10240, 9729);
                     } else {
                        RenderSystem.texParameter(3553, 10241, 9728);
                        RenderSystem.texParameter(3553, 10240, 9728);
                     }

                     var11.method7407(var40, var24::getGlTextureId, var25, var26);
                  } else if (var19) {
                     var11.method7407(var40, var21::getDepthBuffer, var21.framebufferTextureWidth, var21.framebufferTextureHeight);
                  } else {
                     var11.method7407(var40, var21::getFramebufferTexture, var21.framebufferTextureWidth, var21.framebufferTextureHeight);
                  }
               } catch (Exception var35) {
                  JSONException var17 = JSONException.method10464(var35);
                  var17.method10462("auxtargets[" + var13 + "]");
                  throw var17;
               }

               var13++;
            }
         }

         JsonArray var36 = JSONUtils.method32786(var5, "uniforms", (JsonArray)null);
         if (var36 != null) {
            int var37 = 0;

            for (JsonElement var39 : var36) {
               try {
                  this.method6520(var39);
               } catch (Exception var32) {
                  JSONException var41 = JSONException.method10464(var32);
                  var41.method10462("uniforms[" + var37 + "]");
                  throw var41;
               }

               var37++;
            }
         }
      }
   }

   private void method6520(JsonElement var1) throws JSONException {
      JsonObject var4 = JSONUtils.getJSONObject(var1, "uniform");
      String var5 = JSONUtils.getString(var4, "name");
      ShaderUniform var6 = this.listShaders.get(this.listShaders.size() - 1).getShaderManager().func_216539_a(var5);
      if (var6 == null) {
         throw new JSONException("Uniform '" + var5 + "' does not exist");
      } else {
         float[] var7 = new float[4];
         int var8 = 0;

         for (JsonElement var10 : JSONUtils.method32785(var4, "values")) {
            try {
               var7[var8] = JSONUtils.method32770(var10, "value");
            } catch (Exception var13) {
               JSONException var12 = JSONException.method10464(var13);
               var12.method10462("values[" + var8 + "]");
               throw var12;
            }

            var8++;
         }

         switch (var8) {
            case 0:
            default:
               break;
            case 1:
               var6.set(var7[0]);
               break;
            case 2:
               var6.set(var7[0], var7[1]);
               break;
            case 3:
               var6.set(var7[0], var7[1], var7[2]);
               break;
            case 4:
               var6.set(var7[0], var7[1], var7[2], var7[3]);
         }
      }
   }

   public Framebuffer method6521(String var1) {
      return this.mapFramebuffers.get(var1);
   }

   public void method6522(String var1, int var2, int var3) {
      Framebuffer var6 = new Framebuffer(var2, var3, true, Minecraft.IS_RUNNING_ON_MAC);
      var6.setFramebufferColor(0.0F, 0.0F, 0.0F, 0.0F);
      this.mapFramebuffers.put(var1, var6);
      if (var2 == this.mainFramebufferWidth && var3 == this.mainFramebufferHeight) {
         this.listFramebuffers.add(var6);
      }
   }

   @Override
   public void close() {
      for (Framebuffer var4 : this.mapFramebuffers.values()) {
         var4.deleteFramebuffer();
      }

      for (Shader var6 : this.listShaders) {
         var6.close();
      }

      this.listShaders.clear();
   }

   public Shader method6523(String var1, Framebuffer var2, Framebuffer var3) throws IOException {
      Shader var6 = new Shader(this.resourceManager, var1, var2, var3);
      this.listShaders.add(this.listShaders.size(), var6);
      return var6;
   }

   private void method6524() {
      this.projectionMatrix = Matrix4f.method35512((float)this.mainFramebuffer.framebufferTextureWidth, (float)this.mainFramebuffer.framebufferTextureHeight, 0.1F, 1000.0F);
   }

   public void createBindFramebuffers(int var1, int var2) {
      this.mainFramebufferWidth = this.mainFramebuffer.framebufferTextureWidth;
      this.mainFramebufferHeight = this.mainFramebuffer.framebufferTextureHeight;
      this.method6524();

      for (Shader var6 : this.listShaders) {
         var6.method7408(this.projectionMatrix);
      }

      for (Framebuffer var8 : this.listFramebuffers) {
         var8.resize(var1, var2, Minecraft.IS_RUNNING_ON_MAC);
      }
   }

   public void render(float var1) {
      if (!(var1 < this.lastStamp)) {
         this.time = this.time + (var1 - this.lastStamp);
      } else {
         this.time = this.time + (1.0F - this.lastStamp);
         this.time += var1;
      }

      this.lastStamp = var1;

      while (this.time > 20.0F) {
         this.time -= 20.0F;
      }

      for (Shader var5 : this.listShaders) {
         var5.method7409(this.time / 20.0F);
      }
   }

   public final String method6527() {
      return this.shaderGroupName;
   }

   public Framebuffer getFramebuffer(String var1) {
      if (var1 != null) {
         return !var1.equals("minecraft:main") ? this.mapFramebuffers.get(var1) : this.mainFramebuffer;
      } else {
         return null;
      }
   }
}
