package mapped;

import net.minecraft.tileentity.BannerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;

public class Class7599 {
   public static String method24888(IBlockReader var0, BlockPos var1) {
      TileEntity var4 = var0.getTileEntity(var1);
      return method24889(var4);
   }

   public static String method24889(TileEntity var0) {
      if (var0 instanceof INameable) {
         INameable var3 = (INameable)var0;
         method24890(var0);
         return var3.method3381() ? var3.method3380().getUnformattedComponentText() : null;
      } else {
         return null;
      }
   }

   public static void method24890(TileEntity var0) {
      BlockPos var3 = var0.getPos();
      ITextComponent var4 = method24892(var0);
      if (var4 == null) {
         Object var5 = method24891(var3);
         if (var5 == null) {
            var5 = new StringTextComponent("");
         }

         method24893(var0, (ITextComponent)var5);
      }
   }

   public static ITextComponent method24891(BlockPos var0) {
      TileEntity var3 = Class5995.method18606(var0);
      return var3 != null ? method24892(var3) : null;
   }

   public static ITextComponent method24892(TileEntity var0) {
      if (!(var0 instanceof INameable)) {
         return !(var0 instanceof Class950) ? null : (ITextComponent) Reflector.getFieldValue(var0, Reflector.field43159);
      } else {
         return ((INameable)var0).method3380();
      }
   }

   public static boolean method24893(TileEntity var0, ITextComponent var1) {
      if (!(var0 instanceof Class932)) {
         if (!(var0 instanceof BannerTileEntity)) {
            if (!(var0 instanceof Class934)) {
               if (!(var0 instanceof Class950)) {
                  return false;
               } else {
                  ((Class950)var0).method3826(var1);
                  return true;
               }
            } else {
               ((Class934)var0).method3698(var1);
               return true;
            }
         } else {
            ((BannerTileEntity)var0).method3888(var1);
            return true;
         }
      } else {
         ((Class932)var0).method3695(var1);
         return true;
      }
   }
}
