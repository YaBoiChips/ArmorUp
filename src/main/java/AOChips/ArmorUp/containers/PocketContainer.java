package AOChips.ArmorUp.containers;

import AOChips.ArmorUp.registries.ModContainerTypes;
import AOChips.ArmorUp.containers.slots.PocketSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.*;
import net.minecraft.item.ItemStack;

public class PocketContainer extends Container {

    private final IInventory pocketInv;

    public PocketContainer(int id, PlayerInventory playerInventory) {
        this(id, playerInventory, new Inventory(1));
    }

    public PocketContainer(int id, PlayerInventory playerInventory, IInventory pocketInvIn) {
        super(ModContainerTypes.POCKET_CONTAINER.get(), id);
        assertInventorySize(pocketInvIn, 1);
        this.pocketInv = pocketInvIn;


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
        for (int x = 0; x < 1; x++) {
            this.addSlot(new PocketSlot(pocketInv, x, 81, 36));
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
            itemstack = slot.getStack().copy();
            if (index < 1) {
                if (!this.mergeItemStack(itemstack, 1, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack, 0, 1, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemstack;
    }

    @Override
    public void onContainerClosed(PlayerEntity playerIn) {
        super.onContainerClosed(playerIn);
        this.pocketInv.closeInventory(playerIn);

    }


}