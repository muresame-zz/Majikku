package com.gmail.lynx7478.majikku.managers;

import java.util.ArrayList;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.lynx7478.majikku.CAD;
import com.gmail.lynx7478.majikku.Spell;
import com.gmail.lynx7478.majikku.main.Majikku;
import com.gmail.lynx7478.majikku.player.MajikkuPlayer;

public class SpellManager implements Listener
{
	
	private ArrayList<Spell> spells;
	
	public SpellManager(Majikku pl)
	{
		spells = new ArrayList<Spell>();
		pl.getServer().getPluginManager().registerEvents(this, pl);
	}
	
	public ArrayList<Spell> getSpells()
	{
		return spells;
	}
	
	public Spell getSpell(Class<? extends Spell> clazz)
	{
		for(Spell s : spells)
		{
			if(s.getClass() == clazz)
			{
				return s;
			}
		}
		return null;
	}
	
	public Spell getSpellByName(String str)
	{
		str = str.replaceAll(" ", "");
		for(final Spell s : spells)
		{
			if(s.getCodename().replaceAll(" ", "").equalsIgnoreCase(str))
			{
				return s;
			}
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e)
	{
		final MajikkuPlayer p = Majikku.getInstance().getPlayerManager().getMajikkuPlayer(e.getPlayer().getName());
		if(p.hasCADInHand())
		{
			CAD ca = null;
			ItemStack i = p.getPlayer().getPlayer().getItemInHand();
			for(CAD c : Majikku.getInstance().getCADManager().getCADs())
			{
				if(i.equals(c.getItem()))
				{
					ca = c;
					break;
				}
			}
			final CAD cad = ca;
			if(cad != null)
			{
				if(e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR)
				{
					cad.getAssignedSpells()[0].preCast(p, cad);
					Majikku.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(Majikku.getInstance(), new Runnable()
							{
						public void run()
						{
							cad.getAssignedSpells()[0].onCast(p, cad);
						}
							}, cad.getAssignedSpells()[0].getCastTime() * 20L);
				}else
				{
					cad.getAssignedSpells()[1].preCast(p, cad);
					Majikku.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(Majikku.getInstance(), new Runnable()
							{
						public void run()
						{
							cad.getAssignedSpells()[1].onCast(p, cad);
						}
							}, cad.getAssignedSpells()[1].getCastTime() * 20L);
				}
			}
		}
		return;
	}

}
