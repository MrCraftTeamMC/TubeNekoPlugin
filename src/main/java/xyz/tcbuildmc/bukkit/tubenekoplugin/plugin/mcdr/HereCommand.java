package xyz.tcbuildmc.bukkit.tubenekoplugin.plugin.mcdr;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import xyz.tcbuildmc.bukkit.tubenekoplugin.common.util.Text;

import java.util.Objects;

public final class HereCommand implements CommandExecutor {
    private final boolean enable;
    private final int time;
    private final String message;
    private final String notPlayerError;

    public HereCommand(JavaPlugin plugin) {
        this.enable = plugin.getConfig().getBoolean("command.here.enable", true);
        this.time = plugin.getConfig().getInt("command.here.time", 10);
        this.message = plugin.getConfig().getString("command.here.message", "");
        this.notPlayerError = plugin.getConfig().getString("error.not_player", "");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (this.enable) {
            if (commandSender instanceof Player player) {
                Location location = player.getLocation();
                Server server = player.getServer();

                server.broadcastMessage(Text.simple().getText(this.message,
                        new Object[]{
                                player.getDisplayName(),
                                location.getBlockX(), location.getBlockY(), location.getBlockZ(),
                                Objects.requireNonNull(location.getWorld()).getName()}));

                player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, this.time, 1,
                        false, true));

                return true;
            }

            commandSender.sendMessage(this.notPlayerError);
        }
        return true;
    }
}
