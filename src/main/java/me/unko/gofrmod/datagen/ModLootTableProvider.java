package me.unko.gofrmod.datagen;

import me.unko.gofrmod.block.ModBlocks;
import me.unko.gofrmod.block.custom.HeroinBush;
import me.unko.gofrmod.block.custom.WeedCropBlock;
import me.unko.gofrmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
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
        this.addDrop(ModBlocks.OIL_MAKING_BLOCK);
        this.addDrop(ModBlocks.OIL_RAFINERY_BLOCK);

        this.addDrop(ModBlocks.HEROIN_BUSH_BLOCK,
                block -> this.applyExplosionDecay(
                        block, LootTable.builder().pool(LootPool.builder().conditionally(
                                                BlockStatePropertyLootCondition.builder(ModBlocks.HEROIN_BUSH_BLOCK).properties(StatePredicate.Builder.create().exactMatch(HeroinBush.AGE, 3))
                                        )
                                        .with(ItemEntry.builder(ModItems.HEROIN_LEAF))
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                        ).pool(LootPool.builder().conditionally(
                                        BlockStatePropertyLootCondition.builder(ModBlocks.HEROIN_BUSH_BLOCK).properties(StatePredicate.Builder.create().exactMatch(HeroinBush.AGE, 2))
                                ).with(ItemEntry.builder(ModItems.HEROIN_LEAF))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F))))));
    }
}
