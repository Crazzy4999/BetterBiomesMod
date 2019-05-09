package almos.betterbiomesmod;

import almos.betterbiomesmod.lists.BlockList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class BBMItemGroup extends ItemGroup
{
	
	public BBMItemGroup()
	{
		super("bbm");
	}

	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(Item.BLOCK_TO_ITEM.get(BlockList.darkpine_log));
	}
	
}
