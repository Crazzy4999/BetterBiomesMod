package com.github.Crazzy4999.BetterBiomesMod.world.gen.feature;

import java.util.function.Function;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;

@SuppressWarnings("rawtypes")
public abstract class BBMFeature extends Feature
{

	@SuppressWarnings("unchecked")
	public BBMFeature(Function<?, ?> configFactoryIn) {
		super(configFactoryIn);
	}

	public static final Feature<ProbabilityConfig> BBMBAMBOO = register("bbmbamboo", new BBMBambooFeature(ProbabilityConfig::deserialize));

	   @SuppressWarnings({ "unchecked", "deprecation" })
	private static <C extends IFeatureConfig, F extends Feature<C>> F register(String key, BBMBambooFeature bbmBambooFeature) {
		      return (F)(Registry.<Feature<?>>register(Registry.FEATURE, key, bbmBambooFeature));
	}
	}
