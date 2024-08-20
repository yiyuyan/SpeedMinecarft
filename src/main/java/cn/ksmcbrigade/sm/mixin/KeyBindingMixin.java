package cn.ksmcbrigade.sm.mixin;

import cn.ksmcbrigade.sm.SpeedMinecart;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyBinding.class)
public class KeyBindingMixin {
    @Inject(method = "onKeyPressed",at = @At("HEAD"))
    private static void keyPressed(InputUtil.Key key, CallbackInfo ci){
        if(key.getCode()== GLFW.GLFW_KEY_O){
            SpeedMinecart.enabled = !SpeedMinecart.enabled;
            if(MinecraftClient.getInstance().player!=null) MinecraftClient.getInstance().player.sendMessage(Text.of("SpeedMinecarft: "+ SpeedMinecart.enabled),true);
        }
    }
}
