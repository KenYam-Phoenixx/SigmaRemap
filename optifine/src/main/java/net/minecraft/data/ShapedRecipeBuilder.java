package net.minecraft.data;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.ICriterionInstance;
import net.minecraft.advancements.IRequirementsStrategy;
import net.minecraft.advancements.criterion.RecipeUnlockedTrigger;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.Tag;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapedRecipeBuilder
{
    private static final Logger LOGGER = LogManager.getLogger();
    private final Item result;
    private final int count;
    private final List<String> pattern = Lists.newArrayList();
    private final Map<Character, Ingredient> key = Maps.newLinkedHashMap();
    private final Advancement.Builder advancementBuilder = Advancement.Builder.builder();
    private String group;

    public ShapedRecipeBuilder(IItemProvider p_i1271_1_, int p_i1271_2_)
    {
        this.result = p_i1271_1_.asItem();
        this.count = p_i1271_2_;
    }

    public static ShapedRecipeBuilder shapedRecipe(IItemProvider resultIn)
    {
        return shapedRecipe(resultIn, 1);
    }

    public static ShapedRecipeBuilder shapedRecipe(IItemProvider resultIn, int countIn)
    {
        return new ShapedRecipeBuilder(resultIn, countIn);
    }

    public ShapedRecipeBuilder key(Character symbol, Tag<Item> tagIn)
    {
        return this.key(symbol, Ingredient.fromTag(tagIn));
    }

    public ShapedRecipeBuilder key(Character symbol, IItemProvider itemIn)
    {
        return this.key(symbol, Ingredient.fromItems(itemIn));
    }

    public ShapedRecipeBuilder key(Character symbol, Ingredient ingredientIn)
    {
        if (this.key.containsKey(symbol))
        {
            throw new IllegalArgumentException("Symbol '" + symbol + "' is already defined!");
        }
        else if (symbol == ' ')
        {
            throw new IllegalArgumentException("Symbol ' ' (whitespace) is reserved and cannot be defined");
        }
        else
        {
            this.key.put(symbol, ingredientIn);
            return this;
        }
    }

    public ShapedRecipeBuilder patternLine(String patternIn)
    {
        if (!this.pattern.isEmpty() && patternIn.length() != this.pattern.get(0).length())
        {
            throw new IllegalArgumentException("Pattern must be the same width on every line!");
        }
        else
        {
            this.pattern.add(patternIn);
            return this;
        }
    }

    public ShapedRecipeBuilder addCriterion(String name, ICriterionInstance criterionIn)
    {
        this.advancementBuilder.withCriterion(name, criterionIn);
        return this;
    }

    public ShapedRecipeBuilder setGroup(String groupIn)
    {
        this.group = groupIn;
        return this;
    }

    public void build(Consumer<IFinishedRecipe> consumerIn)
    {
        this.build(consumerIn, Registry.ITEM.getKey(this.result));
    }

    public void build(Consumer<IFinishedRecipe> consumerIn, String save)
    {
        ResourceLocation resourcelocation = Registry.ITEM.getKey(this.result);

        if ((new ResourceLocation(save)).equals(resourcelocation))
        {
            throw new IllegalStateException("Shaped Recipe " + save + " should remove its 'save' argument");
        }
        else
        {
            this.build(consumerIn, new ResourceLocation(save));
        }
    }

    public void build(Consumer<IFinishedRecipe> consumerIn, ResourceLocation id)
    {
        this.validate(id);
        this.advancementBuilder.withParentId(new ResourceLocation("recipes/root")).withCriterion("has_the_recipe", new RecipeUnlockedTrigger.Instance(id)).withRewards(AdvancementRewards.Builder.recipe(id)).withRequirementsStrategy(IRequirementsStrategy.OR);
        consumerIn.accept(new ShapedRecipeBuilder.Result(id, this.result, this.count, this.group == null ? "" : this.group, this.pattern, this.key, this.advancementBuilder, new ResourceLocation(id.getNamespace(), "recipes/" + this.result.getGroup().getPath() + "/" + id.getPath())));
    }

    private void validate(ResourceLocation id)
    {
        if (this.pattern.isEmpty())
        {
            throw new IllegalStateException("No pattern is defined for shaped recipe " + id + "!");
        }
        else
        {
            Set<Character> set = Sets.newHashSet(this.key.keySet());
            set.remove(' ');

            for (String s : this.pattern)
            {
                for (int i = 0; i < s.length(); ++i)
                {
                    char c0 = s.charAt(i);

                    if (!this.key.containsKey(c0) && c0 != ' ')
                    {
                        throw new IllegalStateException("Pattern in recipe " + id + " uses undefined symbol '" + c0 + "'");
                    }

                    set.remove(c0);
                }
            }

            if (!set.isEmpty())
            {
                throw new IllegalStateException("Ingredients are defined but not used in pattern for recipe " + id);
            }
            else if (this.pattern.size() == 1 && this.pattern.get(0).length() == 1)
            {
                throw new IllegalStateException("Shaped recipe " + id + " only takes in a single item - should it be a shapeless recipe instead?");
            }
            else if (this.advancementBuilder.getCriteria().isEmpty())
            {
                throw new IllegalStateException("No way of obtaining recipe " + id);
            }
        }
    }

    class Result implements IFinishedRecipe
    {
        private final ResourceLocation id;
        private final Item result;
        private final int count;
        private final String group;
        private final List<String> pattern;
        private final Map<Character, Ingredient> key;
        private final Advancement.Builder advancementBuilder;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation p_i886_2_, Item p_i886_3_, int p_i886_4_, String p_i886_5_, List<String> p_i886_6_, Map<Character, Ingredient> p_i886_7_, Advancement.Builder p_i886_8_, ResourceLocation p_i886_9_)
        {
            this.id = p_i886_2_;
            this.result = p_i886_3_;
            this.count = p_i886_4_;
            this.group = p_i886_5_;
            this.pattern = p_i886_6_;
            this.key = p_i886_7_;
            this.advancementBuilder = p_i886_8_;
            this.advancementId = p_i886_9_;
        }

        public void serialize(JsonObject json)
        {
            if (!this.group.isEmpty())
            {
                json.addProperty("group", this.group);
            }

            JsonArray jsonarray = new JsonArray();

            for (String s : this.pattern)
            {
                jsonarray.add(s);
            }

            json.add("pattern", jsonarray);
            JsonObject jsonobject = new JsonObject();

            for (Entry<Character, Ingredient> entry : this.key.entrySet())
            {
                jsonobject.add(String.valueOf(entry.getKey()), entry.getValue().serialize());
            }

            json.add("key", jsonobject);
            JsonObject jsonobject1 = new JsonObject();
            jsonobject1.addProperty("item", Registry.ITEM.getKey(this.result).toString());

            if (this.count > 1)
            {
                jsonobject1.addProperty("count", this.count);
            }

            json.add("result", jsonobject1);
        }

        public IRecipeSerializer<?> getSerializer()
        {
            return IRecipeSerializer.CRAFTING_SHAPED;
        }

        public ResourceLocation getID()
        {
            return this.id;
        }

        @Nullable
        public JsonObject getAdvancementJson()
        {
            return this.advancementBuilder.serialize();
        }

        @Nullable
        public ResourceLocation getAdvancementID()
        {
            return this.advancementId;
        }
    }
}
