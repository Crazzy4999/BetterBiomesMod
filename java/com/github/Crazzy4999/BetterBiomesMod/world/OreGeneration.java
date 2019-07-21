package com.github.Crazzy4999.BetterBiomesMod.world;

import com.github.Crazzy4999.BetterBiomesMod.config.OregenConfig;
import com.github.Crazzy4999.BetterBiomesMod.lists.BetterBiomeBlocks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration
{
	public static void setupOreGeneration()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			biome.addFeature(Decoration.UNDERGROUND_ORES, new ConfiguredFeature<OreFeatureConfig>(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BetterBiomeBlocks.jade_ore.getDefaultState(), OregenConfig.betterbiome_chance.get())));
		}
	}
}
