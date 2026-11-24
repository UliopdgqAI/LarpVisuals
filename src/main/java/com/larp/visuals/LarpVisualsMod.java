package com.larp.visuals;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LarpVisualsMod implements ModInitializer {
	public static final String MOD_ID = "larpvisuals";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("LarpVisuals mod loaded!");
	}
}