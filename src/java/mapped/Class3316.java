package mapped;

import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multisets;
import java.util.List;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.MapData;

public class Class3316 extends Class3314 {
   public Class3316(Properties var1) {
      super(var1);
   }

   public static ItemStack method11859(World var0, int var1, int var2, byte var3, boolean var4, boolean var5) {
      ItemStack var8 = new ItemStack(Items.field37955);
      method11863(var8, var0, var1, var2, var3, var4, var5, var0.getDimensionKey());
      return var8;
   }

   @Nullable
   public static MapData method11860(ItemStack var0, World var1) {
      return var1.method6798(method11864(method11862(var0)));
   }

   @Nullable
   public static MapData method11861(ItemStack var0, World var1) {
      MapData var4 = method11860(var0, var1);
      if (var4 == null && var1 instanceof ServerWorld) {
         var4 = method11863(var0, var1, var1.getWorldInfo().getSpawnX(), var1.getWorldInfo().getSpawnZ(), 3, false, false, var1.getDimensionKey());
      }

      return var4;
   }

   public static int method11862(ItemStack var0) {
      CompoundNBT var3 = var0.getTag();
      return var3 != null && var3.contains("map", 99) ? var3.getInt("map") : 0;
   }

   private static MapData method11863(ItemStack var0, World var1, int var2, int var3, int var4, boolean var5, boolean var6, RegistryKey<World> var7) {
      int var10 = var1.method6800();
      MapData var11 = new MapData(method11864(var10));
      var11.method24589(var2, var3, var4, var5, var6, var7);
      var1.method6799(var11);
      var0.getOrCreateTag().putInt("map", var10);
      return var11;
   }

   public static String method11864(int var0) {
      return "map_" + var0;
   }

