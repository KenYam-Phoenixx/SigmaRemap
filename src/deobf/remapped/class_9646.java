package remapped;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import java.util.Arrays;
import java.util.Collection;

public class class_9646 implements ArgumentType<CompoundNBT> {
   private static final Collection<String> field_49140 = Arrays.<String>asList("{}", "{foo=bar}");

   private class_9646() {
   }

   public static class_9646 method_44519() {
      return new class_9646();
   }

   public static <S> CompoundNBT method_44521(CommandContext<S> var0, String var1) {
      return (CompoundNBT)var0.getArgument(var1, CompoundNBT.class);
   }

   public CompoundNBT parse(StringReader var1) throws CommandSyntaxException {
      return new class_2392(var1).method_10905();
   }

   public Collection<String> getExamples() {
      return field_49140;
   }
}
