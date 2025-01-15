package net.minecraft.util.datafix;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.DSL;
import com.mojang.datafixers.DataFixer;
import com.mojang.datafixers.DataFixerBuilder;
import com.mojang.datafixers.Typed;
import com.mojang.datafixers.schemas.Schema;
import java.util.Objects;
import java.util.function.BiFunction;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.fixes.AddBedTileEntity;
import net.minecraft.util.datafix.fixes.AddNewChoices;
import net.minecraft.util.datafix.fixes.AdvancementRenamer;
import net.minecraft.util.datafix.fixes.AdvancementRenamer1501;
import net.minecraft.util.datafix.fixes.ArmorStandSilent;
import net.minecraft.util.datafix.fixes.BannerItemColor;
import net.minecraft.util.datafix.fixes.BedItemColor;
import net.minecraft.util.datafix.fixes.BiomeIdFix;
import net.minecraft.util.datafix.fixes.BiomeRenames;
import net.minecraft.util.datafix.fixes.BlockEntityBannerColor;
import net.minecraft.util.datafix.fixes.BlockEntityKeepPacked;
import net.minecraft.util.datafix.fixes.BlockNameFlattening;
import net.minecraft.util.datafix.fixes.BlockRename;
import net.minecraft.util.datafix.fixes.BlockStateFlattenGenOptions;
import net.minecraft.util.datafix.fixes.BlockStateFlattenStructures;
import net.minecraft.util.datafix.fixes.BlockStateFlattenVillageCrops;
import net.minecraft.util.datafix.fixes.BlockStateFlatternEntities;
import net.minecraft.util.datafix.fixes.BookPagesStrictJSON;
import net.minecraft.util.datafix.fixes.CatTypeFix;
import net.minecraft.util.datafix.fixes.ChunkGenStatus;
import net.minecraft.util.datafix.fixes.ChunkLightRemoveFix;
import net.minecraft.util.datafix.fixes.ChunkPaletteFormat;
import net.minecraft.util.datafix.fixes.ChunkStatusFix;
import net.minecraft.util.datafix.fixes.ChunkStatusFix2;
import net.minecraft.util.datafix.fixes.ChunkStructuresTemplateRenameFix;
import net.minecraft.util.datafix.fixes.ColorlessShulkerEntityFix;
import net.minecraft.util.datafix.fixes.CoralFansRenameList;
import net.minecraft.util.datafix.fixes.CustomNameStringToComponentEntity;
import net.minecraft.util.datafix.fixes.CustomNameStringToComponentFixTileEntity;
import net.minecraft.util.datafix.fixes.CustomNameStringToComponentItem;
import net.minecraft.util.datafix.fixes.DyeRenameMap;
import net.minecraft.util.datafix.fixes.ElderGuardianSplit;
import net.minecraft.util.datafix.fixes.EntityArmorAndHeld;
import net.minecraft.util.datafix.fixes.EntityCatSplitFix;
import net.minecraft.util.datafix.fixes.EntityCodSalmonFix;
import net.minecraft.util.datafix.fixes.EntityHealth;
import net.minecraft.util.datafix.fixes.EntityId;
import net.minecraft.util.datafix.fixes.EntityItemFrameFacing;
import net.minecraft.util.datafix.fixes.EntityRavagerRenameFix;
import net.minecraft.util.datafix.fixes.EntityRenaming1510;
import net.minecraft.util.datafix.fixes.ForceVBOOn;
import net.minecraft.util.datafix.fixes.HeightmapRenamingFix;
import net.minecraft.util.datafix.fixes.HorseSaddle;
import net.minecraft.util.datafix.fixes.HorseSplit;
import net.minecraft.util.datafix.fixes.IglooMetadataRemoval;
import net.minecraft.util.datafix.fixes.ItemFilledMapMetadata;
import net.minecraft.util.datafix.fixes.ItemIntIDToString;
import net.minecraft.util.datafix.fixes.ItemLoreComponentizeFix;
import net.minecraft.util.datafix.fixes.ItemRename;
import net.minecraft.util.datafix.fixes.ItemSpawnEggSplit;
import net.minecraft.util.datafix.fixes.ItemStackDataFlattening;
import net.minecraft.util.datafix.fixes.ItemStackEnchantmentFix;
import net.minecraft.util.datafix.fixes.JukeboxRecordItem;
import net.minecraft.util.datafix.fixes.KeyOptionsTranslation;
import net.minecraft.util.datafix.fixes.LWJGL3KeyOptions;
import net.minecraft.util.datafix.fixes.LeavesFix;
import net.minecraft.util.datafix.fixes.LevelDataGeneratorOptionsFix;
import net.minecraft.util.datafix.fixes.MapIdFix;
import net.minecraft.util.datafix.fixes.MinecartEntityTypes;
import net.minecraft.util.datafix.fixes.NamedEntityFix;
import net.minecraft.util.datafix.fixes.NewVillageFix;
import net.minecraft.util.datafix.fixes.ObjectiveDisplayName;
import net.minecraft.util.datafix.fixes.ObjectiveRenderType;
import net.minecraft.util.datafix.fixes.OminousBannerRenameFix;
import net.minecraft.util.datafix.fixes.OminousBannerTileEntityRenameFix;
import net.minecraft.util.datafix.fixes.OptionsAddTextBackgroundFix;
import net.minecraft.util.datafix.fixes.OptionsLowerCaseLanguage;
import net.minecraft.util.datafix.fixes.PaintingDirection;
import net.minecraft.util.datafix.fixes.PaintingMotive;
import net.minecraft.util.datafix.fixes.PistonPushedBlock;
import net.minecraft.util.datafix.fixes.PointOfInterestRebuild;
import net.minecraft.util.datafix.fixes.PointOfInterestReorganizationFix;
import net.minecraft.util.datafix.fixes.PotionItems;
import net.minecraft.util.datafix.fixes.PotionWater;
import net.minecraft.util.datafix.fixes.PufferfishRename;
import net.minecraft.util.datafix.fixes.RecipeRenamer;
import net.minecraft.util.datafix.fixes.RecipeRenamer1502;
import net.minecraft.util.datafix.fixes.RecipeRenamer1510;
import net.minecraft.util.datafix.fixes.RedundantChanceTags;
import net.minecraft.util.datafix.fixes.RenameBeehivePointOfInterest;
import net.minecraft.util.datafix.fixes.RenamedCoral;
import net.minecraft.util.datafix.fixes.RidingToPassengers;
import net.minecraft.util.datafix.fixes.ShulkerBoxEntityColor;
import net.minecraft.util.datafix.fixes.ShulkerBoxItemColor;
import net.minecraft.util.datafix.fixes.ShulkerBoxTileColor;
import net.minecraft.util.datafix.fixes.SignStrictJSON;
import net.minecraft.util.datafix.fixes.SkeletonSplit;
import net.minecraft.util.datafix.fixes.SpawnEggNames;
import net.minecraft.util.datafix.fixes.SpawnerEntityTypes;
import net.minecraft.util.datafix.fixes.StatsRenaming;
import net.minecraft.util.datafix.fixes.StringToUUID;
import net.minecraft.util.datafix.fixes.StructureReferenceFix;
import net.minecraft.util.datafix.fixes.SwimStatsRename;
import net.minecraft.util.datafix.fixes.TeamDisplayName;
import net.minecraft.util.datafix.fixes.TileEntityId;
import net.minecraft.util.datafix.fixes.TippedArrow;
import net.minecraft.util.datafix.fixes.TrappedChestTileEntitySplit;
import net.minecraft.util.datafix.fixes.VillagerLevelAndXpFix;
import net.minecraft.util.datafix.fixes.VillagerProfessionFix;
import net.minecraft.util.datafix.fixes.VillagerTrades;
import net.minecraft.util.datafix.fixes.WolfCollarColor;
import net.minecraft.util.datafix.fixes.ZombieProfToType;
import net.minecraft.util.datafix.fixes.ZombieSplit;
import net.minecraft.util.datafix.fixes.ZombieVillagerXpFix;
import net.minecraft.util.datafix.versions.V0099;
import net.minecraft.util.datafix.versions.V0100;
import net.minecraft.util.datafix.versions.V0102;
import net.minecraft.util.datafix.versions.V0106;
import net.minecraft.util.datafix.versions.V0107;
import net.minecraft.util.datafix.versions.V0135;
import net.minecraft.util.datafix.versions.V0143;
import net.minecraft.util.datafix.versions.V0501;
import net.minecraft.util.datafix.versions.V0700;
import net.minecraft.util.datafix.versions.V0701;
import net.minecraft.util.datafix.versions.V0702;
import net.minecraft.util.datafix.versions.V0703;
import net.minecraft.util.datafix.versions.V0704;
import net.minecraft.util.datafix.versions.V0705;
import net.minecraft.util.datafix.versions.V0808;
import net.minecraft.util.datafix.versions.V1022;
import net.minecraft.util.datafix.versions.V1125;
import net.minecraft.util.datafix.versions.V1451;
import net.minecraft.util.datafix.versions.V1451_1;
import net.minecraft.util.datafix.versions.V1451_2;
import net.minecraft.util.datafix.versions.V1451_3;
import net.minecraft.util.datafix.versions.V1451_4;
import net.minecraft.util.datafix.versions.V1451_5;
import net.minecraft.util.datafix.versions.V1451_6;
import net.minecraft.util.datafix.versions.V1451_7;
import net.minecraft.util.datafix.versions.V1460;
import net.minecraft.util.datafix.versions.V1466;
import net.minecraft.util.datafix.versions.V1470;
import net.minecraft.util.datafix.versions.V1481;
import net.minecraft.util.datafix.versions.V1483;
import net.minecraft.util.datafix.versions.V1486;
import net.minecraft.util.datafix.versions.V1510;
import net.minecraft.util.datafix.versions.V1800;
import net.minecraft.util.datafix.versions.V1801;
import net.minecraft.util.datafix.versions.V1904;
import net.minecraft.util.datafix.versions.V1906;
import net.minecraft.util.datafix.versions.V1909;
import net.minecraft.util.datafix.versions.V1920;
import net.minecraft.util.datafix.versions.V1928;
import net.minecraft.util.datafix.versions.V1929;
import net.minecraft.util.datafix.versions.V1931;
import net.minecraft.util.datafix.versions.V2100;

