package AOChips.ArmorUp.registries;

import AOChips.ArmorUp.classes.blocks.DecayingStone;
import AOChips.ArmorUp.items.ForgingTableBlock;
import AOChips.ArmorUp.lists.BlockList;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.function.ToIntFunction;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistry {

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(

                BlockList.FORGING_TABLE = new ForgingTableBlock(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(4.0f, 1.5f).sound(SoundType.ANCIENT_DEBRIS).setLightLevel(getLightValueLit(13)).harvestTool(ToolType.PICKAXE)).setRegistryName("forging_table"),
                BlockList.DECAYING_STONE = new DecayingStone(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(4.0f, 1.5f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)).setRegistryName("decaying_stone"));

    }

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> state.get(BlockStateProperties.LIT) ? lightValue : 0;
    }
}

