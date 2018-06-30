package com.gmail.lynx7478.majikku.commands;

import com.gmail.lynx7478.majikku.main.Majikku;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public class GiveCADCommand implements CommandExecutor {

    //TODO: Add permission.
    @Override
    public boolean onCommand(CommandSender sender, Command givecad, String s, String[] args) {
        if(!(sender instanceof Player))
        {
            sender.sendMessage("Console cannot execute this command.");
            return false;
        }
        Player p = (Player) sender;
        if(givecad.getName().equalsIgnoreCase("givecad"))
        {
            if(args[0] == null)
            {
                p.sendMessage(ChatColor.RED + "You must input the CAD you want to be given.");
                return false;
            }
            String cadS = args[0];
            p.getInventory().addItem(Majikku.getInstance().getCADManager().getCADByName(cadS).getItem());
            return true;
        }
        return false;
    }
}
