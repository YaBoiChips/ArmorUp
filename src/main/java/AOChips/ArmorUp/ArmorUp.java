package AOChips.ArmorUp;


import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("au")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArmorUp {
    public static final String AU = "au";
    public static Logger LOGGER = LogManager.getLogger();

    public ArmorUp() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
    }

    public static void register() {
        LOGGER.info("AU: Registered");
        Minecraft minecraftClient = Minecraft.getInstance();
    }

    private void commonSetup(FMLCommonSetupEvent e) {
        LOGGER.debug("AU: Common Setup event starting...");
        LOGGER.info("AU: Common Setup event finished.");
    }
    private void clientSetup(FMLClientSetupEvent e)
    {
        LOGGER.debug("AU: Client Setup event starting...");
    }
    public static final ItemGroup AUTAB = new ItemGroup("auTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.IRON_CHESTPLATE);
        }
    };
}
