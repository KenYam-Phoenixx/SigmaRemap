package mapped;

import com.mojang.datafixers.DataFixer;
import java.io.File;
import javax.annotation.Nullable;

import net.minecraft.util.Util;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.datafix.DefaultTypeReferences;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Class8716 {
   private static final Logger field39329 = LogManager.getLogger();
   private final File field39330;
   public final DataFixer field39331;

   public Class8716(SaveFormat.LevelSave var1, DataFixer var2) {
      this.field39331 = var2;
      this.field39330 = var1.resolveFilePath(FolderName.field23348).toFile();
      this.field39330.mkdirs();
   }

   public void method31441(PlayerEntity var1) {
      try {
         CompoundNBT var4 = var1.writeWithoutTypeId(new CompoundNBT());
         File var5 = File.createTempFile(var1.getCachedUniqueIdString() + "-", ".dat", this.field39330);
         CompressedStreamTools.writeCompressed(var4, var5);
         File var6 = new File(this.field39330, var1.getCachedUniqueIdString() + ".dat");
         File var7 = new File(this.field39330, var1.getCachedUniqueIdString() + ".dat_old");
         Util.backupThenUpdate(var6, var5, var7);
      } catch (Exception var8) {
         field39329.warn("Failed to save player data for {}", var1.getName().getString());
      }
   }

   @Nullable
   public CompoundNBT method31442(PlayerEntity var1) {
      CompoundNBT var4 = null;

      try {
         File var5 = new File(this.field39330, var1.getCachedUniqueIdString() + ".dat");
         if (var5.exists() && var5.isFile()) {
            var4 = CompressedStreamTools.readCompressed(var5);
         }
      } catch (Exception var6) {
         field39329.warn("Failed to load player data for {}", var1.getName().getString());
      }

      if (var4 != null) {
         int var7 = var4.contains("DataVersion", 3) ? var4.getInt("DataVersion") : -1;
         var1.read(NBTUtil.update(this.field39331, DefaultTypeReferences.PLAYER, var4, var7));
      }

      return var4;
   }

   public String[] method31443() {
      String[] var3 = this.field39330.list();
      if (var3 == null) {
         var3 = new String[0];
      }

      for (int var4 = 0; var4 < var3.length; var4++) {
         if (var3[var4].endsWith(".dat")) {
            var3[var4] = var3[var4].substring(0, var3[var4].length() - 4);
         }
      }

      return var3;
   }
}
