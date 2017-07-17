package com.gmail.lynx7478.mahou.main;

import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.lynx7478.mahou.CADManager;
import com.gmail.lynx7478.mahou.SpellManager;

public class Mahou extends JavaPlugin 
{
	
	private static Mahou instance;
	
	public static Mahou getInstance()
	{
		return instance;
	}
	
	private CADManager cadManager;
	private SpellManager spellManager;
	
	@Override
	public void onEnable()
	{
		instance = this;
		
		// Initialize the CAD manager.
		cadManager = new CADManager();
		
		// Initilize the Spell manager.
		spellManager = new SpellManager();
	}
	
	public CADManager getCADManager()
	{
		return cadManager;
	}
	
	public SpellManager getSpellManager()
	{
		return spellManager;
	}

}
