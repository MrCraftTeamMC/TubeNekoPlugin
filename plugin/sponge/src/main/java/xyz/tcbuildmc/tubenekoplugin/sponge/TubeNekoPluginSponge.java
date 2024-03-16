package xyz.tcbuildmc.tubenekoplugin.sponge;

import com.google.inject.Inject;
import net.kyori.adventure.text.Component;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.Server;
import org.spongepowered.api.command.Command;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.RegisterCommandEvent;
import org.spongepowered.api.event.lifecycle.StartedEngineEvent;
import org.spongepowered.plugin.PluginContainer;
import org.spongepowered.plugin.builtin.jvm.Plugin;
import xyz.tcbuildmc.tubenekoplugin.sponge.command.CommandUtil;
import xyz.tcbuildmc.tubenekoplugin.sponge.command.LuckyCommandExecutor;

@Plugin("tubenekoplugin")
public class TubeNekoPluginSponge {
    @Inject
    private Logger logger;

    @Inject
    private PluginContainer container;

    @Listener
    public void onLoad(final StartedEngineEvent<Server> e) {
    }

    @Listener
    public void onRegisterCommands(final RegisterCommandEvent<Command.Parameterized> event){
        event.register(this.container, CommandUtil.getCommand(new LuckyCommandExecutor(),
                        "tubenekoplugin.command.jrrp",
                Component.text("Show your lucky number.")),
                "jrrp", "lucky");
    }
}
