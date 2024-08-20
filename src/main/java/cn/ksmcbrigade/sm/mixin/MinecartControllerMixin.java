package cn.ksmcbrigade.sm.mixin;

import cn.ksmcbrigade.sm.SpeedMinecart;
import net.minecraft.entity.vehicle.DefaultMinecartController;
import net.minecraft.entity.vehicle.ExperimentalMinecartController;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({DefaultMinecartController.class, ExperimentalMinecartController.class})
public class MinecartControllerMixin {
    @Inject(method = "getSpeedRetention",at = @At("RETURN"),cancellable = true)
    public void get(CallbackInfoReturnable<Double> cir){
        if(SpeedMinecart.enabled) cir.setReturnValue(cir.getReturnValue()*(SpeedMinecart.times/2));
    }
}
