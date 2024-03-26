package xyz.tcbuildmc.tubenekoplugin.bukkit.hook.papi;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import xyz.tcbuildmc.tubenekoplugin.bukkit.TubeNekoPluginBukkit;

public final class PlaceholderAPIHook extends PlaceholderExpansion {
    @Override
    public String getIdentifier() {
        return "tubenekoplugin";
    }

    @Override
    public String getAuthor() {
        return String.join(", ", TubeNekoPluginBukkit.getProvidingPlugin(TubeNekoPluginBukkit.class)
                .getDescription().getAuthors());
    }

    @Override
    public String getVersion() {
        return TubeNekoPluginBukkit.getProvidingPlugin(TubeNekoPluginBukkit.class).getDescription().getVersion();
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        return super.onRequest(player, params);
    }

    @Override
    public String onPlaceholderRequest(Player player, String params) {
        return super.onPlaceholderRequest(player, params);
    }
}
