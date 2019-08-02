package com.github.Crazzy4999.BetterBiomesMod.item;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class BBMFoods
	{
		public static final Food RED_HABANERO = (new Food.Builder()).hunger(2).saturation(0.8F).effect(new EffectInstance(Effects.STRENGTH, 600, 0), 0.4F).build();
		public static final Food ORANGE_HABANERO = (new Food.Builder()).hunger(2).saturation(0.8F).effect(new EffectInstance(Effects.FIRE_RESISTANCE, 600, 0), 0.8F).build();
	}
