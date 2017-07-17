package com.gmail.lynx7478.mahou;

import java.util.ArrayList;

public class SpellManager 
{
	
	private static ArrayList<Spell> spells = new ArrayList<Spell>();
	
	public SpellManager()
	{
		
	}
	
	public static ArrayList<Spell> getSpells()
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

}
