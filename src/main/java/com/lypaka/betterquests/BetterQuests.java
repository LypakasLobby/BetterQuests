package com.lypaka.betterquests;

import com.lypaka.lypakautils.ConfigurationLoaders.BasicConfigManager;
import com.lypaka.lypakautils.ConfigurationLoaders.ComplexConfigManager;
import com.lypaka.lypakautils.ConfigurationLoaders.ConfigUtils;
import net.minecraftforge.fml.common.Mod;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("betterquests")
public class BetterQuests {

    public static final String MOD_ID = "betterquests";
    public static final String MOD_NAME = "BetterQuests";
    public static Logger logger = LogManager.getLogger(MOD_NAME);
    public static BasicConfigManager configManager;
    public static Map<String, BasicConfigManager> questlineConfigManager;
    public static Map<String, Map<String, BasicConfigManager>> questConfigManager;

    // TODO
    // 1) Create questlines that will hold quests
    // 2) Create quests that will store tasks players need to complete
    // 3) Update progress numbers for quest completion
    // 4) Reward pool for quest and questline completion

    public BetterQuests() throws ObjectMappingException {

        Path dir = ConfigUtils.checkDir(Paths.get("./config/betterquests"));
        String[] files = new String[]{"betterquests.conf"};
        configManager = new BasicConfigManager(files, dir, BetterQuests.class, MOD_NAME, MOD_ID, logger);
        configManager.init();
        ConfigGetters.load();

        //questlineConfigManager = new ComplexConfigManager(ConfigGetters.questlines, "questlines", "questline.conf", dir, BetterQuests.class, MOD_NAME, MOD_ID, logger);
        //questlineConfigManager.init();

    }

}
