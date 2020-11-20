package AOChips.ArmorUp.classes;

import AOChips.ArmorUp.lists.BlockList;
import com.google.gson.JsonObject;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ForgingRecipe implements IRecipe<IInventory> {

    private final Ingredient base;
    private final Ingredient addition;
    private final ItemStack result;
    private final ResourceLocation recipeId;

    public ForgingRecipe(ResourceLocation recipeId, Ingredient base, Ingredient addition, ItemStack result) {
        this.recipeId = recipeId;
        this.base = base;
        this.addition = addition;
        this.result = result;
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        return this.base.test(inv.getStackInSlot(0)) && this.addition.test(inv.getStackInSlot(1));
    }

    @Override
    public ItemStack getCraftingResult(IInventory inv) {
        ItemStack itemStack =this.result.copy();
        CompoundNBT compoundNBT = inv.getStackInSlot(0).getTag();
        CompoundNBT itemTag = new CompoundNBT();
        if (compoundNBT != null){
            itemStack.setTag(compoundNBT.getCompound("glow"));
        }
        return itemStack;
    }

    @Override
    public boolean canFit(int width, int height) {
        return width * height >=2;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.result;
    }

    public boolean isValidAdditionItem(ItemStack addition) {
        return this.addition.test(addition);
    }

    @Override
    public ItemStack getIcon() {
        return new ItemStack(BlockList.FORGING_TABLE);
    }

    @Override
    public ResourceLocation getId() {
        return this.recipeId;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipeSerializer.FORGING;
    }

    @Override
    public IRecipeType<?> getType() {
        return ModRecipeTypes.FORGING;
    }
    public static class Serializer extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>> implements ModRecipeSerializer<ForgingRecipe> {
        public ForgingRecipe read(ResourceLocation recipeId, JsonObject json) {
            Ingredient ingredient = Ingredient.deserialize(JSONUtils.getJsonObject(json, "base"));
            Ingredient ingredient1 = Ingredient.deserialize(JSONUtils.getJsonObject(json, "addition"));
            ItemStack itemstack = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"));
            return new ForgingRecipe(recipeId, ingredient, ingredient1, itemstack);
        }

        public ForgingRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
            Ingredient ingredient = Ingredient.read(buffer);
            Ingredient ingredient1 = Ingredient.read(buffer);
            ItemStack itemstack = buffer.readItemStack();
            return new ForgingRecipe(recipeId, ingredient, ingredient1, itemstack);
        }

        @Override
        public void write(PacketBuffer buffer, ForgingRecipe recipe) {
            recipe.base.write(buffer);
            recipe.addition.write(buffer);
            buffer.writeItemStack(recipe.result);

        }
    }
}
