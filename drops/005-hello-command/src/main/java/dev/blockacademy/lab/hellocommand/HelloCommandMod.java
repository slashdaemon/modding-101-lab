package dev.blockacademy.lab.hellocommand;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lab 005: commands. Minecraft's commands are a tree (the library is called Brigadier):
 * /m101 → hello → [name], and /m101 → announce → message. Each branch can run code.
 */
public class HelloCommandMod implements ModInitializer {
    public static final String MOD_ID = "m101_hello_command";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
                dispatcher.register(Commands.literal("m101")
                        // /m101 hello        → greets whoever ran it
                        // /m101 hello <name> → greets that name
                        .then(Commands.literal("hello")
                                .executes(ctx -> hello(ctx.getSource(), ctx.getSource().getTextName()))
                                .then(Commands.argument("name", StringArgumentType.word())
                                        .executes(ctx -> hello(ctx.getSource(),
                                                StringArgumentType.getString(ctx, "name")))))
                        // /m101 announce <message> → tells everyone; operators only (permission level 2)
                        .then(Commands.literal("announce")
                                .requires(source -> source.hasPermission(2))
                                .then(Commands.argument("message", StringArgumentType.greedyString())
                                        .executes(ctx -> announce(ctx.getSource(),
                                                StringArgumentType.getString(ctx, "message")))))));
        LOGGER.info("Lab 005 registered /m101 hello and /m101 announce.");
    }

    static int hello(CommandSourceStack source, String name) {
        source.sendSuccess(() -> Component.literal("Hello, " + name + "!"), false);
        return 1; // a command returns a number: 1 means "it worked once"
    }

    static int announce(CommandSourceStack source, String message) {
        source.getServer().getPlayerList().broadcastSystemMessage(
                Component.literal("[Lab] " + message), false);
        source.sendSuccess(() -> Component.literal("Announced."), true);
        return 1;
    }
}
