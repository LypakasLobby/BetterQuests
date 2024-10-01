package com.lypaka.betterquests.Quests;

import com.google.common.reflect.TypeToken;
import com.lypaka.betterquests.BetterQuests;
import com.lypaka.betterquests.ConfigGetters;
import com.lypaka.betterquests.Quests.Requirements.*;
import com.lypaka.lypakautils.ConfigurationLoaders.BasicConfigManager;
import com.lypaka.lypakautils.ConfigurationLoaders.ConfigUtils;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestRegistry {

    public static Map<Questline, List<Quest>> questlineListMap;
    public static Map<String, Questline> questlineMap;

    public static void loadQuests() throws ObjectMappingException {

        questlineListMap = new HashMap<>();
        questlineMap = new HashMap<>();
        BetterQuests.questlineConfigManager = new HashMap<>();
        BetterQuests.questConfigManager = new HashMap<>();
        String[] files = new String[]{"data.conf", "requirements.conf"};
        String[] questlineFiles = new String[]{"questline.conf"};
        for (int i = 0; i < ConfigGetters.questlines.size(); i++) {

            String name = ConfigGetters.questlines.get(i);
            Path questlineDir = ConfigUtils.checkDir(Paths.get("./config/betterquests/questlines/" + name));
            BasicConfigManager questlineBCM = new BasicConfigManager(questlineFiles, questlineDir, BetterQuests.class, BetterQuests.MOD_NAME, BetterQuests.MOD_ID, BetterQuests.logger);
            questlineBCM.init();
            BetterQuests.questlineConfigManager.put(name, questlineBCM);
            Map<String, Integer> requiredQuestlines = questlineBCM.getConfigNode(0, "Requirement", "Questlines").getValue(new TypeToken<Map<String, Integer>>() {});
            List<String> havePermissions = questlineBCM.getConfigNode(0, "Requirement", "Permissions-Have").getList(TypeToken.of(String.class));
            List<String> haveNotPermissions = questlineBCM.getConfigNode(0, "Requirement", "Permissions-Not-Have").getList(TypeToken.of(String.class));
            List<String> quests = questlineBCM.getConfigNode(0, "Quests").getList(TypeToken.of(String.class));

            Questline questline = new Questline(name, requiredQuestlines, havePermissions, haveNotPermissions, quests);

            List<Quest> questList = new ArrayList<>();
            Map<String, BasicConfigManager> configMap = new HashMap<>();
            for (int j = 0; j < quests.size(); j++) {

                String questName = quests.get(j);
                Path dir = ConfigUtils.checkDir(Paths.get("./config/betterquests/questlines/" + name + "/" + questName));
                BasicConfigManager bcm = new BasicConfigManager(files, dir, BetterQuests.class, BetterQuests.MOD_NAME, BetterQuests.MOD_ID, BetterQuests.logger);
                bcm.init();
                configMap.put(questName, bcm);

                int amountRequired = bcm.getConfigNode(0, "Amount").getInt();
                List<String> completionCommands = bcm.getConfigNode(0, "Completion", "Commands").getList(TypeToken.of(String.class));
                int progressUpdate = bcm.getConfigNode(0, "Completion", "Progress-Update").getInt();

                String displayID = bcm.getConfigNode(0, "Display", "Display-Item").getString();
                String displayName = bcm.getConfigNode(0, "Display", "Display-Name").getString();
                List<String> displayLore = bcm.getConfigNode(0, "Display", "Lore").getList(TypeToken.of(String.class));

                QuestInfoDisplay display = new QuestInfoDisplay(displayID, displayName, displayLore);

                String event = bcm.getConfigNode(0, "Event").getString();
                String targetID = bcm.getConfigNode(0, "Target", "ID").getString();
                String targetLocation = bcm.getConfigNode(0, "Target", "Location").getString();

                List<String> triggerIDs = bcm.getConfigNode(0, "Trigger", "IDs").getList(TypeToken.of(String.class));
                List<String> triggerLocations = bcm.getConfigNode(0, "Trigger", "Locations").getList(TypeToken.of(String.class));
                String triggerType = bcm.getConfigNode(0, "Trigger", "Type").getString();
                QuestTrigger trigger = new QuestTrigger(triggerIDs, triggerLocations, triggerType);

                Map<String, HoldingItemRequirement> holdingItemRequirementMap = new HashMap<>();
                Map<String, Map<String, String>> holding = bcm.getConfigNode(1, "Requirements", "Holding").getValue(new TypeToken<Map<String, Map<String, String>>>() {});
                for (Map.Entry<String, Map<String, String>> entry : holding.entrySet()) {

                    String holdingID = entry.getKey();
                    int holdingAmount = bcm.getConfigNode(1, "Requirements", "Holding", holdingID, "Amount").getInt();
                    boolean holdingConsumed = bcm.getConfigNode(1, "Requirements", "Holding", holdingID, "Consume").getBoolean();
                    String holdingDisplay = bcm.getConfigNode(1, "Requirements", "Holding", holdingID, "Display-Name").getString();
                    int holdingMetadata = bcm.getConfigNode(1, "Requirements", "Holding", holdingID, "Metadata").getInt();
                    List<String> holdingTags = bcm.getConfigNode(1, "Requirements", "Holding", holdingID, "NBT").getList(TypeToken.of(String.class));

                    HoldingItemRequirement holdingItemRequirement = new HoldingItemRequirement(holdingAmount, holdingConsumed, holdingDisplay, holdingMetadata, holdingTags);
                    holdingItemRequirementMap.put(holdingID, holdingItemRequirement);

                }

                Map<String, InventoryRequirement> inventoryRequirementMap = new HashMap<>();
                Map<String, Map<String, String>> inventory = bcm.getConfigNode(1, "Requirements", "Inventory").getValue(new TypeToken<Map<String, Map<String, String>>>() {});
                for (Map.Entry<String, Map<String, String>> entry : inventory.entrySet()) {

                    String inventoryID = entry.getKey();
                    int inventoryAmount = bcm.getConfigNode(1, "Requirements", "Inventory", inventoryID, "Amount").getInt();
                    boolean inventoryConsumed = bcm.getConfigNode(1, "Requirements", "Inventory", inventoryID, "Consume").getBoolean();
                    String inventoryDisplay = bcm.getConfigNode(1, "Requirements", "Inventory", inventoryID, "Display-Name").getString();
                    int inventoryMetadata = bcm.getConfigNode(1, "Requirements", "Inventory", inventoryID, "Metadata").getInt();
                    List<String> inventoryTags = bcm.getConfigNode(1, "Requirements", "Inventory", inventoryID, "NBT").getList(TypeToken.of(String.class));

                    InventoryRequirement inventoryRequirement = new InventoryRequirement(inventoryAmount, inventoryConsumed, inventoryDisplay, inventoryMetadata, inventoryTags);
                    inventoryRequirementMap.put(inventoryID, inventoryRequirement);

                }

                Map<String, PartyRequirement> partyRequirementMap = new HashMap<>();
                Map<String, Map<String, String>> party = bcm.getConfigNode(1, "Requirements", "Party").getValue(new TypeToken<Map<String, Map<String, String>>>() {});
                for (Map.Entry<String, Map<String, String>> entry : party.entrySet()) {

                    String speciesID = entry.getKey();
                    String form = bcm.getConfigNode(1, "Requirements", "Party", speciesID, "Form").getString();
                    int maxLevel = bcm.getConfigNode(1, "Requirements", "Party", speciesID, "Max-Level").getInt();
                    int minLevel = bcm.getConfigNode(1, "Requirements", "Party", speciesID, "Min-Level").getInt();
                    boolean sacrificed = bcm.getConfigNode(1, "Requirements", "Party", speciesID, "Sacrifice").getBoolean();
                    boolean shiny = bcm.getConfigNode(1, "Requirements", "Party", speciesID, "Shiny").getBoolean();
                    int slot = bcm.getConfigNode(1, "Requirements", "Party", speciesID, "Slot").getInt();

                    PartyRequirement partyRequirement = new PartyRequirement(form, maxLevel, minLevel, sacrificed, shiny, slot);
                    partyRequirementMap.put(speciesID, partyRequirement);

                }

                PermissionRequirement permissionRequirement = null;
                Map<String, Boolean> permissions = bcm.getConfigNode(1, "Requirements", "Permission").getValue(new TypeToken<Map<String, Boolean>>() {});
                if (permissions != null && !permissions.isEmpty()) {

                    permissionRequirement = new PermissionRequirement(permissions);

                }

                ProgressRequirement progressRequirement = null;
                Map<String, Map<String, Integer>> progressMap = bcm.getConfigNode(1, "Requirements", "Progress").getValue(new TypeToken<Map<String, Map<String, Integer>>>() {});
                if (progressMap != null && !progressMap.isEmpty()) {

                    progressRequirement = new ProgressRequirement(progressMap);

                }
                List<String> times = bcm.getConfigNode(1, "Requirements", "Time").getList(TypeToken.of(String.class));
                TimeRequirement timeRequirement = new TimeRequirement(times);

                List<String> weathers = bcm.getConfigNode(1, "Requirements", "Weather").getList(TypeToken.of(String.class));
                WeatherRequirement weatherRequirement = new WeatherRequirement(weathers);

                QuestRequirement questRequirement = new QuestRequirement(holdingItemRequirementMap, inventoryRequirementMap, partyRequirementMap, permissionRequirement, progressRequirement, timeRequirement, weatherRequirement);

                Quest quest = new Quest(questName, amountRequired, completionCommands, progressUpdate, display, event, targetID, targetLocation, trigger, questRequirement);
                questList.add(quest);

            }

            questlineListMap.put(questline, questList);
            questlineMap.put(questline.getName(), questline);
            BetterQuests.questConfigManager.put(questline.getName(), configMap);

        }

    }

}
