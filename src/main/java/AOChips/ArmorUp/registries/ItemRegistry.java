package AOChips.ArmorUp.registries;


import AOChips.ArmorUp.ArmorUp;
import AOChips.ArmorUp.lists.BlockList;
import AOChips.ArmorUp.lists.ItemList;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegistry {

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(

                ItemList.FORGING_TABLE = new BlockItem(BlockList.FORGING_TABLE, new Item.Properties().group(ArmorUp.AUTAB)).setRegistryName(BlockList.FORGING_TABLE.getRegistryName())

        );
    }
}
