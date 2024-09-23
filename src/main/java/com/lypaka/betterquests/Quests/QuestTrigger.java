package com.lypaka.betterquests.Quests;

import java.util.List;

public class QuestTrigger {

    private final List<String> triggerIDs;
    private final List<String> triggerLocations;
    private final String triggerType;

    public QuestTrigger (List<String> triggerIDs, List<String> triggerLocations, String triggerType) {

        this.triggerIDs = triggerIDs;
        this.triggerLocations = triggerLocations;
        this.triggerType = triggerType;

    }

    public List<String> getTriggerIDs() {

        return this.triggerIDs;

    }

    public List<String> getTriggerLocations() {

        return this.triggerLocations;

    }

    public String getTriggerType() {

        return this.triggerType;

    }

}
