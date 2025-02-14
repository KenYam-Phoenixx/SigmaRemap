package mapped;

import com.google.common.collect.*;
import com.mojang.serialization.Codec;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.SectionPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.ShipwreckConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class Structure<C extends Class4698> {
   public static final BiMap<String, Structure<?>> field_236365_a_ = HashBiMap.create();
   private static final Map<Structure<?>, Decoration> field18056 = com.google.common.collect.Maps.newHashMap();
   private static final Logger field18057 = LogManager.getLogger();
   public static final Structure<Class4700> PILLAGER_OUTPOST = method11363("Pillager_Outpost", new Class2968(Class4700.field22296), Decoration.field13002);
   public static final Structure<MineshaftConfig> MINESHAFT = method11363("Mineshaft", new Class2972(MineshaftConfig.field22425), Decoration.field13001);
   public static final Structure<Class4712> MANSION = method11363("Mansion", new Class2976(Class4712.field22349), Decoration.field13002);
   public static final Structure<Class4712> JUNGLE_PYRAMID = method11363("Jungle_Pyramid", new Class2977(Class4712.field22349), Decoration.field13002);
   public static final Structure<Class4712> DESERT_PYRAMID = method11363("Desert_Pyramid", new Class2975(Class4712.field22349), Decoration.field13002);
   public static final Structure<Class4712> IGLOO = method11363("Igloo", new Class2966(Class4712.field22349), Decoration.field13002);
   public static final Structure<Class4726> RUINED_PORTAL = method11363("Ruined_Portal", new Class2978(Class4726.field22392), Decoration.field13002);
   public static final Structure<ShipwreckConfig> SHIPWRECK = method11363("Shipwreck", new Class2964(ShipwreckConfig.field22431), Decoration.field13002);
   public static final Class2974 SWAMP_HUT = method11363("Swamp_Hut", new Class2974(Class4712.field22349), Decoration.field13002);
   public static final Structure<Class4712> STRONGHOLD = method11363("Stronghold", new Class2962(Class4712.field22349), Decoration.field13003);
   public static final Structure<Class4712> MONUMENT = method11363("Monument", new Class2971(Class4712.field22349), Decoration.field13002);
   public static final Structure<Class4711> field18069 = method11363("Ocean_Ruin", new Class2965(Class4711.field22344), Decoration.field13002);
   public static final Structure<Class4712> field18070 = method11363("Fortress", new Class2973(Class4712.field22349), Decoration.field13005);
   public static final Structure<Class4712> field18071 = method11363("EndCity", new Class2960(Class4712.field22349), Decoration.field13002);
   public static final Structure<Class4728> field18072 = method11363("Buried_Treasure", new Class2963(Class4728.field22398), Decoration.field13001);
   public static final Structure<Class4700> field18073 = method11363("Village", new Class2969(Class4700.field22296), Decoration.field13002);
   public static final Structure<Class4712> field18074 = method11363("Nether_Fossil", new Class2979(Class4712.field22349), Decoration.field13005);
   public static final Structure<Class4700> field18075 = method11363("Bastion_Remnant", new Class2970(Class4700.field22296), Decoration.field13002);
   public static final List<Structure<?>> field18076 = ImmutableList.of(PILLAGER_OUTPOST, field18073, field18074);
   private static final ResourceLocation field18077 = new ResourceLocation("jigsaw");
   private static final Map<ResourceLocation, ResourceLocation> field18078 = ImmutableMap.<ResourceLocation, ResourceLocation>builder()
      .put(new ResourceLocation("nvi"), field18077)
      .put(new ResourceLocation("pcp"), field18077)
      .put(new ResourceLocation("bastionremnant"), field18077)
      .put(new ResourceLocation("runtime"), field18077)
      .build();
   private final Codec<StructureFeature<C, Structure<C>>> field18079;

   private static <F extends Structure<?>> F method11363(String var0, F var1, Decoration var2) {
      field_236365_a_.put(var0.toLowerCase(Locale.ROOT), var1);
      field18056.put(var1, var2);
      return Registry.<F>register(Registry.STRUCTURE_FEATURE, var0.toLowerCase(Locale.ROOT), (F)var1);
   }

   public Structure(Codec<C> var1) {
      this.field18079 = var1.fieldOf("config").xmap(var1x -> new StructureFeature<C, Structure<C>>(this, (C)var1x), var0 -> var0.field43175).codec();
   }

   public Decoration func_236396_f_() {
      return field18056.get(this);
   }

   public static void method11365() {
   }

   @Nullable
   public static StructureStart<?> method11366(TemplateManager var0, CompoundNBT var1, long var2) {
      String var6 = var1.getString("id");
      if ("INVALID".equals(var6)) {
         return StructureStart.field24194;
      } else {
         Structure var7 = Registry.STRUCTURE_FEATURE.getOrDefault(new ResourceLocation(var6.toLowerCase(Locale.ROOT)));
         if (var7 == null) {
            field18057.error("Unknown feature id: {}", var6);
            return null;
         } else {
            int var8 = var1.getInt("ChunkX");
            int var9 = var1.getInt("ChunkZ");
            int var10 = var1.getInt("references");
            MutableBoundingBox var11 = var1.contains("BB") ? new MutableBoundingBox(var1.getIntArray("BB")) : MutableBoundingBox.method38386();
            ListNBT var12 = var1.getList("Children", 10);

            try {
               StructureStart var13 = var7.method11371(var8, var9, var11, var10, var2);

               for (int var14 = 0; var14 < var12.size(); var14++) {
                  CompoundNBT var15 = var12.getCompound(var14);
                  String var16 = var15.getString("id").toLowerCase(Locale.ROOT);
                  ResourceLocation var17 = new ResourceLocation(var16);
                  ResourceLocation var18 = field18078.getOrDefault(var17, var17);
                  Class7792 var19 = Registry.field16116.getOrDefault(var18);
                  if (var19 == null) {
                     field18057.error("Unknown structure piece id: {}", var18);
                  } else {
                     try {
                        Class4178 var20 = var19.method25881(var0, var15);
                        var13.method17111().add(var20);
                     } catch (Exception var21) {
                        field18057.error("Exception loading structure piece with id {}", var18, var21);
                     }
                  }
               }

               return var13;
            } catch (Exception var22) {
               field18057.error("Failed Start with id {}", var6, var22);
               return null;
            }
         }
      }
   }

   public Codec<StructureFeature<C, Structure<C>>> method11367() {
      return this.field18079;
   }

   public StructureFeature<C, ? extends Structure<C>> method11368(C var1) {
      return new StructureFeature<>(this, var1);
   }

   @Nullable
   public BlockPos func_236388_a_(IWorldReader var1, StructureManager var2, BlockPos var3, int var4, boolean var5, long var6, StructureSeparationSettings var8) {
      int var11 = var8.method29980();
      int var12 = var3.getX() >> 4;
      int var13 = var3.getZ() >> 4;
      int var14 = 0;

      for (SharedSeedRandom var15 = new SharedSeedRandom(); var14 <= var4; var14++) {
         for (int var16 = -var14; var16 <= var14; var16++) {
            boolean var17 = var16 == -var14 || var16 == var14;

            for (int var18 = -var14; var18 <= var14; var18++) {
               boolean var19 = var18 == -var14 || var18 == var14;
               if (var17 || var19) {
                  int var20 = var12 + var11 * var16;
                  int var21 = var13 + var11 * var18;
                  ChunkPos var22 = this.method11370(var8, var6, var15, var20, var21);
                  IChunk var23 = var1.getChunk(var22.x, var22.z, ChunkStatus.STRUCTURE_STARTS);
                  StructureStart var24 = var2.method24341(SectionPos.from(var23.getPos(), 0), this, var23);
                  if (var24 != null && var24.method17117()) {
                     if (var5 && var24.method17121()) {
                        var24.method17122();
                        return var24.method17120();
                     }

                     if (!var5) {
                        return var24.method17120();
                     }
                  }

                  if (var14 == 0) {
                     break;
                  }
               }
            }

            if (var14 == 0) {
               break;
            }
         }
      }

      return null;
   }

   public boolean method11357() {
      return true;
   }

   public final ChunkPos method11370(StructureSeparationSettings var1, long var2, SharedSeedRandom var4, int var5, int var6) {
      int var9 = var1.method29980();
      int var10 = var1.method29981();
      int var11 = Math.floorDiv(var5, var9);
      int var12 = Math.floorDiv(var6, var9);
      var4.method10374(var2, var11, var12, var1.method29982());
      int var13;
      int var14;
      if (!this.method11357()) {
         var13 = (var4.nextInt(var9 - var10) + var4.nextInt(var9 - var10)) / 2;
         var14 = (var4.nextInt(var9 - var10) + var4.nextInt(var9 - var10)) / 2;
      } else {
         var13 = var4.nextInt(var9 - var10);
         var14 = var4.nextInt(var9 - var10);
      }

      return new ChunkPos(var11 * var9 + var13, var12 * var9 + var14);
   }

   public boolean method11361(ChunkGenerator var1, BiomeProvider var2, long var3, SharedSeedRandom var5, int var6, int var7, Biome var8, ChunkPos var9, C var10) {
      return true;
   }

   private StructureStart<C> method11371(int var1, int var2, MutableBoundingBox var3, int var4, long var5) {
      return this.method11359().method21988(this, var1, var2, var3, var4, var5);
   }

   public StructureStart<?> method11372(
      DynamicRegistries var1,
      ChunkGenerator var2,
      BiomeProvider var3,
      TemplateManager var4,
      long var5,
      ChunkPos var7,
      Biome var8,
      int var9,
      SharedSeedRandom var10,
      StructureSeparationSettings var11,
      C var12
   ) {
      ChunkPos var15 = this.method11370(var11, var5, var10, var7.x, var7.z);
      if (var7.x == var15.x
         && var7.z == var15.z
         && this.method11361(var2, var3, var5, var10, var7.x, var7.z, var8, var15, (C)var12)) {
         StructureStart var16 = this.method11371(var7.x, var7.z, MutableBoundingBox.method38386(), var9, var5);
         var16.method17109(var1, var2, var4, var7.x, var7.z, var8, var12);
         if (var16.method17117()) {
            return var16;
         }
      }

      return StructureStart.field24194;
   }

   public abstract Class7072<C> method11359();

   public String method11373() {
      return (String) field_236365_a_.inverse().get(this);
   }

   public List<MobSpawnInfo.Spawners> method11374() {
      return ImmutableList.of();
   }

   public List<MobSpawnInfo.Spawners> method11375() {
      return ImmutableList.of();
   }
}
