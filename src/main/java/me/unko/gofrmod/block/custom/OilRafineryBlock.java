package me.unko.gofrmod.block.custom;

import com.mojang.serialization.MapCodec;
import me.unko.gofrmod.block.custom.entities.ModBlockEntities;
import me.unko.gofrmod.block.custom.entities.OilMakingEntity;
import me.unko.gofrmod.block.custom.entities.OilRafineryEntity;
import me.unko.gofrmod.item.ModItems;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class OilRafineryBlock extends BlockWithEntity {

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.getBlockEntity(pos) instanceof OilRafineryEntity entity && !world.isClient) {
            if(hand == Hand.MAIN_HAND && stack.getItem() == Items.BUCKET){
                if(entity.isBleachDone){
                    stack.decrement(1);
                    player.setStackInHand(Hand.MAIN_HAND, new ItemStack(ModItems.BLEACH_BUCKET, 1));
                    entity.removeBleach();
                }else if (entity.isMethylamineDone){
                    stack.decrement(1);
                    player.setStackInHand(Hand.MAIN_HAND, new ItemStack(ModItems.METHYLAMINE_BUCKET, 1));
                    entity.removeMethylamine();
                }
            } else if (hand == Hand.MAIN_HAND && stack.getItem() == ModItems.OIL_BUCKET){
                if(!entity.isFilled){
                    entity.fill();
                    stack.decrement(1);
                    player.setStackInHand(Hand.MAIN_HAND, new ItemStack(Items.BUCKET, 1));
                }
            }
        }

        return ActionResult.SUCCESS;
    }

    public OilRafineryBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(OilRafineryBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new OilRafineryEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.OIL_RAFINERY_BLOCK_ENTITY, OilRafineryEntity::tick);
    }
}
