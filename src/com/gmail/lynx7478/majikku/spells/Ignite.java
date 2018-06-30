package com.gmail.lynx7478.majikku.spells;

import com.gmail.lynx7478.majikku.CAD;
import com.gmail.lynx7478.majikku.Spell;
import com.gmail.lynx7478.majikku.player.MajikkuPlayer;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class Ignite extends Spell 
{

	public Ignite() 
	{
		super("Ignite", "ignite", 5, 1);
	}

	@Override
	public void onCast(MajikkuPlayer p) {
		this.spell(p);
		
	}

	@Override
	public void preCast(MajikkuPlayer p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void duringCast(MajikkuPlayer p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void spell(MajikkuPlayer p) {
		Location l = p.getPlayer().getPlayer().getLocation();
		int r = 1;
		for(int x = (r * -1); x <= r; x++)
		{
			for(int y = (r * -1); y <= r; y++)
			{
				for(int z = (r * -1); z <= r; z++)
				{
					Block b = l.getWorld().getBlockAt(l.getBlockX() + x, l.getBlockY() + y, l.getBlockZ() + z);

					if(b.getType() != Material.AIR)
						b.setType(Material.FIRE);
				}
			}
		}
	}

	@Override
	public void onEnd(MajikkuPlayer p) {
		// TODO Auto-generated method stub
		
	}
	
	
}
