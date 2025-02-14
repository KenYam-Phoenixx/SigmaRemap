package net.minecraft.resources.data;

import net.minecraft.util.text.ITextComponent;

public class PackMetadataSection {
   private static String[] field29660;
   public static final PackMetadataSectionSerializer field29661 = new PackMetadataSectionSerializer();
   private final ITextComponent field29662;
   private final int field29663;

   public PackMetadataSection(ITextComponent var1, int var2) {
      this.field29662 = var1;
      this.field29663 = var2;
   }

   public ITextComponent method20752() {
      return this.field29662;
   }

   public int getPackFormat() {
      return this.field29663;
   }
}
