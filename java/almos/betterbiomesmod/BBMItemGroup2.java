package almos.betterbiomesmod;

import almos.betterbiomesmod.lists.ItemList;
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
		return new ItemStack(ItemList.jade_gem);
	}

}
