// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import net.minecraft.entity.EntityType;

import java.util.function.Consumer;

public class Class5908 implements Consumer<Consumer<Class8863>>
{
    private static final Class3090[] field24289;
    private static final EntityType<?>[] field24290;
    
    @Override
    public void accept(final Consumer<Class8863> consumer) {
        final Class8863 method18014 = Class6056.method18001().method18005(Class7739.field31521, new Class2259("advancements.adventure.root.title", new Object[0]), new Class2259("advancements.adventure.root.description", new Object[0]), new Class1932("textures/gui/advancements/backgrounds/adventure.png"), Class1993.field11162, false, false, false).method18011(Class6526.field25976).method18009("killed_something", Class4233.method12729()).method18009("killed_by_something", Class4233.method12731()).method18014(consumer, "adventure/root");
        this.method17762(Class6056.method18001()).method18002(Class6056.method18001().method18002(method18014).method18005(Class7521.field29235, new Class2259("advancements.adventure.sleep_in_bed.title", new Object[0]), new Class2259("advancements.adventure.sleep_in_bed.description", new Object[0]), null, Class1993.field11162, true, true, false).method18009("slept_in_bed", Class4217.method12696()).method18014(consumer, "adventure/sleep_in_bed")).method18005(Class7739.field31332, new Class2259("advancements.adventure.adventuring_time.title", new Object[0]), new Class2259("advancements.adventure.adventuring_time.description", new Object[0]), null, Class1993.field11163, true, true, false).method18007(Class6467.method19353(500)).method18014(consumer, "adventure/adventuring_time");
        final Class8863 method18015 = Class6056.method18001().method18002(method18014).method18005(Class7739.field31514, new Class2259("advancements.adventure.trade.title", new Object[0]), new Class2259("advancements.adventure.trade.description", new Object[0]), null, Class1993.field11162, true, true, false).method18009("traded", Class4212.method12684()).method18014(consumer, "adventure/trade");
        final Class8863 method18016 = this.method17761(Class6056.method18001()).method18002(method18014).method18005(Class7739.field31286, new Class2259("advancements.adventure.kill_a_mob.title", new Object[0]), new Class2259("advancements.adventure.kill_a_mob.description", new Object[0]), null, Class1993.field11162, true, true, false).method18011(Class6526.field25976).method18014(consumer, "adventure/kill_a_mob");
        this.method17761(Class6056.method18001()).method18002(method18016).method18005(Class7739.field31295, new Class2259("advancements.adventure.kill_all_mobs.title", new Object[0]), new Class2259("advancements.adventure.kill_all_mobs.description", new Object[0]), null, Class1993.field11163, true, true, false).method18007(Class6467.method19353(100)).method18014(consumer, "adventure/kill_all_mobs");
        final Class8863 method18017 = Class6056.method18001().method18002(method18016).method18005(Class7739.field31279, new Class2259("advancements.adventure.shoot_arrow.title", new Object[0]), new Class2259("advancements.adventure.shoot_arrow.description", new Object[0]), null, Class1993.field11162, true, true, false).method18009("shot_arrow", Class4213.method12686(Class9504.method35394().method35396(Class8135.method26811().method26812(true).method26814(Class5754.method17068().method17070(Class8039.field33102))))).method18014(consumer, "adventure/shoot_arrow");
        Class6056.method18001().method18002(Class6056.method18001().method18002(method18016).method18005(Class7739.field31607, new Class2259("advancements.adventure.throw_trident.title", new Object[0]), new Class2259("advancements.adventure.throw_trident.description", new Object[0]), null, Class1993.field11162, true, true, false).method18009("shot_trident", Class4213.method12686(Class9504.method35394().method35396(Class8135.method26811().method26812(true).method26814(Class5754.method17068().method17069(EntityType.field29040))))).method18014(consumer, "adventure/throw_trident")).method18005(Class7739.field31607, new Class2259("advancements.adventure.very_very_frightening.title", new Object[0]), new Class2259("advancements.adventure.very_very_frightening.description", new Object[0]), null, Class1993.field11162, true, true, false).method18009("struck_villager", Class4238.method12741(Class5754.method17068().method17069(EntityType.field29042).method17082())).method18014(consumer, "adventure/very_very_frightening");
        Class6056.method18001().method18002(method18015).method18005(Class7521.field29342, new Class2259("advancements.adventure.summon_iron_golem.title", new Object[0]), new Class2259("advancements.adventure.summon_iron_golem.description", new Object[0]), null, Class1993.field11164, true, true, false).method18009("summoned_golem", Class4216.method12693(Class5754.method17068().method17069(EntityType.field29043))).method18014(consumer, "adventure/summon_iron_golem");
        Class6056.method18001().method18002(method18017).method18005(Class7739.field31280, new Class2259("advancements.adventure.sniper_duel.title", new Object[0]), new Class2259("advancements.adventure.sniper_duel.description", new Object[0]), null, Class1993.field11163, true, true, false).method18007(Class6467.method19353(50)).method18009("killed_skeleton", Class4233.method12730(Class5754.method17068().method17069(EntityType.field29023).method17073(Class8817.method30755(Class8683.method29735(50.0f))), Class8135.method26811().method26812(true))).method18014(consumer, "adventure/sniper_duel");
        Class6056.method18001().method18002(method18016).method18005(Class7739.field31590, new Class2259("advancements.adventure.totem_of_undying.title", new Object[0]), new Class2259("advancements.adventure.totem_of_undying.description", new Object[0]), null, Class1993.field11164, true, true, false).method18009("used_totem", Class4229.method12720(Class7739.field31590)).method18014(consumer, "adventure/totem_of_undying");
        final Class8863 method18018 = Class6056.method18001().method18002(method18014).method18005(Class7739.field31611, new Class2259("advancements.adventure.ol_betsy.title", new Object[0]), new Class2259("advancements.adventure.ol_betsy.description", new Object[0]), null, Class1993.field11162, true, true, false).method18009("shot_crossbow", Class4215.method12691(Class7739.field31611)).method18014(consumer, "adventure/ol_betsy");
        Class6056.method18001().method18002(method18018).method18005(Class7739.field31611, new Class2259("advancements.adventure.whos_the_pillager_now.title", new Object[0]), new Class2259("advancements.adventure.whos_the_pillager_now.description", new Object[0]), null, Class1993.field11162, true, true, false).method18009("kill_pillager", Class4210.method12679(Class5754.method17068().method17069(EntityType.field29045))).method18014(consumer, "adventure/whos_the_pillager_now");
        Class6056.method18001().method18002(method18018).method18005(Class7739.field31611, new Class2259("advancements.adventure.two_birds_one_arrow.title", new Object[0]), new Class2259("advancements.adventure.two_birds_one_arrow.description", new Object[0]), null, Class1993.field11163, true, true, false).method18007(Class6467.method19353(65)).method18009("two_birds", Class4210.method12679(Class5754.method17068().method17069(EntityType.field29055), Class5754.method17068().method17069(EntityType.field29055))).method18014(consumer, "adventure/two_birds_one_arrow");
        Class6056.method18001().method18002(method18018).method18005(Class7739.field31611, new Class2259("advancements.adventure.arbalistic.title", new Object[0]), new Class2259("advancements.adventure.arbalistic.description", new Object[0]), null, Class1993.field11163, true, true, true).method18007(Class6467.method19353(85)).method18009("arbalistic", Class4210.method12680(Class8685.method29753(5))).method18014(consumer, "adventure/arbalistic");
        Class6056.method18001().method18002(Class6056.method18001().method18002(method18014).method18004(Class8792.method30651(), new Class2259("advancements.adventure.voluntary_exile.title", new Object[0]), new Class2259("advancements.adventure.voluntary_exile.description", new Object[0]), null, Class1993.field11162, true, true, true).method18009("voluntary_exile", Class4233.method12728(Class5754.method17068().method17070(Class8039.field33100).method17078(Class6969.field27250))).method18014(consumer, "adventure/voluntary_exile")).method18004(Class8792.method30651(), new Class2259("advancements.adventure.hero_of_the_village.title", new Object[0]), new Class2259("advancements.adventure.hero_of_the_village.description", new Object[0]), null, Class1993.field11163, true, true, true).method18007(Class6467.method19353(100)).method18009("hero_of_the_village", Class4217.method12697()).method18014(consumer, "adventure/hero_of_the_village");
        Class6056.method18001().method18002(method18014).method18005(Class7521.field29825.method11704(), new Class2259("advancements.adventure.honey_block_slide.title", new Object[0]), new Class2259("advancements.adventure.honey_block_slide.description", new Object[0]), null, Class1993.field11162, true, true, false).method18009("honey_block_slide", Class4234.method12733(Class7521.field29825)).method18014(consumer, "adventure/honey_block_slide");
    }
    
