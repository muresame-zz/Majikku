package com.gmail.lynx7478.majikku.managers;

import java.util.ArrayList;

import com.gmail.lynx7478.majikku.Spell;

public class SpellManager 
{
	
	private ArrayList<Spell> spells;
	
	public SpellManager()
	{
		spells = new ArrayList<Spell>();
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

}
