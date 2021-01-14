package AOChips.ArmorUp.classes;

import AOChips.ArmorUp.ArmorUp;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
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
        ItemStack stack = event.player.getItemStackFromSlot(EquipmentSlotType.HEAD);
        List<MobEntity> list = world.getEntitiesWithinAABB(MobEntity.class, axisalignedbb);
        for (MobEntity mobEntity : list)
            if (stack.hasTag()) {
                if (stack.getTag().getInt("Glowing") >= 1) {
                    mobEntity.addPotionEffect(new EffectInstance(Effects.GLOWING, 10, 0, false, false));
                }
            }
    }

    @SubscribeEvent
    public static void getLucky(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        ItemStack stack = event.player.getItemStackFromSlot(EquipmentSlotType.FEET);
        if (stack.hasTag()) {
            if (stack.getTag().getInt("Lucky") >= 1) {
                player.addPotionEffect(new EffectInstance(Effects.LUCK, 100, 0, false, false));
            }
        }
    }

    @SubscribeEvent
    public static void getScared(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        ItemStack stack = event.player.getItemStackFromSlot(EquipmentSlotType.FEET);
        if (stack.hasTag()) {
            if (!player.getCooldownTracker().hasCooldown(stack.getItem())) {
                if (stack.getTag().getInt("Scared") >= 1 && player.getHealth() <= 4) {
                    player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 500, 0, false, false));
                    player.getCooldownTracker().setCooldown(stack.getItem(), 20000);
                }
            }
        }
    }

    @SubscribeEvent
    public static void getFrozen(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        ItemStack stack = event.player.getItemStackFromSlot(EquipmentSlotType.CHEST);
        if (stack.hasTag()) {
            if (!player.getCooldownTracker().hasCooldown(stack.getItem())) {
                if (stack.getTag().getInt("Frozen") >= 1 && player.getHealth() <= 4) {
                    player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 200, 250, false, false));
                    player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 200, 13, false, false));
                    player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200, 4, false, false));
                    player.getCooldownTracker().setCooldown(stack.getItem(), 2400);
                }
            }
        }
    }

    @SubscribeEvent
    public static void testBounce(TickEvent.PlayerTickEvent event) {
        World world = event.player.getEntityWorld();
        Entity entity = event.player.getEntity();
        PlayerEntity player = event.player;
        BlockPos pos = new BlockPos(player.getPosX(), player.getPosY() - 0.02, player.getPosZ());
        BlockState state = world.getBlockState(pos);
        ItemStack stack = event.player.getItemStackFromSlot(EquipmentSlotType.FEET);
        if (stack.hasTag()) {
            if (stack.getTag().getInt("Bouncy") >= 1) {
                if (state.getBlock() != Blocks.GRASS && state.getBlock() != Blocks.WATER && state.getBlock() != Blocks.AIR
                        && state.getBlock() != Blocks.TORCH && state.getBlock() != Blocks.CAVE_AIR
                        && state.getBlock() != Blocks.VOID_AIR && state.getBlock() != Blocks.SNOW) {
                    if (!(player.isSneaking())) {
                        if (!(player.isSwimming())) {
                            Vector3d vector3d = entity.getMotion();
                            entity.setMotion(vector3d.x, 1.2, vector3d.z);
                        }
                    }
                }
            }
        }
    }


    @SubscribeEvent
    public static void fallReducer(LivingFallEvent event) {
        LivingEntity entity = event.getEntityLiving();
        ItemStack stack = entity.getItemStackFromSlot(EquipmentSlotType.FEET);
        {
            if (event.getEntity() instanceof PlayerEntity) {
                if (stack.hasTag()) {
                    if (stack.getTag().getInt("Bouncy") >= 1) {
                        if (!entity.isSneaking())
                            event.setDistance(0f);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void undoMagma(LivingHurtEvent event) {
        LivingEntity entity = event.getEntityLiving();
        ItemStack stack = entity.getItemStackFromSlot(EquipmentSlotType.FEET);
        DamageSource source = event.getSource();
        if (stack.hasTag()) {
            if (stack.getTag().getInt("Magma Walker") >= 1) {
                if (source == DamageSource.HOT_FLOOR) {
                    event.isCanceled();
                }
            }
        }
    }

    @SubscribeEvent
    public static void darkSee(TickEvent.PlayerTickEvent event) {
        World world = event.player.getEntityWorld();
        PlayerEntity player = event.player;
        ItemStack stack = event.player.getItemStackFromSlot(EquipmentSlotType.HEAD);
        BlockPos pos = event.player.getPosition();
        BlockState block = world.getBlockState(pos);
        int i = block.getLightValue();
        if (stack.hasTag()) {
            if (stack.getTag().getInt("Sight") <= 1) {
                if (i <= 3) {
                    player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 300, 0, false, false));
                } else player.clearActivePotions();
            }
        }
    }

    @SubscribeEvent
    public static void scaredTp(TickEvent.PlayerTickEvent event) {
        World world = event.player.getEntityWorld();
        PlayerEntity player = event.player;
        ItemStack stack = event.player.getItemStackFromSlot(EquipmentSlotType.FEET);
        if (stack.hasTag()) {
            if (!player.getCooldownTracker().hasCooldown(stack.getItem())) {
                if (stack.getTag().getInt("Avoid") >= 1 && player.getHealth() <= 4) {
                    if (!world.isRemote) {
                        double d0 = player.getPosX() + (player.getRNG().nextDouble() - 0.7D) * 16.0D;
                        double d1 = player.getPosY();
                        double d2 = player.getPosZ() + (player.getRNG().nextDouble() - 0.7D) * 16.0D;
                        player.attemptTeleport(d0, d1, d2, false);
                        player.getCooldownTracker().setCooldown(stack.getItem(), 20000);


                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void magmaWalker(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        World world = player.getEntityWorld();
        BlockState blockstate = Blocks.OBSIDIAN.getDefaultState();
        BlockPos pos = new BlockPos(player.getPosX(), player.getPosY() - 1, player.getPosZ());
        BlockState blockstate1 = world.getBlockState(pos);
        ItemStack stack = event.player.getItemStackFromSlot(EquipmentSlotType.FEET);
        if (stack.hasTag()) {
            if (stack.getTag().getInt("Lava Walker") <= 1) {
                if (blockstate1 == Blocks.LAVA.getDefaultState())
                    world.setBlockState(pos, blockstate);
            }
        }
    }

}



