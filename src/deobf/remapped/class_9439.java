package remapped;

public class class_9439 extends Module {
   public class_9439() {
      super(Category.EXPLOIT, "Null", "Makes you invisible for the anticheat.");
      this.addSetting(new BooleanSetting("Inv Bypass", "Avoid inventory glitchs on some servers", false));
   }

   @class_9148
   public void method_43668(class_139 var1) {
      if (this.method_42015() && mcInstance.method_8530() != null) {
         if (!(var1.method_557() instanceof class_7573)) {
            if (var1.method_557() instanceof class_8913) {
               class_8913 var4 = (class_8913)var1.method_557();
               if (var4.method_40996() < 0 || !this.method_42007("Inv Bypass")) {
                  var1.method_29715(true);
               }
            }
         } else {
            var1.method_29715(true);
         }
      }
   }
}
