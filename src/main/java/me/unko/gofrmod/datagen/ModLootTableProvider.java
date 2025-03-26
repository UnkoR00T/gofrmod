package me.unko.gofrmod.datagen;

import me.unko.gofrmod.block.ModBlocks;
import me.unko.gofrmod.block.custom.WeedCropBlock;
import me.unko.gofrmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }
    @Override
    public void generate() {
        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.WEED_CROP_BLOCK)
                .properties(StatePredicate.Builder.create().exactMatch(WeedCropBlock.AGE, WeedCropBlock.MAX_AGE));
        this.addDrop(ModBlocks.WEED_CROP_BLOCK, this.cropDrops(ModBlocks.WEED_CROP_BLOCK, ModItems.WEED, ModItems.WEED_SEEDS, builder2));
    }
}
