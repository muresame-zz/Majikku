package com.gmail.lynx7478.majikku.managers;

import java.util.ArrayList;

import com.gmail.lynx7478.majikku.CAD;
import com.gmail.lynx7478.majikku.cads.SimpleCAD;
import com.gmail.lynx7478.majikku.main.Majikku;
import com.gmail.lynx7478.majikku.player.MajikkuPlayer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CADManager implements Listener
{
	private ArrayList<CAD> cads;
	
	public CADManager(Majikku p)
	{
		cads = new ArrayList<CAD>();
		p.getServer().getPluginManager().registerEvents(this, p);
		
		cads.add(new SimpleCAD());
	}
	
	public ArrayList<CAD> getCADs()
	{
		return cads;
	}
	
	public CAD getCAD(Class<? extends CAD> clazz)
	{
		for(CAD c : cads)
		{
			if(c.getClass() == clazz)
			{
				return c;
			}
		}
		return null;
	}
	
	public CAD getCADByName(String str)
	{
		str = str.replaceAll(" ", "");
		for(final CAD c : cads)
		{
			if(c.getCodename().replaceAll(" ", "").equalsIgnoreCase(str))
			{
				return c;
			}
		}
		return null;
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e)
	{
		MajikkuPlayer p = Majikku.getInstance().getPlayerManager().getMajikkuPlayer(e.getPlayer().getName());
		if(e.getItem()==null ||e.getItem().getType() == Material.AIR)
		{
			return;
		}
		System.out.println("Item not air or null.");
		if(e.getItem().hasItemMeta())
		{
			System.out.println("Has meta.");
			for(CAD c : Majikku.getInstance().getCADManager().getCADs())
			{
				System.out.println("Cycling CADs.");
				if(e.getItem().getItemMeta().getDisplayName().equals(c.getItem().getItemMeta().getDisplayName()))
				{
					System.out.println("Item contains its name.");
					if(e.getAction() != null)
					{
						if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)
						{
							e.setCancelled(true);
							System.out.println("Cast things.");
							c.getAssignedSpells()[0].preCast(p);
							c.getAssignedSpells()[0].onCast(p);
							c.getAssignedSpells()[0].onEnd(p);
							System.out.println("Done??");
						}else if(e.getAction() == Action.RIGHT_CLICK_AIR ||e.getAction() == Action.RIGHT_CLICK_BLOCK)
						{
							e.setCancelled(true);
							System.out.println("Cast things.");
							c.getAssignedSpells()[1].preCast(p);
							c.getAssignedSpells()[1].onCast(p);
							c.getAssignedSpells()[1].onEnd(p);
							System.out.println("Done??");
						}
					}
				}
			}
		}
	}


}
