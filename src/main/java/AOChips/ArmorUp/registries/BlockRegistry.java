package AOChips.ArmorUp.registries;

import AOChips.ArmorUp.ArmorUp;
import AOChips.ArmorUp.classes.ForgingTableBlock;
import AOChips.ArmorUp.lists.BlockList;
import AOChips.ArmorUp.lists.ItemList;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.ToIntFunction;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistry {

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(

                BlockList.FORGING_TABLE = new ForgingTableBlock(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(4.0f, 1.5f).sound(SoundType.ANCIENT_DEBRIS).setLightLevel(getLightValueLit(13)).harvestTool(ToolType.PICKAXE)).setRegistryName("forging_table")

        );
    }

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> state.get(BlockStateProperties.LIT) ? lightValue : 0;
    }
}

