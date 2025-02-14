package mapped;

import com.google.common.collect.Sets;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.SectionPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ChunkHolder;
import net.minecraft.world.server.ChunkManager;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Class8998 {
   private static String[] field41146;
   private final Class9278 field41147;
   private final Entity field41148;
   private final int field41149;
   private SectionPos field41150;
   private final Set<ServerPlayerEntity> field41151;
   public final ChunkManager field41152;

   public Class8998(ChunkManager var1, Entity var2, int var3, int var4, boolean var5) {
      this.field41152 = var1;
      this.field41151 = Sets.newHashSet();
      this.field41147 = new Class9278(ChunkManager.method6633(var1), var2, var4, var5, this::method33239);
      this.field41148 = var2;
      this.field41149 = var3;
      this.field41150 = SectionPos.method8392(var2);
   }

   @Override
   public boolean equals(Object var1) {
      return !(var1 instanceof Class8998) ? false : ((Class8998)var1).field41148.getEntityId() == this.field41148.getEntityId();
   }

   @Override
   public int hashCode() {
      return this.field41148.getEntityId();
   }

   public void method33239(IPacket<?> var1) {
      for (ServerPlayerEntity var5 : this.field41151) {
         var5.connection.sendPacket(var1);
      }
   }

   public void method33240(IPacket<?> var1) {
      this.method33239(var1);
      if (this.field41148 instanceof ServerPlayerEntity) {
         ((ServerPlayerEntity)this.field41148).connection.sendPacket(var1);
      }
   }

   public void method33241() {
      for (ServerPlayerEntity var4 : this.field41151) {
         this.field41147.method34970(var4);
      }
   }

   public void method33242(ServerPlayerEntity var1) {
      if (this.field41151.remove(var1)) {
         this.field41147.method34970(var1);
      }
   }

   public void method33243(ServerPlayerEntity var1) {
      if (var1 != this.field41148) {
         Vector3d var4 = var1.getPositionVec().subtract(this.field41147.method34975());
         int var5 = Math.min(this.method33245(), (ChunkManager.method6634(this.field41152) - 1) * 16);
         boolean var6 = var4.x >= (double)(-var5)
            && var4.x <= (double)var5
            && var4.z >= (double)(-var5)
            && var4.z <= (double)var5
            && this.field41148.isSpectatedByPlayer(var1);
         if (!var6) {
            if (this.field41151.remove(var1)) {
               this.field41147.method34970(var1);
            }
         } else {
            boolean var7 = this.field41148.forceSpawn;
            if (!var7) {
               ChunkPos var8 = new ChunkPos(this.field41148.chunkCoordX, this.field41148.chunkCoordZ);
               ChunkHolder var9 = this.field41152.method6539(var8.asLong());
               if (var9 != null && var9.method31043() != null) {
                  var7 = ChunkManager.method6635(var8, var1, false) <= ChunkManager.method6634(this.field41152);
               }
            }

            if (var7 && this.field41151.add(var1)) {
               this.field41147.method34971(var1);
            }
         }
      }
   }

   private int method33244(int var1) {
      return ChunkManager.method6633(this.field41152).getServer().method1337(var1);
   }

   private int method33245() {
      Collection<Entity> var3 = this.field41148.method3411();
      int var4 = this.field41149;

      for (Entity var6 : var3) {
         int var7 = var6.getType().method33225() * 16;
         if (var7 > var4) {
            var4 = var7;
         }
      }

      return this.method33244(var4);
   }

   public void method33246(List<ServerPlayerEntity> var1) {
      for (ServerPlayerEntity var5 : var1) {
         this.method33243(var5);
      }
   }

   // $VF: synthetic method
   public static Entity method33247(Class8998 var0) {
      return var0.field41148;
   }

   // $VF: synthetic method
   public static SectionPos method33248(Class8998 var0) {
      return var0.field41150;
   }

   // $VF: synthetic method
   public static SectionPos method33249(Class8998 var0, SectionPos var1) {
      return var0.field41150 = var1;
   }

   // $VF: synthetic method
   public static Class9278 method33250(Class8998 var0) {
      return var0.field41147;
   }
}
