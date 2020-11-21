package AOChips.ArmorUp.classes;

import AOChips.ArmorUp.ArmorUp;
import net.minecraft.command.arguments.NBTTagArgument;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.NBTTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = ArmorUp.AU, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class NBTTest {
    @SubscribeEvent
    public static void makeGlow(TickEvent.PlayerTickEvent event) {
        ItemStack stack = event.player.getHeldItemMainhand();
        PlayerEntity player = event.player;
        if (stack.hasTag()) {
            assert stack.getTag() != null;
            if ((stack.getTag()).hasUniqueId("glow")) {
                player.addPotionEffect(new EffectInstance(Effects.GLOWING, 10));
            }
        }
    }
}
