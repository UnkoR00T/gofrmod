package me.unko.gofrmod.datagen;

import me.unko.gofrmod.block.ModBlocks;
import me.unko.gofrmod.block.custom.HeroinBush;
import me.unko.gofrmod.block.custom.WeedCropBlock;
import me.unko.gofrmod.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.TexturedModel;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.WEED_CROP_BLOCK, WeedCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
        blockStateModelGenerator.registerSingleton(ModBlocks.OIL_MAKING_BLOCK, TexturedModel.CUBE_BOTTOM_TOP);
        blockStateModelGenerator.registerSingleton(ModBlocks.OIL_RAFINERY_BLOCK, TexturedModel.CUBE_BOTTOM_TOP);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.HEROIN_BUSH_BLOCK, BlockStateModelGenerator.CrossType.NOT_TINTED,
                HeroinBush.AGE, 0, 1, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }


}
