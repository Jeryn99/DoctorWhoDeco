package dev.jeryn.doctorwho.forge.data;

import com.google.gson.JsonObject;
import dev.jeryn.doctorwho.DoctorWhoDeco;
import dev.jeryn.doctorwho.common.WCBlocks;
import dev.jeryn.doctorwho.common.blocks.FacingEntityBlock;
import dev.jeryn.doctorwho.common.blocks.MonitorBlock;
import dev.jeryn.doctorwho.common.blocks.Nitro9Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class ModelProviderBlock extends BlockStateProvider {

    public ModelProviderBlock(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator.getPackOutput(), DoctorWhoDeco.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (Block value : ForgeRegistries.BLOCKS.getValues()) {
            @Nullable ResourceLocation location = ForgeRegistries.BLOCKS.getKey(value);
            if (location.getNamespace().matches(DoctorWhoDeco.MOD_ID)) {


                if (value instanceof SlabBlock slabBlock) {

                    ResourceLocation gold_top = new ResourceLocation(DoctorWhoDeco.MOD_ID, "block/roundel_gold_top");
                    ResourceLocation grey_top = new ResourceLocation(DoctorWhoDeco.MOD_ID, "block/roundel_grey_top");


                    ResourceLocation side = new ResourceLocation(DoctorWhoDeco.MOD_ID, "block/" + location.getPath().replace("_slab", ""));
                    ResourceLocation top = new ResourceLocation(DoctorWhoDeco.MOD_ID, "block/" + location.getPath().replace("_slab", "") + "_top");
                    ResourceLocation doubleslab = new ResourceLocation(DoctorWhoDeco.MOD_ID, "block/" + location.getPath().replace("_slab", ""));

                    if (location.getPath().contains("top_half")) {
                        side = new ResourceLocation(DoctorWhoDeco.MOD_ID, "block/" + location.getPath().replace("_slab", ""));
                        top = new ResourceLocation(DoctorWhoDeco.MOD_ID, "block/" + location.getPath().replace("_slab", "").replace("_top_half", "") + "_top");
                    }

                    if (location.getPath().contains("bottom_half")) {
                        side = new ResourceLocation(DoctorWhoDeco.MOD_ID, "block/" + location.getPath().replace("_slab", ""));
                        top = new ResourceLocation(DoctorWhoDeco.MOD_ID, "block/" + location.getPath().replace("_slab", "").replace("_bottom_half", "") + "_top");
                    }

                    if(location.getPath().contains("gold")){
                        top = gold_top;
                    }

                    if(location.getPath().contains("grey")){
                        top = grey_top;
                    }

                    slabBlock(slabBlock, doubleslab, side, top, top);
                    continue;
                }

                if (value instanceof MonitorBlock monitorBlock) {
                    ResourceLocation vicMon = new ResourceLocation(DoctorWhoDeco.MOD_ID, "block/victorian_monitor");
                    ResourceLocation vicMonHanging = new ResourceLocation(DoctorWhoDeco.MOD_ID, "block/victorian_monitor_hanging");
                    threeDeeRotatingHanging(monitorBlock, vicMon, vicMonHanging);
                    continue;
                }

                if(value instanceof HorizontalDirectionalBlock directionalBlock){
                    ResourceLocation texture = new ResourceLocation(DoctorWhoDeco.MOD_ID, "block/" + location.getPath());
                    threeDeeRotating(directionalBlock, texture);
                    continue;
                }

                if(value instanceof Nitro9Block nitro9Block){
                    customLocation(nitro9Block, new ResourceLocation(DoctorWhoDeco.MOD_ID, "block/nitro_9"));
                    continue;
                }

                if(value == WCBlocks.CORAL_CHAIR.get()){
                    continue;
                }

                simpleBlock(value);
            }
        }
    }

    public JsonObject customLocation(Block block, ResourceLocation resourceLocation) {
        return getVariantBuilder(block).partialState().modelForState().modelFile(models().getExistingFile(resourceLocation)).addModel().toJson();
    }

    // Paul McGann is...
    public JsonObject threeDeeRotating(Block block, ResourceLocation location) {
        return getVariantBuilder(block).forAllStates(
                state -> ConfiguredModel.builder().modelFile(new ModelFile.UncheckedModelFile(location)).rotationY((int) state.getValue(HorizontalDirectionalBlock.FACING).toYRot()).build()).toJson();
    }

    public JsonObject threeDeeRotatingHanging(Block block, ResourceLocation location, ResourceLocation hanging) {
        return getVariantBuilder(block).forAllStates(
                state -> ConfiguredModel.builder().modelFile(new ModelFile.UncheckedModelFile(state.getValue(MonitorBlock.HANGING) ? hanging : location)).rotationY((int) state.getValue(HorizontalDirectionalBlock.FACING).toYRot()).build()).toJson();
    }


    public JsonObject fourDRotating(Block block, ResourceLocation location) {
        return getVariantBuilder(block).forAllStates(
                state -> ConfiguredModel.builder().modelFile(new ModelFile.UncheckedModelFile(location)).rotationY((int) (state.getValue(FacingEntityBlock.ROTATION) * 90F)).build()).toJson();

    }

}