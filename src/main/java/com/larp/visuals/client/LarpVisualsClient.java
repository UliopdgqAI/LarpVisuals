package com.larp.visuals.client;

import com.larp.visuals.gui.ClickGuiManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.larp.visuals.LarpVisualsMod.MOD_ID;

@Environment(EnvType.CLIENT)
public class LarpVisualsClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID + "_client");

    @Override
    public void onInitializeClient() {
        LOGGER.info("LarpVisuals client initialized!");
        
        KeyBindings.register();
        
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            ClickGuiManager.getInstance().render(drawContext, 0, 0, tickDelta);
        });
    }
}