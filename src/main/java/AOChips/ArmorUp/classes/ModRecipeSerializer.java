package AOChips.ArmorUp.classes;

import com.google.gson.JsonObject;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SmithingRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public interface ModRecipeSerializer<T extends IRecipe<?>> extends net.minecraftforge.registries.IForgeRegistryEntry<IRecipeSerializer<?>> {
    IRecipeSerializer<SmithingRecipe> FORGING = register("forging", new SmithingRecipe.Serializer());

    T read(ResourceLocation recipeId, JsonObject json);

    @javax.annotation.Nullable
    T read(ResourceLocation recipeId, PacketBuffer buffer);

    void write(PacketBuffer buffer, T recipe);

    static <S extends IRecipeSerializer<T>, T extends IRecipe<?>> S register(String key, S recipeSerializer) {
        return Registry.register(Registry.RECIPE_SERIALIZER, key, recipeSerializer);
    }
}
