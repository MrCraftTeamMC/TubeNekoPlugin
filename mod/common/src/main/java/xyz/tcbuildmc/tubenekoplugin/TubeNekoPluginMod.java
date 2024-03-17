package xyz.tcbuildmc.tubenekoplugin;

import dev.architectury.event.events.client.ClientCommandRegistrationEvent;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import dev.architectury.event.events.common.PlayerEvent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.tcbuildmc.tubenekoplugin.client.command.LuckyCommand;
import xyz.tcbuildmc.tubenekoplugin.event.PlayerRespawnEventListener;

public class TubeNekoPluginMod {
    public static final String MOD_ID = "tubenekoplugin";
    public static final Logger LOGGER = LoggerFactory.getLogger("TubeNekoPlugin");
    
    public static void init() {
        CommandRegistrationEvent.EVENT.register((dispatcher, registry, selection) -> {
        });

        // instead of PlayerEvent.PLAYER_RESPAWN
        PlayerEvent.PLAYER_CLONE.register((died, respawned, wonGame) -> {
            if (!wonGame) {
                PlayerRespawnEventListener.callOnRespawn(died, respawned);
            }
        });
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        ClientCommandRegistrationEvent.EVENT.register((dispatcher, context) -> {
            new LuckyCommand(dispatcher);
        });
    }
}
