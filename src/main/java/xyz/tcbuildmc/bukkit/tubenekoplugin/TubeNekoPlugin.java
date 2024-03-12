package xyz.tcbuildmc.bukkit.tubenekoplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tcbuildmc.bukkit.tubenekoplugin.plugin.mcdr.CatCommand;
import xyz.tcbuildmc.bukkit.tubenekoplugin.plugin.mcdr.CompassCommand;
import xyz.tcbuildmc.bukkit.tubenekoplugin.plugin.mcdr.HereCommand;
import xyz.tcbuildmc.bukkit.tubenekoplugin.plugin.mcdr.LuckyCommand;
import xyz.tcbuildmc.bukkit.tubenekoplugin.plugin.spectorondeath.PlayerRespawnEventListener;

import java.util.logging.Logger;

public final class TubeNekoPlugin extends JavaPlugin {
    private final Logger logger = super.getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic
        super.saveDefaultConfig();
        this.logger.info(super.getConfig().getString("enable"));

        Bukkit.getPluginCommand("here").setExecutor(new HereCommand(this));
        Bukkit.getPluginCommand("lucky").setExecutor(new LuckyCommand(this));
        Bukkit.getPluginCommand("cat").setExecutor(new CatCommand(this));
        Bukkit.getPluginCommand("compass").setExecutor(new CompassCommand(this));
        Bukkit.getPluginManager().registerEvents(new PlayerRespawnEventListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.logger.info(super.getConfig().getString("disable"));
        super.saveConfig();
    }
}
