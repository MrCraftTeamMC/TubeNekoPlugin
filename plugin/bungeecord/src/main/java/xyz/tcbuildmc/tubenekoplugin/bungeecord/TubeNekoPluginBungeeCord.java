package xyz.tcbuildmc.tubenekoplugin.bungeecord;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import xyz.tcbuildmc.tubenekoplugin.bungeecord.util.ConfigurationUtils;

import java.io.IOException;
import java.util.logging.Logger;

public final class TubeNekoPluginBungeeCord extends Plugin {
    private final Logger logger = this.getLogger();
    private Configuration configuration = new Configuration();
    private static boolean TOGGLE = true;

    @Override
    public void onEnable() {
        try {
            this.configuration = ConfigurationUtils.saveDefaultConfig(this);
        } catch (IOException e) {
            this.logger.warning("Cannot save config file!");
            TubeNekoPluginBungeeCord.TOGGLE = false;
        }

        if (TOGGLE) {
        }
    }

    @Override
    public void onDisable() {
        try {
            ConfigurationUtils.saveConfig(this);
        } catch (IOException e) {
            this.logger.warning("Cannot save config file!");
        }
    }
}
