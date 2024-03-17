package xyz.tcbuildmc.tubenekoplugin.event;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.*;
import net.minecraft.server.level.ServerPlayer;

public class PlayerRespawnEventListener {
    public static void callOnRespawn(ServerPlayer died, ServerPlayer respawned) {
        int x = died.getBlockX();
        int y = died.getBlockY();
        int z = died.getBlockZ();
        String name = died.getName().getString();

        MutableComponent message = Component.translatable("event.enhanced_death.death_message", name, x, y, z)
                .withStyle(ChatFormatting.AQUA);
        Style style = message.getStyle();
        style.withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, x + " " + y + " " + z));
        style.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.literal(x + " " + y + " " + z)));
        message.setStyle(style);

        respawned.sendSystemMessage(message);
    }
}
