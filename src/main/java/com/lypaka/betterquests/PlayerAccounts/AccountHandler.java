package com.lypaka.betterquests.PlayerAccounts;

import com.lypaka.betterquests.Quests.Quest;
import com.lypaka.betterquests.Quests.QuestRegistry;
import com.lypaka.betterquests.Quests.Questline;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.*;

public class AccountHandler {

    public static Map<UUID, Account> accountMap = new HashMap<>();

    public static List<Questline> getActiveQuestlines (ServerPlayerEntity player) {

        List<Questline> questlines = new ArrayList<>();
        Account account = accountMap.get(player.getUUID());
        Map<String, Map<String, String>> questlineMap = account.getQuestLineMap();
        for (Map.Entry<String, Map<String, String>> entry : questlineMap.entrySet()) {

            String questlineID = entry.getKey();
            Questline questLine = QuestRegistry.questlineMap.getOrDefault(questlineID, null);
            if (questLine != null) {

                if (!questlines.contains(questLine)) {

                    questlines.add(questLine);

                }

            }

        }

        return questlines;

    }

    public static Quest getCurrentQuestFromQuestline (ServerPlayerEntity player, Questline questline) {

        return getCurrentQuestFromQuestlineID(player, questline.getName());

    }

    public static Quest getCurrentQuestFromQuestlineID (ServerPlayerEntity player, String questlineID) {

        Quest quest = null;
        Account account = accountMap.get(player.getUUID());
        Map<String, Map<String, String>> questlines = account.getQuestLineMap();
        if (questlines.containsKey(questlineID)) {

            Map<String, String> data = questlines.get(questlineID);
            String currentQuest = data.get("Quest-ID");
            Questline questLine = QuestRegistry.questlineMap.get(questlineID);
            if (questLine != null) {

                List<Quest> quests = QuestRegistry.questlineListMap.get(questLine);
                for (Quest q : quests) {

                    if (q.getQuestName().equalsIgnoreCase(currentQuest)) {

                        quest = q;
                        break;

                    }

                }

            }

        }

        return quest;

    }

}
