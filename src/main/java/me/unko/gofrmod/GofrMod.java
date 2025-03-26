package me.unko.gofrmod;

import me.unko.gofrmod.block.ModBlocks;
import me.unko.gofrmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.client.render.RenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GofrMod implements ModInitializer {
	public static final String MOD_ID = "gofrmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing GofrMod!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		CompostingChanceRegistry.INSTANCE.add(ModItems.WEED, 0.5f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.DRIED_WEED, 0.5f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.WEED_SEEDS, 0.3f);


	}

}