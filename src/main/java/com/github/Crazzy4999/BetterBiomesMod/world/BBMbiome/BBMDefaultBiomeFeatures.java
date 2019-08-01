package com.github.Crazzy4999.BetterBiomesMod.world.BBMbiome;

import com.github.Crazzy4999.BetterBiomesMod.lists.BetterBiomeBlocks;
import com.github.Crazzy4999.BetterBiomesMod.world.gen.feature.BBMFeature;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidWithNoiseConfig;

public class BBMDefaultBiomeFeatures
	{
	   public static void addExtraJadeOre(Biome biomeIn)
	   {
		      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BetterBiomeBlocks.jade_ore.getDefaultState(), 6), Placement.COUNT_RANGE, new CountRangeConfig(10, 15, 15, 70)));
	   }

	   public static void addBambooJungleVegetation(Biome biomeIn)
	   {
	      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(BBMFeature.BBMBAMBOO, new ProbabilityConfig(0.05F), Placement.TOP_SOLID_HEIGHTMAP_NOISE_BIASED, new TopSolidWithNoiseConfig(160, 80.0D, 0.3D, Heightmap.Type.WORLD_SURFACE_WG)));
	      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(new Feature[]{Feature.FANCY_TREE, Feature.MEGA_JUNGLE_TREE}, new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG}, new float[]{0.5F, 0.2F}, Feature.JUNGLE_GRASS, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(30, 0.1F, 1)));
	   }
	}