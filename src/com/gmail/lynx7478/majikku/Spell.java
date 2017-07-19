package com.gmail.lynx7478.majikku;

import com.gmail.lynx7478.majikku.player.MajikkuPlayer;

public abstract class Spell 
{
	
	private double cooldown;
	private long castTime;
	private String name;
	private String codeName;
	
	public Spell(String name, String codeName, long castTime, double cooldown)
	{
		this.castTime = castTime;
		this.name = name;
		this.codeName = name;
		this.cooldown = cooldown;
	}
	
	public abstract void onCast(MajikkuPlayer p, CAD cad);
	
	public abstract void preCast(MajikkuPlayer p, CAD cad);
	
	public abstract void duringCast(MajikkuPlayer p, CAD cad);
	
	public abstract void spell(MajikkuPlayer p, CAD cad);
	
	public abstract void onEnd(MajikkuPlayer p, CAD cad);
	
	public String getName()
	{
		return name;
	}
	
	public String getCodename()
	{
		return codeName;
	}
	
	public long getCastTime()
	{
		return castTime;
	}
	
	public double getCooldown()
	{
		return cooldown;
	}

}
