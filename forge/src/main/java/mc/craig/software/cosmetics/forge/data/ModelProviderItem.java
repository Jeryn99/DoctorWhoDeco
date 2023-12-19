package mc.craig.software.cosmetics.forge.data;

import mc.craig.software.cosmetics.WhoCosmetics;
import mc.craig.software.cosmetics.common.WCBlocks;
import mc.craig.software.cosmetics.common.WCItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class ModelProviderItem extends ItemModelProvider {

    public ModelProviderItem(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, WhoCosmetics.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(WCItems.DAVROS_BLACK.get());
        basicItem(WCItems.DAVROS_GOLD.get());

        for (Item value : ForgeRegistries.ITEMS.getValues()) {
            if(value instanceof BlockItem && getKey(value).getNamespace().matches(WhoCosmetics.MOD_ID)){
                blockItem(Objects.requireNonNull(getKey(value.asItem())));
            }
        }

        basicItem(Objects.requireNonNull(getKey(WCBlocks.CORAL_CHAIR.get().asItem())));
        basicItem(Objects.requireNonNull(getKey(WCBlocks.TOYOTA_ROTOR.get().asItem())));
        basicItem(Objects.requireNonNull(getKey(WCBlocks.CLASSIC_ROTOR.get().asItem())));
        basicItem(Objects.requireNonNull(getKey(WCBlocks.CLASSIC_DOORS.get().asItem())));
        basicItem(Objects.requireNonNull(getKey(WCBlocks.WHIRLY_GIG.get().asItem())));


    }

    public @Nullable ResourceLocation getKey(Item item) {
        return ForgeRegistries.ITEMS.getKey(item);
    }

    public ItemModelBuilder toolItem(ResourceLocation item) {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", new ResourceLocation(item.getNamespace(), "item/" + item.getPath()));
    }


    public ItemModelBuilder blockItem(ResourceLocation item) {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile(new ResourceLocation(item.getNamespace(), "block/" + item.getPath())));
    }

    public ItemModelBuilder layeredItem(ResourceLocation destination, ResourceLocation item, ResourceLocation resourceLocation) {
        return getBuilder(destination.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", new ResourceLocation(item.getNamespace(), "item/" + item.getPath()))
                .texture("layer1", new ResourceLocation(resourceLocation.getNamespace(), "item/" + resourceLocation.getPath()));
    }

    public ItemModelBuilder layeredItem(ResourceLocation item, ResourceLocation resourceLocation) {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", new ResourceLocation(item.getNamespace(), "item/" + item.getPath()))
                .texture("layer1", new ResourceLocation(resourceLocation.getNamespace(), "item/" + resourceLocation.getPath()));
    }
}