package com.lypaka.betterquests.Commands;

import com.lypaka.betterquests.BetterQuests;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(modid = BetterQuests.MOD_ID)
public class BetterQuestsCommand {

    public static final List<String> ALIASES = Arrays.asList("betterquests", "bquests", "quests");

    @SubscribeEvent
    public static void onCommandRegistration (RegisterCommandsEvent event) {

        new ReloadCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());

    }

}
