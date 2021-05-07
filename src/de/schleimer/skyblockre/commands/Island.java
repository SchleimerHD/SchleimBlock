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
        World w = Bukkit.getWorld(world);
        if (w == null){
            if (WorldAPI.worldExist(world)){
                w = WorldAPI.loadWorld(world, World.Environment.NORMAL);
            }
            else {
                w = WorldAPI.createWorld(world, World.Environment.NORMAL);
            }

        }
        p.teleport(w.getSpawnLocation());
    }
}
