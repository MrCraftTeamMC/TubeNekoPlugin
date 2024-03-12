package xyz.tcbuildmc.bukkit.tubenekoplugin.common.command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.tcbuildmc.bukkit.tubenekoplugin.common.util.FeatureAdapter;
import xyz.tcbuildmc.bukkit.tubenekoplugin.common.util.Text;

public abstract class CommandAdapter extends FeatureAdapter implements CommandExecutor {
    private final String message;
    public CommandAdapter(String id, JavaPlugin plugin) {
        super(id, plugin);

        this.message = plugin.getConfig().getString(
                Text.simple().getText("message.command.%_", id), "");
    }

    public final String getMessage() {
        return this.message;
    }
}
