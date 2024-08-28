package mapped;

import com.google.common.collect.Multimap;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

public class Class286 implements Class268 {
   private final Class9768<Block> field1088 = new Class9768<Block>(Registry.field16072::method9187, "tags/blocks", "block");
   private final Class9768<Class3257> field1089 = new Class9768<Class3257>(Registry.field16075::method9187, "tags/items", "item");
   private final Class9768<Class7631> field1090 = new Class9768<Class7631>(Registry.field16070::method9187, "tags/fluids", "fluid");
   private final Class9768<Class8992<?>> field1091 = new Class9768<Class8992<?>>(Registry.field16074::method9187, "tags/entity_types", "entity_type");
   private Class8933 field1092 = Class8933.field40418;

   public Class8933 method1068() {
      return this.field1092;
   }

   @Override
   public CompletableFuture<Void> method777(Class7121 var1, Class191 var2, Class7165 var3, Class7165 var4, Executor var5, Executor var6) {
      CompletableFuture<Map<ResourceLocation, Class6879>> var9 = this.field1088.method38419(var2, var5);
      CompletableFuture<Map<ResourceLocation, Class6879>> var10 = this.field1089.method38419(var2, var5);
      CompletableFuture<Map<ResourceLocation, Class6879>> var11 = this.field1090.method38419(var2, var5);
      CompletableFuture<Map<ResourceLocation, Class6879>> var12 = this.field1091.method38419(var2, var5);
      return CompletableFuture.allOf(var9, var10, var11, var12)
         .<Void>thenCompose(var1::method22225)
         .thenAcceptAsync(
            var5x -> {
               Class7984 var8 = this.field1088.method38420(var9.join());
               Class7984 var9x = this.field1089.method38420(var10.join());
               Class7984 var10x = this.field1090.method38420(var11.join());
               Class7984 var11x = this.field1091.method38420(var12.join());
               Class8933 var12x = Class8933.method32664(var8, var9x, var10x, var11x);
               Multimap<ResourceLocation, ResourceLocation> var13 = Class8384.method29380(var12x);
               if (var13.isEmpty()) {
                  Class9443.method36297(var12x);
                  this.field1092 = var12x;
               } else {
                  throw new IllegalStateException(
                     "Missing required tags: "
                        + var13.entries().stream().map(var0 -> var0.getKey() + ":" + var0.getValue()).sorted().collect(Collectors.joining(","))
                  );
               }
            },
            var6
         );
   }
}
