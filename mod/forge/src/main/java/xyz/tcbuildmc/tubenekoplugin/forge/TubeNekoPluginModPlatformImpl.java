package xyz.tcbuildmc.tubenekoplugin.forge;

import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class TubeNekoPluginModPlatformImpl {
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
