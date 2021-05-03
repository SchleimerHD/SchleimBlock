package de.schleimer.skyblockre.commands;

import de.schleimer.skyblockre.api.WorldAPI;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Island implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, Command cmd, String label, String[] args) {
        if (Sender instanceof Player){
            Player p = (Player) Sender;
            if(args.length==0){
                noArgs(p);
            }
            else  if(args.length==1){

            }
            else  if(args.length==2){
                if (args[0].equalsIgnoreCase("tp")){
                    Player t = Bukkit.getPlayer(args[1]);
                    String s = WorldAPI.worldNameFormat(t, World.Environment.NORMAL);
                    WorldAPI.worldExist(s);
                    p.teleport(Bukkit.getWorld(s).getSpawnLocation());
                }

            }
        }
        return false;
    }
    private void noArgs(Player p){
        String world = WorldAPI.worldNameFormat(p, World.Environment.NORMAL);
        if (WorldAPI.worldExist(world)) {
            WorldAPI.createWorld(p, World.Environment.NORMAL);
            WorldAPI.teleportToPlayerIsland(p, p);
        } else {
            WorldAPI.createWorld(p, World.Environment.NORMAL);
            WorldAPI.teleportToPlayerIsland(p,p);

        }
    }
}
