package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Class9585 {
   private static String[] field44808;
   private List<Class8557> field44809 = new ArrayList<Class8557>();
   private List<BlockState> field44810 = new ArrayList<BlockState>();
   private List<Class8557> field44811 = Arrays.<Class8557>asList();

   public void method37212(Class8557 var1, BlockState var2) {
      if (var1 != null) {
         this.field44809.add(var1);
         this.field44810.add(var2);
      }
   }

   public int method37213() {
      return this.field44809.size();
   }

   public Class8557 method37214(int var1) {
      return this.field44809.get(var1);
   }

   public BlockState method37215(int var1) {
      return var1 >= 0 && var1 < this.field44810.size() ? this.field44810.get(var1) : Blocks.AIR.getDefaultState();
   }

   public List<Class8557> method37216(Class8557 var1) {
      this.field44811.set(0, var1);
      return this.field44811;
   }

   public void method37217() {
      this.field44809.clear();
      this.field44810.clear();
   }
}
