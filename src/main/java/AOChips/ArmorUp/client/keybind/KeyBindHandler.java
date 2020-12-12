package AOChips.ArmorUp.client.keybind;

import AOChips.ArmorUp.ArmorUp;
import AOChips.ArmorUp.containers.PocketContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = ArmorUp.AU, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class KeyBindHandler {
    @SubscribeEvent
    public static void doPockets(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        BlockPos pos = player.getPosition();
        if(player instanceof ServerPlayerEntity){
        if (KeyBindingList.POCKET_KEY.isKeyDown()) {
            System.out.println("pog");
            player.openContainer(new SimpleNamedContainerProvider((id, playerInventory, entity) -> new PocketContainer(id, player.inventory, new Inventory()), player.getItemStackFromSlot(EquipmentSlotType.LEGS).getDisplayName()));

        }
        }
    }
}