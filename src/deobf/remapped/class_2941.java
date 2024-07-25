package remapped;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class class_2941 extends Module {
   private List<Entity> field_14300 = new ArrayList<Entity>();

   public class_2941() {
      super(Category.COMBAT, "BowAimbot", "Automatically aims at players while using a bow");
      this.addSetting(new ModeSetting("Sort mode", "Sort mode", 0, "Angle", "Range"));
      this.addSetting(new FloatSetting<Float>("Range", "Range value", 70.0F, Float.class, 10.0F, 100.0F, 1.0F));
      this.addSetting(new BooleanSetting("Silent", "Server-sided rotations.", false));
      this.addSetting(new BooleanSetting("Teams", "Target team", true));
      this.addSetting(new BooleanSetting("Players", "Target players", true));
      this.addSetting(new BooleanSetting("Animals/Monsters", "Target animals and monsters", false));
      this.addSetting(new BooleanSetting("Anti-Bot", "Doesn't target bots", true));
      this.addSetting(new BooleanSetting("Invisible", "Target invisible entites", true));
   }

   @Override
   public void method_42020() {
      this.field_14300.clear();
   }

   @class_9148
   private void method_13455(class_1393 var1) {
      if (this.method_42015() && var1.method_6449()) {
         if (!(mcInstance.field_9632.method_26576().method_27960() instanceof class_2100)) {
            this.field_14300.clear();
         } else {
            this.field_14300 = this.method_13451(this.method_42017().method_42002("Range"));
         }

         if (!this.field_14300.isEmpty() && this.method_42007("Silent")) {
            float[] var4 = class_7211.method_33005((class_5834)this.field_14300.get(0));
            var1.method_6441(var4[0]);
            var1.method_6448(var4[1]);
         }
      }
   }

   @class_9148
   private void method_13456(class_3278 var1) {
      if (this.method_42015() && !this.method_42007("Silent")) {
         if (!this.field_14300.isEmpty()) {
            float[] var4 = class_7211.method_33005((class_5834)this.field_14300.get(0));
            mcInstance.field_9632.field_41701 = var4[0];
            mcInstance.field_9632.field_41755 = var4[1];
         }
      }
   }

   public List<Entity> method_13451(float var1) {
      List var4 = class_314.method_1440();
      Iterator var5 = var4.iterator();

      while (var5.hasNext()) {
         Entity var6 = (Entity)var5.next();
         if (var6 == mcInstance.field_9632) {
            var5.remove();
         } else if (SigmaMainClass.method_3328().method_3307().method_14460(var6)) {
            var5.remove();
         } else if (!(var6 instanceof class_5834)) {
            var5.remove();
         } else if (((class_5834)var6).method_26551() == 0.0F) {
            var5.remove();
         } else if (mcInstance.field_9632.method_37175(var6) > var1) {
            var5.remove();
         } else if (!mcInstance.field_9632.method_26608((class_5834)var6)) {
            var5.remove();
         } else if (var6 instanceof class_9399) {
            var5.remove();
         } else if (!this.method_42007("Players") && var6 instanceof class_704) {
            var5.remove();
         } else if (this.method_42007("Anti-Bot") && var6 instanceof class_704 && SigmaMainClass.method_3328().method_3331().method_20495(var6)) {
            var5.remove();
         } else if (!this.method_42007("Invisible") && var6.method_37109()) {
            var5.remove();
         } else if (!this.method_42007("Animals/Monsters") && !(var6 instanceof class_704)) {
            var5.remove();
         } else if (mcInstance.field_9632.method_37243() != null && mcInstance.field_9632.method_37243().equals(var6)) {
            var5.remove();
         } else if (var6.method_37367()) {
            var5.remove();
         } else if (var6 instanceof class_704 && class_5876.method_26760((class_704)var6) && !this.method_42007("Teams")) {
            var5.remove();
         }
      }

      String var8 = this.method_42016("Sort mode");
      switch (var8) {
         case "Range":
            Collections.sort(var4, new class_202(this));
            break;
         case "Angle":
            Collections.sort(var4, new class_4878(this));
      }

      return var4;
   }
}
