package mapped;

import com.google.common.collect.Queues;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.LockSupport;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public abstract class Class318<R extends Runnable> implements Class321<R>, Executor {
   private final String field1377;
   private static final Logger field1378 = LogManager.getLogger();
   private final Queue<R> field1379 = Queues.newConcurrentLinkedQueue();
   private int field1380;

   public Class318(String var1) {
      this.field1377 = var1;
   }

   public abstract R wrapTask(Runnable var1);

   public abstract boolean canRun(R var1);

   public boolean isOnExecutionThread() {
      return Thread.currentThread() == this.getExecutionThread();
   }

   public abstract Thread getExecutionThread();

   public boolean method1390() {
      return !this.isOnExecutionThread();
   }

   public int method1630() {
      return this.field1379.size();
   }

   @Override
   public String getName() {
      return this.field1377;
   }

   public <V> CompletableFuture<V> supplyAsync(Supplier<V> var1) {
      return !this.method1390() ? CompletableFuture.<V>completedFuture((V)var1.get()) : CompletableFuture.<V>supplyAsync(var1, this);
   }

   private CompletableFuture<Void> method1633(Runnable var1) {
      return CompletableFuture.<Void>supplyAsync(() -> {
         var1.run();
         return null;
      }, this);
   }

   public CompletableFuture<Void> method1634(Runnable var1) {
      if (!this.method1390()) {
         var1.run();
         return CompletableFuture.<Void>completedFuture((Void)null);
      } else {
         return this.method1633(var1);
      }
   }

   public void runImmediately(Runnable var1) {
      if (this.isOnExecutionThread()) {
         var1.run();
      } else {
         this.method1633(var1).join();
      }
   }

   public void enqueue(R var1) {
      this.field1379.add((R)var1);
      LockSupport.unpark(this.getExecutionThread());
   }

   @Override
   public void execute(Runnable var1) {
      if (!this.method1390()) {
         var1.run();
      } else {
         this.enqueue(this.wrapTask(var1));
      }
   }

   public void dropTasks() {
      this.field1379.clear();
   }

   public void drainTasks() {
      while (this.method1302()) {
      }
   }

   public boolean method1302() {
      Runnable var3 = this.field1379.peek();
      if (var3 != null) {
         if (this.field1380 == 0 && !this.canRun((R)var3)) {
            return false;
         } else {
            this.run(this.field1379.remove());
            return true;
         }
      } else {
         return false;
      }
   }

   public void driveUntil(BooleanSupplier var1) {
      this.field1380++;

      try {
         while (!var1.getAsBoolean()) {
            if (!this.method1302()) {
               this.threadYieldPark();
            }
         }
      } finally {
         this.field1380--;
      }
   }

   public void threadYieldPark() {
      Thread.yield();
      LockSupport.parkNanos("waiting for tasks", 100000L);
   }

   public void run(R var1) {
      try {
         var1.run();
      } catch (Exception var6) {
         field1378.fatal("Error executing task on {}", this.getName(), var6);
         if (var6.getCause() instanceof OutOfMemoryError) {
            OutOfMemoryError var5 = (OutOfMemoryError)var6.getCause();
            throw var5;
         }
      }
   }
}
