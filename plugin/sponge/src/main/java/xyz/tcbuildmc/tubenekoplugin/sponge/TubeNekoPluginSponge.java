package xyz.tcbuildmc.tubenekoplugin.sponge;

import com.google.inject.Inject;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.Server;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.StartedEngineEvent;
import org.spongepowered.plugin.builtin.jvm.Plugin;

@Plugin("tubenekoplugin")
public class TubeNekoPluginSponge {
    @Inject
    private Logger logger;

    @Listener
    public void onLoad(final StartedEngineEvent<Server> e) {
    }
}
