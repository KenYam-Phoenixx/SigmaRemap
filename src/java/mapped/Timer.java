package mapped;

public class Timer {
   private long field40276;
   private long field40277;
   private boolean field40278;
   public final AnimationManager field40279;

   public Timer(AnimationManager var1) {
      this.field40279 = var1;
      this.field40276 = 0L;
      this.field40277 = 0L;
      this.field40278 = false;
   }

   public void method32437() {
      this.field40278 = true;
      this.field40276 = System.currentTimeMillis();
   }

   public void method32438() {
      this.field40278 = false;
   }

   public void method32439() {
      this.field40277 = 0L;
      this.field40276 = System.currentTimeMillis();
   }

   public long method32440() {
      if (this.field40278) {
         this.field40277 = this.field40277 + (System.currentTimeMillis() - this.field40276);
         this.field40276 = System.currentTimeMillis();
      }

      return this.field40277;
   }

   public boolean method32441() {
      return this.field40278;
   }
}
