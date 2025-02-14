package mapped;

import totalcross.json.JSONException;
import totalcross.json.JSONObject;

public class Class8351 {
   public String field35889;
   public int field35890;
   public int field35891;
   public int field35892;
   public float field35893 = 64.0F;
   public final boolean field35894;

   public Class8351(String var1, int var2, int var3, int var4) {
      this.field35890 = var2;
      this.field35891 = var3;
      this.field35889 = var1;
      this.field35892 = var4;
      this.field35894 = true;
   }

   public Class8351(String var1, int var2, int var3, int var4, int var5) {
      this.field35890 = var2;
      this.field35891 = var4;
      this.field35893 = (float)var3;
      this.field35889 = var1;
      this.field35892 = var5;
      this.field35894 = false;
   }

   public Class8351(JSONObject var1) throws JSONException {
      if (var1.has("name")) {
         this.field35889 = var1.getString("name");
      }

      if (var1.has("color")) {
         this.field35892 = var1.getInt("color");
      }

      if (var1.has("x")) {
         this.field35890 = var1.getInt("x");
      }

      if (var1.has("z")) {
         this.field35891 = var1.getInt("z");
      }

      this.field35894 = true;
   }

   public JSONObject method29263() {
      JSONObject var3 = new JSONObject();
      var3.put("name", this.field35889);
      var3.put("color", this.field35892);
      var3.put("x", this.field35890);
      var3.put("z", this.field35891);
      return var3;
   }

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         Class8351 var4 = (Class8351)var1;
         return var4.field35889.equals(this.field35889)
            && var4.field35890 == this.field35890
            && var4.field35891 == this.field35891
            && var4.field35892 == this.field35892;
      } else {
         return false;
      }
   }
}
