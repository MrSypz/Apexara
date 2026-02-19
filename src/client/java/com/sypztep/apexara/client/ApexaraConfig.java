package com.sypztep.apexara.client;

import com.sypztep.apexara.Apexara;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screens.Screen;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ApexaraConfig {
    public ApexaraConfig() {}

    public static final ConfigClassHandler<ApexaraConfig> HANDLER = ConfigClassHandler.createBuilder(ApexaraConfig.class)
            .id(Apexara.id("config"))
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(FabricLoader.getInstance().getConfigDir().resolve(Apexara.MODID + ".json5"))
                    .setJson5(true)
                    .build())
            .build();

    // =====================================
    // UI & VISUAL SETTINGS
    // =====================================
    @SerialEntry
    public float lvbarscale = 0.5f;

    @SerialEntry
    public float autohideDuration = 15f;

    @SerialEntry
    public boolean damageCritIndicator = true;

    @SerialEntry
    public boolean missingIndicator = true;

    @SerialEntry
    public boolean damageIndicator = true;

    @SerialEntry
    public Color critDamageColor = new Color(0xFF4F00);

    @SerialEntry
    public boolean fixHeartScreen = true;

    @SerialEntry
    public boolean showResourceBar = true;

    @SerialEntry
    public int postProcessRange = 16;

    // =====================================
    // NOTIFICATIONS
    // =====================================
    @SerialEntry
    public boolean enableToastNotifications = true;

    @SerialEntry
    public boolean toastPositionLeft = false;

    @SerialEntry
    public int toastYOffset = 20;

    @SerialEntry
    public int toastMargin = 0;

    @SerialEntry
    public float toastScale = 0.5f;

    // =====================================
    // GAMEPLAY GENERAL
    // =====================================
    @SerialEntry
    public int maxPartySize = 4;

    @SerialEntry
    public int maxStatValue = 99;

    @SerialEntry
    public boolean unlearnskill = true;

    @SerialEntry
    public boolean allowVanillaFoodHealing = false;

    @SerialEntry
    public boolean rebalanceEnviromentDamage = true;

    @SerialEntry
    public boolean allowCollide = true;

    // =====================================
    // LEVELING SYSTEM
    // =====================================
    @SerialEntry
    public int maxLevel = 99;

    @SerialEntry
    public int startStatpoints = 48;

    @SerialEntry
    public java.util.List<Long> EXP_MAP = new ArrayList<>(java.util.List.of(
            548L, 894L, 1486L, 2173L, 3152L, 3732L, 4112L, 4441L, 4866L, 5337L,
            5804L, 5883L, 6106L, 6424L, 7026L, 7624L, 7981L, 8336L, 8689L, 9134L,
            9670L, 10296L, 11012L, 12095L, 12986L, 13872L, 14753L, 15628L, 16498L, 17362L,
            18221L, 19074L, 19923L, 20947L, 21604L, 23334L, 24606L, 25871L, 26682L, 27932L,
            29175L, 29969L, 31636L, 32856L, 33194L, 34836L, 36468L, 38523L, 40565L, 42165L,
            43754L, 45334L, 46903L, 48463L, 50013L, 51976L, 53084L, 54605L, 56116L, 57618L,
            58277L, 60593L, 63721L, 66005L, 69097L, 72171L, 74407L, 77445L, 89404L, 103722L,
            113105L, 124848L, 130898L, 136110L, 143684L, 149620L, 154725L, 158216L, 175461L, 194586L,
            215795L, 239316L, 265401L, 294329L, 326410L, 361988L, 401444L, 445201L, 493727L, 547543L,
            607225L, 673412L, 746813L, 828215L, 918490L, 1018605L, 1129632L, 1252761L
    ));

    @SerialEntry
    public java.util.List<Long> NOVICE_JOB_EXP_MAP = new ArrayList<>(java.util.List.of(
            10L, 18L, 28L, 40L, 91L, 151L, 205L, 268L, 340L
    ));

    @SerialEntry
    public java.util.List<Long> FIRST_CLASS_JOB_EXP_MAP = new ArrayList<>(List.of(
            60L, 130L, 260L, 460L, 780L, 1060L, 1300L, 1560L, 1910L, 2290L,
            2680L, 2990L, 3340L, 3740L, 4360L, 4970L, 5330L, 6120L, 6700L, 8090L,
            8920L, 9970L, 11080L, 12690L, 14440L, 15850L, 17400L, 19220L, 21060L, 22870L,
            24910L, 26840L, 29080L, 31320L, 33300L, 37110L, 40500L, 43570L, 46180L, 53510L,
            57200L, 60310L, 65690L, 70090L, 72130L, 77540L, 83320L, 90120L, 97180L
    ));

    // =====================================
    // DEATH PENALTY
    // =====================================
    @SerialEntry
    public boolean enableDeathPenalty = true;

    @SerialEntry
    public float deathPenaltyPercentage = 0.1f;

    // =====================================
    // DEBUG
    // =====================================
    @SerialEntry
    public boolean skillVisualDebug = false;
    @SerialEntry
    public boolean ccVisualDebug = false;
    @SerialEntry
    public boolean skillPhaseDebugHud = false;

    public static ApexaraConfig getInstance() {
        return HANDLER.instance();
    }

    public static Screen createScreen(Screen parent) {
        return YetAnotherConfigLib.createBuilder()
                .title(net.minecraft.network.chat.Component.translatable("config.apexara.title"))
                .save(HANDLER::save)
                .build()
                .generateScreen(parent);
    }
}