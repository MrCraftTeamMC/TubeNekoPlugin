package xyz.tcbuildmc.tubenekoplugin.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import xyz.tcbuildmc.tubenekoplugin.TubeNekoPluginMod;
import net.fabricmc.api.ModInitializer;

public class TubeNekoPluginModFabric implements ModInitializer, ClientModInitializer {
    @Override
    public void onInitialize() {
        TubeNekoPluginMod.init();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void onInitializeClient() {
        TubeNekoPluginMod.initClient();
    }
}
