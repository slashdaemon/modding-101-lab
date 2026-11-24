package dev.blockacademy.lab.hello;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lab 001: the smallest mod there is.
 * Fabric reads fabric.mod.json, finds this class under "entrypoints", and calls onInitialize() once
 * while the game starts.
 */
public class HelloMod implements ModInitializer {
    public static final String MOD_ID = "m101_hello";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello from Modding 101! Lab 001 is loaded.");
    }
}
