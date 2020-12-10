package AOChips.ArmorUp.client;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class ToolTipEvent {
    @SubscribeEvent
    public void glowToolTip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.hasTag()) {
            ITextComponent toolTip = (stack.getTag().toFormattedComponent());
            if (stack.getTag().getInt("glow") >= 1) {
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
            if (stack.getTag().getInt("luck") >= 1) {
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
            if (stack.getTag().getInt("scared") >= 1) {
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
            if (stack.getTag().getInt("frozen") >= 1) {
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
            if (stack.getTag().getInt("bouncy") >= 1) {
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
            if (stack.getTag().getInt("unhot") >= 1) {
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
            if (stack.getTag().getInt("darksee") >= 1) {
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
            if (stack.getTag().getInt("scaredtp") >= 1) {
                if (!event.getToolTip().contains(toolTip)) {
                    event.getToolTip().add(toolTip);

                }
            }
        }
    }
}