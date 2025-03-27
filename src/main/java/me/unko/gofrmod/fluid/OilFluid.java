package me.unko.gofrmod.fluid;

import me.unko.gofrmod.block.ModBlocks;
import me.unko.gofrmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public abstract class OilFluid extends FlowableFluid {
    @Override
    public Fluid getFlowing() {
        return ModFluids.OIL_FLOWING;
    }

    @Override
    public Fluid getStill() {
        return ModFluids.OIL_STILL;
    }

    @Override
    protected boolean isInfinite(ServerWorld world) {
        return true;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    @Override
    protected int getMaxFlowDistance(WorldView world) {
        return 3;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView world) {
        return 3;
    }

    @Override
    public Item getBucketItem() {
        return ModItems.OIL_BUCKET;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return false;
    }

    @Override
    public int getTickRate(WorldView world) {
        return 50;
    }

    @Override
    protected float getBlastResistance() {
        return 100f;
    }

    public boolean matchesType(Fluid fluid) {
        return fluid == ModFluids.OIL_STILL || fluid == ModFluids.OIL_FLOWING;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModBlocks.OIL_FLUID_BLOCK.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
    }
    public static class Flowing extends OilFluid {

        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        public int getLevel(FluidState state) {
            return (Integer)state.get(LEVEL);
        }

        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends OilFluid {

        public int getLevel(FluidState state) {
            return 8;
        }

        public boolean isStill(FluidState state) {
            return true;
        }
    }
}
