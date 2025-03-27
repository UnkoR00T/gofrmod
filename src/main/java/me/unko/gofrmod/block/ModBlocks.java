package me.unko.gofrmod.block;

import me.unko.gofrmod.GofrMod;
import me.unko.gofrmod.block.custom.OilMakingBlock;
import me.unko.gofrmod.block.custom.WeedCropBlock;
import me.unko.gofrmod.fluid.ModFluids;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final Block WEED_CROP_BLOCK = register("weed_crop",
            WeedCropBlock::new,
            AbstractBlock.Settings.create().noCollision().breakInstantly().ticksRandomly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY));

    public static final Block OIL_FLUID_BLOCK = registerBlock("oil_block",
            new FluidBlock(ModFluids.OIL_STILL, FluidBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(GofrMod.MOD_ID, "oil_block"))).dropsNothing()), false);

    public static final Block OIL_MAKING_BLOCK = registerBlock("oil_making_block",
            new OilMakingBlock(
                    AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(GofrMod.MOD_ID, "oil_making_block")))),
            true);

    private static Block registerBlock(String name, Block block, boolean registerItem) {
        if (registerItem){
            Item item = Registry.register(Registries.ITEM, Identifier.of(GofrMod.MOD_ID, name), new BlockItem(block,
                    new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GofrMod.MOD_ID, name)))));
        }
        return Registry.register(Registries.BLOCK, Identifier.of(GofrMod.MOD_ID, name), block);
    }

    public static Block register(String name, Function<Block.Settings, Block> itemFactory, Block.Settings settings) {
        RegistryKey<Block> itemKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(GofrMod.MOD_ID, name));

        Block block = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.BLOCK, itemKey, block);

        return block;
    }

    public static void registerModBlocks() {
        GofrMod.LOGGER.info("Registering Mod Blocks for " + GofrMod.MOD_ID);
    }
}
