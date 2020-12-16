package AOChips.ArmorUp.api.inventories;

import AOChips.ArmorUp.util.InventoryHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class PocketInventory extends Inventory {

    public PocketInventory() {
        super(1);
    }

    @Override
    public boolean isUsableByPlayer(PlayerEntity player) {
        return true;
    }

    @Override
    public void openInventory(PlayerEntity player) {
        if (player instanceof ServerPlayerEntity) {
            ItemStack pocket = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
            if (!pocket.isEmpty()) {
                CompoundNBT compoundNBT = pocket.getTag();
                if (compoundNBT != null) {
                    if (compoundNBT.contains("Items", Constants.NBT.TAG_LIST)) {
                        InventoryHelper.loadAllItems(compoundNBT.getList("Items", Constants.NBT.TAG_LIST), this);
                    }
                }
            }
        }
    }


    @Override
    public void closeInventory(PlayerEntity player) {
        if (player instanceof ServerPlayerEntity) {
            ItemStack pocket = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
            if (!pocket.isEmpty()) {
                CompoundNBT compoundNBT = pocket.getTag();
                if (compoundNBT == null) {
                    compoundNBT = new CompoundNBT();
                }
                ListNBT listNBT = new ListNBT();
                InventoryHelper.saveAllItems(listNBT, this);
                compoundNBT.put("Items", listNBT);
                pocket.setTag(compoundNBT);
            }
        }
    }
}

