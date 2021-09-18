package de.schleimer.skyblockre.objects;

import de.schleimer.skyblockre.Generator;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.io.File;

public class TempIsland {
        //Privat Fields
    private static final TempIsland ts = new TempIsland();
        protected World overworld;
        protected World nether;
        protected World the_end;
        public static TempIsland getTemplate(){
            return ts;
        }

        public World getWorld(World.Environment environment) {
            if (environment == World.Environment.NORMAL)
                return overworld;
            else if (environment == World.Environment.NETHER)
                return nether;
            return the_end;
        }
        private TempIsland(){
            if (worldExist(World.Environment.NORMAL)){
                loadWorld(World.Environment.NORMAL);
            }
            else {
                creatworld(World.Environment.NORMAL);
            }
        }

        //Methods
        private World creatworld(World.Environment environment){
            Generator n = new Generator();
            WorldCreator creator = new WorldCreator(environment.toString()+"_" + "Template").generator(n).environment(environment);
            World world = Bukkit.createWorld(creator);
            world.setSpawnLocation(0,75,0);
            Location l = world.getSpawnLocation();
            l.setY(l.getY()-1);
            l.getBlock().setType(Material.BEDROCK);
            return world;
        }
        private World loadWorld(World.Environment environment){
            Generator n = new Generator();
            WorldCreator creator = new WorldCreator(environment.toString()+"_" + "Template").generator(n).environment(environment);
            return Bukkit.createWorld(creator);                                              //Creates the World

        }
        public void teleportto(Player player){
            player.teleport(overworld.getSpawnLocation());
        }
        private boolean worldExist(World.Environment environment){
            File WorldFile = new File(Bukkit.getWorldContainer(), environment.toString()+ "_"+ "Template" );
            return WorldFile.exists();
        }

    }


