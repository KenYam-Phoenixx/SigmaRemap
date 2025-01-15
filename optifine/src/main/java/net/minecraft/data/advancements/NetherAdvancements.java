package net.minecraft.data.advancements;

import java.util.function.Consumer;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.criterion.BrewedPotionTrigger;
import net.minecraft.advancements.criterion.ChangeDimensionTrigger;
import net.minecraft.advancements.criterion.ConstructBeaconTrigger;
import net.minecraft.advancements.criterion.DamageSourcePredicate;
import net.minecraft.advancements.criterion.DistancePredicate;
import net.minecraft.advancements.criterion.EffectsChangedTrigger;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.KilledTrigger;
import net.minecraft.advancements.criterion.LocationPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.advancements.criterion.MobEffectsPredicate;
import net.minecraft.advancements.criterion.NetherTravelTrigger;
import net.minecraft.advancements.criterion.PositionTrigger;
import net.minecraft.advancements.criterion.SummonedEntityTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.feature.Feature;

public class NetherAdvancements implements Consumer<Consumer<Advancement>>
{
    public void accept(Consumer<Advancement> p_accept_1_)
    {
        Advancement advancement = Advancement.Builder.builder().withDisplay(Blocks.RED_NETHER_BRICKS, new TranslationTextComponent("advancements.nether.root.title"), new TranslationTextComponent("advancements.nether.root.description"), new ResourceLocation("textures/gui/advancements/backgrounds/nether.png"), FrameType.TASK, false, false, false).withCriterion("entered_nether", ChangeDimensionTrigger.Instance.changedDimensionTo(DimensionType.THE_NETHER)).register(p_accept_1_, "nether/root");
        Advancement advancement1 = Advancement.Builder.builder().withParent(advancement).withDisplay(Items.FIRE_CHARGE, new TranslationTextComponent("advancements.nether.return_to_sender.title"), new TranslationTextComponent("advancements.nether.return_to_sender.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).withRewards(AdvancementRewards.Builder.experience(50)).withCriterion("killed_ghast", KilledTrigger.Instance.playerKilledEntity(EntityPredicate.Builder.create().type(EntityType.GHAST), DamageSourcePredicate.Builder.damageType().isProjectile(true).direct(EntityPredicate.Builder.create().type(EntityType.FIREBALL)))).register(p_accept_1_, "nether/return_to_sender");
        Advancement advancement2 = Advancement.Builder.builder().withParent(advancement).withDisplay(Blocks.NETHER_BRICKS, new TranslationTextComponent("advancements.nether.find_fortress.title"), new TranslationTextComponent("advancements.nether.find_fortress.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("fortress", PositionTrigger.Instance.forLocation(LocationPredicate.forFeature(Feature.NETHER_BRIDGE))).register(p_accept_1_, "nether/find_fortress");
        Advancement advancement3 = Advancement.Builder.builder().withParent(advancement).withDisplay(Items.MAP, new TranslationTextComponent("advancements.nether.fast_travel.title"), new TranslationTextComponent("advancements.nether.fast_travel.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).withRewards(AdvancementRewards.Builder.experience(100)).withCriterion("travelled", NetherTravelTrigger.Instance.forDistance(DistancePredicate.forHorizontal(MinMaxBounds.FloatBound.atLeast(7000.0F)))).register(p_accept_1_, "nether/fast_travel");
        Advancement advancement4 = Advancement.Builder.builder().withParent(advancement1).withDisplay(Items.GHAST_TEAR, new TranslationTextComponent("advancements.nether.uneasy_alliance.title"), new TranslationTextComponent("advancements.nether.uneasy_alliance.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).withRewards(AdvancementRewards.Builder.experience(100)).withCriterion("killed_ghast", KilledTrigger.Instance.playerKilledEntity(EntityPredicate.Builder.create().type(EntityType.GHAST).location(LocationPredicate.forDimension(DimensionType.OVERWORLD)))).register(p_accept_1_, "nether/uneasy_alliance");
        Advancement advancement5 = Advancement.Builder.builder().withParent(advancement2).withDisplay(Blocks.WITHER_SKELETON_SKULL, new TranslationTextComponent("advancements.nether.get_wither_skull.title"), new TranslationTextComponent("advancements.nether.get_wither_skull.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("wither_skull", InventoryChangeTrigger.Instance.forItems(Blocks.WITHER_SKELETON_SKULL)).register(p_accept_1_, "nether/get_wither_skull");
        Advancement advancement6 = Advancement.Builder.builder().withParent(advancement5).withDisplay(Items.NETHER_STAR, new TranslationTextComponent("advancements.nether.summon_wither.title"), new TranslationTextComponent("advancements.nether.summon_wither.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("summoned", SummonedEntityTrigger.Instance.summonedEntity(EntityPredicate.Builder.create().type(EntityType.WITHER))).register(p_accept_1_, "nether/summon_wither");
        Advancement advancement7 = Advancement.Builder.builder().withParent(advancement2).withDisplay(Items.BLAZE_ROD, new TranslationTextComponent("advancements.nether.obtain_blaze_rod.title"), new TranslationTextComponent("advancements.nether.obtain_blaze_rod.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("blaze_rod", InventoryChangeTrigger.Instance.forItems(Items.BLAZE_ROD)).register(p_accept_1_, "nether/obtain_blaze_rod");
        Advancement advancement8 = Advancement.Builder.builder().withParent(advancement6).withDisplay(Blocks.BEACON, new TranslationTextComponent("advancements.nether.create_beacon.title"), new TranslationTextComponent("advancements.nether.create_beacon.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("beacon", ConstructBeaconTrigger.Instance.forLevel(MinMaxBounds.IntBound.atLeast(1))).register(p_accept_1_, "nether/create_beacon");
        Advancement advancement9 = Advancement.Builder.builder().withParent(advancement8).withDisplay(Blocks.BEACON, new TranslationTextComponent("advancements.nether.create_full_beacon.title"), new TranslationTextComponent("advancements.nether.create_full_beacon.description"), (ResourceLocation)null, FrameType.GOAL, true, true, false).withCriterion("beacon", ConstructBeaconTrigger.Instance.forLevel(MinMaxBounds.IntBound.exactly(4))).register(p_accept_1_, "nether/create_full_beacon");
        Advancement advancement10 = Advancement.Builder.builder().withParent(advancement7).withDisplay(Items.POTION, new TranslationTextComponent("advancements.nether.brew_potion.title"), new TranslationTextComponent("advancements.nether.brew_potion.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).withCriterion("potion", BrewedPotionTrigger.Instance.brewedPotion()).register(p_accept_1_, "nether/brew_potion");
        Advancement advancement11 = Advancement.Builder.builder().withParent(advancement10).withDisplay(Items.MILK_BUCKET, new TranslationTextComponent("advancements.nether.all_potions.title"), new TranslationTextComponent("advancements.nether.all_potions.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).withRewards(AdvancementRewards.Builder.experience(100)).withCriterion("all_effects", EffectsChangedTrigger.Instance.forEffect(MobEffectsPredicate.any().addEffect(Effects.SPEED).addEffect(Effects.SLOWNESS).addEffect(Effects.STRENGTH).addEffect(Effects.JUMP_BOOST).addEffect(Effects.REGENERATION).addEffect(Effects.FIRE_RESISTANCE).addEffect(Effects.WATER_BREATHING).addEffect(Effects.INVISIBILITY).addEffect(Effects.NIGHT_VISION).addEffect(Effects.WEAKNESS).addEffect(Effects.POISON).addEffect(Effects.SLOW_FALLING).addEffect(Effects.RESISTANCE))).register(p_accept_1_, "nether/all_potions");
        Advancement advancement12 = Advancement.Builder.builder().withParent(advancement11).withDisplay(Items.BUCKET, new TranslationTextComponent("advancements.nether.all_effects.title"), new TranslationTextComponent("advancements.nether.all_effects.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, true).withRewards(AdvancementRewards.Builder.experience(1000)).withCriterion("all_effects", EffectsChangedTrigger.Instance.forEffect(MobEffectsPredicate.any().addEffect(Effects.SPEED).addEffect(Effects.SLOWNESS).addEffect(Effects.STRENGTH).addEffect(Effects.JUMP_BOOST).addEffect(Effects.REGENERATION).addEffect(Effects.FIRE_RESISTANCE).addEffect(Effects.WATER_BREATHING).addEffect(Effects.INVISIBILITY).addEffect(Effects.NIGHT_VISION).addEffect(Effects.WEAKNESS).addEffect(Effects.POISON).addEffect(Effects.WITHER).addEffect(Effects.HASTE).addEffect(Effects.MINING_FATIGUE).addEffect(Effects.LEVITATION).addEffect(Effects.GLOWING).addEffect(Effects.ABSORPTION).addEffect(Effects.HUNGER).addEffect(Effects.NAUSEA).addEffect(Effects.RESISTANCE).addEffect(Effects.SLOW_FALLING).addEffect(Effects.CONDUIT_POWER).addEffect(Effects.DOLPHINS_GRACE).addEffect(Effects.BLINDNESS).addEffect(Effects.BAD_OMEN).addEffect(Effects.HERO_OF_THE_VILLAGE))).register(p_accept_1_, "nether/all_effects");
    }
}
