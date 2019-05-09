package almos.betterbiomesmod;

import almos.betterbiomesmod.lists.BlockList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class BBMItemGroup1 extends ItemGroup
{
	
	public BBMItemGroup1()
	{
		super("bbmd");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(Item.BLOCK_TO_ITEM.get(BlockList.cherry_leaves));
	}

}
