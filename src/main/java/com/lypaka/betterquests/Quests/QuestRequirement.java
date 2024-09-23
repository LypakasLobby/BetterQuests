package com.lypaka.betterquests.Quests;

import com.lypaka.betterquests.Quests.Requirements.*;

import java.util.Map;

public class QuestRequirement {

    private final Map<String, HoldingItemRequirement> holdingItemRequirements;
    private final Map<String, InventoryRequirement> inventoryRequirements;
    private final Map<String, PartyRequirement> partyRequirements;
    private final PermissionRequirement permissionRequirements;
    private final ProgressRequirement progressRequirements;
    private final TimeRequirement timeRequirements;
    private final WeatherRequirement weatherRequirements;

    public QuestRequirement (Map<String, HoldingItemRequirement> holdingItemRequirements, Map<String, InventoryRequirement> inventoryRequirements, Map<String, PartyRequirement> partyRequirements,
                             PermissionRequirement permissionRequirements, ProgressRequirement progressRequirements, TimeRequirement timeRequirements, WeatherRequirement weatherRequirements) {

        this.holdingItemRequirements = holdingItemRequirements;
        this.inventoryRequirements = inventoryRequirements;
        this.partyRequirements = partyRequirements;
        this.permissionRequirements = permissionRequirements;
        this.progressRequirements = progressRequirements;
        this.timeRequirements = timeRequirements;
        this.weatherRequirements = weatherRequirements;

    }

    public Map<String, HoldingItemRequirement> getHoldingItemRequirements() {

        return this.holdingItemRequirements;

    }

    public Map<String, InventoryRequirement> getInventoryRequirements() {

        return this.inventoryRequirements;

    }

    public Map<String, PartyRequirement> getPartyRequirements() {

        return this.partyRequirements;

    }

    public PermissionRequirement getPermissionRequirements() {

        return this.permissionRequirements;

    }

    public ProgressRequirement getProgressRequirements() {

        return this.progressRequirements;

    }

    public TimeRequirement getTimeRequirements() {

        return this.timeRequirements;

    }

    public WeatherRequirement getWeatherRequirements() {

        return this.weatherRequirements;

    }

}
