package mapped;

import com.google.common.collect.Maps;
import com.mojang.datafixers.DSL;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.templates.TypeTemplate;
import com.mojang.datafixers.types.templates.Hook.HookFunction;
import net.minecraft.util.datafix.TypeReferences;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Class3655 extends Class3639 {
   public Class3655(int var1, Schema var2) {
      super(var1, var2);
   }

   public static void method12413(Schema var0, Map<String, Supplier<TypeTemplate>> var1, String var2) {
      var0.register(var1, var2, () -> Class9674.method37738(var0));
   }

   public static void method12414(Schema var0, Map<String, Supplier<TypeTemplate>> var1, String var2) {
      var0.register(var1, var2, () -> DSL.optionalFields("Items", DSL.list(TypeReferences.ITEM_STACK.in(var0))));
   }

   public Map<String, Supplier<TypeTemplate>> registerEntities(Schema var1) {
      HashMap var4 = Maps.newHashMap();
      var1.registerSimple(var4, "minecraft:area_effect_cloud");
      method12413(var1, var4, "minecraft:armor_stand");
      var1.register(var4, "minecraft:arrow", var1x -> DSL.optionalFields("inBlockState", TypeReferences.BLOCK_STATE.in(var1)));
      method12413(var1, var4, "minecraft:bat");
      method12413(var1, var4, "minecraft:blaze");
      var1.registerSimple(var4, "minecraft:boat");
      method12413(var1, var4, "minecraft:cave_spider");
      var1.register(
         var4,
         "minecraft:chest_minecart",
         var1x -> DSL.optionalFields("DisplayState", TypeReferences.BLOCK_STATE.in(var1), "Items", DSL.list(TypeReferences.ITEM_STACK.in(var1)))
      );
      method12413(var1, var4, "minecraft:chicken");
      var1.register(var4, "minecraft:commandblock_minecart", var1x -> DSL.optionalFields("DisplayState", TypeReferences.BLOCK_STATE.in(var1)));
      method12413(var1, var4, "minecraft:cow");
      method12413(var1, var4, "minecraft:creeper");
      var1.register(
         var4,
         "minecraft:donkey",
         var1x -> DSL.optionalFields("Items", DSL.list(TypeReferences.ITEM_STACK.in(var1)), "SaddleItem", TypeReferences.ITEM_STACK.in(var1), Class9674.method37738(var1))
      );
      var1.registerSimple(var4, "minecraft:dragon_fireball");
      var1.registerSimple(var4, "minecraft:egg");
      method12413(var1, var4, "minecraft:elder_guardian");
      var1.registerSimple(var4, "minecraft:ender_crystal");
      method12413(var1, var4, "minecraft:ender_dragon");
      var1.register(var4, "minecraft:enderman", var1x -> DSL.optionalFields("carriedBlockState", TypeReferences.BLOCK_STATE.in(var1), Class9674.method37738(var1)));
      method12413(var1, var4, "minecraft:endermite");
      var1.registerSimple(var4, "minecraft:ender_pearl");
      var1.registerSimple(var4, "minecraft:evocation_fangs");
      method12413(var1, var4, "minecraft:evocation_illager");
      var1.registerSimple(var4, "minecraft:eye_of_ender_signal");
      var1.register(
         var4,
         "minecraft:falling_block",
         var1x -> DSL.optionalFields("BlockState", TypeReferences.BLOCK_STATE.in(var1), "TileEntityData", TypeReferences.BLOCK_ENTITY.in(var1))
      );
      var1.registerSimple(var4, "minecraft:fireball");
      var1.register(var4, "minecraft:fireworks_rocket", var1x -> DSL.optionalFields("FireworksItem", TypeReferences.ITEM_STACK.in(var1)));
      var1.register(var4, "minecraft:furnace_minecart", var1x -> DSL.optionalFields("DisplayState", TypeReferences.BLOCK_STATE.in(var1)));
      method12413(var1, var4, "minecraft:ghast");
      method12413(var1, var4, "minecraft:giant");
      method12413(var1, var4, "minecraft:guardian");
      var1.register(
         var4,
         "minecraft:hopper_minecart",
         var1x -> DSL.optionalFields("DisplayState", TypeReferences.BLOCK_STATE.in(var1), "Items", DSL.list(TypeReferences.ITEM_STACK.in(var1)))
      );
      var1.register(
         var4,
         "minecraft:horse",
         var1x -> DSL.optionalFields("ArmorItem", TypeReferences.ITEM_STACK.in(var1), "SaddleItem", TypeReferences.ITEM_STACK.in(var1), Class9674.method37738(var1))
      );
      method12413(var1, var4, "minecraft:husk");
      var1.registerSimple(var4, "minecraft:illusion_illager");
      var1.register(var4, "minecraft:item", var1x -> DSL.optionalFields("Item", TypeReferences.ITEM_STACK.in(var1)));
      var1.register(var4, "minecraft:item_frame", var1x -> DSL.optionalFields("Item", TypeReferences.ITEM_STACK.in(var1)));
      var1.registerSimple(var4, "minecraft:leash_knot");
      var1.register(
         var4,
         "minecraft:llama",
         var1x -> DSL.optionalFields(
               "Items",
               DSL.list(TypeReferences.ITEM_STACK.in(var1)),
               "SaddleItem",
               TypeReferences.ITEM_STACK.in(var1),
               "DecorItem",
               TypeReferences.ITEM_STACK.in(var1),
               Class9674.method37738(var1)
            )
      );
      var1.registerSimple(var4, "minecraft:llama_spit");
      method12413(var1, var4, "minecraft:magma_cube");
      var1.register(var4, "minecraft:minecart", var1x -> DSL.optionalFields("DisplayState", TypeReferences.BLOCK_STATE.in(var1)));
      method12413(var1, var4, "minecraft:mooshroom");
      var1.register(
         var4,
         "minecraft:mule",
         var1x -> DSL.optionalFields("Items", DSL.list(TypeReferences.ITEM_STACK.in(var1)), "SaddleItem", TypeReferences.ITEM_STACK.in(var1), Class9674.method37738(var1))
      );
      method12413(var1, var4, "minecraft:ocelot");
      var1.registerSimple(var4, "minecraft:painting");
      var1.registerSimple(var4, "minecraft:parrot");
      method12413(var1, var4, "minecraft:pig");
      method12413(var1, var4, "minecraft:polar_bear");
      var1.register(var4, "minecraft:potion", var1x -> DSL.optionalFields("Potion", TypeReferences.ITEM_STACK.in(var1)));
      method12413(var1, var4, "minecraft:rabbit");
      method12413(var1, var4, "minecraft:sheep");
      method12413(var1, var4, "minecraft:shulker");
      var1.registerSimple(var4, "minecraft:shulker_bullet");
      method12413(var1, var4, "minecraft:silverfish");
      method12413(var1, var4, "minecraft:skeleton");
      var1.register(var4, "minecraft:skeleton_horse", var1x -> DSL.optionalFields("SaddleItem", TypeReferences.ITEM_STACK.in(var1), Class9674.method37738(var1)));
      method12413(var1, var4, "minecraft:slime");
      var1.registerSimple(var4, "minecraft:small_fireball");
      var1.registerSimple(var4, "minecraft:snowball");
      method12413(var1, var4, "minecraft:snowman");
      var1.register(
         var4, "minecraft:spawner_minecart", var1x -> DSL.optionalFields("DisplayState", TypeReferences.BLOCK_STATE.in(var1), TypeReferences.UNTAGGED_SPAWNER.in(var1))
      );
      var1.register(var4, "minecraft:spectral_arrow", var1x -> DSL.optionalFields("inBlockState", TypeReferences.BLOCK_STATE.in(var1)));
      method12413(var1, var4, "minecraft:spider");
      method12413(var1, var4, "minecraft:squid");
      method12413(var1, var4, "minecraft:stray");
      var1.registerSimple(var4, "minecraft:tnt");
      var1.register(var4, "minecraft:tnt_minecart", var1x -> DSL.optionalFields("DisplayState", TypeReferences.BLOCK_STATE.in(var1)));
      method12413(var1, var4, "minecraft:vex");
      var1.register(
         var4,
         "minecraft:villager",
         var1x -> DSL.optionalFields(
               "Inventory",
               DSL.list(TypeReferences.ITEM_STACK.in(var1)),
               "Offers",
               DSL.optionalFields(
                  "Recipes",
                  DSL.list(
                     DSL.optionalFields("buy", TypeReferences.ITEM_STACK.in(var1), "buyB", TypeReferences.ITEM_STACK.in(var1), "sell", TypeReferences.ITEM_STACK.in(var1))
                  )
               ),
               Class9674.method37738(var1)
            )
      );
      method12413(var1, var4, "minecraft:villager_golem");
      method12413(var1, var4, "minecraft:vindication_illager");
      method12413(var1, var4, "minecraft:witch");
      method12413(var1, var4, "minecraft:wither");
      method12413(var1, var4, "minecraft:wither_skeleton");
      var1.registerSimple(var4, "minecraft:wither_skull");
      method12413(var1, var4, "minecraft:wolf");
      var1.registerSimple(var4, "minecraft:xp_bottle");
      var1.registerSimple(var4, "minecraft:xp_orb");
      method12413(var1, var4, "minecraft:zombie");
      var1.register(var4, "minecraft:zombie_horse", var1x -> DSL.optionalFields("SaddleItem", TypeReferences.ITEM_STACK.in(var1), Class9674.method37738(var1)));
      method12413(var1, var4, "minecraft:zombie_pigman");
      method12413(var1, var4, "minecraft:zombie_villager");
      return var4;
   }

   public Map<String, Supplier<TypeTemplate>> registerBlockEntities(Schema var1) {
      HashMap var4 = Maps.newHashMap();
      method12414(var1, var4, "minecraft:furnace");
      method12414(var1, var4, "minecraft:chest");
      method12414(var1, var4, "minecraft:trapped_chest");
      var1.registerSimple(var4, "minecraft:ender_chest");
      var1.register(var4, "minecraft:jukebox", var1x -> DSL.optionalFields("RecordItem", TypeReferences.ITEM_STACK.in(var1)));
      method12414(var1, var4, "minecraft:dispenser");
      method12414(var1, var4, "minecraft:dropper");
      var1.registerSimple(var4, "minecraft:sign");
      var1.register(var4, "minecraft:mob_spawner", var1x -> TypeReferences.UNTAGGED_SPAWNER.in(var1));
      var1.register(var4, "minecraft:piston", var1x -> DSL.optionalFields("blockState", TypeReferences.BLOCK_STATE.in(var1)));
      method12414(var1, var4, "minecraft:brewing_stand");
      var1.registerSimple(var4, "minecraft:enchanting_table");
      var1.registerSimple(var4, "minecraft:end_portal");
      var1.registerSimple(var4, "minecraft:beacon");
      var1.registerSimple(var4, "minecraft:skull");
      var1.registerSimple(var4, "minecraft:daylight_detector");
      method12414(var1, var4, "minecraft:hopper");
      var1.registerSimple(var4, "minecraft:comparator");
      var1.registerSimple(var4, "minecraft:banner");
      var1.registerSimple(var4, "minecraft:structure_block");
      var1.registerSimple(var4, "minecraft:end_gateway");
      var1.registerSimple(var4, "minecraft:command_block");
      method12414(var1, var4, "minecraft:shulker_box");
      var1.registerSimple(var4, "minecraft:bed");
      return var4;
   }

   public void registerTypes(Schema var1, Map<String, Supplier<TypeTemplate>> var2, Map<String, Supplier<TypeTemplate>> var3) {
      var1.registerType(false, TypeReferences.LEVEL, DSL::remainder);
      var1.registerType(false, TypeReferences.RECIPE, () -> DSL.constType(method12354()));
      var1.registerType(
         false,
         TypeReferences.PLAYER,
         () -> DSL.optionalFields(
               "RootVehicle",
               DSL.optionalFields("Entity", TypeReferences.ENTITY_TREE.in(var1)),
               "Inventory",
               DSL.list(TypeReferences.ITEM_STACK.in(var1)),
               "EnderItems",
               DSL.list(TypeReferences.ITEM_STACK.in(var1)),
               DSL.optionalFields(
                  "ShoulderEntityLeft",
                  TypeReferences.ENTITY_TREE.in(var1),
                  "ShoulderEntityRight",
                  TypeReferences.ENTITY_TREE.in(var1),
                  "recipeBook",
                  DSL.optionalFields("recipes", DSL.list(TypeReferences.RECIPE.in(var1)), "toBeDisplayed", DSL.list(TypeReferences.RECIPE.in(var1)))
               )
            )
      );
      var1.registerType(
         false,
         TypeReferences.CHUNK,
         () -> DSL.fields(
               "Level",
               DSL.optionalFields(
                  "Entities",
                  DSL.list(TypeReferences.ENTITY_TREE.in(var1)),
                  "TileEntities",
                  DSL.list(TypeReferences.BLOCK_ENTITY.in(var1)),
                  "TileTicks",
                  DSL.list(DSL.fields("i", TypeReferences.BLOCK_NAME.in(var1))),
                  "Sections",
                  DSL.list(DSL.optionalFields("Palette", DSL.list(TypeReferences.BLOCK_STATE.in(var1))))
               )
            )
      );
      var1.registerType(true, TypeReferences.BLOCK_ENTITY, () -> DSL.taggedChoiceLazy("id", method12354(), var3));
      var1.registerType(
         true, TypeReferences.ENTITY_TREE, () -> DSL.optionalFields("Passengers", DSL.list(TypeReferences.ENTITY_TREE.in(var1)), TypeReferences.ENTITY.in(var1))
      );
      var1.registerType(true, TypeReferences.ENTITY, () -> DSL.taggedChoiceLazy("id", method12354(), var2));
      var1.registerType(
         true,
         TypeReferences.ITEM_STACK,
         () -> DSL.hook(
               DSL.optionalFields(
                  "id",
                  TypeReferences.ITEM_NAME.in(var1),
                  "tag",
                  DSL.optionalFields(
                     "EntityTag",
                     TypeReferences.ENTITY_TREE.in(var1),
                     "BlockEntityTag",
                     TypeReferences.BLOCK_ENTITY.in(var1),
                     "CanDestroy",
                     DSL.list(TypeReferences.BLOCK_NAME.in(var1)),
                     "CanPlaceOn",
                     DSL.list(TypeReferences.BLOCK_NAME.in(var1))
                  )
               ),
               Class3647.field19682,
               HookFunction.IDENTITY
            )
      );
      var1.registerType(false, TypeReferences.HOTBAR, () -> DSL.compoundList(DSL.list(TypeReferences.ITEM_STACK.in(var1))));
      var1.registerType(false, TypeReferences.OPTIONS, DSL::remainder);
      var1.registerType(
         false,
         TypeReferences.STRUCTURE,
         () -> DSL.optionalFields(
               "entities",
               DSL.list(DSL.optionalFields("nbt", TypeReferences.ENTITY_TREE.in(var1))),
               "blocks",
               DSL.list(DSL.optionalFields("nbt", TypeReferences.BLOCK_ENTITY.in(var1))),
               "palette",
               DSL.list(TypeReferences.BLOCK_STATE.in(var1))
            )
      );
      var1.registerType(false, TypeReferences.BLOCK_NAME, () -> DSL.constType(method12354()));
      var1.registerType(false, TypeReferences.ITEM_NAME, () -> DSL.constType(method12354()));
      var1.registerType(false, TypeReferences.BLOCK_STATE, DSL::remainder);
      Supplier var6 = () -> DSL.compoundList(TypeReferences.ITEM_NAME.in(var1), DSL.constType(DSL.intType()));
      var1.registerType(
         false,
         TypeReferences.STATS,
         () -> DSL.optionalFields(
               "stats",
               DSL.optionalFields(
                  "minecraft:mined",
                  DSL.compoundList(TypeReferences.BLOCK_NAME.in(var1), DSL.constType(DSL.intType())),
                  "minecraft:crafted",
                  (TypeTemplate)var6.get(),
                  "minecraft:used",
                  (TypeTemplate)var6.get(),
                  "minecraft:broken",
                  (TypeTemplate)var6.get(),
                  "minecraft:picked_up",
                  (TypeTemplate)var6.get(),
                  DSL.optionalFields(
                     "minecraft:dropped",
                     (TypeTemplate)var6.get(),
                     "minecraft:killed",
                     DSL.compoundList(TypeReferences.ENTITY_NAME.in(var1), DSL.constType(DSL.intType())),
                     "minecraft:killed_by",
                     DSL.compoundList(TypeReferences.ENTITY_NAME.in(var1), DSL.constType(DSL.intType())),
                     "minecraft:custom",
                     DSL.compoundList(DSL.constType(method12354()), DSL.constType(DSL.intType()))
                  )
               )
            )
      );
      var1.registerType(
         false,
         TypeReferences.SAVED_DATA,
         () -> DSL.optionalFields(
               "data",
               DSL.optionalFields(
                  "Features",
                  DSL.compoundList(TypeReferences.STRUCTURE_FEATURE.in(var1)),
                  "Objectives",
                  DSL.list(TypeReferences.OBJECTIVE.in(var1)),
                  "Teams",
                  DSL.list(TypeReferences.TEAM.in(var1))
               )
            )
      );
      var1.registerType(
         false,
         TypeReferences.STRUCTURE_FEATURE,
         () -> DSL.optionalFields(
               "Children",
               DSL.list(
                  DSL.optionalFields(
                     "CA",
                     TypeReferences.BLOCK_STATE.in(var1),
                     "CB",
                     TypeReferences.BLOCK_STATE.in(var1),
                     "CC",
                     TypeReferences.BLOCK_STATE.in(var1),
                     "CD",
                     TypeReferences.BLOCK_STATE.in(var1)
                  )
               )
            )
      );
      var1.registerType(false, TypeReferences.OBJECTIVE, DSL::remainder);
      var1.registerType(false, TypeReferences.TEAM, DSL::remainder);
      var1.registerType(
         true,
         TypeReferences.UNTAGGED_SPAWNER,
         () -> DSL.optionalFields("SpawnPotentials", DSL.list(DSL.fields("Entity", TypeReferences.ENTITY_TREE.in(var1))), "SpawnData", TypeReferences.ENTITY_TREE.in(var1))
      );
      var1.registerType(
         false,
         TypeReferences.ADVANCEMENTS,
         () -> DSL.optionalFields(
               "minecraft:adventure/adventuring_time",
               DSL.optionalFields("criteria", DSL.compoundList(TypeReferences.BIOME.in(var1), DSL.constType(DSL.string()))),
               "minecraft:adventure/kill_a_mob",
               DSL.optionalFields("criteria", DSL.compoundList(TypeReferences.ENTITY_NAME.in(var1), DSL.constType(DSL.string()))),
               "minecraft:adventure/kill_all_mobs",
               DSL.optionalFields("criteria", DSL.compoundList(TypeReferences.ENTITY_NAME.in(var1), DSL.constType(DSL.string()))),
               "minecraft:husbandry/bred_all_animals",
               DSL.optionalFields("criteria", DSL.compoundList(TypeReferences.ENTITY_NAME.in(var1), DSL.constType(DSL.string())))
            )
      );
      var1.registerType(false, TypeReferences.BIOME, () -> DSL.constType(method12354()));
      var1.registerType(false, TypeReferences.ENTITY_NAME, () -> DSL.constType(method12354()));
      var1.registerType(false, TypeReferences.POI_CHUNK, DSL::remainder);
      var1.registerType(true, TypeReferences.WORLD_GEN_SETTINGS, DSL::remainder);
   }
}
