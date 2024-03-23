package xyz.tcbuildmc.tubenekoplugin;

import dev.architectury.injectables.annotations.ExpectPlatform;

import java.nio.file.Path;

public final class TubeNekoPluginModPlatform {
    @ExpectPlatform
    public static Path getConfigDirectory() {
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }
}
