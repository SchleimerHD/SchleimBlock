package de.schleimer.skyblockre.api;

import org.bukkit.*;
import org.bukkit.entity.Player;

import java.io.File;

public class WorldAPI {

    public static boolean worldExist( String s){
        File WorldFile = new File(Bukkit.getWorldContainer(), s);
        return WorldFile.exists();
    }

    public static World createWorld(String p, World.Environment environment){
        Generator n = new Generator();
        WorldCreator creator = new WorldCreator(p).generator(n).environment(environment);
        World world = Bukkit.createWorld(creator);
        world.setSpawnLocation(0,70,0);
        Location l = world.getSpawnLocation();
        l.setY(l.getY()-1);
        l.getBlock().setType(Material.BEDROCK);
        return world;

    }

    public static World loadWorld(String p, World.Environment environment){
        Generator n = new Generator();
        WorldCreator creator = new WorldCreator(p).generator(n).environment(environment);
        return Bukkit.createWorld(creator);                                              //Creates the World

    }

    public static String worldNameFormat (Player p, World.Environment environment){

        return environment.toString()+"_"+p.getUniqueId().toString();
    }
}