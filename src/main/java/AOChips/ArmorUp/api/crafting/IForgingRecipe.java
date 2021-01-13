package AOChips.ArmorUp.api.crafting;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;

public interface IForgingRecipe extends IRecipe<IInventory> {
    int getLavaCost();
}
