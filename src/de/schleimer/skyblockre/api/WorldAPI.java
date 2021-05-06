package de.schleimer.skyblockre.api;

import org.bukkit.*;
import org.bukkit.entity.Player;

import java.io.File;

public class WorldAPI {

    public static boolean worldExist( String s){
        File WorldFile = new File(Bukkit.getWorldContainer(), s);
        if (WorldFile.exists()) {
            Bukkit.getConsoleSender().sendMessage(s +" do exist");
            return true;
        } else {
            Bukkit.getConsoleSender().sendMessage(s +"does not exist ");
            return false;
        }
    }

    public static void createWorld(Player p, World.Environment environment){
        Generator n = new Generator();
        String w = worldNameFormat(p,environment);
        WorldCreator creator = new WorldCreator(w).generator(n).environment(environment);
        World world = Bukkit.createWorld(creator);
        world.setSpawnLocation(0,70,0);
        Location l = world.getSpawnLocation();
        l.setY(l.getY()-1);

        l.getBlock().setType(Material.BEDROCK);
        Bukkit.getConsoleSender().sendMessage("Block gesetzt");

    }

    public static void loadWorld(String s, World.Environment environment){
        Generator n = new Generator();                                                          //Creates the Generator
        WorldCreator creator = new WorldCreator(s).environment(environment).generator(n);       //Creat the WorldCreator
        Bukkit.createWorld(creator);                                              //Creates the World

    }

    public static String worldNameFormat (Player p, World.Environment environment){
        return environment.toString()+"_"+p.getUniqueId();
    }

    public static void teleportToPlayerIsland(Player send,Player playerIsland){
        if (worldExist(worldNameFormat(playerIsland, World.Environment.NORMAL))){
            send.teleport(Bukkit.getWorld(worldNameFormat(playerIsland, World.Environment.NORMAL)).getSpawnLocation());
        }
    }
}