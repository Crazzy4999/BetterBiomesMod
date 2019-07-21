package com.github.Crazzy4999.BetterBiomesMod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.Crazzy4999.BetterBiomesMod.config.ModConfig;
import com.github.Crazzy4999.BetterBiomesMod.items.CustomAxeItem;
import com.github.Crazzy4999.BetterBiomesMod.items.CustomPickaxeItem;
import com.github.Crazzy4999.BetterBiomesMod.lists.BetterBiomeBlocks;
import com.github.Crazzy4999.BetterBiomesMod.lists.BetterBiomeItems;
import com.github.Crazzy4999.BetterBiomesMod.lists.BetterBiomeToolMaterials;
import com.github.Crazzy4999.BetterBiomesMod.lists.trees.DarkPineTree;
import com.github.Crazzy4999.BetterBiomesMod.world.OreGeneration;

import net.minecraft.block.trees.SpruceTree;
import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("betterbiomesmodbycrazzy")
public class BetterBiomesMod
{
	public static BetterBiomesMod instance; 
	public static final String MODID = "betterbiomesmodbycrazzy";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public static final ItemGroup BBM = new BBMItemGroup();
	public static final ItemGroup BBMD = new BBMItemGroup1();
	public static final ItemGroup BBMI = new BBMItemGroup2();
	public static final ItemGroup BBMT = new BBMItemGroup3();
	
