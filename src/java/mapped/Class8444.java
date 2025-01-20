package mapped;

import java.nio.Buffer;
import java.nio.ByteBuffer;

import com.mentalfrostbyte.Client;
import com.mentalfrostbyte.jello.module.impl.gui.jello.MiniMap;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.BufferUtils;

public class Class8444 {
   private static String[] field36183;
   public Chunk field36184;
   public ByteBuffer field36185;
   public boolean field36186;

   public Class8444(Chunk var1) {
      this.field36184 = var1;
      this.field36185 = BufferUtils.createByteBuffer(768);
      this.method29695();
   }

   public void method29695() {
      this.field36185 = BufferUtils.createByteBuffer(768);
      int var3 = this.field36184.getPos().x * 16;
      int var4 = this.field36184.getPos().z * 16;

      for (int var5 = 0; var5 < 16; var5++) {
         for (int var6 = 0; var6 < 16; var6++) {
            BlockPos var7 = new BlockPos(var3 + var5, 64, var4 + var6);
            int var8 = Client.getInstance().waypointsManager
                  .method30006(
                        new BlockPos(var7.getX(),
                              this.field36184.getHeightmap(Heightmap.Type.WORLD_SURFACE).getHeight(var5, var6) - 1,
                              var7.getZ()),
                        true);
            this.field36185.put((byte) (var8 >> 16 & 0xFF));
            this.field36185.put((byte) (var8 >> 8 & 0xFF));
            this.field36185.put((byte) (var8 & 0xFF));
         }
      }

      ((Buffer) this.field36185).flip();
      this.field36186 = this.method29697();
   }

   public void method29696() {
      if (!this.field36186 && this.method29697()) {
         this.method29695();
      }
   }

   private boolean method29697() {
      Chunk var3 = MiniMap.getMC().world.getChunk(this.field36184.getPos().x, this.field36184.getPos().z + 1);
      Chunk var4 = MiniMap.getMC2().world.getChunk(this.field36184.getPos().x, this.field36184.getPos().z - 1);
      return var3 != null && var3.field9115 && var4 != null && var4.field9115;
   }

   public boolean method29698(Chunk var1) {
      return var1.getPos().x == this.field36184.getPos().x && var1.getPos().z == this.field36184.getPos().z;
   }
}
