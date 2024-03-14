package xyz.tcbuildmc.tubenekoplugin.forge;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import xyz.tcbuildmc.tubenekoplugin.TubeNekoPluginMod;
import net.minecraftforge.fml.common.Mod;

@Mod(TubeNekoPluginMod.MOD_ID)
public class TubeNekoPluginModForge {
    public TubeNekoPluginModForge() {
        // Submit our event bus to let architectury register our content on the right time
//        EventBuses.registerModEventBus(TubeNekoPluginMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        TubeNekoPluginMod.init();
        ExampleModForgeInitClient();
    }

    @OnlyIn(Dist.CLIENT)
    public static void ExampleModForgeInitClient() {
        TubeNekoPluginMod.initClient();
    }
}
