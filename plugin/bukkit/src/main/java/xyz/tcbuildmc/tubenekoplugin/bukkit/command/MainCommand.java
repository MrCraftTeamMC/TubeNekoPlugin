package xyz.tcbuildmc.tubenekoplugin.bukkit.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tcbuildmc.tubenekoplugin.bukkit.TubeNekoPluginBukkit;

import java.util.List;

public class MainCommand implements TabExecutor {
    private final JavaPlugin plugin = TubeNekoPluginBukkit.getProvidingPlugin(TubeNekoPluginBukkit.class);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String alias, String[] args) {
        if (args.length == 1) { // Sub-command
            String content = args[0];

            switch (content) {
                case "reload": {
                    commandSender.sendMessage(this.plugin.getConfig().getString("reload", "")
                            .formatted(ChatColor.AQUA));
                }
                case "help":
                default: {
                    commandSender.sendMessage(this.plugin.getConfig().getString("help", "")
                            .formatted(ChatColor.GREEN));
                    break;
                }
            }
        } else {
            commandSender.sendMessage(this.plugin.getConfig().getString("help", "")
                    .formatted(ChatColor.GREEN));
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return List.of("<help|reload>");
        }

        return List.of();
    }
}
