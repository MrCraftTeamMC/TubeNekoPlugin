package xyz.tcbuildmc.tubenekoplugin.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public final class HereCommand {
    private final LiteralCommandNode<CommandSourceStack> here;

    public HereCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        this.here = dispatcher.register(Commands.literal("here").then(
                Commands.argument("glowing", BoolArgumentType.bool())
                        .executes(this::onExecute)));
    }

    public int onExecute(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer target = context.getSource().getPlayerOrException();
        boolean glowing = BoolArgumentType.getBool(context, "glowing");
        String id = target.getCommandSenderWorld().dimension().registry().getNamespace();

        // TODO i18n
        target.sendSystemMessage(Component.translatable("commands.here.message", target.getBlockX(),
                target.getBlockY(), target.getBlockZ(), id).withStyle(ChatFormatting.AQUA));

        if (glowing) {
            target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 30, 2));
        }
        return Command.SINGLE_SUCCESS;
    }

    public LiteralCommandNode<CommandSourceStack> getHereNode() {
        return this.here;
    }
}
