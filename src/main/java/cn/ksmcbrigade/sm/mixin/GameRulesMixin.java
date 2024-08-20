package cn.ksmcbrigade.sm.mixin;

import cn.ksmcbrigade.sm.SpeedMinecart;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRules.class)
public class GameRulesMixin {
    @Shadow @Final public static GameRules.Key<GameRules.IntRule> MINECART_MAX_SPEED;

    @Inject(method = "getInt",at = @At("RETURN"),cancellable = true)
    public void get(GameRules.Key<GameRules.IntRule> rule, CallbackInfoReturnable<Integer> cir){
        if(SpeedMinecart.enabled && rule.equals(MINECART_MAX_SPEED)){
            cir.setReturnValue(cir.getReturnValue()* SpeedMinecart.times);
        }
    }
}
