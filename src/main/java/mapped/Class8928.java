package mapped;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Util;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class Class8928 {
   private static String[] field40406;
   private static final Map<Block, RenderType> field40407 = Util.<Map<Block, RenderType>>make(Maps.newHashMap(), var0 -> {
      RenderType var3 = RenderType.method14343();
      var0.put(Blocks.TRIPWIRE, var3);
      RenderType var4 = RenderType.method14301();
      var0.put(Blocks.GRASS_BLOCK, var4);
      var0.put(Blocks.IRON_BARS, var4);
      var0.put(Blocks.GLASS_PANE, var4);
      var0.put(Blocks.TRIPWIRE_HOOK, var4);
      var0.put(Blocks.HOPPER, var4);
      var0.put(Blocks.CHAIN, var4);
      var0.put(Blocks.JUNGLE_LEAVES, var4);
      var0.put(Blocks.OAK_LEAVES, var4);
      var0.put(Blocks.SPRUCE_LEAVES, var4);
      var0.put(Blocks.ACACIA_LEAVES, var4);
      var0.put(Blocks.BIRCH_LEAVES, var4);
      var0.put(Blocks.DARK_OAK_LEAVES, var4);
      RenderType var5 = RenderType.method14302();
      var0.put(Blocks.OAK_SAPLING, var5);
      var0.put(Blocks.SPRUCE_SAPLING, var5);
      var0.put(Blocks.BIRCH_SAPLING, var5);
      var0.put(Blocks.JUNGLE_SAPLING, var5);
      var0.put(Blocks.ACACIA_SAPLING, var5);
      var0.put(Blocks.DARK_OAK_SAPLING, var5);
      var0.put(Blocks.GLASS, var5);
      var0.put(Blocks.WHITE_BED, var5);
      var0.put(Blocks.ORANGE_BED, var5);
      var0.put(Blocks.MAGENTA_BED, var5);
      var0.put(Blocks.LIGHT_BLUE_BED, var5);
      var0.put(Blocks.YELLOW_BED, var5);
      var0.put(Blocks.LIME_BED, var5);
      var0.put(Blocks.PINK_BED, var5);
      var0.put(Blocks.GRAY_BED, var5);
      var0.put(Blocks.LIGHT_GRAY_BED, var5);
      var0.put(Blocks.CYAN_BED, var5);
      var0.put(Blocks.PURPLE_BED, var5);
      var0.put(Blocks.BLUE_BED, var5);
      var0.put(Blocks.BROWN_RED, var5);
      var0.put(Blocks.GREEN_BED, var5);
      var0.put(Blocks.RED_BED, var5);
      var0.put(Blocks.BLACK_BED, var5);
      var0.put(Blocks.POWERED_RAIL, var5);
      var0.put(Blocks.DETECTOR_RAIL, var5);
      var0.put(Blocks.COBWEB, var5);
      var0.put(Blocks.GRASS, var5);
      var0.put(Blocks.FERN, var5);
      var0.put(Blocks.DEAD_BUSH, var5);
      var0.put(Blocks.SEAGRASS, var5);
      var0.put(Blocks.TALL_SEAGRASS, var5);
      var0.put(Blocks.DANDELION, var5);
      var0.put(Blocks.POPPY, var5);
      var0.put(Blocks.BLUE_ORCHID, var5);
      var0.put(Blocks.ALLIUM, var5);
      var0.put(Blocks.AZURE_BLUET, var5);
      var0.put(Blocks.RED_TULIP, var5);
      var0.put(Blocks.ORANGE_TULIP, var5);
      var0.put(Blocks.WHITE_TULIP, var5);
      var0.put(Blocks.PINK_TULIP, var5);
      var0.put(Blocks.OXEYE_DAISY, var5);
      var0.put(Blocks.CORNFLOWER, var5);
      var0.put(Blocks.WITHER_ROSE, var5);
      var0.put(Blocks.LILY_OF_THE_VALLEY, var5);
      var0.put(Blocks.BROWN_MUSHROOM, var5);
      var0.put(Blocks.RED_MUSHROOM, var5);
      var0.put(Blocks.TORCH, var5);
      var0.put(Blocks.WALL_TORCH, var5);
      var0.put(Blocks.SOUL_TORCH, var5);
      var0.put(Blocks.SOUL_WALL_TORCH, var5);
      var0.put(Blocks.FIRE, var5);
      var0.put(Blocks.SOUL_FIRE, var5);
      var0.put(Blocks.SPAWNER, var5);
      var0.put(Blocks.REDSTONE_WIRE, var5);
      var0.put(Blocks.WHEAT, var5);
      var0.put(Blocks.OAK_DOOR, var5);
      var0.put(Blocks.LADDER, var5);
      var0.put(Blocks.RAIL, var5);
      var0.put(Blocks.IRON_DOOR, var5);
      var0.put(Blocks.REDSTONE_TORCH, var5);
      var0.put(Blocks.REDSTONE_WALL_TORCH, var5);
      var0.put(Blocks.CACTUS, var5);
      var0.put(Blocks.SUGAR_CANE, var5);
      var0.put(Blocks.REPEATER, var5);
      var0.put(Blocks.OAK_TRAPDOOR, var5);
      var0.put(Blocks.SPRUCE_TRAPDOOR, var5);
      var0.put(Blocks.BIRCH_TRAPDOOR, var5);
      var0.put(Blocks.JUNGLE_TRAPDOOR, var5);
      var0.put(Blocks.ACACIA_TRAPDOOR, var5);
      var0.put(Blocks.DARK_OAK_TRAPDOOR, var5);
      var0.put(Blocks.CRIMSON_TRAPDOOR, var5);
      var0.put(Blocks.WARPED_TRAPDOOR, var5);
      var0.put(Blocks.ATTACHED_PUMPKIN_STEM, var5);
      var0.put(Blocks.ATTACHED_MELON_STEM, var5);
      var0.put(Blocks.PUMPKIN_STEM, var5);
      var0.put(Blocks.MELON_STEM, var5);
      var0.put(Blocks.VINE, var5);
      var0.put(Blocks.LILY_PAD, var5);
      var0.put(Blocks.NETHER_WART, var5);
      var0.put(Blocks.BREWING_STAND, var5);
      var0.put(Blocks.COCOA, var5);
      var0.put(Blocks.BEACON, var5);
      var0.put(Blocks.FLOWER_POT, var5);
      var0.put(Blocks.POTTED_OAK_SAPLING, var5);
      var0.put(Blocks.POTTED_SPRUCE_SAPLING, var5);
      var0.put(Blocks.POTTED_BIRCH_SAPLING, var5);
      var0.put(Blocks.POTTED_JUNGLE_SAPLING, var5);
      var0.put(Blocks.POTTED_ACACIA_SAPLING, var5);
      var0.put(Blocks.POTTED_DARK_OAK_SAPLING, var5);
      var0.put(Blocks.POTTED_FERN, var5);
      var0.put(Blocks.POTTED_DANDELION, var5);
      var0.put(Blocks.POTTED_POPPY, var5);
      var0.put(Blocks.POTTED_BLUE_ORCHID, var5);
      var0.put(Blocks.POTTED_ALLIUM, var5);
      var0.put(Blocks.POTTED_AZURE_BLUET, var5);
      var0.put(Blocks.POTTED_RED_TULIP, var5);
      var0.put(Blocks.POTTED_ORANGE_TULIP, var5);
      var0.put(Blocks.POTTED_WHITE_TULIP, var5);
      var0.put(Blocks.POTTED_PINK_TULIP, var5);
      var0.put(Blocks.POTTED_OXEYE_DAISY, var5);
      var0.put(Blocks.POTTED_CORNFLOWER, var5);
      var0.put(Blocks.POTTED_LILY_OF_THE_VALLEY, var5);
      var0.put(Blocks.POTTED_WITHER_ROSE, var5);
      var0.put(Blocks.POTTED_RED_MUSHROOM, var5);
      var0.put(Blocks.POTTED_BROWN_MUSHROOM, var5);
      var0.put(Blocks.POTTED_DEAD_BUSH, var5);
      var0.put(Blocks.POTTED_CACTUS, var5);
      var0.put(Blocks.CARROTS, var5);
      var0.put(Blocks.POTATOES, var5);
      var0.put(Blocks.COMPARATOR, var5);
      var0.put(Blocks.ACTIVATOR_RAIL, var5);
      var0.put(Blocks.IRON_TRAPDOOR, var5);
      var0.put(Blocks.SUNFLOWER, var5);
      var0.put(Blocks.LILAC, var5);
      var0.put(Blocks.ROSE_BUSH, var5);
      var0.put(Blocks.PEONY, var5);
      var0.put(Blocks.TALL_GRASS, var5);
      var0.put(Blocks.LARGE_FERN, var5);
      var0.put(Blocks.SPRUCE_DOOR, var5);
      var0.put(Blocks.BIRCH_DOOR, var5);
      var0.put(Blocks.JUNGLE_DOOR, var5);
      var0.put(Blocks.ACACIA_DOOR, var5);
      var0.put(Blocks.DARK_OAK_DOOR, var5);
      var0.put(Blocks.END_ROD, var5);
      var0.put(Blocks.CHORUS_PLANT, var5);
      var0.put(Blocks.CHORUS_FLOWER, var5);
      var0.put(Blocks.BEETROOTS, var5);
      var0.put(Blocks.KELP, var5);
      var0.put(Blocks.KELP_PLANT, var5);
      var0.put(Blocks.TURTLE_EGG, var5);
      var0.put(Blocks.DEAD_TUBE_CORAL, var5);
      var0.put(Blocks.DEAD_BRAIN_CORAL, var5);
      var0.put(Blocks.DEAD_BUBBLE_CORAL, var5);
      var0.put(Blocks.DEAD_FIRE_CORAL, var5);
      var0.put(Blocks.DEAD_HORN_CORAL, var5);
      var0.put(Blocks.TUBE_CORAL, var5);
      var0.put(Blocks.BRAIN_CORAL, var5);
      var0.put(Blocks.BUBBLE_CORAL, var5);
      var0.put(Blocks.FIRE_CORAL, var5);
      var0.put(Blocks.HORN_CORAL, var5);
      var0.put(Blocks.DEAD_TUBE_CORAL_FAN, var5);
      var0.put(Blocks.DEAD_BRAIN_CORAL_FAN, var5);
      var0.put(Blocks.DEAD_BUBBLE_CORAL_FAN, var5);
      var0.put(Blocks.DEAD_FIRE_CORAL_FAN, var5);
      var0.put(Blocks.DEAD_HORN_CORAL_FAN, var5);
      var0.put(Blocks.TUBE_CORAL_FAN, var5);
      var0.put(Blocks.BRAIN_CORAL_FAN, var5);
      var0.put(Blocks.BUBBLE_CORAL_FAN, var5);
      var0.put(Blocks.FIRE_CORAL_FAN, var5);
      var0.put(Blocks.HORN_CORAL_FAN, var5);
      var0.put(Blocks.DEAD_TUBE_CORAL_WALL_FAN, var5);
      var0.put(Blocks.DEAD_BRAIN_CORAL_WALL_FAN, var5);
      var0.put(Blocks.DEAD_BUBBLE_CORAL_WALL_FAN, var5);
      var0.put(Blocks.DEAD_FIRE_CORAL_WALL_FAN, var5);
      var0.put(Blocks.DEAD_HORN_CORAL_WALL_FAN, var5);
      var0.put(Blocks.TUBE_CORAL_WALL_FAN, var5);
      var0.put(Blocks.BRAIN_CORAL_WALL_FAN, var5);
      var0.put(Blocks.BUBBLE_CORAL_WALL_FAN, var5);
      var0.put(Blocks.FIRE_CORAL_WALL_FAN, var5);
      var0.put(Blocks.HORN_CORAL_WALL_FAN, var5);
      var0.put(Blocks.SEA_PICKLE, var5);
      var0.put(Blocks.CONDUIT, var5);
      var0.put(Blocks.BAMBOO_SAPLING, var5);
      var0.put(Blocks.BAMBOO, var5);
      var0.put(Blocks.POTTED_BAMBOO, var5);
      var0.put(Blocks.SCAFFOLDING, var5);
      var0.put(Blocks.STONECUTTER, var5);
      var0.put(Blocks.LANTERN, var5);
      var0.put(Blocks.SOUL_LANTERN, var5);
      var0.put(Blocks.CAMPFIRE, var5);
      var0.put(Blocks.SOUL_CAMPFIRE, var5);
      var0.put(Blocks.SWEET_BERRY_BUSH, var5);
      var0.put(Blocks.WEEPING_VINES, var5);
      var0.put(Blocks.WEEPING_VINES_PLANT, var5);
      var0.put(Blocks.TWISTING_VINES, var5);
      var0.put(Blocks.TWISTING_VINES_PLANT, var5);
      var0.put(Blocks.NETHER_SPROUTS, var5);
      var0.put(Blocks.CRIMSON_FUNGUS, var5);
      var0.put(Blocks.WARPED_FUNGUS, var5);
      var0.put(Blocks.CRIMSON_ROOTS, var5);
      var0.put(Blocks.WARPED_ROOTS, var5);
      var0.put(Blocks.POTTED_CRIMSON_FUNGUS, var5);
      var0.put(Blocks.POTTED_WARPED_FUNGUS, var5);
      var0.put(Blocks.POTTED_CRIMSON_ROOTS, var5);
      var0.put(Blocks.POTTED_WARPED_ROOTS, var5);
      var0.put(Blocks.CRIMSON_DOOR, var5);
      var0.put(Blocks.WARPED_DOOR, var5);
      RenderType var6 = RenderType.method14304();
      var0.put(Blocks.ICE, var6);
      var0.put(Blocks.NETHER_PORTAL, var6);
      var0.put(Blocks.WHITE_STAINED_GLASS, var6);
      var0.put(Blocks.ORANGE_STAINED_GLASS, var6);
      var0.put(Blocks.MAGENTA_STAINED_GLASS, var6);
      var0.put(Blocks.LIGHT_BLUE_STAINED_GLASS, var6);
      var0.put(Blocks.YELLOW_STAINED_GLASS, var6);
      var0.put(Blocks.LIME_STAINED_GLASS, var6);
      var0.put(Blocks.PINK_STAINED_GLASS, var6);
      var0.put(Blocks.GRAY_STAINED_GLASS, var6);
      var0.put(Blocks.LIGHT_GRAY_STAINED_GLASS, var6);
      var0.put(Blocks.CYAN_STAINED_GLASS, var6);
      var0.put(Blocks.PURPLE_STAINED_GLASS, var6);
      var0.put(Blocks.BLUE_STAINED_GLASS, var6);
      var0.put(Blocks.BROWN_STAINED_GLASS, var6);
      var0.put(Blocks.GREEN_STAINED_GLASS, var6);
      var0.put(Blocks.RED_STAINED_GLASS, var6);
      var0.put(Blocks.BLACK_STAINED_GLASS, var6);
      var0.put(Blocks.WHITE_STAINED_GLASS_PANE, var6);
      var0.put(Blocks.ORANGE_STAINED_GLASS_PANE, var6);
      var0.put(Blocks.MAGENTA_STAINED_GLASS_PANE, var6);
      var0.put(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, var6);
      var0.put(Blocks.YELLOW_STAINED_GLASS_PANE, var6);
      var0.put(Blocks.LIME_STAINED_GLASS_PANE, var6);
      var0.put(Blocks.PINK_STAINED_GLASS_PANE, var6);
      var0.put(Blocks.GRAY_STAINED_GLASS_PANE, var6);
      var0.put(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, var6);
      var0.put(Blocks.CYAN_STAINED_GLASS_PANE, var6);
      var0.put(Blocks.PURPLE_STAINED_GLASS_PANE, var6);
      var0.put(Blocks.BLUE_STAINED_GLASS_PANE, var6);
      var0.put(Blocks.BROWN_STAINED_GLASS_PANE, var6);
      var0.put(Blocks.GREEN_STAINED_GLASS_PANE, var6);
      var0.put(Blocks.RED_STAINED_GLASS_PANE, var6);
      var0.put(Blocks.BLACK_STAINED_GLASS_PANE, var6);
      var0.put(Blocks.SLIME_BLOCK, var6);
      var0.put(Blocks.HONEY_BLOCK, var6);
      var0.put(Blocks.FROSTED_ICE, var6);
      var0.put(Blocks.BUBBLE_COLUMN, var6);
   });
   private static final Map<Fluid, RenderType> field40408 = Util.<Map<Fluid, RenderType>>make(Maps.newHashMap(), var0 -> {
      RenderType var3 = RenderType.method14304();
      var0.put(Fluids.FLOWING_WATER, var3);
      var0.put(Fluids.WATER, var3);
   });
   private static boolean field40409;

   public static RenderType method32630(BlockState var0) {
      Block var3 = var0.getBlock();
      if (!(var3 instanceof LeavesBlock)) {
         RenderType var4 = field40407.get(var3);
         return var4 == null ? RenderType.method14300() : var4;
      } else {
         return !field40409 ? RenderType.method14300() : RenderType.method14301();
      }
   }

   public static RenderType method32631(BlockState var0) {
      Block var3 = var0.getBlock();
      if (!(var3 instanceof LeavesBlock)) {
         RenderType var4 = field40407.get(var3);
         if (var4 == null) {
            return RenderType.method14300();
         } else {
            return var4 != RenderType.method14304() ? var4 : RenderType.method14306();
         }
      } else {
         return !field40409 ? RenderType.method14300() : RenderType.method14301();
      }
   }

   public static RenderType method32632(BlockState var0, boolean var1) {
      RenderType var4 = method32630(var0);
      if (var4 != RenderType.method14304()) {
         return Class8624.method30907();
      } else if (Minecraft.isFabulousGraphicsEnabled()) {
         return !var1 ? Class8624.method30908() : Class8624.method30909();
      } else {
         return Class8624.method30909();
      }
   }

   public static RenderType method32633(ItemStack var0, boolean var1) {
      Item var4 = var0.getItem();
      if (!(var4 instanceof BlockItem)) {
         return !var1 ? Class8624.method30908() : Class8624.method30909();
      } else {
         Block var5 = ((BlockItem)var4).method11845();
         return method32632(var5.getDefaultState(), var1);
      }
   }

   public static RenderType method32634(FluidState var0) {
      RenderType var3 = field40408.get(var0.getFluid());
      return var3 == null ? RenderType.method14300() : var3;
   }

   public static void method32635(boolean var0) {
      field40409 = var0;
   }
}
