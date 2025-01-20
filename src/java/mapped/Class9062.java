package mapped;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

import net.minecraft.command.CommandSource;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.util.text.TranslationTextComponent;

public class Class9062 implements ArgumentType<String> {
   private static final Collection<String> field41475 = Arrays.<String>asList("foo", "123");
   private static final DynamicCommandExceptionType field41476 = new DynamicCommandExceptionType(var0 -> new TranslationTextComponent("team.notFound", var0));

   public static Class9062 method33746() {
      return new Class9062();
   }

   public static ScorePlayerTeam method33747(CommandContext<CommandSource> var0, String var1) throws CommandSyntaxException {
      String var4 = (String)var0.getArgument(var1, String.class);
      ServerScoreboard var5 = ((CommandSource)var0.getSource()).getServer().method1409();
      ScorePlayerTeam var6 = var5.getTeam(var4);
      if (var6 != null) {
         return var6;
      } else {
         throw field41476.create(var4);
      }
   }

   public String parse(StringReader var1) throws CommandSyntaxException {
      return var1.readUnquotedString();
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      return !(var1.getSource() instanceof ISuggestionProvider) ? Suggestions.empty() : ISuggestionProvider.suggest(((ISuggestionProvider)var1.getSource()).getTeamNames(), var2);
   }

   public Collection<String> getExamples() {
      return field41475;
   }
}
