package com.github.Crazzy4999.BetterBiomesMod;

import com.github.Crazzy4999.BetterBiomesMod.lists.BetterBiomeItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class BBMItemGroup2 extends ItemGroup
{
	
	public BBMItemGroup2()
	{
		super("bbmi");
	}

	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(BetterBiomeItems.jade_gem);
	}

}
