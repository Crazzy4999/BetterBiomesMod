package com.github.Crazzy4999.BetterBiomesMod.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig
{
	public static ForgeConfigSpec.IntValue betterbiome_chance;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
	{
		server.comment("Oregen Config");
		
		betterbiome_chance = server
				.comment("Maximum number of ore veins of the jade ore that can spawn in a chunk.")
				.defineInRange("oregen.betterbiome_chance", 100, 1, 100000);
	}
}
