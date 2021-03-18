package AOChips.ArmorUp.api.crafting;

import AOChips.ArmorUp.lists.BlockList;
import AOChips.ArmorUp.lists.ItemList;
import AOChips.ArmorUp.registries.ModRecipeSerializers;
import AOChips.ArmorUp.registries.ModRecipeTypes;
import com.google.gson.JsonObject;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ForgingRecipe implements IRecipe<IInventory>, IForgingRecipe {

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

        for (int j = 0; j < inv.getSizeInventory(); ++j) {
            ItemStack itemStack1 = inv.getStackInSlot(1);
            ItemStack itemStack2 = this.result;
            CompoundNBT compoundnbt = itemStack2.getTag().copy();
            if (itemStack1.getItem() == ItemList.SHROOMLIGHT_ESSENCE) {
                compoundnbt.putInt("Glowing", 1);
                itemStack2.setTag(compoundnbt);
                return itemStack2;
            } else if (itemStack1.getItem() == Items.RABBIT_FOOT) {
                compoundnbt.putInt("Lucky", 1);
                itemStack2.setTag(compoundnbt);
                return itemStack2;
            } else if (itemStack1.getItem() == Items.GHAST_TEAR) {
                compoundnbt.putInt("Scared", 1);
                itemStack2.setTag(compoundnbt);
                return itemStack2;
            } else if (itemStack1.getItem() == ItemList.FROST_ESSENCE) {
                compoundnbt.putInt("Frozen", 1);
                itemStack2.setTag(compoundnbt);
                return itemStack2;
            } else if (itemStack1.getItem() == Items.SLIME_BALL) {
                compoundnbt.putInt("Bouncy", 1);
                itemStack2.setTag(compoundnbt);
                return itemStack2;
            } else if (itemStack1.getItem() == Items.MAGMA_CREAM) {
                compoundnbt.putInt("Magma Walker", 1);
                itemStack2.setTag(compoundnbt);
                return itemStack2;
            } else if (itemStack1.getItem() == ItemList.ENDER_ESSENCE) {
                compoundnbt.putInt("Sight", 1);
                itemStack2.setTag(compoundnbt);
                return itemStack2;
            } else if (itemStack1.getItem() == ItemList.SHULKER_ESSENCE) {
                compoundnbt.putInt("Avoid", 1);
                itemStack2.setTag(compoundnbt);
                return itemStack2;
            } else if (itemStack1.getItem() == Items.SHULKER_BOX) {
                compoundnbt.putInt("Pockets", 1);
                itemStack2.setTag(compoundnbt);
                return itemStack2;
            } else if (itemStack1.getItem() == Items.LAVA_BUCKET) {
                compoundnbt.putInt("Lava Walker", 1);
                itemStack2.setTag(compoundnbt);
                return itemStack2;
            } else if (itemStack1.getItem() == Items.ELYTRA) {
                compoundnbt.putInt("Rocket Pants", 1);
                itemStack2.setTag(compoundnbt);
                return itemStack2;
            }
        }
            return this.result.copy();
        }

    @Override
    public boolean canFit(int width, int height) {
        return width * height >= 2;
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
        return ModRecipeSerializers.FORGING;
    }

    @Override
    public IRecipeType<?> getType() {
        return ModRecipeTypes.FORGING;
    }

    @Override
    public int getLavaCost() {
        return 20;
    }


    public static class Serializer extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ForgingRecipe> {

        @Override
        public void write(PacketBuffer buffer, ForgingRecipe recipe) {
            recipe.base.write(buffer);
            recipe.addition.write(buffer);
            buffer.writeItemStack(recipe.result);

        }

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

    }
}