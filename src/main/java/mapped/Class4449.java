package mapped;

import com.google.common.collect.UnmodifiableIterator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Util;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import java.io.IOException;
import java.nio.file.Path;

public class Class4449 implements Class4442 {
   private static final Gson field21621 = new GsonBuilder().setPrettyPrinting().create();
   private final Class9068 field21622;

   public Class4449(Class9068 var1) {
      this.field21622 = var1;
   }

   @Override
   public void method14013(Class8297 var1) throws IOException {
      JsonObject var4 = new JsonObject();

      for (Block var6 : Registry.BLOCK) {
         ResourceLocation var7 = Registry.BLOCK.getKey(var6);
         JsonObject var8 = new JsonObject();
         StateContainer<Block, BlockState> var9 = var6.getStateContainer();
         if (!var9.method35395().isEmpty()) {
            JsonObject var10 = new JsonObject();

            for (Property var12 : var9.method35395()) {
               JsonArray var13 = new JsonArray();

               for (Object var15 : var12.method30474()) {
                  var13.add(Util.getValueName(var12, var15));
               }

               var10.add(var12.getName(), var13);
            }

            var8.add("properties", var10);
         }

         JsonArray var18 = new JsonArray();
         UnmodifiableIterator var19 = var9.getValidStates().iterator();

         while (var19.hasNext()) {
            BlockState var20 = (BlockState)var19.next();
            JsonObject var21 = new JsonObject();
            JsonObject var22 = new JsonObject();

            for (Property var16 : var9.method35395()) {
               var22.addProperty(var16.getName(), Util.getValueName(var16, var20.get(var16)));
            }

            if (var22.size() > 0) {
               var21.add("properties", var22);
            }

            var21.addProperty("id", Block.getStateId(var20));
            if (var20 == var6.getDefaultState()) {
               var21.addProperty("default", true);
            }

            var18.add(var21);
         }

         var8.add("states", var18);
         var4.add(var7.toString(), var8);
      }

      Path var17 = this.field21622.method33776().resolve("reports/blocks.json");
      Class4442.method14020(field21621, var1, var4, var17);
   }

   @Override
   public String method14012() {
      return "Block List";
   }
}
