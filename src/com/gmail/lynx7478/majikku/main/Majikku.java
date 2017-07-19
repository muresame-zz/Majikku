package com.gmail.lynx7478.majikku.main;

import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.lynx7478.majikku.CADManager;
import com.gmail.lynx7478.majikku.mangers.PlayerManager;
import com.gmail.lynx7478.majikku.mangers.SpellManager;

public class Majikku extends JavaPlugin 
{
	
	private static Majikku instance;
	
	public static Majikku getInstance()
	{
		return instance;
	}
	
	private CADManager cadManager;
	private SpellManager spellManager;
	
	private PlayerManager playerManager;
	
	@Override
	public void onEnable()
	{
		instance = this;
		
		// Initialize the CAD manager.
		cadManager = new CADManager();
		
		// Initilize the Spell manager.
		spellManager = new SpellManager();
	}
	
	public void onDisable()
	{
		try {
			if(!playerManager.savePlayers())
			{
				this.getLogger().log(Level.SEVERE, "FAILED TO SAVE PLAYERS!!");
			}
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public CADManager getCADManager()
	{
		return cadManager;
	}
	
	public SpellManager getSpellManager()
	{
		return spellManager;
	}
	
	public PlayerManager getPlayerManager()
	{
		return playerManager;
	}

}
