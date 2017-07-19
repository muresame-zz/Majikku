package com.gmail.lynx7478.majikku.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.lynx7478.majikku.Spell;
import com.gmail.lynx7478.majikku.main.Majikku;

import net.md_5.bungee.api.ChatColor;

public class SpellsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command spells, String s, String[] args) 
	{
		if(spells.getName().equalsIgnoreCase("spells"))
		{
			if(!(sender instanceof Player))
			{
				return false;
			}
			Player p = (Player) sender;
			String spls = "";
			for(Spell sp : Majikku.getInstance().getSpellManager().getSpells())
			{
				spls = spls+sp.getName()+", ";
			}
			p.sendMessage(ChatColor.AQUA+"List of current spells: " +ChatColor.GREEN+spls);
			return true;
		}
		return false;
	}

}
