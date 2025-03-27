package me.unko.gofrmod.item;

import me.unko.gofrmod.GofrMod;
import me.unko.gofrmod.block.ModBlocks;
import me.unko.gofrmod.fluid.ModFluids;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.*;

import java.util.function.Function;

public class ModItems {
    public static final Item WEED = register("weed", Item::new, new Item.Settings());
    public static final Item DRIED_WEED = register("dried_weed", Item::new, new Item.Settings());
    public static final Item BLEACH_BUCKET = register("bleach_bucket", Item::new, new Item.Settings());
    public static final Item METHYLAMINE_BUCKET = register("methylamine_bucket", Item::new, new Item.Settings());
    public static final Item JOINT = register("joint", Item::new, new Item.Settings().food(Consumables.JOINT_FOOD_COMPONENT, Consumables.JOINT_CONSUMABLE_COMPONENT));

    public static final Item WEED_SEEDS = registerItem("weed_seeds", new BlockItem(ModBlocks.WEED_CROP_BLOCK, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GofrMod.MOD_ID,"weed_seeds")))));
    public static final Item OIL_BUCKET = registerItem("oil_bucket", new BucketItem(ModFluids.OIL_STILL, new BucketItem.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GofrMod.MOD_ID,"oil_bucket")
            )).maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(GofrMod.MOD_ID, name), item);
    }
    
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GofrMod.MOD_ID, name));

        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void registerModItems() {
        GofrMod.LOGGER.info("Registering Mod Items for " + GofrMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(WEED);
            entries.add(DRIED_WEED);
            entries.add(JOINT);
            entries.add(WEED_SEEDS);
            entries.add(OIL_BUCKET);
            entries.add(ModBlocks.OIL_MAKING_BLOCK);
        });
    }
}