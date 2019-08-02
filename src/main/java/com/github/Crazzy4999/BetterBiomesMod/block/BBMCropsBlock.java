package com.github.Crazzy4999.BetterBiomesMod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class BBMCropsBlock extends CropsBlock
{
	   public BBMCropsBlock(Block.Properties builder)
	   {
	   		super(builder);
	   }
	   protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos)
	   {
		      return state.getBlock() == Blocks.GRASS_BLOCK;
	   }
}
	   