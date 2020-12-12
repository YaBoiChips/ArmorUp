package AOChips.ArmorUp.client.keybind;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;


public class KeyBindingList {
    public static KeyBinding POCKET_KEY = new KeyBinding("OPEN POCKET", GLFW.GLFW_KEY_H, "ArmorUp");

    public static void register() {
            ClientRegistry.registerKeyBinding(POCKET_KEY);
        }


}