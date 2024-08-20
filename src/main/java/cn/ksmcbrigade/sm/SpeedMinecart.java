package cn.ksmcbrigade.sm;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;

public class SpeedMinecart implements ModInitializer {

    public static boolean enabled = false;
    public static int times = 5;

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess,c) -> dispatcher.register(CommandManager.literal("speed-minecart").then(CommandManager.argument("times", IntegerArgumentType.integer()).executes(context -> {
            times = IntegerArgumentType.getInteger(context,"times");
            context.getSource().sendFeedback(()->Text.literal("Now times: "+times),false);
            return 0;
        }))));
    }
}
