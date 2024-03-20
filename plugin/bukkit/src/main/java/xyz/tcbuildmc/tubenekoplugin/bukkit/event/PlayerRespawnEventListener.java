package xyz.tcbuildmc.tubenekoplugin.bukkit.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tcbuildmc.tubenekoplugin.bukkit.TubeNekoPluginBukkit;

import java.util.Objects;

public final class PlayerRespawnEventListener implements Listener {
    private final JavaPlugin plugin = TubeNekoPluginBukkit.getProvidingPlugin(TubeNekoPluginBukkit.class);

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if (this.plugin.getConfig().getBoolean("feature.enhancedDeath.toggle", false)) {
            Player player = e.getEntity();
            Location location = player.getLocation();
            int x = location.getBlockX();
            int y = location.getBlockY();
            int z = location.getBlockZ();
            String dimension = Objects.requireNonNull(location.getWorld()).getName();

            player.sendMessage(this.plugin.getConfig().getString("feature.enhancedDeath.deathMessage", "")
                    .formatted(ChatColor.AQUA,
                            ChatColor.GOLD, x, y, z,
                            ChatColor.GREEN, dimension));
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        if (this.plugin.getConfig().getBoolean("feature.enhancedDeath.toggle", false)) {
            Player player = e.getPlayer();

            if ((!player.isOp() || !player.hasPermission("tubenekoplugin.bypass.enhancedDeath")) &&
                    this.plugin.getConfig().getBoolean("feature.enhancedDeath.toggle", false)) {
                int wait = this.plugin.getConfig().getInt("feature.enhancedDeath.time", 3);
                Location location = player.getLocation();
                GameMode mode = player.getGameMode();

                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(this.plugin.getConfig().getString("feature.enhancedDeath.respawnWaitMessage",
                        "").formatted(ChatColor.AQUA, wait));

                Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
                    try {
                        Thread.sleep(wait * 1000L);
                    } catch (InterruptedException ignored) {
                    } finally {
                        Bukkit.getScheduler().runTask(this.plugin, () -> {
                            player.teleport(location);
                            player.setGameMode(mode);
                        });
                    }
                });
            }
        }
    }
}
