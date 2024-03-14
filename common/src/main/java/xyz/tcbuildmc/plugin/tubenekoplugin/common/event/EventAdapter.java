package xyz.tcbuildmc.plugin.tubenekoplugin.common.event;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tcbuildmc.plugin.tubenekoplugin.common.util.FeatureAdapter;

public abstract class EventAdapter extends FeatureAdapter implements Listener {
    public EventAdapter(String id, JavaPlugin plugin) {
        super(id, plugin);
    }
}