public class DataFixesManager
{
    private static final BiFunction<Integer, Schema, Schema> SCHEMA_FACTORY = Schema::new;
    private static final BiFunction<Integer, Schema, Schema> NAMESPACED_SCHEMA_FACTORY = NamespacedSchema::new;
    private static final DataFixer DATA_FIXER = createFixer();

    private static DataFixer createFixer()
    {
        DataFixerBuilder datafixerbuilder = new DataFixerBuilder(SharedConstants.getVersion().getWorldVersion());
        addFixers(datafixerbuilder);
        return datafixerbuilder.build(Util.getServerExecutor());
    }

    public static DataFixer getDataFixer()
    {
        return DATA_FIXER;
    }

    private static void addFixers(DataFixerBuilder builder)
    {
        Schema schema = builder.addSchema(99, V0099::new);
        Schema schema1 = builder.addSchema(100, V0100::new);
        builder.addFixer(new EntityArmorAndHeld(schema1, true));
        Schema schema2 = builder.addSchema(101, SCHEMA_FACTORY);
        builder.addFixer(new SignStrictJSON(schema2, false));
        Schema schema3 = builder.addSchema(102, V0102::new);
        builder.addFixer(new ItemIntIDToString(schema3, true));
        builder.addFixer(new PotionItems(schema3, false));
        Schema schema4 = builder.addSchema(105, SCHEMA_FACTORY);
        builder.addFixer(new SpawnEggNames(schema4, true));
        Schema schema5 = builder.addSchema(106, V0106::new);
        builder.addFixer(new SpawnerEntityTypes(schema5, true));
        Schema schema6 = builder.addSchema(107, V0107::new);
        builder.addFixer(new MinecartEntityTypes(schema6, true));
        Schema schema7 = builder.addSchema(108, SCHEMA_FACTORY);
        builder.addFixer(new StringToUUID(schema7, true));
        Schema schema8 = builder.addSchema(109, SCHEMA_FACTORY);
        builder.addFixer(new EntityHealth(schema8, true));
        Schema schema9 = builder.addSchema(110, SCHEMA_FACTORY);
        builder.addFixer(new HorseSaddle(schema9, true));
        Schema schema10 = builder.addSchema(111, SCHEMA_FACTORY);
        builder.addFixer(new PaintingDirection(schema10, true));
        Schema schema11 = builder.addSchema(113, SCHEMA_FACTORY);
        builder.addFixer(new RedundantChanceTags(schema11, true));
        Schema schema12 = builder.addSchema(135, V0135::new);
        builder.addFixer(new RidingToPassengers(schema12, true));
        Schema schema13 = builder.addSchema(143, V0143::new);
        builder.addFixer(new TippedArrow(schema13, true));
        Schema schema14 = builder.addSchema(147, SCHEMA_FACTORY);
        builder.addFixer(new ArmorStandSilent(schema14, true));
        Schema schema15 = builder.addSchema(165, SCHEMA_FACTORY);
        builder.addFixer(new BookPagesStrictJSON(schema15, true));
        Schema schema16 = builder.addSchema(501, V0501::new);
        builder.addFixer(new AddNewChoices(schema16, "Add 1.10 entities fix", TypeReferences.ENTITY));
        Schema schema17 = builder.addSchema(502, SCHEMA_FACTORY);
        builder.addFixer(ItemRename.create(schema17, "cooked_fished item renamer", (p_207111_0_) ->
        {
            return Objects.equals(NamespacedSchema.ensureNamespaced(p_207111_0_), "minecraft:cooked_fished") ? "minecraft:cooked_fish" : p_207111_0_;
        }));
        builder.addFixer(new ZombieProfToType(schema17, false));
        Schema schema18 = builder.addSchema(505, SCHEMA_FACTORY);
        builder.addFixer(new ForceVBOOn(schema18, false));
        Schema schema19 = builder.addSchema(700, V0700::new);
        builder.addFixer(new ElderGuardianSplit(schema19, true));
        Schema schema20 = builder.addSchema(701, V0701::new);
        builder.addFixer(new SkeletonSplit(schema20, true));
        Schema schema21 = builder.addSchema(702, V0702::new);
        builder.addFixer(new ZombieSplit(schema21, true));
        Schema schema22 = builder.addSchema(703, V0703::new);
        builder.addFixer(new HorseSplit(schema22, true));
        Schema schema23 = builder.addSchema(704, V0704::new);
        builder.addFixer(new TileEntityId(schema23, true));
        Schema schema24 = builder.addSchema(705, V0705::new);
        builder.addFixer(new EntityId(schema24, true));
        Schema schema25 = builder.addSchema(804, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new BannerItemColor(schema25, true));
        Schema schema26 = builder.addSchema(806, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new PotionWater(schema26, false));
        Schema schema27 = builder.addSchema(808, V0808::new);
        builder.addFixer(new AddNewChoices(schema27, "added shulker box", TypeReferences.BLOCK_ENTITY));
        Schema schema28 = builder.addSchema(808, 1, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new ShulkerBoxEntityColor(schema28, false));
        Schema schema29 = builder.addSchema(813, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new ShulkerBoxItemColor(schema29, false));
        builder.addFixer(new ShulkerBoxTileColor(schema29, false));
        Schema schema30 = builder.addSchema(816, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new OptionsLowerCaseLanguage(schema30, false));
        Schema schema31 = builder.addSchema(820, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(ItemRename.create(schema31, "totem item renamer", (p_207107_0_) ->
        {
            return Objects.equals(p_207107_0_, "minecraft:totem") ? "minecraft:totem_of_undying" : p_207107_0_;
        }));
        Schema schema32 = builder.addSchema(1022, V1022::new);
        builder.addFixer(new WriteAndReadDataFix(schema32, "added shoulder entities to players", TypeReferences.PLAYER));
        Schema schema33 = builder.addSchema(1125, V1125::new);
        builder.addFixer(new AddBedTileEntity(schema33, true));
        builder.addFixer(new BedItemColor(schema33, false));
        Schema schema34 = builder.addSchema(1344, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new LWJGL3KeyOptions(schema34, false));
        Schema schema35 = builder.addSchema(1446, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new KeyOptionsTranslation(schema35, false));
        Schema schema36 = builder.addSchema(1450, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new BlockStateFlattenStructures(schema36, false));
        Schema schema37 = builder.addSchema(1451, V1451::new);
        builder.addFixer(new AddNewChoices(schema37, "AddTrappedChestFix", TypeReferences.BLOCK_ENTITY));
        Schema schema38 = builder.addSchema(1451, 1, V1451_1::new);
        builder.addFixer(new ChunkPaletteFormat(schema38, true));
        Schema schema39 = builder.addSchema(1451, 2, V1451_2::new);
        builder.addFixer(new PistonPushedBlock(schema39, true));
        Schema schema40 = builder.addSchema(1451, 3, V1451_3::new);
        builder.addFixer(new BlockStateFlatternEntities(schema40, true));
        builder.addFixer(new ItemFilledMapMetadata(schema40, false));
        Schema schema41 = builder.addSchema(1451, 4, V1451_4::new);
        builder.addFixer(new BlockNameFlattening(schema41, true));
        builder.addFixer(new ItemStackDataFlattening(schema41, false));
        Schema schema42 = builder.addSchema(1451, 5, V1451_5::new);
        builder.addFixer(new AddNewChoices(schema42, "RemoveNoteBlockFlowerPotFix", TypeReferences.BLOCK_ENTITY));
        builder.addFixer(new ItemSpawnEggSplit(schema42, false));
        builder.addFixer(new WolfCollarColor(schema42, false));
        builder.addFixer(new BlockEntityBannerColor(schema42, false));
        builder.addFixer(new BlockStateFlattenGenOptions(schema42, false));
        Schema schema43 = builder.addSchema(1451, 6, V1451_6::new);
        builder.addFixer(new StatsRenaming(schema43, true));
        builder.addFixer(new JukeboxRecordItem(schema43, false));
        Schema schema44 = builder.addSchema(1451, 7, V1451_7::new);
        builder.addFixer(new BlockStateFlattenVillageCrops(schema44, true));
        Schema schema45 = builder.addSchema(1451, 7, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new VillagerTrades(schema45, false));
        Schema schema46 = builder.addSchema(1456, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new EntityItemFrameFacing(schema46, false));
        Schema schema47 = builder.addSchema(1458, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new CustomNameStringToComponentEntity(schema47, false));
        builder.addFixer(new CustomNameStringToComponentItem(schema47, false));
        builder.addFixer(new CustomNameStringToComponentFixTileEntity(schema47, false));
        Schema schema48 = builder.addSchema(1460, V1460::new);
        builder.addFixer(new PaintingMotive(schema48, false));
        Schema schema49 = builder.addSchema(1466, V1466::new);
        builder.addFixer(new ChunkGenStatus(schema49, true));
        Schema schema50 = builder.addSchema(1470, V1470::new);
        builder.addFixer(new AddNewChoices(schema50, "Add 1.13 entities fix", TypeReferences.ENTITY));
        Schema schema51 = builder.addSchema(1474, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new ColorlessShulkerEntityFix(schema51, false));
        builder.addFixer(BlockRename.create(schema51, "Colorless shulker block fixer", (p_207106_0_) ->
        {
            return Objects.equals(NamespacedSchema.ensureNamespaced(p_207106_0_), "minecraft:purple_shulker_box") ? "minecraft:shulker_box" : p_207106_0_;
        }));
        builder.addFixer(ItemRename.create(schema51, "Colorless shulker item fixer", (p_207101_0_) ->
        {
            return Objects.equals(NamespacedSchema.ensureNamespaced(p_207101_0_), "minecraft:purple_shulker_box") ? "minecraft:shulker_box" : p_207101_0_;
        }));
        Schema schema52 = builder.addSchema(1475, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(BlockRename.create(schema52, "Flowing fixer", (p_207100_0_) ->
        {
            return ImmutableMap.of("minecraft:flowing_water", "minecraft:water", "minecraft:flowing_lava", "minecraft:lava").getOrDefault(p_207100_0_, p_207100_0_);
        }));
        Schema schema53 = builder.addSchema(1480, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(BlockRename.create(schema53, "Rename coral blocks", (p_207104_0_) ->
        {
            return RenamedCoral.field_204918_a.getOrDefault(p_207104_0_, p_207104_0_);
        }));
        builder.addFixer(ItemRename.create(schema53, "Rename coral items", (p_207103_0_) ->
        {
            return RenamedCoral.field_204918_a.getOrDefault(p_207103_0_, p_207103_0_);
        }));
        Schema schema54 = builder.addSchema(1481, V1481::new);
        builder.addFixer(new AddNewChoices(schema54, "Add conduit", TypeReferences.BLOCK_ENTITY));
        Schema schema55 = builder.addSchema(1483, V1483::new);
        builder.addFixer(new PufferfishRename(schema55, true));
        builder.addFixer(ItemRename.create(schema55, "Rename pufferfish egg item", (p_207552_0_) ->
        {
            return PufferfishRename.field_207461_a.getOrDefault(p_207552_0_, p_207552_0_);
        }));
        Schema schema56 = builder.addSchema(1484, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(ItemRename.create(schema56, "Rename seagrass items", (p_209172_0_) ->
        {
            return ImmutableMap.of("minecraft:sea_grass", "minecraft:seagrass", "minecraft:tall_sea_grass", "minecraft:tall_seagrass").getOrDefault(p_209172_0_, p_209172_0_);
        }));
        builder.addFixer(BlockRename.create(schema56, "Rename seagrass blocks", (p_209168_0_) ->
        {
            return ImmutableMap.of("minecraft:sea_grass", "minecraft:seagrass", "minecraft:tall_sea_grass", "minecraft:tall_seagrass").getOrDefault(p_209168_0_, p_209168_0_);
        }));
        builder.addFixer(new HeightmapRenamingFix(schema56, false));
        Schema schema57 = builder.addSchema(1486, V1486::new);
        builder.addFixer(new EntityCodSalmonFix(schema57, true));
        builder.addFixer(ItemRename.create(schema57, "Rename cod/salmon egg items", (p_207551_0_) ->
        {
            return EntityCodSalmonFix.field_209759_b.getOrDefault(p_207551_0_, p_207551_0_);
        }));
        Schema schema58 = builder.addSchema(1487, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(ItemRename.create(schema58, "Rename prismarine_brick(s)_* blocks", (p_207547_0_) ->
        {
            return ImmutableMap.of("minecraft:prismarine_bricks_slab", "minecraft:prismarine_brick_slab", "minecraft:prismarine_bricks_stairs", "minecraft:prismarine_brick_stairs").getOrDefault(p_207547_0_, p_207547_0_);
        }));
        builder.addFixer(BlockRename.create(schema58, "Rename prismarine_brick(s)_* items", (p_207546_0_) ->
        {
            return ImmutableMap.of("minecraft:prismarine_bricks_slab", "minecraft:prismarine_brick_slab", "minecraft:prismarine_bricks_stairs", "minecraft:prismarine_brick_stairs").getOrDefault(p_207546_0_, p_207546_0_);
        }));
        Schema schema59 = builder.addSchema(1488, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(BlockRename.create(schema59, "Rename kelp/kelptop", (p_207549_0_) ->
        {
            return ImmutableMap.of("minecraft:kelp_top", "minecraft:kelp", "minecraft:kelp", "minecraft:kelp_plant").getOrDefault(p_207549_0_, p_207549_0_);
        }));
        builder.addFixer(ItemRename.create(schema59, "Rename kelptop", (p_207548_0_) ->
        {
            return Objects.equals(p_207548_0_, "minecraft:kelp_top") ? "minecraft:kelp" : p_207548_0_;
        }));
        builder.addFixer(new NamedEntityFix(schema59, false, "Command block block entity custom name fix", TypeReferences.BLOCK_ENTITY, "minecraft:command_block")
        {
            protected Typed<?> fix(Typed<?> p_207419_1_)
            {
                return p_207419_1_.update(DSL.remainderFinder(), CustomNameStringToComponentEntity::fixTagCustomName);
            }
        });
        builder.addFixer(new NamedEntityFix(schema59, false, "Command block minecart custom name fix", TypeReferences.ENTITY, "minecraft:commandblock_minecart")
        {
            protected Typed<?> fix(Typed<?> p_207419_1_)
            {
                return p_207419_1_.update(DSL.remainderFinder(), CustomNameStringToComponentEntity::fixTagCustomName);
            }
        });
        builder.addFixer(new IglooMetadataRemoval(schema59, false));
        Schema schema60 = builder.addSchema(1490, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(BlockRename.create(schema60, "Rename melon_block", (p_207808_0_) ->
        {
            return Objects.equals(p_207808_0_, "minecraft:melon_block") ? "minecraft:melon" : p_207808_0_;
        }));
        builder.addFixer(ItemRename.create(schema60, "Rename melon_block/melon/speckled_melon", (p_207807_0_) ->
        {
            return ImmutableMap.of("minecraft:melon_block", "minecraft:melon", "minecraft:melon", "minecraft:melon_slice", "minecraft:speckled_melon", "minecraft:glistering_melon_slice").getOrDefault(p_207807_0_, p_207807_0_);
        }));
        Schema schema61 = builder.addSchema(1492, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new ChunkStructuresTemplateRenameFix(schema61, false));
        Schema schema62 = builder.addSchema(1494, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new ItemStackEnchantmentFix(schema62, false));
        Schema schema63 = builder.addSchema(1496, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new LeavesFix(schema63, false));
        Schema schema64 = builder.addSchema(1500, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new BlockEntityKeepPacked(schema64, false));
        Schema schema65 = builder.addSchema(1501, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new AdvancementRenamer1501(schema65, false));
        Schema schema66 = builder.addSchema(1502, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new RecipeRenamer1502(schema66, false));
        Schema schema67 = builder.addSchema(1506, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new LevelDataGeneratorOptionsFix(schema67, false));
        Schema schema68 = builder.addSchema(1508, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new BiomeRenames(schema68, false));
        Schema schema69 = builder.addSchema(1510, V1510::new);
        builder.addFixer(BlockRename.create(schema69, "Block renamening fix", (p_209169_0_) ->
        {
            return EntityRenaming1510.BLOCK_RENAME_MAP.getOrDefault(p_209169_0_, p_209169_0_);
        }));
        builder.addFixer(ItemRename.create(schema69, "Item renamening fix", (p_210900_0_) ->
        {
            return EntityRenaming1510.ITEM_RENAME_MAP.getOrDefault(p_210900_0_, p_210900_0_);
        }));
        builder.addFixer(new RecipeRenamer1510(schema69, false));
        builder.addFixer(new EntityRenaming1510(schema69, true));
        builder.addFixer(new SwimStatsRename(schema69, false));
        Schema schema70 = builder.addSchema(1514, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new ObjectiveDisplayName(schema70, false));
        builder.addFixer(new TeamDisplayName(schema70, false));
        builder.addFixer(new ObjectiveRenderType(schema70, false));
        Schema schema71 = builder.addSchema(1515, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(BlockRename.create(schema71, "Rename coral fan blocks", (p_211924_0_) ->
        {
            return CoralFansRenameList.field_211870_a.getOrDefault(p_211924_0_, p_211924_0_);
        }));
        Schema schema72 = builder.addSchema(1624, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new TrappedChestTileEntitySplit(schema72, false));
        Schema schema73 = builder.addSchema(1800, V1800::new);
        builder.addFixer(new AddNewChoices(schema73, "Added 1.14 mobs fix", TypeReferences.ENTITY));
        builder.addFixer(ItemRename.create(schema73, "Rename dye items", (p_219813_0_) ->
        {
            return DyeRenameMap.field_219828_a.getOrDefault(p_219813_0_, p_219813_0_);
        }));
        Schema schema74 = builder.addSchema(1801, V1801::new);
        builder.addFixer(new AddNewChoices(schema74, "Added Illager Beast", TypeReferences.ENTITY));
        Schema schema75 = builder.addSchema(1802, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(BlockRename.create(schema75, "Rename sign blocks & stone slabs", (p_219812_0_) ->
        {
            return ImmutableMap.of("minecraft:stone_slab", "minecraft:smooth_stone_slab", "minecraft:sign", "minecraft:oak_sign", "minecraft:wall_sign", "minecraft:oak_wall_sign").getOrDefault(p_219812_0_, p_219812_0_);
        }));
        builder.addFixer(ItemRename.create(schema75, "Rename sign item & stone slabs", (p_219815_0_) ->
        {
            return ImmutableMap.of("minecraft:stone_slab", "minecraft:smooth_stone_slab", "minecraft:sign", "minecraft:oak_sign").getOrDefault(p_219815_0_, p_219815_0_);
        }));
        Schema schema76 = builder.addSchema(1803, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new ItemLoreComponentizeFix(schema76, false));
        Schema schema77 = builder.addSchema(1904, V1904::new);
        builder.addFixer(new AddNewChoices(schema77, "Added Cats", TypeReferences.ENTITY));
        builder.addFixer(new EntityCatSplitFix(schema77, false));
        Schema schema78 = builder.addSchema(1905, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new ChunkStatusFix(schema78, false));
        Schema schema79 = builder.addSchema(1906, V1906::new);
        builder.addFixer(new AddNewChoices(schema79, "Add POI Blocks", TypeReferences.BLOCK_ENTITY));
        Schema schema80 = builder.addSchema(1909, V1909::new);
        builder.addFixer(new AddNewChoices(schema80, "Add jigsaw", TypeReferences.BLOCK_ENTITY));
        Schema schema81 = builder.addSchema(1911, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new ChunkStatusFix2(schema81, false));
        Schema schema82 = builder.addSchema(1917, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new CatTypeFix(schema82, false));
        Schema schema83 = builder.addSchema(1918, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new VillagerProfessionFix(schema83, "minecraft:villager"));
        builder.addFixer(new VillagerProfessionFix(schema83, "minecraft:zombie_villager"));
        Schema schema84 = builder.addSchema(1920, V1920::new);
        builder.addFixer(new NewVillageFix(schema84, false));
        builder.addFixer(new AddNewChoices(schema84, "Add campfire", TypeReferences.BLOCK_ENTITY));
        Schema schema85 = builder.addSchema(1925, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new MapIdFix(schema85, false));
        Schema schema86 = builder.addSchema(1928, V1928::new);
        builder.addFixer(new EntityRavagerRenameFix(schema86, true));
        builder.addFixer(ItemRename.create(schema86, "Rename ravager egg item", (p_219814_0_) ->
        {
            return EntityRavagerRenameFix.field_219829_a.getOrDefault(p_219814_0_, p_219814_0_);
        }));
        Schema schema87 = builder.addSchema(1929, V1929::new);
        builder.addFixer(new AddNewChoices(schema87, "Add Wandering Trader and Trader Llama", TypeReferences.ENTITY));
        Schema schema88 = builder.addSchema(1931, V1931::new);
        builder.addFixer(new AddNewChoices(schema88, "Added Fox", TypeReferences.ENTITY));
        Schema schema89 = builder.addSchema(1936, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new OptionsAddTextBackgroundFix(schema89, false));
        Schema schema90 = builder.addSchema(1946, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new PointOfInterestReorganizationFix(schema90, false));
        Schema schema91 = builder.addSchema(1948, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new OminousBannerRenameFix(schema91, false));
        Schema schema92 = builder.addSchema(1953, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new OminousBannerTileEntityRenameFix(schema92, false));
        Schema schema93 = builder.addSchema(1955, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new VillagerLevelAndXpFix(schema93, false));
        builder.addFixer(new ZombieVillagerXpFix(schema93, false));
        Schema schema94 = builder.addSchema(1961, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new ChunkLightRemoveFix(schema94, false));
        Schema schema95 = builder.addSchema(2100, V2100::new);
        builder.addFixer(new AddNewChoices(schema95, "Added Bee and Bee Stinger", TypeReferences.ENTITY));
        builder.addFixer(new AddNewChoices(schema95, "Add beehive", TypeReferences.BLOCK_ENTITY));
        builder.addFixer(new RecipeRenamer(schema95, false, "Rename sugar recipe", (p_230063_0_) ->
        {
            return "minecraft:sugar".equals(p_230063_0_) ? "sugar_from_sugar_cane" : p_230063_0_;
        }));
        builder.addFixer(new AdvancementRenamer(schema95, false, "Rename sugar recipe advancement", (p_230062_0_) ->
        {
            return "minecraft:recipes/misc/sugar".equals(p_230062_0_) ? "minecraft:recipes/misc/sugar_from_sugar_cane" : p_230062_0_;
        }));
        Schema schema96 = builder.addSchema(2202, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new BiomeIdFix(schema96, false));
        Schema schema97 = builder.addSchema(2209, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(ItemRename.create(schema97, "Rename bee_hive item to beehive", (p_226189_0_) ->
        {
            return Objects.equals(p_226189_0_, "minecraft:bee_hive") ? "minecraft:beehive" : p_226189_0_;
        }));
        builder.addFixer(new RenameBeehivePointOfInterest(schema97));
        builder.addFixer(BlockRename.create(schema97, "Rename bee_hive block to beehive", (p_226188_0_) ->
        {
            return ImmutableMap.of("minecraft:bee_hive", "minecraft:beehive").getOrDefault(p_226188_0_, p_226188_0_);
        }));
        Schema schema98 = builder.addSchema(2211, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new StructureReferenceFix(schema98, false));
        Schema schema99 = builder.addSchema(2218, NAMESPACED_SCHEMA_FACTORY);
        builder.addFixer(new PointOfInterestRebuild(schema99, false));
    }
}
