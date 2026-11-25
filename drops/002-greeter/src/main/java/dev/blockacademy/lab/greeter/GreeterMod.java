package dev.blockacademy.lab.greeter;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lab 002: reacting to something that happens in the game.
 * Fabric API fires JOIN on the server each time a player joins; we register a listener for it.
 */
public class GreeterMod implements ModInitializer {
    public static final String MOD_ID = "m101_greeter";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            ServerPlayer player = handler.getPlayer();
            player.sendSystemMessage(greeting(player.getName().getString()));
            LOGGER.info("Greeted {}", player.getName().getString());
        });
        LOGGER.info("Lab 002 is listening for players joining.");
    }

    static Component greeting(String name) {
        return Component.literal("Welcome to the Lab, ")
                .append(Component.literal(name).withStyle(ChatFormatting.GREEN))
                .append("!");
    }
}
