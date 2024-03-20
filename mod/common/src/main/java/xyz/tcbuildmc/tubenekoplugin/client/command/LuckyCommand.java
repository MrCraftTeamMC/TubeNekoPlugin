package xyz.tcbuildmc.tubenekoplugin.client.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import dev.architectury.event.events.client.ClientCommandRegistrationEvent;
import net.minecraft.ChatFormatting;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;

import java.util.Random;

public final class LuckyCommand {
    private final LiteralCommandNode<ClientCommandRegistrationEvent.ClientCommandSourceStack> jrrp;
    private final LiteralCommandNode<ClientCommandRegistrationEvent.ClientCommandSourceStack> lucky;

    public LuckyCommand(CommandDispatcher<ClientCommandRegistrationEvent.ClientCommandSourceStack> dispatcher) {
        this.jrrp = dispatcher.register(ClientCommandRegistrationEvent.literal("jrrp")
                .executes(this::onExecute));
        this.lucky = dispatcher.register(ClientCommandRegistrationEvent.literal("licky")
                .redirect(this.jrrp));
    }

    public int onExecute(
            CommandContext<ClientCommandRegistrationEvent.ClientCommandSourceStack> context) {
        LocalPlayer player = context.getSource().arch$getPlayer();
        player.sendSystemMessage(Component.translatable(
                "commands.jrrp.message", new Random().nextInt(100))
                .withStyle(ChatFormatting.AQUA));

        return Command.SINGLE_SUCCESS;
    }

    public LiteralCommandNode<ClientCommandRegistrationEvent.ClientCommandSourceStack> getJrrpNode() {
        return this.jrrp;
    }

    public LiteralCommandNode<ClientCommandRegistrationEvent.ClientCommandSourceStack> getLuckyNode() {
        return this.lucky;
    }
}
