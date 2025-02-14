package mapped;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.mojang.datafixers.DSL;
import com.mojang.datafixers.DataFix;
import com.mojang.datafixers.DataFixUtils;
import com.mojang.datafixers.OpticFinder;
import com.mojang.datafixers.TypeRewriteRule;
import com.mojang.datafixers.Typed;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.Type;
import com.mojang.datafixers.types.templates.List.ListType;
import com.mojang.serialization.Dynamic;
import it.unimi.dsi.fastutil.ints.*;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.util.datafix.TypeReferences;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Class9508 extends DataFix {
   private static final int[][] field44265 = new int[][]{{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
   private static final Object2IntMap<String> field44266 = (Object2IntMap<String>)DataFixUtils.make(new Object2IntOpenHashMap(), var0 -> {
      var0.put("minecraft:acacia_leaves", 0);
      var0.put("minecraft:birch_leaves", 1);
      var0.put("minecraft:dark_oak_leaves", 2);
      var0.put("minecraft:jungle_leaves", 3);
      var0.put("minecraft:oak_leaves", 4);
      var0.put("minecraft:spruce_leaves", 5);
   });
   private static final Set<String> field44267 = ImmutableSet.of(
      "minecraft:acacia_bark",
      "minecraft:birch_bark",
      "minecraft:dark_oak_bark",
      "minecraft:jungle_bark",
      "minecraft:oak_bark",
      "minecraft:spruce_bark",
      new String[]{
         "minecraft:acacia_log",
         "minecraft:birch_log",
         "minecraft:dark_oak_log",
         "minecraft:jungle_log",
         "minecraft:oak_log",
         "minecraft:spruce_log",
         "minecraft:stripped_acacia_log",
         "minecraft:stripped_birch_log",
         "minecraft:stripped_dark_oak_log",
         "minecraft:stripped_jungle_log",
         "minecraft:stripped_oak_log",
         "minecraft:stripped_spruce_log"
      }
   );

   public Class9508(Schema var1, boolean var2) {
      super(var1, var2);
   }

   public TypeRewriteRule makeRule() {
      Type<?> var3 = this.getInputSchema().getType(TypeReferences.CHUNK);
      OpticFinder<?> var4 = var3.findField("Level");
      OpticFinder<?> var5 = var4.type().findField("Sections");
      Type<?> var6 = var5.type();
      if (var6 instanceof ListType) {
         Type<?> var7 = ((ListType)var6).getElement();
         OpticFinder<?> var8 = DSL.typeFinder(var7);
         return this.fixTypeEverywhereTyped(
            "Leaves fix",
            var3,
            var4x -> var4x.updateTyped(
                  var4,
                  var3xx -> {
                     int[] var6x = new int[]{0};
                     Typed<?>  var7x = var3xx.updateTyped(
                        var5,
                        var3xxx -> {
                           Int2ObjectMap<Class7453> var6xx = new Int2ObjectOpenHashMap<>(
                              var3xxx.getAllTyped(var8)
                                 .stream()
                                 .map(var1xxx -> new Class7453(var1xxx, this.getInputSchema()))
                                 .collect(Collectors.toMap(Class7452::method24094, var0 -> var0))
                           );
                           if (var6xx.values().stream().allMatch(Class7452::method24091)) {
                              return var3xxx;
                           } else {
                              List<IntSet> var7xx = Lists.newArrayList();

                              for (int var8x = 0; var8x < 7; var8x++) {
                                 var7xx.add(new IntOpenHashSet());
                              }

                               for (Class7453 var9 : var6xx.values()) {
                                   if (!var9.method24091()) {
                                       for (int var10 = 0; var10 < 4096; var10++) {
                                           int var11 = var9.method24092(var10);
                                           if (!var9.method24100(var11)) {
                                               if (var9.method24101(var11)) {
                                                   int var12 = this.method36710(var10);
                                                   int var13 = this.method36712(var10);
                                                   var6x[0] |= method36713(var12 == 0, var12 == 15, var13 == 0, var13 == 15);
                                               }
                                           } else {
                                               ((IntSet) var7xx.get(0)).add(var9.method24094() << 12 | var10);
                                           }
                                       }
                                   }
                               }

                              for (int var28 = 1; var28 < 7; var28++) {
                                 IntSet var29 = (IntSet)var7xx.get(var28 - 1);
                                 IntSet var30 = (IntSet)var7xx.get(var28);
                                 IntIterator var31 = var29.iterator();

                                 while (var31.hasNext()) {
                                    int var32 = var31.nextInt();
                                    int var33 = this.method36710(var32);
                                    int var14 = this.method36711(var32);
                                    int var15 = this.method36712(var32);

                                    for (int[] var19 : field44265) {
                                       int var20 = var33 + var19[0];
                                       int var21 = var14 + var19[1];
                                       int var22 = var15 + var19[2];
                                       if (var20 >= 0 && var20 <= 15 && var22 >= 0 && var22 <= 15 && var21 >= 0 && var21 <= 255) {
                                          Class7453 var23 = (Class7453)var6xx.get(var21 >> 4);
                                          if (var23 != null && !var23.method24091()) {
                                             int var24 = method36709(var20, var21 & 15, var22);
                                             int var25 = var23.method24092(var24);
                                             if (var23.method24101(var25)) {
                                                int var26 = Class7453.method24104(var23, var25);
                                                if (var26 > var28) {
                                                   Class7453.method24105(var23, var24, var25, var28);
                                                   var30.add(method36709(var20, var21, var22));
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }

                              return var3xxx.updateTyped(
                                 var8, var1xxx -> ((Class7453)var6xx.get(((Dynamic)var1xxx.get(DSL.remainderFinder())).get("Y").asInt(0))).method24090(var1xxx)
                              );
                           }
                        }
                     );
                     if (var6x[0] != 0) {
                        var7x = var7x.update(DSL.remainderFinder(), var1xx -> {
                           Dynamic var4xx = DataFixUtils.orElse(var1xx.get("UpgradeData").result(), var1xx.emptyMap());
                           return var1xx.set("UpgradeData", var4xx.set("Sides", var1xx.createByte((byte)(var4xx.get("Sides").asByte((byte)0) | var6x[0]))));
                        });
                     }

                     return var7x;
                  }
               )
         );
      } else {
         throw new IllegalStateException("Expecting sections to be a list.");
      }
   }

   public static int method36709(int var0, int var1, int var2) {
      return var1 << 8 | var2 << 4 | var0;
   }

   private int method36710(int var1) {
      return var1 & 15;
   }

   private int method36711(int var1) {
      return var1 >> 8 & 0xFF;
   }

   private int method36712(int var1) {
      return var1 >> 4 & 15;
   }

   public static int method36713(boolean var0, boolean var1, boolean var2, boolean var3) {
      short var6 = 0;
      if (!var2) {
         if (!var3) {
            if (!var1) {
               if (var0) {
                  var6 |= 64;
               }
            } else {
               var6 |= 4;
            }
         } else if (!var0) {
            if (!var1) {
               var6 |= 16;
            } else {
               var6 |= 8;
            }
         } else {
            var6 |= 32;
         }
      } else if (!var1) {
         if (!var0) {
            var6 |= 1;
         } else {
            var6 |= 128;
         }
      } else {
         var6 |= 2;
      }

      return var6;
   }

   // $VF: synthetic method
   public static Object2IntMap method36720() {
      return field44266;
   }

   // $VF: synthetic method
   public static Set method36721() {
      return field44267;
   }
}
