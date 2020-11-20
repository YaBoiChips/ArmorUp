package AOChips.ArmorUp.classes;

import AOChips.ArmorUp.ArmorUp;
import AOChips.ArmorUp.containers.ForgingTableContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, ArmorUp.AU);

    public static final RegistryObject<ContainerType<ForgingTableContainer>> FORGING_CONTAINER = CONTAINER_TYPES
            .register("forge_container", () -> IForgeContainerType.create(ForgingTableContainer::new));

    }

