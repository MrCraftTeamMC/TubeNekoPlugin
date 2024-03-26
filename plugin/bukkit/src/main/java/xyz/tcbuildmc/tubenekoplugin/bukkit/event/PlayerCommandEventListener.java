package xyz.tcbuildmc.tubenekoplugin.bukkit.event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tcbuildmc.tubenekoplugin.bukkit.TubeNekoPluginBukkit;

import java.util.LinkedHashMap;
import java.util.Map;

public class PlayerCommandEventListener implements Listener {
    private final JavaPlugin plugin = TubeNekoPluginBukkit.getProvidingPlugin(TubeNekoPluginBukkit.class);
    private final long coolDown = plugin.getConfig().getInt("feature.commandCoolDown.time", 1) * 1000L;

    // V -> mills until u can use command
    private final Map<String, Long> coolDownMap = new LinkedHashMap<>();

    @EventHandler
    public void onPlayerCommandProcess(PlayerCommandPreprocessEvent e) {
        Player player = e.getPlayer();
        if ((!player.hasPermission("tubenekoplugin.bypass.commandCoolDown") || !player.isOp()) &&
                this.plugin.getConfig().getBoolean("feature.commandCoolDown.toggle", false)) {
            String uuid = player.getUniqueId().toString();

            if (!coolDownMap.containsKey(uuid)) {
                coolDownMap.put(uuid, System.currentTimeMillis() + this.coolDown);
                return;
            }

            long until = coolDownMap.get(uuid);
            if (System.currentTimeMillis() <= until) {
                player.sendMessage(this.plugin.getConfig().getString("feature.commandCoolDown.message", "")
                        .formatted(ChatColor.GREEN));

                e.setCancelled(true);
                return;
            }

            coolDownMap.remove(uuid);
        }
    }
}
