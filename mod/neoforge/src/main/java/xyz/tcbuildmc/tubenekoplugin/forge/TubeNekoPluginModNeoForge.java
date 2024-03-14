package xyz.tcbuildmc.tubenekoplugin.forge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.common.Mod;
import xyz.tcbuildmc.tubenekoplugin.TubeNekoPluginMod;

@Mod(TubeNekoPluginMod.MOD_ID)
public class TubeNekoPluginModNeoForge {
    public TubeNekoPluginModNeoForge() {
        TubeNekoPluginMod.init();
        ExampleModNeoForgeInitClient();
    }

    @OnlyIn(Dist.CLIENT)
    public static void ExampleModNeoForgeInitClient() {
        TubeNekoPluginMod.initClient();
    }
}
