package com.lypaka.betterquests.Quests;

import java.util.List;
import java.util.Map;

public class Questline {

    private final String name;
    private final Map<String, Integer> requiredQuestProgression;
    private final List<String> havePermissions;
    private final List<String> haveNotPermissions;
    private final List<String> quests;

    public Questline (String name, Map<String, Integer> requiredQuestProgression, List<String> havePermissions, List<String> haveNotPermissions, List<String> quests) {

        this.name = name;
        this.requiredQuestProgression = requiredQuestProgression;
        this.havePermissions = havePermissions;
        this.haveNotPermissions = haveNotPermissions;
        this.quests = quests;

    }

    public String getName() {

        return this.name;

    }

    public Map<String, Integer> getRequiredQuestProgression() {

        return this.requiredQuestProgression;

    }

    public List<String> getHavePermissions() {

        return this.havePermissions;

    }

    public List<String> getHaveNotPermissions() {

        return this.havePermissions;

    }

    public List<String> getQuests() {

        return this.quests;

    }

}
