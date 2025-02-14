package mapped;

import com.mojang.datafixers.DataFixer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.datafix.DefaultTypeReferences;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.DimensionSavedDataManager;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.function.Supplier;

public class Class1648 implements AutoCloseable {
   private final IOWorker field8947;
   public final DataFixer field8948;
   private Class8418 field8949;

   public Class1648(File var1, DataFixer var2, boolean var3) {
      this.field8948 = var2;
      this.field8947 = new IOWorker(var1, var3, "chunk");
   }

   public CompoundNBT method6529(RegistryKey<World> var1, Supplier<DimensionSavedDataManager> var2, CompoundNBT var3) {
      int var6 = method6530(var3);

      if (var6 < 1493) {
         var3 = NBTUtil.update(this.field8948, DefaultTypeReferences.CHUNK, var3, var6, 1493);
         if (var3.getCompound("Level").getBoolean("hasLegacyStructureData")) {
            if (this.field8949 == null) {
               this.field8949 = Class8418.method29580(var1, (DimensionSavedDataManager)var2.get());
            }

            var3 = this.field8949.method29575(var3);
         }
      }

      var3 = NBTUtil.update(this.field8948, DefaultTypeReferences.CHUNK, var3, Math.max(1493, var6));
      if (var6 < SharedConstants.getVersion().getWorldVersion()) {
         var3.putInt("DataVersion", SharedConstants.getVersion().getWorldVersion());
      }

      return var3;
   }

   public static int method6530(CompoundNBT var0) {
      return !var0.contains("DataVersion", 99) ? -1 : var0.getInt("DataVersion");
   }

   @Nullable
   public CompoundNBT method6531(ChunkPos var1) throws IOException {
      return this.field8947.func_227090_a_(var1);
   }

   public void method6532(ChunkPos var1, CompoundNBT var2) {
      this.field8947.func_227093_a_(var1, var2);
      if (this.field8949 != null) {
         this.field8949.method29574(var1.asLong());
      }
   }

   public void method6533() {
      this.field8947.func_227088_a_().join();
   }

   @Override
   public void close() throws IOException {
      this.field8947.close();
   }
}
