package dev.jeryn.doctorwho.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.jeryn.doctorwho.DoctorWhoDeco;
import dev.jeryn.doctorwho.client.models.ModelRegistration;
import dev.jeryn.doctorwho.client.models.block.TenthDoctorChairModel;
import dev.jeryn.doctorwho.common.blockentity.CoralChairBlockEntity;
import dev.jeryn.doctorwho.common.blocks.CoralChairBlock;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

public class RenderCoralChair implements BlockEntityRenderer<CoralChairBlockEntity>, BlockEntityRendererProvider<CoralChairBlockEntity> {


    private static final ResourceLocation TEXTURE = new ResourceLocation(DoctorWhoDeco.MOD_ID, "textures/block/coral_chair.png");
    private final TenthDoctorChairModel chair;

    public RenderCoralChair(Context context) {
        chair = new TenthDoctorChairModel(context.bakeLayer(ModelRegistration.TENTH_CHAIR));
    }

    @Override
    public void render(CoralChairBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 1.5, 0.5D);

        BlockState blockstate = blockEntity.getBlockState();
        poseStack.mulPose(Axis.ZP.rotationDegrees(180));
        poseStack.mulPose(Axis.YP.rotationDegrees(-blockstate.getValue(CoralChairBlock.FACING).toYRot()));
        chair.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(TEXTURE)), packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        poseStack.popPose();
    }



    @Override
    public BlockEntityRenderer<CoralChairBlockEntity> create(Context context) {
        return new RenderCoralChair(context);
    }
}
