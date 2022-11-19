package mc.craig.software.cosmetics.mixin;

import mc.craig.software.cosmetics.common.entity.DavrosChair;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerRenderer.class)
public class MixinRenderPlayer {

    @Inject(at = @At("TAIL"), method = "setModelProperties(Lnet/minecraft/client/player/AbstractClientPlayer;)V", cancellable = true)
    private void setModelProperties(AbstractClientPlayer clientPlayer, CallbackInfo ci) {
        if(clientPlayer.getVehicle() instanceof DavrosChair){
            PlayerRenderer renderer = (PlayerRenderer) (Object) this;
            PlayerModel<AbstractClientPlayer> model = renderer.getModel();
            model.leftLeg.visible = model.rightLeg.visible = model.leftPants.visible = model.rightPants.visible = false;
        }
    }

}
