package com.gmail.lynx7478.mahou;

import org.bukkit.plugin.java.JavaPlugin;

public class Mahou extends JavaPlugin 
{
	
	private static Mahou instance;
	
	public static Mahou getInstance()
	{
		return instance;
	}
	
	@Override
	public void onEnable()
	{
		instance = this;
		
		
	}

}
