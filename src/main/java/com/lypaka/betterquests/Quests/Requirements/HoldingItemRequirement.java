package com.lypaka.betterquests.Quests.Requirements;

import java.util.List;

public class HoldingItemRequirement {

    private final int amount;
    private final boolean consumes;
    private final String displayName;
    private final int metadata;
    private final List<String> tags;

    public HoldingItemRequirement(int amount, boolean consumes, String displayName, int metadata, List<String> tags) {

        this.amount = amount;
        this.consumes = consumes;
        this.displayName = displayName;
        this.metadata = metadata;
        this.tags = tags;

    }

    public int getAmount() {

        return this.amount;

    }

    public boolean isConsumed() {

        return this.consumes;

    }

    public String getDisplayName() {

        return this.displayName;

    }

    public int getMetadata() {

        return this.metadata;

    }

    public List<String> getTags() {

        return this.tags;

    }

}
