package de.schleimer.skyblockre.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Build implements CommandExecutor {
    public static HashMap<Player,Boolean> builder = new HashMap<Player, Boolean>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //Bukkit.getConsoleSender().sendMessage("Build Command executed");
        if (sender.hasPermission("skyblock.builder")){
            if(args.length == 0){
                if (sender instanceof Player){
                Player player = (Player) sender;
                setbuilder(player);
                }
            }
            else if (args.length == 1){
                Player player = Bukkit.getPlayer(args[0]);
                if (player.isOnline()){
                    setbuilder(player);
                }
            }
        }
        return true;
    }


    private void setbuilder (Player player){
        if(builder.get(player)!= null){
            if(builder.get(player)== false ){
                builder.put(player,true);
            }
            else {
                builder.put(player,false);
            }
        }
        else {
            builder.put(player,true);
        }
    }
}
