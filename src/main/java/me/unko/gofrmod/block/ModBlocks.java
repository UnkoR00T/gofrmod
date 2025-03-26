package me.unko.gofrmod.block;

import me.unko.gofrmod.GofrMod;
import me.unko.gofrmod.block.custom.WeedCropBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.fluid.FlowableFluid;
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

    public static final Block WEED_CROP_BLOCK = register("weed_crop", WeedCropBlock::new, AbstractBlock.Settings.create().noCollision().breakInstantly().ticksRandomly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY));
    public static FlowableFluid STILL_OIL;
    public static FlowableFluid FLOWING_OIL;
    public static Item OIL_BUCKET;

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
