package dev.blockacademy.lab.sides.client;

import dev.blockacademy.lab.sides.SidesMod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;

/**
 * Lab 003: the "client" entrypoint runs only in a player's game. It lives in src/client, the only
 * place that can use client classes such as Minecraft (the window, the screen, the keyboard).
 */
public class SidesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        SidesMod.LOGGER.info("[client] Lab 003 client code loaded. A dedicated server never runs this.");

        // Entrypoints run very early, before the game window exists. Anything that needs the window
        // waits for the client to finish starting.
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> SidesMod.LOGGER.info(
                "[client] The game window is open: {}x{} pixels.",
                client.getWindow().getScreenWidth(), client.getWindow().getScreenHeight()));
    }
}
