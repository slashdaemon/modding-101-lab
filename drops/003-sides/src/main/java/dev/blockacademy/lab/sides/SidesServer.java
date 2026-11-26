package dev.blockacademy.lab.sides;

import net.fabricmc.api.DedicatedServerModInitializer;

/**
 * Lab 003: the "server" entrypoint runs only on a dedicated server, never in singleplayer.
 */
public class SidesServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        SidesMod.LOGGER.info("[server] Lab 003 on a dedicated server. No screen, no keyboard, just the world.");
    }
}
