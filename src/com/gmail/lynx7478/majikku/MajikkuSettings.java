package com.gmail.lynx7478.majikku;

import com.gmail.lynx7478.majikku.main.Majikku;

public class MajikkuSettings 
{
	
	
	private int maximumCads;
	private double maxPower;
	private double basePower;
	
	
	public MajikkuSettings()
	{
		//TODO: Initiliaze the varibales.
		this.maximumCads = Majikku.getInstance().getConfig().getInt("MaximumCADs");
		this.maxPower = Majikku.getInstance().getConfig().getDouble("MaxPower");
		this.basePower = Majikku.getInstance().getConfig().getDouble("BasePower");
	}
	
	public int getMaximumCADs()
	{
		return maximumCads;
	}
	
	public double getMaxPower()
	{
		return maxPower;
	}
	
	public double getBasePower()
	{
		return basePower;
	}

}
