package xyz.tcbuildmc.tubenekoplugin;

import dev.architectury.event.events.client.ClientCommandRegistrationEvent;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class TubeNekoPluginMod {
    public static final String MOD_ID = "tubenekoplugin";
    
    public static void init() {
        CommandRegistrationEvent.EVENT.register((dispatcher, registry, selection) -> {

        });
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        ClientCommandRegistrationEvent.EVENT.register((dispatcher, context) -> {

        });
    }
}