   public void method11865(World var1, Entity var2, MapData var3) {
      if (var1.getDimensionKey() == var3.field32318 && var2 instanceof PlayerEntity) {
         int var6 = 1 << var3.scale;
         int var7 = var3.xCenter;
         int var8 = var3.zCenter;
         int var9 = MathHelper.floor(var2.getPosX() - (double)var7) / var6 + 64;
         int var10 = MathHelper.floor(var2.getPosZ() - (double)var8) / var6 + 64;
         int var11 = 128 / var6;
         if (var1.getDimensionType().getHasCeiling()) {
            var11 /= 2;
         }

         Class8541 var12 = var3.method24599((PlayerEntity)var2);
         var12.field38397++;
         boolean var13 = false;

         for (int var14 = var9 - var11 + 1; var14 < var9 + var11; var14++) {
            if ((var14 & 15) == (var12.field38397 & 15) || var13) {
               var13 = false;
               double var15 = 0.0;

               for (int var17 = var10 - var11 - 1; var17 < var10 + var11; var17++) {
                  if (var14 >= 0 && var17 >= -1 && var14 < 128 && var17 < 128) {
                     int var18 = var14 - var9;
                     int var19 = var17 - var10;
                     boolean var20 = var18 * var18 + var19 * var19 > (var11 - 2) * (var11 - 2);
                     int var21 = (var7 / var6 + var14 - 64) * var6;
                     int var22 = (var8 / var6 + var17 - 64) * var6;
                     LinkedHashMultiset var23 = LinkedHashMultiset.create();
                     Chunk var24 = var1.getChunkAt(new BlockPos(var21, 0, var22));
                     if (!var24.isEmpty()) {
                        ChunkPos var25 = var24.getPos();
                        int var26 = var21 & 15;
                        int var27 = var22 & 15;
                        int var28 = 0;
                        double var29 = 0.0;
                        if (!var1.getDimensionType().getHasCeiling()) {
                           BlockPos.Mutable var31 = new BlockPos.Mutable();
                           BlockPos.Mutable var32 = new BlockPos.Mutable();

                           for (int var33 = 0; var33 < var6; var33++) {
                              for (int var36 = 0; var36 < var6; var36++) {
                                 int var37 = var24.getTopBlockY(Heightmap.Type.WORLD_SURFACE, var33 + var26, var36 + var27) + 1;
                                 BlockState var38;
                                 if (var37 <= 1) {
                                    var38 = Blocks.BEDROCK.getDefaultState();
                                 } else {
                                    do {
                                       var31.setPos(var25.getX() + var33 + var26, --var37, var25.getZ() + var36 + var27);
                                       var38 = var24.getBlockState(var31);
                                    } while (var38.method23394(var1, var31) == MaterialColor.AIR && var37 > 0);

                                    if (var37 > 0 && !var38.getFluidState().isEmpty()) {
                                       int var39 = var37 - 1;
                                       var32.method8374(var31);

                                       BlockState var40;
                                       do {
                                          var32.setY(var39--);
                                          var40 = var24.getBlockState(var32);
                                          var28++;
                                       } while (var39 > 0 && !var40.getFluidState().isEmpty());

                                       var38 = this.method11866(var1, var38, var31);
                                    }
                                 }

                                 var3.method24601(var1, var25.getX() + var33 + var26, var25.getZ() + var36 + var27);
                                 var29 += (double)var37 / (double)(var6 * var6);
                                 var23.add(var38.method23394(var1, var31));
                              }
                           }
                        } else {
                           int var42 = var21 + var22 * 231871;
                           var42 = var42 * var42 * 31287121 + var42 * 11;
                           if ((var42 >> 20 & 1) != 0) {
                              var23.add(Blocks.STONE.getDefaultState().method23394(var1, BlockPos.ZERO), 100);
                           } else {
                              var23.add(Blocks.DIRT.getDefaultState().method23394(var1, BlockPos.ZERO), 10);
                           }

                           var29 = 100.0;
                        }

                        var28 /= var6 * var6;
                        double var34 = (var29 - var15) * 4.0 / (double)(var6 + 4) + ((double)(var14 + var17 & 1) - 0.5) * 0.4;
                        byte var44 = 1;
                        if (var34 > 0.6) {
                           var44 = 2;
                        }

                        if (var34 < -0.6) {
                           var44 = 0;
                        }

                        MaterialColor var46 = (MaterialColor)Iterables.getFirst(Multisets.copyHighestCountFirst(var23), MaterialColor.AIR);
                        if (var46 == MaterialColor.field30959) {
                           var34 = (double)var28 * 0.1 + (double)(var14 + var17 & 1) * 0.2;
                           var44 = 1;
                           if (var34 < 0.5) {
                              var44 = 2;
                           }

                           if (var34 > 0.9) {
                              var44 = 0;
                           }
                        }

                        var15 = var29;
                        if (var17 >= 0 && var18 * var18 + var19 * var19 < var11 * var11 && (!var20 || (var14 + var17 & 1) != 0)) {
                           byte var47 = var3.colors[var14 + var17 * 128];
                           byte var48 = (byte)(var46.field31007 * 4 + var44);
                           if (var47 != var48) {
                              var3.colors[var14 + var17 * 128] = var48;
                              var3.method24598(var14, var17);
                              var13 = true;
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private BlockState method11866(World var1, BlockState var2, BlockPos var3) {
      FluidState var6 = var2.getFluidState();
      return !var6.isEmpty() && !var2.method23454(var1, var3, Direction.UP) ? var6.getBlockState() : var2;
   }

   private static boolean method11867(Biome[] var0, int var1, int var2, int var3) {
      return var0[var2 * var1 + var3 * var1 * 128 * var1].getDepth() >= 0.0F;
   }

   public static void method11868(ServerWorld var0, ItemStack var1) {
      MapData var4 = method11861(var1, var0);
      if (var4 != null && var0.getDimensionKey() == var4.field32318) {
         int var5 = 1 << var4.scale;
         int var6 = var4.xCenter;
         int var7 = var4.zCenter;
         Biome[] var8 = new Biome[128 * var5 * 128 * var5];

         for (int var9 = 0; var9 < 128 * var5; var9++) {
            for (int var10 = 0; var10 < 128 * var5; var10++) {
               var8[var9 * 128 * var5 + var10] = var0.getBiome(new BlockPos((var6 / var5 - 64) * var5 + var10, 0, (var7 / var5 - 64) * var5 + var9));
            }
         }

         for (int var15 = 0; var15 < 128; var15++) {
            for (int var16 = 0; var16 < 128; var16++) {
               if (var15 > 0 && var16 > 0 && var15 < 127 && var16 < 127) {
                  Biome var11 = var8[var15 * var5 + var16 * var5 * 128 * var5];
                  int var12 = 8;
                  if (method11867(var8, var5, var15 - 1, var16 - 1)) {
                     var12--;
                  }

                  if (method11867(var8, var5, var15 - 1, var16 + 1)) {
                     var12--;
                  }

                  if (method11867(var8, var5, var15 - 1, var16)) {
                     var12--;
                  }

                  if (method11867(var8, var5, var15 + 1, var16 - 1)) {
                     var12--;
                  }

                  if (method11867(var8, var5, var15 + 1, var16 + 1)) {
                     var12--;
                  }

                  if (method11867(var8, var5, var15 + 1, var16)) {
                     var12--;
                  }

                  if (method11867(var8, var5, var15, var16 - 1)) {
                     var12--;
                  }

                  if (method11867(var8, var5, var15, var16 + 1)) {
                     var12--;
                  }

                  int var13 = 3;
                  MaterialColor var14 = MaterialColor.AIR;
                  if (!(var11.getDepth() < 0.0F)) {
                     if (var12 > 0) {
                        var14 = MaterialColor.field30973;
                        if (var12 <= 3) {
                           var13 = 3;
                        } else {
                           var13 = 1;
                        }
                     }
                  } else {
                     var14 = MaterialColor.field30962;
                     if (var12 > 7 && var16 % 2 == 0) {
                        var13 = (var15 + (int)(MathHelper.sin((float)var16 + 0.0F) * 7.0F)) / 8 % 5;
                        if (var13 != 3) {
                           if (var13 == 4) {
                              var13 = 0;
                           }
                        } else {
                           var13 = 1;
                        }
                     } else if (var12 <= 7) {
                        if (var12 <= 5) {
                           if (var12 <= 3) {
                              if (var12 > 1) {
                                 var13 = 0;
                              }
                           } else {
                              var13 = 0;
                           }
                        } else {
                           var13 = 1;
                        }
                     } else {
                        var14 = MaterialColor.AIR;
                     }
                  }

                  if (var14 != MaterialColor.AIR) {
                     var4.colors[var15 + var16 * 128] = (byte)(var14.field31007 * 4 + var13);
                     var4.method24598(var15, var16);
                  }
               }
            }
         }
      }
   }

   @Override
   public void method11724(ItemStack var1, World var2, Entity var3, int var4, boolean var5) {
      if (!var2.isRemote) {
         MapData var8 = method11861(var1, var2);
         if (var8 != null) {
            if (var3 instanceof PlayerEntity) {
               PlayerEntity var9 = (PlayerEntity)var3;
               var8.method24594(var9, var1);
            }

            if (!var8.locked && (var5 || var3 instanceof PlayerEntity && ((PlayerEntity)var3).getHeldItemOffhand() == var1)) {
               this.method11865(var2, var3, var8);
            }
         }
      }
   }

   @Nullable
   @Override
   public IPacket<?> method11858(ItemStack var1, World var2, PlayerEntity var3) {
      return method11861(var1, var2).method24597(var1, var2, var3);
   }

   @Override
   public void method11725(ItemStack var1, World var2, PlayerEntity var3) {
      CompoundNBT var6 = var1.getTag();
      if (var6 != null && var6.contains("map_scale_direction", 99)) {
         method11869(var1, var2, var6.getInt("map_scale_direction"));
         var6.remove("map_scale_direction");
      } else if (var6 != null && var6.contains("map_to_lock", 1) && var6.getBoolean("map_to_lock")) {
         method11870(var2, var1);
         var6.remove("map_to_lock");
      }
   }

   public static void method11869(ItemStack var0, World var1, int var2) {
      MapData var5 = method11861(var0, var1);
      if (var5 != null) {
         method11863(
            var0,
            var1,
            var5.xCenter,
            var5.zCenter,
            MathHelper.clamp(var5.scale + var2, 0, 4),
            var5.trackingPosition,
            var5.unlimitedTracking,
            var5.field32318
         );
      }
   }

   public static void method11870(World var0, ItemStack var1) {
      MapData var4 = method11861(var1, var0);
      if (var4 != null) {
         MapData var5 = method11863(var1, var0, 0, 0, var4.scale, var4.trackingPosition, var4.unlimitedTracking, var4.field32318);
         var5.method24593(var4);
      }
   }

   @Override
   public void method11730(ItemStack var1, World var2, List<ITextComponent> var3, Class2216 var4) {
      MapData var7 = var2 != null ? method11861(var1, var2) : null;
      if (var7 != null && var7.locked) {
         var3.add(new TranslationTextComponent("filled_map.locked", method11862(var1)).mergeStyle(TextFormatting.GRAY));
      }

      if (var4.method8944()) {
         if (var7 == null) {
            var3.add(new TranslationTextComponent("filled_map.unknown").mergeStyle(TextFormatting.GRAY));
         } else {
            var3.add(new TranslationTextComponent("filled_map.id", method11862(var1)).mergeStyle(TextFormatting.GRAY));
            var3.add(new TranslationTextComponent("filled_map.scale", 1 << var7.scale).mergeStyle(TextFormatting.GRAY));
            var3.add(new TranslationTextComponent("filled_map.level", var7.scale, 4).mergeStyle(TextFormatting.GRAY));
         }
      }
   }

   public static int method11871(ItemStack var0) {
      CompoundNBT var3 = var0.method32145("display");
      if (var3 != null && var3.contains("MapColor", 99)) {
         int var4 = var3.getInt("MapColor");
         return 0xFF000000 | var4 & 16777215;
      } else {
         return -12173266;
      }
   }

   @Override
   public ActionResultType onItemUse(ItemUseContext var1) {
      BlockState var4 = var1.getWorld().getBlockState(var1.getPos());
      if (!var4.isIn(BlockTags.field32760)) {
         return super.onItemUse(var1);
      } else {
         if (!var1.getWorld().isRemote) {
            MapData var5 = method11861(var1.method18357(), var1.getWorld());
            var5.method24600(var1.getWorld(), var1.getPos());
         }

         return ActionResultType.method9002(var1.getWorld().isRemote);
      }
   }
}
