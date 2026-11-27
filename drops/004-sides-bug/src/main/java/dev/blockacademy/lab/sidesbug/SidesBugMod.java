package dev.blockacademy.lab.sidesbug;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.resources.language.I18n;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lab 004, a bug hunt. This mod works in singleplayer and crashes a dedicated server on startup.
 * Find out why before you read the next drop.
 *
 * (This drop's build turns off split source sets, so the build lets the bug through. That's on purpose.)
 */
public class SidesBugMod implements ModInitializer {
    public static final String MOD_ID = "m101_sides_bug";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // Log a friendly, translated message.
        LOGGER.info(I18n.get("m101_sides_bug.loaded"));
    }
}
