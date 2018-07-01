package com.gmail.lynx7478.majikku.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CADBuilder
{

    private Material mat;
    private String name;
    private boolean droppable;

    public CADBuilder(Material mat, String name, boolean droppable)
    {
        this.mat = mat;
        this.name = name;
        this.droppable = droppable;
    }

    public ItemStack resultingItem()
    {
        ItemStack i = new ItemStack(mat);
        ItemMeta m  = i.getItemMeta();
        m.setDisplayName(name);
        ArrayList<String> l = new ArrayList<String>();
        l.add(" ");
        l.add(ChatColor.AQUA + "CAD");
        if(!droppable)
        {
            l.add(" ");
            l.add(ChatColor.GOLD+"Soulbound");
        }
        m.setLore(l);
        i.setItemMeta(m);
        return i;
    }
}
