package xyz.tcbuildmc.tubenekoplugin.velocity.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.velocitypowered.api.command.BrigadierCommand;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.Component;

public final class BroadcastCommand {
    public static BrigadierCommand register(ProxyServer proxy) {
        return new BrigadierCommand(BrigadierCommand.literalArgumentBuilder("broadcast")
                .requires(source -> source.hasPermission("tubenekoplugin.command.broadcast"))
                .then(BrigadierCommand.requiredArgumentBuilder("message", StringArgumentType.greedyString())
                        .executes(context -> {
                            String message = context.getArgument("message", String.class);
                            proxy.getAllPlayers().forEach(player ->
                                    player.sendMessage(Component.text(message)));

                            return Command.SINGLE_SUCCESS;
                        }))
                .build());
    }
}
