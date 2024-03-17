package xyz.tcbuildmc.tubenekoplugin.misc;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Experimental
public class KeyMappings {
    public static final KeyMapping KEY_AUTOGG = new KeyMapping(
            "key.tubenekoplugin.auto_gg",
            InputConstants.Type.KEYSYM,
            InputConstants.KEY_G,
            "category.tubenekoplugin.auto_gg");

    public static final KeyMapping KEY_AUTOLOL = new KeyMapping(
            "key.tubenekoplugin.auto_lol",
            InputConstants.Type.KEYSYM,
            InputConstants.KEY_L,
            "category.tubenekoplugin.auto_lol");

    public static final KeyMapping KEY_AUTOHUB = new KeyMapping(
            "key.tubenekoplugin.auto_hub",
            InputConstants.Type.KEYSYM,
            InputConstants.KEY_H,
            "category.tubenekoplugin.auto_hub");


}
