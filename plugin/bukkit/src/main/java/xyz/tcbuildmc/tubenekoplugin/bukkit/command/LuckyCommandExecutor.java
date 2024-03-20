package xyz.tcbuildmc.tubenekoplugin.bukkit.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tcbuildmc.tubenekoplugin.bukkit.TubeNekoPluginBukkit;

import java.util.Random;

public final class LuckyCommandExecutor implements CommandExecutor {
    private final JavaPlugin plugin = TubeNekoPluginBukkit.getProvidingPlugin(TubeNekoPluginBukkit.class);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (this.plugin.getConfig().getBoolean("command.jrrp.toggle", false)) {
            commandSender.sendMessage(this.plugin.getConfig().getString("command.jrrp.message",
                            "")
                    .formatted(ChatColor.AQUA, new Random().nextInt(this.plugin.getConfig().getInt(
                            "command.jrrp.range", 100))));
        }

        return true;
    }
}
