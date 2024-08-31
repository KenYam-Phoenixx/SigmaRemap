package net.minecraft.network.datasync;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.EncoderException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;

import mapped.*;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityDataManager {
   private static final Logger field43430 = LogManager.getLogger();
   private static final Map<Class<? extends Entity>, Integer> field43431 = Maps.newHashMap();
   private final Entity field43432;
   private final Map<Integer, Class9773<?>> field43433 = Maps.newHashMap();
   private final ReadWriteLock field43434 = new ReentrantReadWriteLock();
   private boolean field43435 = true;
   private boolean field43436;
   public Biome field43437 = Class8708.field39311;
   public BlockPos field43438 = BlockPos.ZERO;

   public EntityDataManager(Entity var1) {
      this.field43432 = var1;
   }

   public static <T> DataParameter<T> createKey(Class<? extends Entity> var0, Class6466<T> var1) {
      if (field43430.isDebugEnabled()) {
         try {
            Class var4 = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName());
            if (!var4.equals(var0)) {
               field43430.debug("defineId called for: {} from {}", var0, var4, new RuntimeException());
            }
         } catch (ClassNotFoundException var7) {
         }
      }

      int var8;
      if (field43431.containsKey(var0)) {
         var8 = field43431.get(var0) + 1;
      } else {
         int var5 = 0;
         Class var6 = var0;

         while (var6 != Entity.class) {
            var6 = var6.getSuperclass();
            if (field43431.containsKey(var6)) {
               var5 = field43431.get(var6) + 1;
               break;
            }
         }

         var8 = var5;
      }

      if (var8 > 254) {
         throw new IllegalArgumentException("Data value id is too big with " + var8 + "! (Max is " + 254 + ")");
      } else {
         field43431.put(var0, var8);
         return var1.method19647(var8);
      }
   }

   public <T> void register(DataParameter<T> var1, T var2) {
      int var5 = var1.method35015();
      if (var5 <= 254) {
         if (!this.field43433.containsKey(var5)) {
            if (DataSerializers.method25806(var1.method35016()) >= 0) {
               this.method35443(var1, var2);
            } else {
               throw new IllegalArgumentException("Unregistered serializer " + var1.method35016() + " for " + var5 + "!");
            }
         } else {
            throw new IllegalArgumentException("Duplicate id value for " + var5 + "!");
         }
      } else {
         throw new IllegalArgumentException("Data value id is too big with " + var5 + "! (Max is " + 254 + ")");
      }
   }

   private <T> void method35443(DataParameter<T> var1, T var2) {
      Class9773<T> var5 = new Class9773<>(var1, var2);
      this.field43434.writeLock().lock();
      this.field43433.put(var1.method35015(), var5);
      this.field43435 = false;
      this.field43434.writeLock().unlock();
   }

   private <T> Class9773<T> method35444(DataParameter<T> var1) {
      this.field43434.readLock().lock();

      Class9773 var4;
      try {
         var4 = this.field43433.get(var1.method35015());
      } catch (Throwable var11) {
         CrashReport var6 = CrashReport.makeCrashReport(var11, "Getting synched entity data");
         CrashReportCategory var7 = var6.makeCategory("Synched entity data");
         var7.addDetail("Data ID", var1);
         throw new ReportedException(var6);
      } finally {
         this.field43434.readLock().unlock();
      }

      return var4;
   }

   public <T> T method35445(DataParameter<T> var1) {
      return this.<T>method35444(var1).method38449();
   }

   public <T> void method35446(DataParameter<T> var1, T var2) {
      Class9773 var5 = this.method35444(var1);
      if (ObjectUtils.notEqual(var2, var5.method38449())) {
         var5.method38448(var2);
         this.field43432.method3155(var1);
         var5.method38451(true);
         this.field43436 = true;
      }
   }

   public boolean method35447() {
      return this.field43436;
   }

   public static void method35448(List<Class9773<?>> var0, PacketBuffer var1) throws IOException {
      if (var0 != null) {
         int var4 = 0;

         for (int var5 = var0.size(); var4 < var5; var4++) {
            method35451(var1, (Class9773)var0.get(var4));
         }
      }

      var1.writeByte(255);
   }

   @Nullable
   public List<Class9773<?>> method35449() {
      ArrayList var3 = null;
      if (this.field43436) {
         this.field43434.readLock().lock();

         for (Class9773 var5 : this.field43433.values()) {
            if (var5.method38450()) {
               var5.method38451(false);
               if (var3 == null) {
                  var3 = Lists.newArrayList();
               }

               var3.add(var5.method38452());
            }
         }

         this.field43434.readLock().unlock();
      }

      this.field43436 = false;
      return var3;
   }

   @Nullable
   public List<Class9773<?>> method35450() {
      ArrayList var3 = null;
      this.field43434.readLock().lock();

      for (Class9773 var5 : this.field43433.values()) {
         if (var3 == null) {
            var3 = Lists.newArrayList();
         }

         var3.add(var5.method38452());
      }

      this.field43434.readLock().unlock();
      return var3;
   }

   private static <T> void method35451(PacketBuffer var0, Class9773<T> var1) throws IOException {
      DataParameter var4 = var1.method38447();
      int var5 = DataSerializers.method25806(var4.method35016());
      if (var5 >= 0) {
         var0.writeByte(var4.method35015());
         var0.writeVarInt(var5);
         var4.method35016().method19646(var0, var1.method38449());
      } else {
         throw new EncoderException("Unknown serializer type " + var4.method35016());
      }
   }

   @Nullable
   public static List<Class9773<?>> method35452(PacketBuffer var0) throws IOException {
      ArrayList var3 = null;

      short var4;
      while ((var4 = var0.readUnsignedByte()) != 255) {
         if (var3 == null) {
            var3 = Lists.newArrayList();
         }

         int var5 = var0.readVarInt();
         Class6466 var6 = DataSerializers.method25805(var5);
         if (var6 == null) {
            throw new DecoderException("Unknown serializer type " + var5);
         }

         var3.add(method35453(var0, var4, var6));
      }

      return var3;
   }

   private static <T> Class9773<T> method35453(PacketBuffer var0, int var1, Class6466<T> var2) {
      return new Class9773<T>(var2.method19647(var1), (T)var2.method19645(var0));
   }

   public void method35454(List<Class9773<?>> var1) {
      this.field43434.writeLock().lock();

      for (Class9773 var5 : var1) {
         Class9773 var6 = this.field43433.get(var5.method38447().method35015());
         if (var6 != null) {
            this.method35455(var6, var5);
            this.field43432.method3155(var5.method38447());
         }
      }

      this.field43434.writeLock().unlock();
      this.field43436 = true;
   }

   private <T> void method35455(Class9773<T> var1, Class9773<?> var2) {
      if (Objects.equals(Class9773.method38453(var2).method35016(), Class9773.method38453(var1).method35016())) {
         var1.method38448((T) var2.method38449());
      } else {
         throw new IllegalStateException(
            String.format(
               "Invalid entity data item type for field %d on entity %s: old=%s(%s), new=%s(%s)",
               Class9773.method38453(var1).method35015(),
               this.field43432,
               Class9773.method38454(var1),
               Class9773.method38454(var1).getClass(),
               Class9773.method38454(var2),
               Class9773.method38454(var2).getClass()
            )
         );
      }
   }

   public boolean method35456() {
      return this.field43435;
   }

   public void method35457() {
      this.field43436 = false;
      this.field43434.readLock().lock();

      for (Class9773 var4 : this.field43433.values()) {
         var4.method38451(false);
      }

      this.field43434.readLock().unlock();
   }
}
