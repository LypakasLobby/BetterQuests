package com.lypaka.betterquests;

import com.google.common.reflect.TypeToken;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;

import java.util.List;

public class ConfigGetters {

    public static List<String> questlines;

    public static void load() throws ObjectMappingException {

        questlines = BetterQuests.configManager.getConfigNode(0, "Quest-Lines").getList(TypeToken.of(String.class));

    }

}
