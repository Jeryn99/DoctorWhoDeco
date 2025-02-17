package dev.jeryn.doctorwho.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.jeryn.doctorwho.common.entity.Grenade;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class RenderGrenade extends ThrownItemRenderer<Grenade> {

    public RenderGrenade(EntityRendererProvider.Context context, float f, boolean bl) {
        super(context, f, bl);
    }

    public RenderGrenade(EntityRendererProvider.Context context) {
        super(context);
    }


    @Override
    public void render(Grenade entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotation(entity.tickCount / 2));
        poseStack.mulPose(Axis.ZP.rotation((float) (entity.tickCount / 2 * Math.random())));
        super.render(entity, entityYaw, partialTick, poseStack, buffer, packedLight);
        poseStack.popPose();
    }
}
