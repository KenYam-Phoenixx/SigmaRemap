package mapped;

import com.google.gson.JsonObject;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public interface Class6504<T extends IRecipe<?>> {
   Class6504<Class4852> field28470 = method19702("crafting_shaped", new Class6507());
   Class6504<Class4854> field28471 = method19702("crafting_shapeless", new Class6506());
   Class6505<Class4839> field28472 = method19702("crafting_special_armordye", new Class6505<Class4839>(Class4839::new));
   Class6505<Class4857> field28473 = method19702("crafting_special_bookcloning", new Class6505<Class4857>(Class4857::new));
   Class6505<Class4840> field28474 = method19702("crafting_special_mapcloning", new Class6505<Class4840>(Class4840::new));
   Class6505<Class4853> field28475 = method19702("crafting_special_mapextending", new Class6505<Class4853>(Class4853::new));
   Class6505<Class4859> field28476 = method19702("crafting_special_firework_rocket", new Class6505<Class4859>(Class4859::new));
   Class6505<Class4860> field28477 = method19702("crafting_special_firework_star", new Class6505<Class4860>(Class4860::new));
   Class6505<Class4855> field28478 = method19702("crafting_special_firework_star_fade", new Class6505<Class4855>(Class4855::new));
   Class6505<Class4856> field28479 = method19702("crafting_special_tippedarrow", new Class6505<Class4856>(Class4856::new));
   Class6505<Class4861> field28480 = method19702("crafting_special_bannerduplicate", new Class6505<Class4861>(Class4861::new));
   Class6505<Class4841> field28481 = method19702("crafting_special_shielddecoration", new Class6505<Class4841>(Class4841::new));
   Class6505<Class4838> field28482 = method19702("crafting_special_shulkerboxcoloring", new Class6505<Class4838>(Class4838::new));
   Class6505<Class4836> field28483 = method19702("crafting_special_suspiciousstew", new Class6505<Class4836>(Class4836::new));
   Class6505<Class4858> field28484 = method19702("crafting_special_repairitem", new Class6505<Class4858>(Class4858::new));
   Class6503<FurnaceRecipe> field28485 = method19702("smelting", new Class6503<FurnaceRecipe>(FurnaceRecipe::new, 200));
   Class6503<BlastingRecipe> field28486 = method19702("blasting", new Class6503<BlastingRecipe>(BlastingRecipe::new, 100));
   Class6503<SmokingRecipe> field28487 = method19702("smoking", new Class6503<SmokingRecipe>(SmokingRecipe::new, 100));
   Class6503<CampfireCookingRecipe> field28488 = method19702("campfire_cooking", new Class6503<CampfireCookingRecipe>(CampfireCookingRecipe::new, 100));
   Class6504<StonecuttingRecipe> field28489 = method19702("stonecutting", new Class6508<StonecuttingRecipe>(StonecuttingRecipe::new));
   Class6504<SmithingRecipe> field28490 = method19702("smithing", new Class6509());

   T method19700(ResourceLocation var1, JsonObject var2);

   T method19699(ResourceLocation var1, PacketBuffer var2);

   void method19698(PacketBuffer var1, T var2);

   static <S extends Class6504<T>, T extends IRecipe<?>> S method19702(String var0, S var1) {
      return Registry.<S>register(Registry.field16086, var0, (S)var1);
   }
}
