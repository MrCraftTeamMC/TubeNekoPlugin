package xyz.tcbuildmc.plugin.tubenekoplugin.common.util;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class FeatureAdapter {
    private final boolean enable;
    private final String error_nonPlayer;
    private final String id;
    private final JavaPlugin plugin;

    public FeatureAdapter(String id, JavaPlugin plugin) {
        this.enable = plugin.getConfig().getBoolean(
                Text.simple().getText("config.feature.%_.enable", id), false);
        this.error_nonPlayer = plugin.getConfig().getString("message.error.none_player");
        this.id = id;
        this.plugin = plugin;
    }

    public final String getId() {
        return this.id;
    }

    public String getNonPlayerMessage() {
        return this.error_nonPlayer;
    }

    public final JavaPlugin getPlugin() {
        return this.plugin;
    }

    public final boolean isEnable() {
        return this.enable;
    }
}
