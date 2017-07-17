package com.gmail.lynx7478.majikku;

public class Spell 
{
	
	private double castTime;
	private String name;
	private String codeName;
//	private CAD[] cads;
	
	public Spell(String name, String codeName, double castTime)
	{
		this.castTime = castTime;
		this.name = name;
		this.codeName = name;
	}
	
	/* public Spell(String name, String codeName, double castTime, CAD[] cads)
	{
		this.castTime = castTime;
		this.name = name;
		this.codeName = name;
		this.cads = cads;
	} */
	
	public void onCast(){}
	
	public void preCast(){}
	
	public void duringCast() {}
	
	public void spell() {}
	
	public void onEnd() {}
	
	public String getName()
	{
		return name;
	}
	
	public String getCodename()
	{
		return codeName;
	}
	
	public double getCastTime()
	{
		return castTime;
	}

}
