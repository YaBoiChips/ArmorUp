package AOChips.ArmorUp.registries;

import AOChips.ArmorUp.ArmorUp;
import AOChips.ArmorUp.api.crafting.ForgingRecipe;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Optional;

public class ModRecipeTypes {

    public static final IRecipeType<ForgingRecipe> FORGING = new IRecipeType<ForgingRecipe>() {
        @Override
        public <C extends IInventory> Optional<ForgingRecipe> matches(IRecipe<C> recipe, World worldIn, C inv) {
            return recipe.matches(inv, worldIn) ? Optional.of((ForgingRecipe) recipe) : Optional.empty();
        }
    };

    static {
        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(ArmorUp.AU, "forging"), FORGING);
    }
}
