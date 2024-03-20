package xyz.tcbuildmc.tubenekoplugin.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tcbuildmc.tubenekoplugin.bukkit.command.HereCommandExecutor;
import xyz.tcbuildmc.tubenekoplugin.bukkit.command.LuckyCommandExecutor;
import xyz.tcbuildmc.tubenekoplugin.bukkit.command.MainCommand;
import xyz.tcbuildmc.tubenekoplugin.bukkit.command.WhereCommandExecutor;
import xyz.tcbuildmc.tubenekoplugin.bukkit.event.PlayerRespawnEventListener;

import java.util.Objects;

public class TubeNekoPluginBukkit extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();

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
        saveConfig();
    }
}
