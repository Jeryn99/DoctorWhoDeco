package mc.craig.software.cosmetics.common.entity;

import mc.craig.software.cosmetics.common.WCItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class Grenade extends ThrowableItemProjectile {
    private int fuse = 100;
    private boolean isBouncing = false;


    public Grenade(EntityType entityType, double d, double e, double f, Level level) {
        super(entityType, d, e, f, level);
    }

    public Grenade(EntityType entityType, Level level) {
        super(entityType, level);
    }

    public Grenade(LivingEntity livingEntity, Level level) {
        super(Entities.GRENADE.get(), livingEntity, level);
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }


    @Override
    public void tick() {
        super.tick();
        fuse--;
        if (fuse <= 0) {
            explode();
            remove(RemovalReason.DISCARDED);
        }
    }



    private void explode() {
        this.level.explode(this, this.getX(), this.getY(0.0625), this.getZ(), 2.0F, Explosion.BlockInteraction.BREAK);
        remove(RemovalReason.DISCARDED);
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
            explode();
    }

    @Override
    protected Item getDefaultItem() {
        return WCItems.GRENADE.get();
    }
}
