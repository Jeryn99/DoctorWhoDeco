package mc.craig.software.cosmetics;

import mc.craig.software.cosmetics.common.WCItems;
import mc.craig.software.cosmetics.common.entity.Entities;
import net.minecraft.world.entity.Entity;

public class WhoCosmetics {
    public static final String MOD_ID = "whocosmetics";
    public static final String MAPPING_ERROR = "Something has went terribly wrong with expect platform";

    public static void init() {
        WCItems.ITEMS.register();
        Entities.ENTITY_TYPES.register();
    }
}
