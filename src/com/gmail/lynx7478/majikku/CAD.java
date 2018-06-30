package com.gmail.lynx7478.majikku;

import org.bukkit.inventory.ItemStack;

public class CAD 
{
	
	private int levelRequired;
	private int cadLevel;
	private int baseLevel;
	private int maxLevel;
	private double basePower;
	private double powerPerLevel;
	private double maxPower;
	
	private String name;
	private String codeName;
	private ItemStack item;
	
	private Spell[] spells;
	
	public CAD(String name, String codeName, int levelRequired, int cadLevel, int baseLevel, int maxLevel, double basePower, double powerPerLevel,
			double maxPower, ItemStack item, Spell s1, Spell s2)
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
		
		this.spells = new Spell[] {s1, s2};
		
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

	public int getMaxLevel() { return maxLevel; }
	
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
	
	public Spell[] getAssignedSpells()
	{
		return spells;
	}
	
	public void setAssignedSpells(Spell s1, Spell s2)
	{
		spells =  new Spell[] {s1, s2};
	}

}
