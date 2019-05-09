package almos.betterbiomesmod;

import almos.betterbiomesmod.lists.ItemList;
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
		return new ItemStack(ItemList.jade_axe);
	}

}
