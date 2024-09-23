package com.lypaka.betterquests.Quests.Requirements;

import java.util.Map;

public class PermissionRequirement {

    private final Map<String, Boolean> permissions;

    public PermissionRequirement (Map<String, Boolean> permissions) {

        this.permissions = permissions;

    }

    public Map<String, Boolean> getPermissions() {

        return this.permissions;

    }

}
