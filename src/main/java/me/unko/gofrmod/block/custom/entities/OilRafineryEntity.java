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

public class OilRafineryEntity extends BlockEntity {

    public static boolean isFilled = false;
    public static boolean isBleachDone = false;
    public static boolean isMethylamineDone = false;
    private static int ticksPassed = 0;

    public OilRafineryEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.OIL_RAFINERY_BLOCK_ENTITY, pos, state);
    }

    public static void fill() {
        if(!isFilled) isFilled = true;
    }

    public static void removeBleach(){
        if(isBleachDone) isBleachDone = false;
    }

    public static void removeMethylamine(){
        if(isMethylamineDone) isMethylamineDone = false;
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
    public static void tick(World world, BlockPos pos, BlockState state, OilRafineryEntity blockEntity) {
        if (isFilled && !isBleachDone && !isMethylamineDone){
            ticksPassed++;
            if (ticksPassed > 1400){
                world.playSoundAtBlockCenter(pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1f, 1f, true);
                isFilled = false;
                isBleachDone = true;
                isMethylamineDone = true;
                ticksPassed = 0;
            }
        }
    }
}
