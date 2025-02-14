package mapped;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.minecraft.command.CommandSource;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Class9082 implements ArgumentType<ResourceLocation> {
   private static final Collection<String> field41582 = Stream.<RegistryKey>of(World.OVERWORLD, World.THE_NETHER)
      .<String>map(var0 -> var0.getLocation().toString())
      .collect(Collectors.<String>toList());
   private static final DynamicCommandExceptionType field41583 = new DynamicCommandExceptionType(
      var0 -> new TranslationTextComponent("argument.dimension.invalid", var0)
   );

   public ResourceLocation parse(StringReader var1) throws CommandSyntaxException {
      return ResourceLocation.method8294(var1);
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      return !(var1.getSource() instanceof ISuggestionProvider)
         ? Suggestions.empty()
         : ISuggestionProvider.method20143(((ISuggestionProvider)var1.getSource()).method20135().stream().<ResourceLocation>map(RegistryKey::getLocation), var2);
   }

   public Collection<String> getExamples() {
      return field41582;
   }

   public static Class9082 method33872() {
      return new Class9082();
   }

   public static ServerWorld method33873(CommandContext<CommandSource> var0, String var1) throws CommandSyntaxException {
      ResourceLocation var4 = (ResourceLocation)var0.getArgument(var1, ResourceLocation.class);
      RegistryKey var5 = RegistryKey.<World>getOrCreateKey(Registry.WORLD_KEY, var4);
      ServerWorld var6 = ((CommandSource)var0.getSource()).getServer().method1318(var5);
      if (var6 != null) {
         return var6;
      } else {
         throw field41583.create(var4);
      }
   }
}
