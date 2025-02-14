package mapped;

import it.unimi.dsi.fastutil.shorts.ShortList;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ITickList;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.chunk.storage.ChunkSerializer;

import java.util.function.Function;
import java.util.function.Predicate;

public class Class6806<T> implements ITickList<T> {
   private static String[] field29627;
   public final Predicate<T> field29628;
   private final ChunkPos field29629;
   private final ShortList[] field29630 = new ShortList[16];

   public Class6806(Predicate<T> var1, ChunkPos var2) {
      this(var1, var2, new ListNBT());
   }

   public Class6806(Predicate<T> var1, ChunkPos var2, ListNBT var3) {
      this.field29628 = var1;
      this.field29629 = var2;

      for (int var6 = 0; var6 < var3.size(); var6++) {
         ListNBT var7 = var3.getList(var6);

         for (int var8 = 0; var8 < var7.size(); var8++) {
            IChunk.getList(this.field29630, var6).add(var7.getShort(var8));
         }
      }
   }

   public ListNBT method20737() {
      return ChunkSerializer.method38094(this.field29630);
   }

   public void method20738(ITickList<T> var1, Function<BlockPos, T> var2) {
      for (int var5 = 0; var5 < this.field29630.length; var5++) {
         if (this.field29630[var5] != null) {

             for (Short var7 : this.field29630[var5]) {
                 BlockPos var8 = ChunkPrimer.method7114(var7, var5, this.field29629);
                 var1.scheduleTick(var8, var2.apply(var8), 0);
             }

            this.field29630[var5].clear();
         }
      }
   }

   @Override
   public boolean method20718(BlockPos var1, T var2) {
      return false;
   }

   @Override
   public void method20719(BlockPos var1, T var2, int var3, Class2199 var4) {
      IChunk.getList(this.field29630, var1.getY() >> 4).add(ChunkPrimer.method7113(var1));
   }

   @Override
   public boolean method20720(BlockPos var1, T var2) {
      return false;
   }
}
