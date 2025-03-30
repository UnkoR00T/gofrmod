package me.unko.gofrmod.block.custom.entities;

import me.unko.gofrmod.GofrMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class OilMakingEntity extends BlockEntity {

    public static float amount = 0f;
    public static boolean isReady = false;
    public static int ticksPassed = 0;

    public void setIsReady(boolean _isReady) {
        isReady = _isReady;
    }

    public void addAmount(float _amount) {
        amount = amount + _amount;
    }

    public OilMakingEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.OIL_MAKING_BLOCK_ENTITY, pos, state);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        nbt.putFloat("amount", amount);
        nbt.putBoolean("isReady", isReady);
        super.writeNbt(nbt, registries);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        amount = nbt.getFloat("amount");
        isReady = nbt.getBoolean("isReady");
        super.readNbt(nbt, registries);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
    public static void tick(World world, BlockPos pos, BlockState state, OilMakingEntity blockEntity) {
        if(amount >= 1f && !isReady){
            ticksPassed++;
            if(ticksPassed >= 1200){
                world.playSoundAtBlockCenter(pos, SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.BLOCKS, 1f, 1f, true);
                ticksPassed = 0;
                isReady = true;
                amount -= 1f;
            }
        }
    }
}
