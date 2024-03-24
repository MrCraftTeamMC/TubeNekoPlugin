package xyz.tcbuildmc.tubenekoplugin.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;
import xyz.tcbuildmc.tubenekoplugin.velocity.command.BroadcastCommand;
import xyz.tcbuildmc.tubenekoplugin.velocity.command.MainCommand;

@Plugin(id = "tubenekoplugin",
    name = "TubeNekoPlugin",
    version = "1.0.0",
    description = "A server-side Mod / Plugin provides some mess features for Minecraft Servers. Used by TubeCraft.",
    url = "https://tcbuildmc.xyz",
    authors = {
        "TCBuildTeamMC",
        "Mr_limr267, Mr_zmh5, SnowCuiteQwQ"
    }
)
public final class TubeNekoPluginVelocity {
    @Inject
    private Logger logger;

    private final ProxyServer proxy;

    @Inject
    public TubeNekoPluginVelocity(ProxyServer proxy) {
        this.proxy = proxy;
    }

    @Subscribe
    public void onLoad(ProxyInitializeEvent e) {
        // Command Registration
        CommandManager manager = this.proxy.getCommandManager();

        manager.register(manager.metaBuilder("tubenekoplugin")
                .plugin(this)
                .build(), MainCommand.register(this.proxy));

        manager.register(manager.metaBuilder("broadcast")
                .plugin(this)
                .build(), BroadcastCommand.register(this.proxy));
    }
}
