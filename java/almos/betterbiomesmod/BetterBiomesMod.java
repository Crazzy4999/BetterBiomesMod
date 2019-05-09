package almos.betterbiomesmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import almos.betterbiomesmod.items.ItemCustomAxe;
import almos.betterbiomesmod.items.ItemCustomPickaxe;
import almos.betterbiomesmod.lists.BlockList;
import almos.betterbiomesmod.lists.ItemList;
import almos.betterbiomesmod.lists.ToolMaterialList;
import almos.betterbiomesmod.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("betterbiomesmodbycrazzy")
public class BetterBiomesMod
{
	public static BetterBiomesMod instance; 
	public static final String modid = "betterbiomesmodbycrazzy";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public static final ItemGroup bbm = new BBMItemGroup();
	public static final ItemGroup bbmd = new BBMItemGroup1();
	public static final ItemGroup bbmi = new BBMItemGroup2();
	public static final ItemGroup bbmt = new BBMItemGroup3();
	
	public BetterBiomesMod()
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		OreGeneration.setupOreGeneration();
		logger.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		logger.info("clientRegistries method registered.");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegsitryEvents
	{
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
				ItemList.jade_gem = new Item(new Item.Properties().group(bbmi)).setRegistryName(location("jade_gem")),
				ItemList.jade_gemshards = new Item(new Item.Properties().group(bbmi)).setRegistryName(location("jade_gemshards")),
				ItemList.jade_gempowder = new Item(new Item.Properties().group(bbmi)).setRegistryName(location("jade_gempowder")),
				ItemList.mortar = new Item(new Item.Properties().group(bbmt)).setRegistryName(location("mortar")),
				ItemList.pestle = new Item(new Item.Properties().group(bbmt)).setRegistryName(location("pestle")),
				ItemList.gemstonemortar_andpestle = new Item(new Item.Properties().group(bbmt)).setRegistryName(location("gemstonemortar_andpestle")),
				ItemList.turquoise_gem = new Item(new Item.Properties().group(bbmi)).setRegistryName(location("turquoise_gem")),
				
				ItemList.jade_block = new ItemBlock(BlockList.jade_block, new Item.Properties().group(bbm)).setRegistryName(BlockList.jade_block.getRegistryName()),
				ItemList.turquoise_block = new ItemBlock(BlockList.turquoise_block, new Item.Properties().group(bbm)).setRegistryName(BlockList.turquoise_block.getRegistryName()),
				
				ItemList.cherry_log = new ItemBlock(BlockList.cherry_log, new Item.Properties().group(bbm)).setRegistryName(BlockList.cherry_log.getRegistryName()),
				ItemList.cherry_wood = new ItemBlock(BlockList.cherry_wood, new Item.Properties().group(bbm)).setRegistryName(BlockList.cherry_wood.getRegistryName()),
				ItemList.cherry_leaves_blossom = new ItemBlock(BlockList.cherry_leaves_blossom, new Item.Properties().group(bbmd)).setRegistryName(BlockList.cherry_leaves_blossom.getRegistryName()),
				ItemList.cherry_leaves = new ItemBlock(BlockList.cherry_leaves, new Item.Properties().group(bbmd)).setRegistryName(BlockList.cherry_leaves.getRegistryName()),
				
				ItemList.teatree_log = new ItemBlock(BlockList.teatree_log, new Item.Properties().group(bbm)).setRegistryName(BlockList.teatree_log.getRegistryName()),
				ItemList.teatree_wood = new ItemBlock(BlockList.teatree_wood, new Item.Properties().group(bbm)).setRegistryName(BlockList.teatree_wood.getRegistryName()),
				ItemList.teatree_leaves = new ItemBlock(BlockList.teatree_leaves, new Item.Properties().group(bbmd)).setRegistryName(BlockList.teatree_leaves.getRegistryName()),
				
				ItemList.darkpine_log = new ItemBlock(BlockList.darkpine_log, new Item.Properties().group(bbm)).setRegistryName(BlockList.darkpine_log.getRegistryName()),
				ItemList.darkpine_wood = new ItemBlock(BlockList.darkpine_wood, new Item.Properties().group(bbm)).setRegistryName(BlockList.darkpine_wood.getRegistryName()),
				ItemList.darkpine_leaves = new ItemBlock(BlockList.darkpine_leaves, new Item.Properties().group(bbmd)).setRegistryName(BlockList.darkpine_leaves.getRegistryName()),
				ItemList.darkpine_planks = new ItemBlock(BlockList.darkpine_planks, new Item.Properties().group(bbm)).setRegistryName(BlockList.darkpine_planks.getRegistryName()),
				ItemList.darkpine_slab = new ItemBlock(BlockList.darkpine_slab, new Item.Properties().group(bbm)).setRegistryName(BlockList.darkpine_slab.getRegistryName()),
				ItemList.stripped_darkpine_log = new ItemBlock(BlockList.stripped_darkpine_log, new Item.Properties().group(bbm)).setRegistryName(BlockList.stripped_darkpine_log.getRegistryName()),
				ItemList.stripped_darkpine_wood = new ItemBlock(BlockList.stripped_darkpine_wood, new Item.Properties().group(bbm)).setRegistryName(BlockList.stripped_darkpine_wood.getRegistryName()),
				ItemList.darkpine_fence = new ItemBlock(BlockList.darkpine_fence, new Item.Properties().group(bbmd)).setRegistryName(BlockList.darkpine_fence.getRegistryName()),
				ItemList.darkpine_fence_gate = new ItemBlock(BlockList.darkpine_fence_gate, new Item.Properties().group(bbmd)).setRegistryName(BlockList.darkpine_fence_gate.getRegistryName()),
				ItemList.jade_ore = new ItemBlock(BlockList.jade_ore, new Item.Properties().group(bbm)).setRegistryName(BlockList.jade_ore.getRegistryName()),
				
				ItemList.jade_axe = new ItemCustomAxe(ToolMaterialList.jade, 4.0f, -3.5f, new Item.Properties().group(bbmt)).setRegistryName(location("jade_axe")),
				ItemList.jade_pickaxe = new ItemCustomPickaxe(ToolMaterialList.jade, -6, -2.4f, new Item.Properties().group(bbmt)).setRegistryName(location("jade_pickaxe")),
				ItemList.jade_sword = new ItemSword(ToolMaterialList.jade, 0, -1.5f, new Item.Properties().group(bbmt)).setRegistryName(location("jade_sword")),
				ItemList.jade_shovel = new ItemSpade(ToolMaterialList.jade, -8.0f, -2.6f, new Item.Properties().group(bbmt)).setRegistryName(location("jade_shovel")),
				ItemList.jade_hoe = new ItemHoe(ToolMaterialList.jade, -3.0f, new Item.Properties().group(bbmt)).setRegistryName(location("jade_hoe"))
				
			);
			
