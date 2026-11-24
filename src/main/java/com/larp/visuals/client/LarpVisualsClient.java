package com.larp.visuals.client;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.larp.visuals.LarpVisualsMod.MOD_ID;

public class LarpVisualsClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID + "_client");

	@Override
	public void onInitializeClient() {
		LOGGER.info("LarpVisuals client initialized!");
	}
}