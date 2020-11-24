package AOChips.ArmorUp.registries;


import AOChips.ArmorUp.ArmorUp;
import AOChips.ArmorUp.items.EssenceBottle;
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

                ItemList.FORGING_TABLE = new BlockItem(BlockList.FORGING_TABLE, new Item.Properties().group(ArmorUp.AUTAB)).setRegistryName(BlockList.FORGING_TABLE.getRegistryName()),
                ItemList.ESSENCE_BOTTLE = new EssenceBottle(new Item.Properties().group(ArmorUp.AUTAB)).setRegistryName("essence_bottle"),
                ItemList.SOUL_FIRE_ESSENCE = new Item(new Item.Properties().group(ArmorUp.AUTAB)).setRegistryName("soul_fire_essence"),
                ItemList.SHROOMLIGHT_ESSENCE = new Item(new Item.Properties().group(ArmorUp.AUTAB)).setRegistryName("shroomlight_essence"),
                ItemList.FROST_ESSENCE = new Item(new Item.Properties().group(ArmorUp.AUTAB)).setRegistryName("frost_essence"),
                ItemList.ENDER_ESSENCE = new Item(new Item.Properties().group(ArmorUp.AUTAB)).setRegistryName("ender_essence")
        );
    }
}
