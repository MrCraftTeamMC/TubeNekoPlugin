package xyz.tcbuildmc.plugin.tubenekoplugin.common.backup.plugin.spectorondeath;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tcbuildmc.plugin.tubenekoplugin.common.util.Text;

import java.util.Objects;

public final class PlayerRespawnEventListener implements Listener {
    private final JavaPlugin plugin;
    private final boolean enable;
    private final int respawnTime;
    private final String deathMessage;
    private final String respawnMessage;

    public PlayerRespawnEventListener(JavaPlugin plugin) {
        this.plugin = plugin;
        this.enable = plugin.getConfig().getBoolean("feature.sod.enable", true);
        this.respawnTime = plugin.getConfig().getInt("feature.sod.time", 3);
        this.deathMessage = plugin.getConfig().getString("feature.sod.message.death", "");
        this.respawnMessage = plugin.getConfig().getString("feature.sod.message.respawn", "");
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if (this.enable) {
            Player player = e.getEntity().getPlayer();
            Location location = Objects.requireNonNull(player).getLocation();

            player.sendMessage(Text.simple().getText(this.deathMessage,
                    location.getBlockX(), location.getBlockY(), location.getBlockZ(),
                    Objects.requireNonNull(location.getWorld()).getName()));
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();

        if ((!player.isOp() || !player.hasPermission("tubeutilities.bypass.sod") && this.enable)) {
            Location location = player.getLocation();

            GameMode mode = player.getGameMode();
            player.setGameMode(GameMode.SPECTATOR);

            Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
                try {
                    player.sendMessage(Text.simple().getText(this.respawnMessage,
                            this.respawnTime));
                    Thread.sleep(this.respawnTime * 1000L);
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
