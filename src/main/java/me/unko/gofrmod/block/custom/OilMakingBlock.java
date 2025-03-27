package me.unko.gofrmod.block.custom;

import com.mojang.serialization.MapCodec;
import me.unko.gofrmod.block.custom.entities.ModBlockEntities;
import me.unko.gofrmod.block.custom.entities.OilMakingEntity;
import me.unko.gofrmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class OilMakingBlock extends BlockWithEntity {

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.getBlockEntity(pos) instanceof OilMakingEntity entity) {
            if (entity.isReady && hand == Hand.MAIN_HAND && stack.getItem() == Items.BUCKET) {
                stack.decrement(1);
                player.setStackInHand(Hand.MAIN_HAND, new ItemStack(ModItems.OIL_BUCKET, 1));
                entity.setIsReady(false);
            }
            else if (hand == Hand.MAIN_HAND && stack.getItem() == Items.COAL){
                entity.addAmount(0.1f);
                stack.decrement(1);
            }
        }

        return ActionResult.SUCCESS;
    }

    public OilMakingBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(OilMakingBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new OilMakingEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.OIL_MAKING_BLOCK_ENTITY, OilMakingEntity::tick);
    }
}