    private Class6056 method17761(final Class6056 class6056) {
        for (final EntityType<?> class6057 : Class5908.field24290) {
            class6056.method18009(Class90.field210.method503(class6057).toString(), Class4233.method12728(Class5754.method17068().method17069(class6057)));
        }
        return class6056;
    }
    
    private Class6056 method17762(final Class6056 class6056) {
        for (final Class3090 class6057 : Class5908.field24289) {
            class6056.method18009(Class90.field217.method503(class6057).toString(), Class4217.method12695(Class8697.method29808(class6057)));
        }
        return class6056;
    }
    
    static {
        field24289 = new Class3090[] { Class7102.field27660, Class7102.field27639, Class7102.field27638, Class7102.field27634, Class7102.field27650, Class7102.field27665, Class7102.field27662, Class7102.field27669, Class7102.field27636, Class7102.field27657, Class7102.field27644, Class7102.field27651, Class7102.field27645, Class7102.field27670, Class7102.field27667, Class7102.field27633, Class7102.field27643, Class7102.field27664, Class7102.field27658, Class7102.field27654, Class7102.field27655, Class7102.field27647, Class7102.field27635, Class7102.field27649, Class7102.field27653, Class7102.field27648, Class7102.field27668, Class7102.field27663, Class7102.field27671, Class7102.field27661, Class7102.field27637, Class7102.field27659, Class7102.field27646, Class7102.field27666, Class7102.field27676, Class7102.field27677, Class7102.field27678, Class7102.field27680, Class7102.field27681, Class7102.field27682, Class7102.field27705, Class7102.field27706 };
        field24290 = new EntityType[] { EntityType.field28965, EntityType.field29030, EntityType.field29014, EntityType.field28977, EntityType.field28962, EntityType.field28969, EntityType.field28980, EntityType.field28986, EntityType.field28988, EntityType.field28990, EntityType.field28998, EntityType.field29020, EntityType.field29022, EntityType.field29023, EntityType.field29025, EntityType.field29032, EntityType.field29044, EntityType.field29047, EntityType.field29049, EntityType.field29052, EntityType.field29054, EntityType.field29055, EntityType.field28973, EntityType.field29045, EntityType.field29056 };
    }
}
