package net.minecraft.entity.merchant.villager;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import mapped.*;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraft.util.Util;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.Map;

public class VillagerTrades {
   private static String[] field45413;
   public static final Map<Class8395, Int2ObjectMap<Class5391[]>> field45414 = Util.<Map<Class8395, Int2ObjectMap<Class5391[]>>>make(
      Maps.newHashMap(),
      var0 -> {
         var0.put(
            Class8395.field36016,
            method38080(
               ImmutableMap.of(
                  1,
                  new Class5391[]{
                     new Class5396(Items.field37842, 20, 16, 2),
                     new Class5396(Items.field38053, 26, 16, 2),
                     new Class5396(Items.field38052, 22, 16, 2),
                     new Class5396(Items.field38111, 15, 16, 2),
                     new Class5395(Items.field37843, 1, 6, 16, 1)
                  },
                  2,
                  new Class5391[]{
                     new Class5396(Blocks.PUMPKIN, 6, 12, 10),
                     new Class5395(Items.field38067, 1, 4, 5),
                     new Class5395(Items.APPLE, 1, 4, 16, 5)
                  },
                  3,
                  new Class5391[]{new Class5395(Items.field37954, 3, 18, 10), new Class5396(Blocks.MELON, 4, 12, 20)},
                  4,
                  new Class5391[]{
                     new Class5395(Blocks.CAKE, 1, 1, 12, 15),
                     new Class5393(Effects.NIGHT_VISION, 100, 15),
                     new Class5393(Effects.JUMP_BOOST, 160, 15),
                     new Class5393(Effects.WEAKNESS, 140, 15),
                     new Class5393(Effects.BLINDNESS, 120, 15),
                     new Class5393(Effects.POISON, 280, 15),
                     new Class5393(Effects.SATURATION, 7, 15)
                  },
                  5,
                  new Class5391[]{new Class5395(Items.field38057, 3, 3, 30), new Class5395(Items.field37980, 4, 3, 30)}
               )
            )
         );
         var0.put(
            Class8395.field36017,
            method38080(
               ImmutableMap.of(
                  1,
                  new Class5391[]{
                     new Class5396(Items.field37838, 20, 16, 2),
                     new Class5396(Items.field37798, 10, 16, 2),
                     new Class5397(Items.field37909, 6, Items.field37913, 6, 16, 1),
                     new Class5395(Items.field37894, 3, 1, 16, 1)
                  },
                  2,
                  new Class5391[]{
                     new Class5396(Items.field37909, 15, 16, 10),
                     new Class5397(Items.field37910, 6, Items.field37914, 6, 16, 5),
                     new Class5395(Items.field38171, 2, 1, 5)
                  },
                  3,
                  new Class5391[]{new Class5396(Items.field37910, 13, 16, 20), new Class5392(Items.field37906, 3, 3, 10, 0.2F)},
                  4,
                  new Class5391[]{new Class5396(Items.field37911, 6, 12, 30)},
                  5,
                  new Class5391[]{
                     new Class5396(Items.field37912, 4, 12, 30),
                     new Class5390(
                        1,
                        12,
                        30,
                        ImmutableMap.<Class9564, Item>builder()
                           .put(Class9564.field44542, Items.OAK_BOAT)
                           .put(Class9564.field44546, Items.field38121)
                           .put(Class9564.field44544, Items.field38121)
                           .put(Class9564.field44540, Items.field38123)
                           .put(Class9564.field44541, Items.field38123)
                           .put(Class9564.field44543, Items.field38124)
                           .put(Class9564.field44545, Items.field38125)
                           .build()
                     )
                  }
               )
            )
         );
         var0.put(
            Class8395.field36023,
            method38080(
               ImmutableMap.of(
                  1,
                  new Class5391[]{
                     new Class5396(Blocks.WHITE_WOOL, 18, 16, 2),
                     new Class5396(Blocks.BROWN_WOOL, 18, 16, 2),
                     new Class5396(Blocks.BLACK_WOOL, 18, 16, 2),
                     new Class5396(Blocks.GRAY_WOOL, 18, 16, 2),
                     new Class5395(Items.field37956, 2, 1, 1)
                  },
                  2,
                  new Class5391[]{
                     new Class5396(Items.field37918, 12, 16, 10),
                     new Class5396(Items.field37925, 12, 16, 10),
                     new Class5396(Items.field37933, 12, 16, 10),
                     new Class5396(Items.field37921, 12, 16, 10),
                     new Class5396(Items.field37923, 12, 16, 10),
                     new Class5395(Blocks.WHITE_WOOL, 1, 1, 16, 5),
                     new Class5395(Blocks.ORANGE_WOOL, 1, 1, 16, 5),
                     new Class5395(Blocks.MAGENTA_WOOL, 1, 1, 16, 5),
                     new Class5395(Blocks.LIGHT_BLUE_WOOL, 1, 1, 16, 5),
                     new Class5395(Blocks.YELLOW_WOOL, 1, 1, 16, 5),
                     new Class5395(Blocks.LIME_WOOL, 1, 1, 16, 5),
                     new Class5395(Blocks.PINK_WOOL, 1, 1, 16, 5),
                     new Class5395(Blocks.GRAY_WOOL, 1, 1, 16, 5),
                     new Class5395(Blocks.LIGHT_GRAY_WOOL, 1, 1, 16, 5),
                     new Class5395(Blocks.CYAN_WOOL, 1, 1, 16, 5),
                     new Class5395(Blocks.PURPLE_WOOL, 1, 1, 16, 5),
                     new Class5395(Blocks.BLUE_WOOL, 1, 1, 16, 5),
                     new Class5395(Blocks.BROWN_WOOL, 1, 1, 16, 5),
                     new Class5395(Blocks.GREEN_WOOL, 1, 1, 16, 5),
                     new Class5395(Blocks.RED_WOOL, 1, 1, 16, 5),
                     new Class5395(Blocks.BLACK_WOOL, 1, 1, 16, 5),
                     new Class5395(Blocks.WHITE_CARPET, 1, 4, 16, 5),
                     new Class5395(Blocks.ORANGE_CARPET, 1, 4, 16, 5),
                     new Class5395(Blocks.MAGENTA_CARPET, 1, 4, 16, 5),
                     new Class5395(Blocks.LIGHT_BLUE_CARPET, 1, 4, 16, 5),
                     new Class5395(Blocks.YELLOW_CARPET, 1, 4, 16, 5),
                     new Class5395(Blocks.LIME_CARPET, 1, 4, 16, 5),
                     new Class5395(Blocks.PINK_CARPET, 1, 4, 16, 5),
                     new Class5395(Blocks.GRAY_CARPET, 1, 4, 16, 5),
                     new Class5395(Blocks.LIGHT_GRAY_CARPET, 1, 4, 16, 5),
                     new Class5395(Blocks.CYAN_CARPET, 1, 4, 16, 5),
                     new Class5395(Blocks.PURPLE_CARPET, 1, 4, 16, 5),
                     new Class5395(Blocks.BLUE_CARPET, 1, 4, 16, 5),
                     new Class5395(Blocks.BROWN_CARPET, 1, 4, 16, 5),
                     new Class5395(Blocks.GREEN_CARPET, 1, 4, 16, 5),
                     new Class5395(Blocks.RED_CARPET, 1, 4, 16, 5),
                     new Class5395(Blocks.BLACK_CARPET, 1, 4, 16, 5)
                  },
                  3,
                  new Class5391[]{
                     new Class5396(Items.field37922, 12, 16, 20),
                     new Class5396(Items.field37926, 12, 16, 20),
                     new Class5396(Items.field37919, 12, 16, 20),
                     new Class5396(Items.field37932, 12, 16, 20),
                     new Class5396(Items.field37924, 12, 16, 20),
                     new Class5395(Blocks.WHITE_BED, 3, 1, 12, 10),
                     new Class5395(Blocks.YELLOW_BED, 3, 1, 12, 10),
                     new Class5395(Blocks.RED_BED, 3, 1, 12, 10),
                     new Class5395(Blocks.BLACK_BED, 3, 1, 12, 10),
                     new Class5395(Blocks.BLUE_BED, 3, 1, 12, 10),
                     new Class5395(Blocks.BROWN_RED, 3, 1, 12, 10),
                     new Class5395(Blocks.CYAN_BED, 3, 1, 12, 10),
                     new Class5395(Blocks.GRAY_BED, 3, 1, 12, 10),
                     new Class5395(Blocks.GREEN_BED, 3, 1, 12, 10),
                     new Class5395(Blocks.LIGHT_BLUE_BED, 3, 1, 12, 10),
                     new Class5395(Blocks.LIGHT_GRAY_BED, 3, 1, 12, 10),
                     new Class5395(Blocks.LIME_BED, 3, 1, 12, 10),
                     new Class5395(Blocks.MAGENTA_BED, 3, 1, 12, 10),
                     new Class5395(Blocks.ORANGE_BED, 3, 1, 12, 10),
                     new Class5395(Blocks.PINK_BED, 3, 1, 12, 10),
                     new Class5395(Blocks.PURPLE_BED, 3, 1, 12, 10)
                  },
                  4,
                  new Class5391[]{
                     new Class5396(Items.field37930, 12, 16, 30),
                     new Class5396(Items.field37928, 12, 16, 30),
                     new Class5396(Items.field37929, 12, 16, 30),
                     new Class5396(Items.field37931, 12, 16, 30),
                     new Class5396(Items.field37920, 12, 16, 30),
                     new Class5396(Items.field37927, 12, 16, 30),
                     new Class5395(Items.field38092, 3, 1, 12, 15),
                     new Class5395(Items.field38103, 3, 1, 12, 15),
                     new Class5395(Items.field38095, 3, 1, 12, 15),
                     new Class5395(Items.field38106, 3, 1, 12, 15),
                     new Class5395(Items.field38098, 3, 1, 12, 15),
                     new Class5395(Items.field38105, 3, 1, 12, 15),
                     new Class5395(Items.field38097, 3, 1, 12, 15),
                     new Class5395(Items.field38099, 3, 1, 12, 15),
                     new Class5395(Items.field38107, 3, 1, 12, 15),
                     new Class5395(Items.field38102, 3, 1, 12, 15),
                     new Class5395(Items.field38094, 3, 1, 12, 15),
                     new Class5395(Items.field38101, 3, 1, 12, 15),
                     new Class5395(Items.field38104, 3, 1, 12, 15),
                     new Class5395(Items.field38096, 3, 1, 12, 15),
                     new Class5395(Items.field38093, 3, 1, 12, 15),
                     new Class5395(Items.field38100, 3, 1, 12, 15)
                  },
                  5,
                  new Class5391[]{new Class5395(Items.PAINTING, 2, 3, 30)}
               )
            )
         );
         var0.put(
            Class8395.field36018,
            method38080(
               ImmutableMap.of(
                  1,
                  new Class5391[]{
                     new Class5396(Items.field37835, 32, 16, 2),
                     new Class5395(Items.field37797, 1, 16, 1),
                     new Class5397(Blocks.GRAVEL, 10, Items.field37868, 10, 12, 1)
                  },
                  2,
                  new Class5391[]{new Class5396(Items.field37868, 26, 12, 10), new Class5395(Items.BOW, 2, 1, 5)},
                  3,
                  new Class5391[]{new Class5396(Items.field37838, 14, 16, 20), new Class5395(Items.CROSSBOW, 3, 1, 10)},
                  4,
                  new Class5391[]{new Class5396(Items.field37839, 24, 16, 30), new Class5392(Items.BOW, 2, 3, 15)},
                  5,
                  new Class5391[]{
                     new Class5396(Items.field37500, 8, 12, 30),
                     new Class5392(Items.CROSSBOW, 3, 3, 15),
                     new Class5400(Items.field37797, 5, Items.field38117, 5, 2, 12, 30)
                  }
               )
            )
         );
         var0.put(
            Class8395.field36020,
            method38080(
               ImmutableMap.<Integer, Class5391[]>builder()
                  .put(1, new Class5391[]{new Class5396(Items.field37899, 24, 16, 2), new Class5399(1), new Class5395(Blocks.BOOKSHELF, 9, 1, 12, 1)})
                  .put(2, new Class5391[]{new Class5396(Items.field37900, 4, 12, 10), new Class5399(5), new Class5395(Items.field38168, 1, 1, 5)})
                  .put(3, new Class5391[]{new Class5396(Items.field37915, 5, 12, 20), new Class5399(10), new Class5395(Items.GLASS_BLOCK, 1, 4, 10)})
                  .put(
                     4,
                     new Class5391[]{
                        new Class5396(Items.field38047, 2, 12, 30),
                        new Class5399(15),
                        new Class5395(Items.field37907, 5, 1, 15),
                        new Class5395(Items.COMPASS, 4, 1, 15)
                     }
                  )
                  .put(5, new Class5391[]{new Class5395(Items.field38088, 20, 1, 30)})
                  .build()
            )
         );
         var0.put(
            Class8395.field36014,
            method38080(
               ImmutableMap.of(
                  1,
                  new Class5391[]{new Class5396(Items.field37899, 24, 16, 2), new Class5395(Items.field38056, 7, 1, 1)},
                  2,
                  new Class5391[]{new Class5396(Items.field37471, 11, 16, 10), new Class5398(13, Structure.MONUMENT, MapDecorationType.MONUMENT, 12, 5)},
                  3,
                  new Class5391[]{new Class5396(Items.COMPASS, 1, 12, 20), new Class5398(14, Structure.MANSION, MapDecorationType.MANSION, 12, 10)},
                  4,
                  new Class5391[]{
                     new Class5395(Items.ITEM_FRAME, 7, 1, 15),
                     new Class5395(Items.field38092, 3, 1, 15),
                     new Class5395(Items.field38103, 3, 1, 15),
                     new Class5395(Items.field38095, 3, 1, 15),
                     new Class5395(Items.field38106, 3, 1, 15),
                     new Class5395(Items.field38098, 3, 1, 15),
                     new Class5395(Items.field38105, 3, 1, 15),
                     new Class5395(Items.field38097, 3, 1, 15),
                     new Class5395(Items.field38099, 3, 1, 15),
                     new Class5395(Items.field38107, 3, 1, 15),
                     new Class5395(Items.field38102, 3, 1, 15),
                     new Class5395(Items.field38094, 3, 1, 15),
                     new Class5395(Items.field38101, 3, 1, 15),
                     new Class5395(Items.field38104, 3, 1, 15),
                     new Class5395(Items.field38096, 3, 1, 15),
                     new Class5395(Items.field38093, 3, 1, 15),
                     new Class5395(Items.field38100, 3, 1, 15)
                  },
                  5,
                  new Class5391[]{new Class5395(Items.field38155, 8, 1, 30)}
               )
            )
         );
         var0.put(
            Class8395.field36015,
            method38080(
               ImmutableMap.of(
                  1,
                  new Class5391[]{new Class5396(Items.field37965, 32, 16, 2), new Class5395(Items.REDSTONE_DUST, 1, 2, 1)},
                  2,
                  new Class5391[]{new Class5396(Items.field37802, 3, 12, 10), new Class5395(Items.field37917, 1, 1, 5)},
                  3,
                  new Class5391[]{new Class5396(Items.field38080, 2, 12, 20), new Class5395(Blocks.GLOWSTONE, 4, 1, 12, 10)},
                  4,
                  new Class5391[]{
                     new Class5396(Items.field37793, 4, 12, 30),
                     new Class5396(Items.field37972, 9, 12, 30),
                     new Class5395(Items.ENDER_PEARL, 5, 1, 15)
                  },
                  5,
                  new Class5391[]{new Class5396(Items.field37970, 22, 12, 30), new Class5395(Items.EXPERIENCE_BOTTLE, 3, 1, 30)}
               )
            )
         );
         var0.put(
            Class8395.field36012,
            method38080(
               ImmutableMap.of(
                  1,
                  new Class5391[]{
                     new Class5396(Items.field37798, 15, 16, 2),
                     new Class5395(new ItemStack(Items.field37854), 7, 1, 12, 1, 0.2F),
                     new Class5395(new ItemStack(Items.field37855), 4, 1, 12, 1, 0.2F),
                     new Class5395(new ItemStack(Items.field37852), 5, 1, 12, 1, 0.2F),
                     new Class5395(new ItemStack(Items.field37853), 9, 1, 12, 1, 0.2F)
                  },
                  2,
                  new Class5391[]{
                     new Class5396(Items.field37801, 4, 12, 10),
                     new Class5395(new ItemStack(Items.field38167), 36, 1, 12, 5, 0.2F),
                     new Class5395(new ItemStack(Items.field37851), 1, 1, 12, 5, 0.2F),
                     new Class5395(new ItemStack(Items.field37850), 3, 1, 12, 5, 0.2F)
                  },
                  3,
                  new Class5391[]{
                     new Class5396(Items.LAVA_BUCKET, 1, 12, 20),
                     new Class5396(Items.field37800, 1, 12, 20),
                     new Class5395(new ItemStack(Items.field37848), 1, 1, 12, 10, 0.2F),
                     new Class5395(new ItemStack(Items.field37849), 4, 1, 12, 10, 0.2F),
                     new Class5395(new ItemStack(Items.field38119), 5, 1, 12, 10, 0.2F)
                  },
                  4,
                  new Class5391[]{new Class5392(Items.field37858, 14, 3, 15, 0.2F), new Class5392(Items.field37859, 8, 3, 15, 0.2F)},
                  5,
                  new Class5391[]{new Class5392(Items.field37856, 8, 3, 30, 0.2F), new Class5392(Items.field37857, 16, 3, 30, 0.2F)}
               )
            )
         );
         var0.put(
            Class8395.field36025,
            method38080(
               ImmutableMap.of(
                  1,
                  new Class5391[]{
                     new Class5396(Items.field37798, 15, 16, 2),
                     new Class5395(new ItemStack(Items.IRON_AXE), 3, 1, 12, 1, 0.2F),
                     new Class5392(Items.field37820, 2, 3, 1)
                  },
                  2,
                  new Class5391[]{new Class5396(Items.field37801, 4, 12, 10), new Class5395(new ItemStack(Items.field38167), 36, 1, 12, 5, 0.2F)},
                  3,
                  new Class5391[]{new Class5396(Items.field37868, 24, 12, 20)},
                  4,
                  new Class5391[]{new Class5396(Items.field37800, 1, 12, 30), new Class5392(Items.field37828, 12, 3, 15, 0.2F)},
                  5,
                  new Class5391[]{new Class5392(Items.field37825, 8, 3, 30, 0.2F)}
               )
            )
         );
         var0.put(
            Class8395.field36024,
            method38080(
               ImmutableMap.of(
                  1,
                  new Class5391[]{
                     new Class5396(Items.field37798, 15, 16, 2),
                     new Class5395(new ItemStack(Items.field37813), 1, 1, 12, 1, 0.2F),
                     new Class5395(new ItemStack(Items.field37811), 1, 1, 12, 1, 0.2F),
                     new Class5395(new ItemStack(Items.field37812), 1, 1, 12, 1, 0.2F),
                     new Class5395(new ItemStack(Items.field37814), 1, 1, 12, 1, 0.2F)
                  },
                  2,
                  new Class5391[]{new Class5396(Items.field37801, 4, 12, 10), new Class5395(new ItemStack(Items.field38167), 36, 1, 12, 5, 0.2F)},
                  3,
                  new Class5391[]{
                     new Class5396(Items.field37868, 30, 12, 20),
                     new Class5392(Items.IRON_AXE, 1, 3, 10, 0.2F),
                     new Class5392(Items.IRON_SHOVEL, 2, 3, 10, 0.2F),
                     new Class5392(Items.field37822, 3, 3, 10, 0.2F),
                     new Class5395(new ItemStack(Items.field37829), 4, 1, 3, 10, 0.2F)
                  },
                  4,
                  new Class5391[]{
                     new Class5396(Items.field37800, 1, 12, 30),
                     new Class5392(Items.field37828, 12, 3, 15, 0.2F),
                     new Class5392(Items.field37826, 5, 3, 15, 0.2F)
                  },
                  5,
                  new Class5391[]{new Class5392(Items.field37827, 13, 3, 30, 0.2F)}
               )
            )
         );
         var0.put(
            Class8395.field36013,
            method38080(
               ImmutableMap.of(
                  1,
                  new Class5391[]{
                     new Class5396(Items.field37963, 14, 16, 2),
                     new Class5396(Items.PORKCHOP, 7, 16, 2),
                     new Class5396(Items.field38077, 4, 16, 2),
                     new Class5395(Items.field38079, 1, 1, 1)
                  },
                  2,
                  new Class5391[]{
                     new Class5396(Items.field37798, 15, 16, 2),
                     new Class5395(Items.field37870, 1, 5, 16, 5),
                     new Class5395(Items.field37964, 1, 8, 16, 5)
                  },
                  3,
                  new Class5391[]{new Class5396(Items.field38090, 7, 16, 20), new Class5396(Items.field37961, 10, 16, 20)},
                  4,
                  new Class5391[]{new Class5396(Items.field37898, 10, 12, 30)},
                  5,
                  new Class5391[]{new Class5396(Items.field38170, 10, 12, 30)}
               )
            )
         );
         var0.put(
            Class8395.field36019,
            method38080(
               ImmutableMap.of(
                  1,
                  new Class5391[]{
                     new Class5396(Items.LEATHER, 6, 16, 2), new Class5394(Items.field37846, 3), new Class5394(Items.field37845, 7)
                  },
                  2,
                  new Class5391[]{
                     new Class5396(Items.field37868, 26, 12, 10),
                     new Class5394(Items.field37844, 5, 12, 5),
                     new Class5394(Items.field37847, 4, 12, 5)
                  },
                  3,
                  new Class5391[]{new Class5396(Items.field38081, 9, 12, 20), new Class5394(Items.field37845, 7)},
                  4,
                  new Class5391[]{new Class5396(Items.field37793, 4, 12, 30), new Class5394(Items.field38086, 6, 12, 15)},
                  5,
                  new Class5391[]{new Class5395(new ItemStack(Items.field37886), 6, 1, 12, 30, 0.2F), new Class5394(Items.field37844, 5, 12, 30)}
               )
            )
         );
         var0.put(
            Class8395.field36021,
            method38080(
               ImmutableMap.of(
                  1,
                  new Class5391[]{new Class5396(Items.field37897, 10, 16, 2), new Class5395(Items.field37896, 1, 10, 16, 1)},
                  2,
                  new Class5391[]{new Class5396(Blocks.STONE, 20, 16, 10), new Class5395(Blocks.CHISELED_STONE_BRICKS, 1, 4, 16, 5)},
                  3,
                  new Class5391[]{
                     new Class5396(Blocks.GRANITE, 16, 16, 20),
                     new Class5396(Blocks.ANDESITE, 16, 16, 20),
                     new Class5396(Blocks.DIORITE, 16, 16, 20),
                     new Class5395(Blocks.POLISHED_ANDESITE, 1, 4, 16, 10),
                     new Class5395(Blocks.POLISHED_DIORITE, 1, 4, 16, 10),
                     new Class5395(Blocks.POLISHED_GRANITE, 1, 4, 16, 10)
                  },
                  4,
                  new Class5391[]{
                     new Class5396(Items.field38072, 12, 12, 30),
                     new Class5395(Blocks.ORANGE_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.WHITE_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.BLUE_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.LIGHT_BLUE_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.GRAY_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.LIGHT_GRAY_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.BLACK_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.RED_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.PINK_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.MAGENTA_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.LIME_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.GREEN_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.CYAN_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.PURPLE_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.YELLOW_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.BROWN_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.ORANGE_GLAZED_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.WHITE_GLAZED_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.BLUE_GLAZED_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.GRAY_GLAZED_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.BLACK_GLAZED_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.RED_GLAZED_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.PINK_GLAZED_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.MAGENTA_GLAZED_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.LIME_GLAZED_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.GREEN_GLAZED_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.CYAN_GLAZED_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.PURPLE_GLAZED_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.YELLOW_GLAZED_TERRACOTTA, 1, 1, 12, 15),
                     new Class5395(Blocks.BROWN_GLAZED_TERRACOTTA, 1, 1, 12, 15)
                  },
                  5,
                  new Class5391[]{new Class5395(Blocks.QUARTZ_PILLAR, 1, 1, 12, 30), new Class5395(Blocks.QUARTZ_BLOCK, 1, 1, 12, 30)}
               )
            )
         );
      }
   );
   public static final Int2ObjectMap<Class5391[]> field45415 = method38080(
      ImmutableMap.of(
         1,
         new Class5391[]{
            new Class5395(Items.SEA_PICKLE, 2, 1, 5, 1),
            new Class5395(Items.field37901, 4, 1, 5, 1),
            new Class5395(Items.field37446, 2, 1, 5, 1),
            new Class5395(Items.field38146, 5, 1, 5, 1),
            new Class5395(Items.FERN, 1, 1, 12, 1),
            new Class5395(Items.SUGAR_CANE, 1, 1, 8, 1),
            new Class5395(Items.field37438, 1, 1, 4, 1),
            new Class5395(Items.KELP, 3, 1, 12, 1),
            new Class5395(Items.field37427, 3, 1, 8, 1),
            new Class5395(Items.DANDELION, 1, 1, 12, 1),
            new Class5395(Items.POPPY, 1, 1, 12, 1),
            new Class5395(Items.BLUE_ORCHID, 1, 1, 8, 1),
            new Class5395(Items.ALLIUM, 1, 1, 12, 1),
            new Class5395(Items.AZURE_BLUET, 1, 1, 12, 1),
            new Class5395(Items.RED_TULIP, 1, 1, 12, 1),
            new Class5395(Items.ORANGE_TULIP, 1, 1, 12, 1),
            new Class5395(Items.WHITE_TULIP, 1, 1, 12, 1),
            new Class5395(Items.PINK_TULIP, 1, 1, 12, 1),
            new Class5395(Items.OXEYE_DAISY, 1, 1, 12, 1),
            new Class5395(Items.CORNFLOWER, 1, 1, 12, 1),
            new Class5395(Items.LILY_OF_THE_VALLEY, 1, 1, 7, 1),
            new Class5395(Items.field37841, 1, 1, 12, 1),
            new Class5395(Items.field38112, 1, 1, 12, 1),
            new Class5395(Items.field37959, 1, 1, 12, 1),
            new Class5395(Items.field37960, 1, 1, 12, 1),
            new Class5395(Items.ACACIA_SAPLING, 5, 1, 8, 1),
            new Class5395(Items.BIRCH_SAPLING, 5, 1, 8, 1),
            new Class5395(Items.DARK_OAK_SAPLING, 5, 1, 8, 1),
            new Class5395(Items.JUNGLE_SAPLING, 5, 1, 8, 1),
            new Class5395(Items.OAK_SAPLING, 5, 1, 8, 1),
            new Class5395(Items.SPRUCE_SAPLING, 5, 1, 8, 1),
            new Class5395(Items.field37932, 1, 3, 12, 1),
            new Class5395(Items.field37918, 1, 3, 12, 1),
            new Class5395(Items.field37929, 1, 3, 12, 1),
            new Class5395(Items.field37924, 1, 3, 12, 1),
            new Class5395(Items.field37933, 1, 3, 12, 1),
            new Class5395(Items.field37931, 1, 3, 12, 1),
            new Class5395(Items.field37926, 1, 3, 12, 1),
            new Class5395(Items.field37920, 1, 3, 12, 1),
            new Class5395(Items.field37922, 1, 3, 12, 1),
            new Class5395(Items.field37925, 1, 3, 12, 1),
            new Class5395(Items.field37928, 1, 3, 12, 1),
            new Class5395(Items.field37921, 1, 3, 12, 1),
            new Class5395(Items.field37923, 1, 3, 12, 1),
            new Class5395(Items.field37919, 1, 3, 12, 1),
            new Class5395(Items.field37930, 1, 3, 12, 1),
            new Class5395(Items.field37927, 1, 3, 12, 1),
            new Class5395(Items.field37725, 3, 1, 8, 1),
            new Class5395(Items.field37726, 3, 1, 8, 1),
            new Class5395(Items.field37727, 3, 1, 8, 1),
            new Class5395(Items.field37728, 3, 1, 8, 1),
            new Class5395(Items.field37724, 3, 1, 8, 1),
            new Class5395(Items.field37473, 1, 1, 12, 1),
            new Class5395(Items.BROWN_MUSHROOM, 1, 1, 12, 1),
            new Class5395(Items.RED_MUSHROOM, 1, 1, 12, 1),
            new Class5395(Items.field37485, 1, 2, 5, 1),
            new Class5395(Items.SAND, 1, 8, 8, 1),
            new Class5395(Items.RED_SAND, 1, 4, 6, 1)
         },
         2,
         new Class5391[]{
            new Class5395(Items.field37895, 5, 1, 4, 1),
            new Class5395(Items.field37892, 5, 1, 4, 1),
            new Class5395(Items.field37590, 3, 1, 6, 1),
            new Class5395(Items.field37749, 6, 1, 6, 1),
            new Class5395(Items.field37840, 1, 1, 8, 1),
            new Class5395(Items.PODZOL, 3, 3, 6, 1)
         }
      )
   );

   private static Int2ObjectMap<Class5391[]> method38080(ImmutableMap<Integer, Class5391[]> var0) {
      return new Int2ObjectOpenHashMap(var0);
   }
}
