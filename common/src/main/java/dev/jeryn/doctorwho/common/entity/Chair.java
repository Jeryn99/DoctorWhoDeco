package dev.jeryn.doctorwho.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Chair extends Entity {

    private static int MAX_PASSENGERS = 3;


    public Chair(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return getPassengers().size() < MAX_PASSENGERS;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {

    }


    /**
     * Positions the given passenger on the vehicle.
     *
     * @param passenger the passenger to position on the vehicle
     */
    @Override
    protected void positionRider(Entity passenger, MoveFunction moveFunction) {
        // Calculate the mount offset based on the vehicle's and passenger's positions
        double mountOffset = this.getY() + this.getPassengersRidingOffset() + passenger.getMyRidingOffset();

        // Determine the direction the vehicle is facing
        Direction rotation = getDirection();

        // Calculate the block positions to the left and right of the vehicle
        BlockPos blockPos = blockPosition();
        BlockPos leftPos = blockPosition().relative(rotation.getClockWise());
        BlockPos rightPos = blockPosition().relative(rotation.getCounterClockWise());

        // Check if the passenger is actually a passenger on the vehicle
        if (!getPassengers().contains(passenger)) {
            return;
        }

        // Position the passenger based on their position in the list of passengers
        if (getPassengers().indexOf(passenger) == 0) {
            // If the passenger is the first in the list, call the parent method to position them
            passenger.setPos(blockPos.getX() + 0.5, mountOffset, blockPos.getZ() + 0.5);
        } else if (getPassengers().indexOf(passenger) == 1) {
            // If the passenger is the second in the list, position them to the left of the vehicle
            passenger.setPos(leftPos.getX() + 0.5, mountOffset, leftPos.getZ() + 0.5);
        } else if (getPassengers().indexOf(passenger) == 2) {
            // If the passenger is the third in the list, position them to the right of the vehicle
            passenger.setPos(rightPos.getX() + 0.5, mountOffset, rightPos.getZ() + 0.5);
        }
    }


    @Override
    public void tick() {
        if (getPassengers().isEmpty()) {
            kill();
        }

        super.tick();
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }
}
