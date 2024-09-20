package com.lypaka.betterquests;

import com.lypaka.lypakautils.ConfigurationLoaders.BasicConfigManager;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("betterquests")
public class BetterQuests {

    public static final String MOD_ID = "betterquests";
    public static final String MOD_NAME = "BetterQuests";
    public static Logger logger = LogManager.getLogger(MOD_NAME);
    public static BasicConfigManager configManager;

    public BetterQuests() {



    }

}
