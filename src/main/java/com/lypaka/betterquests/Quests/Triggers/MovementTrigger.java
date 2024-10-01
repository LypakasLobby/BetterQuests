package com.lypaka.betterquests.Quests.Triggers;

import com.lypaka.lypakautils.API.PlayerMovementEvent;
import com.lypaka.lypakautils.WorldStuff.WorldMap;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MovementTrigger {

    @SubscribeEvent
    public void onWalk (PlayerMovementEvent.Land event) {

        ServerPlayerEntity player = event.getPlayer();
        int x = player.blockPosition().getX();
        int y = player.blockPosition().getY();
        int z = player.blockPosition().getZ();
        BlockPos pos = new BlockPos(x, y, z);
        String world = WorldMap.getWorldName(player);
        String location = world + "," + x + "," + y + "," + z;
        String blockID = event.getBlockID();

        // check if player has any active quests first, in the event they need to trigger the next phase of their questline

    }

}
