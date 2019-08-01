package com.github.Crazzy4999.BetterBiomesMod.world.BBMbiome;

import com.github.Crazzy4999.BetterBiomesMod.lists.BetterBiomeBiomes;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.registries.ForgeRegistries;

public class BBMBiomes
	{
	
    public static WorldType Worldtype = WorldType.DEFAULT;
	public static void init()
    {
		registerBiomes();
    }
	private static Biome initBiome(Biome biome, String name, BiomeType biometype, Type type, Type type1, Type type2, String name1)
    {
        biome.setRegistryName(name);
        ForgeRegistries.BIOMES.register(biome);
        BiomeDictionary.addTypes(biome, type);
        BiomeManager.addBiome(biometype, new BiomeManager.BiomeEntry(biome, 10));
        BiomeManager.addSpawnBiome(biome);
        System.out.println(name1 + "name");
        return biome;
    }
	 public static void registerBiomes()
	    {
	        initBiome(BetterBiomeBiomes.FERTILE_JUNGLE_HILLS, "fertile_jungle_hills", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.BEACH, "FJH registered");
	    }
	}


















