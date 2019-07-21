package com.github.Crazzy4999.BetterBiomesMod;

import com.github.Crazzy4999.BetterBiomesMod.lists.BetterBiomeItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class BBMItemGroup3 extends ItemGroup
{
	
	public BBMItemGroup3()
	{
		super("bbmt");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(BetterBiomeItems.jade_axe);
	}

}
