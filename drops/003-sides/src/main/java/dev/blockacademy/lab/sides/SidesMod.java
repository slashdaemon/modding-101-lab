package dev.blockacademy.lab.sides;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lab 003: the "main" entrypoint runs everywhere: on a player's game and on a dedicated server.
 * Code here must only use classes that exist on both.
 */
public class SidesMod implements ModInitializer {
    public static final String MOD_ID = "m101_sides";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("[main] Lab 003 loaded. This runs in every copy of the game.");

        ServerLifecycleEvents.SERVER_STARTED.register(server -> LOGGER.info(
                "[main] A server just started. Kind: {}",
                server.isDedicatedServer() ? "dedicated server" : "integrated server (singleplayer)"));
    }
}
