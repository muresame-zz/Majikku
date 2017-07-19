package com.gmail.lynx7478.majikku.managers;

import java.util.ArrayList;

import com.gmail.lynx7478.majikku.CAD;

public class CADManager 
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


}
