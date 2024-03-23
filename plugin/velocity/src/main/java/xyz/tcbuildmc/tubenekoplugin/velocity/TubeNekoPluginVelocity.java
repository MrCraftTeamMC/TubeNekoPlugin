package xyz.tcbuildmc.tubenekoplugin.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import org.slf4j.Logger;

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

    @Subscribe
    public void onLoad(ProxyInitializeEvent e) {
    }
}
