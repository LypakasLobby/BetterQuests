package com.lypaka.betterquests.Quests;

import java.util.List;

public class QuestInfoDisplay {

    private final String id;
    private final String displayName;
    private final List<String> lore;

    public QuestInfoDisplay (String id, String displayName, List<String> lore) {

        this.id = id;
        this.displayName = displayName;
        this.lore = lore;

    }

    public String getID() {

        return this.id;

    }

    public String getDisplayName() {

        return displayName;

    }

    public List<String> getLore() {

        return this.lore;

    }

}
