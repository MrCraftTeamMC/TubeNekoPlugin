package xyz.tcbuildmc.tubenekoplugin.fabric;

import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class TubeNekoPluginModPlatformImpl {
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
