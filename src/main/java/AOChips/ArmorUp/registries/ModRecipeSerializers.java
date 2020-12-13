package AOChips.ArmorUp.registries;

import AOChips.ArmorUp.ArmorUp;
import AOChips.ArmorUp.api.crafting.ForgingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class ModRecipeSerializers {
    public static final IRecipeSerializer<ForgingRecipe> FORGING = new ForgingRecipe.Serializer();

    @SubscribeEvent
    public void onRegisterSerializers(RegistryEvent.Register<IRecipeSerializer<?>> event) {
        event.getRegistry().registerAll(
                (FORGING.setRegistryName(new ResourceLocation(ArmorUp.AU, "forging")))
        );
    }
}
