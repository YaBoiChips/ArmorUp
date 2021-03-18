package AOChips.ArmorUp.client.keybind;

import AOChips.ArmorUp.ArmorUp;
import AOChips.ArmorUp.api.inventories.PocketInventory;
import AOChips.ArmorUp.containers.PocketContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.NetworkHooks;


@Mod.EventBusSubscriber(modid = ArmorUp.AU, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class KeyBindHandler {
    @SubscribeEvent
    public static void doPockets(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        ItemStack stack = event.player.getItemStackFromSlot(EquipmentSlotType.LEGS);
        if (player.getEntityWorld().isRemote){
        if (player instanceof ServerPlayerEntity) {
            if (stack.hasTag()) {
                if (stack.getTag().getInt("Pockets") >= 1) {
                    if (KeyBindingList.POCKET_KEY.isPressed()) {
                        NetworkHooks.openGui((ServerPlayerEntity) player, new SimpleNamedContainerProvider((id, playerInventory, entity) -> new PocketContainer(id, player.inventory, new PocketInventory()), player.getItemStackFromSlot(EquipmentSlotType.LEGS).getDisplayName()));
                    }
                    }
                }
            }
        }
    }
}