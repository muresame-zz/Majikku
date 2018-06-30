package com.gmail.lynx7478.majikku.managers;

import java.util.ArrayList;

import com.gmail.lynx7478.majikku.CAD;
import com.gmail.lynx7478.majikku.main.Majikku;
import com.gmail.lynx7478.majikku.player.MajikkuPlayer;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CADManager implements Listener
{
	private ArrayList<CAD> cads;
	
	public CADManager()
	{
		cads = new ArrayList<CAD>();
		
		
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
		if(e.getItem().hasItemMeta())
		{
			for(CAD c : Majikku.getInstance().getCADManager().getCADs())
			{
				if(e.getItem().getItemMeta().getDisplayName().equals(c.getName()))
				{
					if(e.getAction() != null)
					{
						if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)
						{
							c.getAssignedSpells()[0].preCast(p);
						}
					}
				}
			}
		}
	}


}
