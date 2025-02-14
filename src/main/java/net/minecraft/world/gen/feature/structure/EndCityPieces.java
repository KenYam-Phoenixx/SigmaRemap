package net.minecraft.world.gen.feature.structure;

import com.google.common.collect.Lists;
import mapped.*;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EndCityPieces {
   private static final Class9463 field44105 = new Class9463().method36428(true).method36434(Class7095.field30526);
   private static final Class9463 field44106 = new Class9463().method36428(true).method36434(Class7095.field30528);
   private static final Class8015 field44107 = new Class8018();
   private static final List<Class6793<Rotation, BlockPos>> field44108 = Lists.newArrayList(
      new Class6793[]{
         new Class6793<Rotation, BlockPos>(Rotation.NONE, new BlockPos(1, -1, 0)),
         new Class6793<Rotation, BlockPos>(Rotation.CLOCKWISE_90, new BlockPos(6, -1, 1)),
         new Class6793<Rotation, BlockPos>(Rotation.COUNTERCLOCKWISE_90, new BlockPos(0, -1, 5)),
         new Class6793<Rotation, BlockPos>(Rotation.CLOCKWISE_180, new BlockPos(5, -1, 6))
      }
   );
   private static final Class8015 field44109 = new Class8017();
   private static final Class8015 field44110 = new Class8016();
   private static final List<Class6793<Rotation, BlockPos>> field44111 = Lists.newArrayList(
      new Class6793[]{
         new Class6793<Rotation, BlockPos>(Rotation.NONE, new BlockPos(4, -1, 0)),
         new Class6793<Rotation, BlockPos>(Rotation.CLOCKWISE_90, new BlockPos(12, -1, 4)),
         new Class6793<Rotation, BlockPos>(Rotation.COUNTERCLOCKWISE_90, new BlockPos(0, -1, 8)),
         new Class6793<Rotation, BlockPos>(Rotation.CLOCKWISE_180, new BlockPos(8, -1, 12))
      }
   );
   private static final Class8015 field44112 = new Class8014();

   private static Class4186 method36639(TemplateManager var0, Class4186 var1, BlockPos var2, String var3, Rotation var4, boolean var5) {
      Class4186 var8 = new Class4186(var0, var3, var1.field20455, var4, var5);
      BlockPos var9 = var1.field20453.method32895(var1.field20454, var2, var8.field20454, BlockPos.ZERO);
      var8.method12937(var9.getX(), var9.getY(), var9.getZ());
      return var8;
   }

   public static void method36640(TemplateManager var0, BlockPos var1, Rotation var2, List<Class4178> var3, Random var4) {
      field44112.init();
      field44107.init();
      field44110.init();
      field44109.init();
      Class4186 var7 = method36641(var3, new Class4186(var0, "base_floor", var1, var2, true));
      var7 = method36641(var3, method36639(var0, var7, new BlockPos(-1, 0, -1), "second_floor_1", var2, false));
      var7 = method36641(var3, method36639(var0, var7, new BlockPos(-1, 4, -1), "third_floor_1", var2, false));
      var7 = method36641(var3, method36639(var0, var7, new BlockPos(-1, 8, -1), "third_roof", var2, true));
      method36642(var0, field44109, 1, var7, (BlockPos)null, var3, var4);
   }

   private static Class4186 method36641(List<Class4178> var0, Class4186 var1) {
      var0.add(var1);
      return var1;
   }

   private static boolean method36642(TemplateManager var0, Class8015 var1, int var2, Class4186 var3, BlockPos var4, List<Class4178> var5, Random var6) {
      if (var2 > 8) {
         return false;
      } else {
         ArrayList<Class4178> var9 = Lists.newArrayList();
         if (var1.method27401(var0, var2, var3, var4, var9, var6)) {
            boolean var10 = false;
            int var11 = var6.nextInt();

            for (Class4178 var13 : var9) {
               var13.field20448 = var11;
               Class4178 var14 = Class4178.method12918(var5, var13.method12915());
               if (var14 != null && var14.field20448 != var3.field20448) {
                  var10 = true;
                  break;
               }
            }

            if (!var10) {
               var5.addAll(var9);
               return true;
            }
         }

         return false;
      }
   }

   // $VF: synthetic method
   public static Class4186 method36643(TemplateManager var0, Class4186 var1, BlockPos var2, String var3, Rotation var4, boolean var5) {
      return method36639(var0, var1, var2, var3, var4, var5);
   }

   // $VF: synthetic method
   public static Class4186 method36644(List var0, Class4186 var1) {
      return method36641(var0, var1);
   }

   // $VF: synthetic method
   public static Class8015 method36645() {
      return field44109;
   }

   // $VF: synthetic method
   public static boolean method36646(TemplateManager var0, Class8015 var1, int var2, Class4186 var3, BlockPos var4, List var5, Random var6) {
      return method36642(var0, var1, var2, var3, var4, var5, var6);
   }

   // $VF: synthetic method
   public static List<Class6793<Rotation, BlockPos>> method36647() {
      return field44108;
   }

   // $VF: synthetic method
   public static Class8015 method36648() {
      return field44110;
   }

   // $VF: synthetic method
   public static Class8015 method36649() {
      return field44112;
   }

   // $VF: synthetic method
   public static Class8015 method36650() {
      return field44107;
   }

   // $VF: synthetic method
   public static List<Class6793<Rotation, BlockPos>> method36651() {
      return field44111;
   }

   // $VF: synthetic method
   public static Class9463 method36652() {
      return field44105;
   }

   // $VF: synthetic method
   public static Class9463 method36653() {
      return field44106;
   }
}
