package xyz.tcbuildmc.tubenekoplugin.sponge.command;

import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;
import org.spongepowered.api.command.CommandExecutor;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.exception.CommandException;
import org.spongepowered.api.command.parameter.CommandContext;

import java.util.Random;

public class LuckyCommandExecutor implements CommandExecutor {
    @Override
    public CommandResult execute(CommandContext context) throws CommandException {
        context.sendMessage(Identity.nil(), Component.text("Your lucky number: " +
                new Random().nextInt(100)));

        return CommandResult.success();
    }
}
