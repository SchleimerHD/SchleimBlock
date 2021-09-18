package de.schleimer.skyblockre.objects;

import de.schleimer.skyblockre.Generator;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Islands {


    //Privat Fields
    private static final List<Islands> Inseln = new ArrayList<>();
    private final List<UUID> members = new ArrayList<>();

    private Player player;
    private World overworld;
    private World nether;
    private World the_end;
    private double balance;

    //Setter getter for Islands
            //Static
    public static Islands getIslandsbyPlayer(Player player){
        for (Islands l:Inseln){
            if (player == l.player ){
                return l;
            }
        }
        return null;
    }
    public static Islands getIslandsbyPlayer(String name){
        for (Islands l:Inseln){
            if (name == l.player.getName() ){
                return l;
            }
        }
        return null;
    }
    public static Islands getIslandsbyWorld(String name){
        for (Islands l:Inseln){
            if (name == l.getWorld(World.Environment.NORMAL).toString() ){
                return l;
            }
            else if (name == l.getWorld(World.Environment.NETHER).toString() ){
                return l;
            }
            if (name == l.getWorld(World.Environment.THE_END).toString() ){
                return l;
            }
        }
        return null;
    }
    public static Islands getIslandsbyWorld(World world){
        for (Islands l:Inseln){
            if (world == l.getWorld(world.getEnvironment()) ){
                return l;
            }
        }
        return null;
    }
            //Dynamic
    public World getWorld(World.Environment environment) {
        if (environment == World.Environment.NORMAL)
            return overworld;
        else if (environment == World.Environment.NETHER)
            return nether;
        return the_end;
    }



    //Constructors and Destructor
    public Islands(Player player){
        Inseln.add(this);
        this.player =  player;
        if (worldExist(World.Environment.NORMAL)){
            overworld = loadWorld(World.Environment.NORMAL);
        }
        else{
            overworld = creatworld(World.Environment.NORMAL);
            teleportto(player);
        }
    }
    private Islands(){
    }
    //Methods
    private World creatworld(World.Environment environment){
        Generator n = new Generator();
        WorldCreator creator = new WorldCreator(environment.toString()+"_" + player.getUniqueId()).generator(n).environment(environment);
        World world = Bukkit.createWorld(creator);
        world.setSpawnLocation(0,75,0);
        Location l = world.getSpawnLocation();
        l.setY(l.getY()-1);
        l.getBlock().setType(Material.BEDROCK);
        return world;
    }
    private World loadWorld(World.Environment environment){
        Generator n = new Generator();
        WorldCreator creator = new WorldCreator(environment.toString()+"_" + player.getUniqueId()).generator(n).environment(environment);
        return Bukkit.createWorld(creator);                                              //Creates the World

    }
    public void teleportto(Player player){
        player.teleport(overworld.getSpawnLocation());
    }
    private boolean worldExist(World.Environment environment){
        File WorldFile = new File(Bukkit.getWorldContainer(), environment.toString()+ "_"+ player.getUniqueId());
        return WorldFile.exists();
    }
    public boolean ismember(Player p){
        return p.equals(player) || members.contains(p);
    }

}
