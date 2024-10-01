package com.lypaka.betterquests.Listeners;

import com.google.common.reflect.TypeToken;
import com.lypaka.betterquests.BetterQuests;
import com.lypaka.betterquests.PlayerAccounts.Account;
import com.lypaka.betterquests.PlayerAccounts.AccountHandler;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;

import java.util.HashMap;
import java.util.Map;

public class ConnectionListener {

    @SubscribeEvent
    public void onConnect (PlayerEvent.PlayerLoggedInEvent event) throws ObjectMappingException {

        ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
        BetterQuests.playerConfigManager.loadPlayer(player.getUUID());
        Map<String, Map<String, String>> questLineMap = new HashMap<>(0);
        Map<String, Integer> questProgressMap = new HashMap<>(0);
        Map<String, Map<String, String>> configMap = BetterQuests.playerConfigManager.getPlayerConfigNode(player.getUUID(), "Questlines").getValue(new TypeToken<Map<String, Map<String, String>>>() {});
        if (configMap != null && !configMap.isEmpty()) {

            for (Map.Entry<String, Map<String, String>> entry : configMap.entrySet()) {

                String questLineID = entry.getKey();
                Map<String, String> data = new HashMap<>();
                data.put("Quest-ID", BetterQuests.playerConfigManager.getPlayerConfigNode(player.getUUID(), "Questlines", questLineID, "Current-Quest", "Quest-ID").getString());
                data.put("Quest-Progress", String.valueOf(BetterQuests.playerConfigManager.getPlayerConfigNode(player.getUUID(), "Questlines", questLineID, "Current-Quest", "Quest-Progress").getInt()));
                questLineMap.put(questLineID, data);

                questProgressMap.put(questLineID, BetterQuests.playerConfigManager.getPlayerConfigNode(player.getUUID(), "Questlines", questLineID, "Progress-Number").getInt());

            }

        }

        Account account = new Account(player.getUUID(), questLineMap, questProgressMap);
        AccountHandler.accountMap.put(player.getUUID(), account);

    }

}
