package me.unko.gofrmod.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class Consumables {
    public static final ConsumableComponent JOINT_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            // The duration is in ticks, 20 ticks = 1 second
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HASTE, 20 * 60 * 2, 2), 0.4f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 60 * 2, 0), 0.3f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20 * 60, 2), 0.5f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 10 * 60, 2), 0.6f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5 * 60, 2), 0.9f))
            .build();
    public static final ConsumableComponent METH_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            // The duration is in ticks, 20 ticks = 1 second
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HASTE, 20 * 60 * 2, 2), 0.4f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 60 * 2, 1), 0.3f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 60, 2), 0.2f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 20 * 30, 2), 0.4f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 30, 2), 0.5f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20 * 20, 2), 0.3f))
            .build();

    public static final ConsumableComponent HEROIN_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            // The duration is in ticks, 20 ticks = 1 second
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.LUCK, 20 * 60 * 2, 2), 0.4f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20 * 60 * 2, 1), 0.3f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 60, 0), 0.2f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 20 * 30, 2), 0.4f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 30, 2), 0.5f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20 * 20, 0), 0.3f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 20, 2), 0.3f))
            .build();

    public static final ConsumableComponent POWERMIX_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            // The duration is in ticks, 20 ticks = 1 second
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.LUCK, 20 * 60 * 2, 2), 0.4f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HASTE, 20 * 60 * 2, 2), 0.4f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20 * 60 * 2, 1), 0.3f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 60, 0), 0.3f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 20 * 60, 2), 0.4f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 15, 2), 0.5f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20 * 20, 0), 0.3f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 20, 2), 0.4f))
            .build();
    public static final FoodComponent DRUG_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .build();
}
