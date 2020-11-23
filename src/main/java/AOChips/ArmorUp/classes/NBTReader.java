package AOChips.ArmorUp.classes;

import AOChips.ArmorUp.ArmorUp;
import net.minecraft.command.arguments.NBTTagArgument;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.NBTTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Objects;

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
            if (stack.getTag().getInt("glow") >=1) {
                mobEntity.addPotionEffect(new EffectInstance(Effects.GLOWING, 10, 0, false, false));
            }
        }
    }

    @SubscribeEvent
    public static void getLucky(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        ItemStack stack = event.player.inventory.armorInventory.get(0);
        if (stack.hasTag()) {
            if (stack.getTag().getInt("luck") >=1) {
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
            if (stack.getTag().getInt("scared") >=1 && player.getHealth() <= 4) {
                player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 500, 0, false, false));
//                world.addParticle(ParticleTypes.LARGE_SMOKE, player.getPosXRandom(0.5D), player.getPosYRandom(), player.getPosZRandom(0.5D), 0.0D, 0.0D, 0.0D);
            }
        }
    }

}
