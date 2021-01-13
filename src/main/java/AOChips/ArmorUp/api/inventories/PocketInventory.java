package AOChips.ArmorUp.api.inventories;


import AOChips.ArmorUp.util.InventoryHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
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
            this.clear();
            ItemStack pocket = InventoryHelper.getPocketStack(player);
            if (!pocket.isEmpty()) {
                CompoundNBT compound = pocket.getTag();
                if (compound != null) {
                    if (compound.contains("Items", Constants.NBT.TAG_LIST)) {
                        InventoryHelper.loadAllItems(compound.getList("Items", Constants.NBT.TAG_COMPOUND), this);
                    }
                }
            }
        }
    }

    @Override
    public void closeInventory(PlayerEntity player) {
        ItemStack pocket = InventoryHelper.getPocketStack(player);
        CompoundNBT compound = pocket.getTag();
        if (compound == null) {
            compound = new CompoundNBT();
        }
        ListNBT list = new ListNBT();
        InventoryHelper.saveAllItems(list, this);
        compound.put("Items", list);
        pocket.setTag(compound);
    }
}



