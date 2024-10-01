package com.lypaka.betterquests.Quests;

import java.util.List;

public class Quest {

    private final String questName;
    private final int amountRequired;
    private final List<String> completionCommands;
    private final int progressNumberUpdate;
    private final QuestInfoDisplay infoDisplay;
    private final String event;
    private final String targetID;
    private final String targetLocation;
    private final QuestTrigger questTrigger;
    private final QuestRequirement requirements;

    public Quest (String questName, int amountRequired, List<String> completionCommands, int progressNumberUpdate, QuestInfoDisplay infoDisplay, String event, String targetID, String targetLocation, QuestTrigger questTrigger, QuestRequirement requirements) {

        this.questName = questName;
        this.amountRequired = amountRequired;
        this.completionCommands = completionCommands;
        this.progressNumberUpdate = progressNumberUpdate;
        this.infoDisplay = infoDisplay;
        this.event = event;
        this.targetID = targetID;
        this.targetLocation = targetLocation;
        this.questTrigger = questTrigger;
        this.requirements = requirements;

    }

    public String getQuestName() {

        return this.questName;

    }

    public int getAmountRequired() {

        return this.amountRequired;

    }

    public List<String> getCompletionCommands() {

        return this.completionCommands;

    }

    public int getProgressNumberUpdate() {

        return this.progressNumberUpdate;

    }

    public QuestInfoDisplay getInfoDisplay() {

        return this.infoDisplay;

    }

    public String getEvent() {

        return this.event;

    }

    public String getTargetID() {

        return this.targetID;

    }

    public String getTargetLocation() {

        return this.targetLocation;

    }

    public QuestTrigger getQuestTrigger() {

        return this.questTrigger;

    }

    public QuestRequirement getRequirements() {

        return this.requirements;

    }

}
