package com.sypztep.apexara;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Apexara implements ModInitializer {
    public static final String MODID = "apexara";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MODID, path);
    }

    @Override
    public void onInitialize() {
    }
}
