package xyz.tcbuildmc.tubenekoplugin.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tcbuildmc.tubenekoplugin.bukkit.command.LuckyCommandExecutor;

public class TubeNekoPluginBukkit extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();

        Bukkit.getPluginCommand("jrrp").setExecutor(new LuckyCommandExecutor(this));
    }

    @Override
    public void onDisable() {
        saveConfig();
    }
}
