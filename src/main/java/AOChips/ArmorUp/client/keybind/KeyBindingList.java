package AOChips.ArmorUp.client.keybind;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;


public class KeyBindingList {
    public static KeyBinding POCKET_KEY = new KeyBinding("OPEN POCKET", GLFW.GLFW_KEY_H, "ArmorUp");
    public static KeyBinding ROCKET_KEY = new KeyBinding("ROCKET", GLFW.GLFW_KEY_SPACE, "ArmorUp");

    public static void register() {
            ClientRegistry.registerKeyBinding(POCKET_KEY);
            ClientRegistry.registerKeyBinding(ROCKET_KEY);
        }
    }



