package com.sypztep.apexara.client;

import net.fabricmc.api.ClientModInitializer;

public class ApexaraClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ApexaraConfig.HANDLER.load();
    }
}
