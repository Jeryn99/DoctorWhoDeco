package me.craig.software.cosmetics.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class StrawHatModel<T extends Entity> extends EntityModel<T> {
	private final ModelPart bipedHead;

	public StrawHatModel(ModelPart root) {
		this.bipedHead = root.getChild("bipedHead");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bipedHead = partdefinition.addOrReplaceChild("bipedHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition seventh_hat = bipedHead.addOrReplaceChild("seventh_hat", CubeListBuilder.create().texOffs(0, 0).addBox(-5.25F, 3.5F, -3.5F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(-4.75F, 2.5F, -3.0F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(24, 24).addBox(-4.25F, 1.75F, -2.5F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 21).addBox(-4.25F, 0.75F, -2.5F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(27, 11).addBox(-3.25F, 0.5F, -2.5F, 6.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(17, 33).addBox(2.75F, 0.5F, -1.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(9, 30).addBox(-4.25F, 0.5F, -1.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(30, 0).mirror().addBox(-0.75F, 0.0F, -2.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.25F, -10.5F, -1.5F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bipedHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}