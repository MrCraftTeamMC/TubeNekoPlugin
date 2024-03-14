package xyz.tcbuildmc.plugin.tubenekoplugin.common.backup.plugin.mcdr;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import xyz.tcbuildmc.plugin.tubenekoplugin.common.util.Text;

import java.util.Objects;

public final class CompassCommand implements CommandExecutor {
    private final boolean enable;
    private final String message;
    private final String notPlayerError;

    public CompassCommand(JavaPlugin plugin) {
        this.enable = plugin.getConfig().getBoolean("command.compass.enable", true);
        this.message = plugin.getConfig().getString("command.compass.message", "");
        this.notPlayerError = plugin.getConfig().getString("error.not_player", "");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (this.enable) {
            if (commandSender instanceof Player) {
                Location location = ((Player) commandSender).getRespawnLocation();
                commandSender.sendMessage(Text.simple().getText(this.message,
                        Objects.requireNonNull(location).getBlockX(), location.getBlockY(), location.getBlockZ(),
                        Objects.requireNonNull(location.getWorld()).getName()));

                return true;
            }

            commandSender.sendMessage(this.notPlayerError);
        }

        return true;
    }
}
