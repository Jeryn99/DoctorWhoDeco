package dev.jeryn.doctorwho.common;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.jeryn.doctorwho.DoctorWhoDeco;
import dev.jeryn.doctorwho.Platform;
import dev.jeryn.doctorwho.common.entity.DavrosChair;
import dev.jeryn.doctorwho.common.items.*;
import dev.jeryn.doctorwho.compat.TardisRefinedCompat;
import dev.jeryn.doctorwho.registry.DeferredRegistry;
import dev.jeryn.doctorwho.registry.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

public class WCItems {

    public static final DeferredRegistry<Item> ITEMS = DeferredRegistry.create(DoctorWhoDeco.MOD_ID, Registries.ITEM);
    public static Item.Properties GENERIC_PROPERTIES = new Item.Properties().stacksTo(1);
    public static Item.Properties GRENADE_PROP = new Item.Properties().stacksTo(8);

    public static final DeferredRegistry<CreativeModeTab> TABS = DeferredRegistry.create(DoctorWhoDeco.MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> MAIN = TABS.register(DoctorWhoDeco.MOD_ID, WCItems::createTab);
    public static final RegistrySupplier<CreativeModeTab> ROUNDELS = TABS.register(DoctorWhoDeco.MOD_ID + "_roundels", WCItems::createRoundelTab);
    public static final RegistrySupplier<CreativeModeTab> SLABS = TABS.register(DoctorWhoDeco.MOD_ID + "_slab_roundels", WCItems::createRoundelSlabsTab);

    public static final String CREATIVE_TAB = "tab." + DoctorWhoDeco.MOD_ID + ".main";


    public static final RegistrySupplier<Item> FEZ = ITEMS.register("fez", () -> new ClothingItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET, true, DyeColor.RED.getMapColor().col));
    public static final RegistrySupplier<Item> BOW_TIE = ITEMS.register("bowtie", () -> new ClothingItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, true, DyeColor.RED.getMapColor().col));
    public static final RegistrySupplier<Item> TOP_HAT = ITEMS.register("top_hat", () -> new JSONClothingItem(ArmorItem.Type.HELMET, true, DyeColor.BLUE.getMapColor().col));

    public static final RegistrySupplier<Item> CELERY = ITEMS.register("celery", () -> new ClothingItem(ArmorMaterials.TURTLE, ArmorItem.Type.CHESTPLATE));
    public static final RegistrySupplier<Item> SATCHEL = ITEMS.register("satchel", () -> new ClothingItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE));
    public static final RegistrySupplier<Item> STETSON = ITEMS.register("stetson", () -> new ClothingItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET));
    public static final RegistrySupplier<Item> ASTRAKHAN = ITEMS.register("astrakhan", () -> new ClothingItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET));
    public static final RegistrySupplier<Item> STRAW_HAT = ITEMS.register("straw_hat", () -> new ClothingItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET));
    public static final RegistrySupplier<Item> MONDAS = ITEMS.register("mondas", () -> new JSONClothingItem(ArmorItem.Type.HELMET));
    public static final RegistrySupplier<Item> THREED_GLASSES = ITEMS.register("3d_glasses", () -> new JSONClothingItem(ArmorItem.Type.HELMET));
    public static final RegistrySupplier<Item> MAGNOLI = ITEMS.register("magnoli_clothiers", () -> new JSONClothingItem(ArmorItem.Type.HELMET));
    public static final RegistrySupplier<Item> RAINBOW_SCARF = ITEMS.register("rainbow_scarf", () -> new ClothingItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE));
    public static final RegistrySupplier<Item> RED_SCARF = ITEMS.register("red_scarf", () -> new ClothingItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE));
    public static final RegistrySupplier<Item> SCARF = ITEMS.register("scarf", () -> new ClothingItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, false, DyeColor.GRAY.getMapColor().col));
    public static final RegistrySupplier<Item> CRICKET_JACKET = ITEMS.register("cricket_jacket", () -> new ClothingItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE).enableAlexSupport());

    public static final RegistrySupplier<Item> SECOND_JACKET = ITEMS.register("second_jacket", () -> new ClothingItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE).enableAlexSupport());
    public static final RegistrySupplier<Item> VELVET_COAT = ITEMS.register("velvet_coat", () -> new ClothingItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE).enableAlexSupport());
    public static final RegistrySupplier<Item> TENTH_COAT = ITEMS.register("tenth_coat", () -> new ClothingItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE).enableAlexSupport());
    public static final RegistrySupplier<Item> RAINBOW_COAT = ITEMS.register("rainbow_coat", () -> new ClothingItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE).enableAlexSupport());
    public static final RegistrySupplier<Item> SASH = ITEMS.register("sash", () -> new ClothingItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE));

    public static final RegistrySupplier<Item> FRUIT_HAT = ITEMS.register("fruit_hat", () -> new JSONClothingItem(ArmorItem.Type.HELMET));
    public static final RegistrySupplier<Item> FEATHER_HAT = ITEMS.register("feather_hat", () -> new JSONClothingItem(ArmorItem.Type.HELMET));

    public static final RegistrySupplier<Item> DAVROS_GOLD = ITEMS.register("davros_gold", () -> new DavrosSpawnerItem(WCItems.GENERIC_PROPERTIES, DavrosChair.Variant.GOLD));
    public static final RegistrySupplier<Item> DAVROS_BLACK = ITEMS.register("davros_black", () -> new DavrosSpawnerItem(WCItems.GENERIC_PROPERTIES, DavrosChair.Variant.BLACK));


    public static final RegistrySupplier<Item> SPACE_HELMET = ITEMS.register("space_helmet", () -> new ClothingItem(ArmorMaterials.IRON,ArmorItem.Type.HELMET).enableAlexSupport().setTextureOverride("space_suit"));
    public static final RegistrySupplier<Item> SPACE_CHEST = ITEMS.register("space_chest", () -> new ClothingItem(ArmorMaterials.IRON, ArmorItem.Type.CHESTPLATE).enableAlexSupport().setTextureOverride("space_suit"));
    public static final RegistrySupplier<Item> SPACE_LEGS = ITEMS.register("space_legs", () -> new ClothingItem(ArmorMaterials.IRON, ArmorItem.Type.LEGGINGS).enableAlexSupport().setTextureOverride("space_suit"));
    public static final RegistrySupplier<Item> SPACE_FEET = ITEMS.register("space_feet", () -> new ClothingItem(ArmorMaterials.IRON, ArmorItem.Type.BOOTS).enableAlexSupport().setTextureOverride("space_suit"));

    public static final RegistrySupplier<Item> ANTLERS = ITEMS.register("antlers", () -> new JSONClothingItem(ArmorItem.Type.HELMET));
    public static final RegistrySupplier<Item> GASMASK = ITEMS.register("gas_mask", () -> new ClothingItem(ArmorMaterials.CHAIN, ArmorItem.Type.HELMET));
    public static final RegistrySupplier<Item> EYE_STALK = ITEMS.register("eye_stalk", () -> new JSONClothingItem(ArmorItem.Type.HELMET));
    public static final RegistrySupplier<Item> ACES_BAT = ITEMS.register("aces_bat", () -> new SwordItem(Tiers.IRON, 3, -2.4F, (new Item.Properties())));

    public static final RegistrySupplier<Item> UNIT_BERRET_R = ITEMS.register("unit_berret_red", () -> new JSONClothingItem(ArmorItem.Type.HELMET));
    public static final RegistrySupplier<Item> UNIT_BERRET_G = ITEMS.register("unit_berret_green", () -> new JSONClothingItem(ArmorItem.Type.HELMET));
    public static final RegistrySupplier<Item> UNIT_BERRET_B = ITEMS.register("unit_berret_blue", () -> new JSONClothingItem(ArmorItem.Type.HELMET));


    public static final RegistrySupplier<Item> UMBRELLA = ITEMS.register("umbrella", () -> new UmbrellaItem(GENERIC_PROPERTIES));

    public static final RegistrySupplier<Item> UMBRELLA_MISSY = ITEMS.register("missy_umbrella", () -> new UmbrellaItem(GENERIC_PROPERTIES));

    public static final RegistrySupplier<Item> SONIC_10 = ITEMS.register("sonic_10", WCItems::createSonicItem);
    public static final RegistrySupplier<Item> SONIC_12 = ITEMS.register("sonic_12", WCItems::createSonicItem);
    public static final RegistrySupplier<Item> SONIC_13 = ITEMS.register("sonic_13", WCItems::createSonicItem);
    public static final RegistrySupplier<Item> SONIC_TROWEL = ITEMS.register("sonic_trowel", WCItems::createSonicItem);
    public static final RegistrySupplier<Item> SONIC_RIVER = ITEMS.register("sonic_river", WCItems::createSonicItem);
    public static final RegistrySupplier<Item> SONIC_14 = ITEMS.register("sonic_14", WCItems::createSonicItem);
    public static final RegistrySupplier<Item> SONIC_11 = ITEMS.register("sonic_11", WCItems::createSonicItem);
    public static final RegistrySupplier<Item> GRENADE = ITEMS.register("grenade", () -> new GrenadeItem(GRENADE_PROP));

    private static @NotNull Item createSonicItem() {

        if (!Platform.isModLoaded("tardis_refined")) {
            return new SonicItem(GENERIC_PROPERTIES);
        }

        return TardisRefinedCompat.getSonicItem();
    }


    @ExpectPlatform
    private static CreativeModeTab createTab() {
        throw new RuntimeException(DoctorWhoDeco.MAPPING_ERROR);
    }

    @ExpectPlatform
    private static CreativeModeTab createRoundelSlabsTab() {
        throw new RuntimeException(DoctorWhoDeco.MAPPING_ERROR);
    }

    @ExpectPlatform
    private static CreativeModeTab createRoundelTab() {
        throw new RuntimeException(DoctorWhoDeco.MAPPING_ERROR);
    }

}
