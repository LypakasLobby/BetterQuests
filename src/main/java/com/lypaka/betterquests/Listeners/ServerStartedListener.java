package com.lypaka.betterquests.Listeners;

import com.lypaka.betterquests.BetterQuests;
import com.lypaka.betterquests.Quests.QuestRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;

@Mod.EventBusSubscriber(modid = BetterQuests.MOD_ID)
public class ServerStartedListener {

    @SubscribeEvent
    public static void onServerStarted (FMLServerStartedEvent event) throws ObjectMappingException {

        QuestRegistry.loadQuests();

    }

}
