package me.unko.gofrmod.block.custom.entities;

import me.unko.gofrmod.GofrMod;
import me.unko.gofrmod.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<OilMakingEntity> OIL_MAKING_BLOCK_ENTITY =
            register("oil_making", OilMakingEntity::new, ModBlocks.OIL_MAKING_BLOCK);
    public static final BlockEntityType<OilRafineryEntity> OIL_RAFINERY_BLOCK_ENTITY =
            register("oil_rafinery", OilRafineryEntity::new, ModBlocks.OIL_RAFINERY_BLOCK);

    private static <T extends BlockEntity> BlockEntityType<T> register(
            String name,
            FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,
            Block... blocks
    ) {
        Identifier id = Identifier.of(GofrMod.MOD_ID, name);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }

    public static void registerModBlockEntities() {
        GofrMod.LOGGER.info("Initializing ModBlockEntities");
    }
}
