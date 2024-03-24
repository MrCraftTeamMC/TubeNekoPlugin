package xyz.tcbuildmc.tubenekoplugin.bungeecord.util;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ConfigurationUtils {
    public static Configuration saveDefaultConfig(Plugin plugin) throws IOException {
        makeConfig(plugin);
        saveConfig(plugin);

        return loadConfig(plugin);
    }

    public static void makeConfig(Plugin plugin) throws IOException {
        File dataFolder = plugin.getDataFolder();

        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }

        File configFile = getConfigFile(plugin);
        if (!configFile.exists()) {
            FileOutputStream fos = new FileOutputStream(configFile);
            InputStream is = plugin.getResourceAsStream("config.yml");
            is.transferTo(fos);

            is.close();
            fos.close();
        }
    }

    public static Configuration loadConfig(Plugin plugin) throws IOException {
        return getProvider().load(getConfigFile(plugin));
    }

    public static void saveConfig(Plugin plugin) throws IOException {
        getProvider().save(loadConfig(plugin), getConfigFile(plugin));
    }

    public static void saveConfig(Plugin plugin, Configuration configuration) throws IOException {
        getProvider().save(configuration, getConfigFile(plugin));
    }

    public static void reloadConfig(Plugin plugin) throws IOException {
        saveConfig(plugin);
    }

    public static void reloadConfig(Plugin plugin, Configuration configuration) throws IOException {
        saveConfig(plugin, configuration);
    }

    public static File getConfigFile(Plugin plugin) {
        return new File(plugin.getDataFolder(), "config.yml");
    }

    public static ConfigurationProvider getProvider() {
        return ConfigurationProvider.getProvider(YamlConfiguration.class);
    }
}
