package com.gmail.lynx7478.majikku.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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

    //TODO: Dropabble things.
    public ItemStack resultingItem()
    {
        ItemStack i = new ItemStack(mat);
        ItemMeta m  = i.getItemMeta();
        m.setDisplayName(name);
        i.setItemMeta(m);
        //TODO: Add soulbound.
        return i;
    }
}
