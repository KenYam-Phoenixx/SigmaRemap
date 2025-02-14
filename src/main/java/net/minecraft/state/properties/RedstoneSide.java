package net.minecraft.state.properties;

import net.minecraft.util.IStringSerializable;

public enum RedstoneSide implements IStringSerializable {
   field265("up"),
   field266("side"),
   field267("none");

   private final String field268;
   private static final RedstoneSide[] field269 = new RedstoneSide[]{field265, field266, field267};

   private RedstoneSide(String var3) {
      this.field268 = var3;
   }

   @Override
   public String toString() {
      return this.getString();
   }

   @Override
   public String getString() {
      return this.field268;
   }

   public boolean method279() {
      return this != field267;
   }
}
