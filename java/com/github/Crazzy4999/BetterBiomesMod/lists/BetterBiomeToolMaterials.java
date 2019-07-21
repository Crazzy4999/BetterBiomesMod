package com.github.Crazzy4999.BetterBiomesMod.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum BetterBiomeToolMaterials implements IItemTier
{
	jade(12.0f, 10.0f, 2725, 3, 25, BetterBiomeItems.jade_gem),
	copper(4.0f, 5.0f, 225, 2, 12, BetterBiomeItems.copper_ingot);
	
	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	
	private BetterBiomeToolMaterials(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial)
	{
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getMaxUses()
	{
		return this.durability;
	}

	@Override
	public float getEfficiency()
	{
		return this.efficiency;
	}

	@Override
	public float getAttackDamage()
	{
		return this.attackDamage;
	}

	@Override
	public int getHarvestLevel()
	{
		return this.harvestLevel;
	}

	@Override
	public int getEnchantability()
	{
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial()
	{
		return Ingredient.fromItems(this.repairMaterial);
	}
}
