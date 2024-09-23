package com.lypaka.betterquests.Quests.Requirements;

public class PartyRequirement {

    private final String form;
    private final int maxLevel;
    private final int minLevel;
    private final boolean sacrificed;
    private final boolean shiny;
    private final int slot;

    public PartyRequirement (String form, int maxLevel, int minLevel, boolean sacrificed, boolean shiny, int slot) {

        this.form = form;
        this.maxLevel = maxLevel;
        this.minLevel = minLevel;
        this.sacrificed = sacrificed;
        this.shiny = shiny;
        this.slot = slot;

    }

    public String getForm() {

        return this.form;

    }

    public int getMaxLevel() {

        return this.maxLevel;

    }

    public int getMinLevel() {

        return this.minLevel;

    }

    public boolean isSacrificed() {

        return this.sacrificed;

    }

    public boolean isShiny() {

        return shiny;

    }

    public int getSlot() {

        return this.slot;

    }

}
