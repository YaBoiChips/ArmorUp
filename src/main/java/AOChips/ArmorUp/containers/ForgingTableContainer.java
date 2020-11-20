package AOChips.ArmorUp.containers;

import AOChips.ArmorUp.classes.ForgingRecipe;
import AOChips.ArmorUp.classes.ModContainerTypes;
import AOChips.ArmorUp.classes.ModRecipeTypes;
import AOChips.ArmorUp.lists.BlockList;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.AbstractRepairContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.world.World;

import java.util.List;

public class ForgingTableContainer extends AbstractRepairContainer {

    private final World world;
    private ForgingRecipe recipe;
    private final List<ForgingRecipe> forgingRecipe;


    public ForgingTableContainer(int windowId, PlayerInventory playerInv, PacketBuffer packetBuffer){
        this(windowId, playerInv, IWorldPosCallable.DUMMY);

    }


    public ForgingTableContainer(int windowId, PlayerInventory playerInv, IWorldPosCallable posCallable) {
        super(ModContainerTypes.FORGING_CONTAINER.get(), windowId, playerInv, posCallable);
        this.world = playerInv.player.world;
        this.forgingRecipe = this.world.getRecipeManager().getRecipesForType(ModRecipeTypes.FORGING);
    }

    @Override
    protected boolean func_230303_b_(PlayerEntity player, boolean p_230303_2_) {
        return this.recipe != null && this.recipe.matches(this.field_234643_d_, this.world);
    }

    @Override
    protected ItemStack func_230301_a_(PlayerEntity player, ItemStack itemStack){
        itemStack.onCrafting(player.world, player, itemStack.getCount());
        this.field_234642_c_.onCrafting(player);
        this.consumeItem(0);
        this.consumeItem(1);
        this.field_234644_e_.consume((p_234653_0_, p_234653_1_) -> {
            p_234653_0_.playEvent(1044, p_234653_1_, 0);
        });
        return itemStack;
    }

    private void consumeItem(int p_234654_1_) {
        ItemStack itemstack = this.field_234643_d_.getStackInSlot(p_234654_1_);
        itemstack.shrink(1);
        this.field_234643_d_.setInventorySlotContents(p_234654_1_, itemstack);
    }

    @Override
    protected boolean func_230302_a_(BlockState blockState) {
        return blockState.isIn(BlockList.FORGING_TABLE);
    }

    @Override
    public void updateRepairOutput() {
        List<ForgingRecipe> list = this.world.getRecipeManager().getRecipes(ModRecipeTypes.FORGING, this.field_234643_d_, this.world);
        if (list.isEmpty()) {
            this.field_234642_c_.setInventorySlotContents(0, ItemStack.EMPTY);
        } else {
            this.recipe = list.get(0);
            ItemStack itemstack = this.recipe.getCraftingResult(this.field_234643_d_);
            this.field_234642_c_.setRecipeUsed(this.recipe);
            this.field_234642_c_.setInventorySlotContents(0, itemstack);
        }

    }
}
