package xyz.tcbuildmc.bukkit.tubenekoplugin.plugin.mcdr;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import xyz.tcbuildmc.bukkit.tubenekoplugin.common.util.Text;

import java.util.Random;

public final class LuckyCommand implements CommandExecutor {
    private final boolean enable;
    private final String message;
    private final int range;

    public LuckyCommand(JavaPlugin plugin) {
        this.enable = plugin.getConfig().getBoolean("command.lucky.enable", true);
        this.message = plugin.getConfig().getString("command.lucky.message", "");
        this.range = plugin.getConfig().getInt("command.lucky.range", 100);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (this.enable) {
            Random random = new Random();
            commandSender.sendMessage(Text.simple().getText(this.message,
                    random.nextInt(this.range)));
        }

        return true;
    }
}
