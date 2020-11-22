package AOChips.ArmorUp.items;

import AOChips.ArmorUp.lists.ItemList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EssenceBottle extends Item {
    public EssenceBottle(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        BlockState blockstate = world.getBlockState(blockpos);
        if(blockstate.getBlock() == Blocks.SOUL_FIRE) {
            player.inventory.removeStackFromSlot(player.inventory.getSlotFor(ItemList.ESSENCE_BOTTLE.getDefaultInstance()));
            player.inventory.addItemStackToInventory(new ItemStack(ItemList.SOUL_FIRE_ESSENCE));
            world.destroyBlock(blockpos, false);
        }
        if(blockstate.getBlock() == Blocks.SHROOMLIGHT) {
            player.inventory.removeStackFromSlot(player.inventory.getSlotFor(ItemList.ESSENCE_BOTTLE.getDefaultInstance()));
            player.inventory.addItemStackToInventory(new ItemStack(ItemList.SHROOMLIGHT_ESSENCE));
            world.destroyBlock(blockpos, false);
        }
        if(blockstate.getBlock() == Blocks.BLUE_ICE) {
            player.inventory.removeStackFromSlot(player.inventory.getSlotFor(ItemList.ESSENCE_BOTTLE.getDefaultInstance()));
            player.inventory.addItemStackToInventory(new ItemStack(ItemList.FROST_ESSENCE));
            world.destroyBlock(blockpos, false);
        }
        return ActionResultType.CONSUME;
    }
}
