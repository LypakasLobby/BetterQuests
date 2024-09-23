package com.lypaka.betterquests.Quests.Requirements;

import java.util.List;

public class TimeRequirement {

    private final List<String> times;

    public TimeRequirement (List<String> times) {

        this.times = times;

    }

    public List<String> getTimes() {

        return this.times;

    }

}
