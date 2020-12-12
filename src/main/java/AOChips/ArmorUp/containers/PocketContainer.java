package AOChips.ArmorUp.containers;

import AOChips.ArmorUp.classes.ModContainerTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.*;
import net.minecraft.item.ItemStack;

public class PocketContainer extends Container {

    private final IInventory pocketInv;

    public static PocketContainer makeContainer(int id, PlayerInventory playerInventory) {
        return new PocketContainer(id, playerInventory);
    }

    public PocketContainer(int id, PlayerInventory playerInventory) {
        this(id, playerInventory, new Inventory(1));
    }

    public PocketContainer(int id, PlayerInventory playerInventory, IInventory pocketInvIn) {
        super(ModContainerTypes.POCKET_CONTAINER.get(), id);
        pocketInv = pocketInvIn;

        this.addSlot(new Slot(pocketInv, 0, 81, 36));

        // Main Inventory
        int startX = 8;
        int startY = 84;
        int slotSizePlus2 = 18;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startX + (column * slotSizePlus2),
                        startY + (row * slotSizePlus2)));
            }
        }

        // Hotbar
        for (int column = 0; column < 9; column++) {
            this.addSlot(new Slot(playerInventory, column, startX + (column * slotSizePlus2), 142));
        }
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }
    @Override
    public ItemStack transferStackInSlot (PlayerEntity playerIn, int index){
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index < 1) {
                if (!this.mergeItemStack(itemstack1, 1, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }
}