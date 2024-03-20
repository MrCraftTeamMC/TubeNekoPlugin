package xyz.tcbuildmc.tubenekoplugin.bukkit.command;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.tcbuildmc.tubenekoplugin.bukkit.TubeNekoPluginBukkit;

import java.util.List;
import java.util.Objects;

public final class HereCommandExecutor implements TabExecutor {
    private final JavaPlugin plugin = TubeNekoPluginBukkit.getProvidingPlugin(TubeNekoPluginBukkit.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (this.plugin.getConfig().getBoolean("command.here.toggle", false)) {
            if (sender instanceof Player player) {
                Server server = player.getServer();
                Location location = player.getLocation();
                String dimension = Objects.requireNonNull(location.getWorld()).getName();

                server.broadcastMessage(this.plugin.getConfig().getString("command.here.message", "")
                        .formatted(ChatColor.AQUA, player.getDisplayName(),
                                ChatColor.GREEN, location.getBlockX(), location.getBlockY(), location.getBlockZ(),
                                ChatColor.GOLD, dimension));

                if (args.length == 1 && args[0].equals("true")) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 30, 2));
                }

                return true;
            }

            sender.sendMessage(this.plugin.getConfig().getString("notPlayer", "")
                    .formatted(ChatColor.RED));
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return List.of("[glowing]");
        }
        return List.of();
    }
}
