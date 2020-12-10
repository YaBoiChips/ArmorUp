package AOChips.ArmorUp;


import AOChips.ArmorUp.classes.ModContainerTypes;
import AOChips.ArmorUp.classes.ModRecipeSerializers;
import AOChips.ArmorUp.classes.ModRecipeTypes;
import AOChips.ArmorUp.client.ToolTipEvent;
import AOChips.ArmorUp.client.gui.ForgingTableScreen;
import AOChips.ArmorUp.lists.ItemList;
import AOChips.ArmorUp.registries.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

@Mod("au")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArmorUp {
    public static final String AU = "au";
    public static Logger LOGGER = LogManager.getLogger();

    public ArmorUp() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
        modEventBus.register(new ModRecipeSerializers());
        MinecraftForge.EVENT_BUS.register(new ToolTipEvent());
    }

    public static void register() {
        LOGGER.info("AU: Registered");
        Minecraft minecraftClient = Minecraft.getInstance();
    }

    private void commonSetup(FMLCommonSetupEvent e) {
        LOGGER.debug("AU: Common Setup event starting...");
        LOGGER.info("AU: Common Setup event finished.");
    }
    private void clientSetup(FMLClientSetupEvent e) {
        LOGGER.debug("AU: Client Setup event starting...");
        ScreenManager.registerFactory(ModContainerTypes.FORGING_CONTAINER.get(), ForgingTableScreen::new);
    }
    public static final ItemGroup AUTAB = new ItemGroup("auTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.IRON_CHESTPLATE);
        }
    };
}
