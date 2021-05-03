package de.schleimer.skyblockre.api;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;

import java.io.File;

public class WorldAPI {
    public static boolean worldExist( String s){
        File WorldFile = new File(Bukkit.getWorldContainer(), s);
        if (WorldFile.exists()) {
            return true;
        } else {
            return false;
        }

    }
    public static void createWorld(Player p, World.Environment environment){
        String w = worldNameFormat(p,environment);
        WorldCreator creator = new WorldCreator(w);
        Generator n = new Generator();
        creator.generator(n);
        Bukkit.createWorld(creator);
        World world = Bukkit.getWorld(w);
        world.setSpawnLocation(0,60,0);
        Location l = world.getSpawnLocation();
        l.setY(l.getY()-1);
        l.getBlock().setType(Material.COBBLESTONE);


    }
    public static String worldNameFormat (Player p, World.Environment environment){
        return environment.toString()+"_"+p.getUniqueId();

    }
    public static void teleportToPlayerIsland(Player send,String playerIsland){
        Player p =Bukkit.getPlayer(playerIsland);
        teleportToPlayerIsland(send , p);
    }
    public static void teleportToPlayerIsland(Player send,Player playerIsland){
        if (worldExist(worldNameFormat(playerIsland, World.Environment.NORMAL))){
            send.teleport(Bukkit.getWorld(worldNameFormat(playerIsland, World.Environment.NORMAL)).getSpawnLocation());
        }
    }
}
