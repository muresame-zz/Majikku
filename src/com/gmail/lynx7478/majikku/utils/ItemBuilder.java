package com.gmail.lynx7478.majikku.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder 
{
	
	public static ItemStack buildItem(Material mat, String name, boolean droppable)
	{
		ItemStack i = new ItemStack(mat);
		ItemMeta m = i.getItemMeta();
		m.setDisplayName(name);
		if(!droppable)
		{
			List<String> listLore = new ArrayList<String>();
			listLore.add(ChatColor.GOLD + "Souldbound");
			m.setLore(listLore);
		}
		i.setItemMeta(m);
		
		return i;
	}
	
	public static ItemStack buildItem(Material mat, String name, String[] lore, boolean droppable)
	{
		ItemStack i = new ItemStack(mat);
		ItemMeta m = i.getItemMeta();
		m.setDisplayName(name);
		List<String> listLore = Arrays.asList(lore);
		if(!droppable)
		{
			listLore.add(" ");
			listLore.add(ChatColor.GOLD + "Souldbound");
		}
		m.setLore(listLore);
		i.setItemMeta(m);
		
		return i;
	}

}
