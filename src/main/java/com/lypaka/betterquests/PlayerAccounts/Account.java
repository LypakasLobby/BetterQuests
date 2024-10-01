package com.lypaka.betterquests.PlayerAccounts;

import java.util.Map;
import java.util.UUID;

public class Account {

    private final UUID uuid;
    private final Map<String, Map<String, String>> questLineMap;
    private final Map<String, Integer> questProgressNumbers;

    public Account (UUID uuid, Map<String, Map<String, String>> questLineMap, Map<String, Integer> questProgressNumbers) {

        this.uuid = uuid;
        this.questLineMap = questLineMap;
        this.questProgressNumbers = questProgressNumbers;

    }

    public UUID getUUID() {

        return this.uuid;

    }

    public Map<String, Map<String, String>> getQuestLineMap() {

        return this.questLineMap;

    }

    public Map<String, Integer> getQuestProgressNumbers() {

        return this.questProgressNumbers;

    }

}
