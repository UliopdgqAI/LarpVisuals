package com.larp.visuals.client;

import com.larp.visuals.gui.ClickGuiManager;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    public static final KeyBinding OPEN_GUI = KeyBindingHelper.registerKeyBinding(new KeyBinding(
        "key.larpvisuals.gui",
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_RIGHT_SHIFT,
        "category.larpvisuals"
    ));
    
    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (OPEN_GUI.wasPressed()) {
                ClickGuiManager.getInstance().toggleGui();
            }
        });
    }
}