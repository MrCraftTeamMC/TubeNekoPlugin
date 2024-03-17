package xyz.tcbuildmc.tubenekoplugin.bukkit;

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

import java.util.Objects;

public final class PlayerRespawnEventListener implements Listener {
    private final JavaPlugin plugin;

    public PlayerRespawnEventListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
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

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();

        if ((!player.isOp() || !player.hasPermission("tubenekoplugin.bypass.enhanceddeath")) &&
                this.plugin.getConfig().getBoolean("feature.enhanceddeath.toggle", false)) {
            int wait = this.plugin.getConfig().getInt("feature.enhanceddeath.time", 3);
            Location location = player.getLocation();
            GameMode mode = player.getGameMode();

            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage(this.plugin.getConfig().getString("feature.enhanceddeath.respawnWaitMessage",
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
