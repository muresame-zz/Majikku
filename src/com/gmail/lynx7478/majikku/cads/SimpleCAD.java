package com.gmail.lynx7478.majikku.cads;

import com.gmail.lynx7478.majikku.CAD;
import com.gmail.lynx7478.majikku.main.Majikku;
import com.gmail.lynx7478.majikku.spells.Ignite;
import com.gmail.lynx7478.majikku.utils.CADBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class SimpleCAD extends CAD {
    public SimpleCAD() {
        super("SimpleCAD", "SCAD", 0, 0, 0, 1, 1, 100, 100.0, new CADBuilder(Material.IRON_INGOT,
                ChatColor.AQUA+"Simple CAD", false).resultingItem(), Majikku.getInstance().getSpellManager().getSpell(Ignite.class), Majikku.getInstance().getSpellManager().getSpell(Ignite.class));
    }
}
