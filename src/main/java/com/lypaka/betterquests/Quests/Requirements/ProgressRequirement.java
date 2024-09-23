package com.lypaka.betterquests.Quests.Requirements;

import java.util.Map;

public class ProgressRequirement {

    private final Map<String, Map<String, Integer>> progressMap;

    public ProgressRequirement (Map<String, Map<String, Integer>> progressMap) {

        this.progressMap = progressMap;

    }

    public Map<String, Map<String, Integer>> getProgressMap() {

        return this.progressMap;

    }

}
