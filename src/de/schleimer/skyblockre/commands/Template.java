package de.schleimer.skyblockre.commands;

import de.schleimer.skyblockre.api.WorldAPI;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Template implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if (args.length ==1){
                if (args[0].equalsIgnoreCase("nether")){
                    /*
                    WorldAPI.createWorld("Template_"+ World.Environment.NETHER.toString(), World.Environment.NETHER);
                    p.teleport(Bukkit.getWorld("Template_"+ World.Environment.NETHER).getSpawnLocation());

                     */
                }else if (args[0].equalsIgnoreCase("normal")){
                    /*
                    WorldAPI.createWorld("Template_"+ World.Environment.NORMAL.toString(), World.Environment.NORMAL);
                    p.teleport(Bukkit.getWorld("Template_"+ World.Environment.NORMAL).getSpawnLocation());
                     */
                }
            }
        }
        return false;
    }
}
