package com.lypaka.betterquests.Commands;

import com.lypaka.betterquests.BetterQuests;
import com.lypaka.betterquests.ConfigGetters;
import com.lypaka.betterquests.Quests.QuestRegistry;
import com.lypaka.lypakautils.FancyText;
import com.lypaka.lypakautils.MiscHandlers.PermissionHandler;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;

public class ReloadCommand {

    public ReloadCommand (CommandDispatcher<CommandSource> dispatcher) {

        for (String a : BetterQuestsCommand.ALIASES) {

            dispatcher.register(
                    Commands.literal(a)
                            .then(
                                    Commands.literal("reload")
                                            .executes(c -> {

                                                if (c.getSource().getEntity() instanceof ServerPlayerEntity) {

                                                    ServerPlayerEntity player = (ServerPlayerEntity) c.getSource().getEntity();
                                                    if (!PermissionHandler.hasPermission(player, "betterquests.command.admin")) {

                                                        player.sendMessage(FancyText.getFormattedText("&cYou don't have permission to use this command!"), player.getUUID());
                                                        return 0;

                                                    }

                                                }

                                                try {

                                                    BetterQuests.configManager.load();
                                                    ConfigGetters.load();
                                                    QuestRegistry.loadQuests();
                                                    c.getSource().sendSuccess(FancyText.getFormattedText("&aSuccessfully reloaded BetterQuests!"), true);
                                                    return 0;

                                                } catch (ObjectMappingException e) {

                                                    throw new RuntimeException(e);

                                                }

                                            })
                            )
            );

        }

    }

}
