package com.lypaka.betterquests.Quests.Requirements;

import java.util.List;

public class WeatherRequirement {

    private final List<String> times;

    public WeatherRequirement (List<String> times) {

        this.times = times;

    }

    public List<String> getTimes() {

        return this.times;

    }

}
