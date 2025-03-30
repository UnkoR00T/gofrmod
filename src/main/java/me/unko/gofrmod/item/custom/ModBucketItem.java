package me.unko.gofrmod.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ModBucketItem extends Item {

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        return new ItemStack(Items.BUCKET);
    }

    public ModBucketItem(Settings settings) {
        super(settings);
    }
}
