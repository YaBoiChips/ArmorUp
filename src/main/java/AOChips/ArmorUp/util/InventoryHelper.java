package AOChips.ArmorUp.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;

import java.util.concurrent.atomic.AtomicReference;

public class InventoryHelper {
    public static ListNBT saveAllItems(ListNBT list, Inventory inventory) {
        for (int i = 0; i < inventory.getSizeInventory(); ++i) {
            ItemStack itemstack = inventory.getStackInSlot(i);
            if (!itemstack.isEmpty()) {
                CompoundNBT compound = new CompoundNBT();
                compound.putByte("Slot", (byte) i);
                itemstack.write(compound);
                list.add(compound);
            }
        }
        return list;
    }

    public static void loadAllItems(ListNBT list, Inventory inventory) {
        for (int i = 0; i < list.size(); i++) {
            CompoundNBT compound = list.getCompound(i);
            int slot = compound.getByte("Slot") & 255;
            if (slot < inventory.getSizeInventory()) {
                inventory.setInventorySlotContents(slot, ItemStack.read(compound));
            }
        }
    }

    public static ItemStack getPocketStack(PlayerEntity player) {
        AtomicReference<ItemStack> pocket = new AtomicReference<>(ItemStack.EMPTY);
        if (player.inventory instanceof PlayerInventory) {

            PlayerInventory inventory = (PlayerInventory) player.inventory;
            pocket.set(inventory.armorInventory.get(1));
        }
        return pocket.get();
    }
}
