package xyz.tcbuildmc.bukkit.tubenekoplugin.plugin.mcdr;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class CatCommand implements CommandExecutor {
    private final boolean enable;
    private final String message;

    public CatCommand(JavaPlugin plugin) {
        this.enable = plugin.getConfig().getBoolean("command.cat.enable", true);
        this.message = plugin.getConfig().getString("command.cat.message", "");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (this.enable) {
            commandSender.sendMessage(this.message);
        }

        return true;
    }
}
