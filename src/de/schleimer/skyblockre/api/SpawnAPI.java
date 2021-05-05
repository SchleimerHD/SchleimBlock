package de.schleimer.skyblockre.api;

import de.schleimer.skyblockre.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SpawnAPI {
    public static void teleportToSpawn(Player player){
        FileConfiguration config = Main.getPlugin().getConfig();
        World world = Bukkit.getWorld(config.getString("Spawn.World"));
        double X = config.getDouble("Spawn.X");
        double Y = config.getDouble("Spawn.Y");
        double Z = config.getDouble("Spawn.Z");
        float Yaw = (float) config.getDouble("Spawn.Yaw");
        float Pitch = (float) config.getDouble("Spawn.Pitch");
        Location location = new Location(world,X,Y,Z,Yaw,Pitch);
        player.teleport(location);
    }
    public  static void setSpawn(Player p){
        FileConfiguration config = Main.getPlugin().getConfig();
        config.set("Spawn.World",p.getWorld().getName());
        config.set("Spawn.X",p.getLocation().getX());
        config.set("Spawn.Y",p.getLocation().getY());
        config.set("Spawn.Z",p.getLocation().getZ());
        config.set("Spawn.Yaw",p.getLocation().getYaw());
        config.set("Spawn.Pitch",p.getLocation().getPitch());
        Main.getPlugin().saveConfig();
    }
}
