package com.gmail.lynx7478.majikku.main;

import java.io.IOException;
import java.util.logging.Level;

import com.gmail.lynx7478.majikku.commands.GiveCADCommand;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.lynx7478.majikku.commands.SpellsCommand;
import com.gmail.lynx7478.majikku.managers.*;

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

		// Initilize the Spell manager.
		spellManager = new SpellManager();

		// Initialize the CAD manager.
		cadManager = new CADManager(this);
		
		playerManager = new PlayerManager(this);
		
		// Commands.
		this.getCommand("spells").setExecutor(new SpellsCommand());
		this.getCommand("givecad").setExecutor(new GiveCADCommand());
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
