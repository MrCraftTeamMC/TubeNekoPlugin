package xyz.tcbuildmc.tubenekoplugin.sponge;

import com.google.inject.Inject;
import net.kyori.adventure.text.Component;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.Server;
import org.spongepowered.api.command.Command;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.StartedEngineEvent;
import org.spongepowered.plugin.builtin.jvm.Plugin;
import xyz.tcbuildmc.tubenekoplugin.sponge.command.LuckyCommandExecutor;

import java.util.Random;

@Plugin("tubenekoplugin")
public class TubeNekoPluginSponge {
    @Inject
    private Logger logger;

    @Listener
    public void onLoad(final StartedEngineEvent<Server> e) {
    }

    public void registerCommands() {
        Command.builder()
                .executor(new LuckyCommandExecutor())
                .permission("tubenekoplugin.command.jrrp")
                .shortDescription(Component.text("Show your lucky number."))
                .executionRequirements(commandCause -> commandCause.cause().root()
                        instanceof ServerPlayer)
                .build();
    }
}
