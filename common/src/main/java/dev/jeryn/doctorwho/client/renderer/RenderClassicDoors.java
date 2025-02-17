
package dev.jeryn.doctorwho.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.jeryn.doctorwho.client.models.block.ClassicDoorsModel;
import dev.jeryn.doctorwho.client.models.ModelRegistration;
import dev.jeryn.doctorwho.common.blockentity.ClassicDoorsBlockEntity;
import dev.jeryn.doctorwho.common.blocks.ClassicDoorsBlock;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.jetbrains.annotations.NotNull;

public class RenderClassicDoors implements BlockEntityRenderer<ClassicDoorsBlockEntity>, BlockEntityRendererProvider<ClassicDoorsBlockEntity> {

    private final ClassicDoorsModel classicDoorsModel;

    public RenderClassicDoors(Context context) {
        classicDoorsModel = new ClassicDoorsModel(context.bakeLayer(ModelRegistration.CLASSIC_DOOR));
    }

    @Override
    public void render(ClassicDoorsBlockEntity blockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        if (blockEntity.getBlockState().hasProperty(DoorBlock.HALF) && blockEntity.getBlockState().getValue(DoorBlock.HALF) == DoubleBlockHalf.UPPER)
            return;
        poseStack.pushPose();

        BlockState blockstate = blockEntity.getBlockState();
        poseStack.translate(0.5F, 1.5F, 0.5F);

        poseStack.mulPose(Axis.ZP.rotationDegrees(180F));
        float rotation = blockstate.getValue(ClassicDoorsBlock.FACING).toYRot();
        poseStack.mulPose(Axis.YP.rotationDegrees(rotation));

        if(blockstate.hasProperty(ClassicDoorsBlock.OFFSET) && blockstate.getValue(ClassicDoorsBlock.OFFSET)) {
            poseStack.translate(-0.5, 0, 1);
            poseStack.translate(0, 0, -0.01);
        } else {
            poseStack.translate(0, 0, 1);
            poseStack.translate(0, 0, -0.01);
        }

        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(blockstate.getBlock());

        classicDoorsModel.renderToBuffer(blockEntity, poseStack, bufferSource.getBuffer(RenderType.entityCutout(createTextureFromBlockState(blockKey))), packedLight, packedOverlay, 1, 1, 1, 1);
        poseStack.popPose();
    }

    public static ResourceLocation createTextureFromBlockState(ResourceLocation blockLocation){
        return new ResourceLocation(blockLocation.getNamespace(), "textures/block/"+ blockLocation.getPath() +".png");
    }


    @Override
    public BlockEntityRenderer<ClassicDoorsBlockEntity> create(Context context) {
        return new RenderClassicDoors(context);
    }
}

