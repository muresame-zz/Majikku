package com.gmail.lynx7478.majikku.managers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.gmail.lynx7478.majikku.main.Majikku;
import com.gmail.lynx7478.majikku.player.MajikkuPlayer;

public class PlayerManager implements Listener 
{
	private File dir;
	private HashMap<String, MajikkuPlayer> players;
	
	public PlayerManager()
	{
		(dir = new File(Majikku.getInstance().getDataFolder().getAbsolutePath() + File.separator + "Players")).mkdirs();
		
		this.players = new HashMap<String, MajikkuPlayer>();
		//TODO: Load all the files.
		if(!loadPlayers())
		{
			Majikku.getInstance().getLogger().log(Level.SEVERE, "FAILED LOADING PLAYERS!!");
		}
	}
	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		if(!players.containsKey(e.getPlayer().getName()))
		{
			this.players.put(e.getPlayer().getName(), new MajikkuPlayer(e.getPlayer()));
			return;
		}
		
		
	}
	
	public boolean savePlayers() throws IOException
	{
		for(String s : players.keySet())
		{
			MajikkuPlayer p = players.get(s);
			File f = new File(dir, s+".yml");
			if(!f.exists())
			{
				f.createNewFile();
			}
			YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
			
			yml.set("Level", p.getLevel());
			yml.set("Power", p.getPower());
			yml.set("BasePower", p.getBasePower());
			//TODO: CADs.
			
		}
		return true;
	}
	
	@SuppressWarnings("deprecation")
	private boolean loadPlayers()
	{
		for(File fs : dir.listFiles())
		{
			YamlConfiguration yml = YamlConfiguration.loadConfiguration(fs);
			players.put(fs.getName().replaceAll(".yml", ""), new MajikkuPlayer(
					Bukkit.getOfflinePlayer(fs.getName().replaceAll(".yml", "")), 
					yml.getInt("Level"), 
					yml.getDouble("Power"), 
					yml.getDouble("BasePower"), 
					/* CADs */ null));
			//TODO: CADs.
		}
		return true;
	}

}