			logger.info("Items registered.");
		}
		   
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
				BlockList.jade_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(8.0f, 14.0f).sound(SoundType.METAL)).setRegistryName(location("jade_block")),
				BlockList.turquoise_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(7.0f, 14.0f).sound(SoundType.METAL)).setRegistryName(location("turquoise_block")),
				
				BlockList.cherry_log = new BlockLog(MaterialColor.ADOBE,Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.WOOD)).setRegistryName(location("cherry_log")),
				BlockList.cherry_wood = new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.WOOD)).setRegistryName(location("cherry_wood")),
				BlockList.cherry_leaves_blossom = new BlockLeaves(Block.Properties.create(Material.LEAVES).hardnessAndResistance(2.0f).needsRandomTick().sound(SoundType.PLANT)).setRegistryName(location("cherry_leaves_blossom")),
				BlockList.cherry_leaves = new BlockLeaves(Block.Properties.create(Material.LEAVES).hardnessAndResistance(2.0f).needsRandomTick().sound(SoundType.PLANT)).setRegistryName(location("cherry_leaves")),
				
				BlockList.teatree_log = new BlockLog(MaterialColor.ADOBE,Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.WOOD)).setRegistryName(location("teatree_log")),
				BlockList.teatree_wood = new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.WOOD)).setRegistryName(location("teatree_wood")),
				BlockList.teatree_leaves = new BlockLeaves(Block.Properties.create(Material.LEAVES).hardnessAndResistance(2.0f).needsRandomTick().sound(SoundType.PLANT)).setRegistryName(location("teatree_leaves")),
				
				BlockList.darkpine_log = new BlockLog(MaterialColor.OBSIDIAN,Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.WOOD)).setRegistryName(location("darkpine_log")),
				BlockList.darkpine_wood = new BlockRotatedPillar(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.WOOD)).setRegistryName(location("darkpine_wood")),
				BlockList.darkpine_leaves = new BlockLeaves(Block.Properties.create(Material.LEAVES).hardnessAndResistance(2.0f).needsRandomTick().sound(SoundType.PLANT)).setRegistryName(location("darkpine_leaves")),
				BlockList.darkpine_planks = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f).sound(SoundType.WOOD)).setRegistryName(location("darkpine_planks")),
				BlockList.stripped_darkpine_log = new BlockLog(MaterialColor.OBSIDIAN,Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0f).sound(SoundType.WOOD)).setRegistryName(location("stripped_darkpine_log")),
				BlockList.stripped_darkpine_wood = new BlockRotatedPillar(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f).sound(SoundType.WOOD)).setRegistryName(location("stripped_darkpine_wood")),
				BlockList.darkpine_fence = new BlockFence(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)).setRegistryName(location("darkpine_fence")),
				BlockList.darkpine_fence_gate = new BlockFenceGate(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)).setRegistryName(location("darkpine_fence_gate")),
				BlockList.darkpine_slab = new BlockSlab(Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.WOOD)).setRegistryName(location("darkpine_slab")),
				BlockList.jade_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 8.0f).sound(SoundType.STONE)).setRegistryName(location("jade_ore"))
				
				);
			
			logger.info("Blocks registered.");
		}

		private static ResourceLocation location(String name)
		
		{
			return new ResourceLocation(modid, name);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
