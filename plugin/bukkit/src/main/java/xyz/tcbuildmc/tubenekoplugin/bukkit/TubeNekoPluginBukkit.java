package xyz.tcbuildmc.tubenekoplugin.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tcbuildmc.tubenekoplugin.bukkit.command.HereCommandExecutor;
import xyz.tcbuildmc.tubenekoplugin.bukkit.command.LuckyCommandExecutor;
import xyz.tcbuildmc.tubenekoplugin.bukkit.command.MainCommand;
import xyz.tcbuildmc.tubenekoplugin.bukkit.command.WhereCommandExecutor;
import xyz.tcbuildmc.tubenekoplugin.bukkit.event.PlayerRespawnEventListener;
import xyz.tcbuildmc.tubenekoplugin.bukkit.hook.papi.Holders;
import xyz.tcbuildmc.tubenekoplugin.bukkit.hook.papi.PlaceholderAPIHook;
import xyz.tcbuildmc.tubenekoplugin.bukkit.stats.Metrics;

import java.util.Objects;
import java.util.logging.Logger;

public class TubeNekoPluginBukkit extends JavaPlugin {
    private final Logger logger = this.getLogger();
    private final int bstats_plugin_id = 21386;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        // Hooks
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PlaceholderAPIHook().register();
            Holders.setAccessible(true);
        } else {
            this.logger.warning(this.getConfig().getString("noPapi", "")
                    .formatted(ChatColor.GREEN));
        }

        // BStats
        if (this.getConfig().getBoolean("bstats", false)) {
            new Metrics(this, bstats_plugin_id);
        }

        Bukkit.getPluginManager().registerEvents(new PlayerRespawnEventListener(), this);
        Objects.requireNonNull(Bukkit.getPluginCommand("tubenekoplugin")).setExecutor(new MainCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("tubenekoplugin")).setTabCompleter(new MainCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("jrrp")).setExecutor(new LuckyCommandExecutor());
        Objects.requireNonNull(Bukkit.getPluginCommand("here")).setExecutor(new HereCommandExecutor());
        Objects.requireNonNull(Bukkit.getPluginCommand("here")).setTabCompleter(new HereCommandExecutor());
        Objects.requireNonNull(Bukkit.getPluginCommand("where")).setExecutor(new WhereCommandExecutor());
        Objects.requireNonNull(Bukkit.getPluginCommand("where")).setTabCompleter(new WhereCommandExecutor());
    }

    @Override
    public void onDisable() {
        this.saveConfig();
    }
}
