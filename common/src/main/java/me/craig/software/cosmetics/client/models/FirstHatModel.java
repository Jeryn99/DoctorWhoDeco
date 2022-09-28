package me.craig.software.cosmetics.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;


public class FirstHatModel<T extends Entity> extends EntityModel<T> {
    private final ModelPart first_fez;

    public FirstHatModel(ModelPart root) {
        this.first_fez = root.getChild("first_fez");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition first_fez = partdefinition.addOrReplaceChild("first_fez", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition first_hat = first_fez.addOrReplaceChild("first_hat", CubeListBuilder.create().texOffs(0, 0).addBox(-3.75F, -3.0F, 0.75F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -8.25F, 0.5F, -0.384F, 0.0F, 0.0F));

        PartDefinition tasel = first_hat.addOrReplaceChild("tasel", CubeListBuilder.create().texOffs(6, 7).addBox(0.4F, 0.1F, -1.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(6, 7).addBox(-1.4F, 0.1F, -1.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(0.4F, 0.1F, 0.65F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(-1.4F, 0.1F, 0.65F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.25F, -3.25F, 2.25F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        first_fez.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}