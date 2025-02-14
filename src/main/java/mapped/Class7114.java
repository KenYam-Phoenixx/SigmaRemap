package mapped;

import com.mojang.datafixers.DSL;
import com.mojang.datafixers.DataFix;
import com.mojang.datafixers.Typed;
import com.mojang.datafixers.DSL.TypeReference;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.Type;
import com.mojang.serialization.Dynamic;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Class7114 extends DataFix {
   public static final Logger field30633 = LogManager.getLogger();
   public TypeReference field30634;

   public Class7114(Schema var1, TypeReference var2) {
      super(var1, false);
      this.field30634 = var2;
   }

   public Typed<?> method22155(Typed<?> var1, String var2, Function<Dynamic<?>, Dynamic<?>> var3) {
      Type var6 = this.getInputSchema().getChoiceType(this.field30634, var2);
      Type var7 = this.getOutputSchema().getChoiceType(this.field30634, var2);
      return var1.updateTyped(DSL.namedChoice(var2, var6), var7, var1x -> var1x.update(DSL.remainderFinder(), var3));
   }

   public static Optional<Dynamic<?>> method22156(Dynamic<?> var0, String var1, String var2) {
      return method22159(var0, var1).<Dynamic<?>>map(var3 -> var0.remove(var1).set(var2, var3));
   }

   public static Optional<Dynamic<?>> method22157(Dynamic<?> var0, String var1, String var2) {
      return var0.get(var1).result().<Dynamic<?>>flatMap(Class7114::method22160).<Dynamic<?>>map(var3 -> var0.remove(var1).set(var2, var3));
   }

   public static Optional<Dynamic<?>> method22158(Dynamic<?> var0, String var1, String var2) {
      String var5 = var1 + "Most";
      String var6 = var1 + "Least";
      return method22161(var0, var5, var6).<Dynamic<?>>map(var4 -> var0.remove(var5).remove(var6).set(var2, var4));
   }

   public static Optional<Dynamic<?>> method22159(Dynamic<?> var0, String var1) {
      return var0.get(var1).result().<Dynamic<?>>flatMap(var1x -> {
         String var4 = var1x.asString((String)null);
         if (var4 != null) {
            try {
               UUID var5 = UUID.fromString(var4);
               return method22162(var0, var5.getMostSignificantBits(), var5.getLeastSignificantBits());
            } catch (IllegalArgumentException var6) {
            }
         }

         return Optional.empty();
      });
   }

   public static Optional<Dynamic<?>> method22160(Dynamic<?> var0) {
      return method22161((Dynamic<?>)var0, "M", "L");
   }

   public static Optional<Dynamic<?>> method22161(Dynamic<?> var0, String var1, String var2) {
      long var5 = var0.get(var1).asLong(0L);
      long var7 = var0.get(var2).asLong(0L);
      return var5 != 0L && var7 != 0L ? method22162(var0, var5, var7) : Optional.<Dynamic<?>>empty();
   }

   public static Optional<Dynamic<?>> method22162(Dynamic<?> var0, long var1, long var3) {
      return Optional.<Dynamic<?>>of(var0.createIntList(Arrays.stream(new int[]{(int)(var1 >> 32), (int)var1, (int)(var3 >> 32), (int)var3})));
   }
}