	public BetterBiomesMod()
	{
		instance = this;
		
		ModLoadingContext.get().registerConfig(Type.SERVER, ModConfig.SERVER, "betterbiomesmodbycrazzy-server.toml");
		ModLoadingContext.get().registerConfig(Type.CLIENT, ModConfig.CLIENT, "betterbiomesmodbycrazzy-client.toml");
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		ModConfig.loadConfig(ModConfig.SERVER, FMLPaths.CONFIGDIR.get().resolve("betterbiomesmodbycrazzy-server.toml").toString());
		ModConfig.loadConfig(ModConfig.CLIENT, FMLPaths.CONFIGDIR.get().resolve("betterbiomesmodbycrazzy-client.toml").toString());
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		OreGeneration.setupOreGeneration();
		LOGGER.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		LOGGER.info("clientRegistries method registered.");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegsitryEvents
	{
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
				BetterBiomeItems.jade_gem = new Item(new Item.Properties().group(BBMI)).setRegistryName(location("jade_gem")),
				BetterBiomeItems.jade_gemshards = new Item(new Item.Properties().group(BBMI)).setRegistryName(location("jade_gemshards")),
				BetterBiomeItems.jade_gempowder = new Item(new Item.Properties().group(BBMI)).setRegistryName(location("jade_gempowder")),
				BetterBiomeItems.mortar = new Item(new Item.Properties().group(BBMT)).setRegistryName(location("mortar")),
				BetterBiomeItems.pestle = new Item(new Item.Properties().group(BBMT)).setRegistryName(location("pestle")),
				BetterBiomeItems.gemstonemortar_andpestle = new Item(new Item.Properties().group(BBMT)).setRegistryName(location("gemstonemortar_andpestle")),
				BetterBiomeItems.turquoise_gem = new Item(new Item.Properties().group(BBMI)).setRegistryName(location("turquoise_gem")),
				BetterBiomeItems.copper_ingot = new Item(new Item.Properties().group(BBMI)).setRegistryName(location("copper_ingot")),
				
				BetterBiomeItems.jade_block = new BlockItem(BetterBiomeBlocks.jade_block, new Item.Properties().group(BBM)).setRegistryName(BetterBiomeBlocks.jade_block.getRegistryName()),
				BetterBiomeItems.turquoise_block = new BlockItem(BetterBiomeBlocks.turquoise_block, new Item.Properties().group(BBM)).setRegistryName(BetterBiomeBlocks.turquoise_block.getRegistryName()),
				
				BetterBiomeItems.cherry_log = new BlockItem(BetterBiomeBlocks.cherry_log, new Item.Properties().group(BBM)).setRegistryName(BetterBiomeBlocks.cherry_log.getRegistryName()),
				BetterBiomeItems.cherry_wood = new BlockItem(BetterBiomeBlocks.cherry_wood, new Item.Properties().group(BBM)).setRegistryName(BetterBiomeBlocks.cherry_wood.getRegistryName()),
				BetterBiomeItems.cherry_leaves_blossom = new BlockItem(BetterBiomeBlocks.cherry_leaves_blossom, new Item.Properties().group(BBMD)).setRegistryName(BetterBiomeBlocks.cherry_leaves_blossom.getRegistryName()),
				BetterBiomeItems.cherry_leaves = new BlockItem(BetterBiomeBlocks.cherry_leaves, new Item.Properties().group(BBMD)).setRegistryName(BetterBiomeBlocks.cherry_leaves.getRegistryName()),
				
				BetterBiomeItems.teatree_log = new BlockItem(BetterBiomeBlocks.teatree_log, new Item.Properties().group(BBM)).setRegistryName(BetterBiomeBlocks.teatree_log.getRegistryName()),
				BetterBiomeItems.teatree_wood = new BlockItem(BetterBiomeBlocks.teatree_wood, new Item.Properties().group(BBM)).setRegistryName(BetterBiomeBlocks.teatree_wood.getRegistryName()),
				BetterBiomeItems.teatree_leaves = new BlockItem(BetterBiomeBlocks.teatree_leaves, new Item.Properties().group(BBMD)).setRegistryName(BetterBiomeBlocks.teatree_leaves.getRegistryName()),
				
				BetterBiomeItems.darkpine_log = new BlockItem(BetterBiomeBlocks.darkpine_log, new Item.Properties().group(BBM)).setRegistryName(BetterBiomeBlocks.darkpine_log.getRegistryName()),
				BetterBiomeItems.darkpine_wood = new BlockItem(BetterBiomeBlocks.darkpine_wood, new Item.Properties().group(BBM)).setRegistryName(BetterBiomeBlocks.darkpine_wood.getRegistryName()),
				BetterBiomeItems.darkpine_leaves = new BlockItem(BetterBiomeBlocks.darkpine_leaves, new Item.Properties().group(BBMD)).setRegistryName(BetterBiomeBlocks.darkpine_leaves.getRegistryName()),
				BetterBiomeItems.darkpine_sapling = new BlockItem(BetterBiomeBlocks.darkpine_sapling, new Item.Properties().group(BBMD)).setRegistryName(BetterBiomeBlocks.darkpine_sapling.getRegistryName()),
				BetterBiomeItems.darkpine_planks = new BlockItem(BetterBiomeBlocks.darkpine_planks, new Item.Properties().group(BBM)).setRegistryName(BetterBiomeBlocks.darkpine_planks.getRegistryName()),
				BetterBiomeItems.darkpine_slab = new BlockItem(BetterBiomeBlocks.darkpine_slab, new Item.Properties().group(BBM)).setRegistryName(BetterBiomeBlocks.darkpine_slab.getRegistryName()),
				BetterBiomeItems.stripped_darkpine_log = new BlockItem(BetterBiomeBlocks.stripped_darkpine_log, new Item.Properties().group(BBM)).setRegistryName(BetterBiomeBlocks.stripped_darkpine_log.getRegistryName()),
				BetterBiomeItems.stripped_darkpine_wood = new BlockItem(BetterBiomeBlocks.stripped_darkpine_wood, new Item.Properties().group(BBM)).setRegistryName(BetterBiomeBlocks.stripped_darkpine_wood.getRegistryName()),
				BetterBiomeItems.darkpine_fence = new BlockItem(BetterBiomeBlocks.darkpine_fence, new Item.Properties().group(BBMD)).setRegistryName(BetterBiomeBlocks.darkpine_fence.getRegistryName()),
				BetterBiomeItems.darkpine_fence_gate = new BlockItem(BetterBiomeBlocks.darkpine_fence_gate, new Item.Properties().group(BBMD)).setRegistryName(BetterBiomeBlocks.darkpine_fence_gate.getRegistryName()),
				
				BetterBiomeItems.datepalm_log = new BlockItem(BetterBiomeBlocks.datepalm_log, new Item.Properties().group(BBM)).setRegistryName(BetterBiomeBlocks.datepalm_log.getRegistryName()),
				BetterBiomeItems.datepalm_wood = new BlockItem(BetterBiomeBlocks.datepalm_wood, new Item.Properties().group(BBM)).setRegistryName(BetterBiomeBlocks.datepalm_wood.getRegistryName()),
				BetterBiomeItems.datepalm_leaves = new BlockItem(BetterBiomeBlocks.datepalm_leaves, new Item.Properties().group(BBMD)).setRegistryName(BetterBiomeBlocks.datepalm_leaves.getRegistryName()),
				BetterBiomeItems.datepalm_fruit_leaves = new BlockItem(BetterBiomeBlocks.datepalm_fruit_leaves, new Item.Properties().group(BBMD)).setRegistryName(BetterBiomeBlocks.datepalm_fruit_leaves.getRegistryName()),
						
				BetterBiomeItems.jade_ore = new BlockItem(BetterBiomeBlocks.jade_ore, new Item.Properties().group(BBM)).setRegistryName(BetterBiomeBlocks.jade_ore.getRegistryName()),
				
				BetterBiomeItems.jade_axe = new CustomAxeItem(BetterBiomeToolMaterials.jade, 4.0f, -3.5f, new Item.Properties().group(BBMT)).setRegistryName(location("jade_axe")),
				BetterBiomeItems.jade_pickaxe = new CustomPickaxeItem(BetterBiomeToolMaterials.jade, -6, -2.4f, new Item.Properties().group(BBMT)).setRegistryName(location("jade_pickaxe")),
				BetterBiomeItems.jade_sword = new SwordItem(BetterBiomeToolMaterials.jade, 0, -1.5f, new Item.Properties().group(BBMT)).setRegistryName(location("jade_sword")),
				BetterBiomeItems.jade_shovel = new ShovelItem(BetterBiomeToolMaterials.jade, -8.0f, -2.6f, new Item.Properties().group(BBMT)).setRegistryName(location("jade_shovel")),
				BetterBiomeItems.jade_hoe = new HoeItem(BetterBiomeToolMaterials.jade, -3.0f, new Item.Properties().group(BBMT)).setRegistryName(location("jade_hoe")),
				BetterBiomeItems.poppy_cutter_knife = new SwordItem(BetterBiomeToolMaterials.copper, 0, -1.5f, new Item.Properties().group(BBMT)).setRegistryName(location("poppy_cutter_knife")),
				
				BetterBiomeItems.heroin_poppy = new BlockItem(BetterBiomeBlocks.heroin_poppy, new Item.Properties().group(BBMD)).setRegistryName(location("heroin_poppy")),
				BetterBiomeItems.bleeding_heroin_poppy = new Item(new Item.Properties().group(BBMI)).setRegistryName(location("bleeding_heroin_poppy"))

			);
			
			LOGGER.info("Items registered.");
		}
		   
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
				BetterBiomeBlocks.jade_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(8.0f, 14.0f).sound(SoundType.METAL)).setRegistryName(location("jade_block")),
				BetterBiomeBlocks.turquoise_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(7.0f, 14.0f).sound(SoundType.METAL)).setRegistryName(location("turquoise_block")),
				
				BetterBiomeBlocks.cherry_log = new LogBlock(MaterialColor.ADOBE,Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.WOOD)).setRegistryName(location("cherry_log")),
				BetterBiomeBlocks.cherry_wood = new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.WOOD)).setRegistryName(location("cherry_wood")),
				BetterBiomeBlocks.cherry_leaves_blossom = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(2.0f).tickRandomly().sound(SoundType.PLANT)).setRegistryName(location("cherry_leaves_blossom")),
				BetterBiomeBlocks.cherry_leaves = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(2.0f).tickRandomly().sound(SoundType.PLANT)).setRegistryName(location("cherry_leaves")),
				
				BetterBiomeBlocks.teatree_log = new LogBlock(MaterialColor.ADOBE,Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.WOOD)).setRegistryName(location("teatree_log")),
				BetterBiomeBlocks.teatree_wood = new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.WOOD)).setRegistryName(location("teatree_wood")),
				BetterBiomeBlocks.teatree_leaves = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(2.0f).tickRandomly().sound(SoundType.PLANT)).setRegistryName(location("teatree_leaves")),
				
				BetterBiomeBlocks.darkpine_log = new LogBlock(MaterialColor.OBSIDIAN,Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.WOOD)).setRegistryName(location("darkpine_log")),
				BetterBiomeBlocks.darkpine_wood = new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.WOOD)).setRegistryName(location("darkpine_wood")),
				BetterBiomeBlocks.darkpine_leaves = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(2.0f).tickRandomly().sound(SoundType.PLANT)).setRegistryName(location("darkpine_leaves")),
				BetterBiomeBlocks.darkpine_sapling = new SaplingBlock(new DarkPineTree(), Block.Properties.create(Material.LEAVES).hardnessAndResistance(0).tickRandomly().sound(SoundType.PLANT)).setRegistryName(location("darkpine_sapling")),
				BetterBiomeBlocks.darkpine_planks = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f).sound(SoundType.WOOD)).setRegistryName(location("darkpine_planks")),
				BetterBiomeBlocks.stripped_darkpine_log = new LogBlock(MaterialColor.OBSIDIAN,Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0f).sound(SoundType.WOOD)).setRegistryName(location("stripped_darkpine_log")),
				BetterBiomeBlocks.stripped_darkpine_wood = new RotatedPillarBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f).sound(SoundType.WOOD)).setRegistryName(location("stripped_darkpine_wood")),
				BetterBiomeBlocks.darkpine_fence = new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)).setRegistryName(location("darkpine_fence")),
				BetterBiomeBlocks.darkpine_fence_gate = new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)).setRegistryName(location("darkpine_fence_gate")),
				BetterBiomeBlocks.darkpine_slab = new SlabBlock(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)).setRegistryName(location("darkpine_slab")),
				
				BetterBiomeBlocks.datepalm_log = new LogBlock(MaterialColor.ADOBE,Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.WOOD)).setRegistryName(location("datepalm_log")),
				BetterBiomeBlocks.datepalm_wood = new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.WOOD)).setRegistryName(location("datepalm_wood")),
				BetterBiomeBlocks.datepalm_leaves = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(2.0f).tickRandomly().sound(SoundType.PLANT)).setRegistryName(location("datepalm_leaves")),
				BetterBiomeBlocks.datepalm_fruit_leaves = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(2.0f).tickRandomly().sound(SoundType.PLANT)).setRegistryName(location("datepalm_fruit_leaves")),
						
				BetterBiomeBlocks.jade_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 8.0f).sound(SoundType.STONE)).setRegistryName(location("jade_ore")),
				
				BetterBiomeBlocks.heroin_poppy = new FlowerBlock(Effects.LEVITATION, 3, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0f, 0.0f).sound(SoundType.PLANT)).setRegistryName(location("heroin_poppy"))
				
				);
			
			LOGGER.info("Blocks registered.");
		}
		
		@SubscribeEvent
		public static void hpandpck(final ItemCraftedEvent event)
		{
			if (event.getCrafting().getItem() == BetterBiomeItems.heroin_poppy)
			{
				event.getPlayer().addItemStackToInventory(new ItemStack(BetterBiomeItems.poppy_cutter_knife, 1));
			}
		}

		private static ResourceLocation location(String name)
		
		{
			return new ResourceLocation(MODID, name);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
