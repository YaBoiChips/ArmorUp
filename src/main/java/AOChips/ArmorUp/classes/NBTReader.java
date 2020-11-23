package AOChips.ArmorUp.classes;

import AOChips.ArmorUp.ArmorUp;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = ArmorUp.AU, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class NBTReader {
    @SubscribeEvent
    public static void makeGlow(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        World world = event.player.getEntityWorld();
        AxisAlignedBB axisalignedbb = (new AxisAlignedBB(player.getPosition())).grow(6).expand(0.0D, world.getHeight(), 0.0D);
        ItemStack stack = event.player.inventory.armorInventory.get(3);
        List<MobEntity> list = world.getEntitiesWithinAABB(MobEntity.class, axisalignedbb);
        for (MobEntity mobEntity : list)
            if (stack.hasTag()) {
                assert stack.getTag() != null;
                if (stack.getTag().getInt("glow") >= 1) {
                    mobEntity.addPotionEffect(new EffectInstance(Effects.GLOWING, 10, 0, false, false));
                }
            }
    }
    @SubscribeEvent
    public static void getLucky(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        ItemStack stack = event.player.inventory.armorInventory.get(0);
        if (stack.hasTag()) {
            if (stack.getTag().getInt("luck") >= 1) {
                player.addPotionEffect(new EffectInstance(Effects.LUCK, 100, 0, false, false));
            }
        }
    }

    @SubscribeEvent
    public static void getScared(TickEvent.PlayerTickEvent event) {
        World world = event.player.getEntityWorld();
        PlayerEntity player = event.player;
        ItemStack stack = event.player.inventory.armorInventory.get(0);
        if (stack.hasTag()) {
            if (stack.getTag().getInt("scared") >= 1 && player.getHealth() <= 4) {
                player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 500, 0, false, false));
            }
        }
    }

    @SubscribeEvent
    public static void getFrozen(TickEvent.PlayerTickEvent event) {
        World world = event.player.getEntityWorld();
        PlayerEntity player = event.player;
        ItemStack stack = event.player.inventory.armorInventory.get(2);
        if (stack.hasTag()) {
            if (stack.getTag().getInt("frozen") >= 1 && player.getHealth() <= 4) {
                player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 200, 250, false, false));
                player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 200, 13, false, false));
                player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 35, 2, false, false));
            }
        }
    }
}