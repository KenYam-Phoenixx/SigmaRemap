package mapped;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.biome.SoundAdditionsAmbience;

import java.util.Optional;
import java.util.Random;

public class Class8079 implements IAmbientSoundHandler {
   private static String[] field34719;
   private final ClientPlayerEntity field34720;
   private final SoundHandler field34721;
   private final BiomeManager field34722;
   private final Random field34723;
   private Object2ObjectArrayMap<Biome, Class6337> field34724 = new Object2ObjectArrayMap();
   private Optional<MoodSoundAmbience> field34725 = Optional.<MoodSoundAmbience>empty();
   private Optional<SoundAdditionsAmbience> field34726 = Optional.<SoundAdditionsAmbience>empty();
   private float field34727;
   private Biome field34728;

   public Class8079(ClientPlayerEntity var1, SoundHandler var2, BiomeManager var3) {
      this.field34723 = var1.world.method6814();
      this.field34720 = var1;
      this.field34721 = var2;
      this.field34722 = var3;
   }

   public float method27949() {
      return this.field34727;
   }

   @Override
   public void tick() {
      this.field34724.values().removeIf(Class6333::method19270);
      Biome var3 = this.field34722.getBiomeAtPosition(this.field34720.getPosX(), this.field34720.getPosY(), this.field34720.getPosZ());
      if (var3 != this.field34728) {
         this.field34728 = var3;
         this.field34725 = var3.getMoodSound();
         this.field34726 = var3.getAdditionalAmbientSound();
         this.field34724.values().forEach(Class6337::method19277);
         var3.getAmbientSound().ifPresent(var2 -> {
            Class6337 var5 = (Class6337)this.field34724.compute(var3, (var2x, var3x) -> {
               if (var3x == null) {
                  var3x = new Class6337(var2);
                  this.field34721.play(var3x);
               }

               var3x.method19278();
               return var3x;
            });
         });
      }

      this.field34726.ifPresent(var1 -> {
         if (this.field34723.nextDouble() < var1.method28563()) {
            this.field34721.play(SimpleSound.method19297(var1.method28562()));
         }
      });
      this.field34725
         .ifPresent(
            var1 -> {
               World var4 = this.field34720.world;
               int var5 = var1.method27075() * 2 + 1;
               BlockPos var6 = new BlockPos(
                  this.field34720.getPosX() + (double)this.field34723.nextInt(var5) - (double)var1.method27075(),
                  this.field34720.getPosYEye() + (double)this.field34723.nextInt(var5) - (double)var1.method27075(),
                  this.field34720.getPosZ() + (double)this.field34723.nextInt(var5) - (double)var1.method27075()
               );
               int var7 = var4.getLightFor(LightType.SKY, var6);
               if (var7 <= 0) {
                  this.field34727 = this.field34727 - (float)(var4.getLightFor(LightType.BLOCK, var6) - 1) / (float)var1.method27074();
               } else {
                  this.field34727 = this.field34727 - (float)var7 / (float)var4.getMaxLightLevel() * 0.001F;
               }

               if (!(this.field34727 >= 1.0F)) {
                  this.field34727 = Math.max(this.field34727, 0.0F);
               } else {
                  double var8 = (double)var6.getX() + 0.5;
                  double var10 = (double)var6.getY() + 0.5;
                  double var12 = (double)var6.getZ() + 0.5;
                  double var14 = var8 - this.field34720.getPosX();
                  double var16 = var10 - this.field34720.getPosYEye();
                  double var18 = var12 - this.field34720.getPosZ();
                  double var20 = (double) MathHelper.sqrt(var14 * var14 + var16 * var16 + var18 * var18);
                  double var22 = var20 + var1.method27076();
                  SimpleSound var24 = SimpleSound.method19298(
                     var1.method27073(),
                     this.field34720.getPosX() + var14 / var20 * var22,
                     this.field34720.getPosYEye() + var16 / var20 * var22,
                     this.field34720.getPosZ() + var18 / var20 * var22
                  );
                  this.field34721.play(var24);
                  this.field34727 = 0.0F;
               }
            }
         );
   }
}
