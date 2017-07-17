package com.gmail.lynx7478.mahou;

import org.bukkit.inventory.ItemStack;

public class CAD 
{
	
	private int levelRequired;
	private int cadLevel;
	private int baseLevel;
	private double basePower;
	private double powerPerLevel;
	private double maxPower;
	
	private String name;
	private String codeName;
	private ItemStack item;
	
	public CAD(String name, String codeName, int levelRequired, int cadLevel, int baseLevel, double basePower, double powerPerLevel,
			double maxPower, ItemStack item)
	{
		this.levelRequired = levelRequired;
		this.cadLevel = cadLevel;
		this.baseLevel = baseLevel;
		this.basePower = basePower;
		this.powerPerLevel = powerPerLevel;
		this.maxPower = maxPower;
		
		this.name = name;
		this.codeName = codeName;
		this.item = item;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getCodename()
	{
		return codeName;
	}
	
	public ItemStack getItem()
	{
		return item;
	}
	
	public int getLevelRequired()
	{
		return levelRequired;
	}
	
	public int getCADLevel()
	{
		return cadLevel;
	}
	
	public int getBaseLevel()
	{
		return baseLevel;
	}
	
	public double getBasePower()
	{
		return basePower;
	}
	
	public double getPowerPerLevel()
	{
		return powerPerLevel;
	}
	
	public double getMaxPower()
	{
		return maxPower;
	}

}
