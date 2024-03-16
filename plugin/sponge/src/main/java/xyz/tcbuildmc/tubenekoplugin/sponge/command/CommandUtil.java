package xyz.tcbuildmc.tubenekoplugin.sponge.command;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.command.Command;
import org.spongepowered.api.command.CommandExecutor;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

public final class CommandUtil {
    public static Command.Parameterized getCommand(CommandExecutor e, String perm, Component desc) {
        return Command.builder()
                .executor(e)
                .permission(perm)
                .shortDescription(desc)
                .build();
    }

    public static Command.Parameterized getCommandPlayerUse(CommandExecutor e, String perm, Component desc) {
        return Command.builder()
                .executor(e)
                .permission(perm)
                .shortDescription(desc)
                .executionRequirements(c -> c.cause().root() instanceof ServerPlayer)
                .build();
    }

    public static CommandResult getResult(int code, Component msg) {
        return CommandResult.builder()
                .result(code)
                .error(msg)
                .build();
    }
}
