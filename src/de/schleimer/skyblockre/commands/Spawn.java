package de.schleimer.skyblockre.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player){
            Player p = (Player) commandSender;
            World w = Bukkit.getWorld("world");
            Location l = new Location(w,0.5,65,0.5);
            l.setYaw(0);
            l.setPitch(0);
            w.setSpawnLocation(l.getBlockX(),l.getBlockY(),l.getBlockZ());
            p.teleport(l);
        }
        return false;
    }
}
