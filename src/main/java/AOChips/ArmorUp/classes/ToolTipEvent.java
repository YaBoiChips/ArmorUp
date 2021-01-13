package AOChips.ArmorUp.classes;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ToolTipEvent {
    @SubscribeEvent
    public void glowToolTip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.hasTag()) {
            ITextComponent toolTip = (stack.getTag().toFormattedComponent());
            if (stack.getTag().getInt("Glowing") >= 1) {
                if (!event.getToolTip().contains(toolTip)) {
                    event.getToolTip().add(toolTip);

                }
            }
        }
    }

    @SubscribeEvent
    public void luckToolTip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.hasTag()) {
            ITextComponent toolTip = (stack.getTag().toFormattedComponent());
            if (stack.getTag().getInt("Lucky") >= 1) {
                if (!event.getToolTip().contains(toolTip)) {
                    event.getToolTip().add(toolTip);

                }
            }
        }
    }

    @SubscribeEvent
    public void scaredToolTip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.hasTag()) {
            ITextComponent toolTip = (stack.getTag().toFormattedComponent());
            if (stack.getTag().getInt("Scared") >= 1) {
                if (!event.getToolTip().contains(toolTip)) {
                    event.getToolTip().add(toolTip);

                }
            }
        }
    }

    @SubscribeEvent
    public void frozenToolTip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.hasTag()) {
            ITextComponent toolTip = (stack.getTag().toFormattedComponent());
            if (stack.getTag().getInt("Frozen") >= 1) {
                if (!event.getToolTip().contains(toolTip)) {
                    event.getToolTip().add(toolTip);

                }
            }
        }
    }

    @SubscribeEvent
    public void bouncyToolTip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.hasTag()) {
            ITextComponent toolTip = (stack.getTag().toFormattedComponent());
            if (stack.getTag().getInt("Bouncy") >= 1) {
                if (!event.getToolTip().contains(toolTip)) {
                    event.getToolTip().add(toolTip);

                }
            }
        }
    }

    @SubscribeEvent
    public void unhotToolTip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.hasTag()) {
            ITextComponent toolTip = (stack.getTag().toFormattedComponent());
            if (stack.getTag().getInt("Magma Walker") >= 1) {
                if (!event.getToolTip().contains(toolTip)) {
                    event.getToolTip().add(toolTip);

                }
            }
        }
    }

    @SubscribeEvent
    public void darkseeToolTip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.hasTag()) {
            ITextComponent toolTip = (stack.getTag().toFormattedComponent());
            if (stack.getTag().getInt("Sight") >= 1) {
                if (!event.getToolTip().contains(toolTip)) {
                    event.getToolTip().add(toolTip);

                }
            }
        }
    }

    @SubscribeEvent
    public void scaredtpToolTip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.hasTag()) {
            ITextComponent toolTip = (stack.getTag().toFormattedComponent());
            if (stack.getTag().getInt("Avoid") >= 1) {
                if (!event.getToolTip().contains(toolTip)) {
                    event.getToolTip().add(toolTip);

                }
            }
        }
    }

    @SubscribeEvent
    public void pocketToolTip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.hasTag()) {
            ITextComponent toolTip = (stack.getTag().toFormattedComponent());
            if (stack.getTag().getInt("Pockets") >= 1) {
                if (!event.getToolTip().contains(toolTip)) {
                    event.getToolTip().add(toolTip);
                }
            }
        }
    }

    @SubscribeEvent
    public void lavaToolTip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.hasTag()) {
            ITextComponent toolTip = (stack.getTag().toFormattedComponent());
            if (stack.getTag().getInt("Lava Walker") >= 1) {
                if (!event.getToolTip().contains(toolTip)) {
                    event.getToolTip().add(toolTip);
                }
            }
        }
    }
}