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
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(s instanceof Player) {
            Player p = (Player)s;
            if(args.length==0){
                noArgs(p);
            }
            else  if(args.length==2){
                if (args[0].equalsIgnoreCase("tp")){
                    /*
                    String S = WorldAPI.worldNameFormat(t, World.Environment.NORMAL);
                    WorldAPI.worldExist(S);
                    p.teleport(Bukkit.getWorld(S).getSpawnLocation());

                     */
                }
            }
        }
        else{
            Bukkit.getConsoleSender().sendMessage("Nur Spieler können den Island befehl nutzen");
        }
        return false;
    }

    private void noArgs(Player p){
        String world = WorldAPI.worldNameFormat(p, World.Environment.NORMAL);
        if (WorldAPI.worldExist(world) && Bukkit.getWorld(world) != null) {
            WorldAPI.loadWorld(world, World.Environment.NORMAL);
        } else if (!WorldAPI.worldExist(world)){

            WorldAPI.createWorld(p, World.Environment.NORMAL);

        }
        WorldAPI.teleportToPlayerIsland(p,p);
    }
}
