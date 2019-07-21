package com.github.Crazzy4999.BetterBiomesMod;

import com.github.Crazzy4999.BetterBiomesMod.lists.BetterBiomeBlocks;
import com.github.Crazzy4999.BetterBiomesMod.lists.BetterBiomeItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BBMItemGroup
{
	public static final ItemGroup BBMItemGroup = new ItemGroup("bbm")
	{
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon()
		{
			return new ItemStack(BetterBiomeBlocks.darkpine_log);
		}
	};
	
	public static final ItemGroup BBMItemGroup1 = new ItemGroup("bbmd")
	{
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon()
		{
			return new ItemStack(BetterBiomeBlocks.cherry_leaves);
		}
	};
	
	public static final ItemGroup BBMItemGroup2 = new ItemGroup("bbmi")
	{
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon()
		{
			return new ItemStack(BetterBiomeItems.jade_gem);
		}
	};
	
	public static final ItemGroup BBMItemGroup3 = new ItemGroup("bbmt")
	{
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon()
		{
			return new ItemStack(BetterBiomeItems.jade_axe);
		}
	};
}
