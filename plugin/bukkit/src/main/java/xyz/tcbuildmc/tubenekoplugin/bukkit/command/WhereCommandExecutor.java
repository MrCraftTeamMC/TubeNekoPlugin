package xyz.tcbuildmc.tubenekoplugin.bukkit.command;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.tcbuildmc.tubenekoplugin.bukkit.TubeNekoPluginBukkit;

import java.util.List;

public final class WhereCommandExecutor implements TabExecutor {
    private final JavaPlugin plugin = TubeNekoPluginBukkit.getProvidingPlugin(TubeNekoPluginBukkit.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (this.plugin.getConfig().getBoolean("command.where.toggle", false)) {
            if (args.length == 1 || args.length == 2) {
                if (sender instanceof Player player) {
                    Player target = player.getServer().getPlayer(args[0]);

                    if (target != null) {
                        Location location = target.getLocation();
                        String dimension = target.getName();

                        sender.sendMessage(this.plugin.getConfig().getString("command.where.message", "")
                                .formatted(ChatColor.AQUA, player.getDisplayName(),
                                        ChatColor.GREEN, location.getBlockX(), location.getBlockY(), location.getBlockZ(),
                                        ChatColor.GOLD, dimension));

                        if (args.length == 2 && args[1].equals("true")) {
                            target.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 30, 2));
                        }

                        return true;
                    }
                    sender.sendMessage(this.plugin.getConfig().getString("invalidPlayer", "")
                            .formatted(ChatColor.GREEN));

                    return true;
                }

                sender.sendMessage(this.plugin.getConfig().getString("notPlayer", "")
                        .formatted(ChatColor.RED));

                return true;
            }
            sender.sendMessage(this.plugin.getConfig().getString("help", "")
                    .formatted(ChatColor.GREEN));
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return List.of("<playerName> [glowing]");
        } else if (args.length == 2) {
            return List.of("[glowing]");
        }
        return List.of();
    }
}
