package xyz.tcbuildmc.tubenekoplugin.velocity.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.velocitypowered.api.command.BrigadierCommand;
import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.plugin.PluginContainer;
import com.velocitypowered.api.plugin.PluginDescription;
import com.velocitypowered.api.plugin.PluginManager;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.Component;

import java.util.Optional;

public final class MainCommand {
    public static BrigadierCommand register(ProxyServer proxy) {
        return new BrigadierCommand(BrigadierCommand.literalArgumentBuilder("tubenekoplugin")
                .requires(source -> source.hasPermission("tubenekoplugin.command.main"))
                .executes(context -> {
                    CommandSource source = context.getSource();
                    PluginManager manager = proxy.getPluginManager();
                    Optional<PluginContainer> optional = manager.getPlugin("tubenekoplugin");

                    optional.ifPresent(container -> {
                        PluginDescription description = container.getDescription();

                        source.sendMessage(Component.text()
                                .content("")
                                .append(Component.text(description.getName().orElse("")))
                                .appendSpace()
                                .append(Component.text(description.getVersion().orElse("")))
                                .build());
                    });

                    return Command.SINGLE_SUCCESS;
                }).then(BrigadierCommand.literalArgumentBuilder("help")
                        .executes(context -> {
                            CommandSource source = context.getSource();
                            source.sendMessage(Component.text("Please see our wiki: https://github.com/MrCraftTeamMC/TubeNekoPlugin/wiki"));

                            return Command.SINGLE_SUCCESS;
                        }))
                .build());
    }
}
